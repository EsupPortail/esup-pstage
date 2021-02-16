package org.esupportail.pstage.dao.referentiel;

import fr.wsclient.apogee.ReferentielMetier.ReferentielMetierServiceInterface;
import fr.wsclient.apogee.ReferentielMetier.ComposanteDTO3;
import fr.wsclient.apogee.ReferentielMetier.WebBaseException_Exception;

import java.util.LinkedHashMap;
import java.util.List;
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
	final transient Logger logger = Logger.getLogger(PersonalComponentRepositoryDaoWS.class);

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
						
			ReferentielMetierServiceInterface referentielMetierServiceInterface = WsUtils.initReferentielMetierService();
			// recuperer la liste des composantes
			List <ComposanteDTO3> composante = referentielMetierServiceInterface.recupererComposanteV2(null, null);
			
			if (composante != null) {

				if (logger.isDebugEnabled()) {
					logger.debug("PersonalComponentRepositoryDaoWS:: getComposantesRef. composante  = " + mapComp.size());
				}
				
				recupComposantes(composante);

			}
			
			return mapComp;
			
		} catch (WebBaseException_Exception e) {
			logger.error("WebBaseException getComposantesRef = " + e );
			throw new CommunicationApogeeException(e);
		
		} catch (Exception e) {
			throw new CommunicationApogeeException(e);
		}
	}

	public void recupComposantes(List <ComposanteDTO3> composante){
		for (int i = 0; i < composante.size(); i++) {
			Object idl = composante.get(i).getCodCmp();
			String lib = composante.get(i).getLibCmp();
			if (composante.get(i).getTemEnSveCmp().equals("O")) {
				mapComp.put(idl + "", lib);
			}
			// Si la composante en cours de recuperation contient une liste de composantes filles
			// On la parcours egalement
			if (composante.get(i).getListeComposanteFils() != null && composante.get(i).getListeComposanteFils().getComposante().size() > 0){
				recupComposantes(composante.get(i).getListeComposanteFils().getComposante());
			}
		}
	}
}
