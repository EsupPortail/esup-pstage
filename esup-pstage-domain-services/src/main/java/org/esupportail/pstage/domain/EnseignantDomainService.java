/**
 * ESUP-Portail PStageData - Copyright (c) 2006 ESUP-Portail consortium
 * http://sourcesup.cru.fr/projects/esup-pstagedata
 */
package org.esupportail.pstage.domain;

import java.io.Serializable;
import java.util.List;

import org.esupportail.pstagedata.domain.dto.EnseignantDTO;
import org.esupportail.pstagedata.exceptions.DataAddException;
import org.esupportail.pstagedata.exceptions.DataDeleteException;
import org.esupportail.pstagedata.exceptions.DataUpdateException;
import org.esupportail.pstagedata.exceptions.WebServiceDataBaseException;

/**
 * Enseignant Domain service interface.
 */
/**
 * @author Danielle Martineau : danielle.martineau@univ-rennes1.fr
 *
 */
public interface EnseignantDomainService extends Serializable {
	
	/**
	 * @param codeUniversite 
	 * @return List<EnseignantDTO>
	 */
	public List<EnseignantDTO> getEnseignants(String codeUniversite);
	
	/**
	 * @param id
	 * @return EnseignantDTO
	 */
	public EnseignantDTO getEnseignantFromId(int id);
	
	/**
	 * @param uidEnseignant
	 * @param codeUniversite
	 * @return EnseignantDTO
	 */
	public EnseignantDTO getEnseignantFromUid(String uidEnseignant, String codeUniversite);
	
	/**
	 * @param uidEnseignant
	 * @param codeUniversite 
	 * @return int
	 */
	public int getNombreConventionByEnseignant(String uidEnseignant, String codeUniversite);
	
	/**
	 * @param enseignant
	 * @return int
	 * @throws DataAddException
	 * @throws WebServiceDataBaseException
	 */
	public int addEnseignant(EnseignantDTO enseignant) throws DataAddException, WebServiceDataBaseException;
	
	
	/**
	 * @param enseignant
	 * @return boolean
	 * @throws DataUpdateException
	 * @throws WebServiceDataBaseException
	 */
	public boolean updateEnseignant(EnseignantDTO enseignant) throws DataUpdateException, WebServiceDataBaseException;
	
	
	/**
	 * @param idEnseignant
	 * @return boolean
	 * @throws DataDeleteException
	 * @throws WebServiceDataBaseException
	 */
	public boolean deleteEnseignant(int idEnseignant) throws DataDeleteException, WebServiceDataBaseException;

}
