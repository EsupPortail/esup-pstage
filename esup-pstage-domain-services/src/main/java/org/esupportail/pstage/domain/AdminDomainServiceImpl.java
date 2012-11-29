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
import org.esupportail.pstagedata.remote.RemoteServices;
import org.esupportail.pstagedata.remote.WebServiceDataBaseException_Exception;

/**
 * The AdminDomainService service impl.
 */
public class AdminDomainServiceImpl implements Serializable, AdminDomainService{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * RemoteServices
	 */
	private RemoteServices remoteServices;
	
	/**
	 * @return the remoteServices
	 */
	public RemoteServices getRemoteServices() {
		return remoteServices;
	}

	/**
	 * @param remoteServices the remoteServices to set
	 */
	public void setRemoteServices(RemoteServices remoteServices) {
		this.remoteServices = remoteServices;
	}
	/* ****************************************************************************
	 * ADMIN STRUCTURE
	 *****************************************************************************/
	
	/**
	 * @see org.esupportail.pstage.domain.AdminDomainService#getAdminsStructure()
	 */
	public List<AdminStructureDTO> getAdminsStructure(){
		return this.remoteServices.getAdminsStructure();
	}
		
	/**
	 * @see org.esupportail.pstage.domain.AdminDomainService#getAdminStructureFromLogin(java.lang.String)
	 */
	public AdminStructureDTO getAdminStructureFromLogin(String login){
		return this.remoteServices.getAdminStructureFromLogin(login);
	}
	
	/**
	 * @see org.esupportail.pstage.domain.AdminDomainService#getAdminStructureFromEppn(java.lang.String)
	 */
	public AdminStructureDTO getAdminStructureFromEppn(String eppn){
		return this.remoteServices.getAdminStructureFromEppn(eppn);
	}
	
	/**
	 * @see org.esupportail.pstage.domain.AdminDomainService#addAdminStructure(org.esupportail.pstagedata.domain.dto.AdminStructureDTO)
	 */
	public int addAdminStructure(AdminStructureDTO admin) throws DataAddException_Exception, WebServiceDataBaseException_Exception, AdminStructureLoginEppnAlreadyUsedException_Exception, AdminStructureAccountException_Exception{
		return this.remoteServices.addAdminStructure(admin);
	}
	
	/**
	 * @see org.esupportail.pstage.domain.AdminDomainService#updateAdminStructure(org.esupportail.pstagedata.domain.dto.AdminStructureDTO)
	 */
	public boolean updateAdminStructure(AdminStructureDTO admin) throws DataUpdateException_Exception, WebServiceDataBaseException_Exception, AdminStructureLoginEppnAlreadyUsedException_Exception, AdminStructureAccountException_Exception{
		return this.remoteServices.updateAdminStructure(admin);
	}
	
	/**
	 * @see org.esupportail.pstage.domain.AdminDomainService#updateAdminStructureDerniereConnexion(org.esupportail.pstagedata.domain.dto.AdminStructureDTO)
	 */
	public boolean updateAdminStructureDerniereConnexion(AdminStructureDTO admin) throws DataUpdateException_Exception, WebServiceDataBaseException_Exception{
		return this.remoteServices.updateAdminStructureDerniereConnexion(admin);
	}
	
	/**
	 * @see org.esupportail.pstage.domain.AdminDomainService#deleteAdminStructure(int)
	 */
	public boolean deleteAdminStructure(int idAdminStructure) throws DataDeleteException_Exception, WebServiceDataBaseException_Exception{
		return this.remoteServices.deleteAdminStructure(idAdminStructure);	
	}
}
