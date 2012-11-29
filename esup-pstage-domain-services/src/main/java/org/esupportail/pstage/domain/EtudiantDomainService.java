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
import org.esupportail.pstagedata.remote.EtudiantDTO;
import org.esupportail.pstagedata.remote.WebServiceDataBaseException_Exception;

/**
 * Etudiant Domain service interface.
 */
/**
 * @author Danielle Martineau : danielle.martineau@univ-rennes1.fr
 *
 */
public interface EtudiantDomainService extends Serializable {
	
	/**
	 * @return List<EtudiantDTO>
	 */
	public List<EtudiantDTO> getEtudiants();
	
	/**
	 * @param id
	 * @return EtudiantDTO
	 */
	public EtudiantDTO getEtudiantFromId(int id);
	
	/**
	 * @param etudiant
	 * @return int
	 * @throws DataAddException_Exception
	 * @throws WebServiceDataBaseException_Exception
	 */
	public int addEtudiant(EtudiantDTO etudiant) throws DataAddException_Exception, WebServiceDataBaseException_Exception;
	
	/**
	 * @param etudiant
	 * @return boolean
	 * @throws DataUpdateException_Exception
	 * @throws WebServiceDataBaseException_Exception
	 */
	public boolean updateEtudiant(EtudiantDTO etudiant) throws DataUpdateException_Exception, WebServiceDataBaseException_Exception;
	
	/**
	 * @param idEtudiant
	 * @return boolean
	 * @throws DataDeleteException_Exception
	 * @throws WebServiceDataBaseException_Exception
	 */
	public boolean deleteEtudiant(int idEtudiant) throws DataDeleteException_Exception, WebServiceDataBaseException_Exception;

}
