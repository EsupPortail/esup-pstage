package org.esupportail.pstage.dao.referentiel;

import gouv.education.apogee.commun.transverse.dto.geographie.CommuneDTO;

import java.io.Serializable;
import java.util.List;

/**
 * @author Matthieu Manginot : matthieu.manginot@univ-nancy2.fr
 *
 */
public interface GeographieRepositoryDao extends Serializable{
	/**
	 * @param departement
	 * @return la liste des communes françaises à partir du département
	 */
	public List<CommuneDTO> getCommuneFromDepartement(String departement);
}
