package org.esupportail.pstage.domain.referentiel;

import java.io.Serializable;
import java.util.Map;

import org.esupportail.pstage.domain.beans.EtabRef;
import org.esupportail.pstage.domain.beans.SignataireRef;


/**
 * @author dhouillo
 *
 */
public interface StudentComponentRepositoryDomain extends Serializable{

	 /**
	 * @param universityCode
	 * @return etablissementReference
	 */
	public EtabRef getEtabRef(String universityCode);
	/**
	 * @param universityCode
	 * @param Composante
	 * @return signataire de la composante
	 */
	public SignataireRef getSigCompoRef(String universityCode, String Composante);
	/**
	 * Retourne les codes etapes et leurs libelles
	 * @param universityCode
	 * @return a LinkedHashMap<String, String>, codes etapes et leurs libelles
	 */
	public Map<String, String> getEtapesRef(String universityCode);
	/**
	 * Retourne les codes/libelle des Ufrs parmi l'ensemble des composantes
	 * @param universityCode 
	 * @return Map<String,String>
	 */
	public Map<String,String> getComposantesPrincipalesRef(String universityCode,Map<String,String> lesComposantes);

}
