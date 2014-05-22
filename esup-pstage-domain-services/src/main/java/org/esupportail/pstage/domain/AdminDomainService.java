/**
 * ESUP-PStage - Copyright (c) 2006 ESUP-Portail consortium
 * http://sourcesup.cru.fr/projects/esup-pstage
 */
package org.esupportail.pstage.domain;

import java.io.Serializable;
import java.util.List;

import org.esupportail.pstagedata.domain.dto.AdminStructureDTO;
import org.esupportail.pstagedata.exceptions.AdminStructureAccountException;
import org.esupportail.pstagedata.exceptions.AdminStructureLoginEppnAlreadyUsedException;
import org.esupportail.pstagedata.exceptions.DataAddException;
import org.esupportail.pstagedata.exceptions.DataDeleteException;
import org.esupportail.pstagedata.exceptions.DataUpdateException;
import org.esupportail.pstagedata.exceptions.WebServiceDataBaseException;

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
	 * @throws DataAddException 
	 * @throws WebServiceDataBaseException 
	 * @throws AdminStructureLoginEppnAlreadyUsedException 
	 * @throws AdminStructureAccountException 
	 */
	public int addAdminStructure(AdminStructureDTO admin) throws DataAddException, WebServiceDataBaseException, AdminStructureLoginEppnAlreadyUsedException, AdminStructureAccountException;
	/**
	 * @param admin 
	 * @return boolean
	 * @throws DataUpdateException 
	 * @throws WebServiceDataBaseException 
	 * @throws AdminStructureLoginEppnAlreadyUsedException 
	 * @throws AdminStructureAccountException 
	 */
	public boolean updateAdminStructure(AdminStructureDTO admin) throws DataUpdateException, WebServiceDataBaseException, AdminStructureLoginEppnAlreadyUsedException, AdminStructureAccountException;
	/**
	 * @param admin 
	 * @return boolean
	 * @throws DataUpdateException 
	 * @throws WebServiceDataBaseException 
	 */
	public boolean updateAdminStructureDerniereConnexion(AdminStructureDTO admin) throws DataUpdateException, WebServiceDataBaseException;
	/**
	 * @param idAdminStructure 
	 * @return boolean
	 * @throws DataDeleteException 
	 * @throws WebServiceDataBaseException 
	 */
	public boolean deleteAdminStructure(int idAdminStructure) throws DataDeleteException, WebServiceDataBaseException;
}
