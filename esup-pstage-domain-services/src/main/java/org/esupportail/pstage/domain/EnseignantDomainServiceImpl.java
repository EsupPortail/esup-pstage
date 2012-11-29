/**
 * ESUP-Portail PStageData - Copyright (c) 2006 ESUP-Portail consortium
 * http://sourcesup.cru.fr/projects/esup-pstagedata
 */
package org.esupportail.pstage.domain;

import java.util.List;

import org.esupportail.pstagedata.remote.DataAddException_Exception;
import org.esupportail.pstagedata.remote.DataDeleteException_Exception;
import org.esupportail.pstagedata.remote.DataUpdateException_Exception;
import org.esupportail.pstagedata.remote.EnseignantDTO;
import org.esupportail.pstagedata.remote.RemoteServices;
import org.esupportail.pstagedata.remote.WebServiceDataBaseException_Exception;


/**
 * @author Danielle Martineau : danielle.martineau@univ-rennes1.fr
 *
 */

public class EnseignantDomainServiceImpl implements EnseignantDomainService {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Code universite
	 */
	String codeUniversite;
	
	/**
	 * RemoteServices
	 */
	public RemoteServices remoteServices;

	/**
	 * @return the RemoteServices
	 */
	public RemoteServices getRemoteServices() {
		return remoteServices;
	}

	/**
	 * @param RemoteServices the RemoteServices to set
	 */
	public void setRemoteServices(RemoteServices remoteServices) {
		this.remoteServices = remoteServices;
	}

	/**
	 * ListeDomainService
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
	 * @see org.esupportail.pstage.domain.EnseignantDomainService#getEnseignants(java.lang.String)
	 */
	public List<EnseignantDTO> getEnseignants(String codeUniversite) {
		return this.remoteServices.getEnseignantsFromCodUniv(codeUniversite);
	}

	/**
	 * @see org.esupportail.pstage.domain.EnseignantDomainService#getNombreConventionByEnseignant(java.lang.String, java.lang.String)
	 */
	public int getNombreConventionByEnseignant(String uidEnseignant, String codeUniversite){
		return this.remoteServices.getNombreConventionByEnseignantFromCodUniv(uidEnseignant, codeUniversite);
	}
	
	/**
	 * @see org.esupportail.pstage.domain.EnseignantDomainService#addEnseignant(org.esupportail.pstagedata.domain.dto.EnseignantDTO)
	 */
	public int addEnseignant(EnseignantDTO enseignant) throws DataAddException_Exception,
			WebServiceDataBaseException_Exception {
		return this.remoteServices.addEnseignant(enseignant);
	}


	/**
	 * @see org.esupportail.pstage.domain.EnseignantDomainService#deleteEnseignant(int)
	 */
	public boolean deleteEnseignant(int idEnseignant)
			throws DataDeleteException_Exception, WebServiceDataBaseException_Exception {

		return this.remoteServices.deleteEnseignant(idEnseignant);
	}


	/**
	 * @see org.esupportail.pstage.domain.EnseignantDomainService#getEnseignantFromId(int)
	 */
	public EnseignantDTO getEnseignantFromId(int id) {
		EnseignantDTO e = this.remoteServices.getEnseignantFromId(id);
		setObjectsForEnseignant(e);
		return e;
	}


	/**
	 * @see org.esupportail.pstage.domain.EnseignantDomainService#getEnseignantFromUid(java.lang.String, java.lang.String)
	 */
	public EnseignantDTO getEnseignantFromUid(String uidEnseignant,	String codeUniversite) {
		EnseignantDTO e = this.remoteServices.getEnseignantFromUid(uidEnseignant, codeUniversite);
		setObjectsForEnseignant(e);
		return e;
	}

	/**
	 * @see org.esupportail.pstage.domain.EnseignantDomainService#updateEnseignant(org.esupportail.pstagedata.domain.dto.EnseignantDTO)
	 */
	public boolean updateEnseignant(EnseignantDTO enseignant)
			throws DataUpdateException_Exception, WebServiceDataBaseException_Exception {
		return this.remoteServices.updateEnseignant(enseignant);
	}

	/**
	 * @param lc
	 */
	public void setObjectsForEnseignant(List<EnseignantDTO> le){
		if(le!=null){
			for(EnseignantDTO c : le){
				setObjectsForEnseignant(c);
			}
		}
	}
	
	/**
	 * @param c
	 */
	public void setObjectsForEnseignant(EnseignantDTO e){
		if(e!=null){
			if (e.getCodeAffectation() != null)
				e.setAffectation(this.nomenclatureDomainService.getAffectationFromCode(e.getCodeAffectation(), codeUniversite));
		}
	}

	/**
	 * @return the codeUniversite
	 */
	public String getCodeUniversite() {
		return codeUniversite;
	}

	/**
	 * @param codeUniversite the codeUniversite to set
	 */
	public void setCodeUniversite(String codeUniversite) {
		this.codeUniversite = codeUniversite;
	}
	
	

}
