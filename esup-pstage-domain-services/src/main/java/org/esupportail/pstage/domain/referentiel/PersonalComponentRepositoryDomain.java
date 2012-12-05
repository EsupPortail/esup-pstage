package org.esupportail.pstage.domain.referentiel;

import java.io.Serializable;
import java.util.Map;


/**
 * Acces au composantes du personnel.
 *
 */
public interface PersonalComponentRepositoryDomain extends Serializable{
	/**
	 * Retourne les codes de toutes les composantes (UFR et departements) de l'universite et leurs libelles
	 * @param universityCode
	 * @return a Map<String,String>, codes et libelles des composantes
	 */
	public Map<String, String> getComposantesRef(String universityCode); 

}
