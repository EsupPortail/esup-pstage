/**
 * ESUP-PStage - Copyright (c) 2006 ESUP-Portail consortium
 * http://sourcesup.cru.fr/projects/esup-pstage
 */
package org.esupportail.pstage.domain;

import java.util.List;

import org.esupportail.pstagedata.remote.AvenantDTO;
import org.esupportail.pstagedata.remote.DataAddException_Exception;
import org.esupportail.pstagedata.remote.DataDeleteException_Exception;
import org.esupportail.pstagedata.remote.DataUpdateException_Exception;
import org.esupportail.pstagedata.remote.RemoteServices;
import org.esupportail.pstagedata.remote.WebServiceDataBaseException_Exception;

/**
 * @author Matthieu Manginot : matthieu.manginot@univ-nancy2.fr
 *
 */
public class AvenantDomainServiceImpl implements AvenantDomainService{
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
	
	/**
	 * NomenclatureDomainService
	 */
	private NomenclatureDomainService nomenclatureDomainService;	

	/**
	 * @return the nomenclatureDomainService
	 */
	public NomenclatureDomainService getNomenclatureDomainService() {
		return nomenclatureDomainService;
	}

	/**
	 * @param nomenclatureDomainService the nomenclatureDomainService to set
	 */
	public void setNomenclatureDomainService(
			NomenclatureDomainService nomenclatureDomainService) {
		this.nomenclatureDomainService = nomenclatureDomainService;
	}
	/**
	 * StructureDomainService
	 */
	private StructureDomainService structureDomainService;	

	/**
	 * @return the structureDomainService
	 */
	public StructureDomainService getStructureDomainService() {
		return structureDomainService;
	}

	/**
	 * @param structureDomainService the structureDomainService to set
	 */
	public void setStructureDomainService(
			StructureDomainService structureDomainService) {
		this.structureDomainService = structureDomainService;
	}
	
	/* ****************************************************************************
	 * AVENANT
	 *****************************************************************************/	
	/**
	 * @see org.esupportail.pstagedata.domain.AvenantDomainService#getAvenant()
	 */
	public List<AvenantDTO> getAvenant(int idConvention) {
		List<AvenantDTO> l = this.remoteServices.getAvenant(idConvention);
		this.setObjectsForAvenant(l);
		return l;
	}
	
	/**
	 * @see org.esupportail.pstagedata.domain.AvenantDomainService#getNombreAvenant()
	 */
	public int getNombreAvenant(int idConvention) {
		return this.remoteServices.getNombreAvenant(idConvention);
	}
	
	/**
	 * @see org.esupportail.pstagedata.domain.AvenantDomainService#addAvenant(org.esupportail.pstagedata.domain.dto.AvenantDTO)
	 */
	public int addAvenant(AvenantDTO a) throws DataAddException_Exception,WebServiceDataBaseException_Exception {
		return this.remoteServices.addAvenant(a);
	}
	/**
	 * @see org.esupportail.pstagedata.domain.AvenantDomainService#updateAvenant(org.esupportail.pstagedata.domain.dto.AvenantDTO)
	 */
	public boolean updateAvenant(AvenantDTO a) throws DataUpdateException_Exception,WebServiceDataBaseException_Exception{
		return this.remoteServices.updateAvenant(a);
	}
	
	/**
	 * @see org.esupportail.pstagedata.domain.AvenantDomainService#deleteAvenant(int)
	 */
	public boolean deleteAvenant(int idAvenant) throws DataDeleteException_Exception,WebServiceDataBaseException_Exception{
		return this.remoteServices.deleteAvenant(idAvenant);
	}
	
	
	/**
	 * @param lc
	 */
	public void setObjectsForAvenant(List<AvenantDTO> la){
		if(la!=null){
			for(AvenantDTO a : la){
				setObjectsForAvenant(a);
			}
		}
	}
	
	/**
	 * @param c
	 */
	public void setObjectsForAvenant(AvenantDTO a){
		if(a!=null){
			if (a.getIdService() != null && a.getIdService() > 0)
				a.setService(structureDomainService.getServiceFromId(a.getIdService()));
			if (a.getIdContact() != null && a.getIdContact() > 0 )
				a.setContact(structureDomainService.getContactFromId(a.getIdContact()));
			if (a.getIdEnseignant() != null && a.getIdEnseignant() > 0 )
				a.setEnseignant(remoteServices.getEnseignantFromId(a.getIdEnseignant()));
			if (a.getIdUniteGratification()!= null && a.getIdUniteGratification() > 0 )
				a.setUniteGratification(nomenclatureDomainService.getUniteGratificationDTOFromId(a.getIdUniteGratification()));
		}
	}
}
