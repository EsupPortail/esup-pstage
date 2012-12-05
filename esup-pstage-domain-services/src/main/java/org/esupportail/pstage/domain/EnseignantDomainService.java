/**
 * ESUP-Portail PStageData - Copyright (c) 2006 ESUP-Portail consortium
 * http://sourcesup.cru.fr/projects/esup-pstagedata
 */
package org.esupportail.pstage.domain;

import java.io.Serializable;
import java.util.List;

import org.esupportail.pstagedata.remote.DataAddException_Exception;
import org.esupportail.pstagedata.remote.DataDeleteException_Exception;
import org.esupportail.pstagedata.remote.DataUpdateException_Exception;
import org.esupportail.pstagedata.remote.EnseignantDTO;
import org.esupportail.pstagedata.remote.WebServiceDataBaseException_Exception;

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
	 * @throws DataAddException_Exception
	 * @throws WebServiceDataBaseException_Exception
	 */
	public int addEnseignant(EnseignantDTO enseignant) throws DataAddException_Exception, WebServiceDataBaseException_Exception;
	
	
	/**
	 * @param enseignant
	 * @return boolean
	 * @throws DataUpdateException_Exception
	 * @throws WebServiceDataBaseException_Exception
	 */
	public boolean updateEnseignant(EnseignantDTO enseignant) throws DataUpdateException_Exception, WebServiceDataBaseException_Exception;
	
	
	/**
	 * @param idEnseignant
	 * @return boolean
	 * @throws DataDeleteException_Exception
	 * @throws WebServiceDataBaseException_Exception
	 */
	public boolean deleteEnseignant(int idEnseignant) throws DataDeleteException_Exception, WebServiceDataBaseException_Exception;

}
