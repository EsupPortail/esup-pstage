package org.esupportail.pstage.domain.referentiel;

import java.io.Serializable;
import java.util.List;

/**
 * @author Matthieu Manginot : matthieu.manginot@univ-nancy2.fr
 *
 */
public interface GeographieRepositoryDomain extends Serializable{
	/**
	 * @param departement
	 * @return la liste des communes franï¿½aises ï¿½ partir du dï¿½partement
	 */
	public List<CommuneDTO> getCommuneFromDepartement(String departement);
	/**
	 * @param departement
	 * @param codeCommune
	 * @return la commune pour le couple departement/codeCommune
	 */
	public CommuneDTO getCommuneFromDepartementEtCodeCommune(String departement, String codeCommune);
}
