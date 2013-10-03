package org.esupportail.pstage.dao.referentiel;

import gouv.education.apogee.commun.client.utils.WSUtils;
import gouv.education.apogee.commun.client.ws.referentielmetier.ReferentielMetierServiceInterface;
import gouv.education.apogee.commun.client.ws.referentielmetier.ReferentielMetierSoapBindingStub;
import gouv.education.apogee.commun.transverse.dto.pedagogique.ComposanteDTO3;
import gouv.education.apogee.commun.transverse.exception.WebBaseException;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.log4j.Logger;
import org.esupportail.pstage.exceptions.CommunicationApogeeException;

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
	
	/**
	 * @see org.esupportail.pstage.dao.referentiel.PersonalComponentRepositoryDao#getComposantesRef(java.lang.String)
	 */
	public Map<String, String> getComposantesRef(String universityCode) {
		
		if (logger.isDebugEnabled()) {
			logger.debug("PersonalComponentRepositoryDaoWS:: getComposantesRef. universityCode  = "+universityCode);
		}
		
		mapComp = new LinkedHashMap<String,String>();

		try {
			ReferentielMetierServiceInterface referentielMetierService = 
				(ReferentielMetierSoapBindingStub) WSUtils.getService(WSUtils.REFERENTIEL_SERVICE_NAME);
			
			// recuperer la liste des composantes
			ComposanteDTO3[] composante = referentielMetierService.recupererComposante_v2(null, null);
			
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

	public void recupComposantes(ComposanteDTO3[] composante){
		for (int i = 0; i < composante.length; i++) {
			Object idl = composante[i].getCodCmp();
			String lib = composante[i].getLibCmp();
			if (composante[i].getTemEnSveCmp().equals("O")) {
				mapComp.put(idl + "", lib);
			}
			// Si la composante en cours de recuperation contient une liste de composantes filles
			// On la parcours egalement
			if (composante[i].getListeComposanteFils() != null && composante[i].getListeComposanteFils().length > 0){
				recupComposantes(composante[i].getListeComposanteFils());
			}
		}
	}
}
