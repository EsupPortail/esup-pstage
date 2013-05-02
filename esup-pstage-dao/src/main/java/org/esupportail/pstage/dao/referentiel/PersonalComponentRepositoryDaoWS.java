package org.esupportail.pstage.dao.referentiel;

import gouv.education.apogee.commun.transverse.dto.pedagogique.composantedto3.ComposanteDTO3;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.esupportail.pstage.exceptions.CommunicationApogeeException;
import org.springframework.util.Assert;

import referentielmetier_18062010_impl.servicesmetiers.commun.apogee.education.gouv.ReferentielMetierServiceInterface;
import referentielmetier_18062010_impl.servicesmetiers.commun.apogee.education.gouv.WebBaseException;

/**
 * 
 * Acces au composantes du personnel personnalise.
 *
 */

@SuppressWarnings("serial")
public class PersonalComponentRepositoryDaoWS implements
PersonalComponentRepositoryDao {

	/**
	 * 
	 */
	final Logger logger = Logger.getLogger(PersonalComponentRepositoryDaoWS.class);

	LinkedHashMap<String,String> mapComp = new LinkedHashMap<String,String>();

	private ReferentielMetierServiceInterface referentielMetierService;

	/**
	 * @see org.esupportail.pstage.dao.referentiel.PersonalComponentRepositoryDao#getComposantesRef(java.lang.String)
	 */
	public Map<String, String> getComposantesRef(String universityCode) {

		if (logger.isDebugEnabled()) {
			logger.debug("PersonalComponentRepositoryDaoWS:: getComposantesRef. universityCode  = "+universityCode);
		}

		mapComp = new LinkedHashMap<String,String>();

		try {

			// recuperer la liste des composantes
			List<ComposanteDTO3>composante = referentielMetierService.recupererComposanteV2(null, null);

			if (composante != null) {

				if (logger.isDebugEnabled()) {
					logger.debug("PersonalComponentRepositoryDaoWS:: getComposantesRef. composante  = " + mapComp.size());
				}

				recupComposantes(composante);

			}

			return mapComp;

		} catch (WebBaseException e) {
			logger.error("WebBaseException getComposantesRef = " + e );
			throw new CommunicationApogeeException(e);

		} catch (Exception e) {
			throw new CommunicationApogeeException(e);
		}
	}

	public void recupComposantes(List<ComposanteDTO3> composante){
		for (int i = 0; i < composante.size(); i++) {
			Object idl = composante.get(i).getCodCmp();
			String lib = composante.get(i).getLibCmp();
			if (composante.get(i).getTemEnSveCmp().equals("O")) {
				mapComp.put(idl + "", lib);
			}
			// Si la composante en cours de recuperation contient une liste de composantes filles
			// On la parcours egalement
			if (composante.get(i).getListeComposanteFils() != null && composante.get(i).getListeComposanteFils().getItem().size()> 0){
				recupComposantes(composante.get(i).getListeComposanteFils().getItem());
			}
		}
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		Assert.notNull(referentielMetierService,"La propriété referentielMetierService ne peut etre null.");
	}

	/**
	 * @return the referentielMetierService
	 */
	public ReferentielMetierServiceInterface getReferentielMetierService() {
		return referentielMetierService;
	}

	/**
	 * @param referentielMetierService the referentielMetierService to set
	 */
	public void setReferentielMetierService(
			ReferentielMetierServiceInterface referentielMetierService) {
		this.referentielMetierService = referentielMetierService;
	}

}
