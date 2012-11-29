/**
 * ESUP-PStage - Copyright (c) 2006 ESUP-Portail consortium
 * http://sourcesup.cru.fr/projects/esup-pstage
 */
package org.esupportail.pstage.domain;

import java.io.Serializable;
import java.util.List;

import org.esupportail.pstagedata.remote.AdminStructureAccountException_Exception;
import org.esupportail.pstagedata.remote.AdminStructureDTO;
import org.esupportail.pstagedata.remote.AdminStructureLoginEppnAlreadyUsedException_Exception;
import org.esupportail.pstagedata.remote.DataAddException_Exception;
import org.esupportail.pstagedata.remote.DataDeleteException_Exception;
import org.esupportail.pstagedata.remote.DataUpdateException_Exception;
import org.esupportail.pstagedata.remote.WebServiceDataBaseException_Exception;

/**
 * The AdminDaoService service interface.
 */
public interface AdminDomainService extends Serializable {
	/* ****************************************************************************
	 * ADMIN STRUCTURE
	 *****************************************************************************/
	/**
	 * @return List<AdminStructureDTO>
	 */
	public List<AdminStructureDTO> getAdminsStructure();
	/**
	 * @param login 
	 * @return AdminStructureDTO
	 */
	public AdminStructureDTO getAdminStructureFromLogin(String login);
	/**
	 * @param eppn 
	 * @return AdminStructureDTO
	 */
	public AdminStructureDTO getAdminStructureFromEppn(String eppn);
	/**
	 * @param admin 
	 * @return int
	 * @throws DataAddException_Exception 
	 * @throws WebServiceDataBaseException_Exception 
	 * @throws AdminStructureLoginEppnAlreadyUsedException_Exception 
	 * @throws AdminStructureAccountException_Exception 
	 */
	public int addAdminStructure(AdminStructureDTO admin) throws DataAddException_Exception, WebServiceDataBaseException_Exception, AdminStructureLoginEppnAlreadyUsedException_Exception, AdminStructureAccountException_Exception;
	/**
	 * @param admin 
	 * @return boolean
	 * @throws DataUpdateException_Exception 
	 * @throws WebServiceDataBaseException_Exception 
	 * @throws AdminStructureLoginEppnAlreadyUsedException_Exception 
	 * @throws AdminStructureAccountException_Exception 
	 */
	public boolean updateAdminStructure(AdminStructureDTO admin) throws DataUpdateException_Exception, WebServiceDataBaseException_Exception, AdminStructureLoginEppnAlreadyUsedException_Exception, AdminStructureAccountException_Exception;
	/**
	 * @param admin 
	 * @return boolean
	 * @throws DataUpdateException_Exception 
	 * @throws WebServiceDataBaseException_Exception 
	 */
	public boolean updateAdminStructureDerniereConnexion(AdminStructureDTO admin) throws DataUpdateException_Exception, WebServiceDataBaseException_Exception;
	/**
	 * @param idAdminStructure 
	 * @return boolean
	 * @throws DataDeleteException_Exception 
	 * @throws WebServiceDataBaseException_Exception 
	 */
	public boolean deleteAdminStructure(int idAdminStructure) throws DataDeleteException_Exception, WebServiceDataBaseException_Exception;
}
