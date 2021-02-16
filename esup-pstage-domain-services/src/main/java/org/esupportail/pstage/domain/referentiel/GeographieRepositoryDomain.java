package org.esupportail.pstage.domain.referentiel;

import fr.wsclient.apogee.GeographieMetier.CommuneDTO;

import java.io.Serializable;
import java.util.List;

/**
 * @author Matthieu Manginot : matthieu.manginot@univ-nancy2.fr
 *
 */
public interface GeographieRepositoryDomain extends Serializable{
	/**
	 * @param departement
	 * @return la liste des communes francaises a partir du departement
	 */
	public List<CommuneDTO> getCommuneFromDepartement(String departement);
	/**
	 * @param departement
	 * @param codeCommune
	 * @return la commune pour le couple departement/codeCommune
	 */
	public CommuneDTO getCommuneFromDepartementEtCodeCommune(String departement, String codeCommune);
}
