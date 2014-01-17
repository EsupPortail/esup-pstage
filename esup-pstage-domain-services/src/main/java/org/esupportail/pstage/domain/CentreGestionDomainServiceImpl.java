/**
 * ESUP-PStage - Copyright (c) 2006 ESUP-Portail consortium
 * http://sourcesup.cru.fr/projects/esup-pstage
 */
package org.esupportail.pstage.domain;

import java.util.List;

import org.esupportail.pstagedata.domain.dto.CentreGestionDTO;
import org.esupportail.pstagedata.domain.dto.CentreGestionSuperviseurDTO;
import org.esupportail.pstagedata.exceptions.CentreEntrepriseDejaExistantException;
import org.esupportail.pstagedata.exceptions.CentreEtablissementDejaExistantException;
import org.esupportail.pstagedata.exceptions.CentreReferenceException;
import org.esupportail.pstagedata.exceptions.DataAddException;
import org.esupportail.pstagedata.exceptions.DataDeleteException;
import org.esupportail.pstagedata.exceptions.DataUpdateException;
import org.esupportail.pstagedata.exceptions.WebServiceDataBaseException;
import org.esupportail.pstagedata.remote.RemoteServices;

/**
 * @author Matthieu Manginot : matthieu.manginot@univ-nancy2.fr
 *
 */
public class CentreGestionDomainServiceImpl implements CentreGestionDomainService{
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

	/* ****************************************************************************
	 * CENTRE DE GESTION
	 *****************************************************************************/	
	/**
	 * @see org.esupportail.pstage.domain.CentreGestionDomainService#getCentreEntreprise()
	 */
	public CentreGestionDTO getCentreEntreprise(){
		CentreGestionDTO c = this.remoteServices.getCentreEntreprise();
		setObjectsForCentreGestion(c);
		return c;
	}
	
	/**
	 * @see org.esupportail.pstage.domain.CentreGestionDomainService#getCentreEtablissement(java.lang.String)
	 */
	public CentreGestionDTO getCentreEtablissement(String codeUniversite){
		CentreGestionDTO c = this.remoteServices.getCentreEtablissement(codeUniversite);
		setObjectsForCentreGestion(c);
		return c;
	}
	
	/**
	 * @see org.esupportail.pstage.domain.CentreGestionDomainService#getCentresEtablissement(java.lang.String)
	 */
	public List<CentreGestionDTO> getCentresEtablissement(String codeUniversite){
		return this.remoteServices.getCentresEtablissementFromCodUniv(codeUniversite);
	}
	
	/**
	 * @see org.esupportail.pstage.domain.CentreGestionDomainService#getCentreGestionList(java.lang.String)
	 */
	public List<CentreGestionDTO> getCentreGestionList(String codeUniversite){
		List<CentreGestionDTO> c = this.remoteServices.getCentreGestionList(codeUniversite);
		setObjectsForCentreGestion(c);
		return c;
	}
	/**
	 * @see org.esupportail.pstage.domain.CentreGestionDomainService#getCentreGestion(int)
	 */
	public CentreGestionDTO getCentreGestion(int idCentreGestion){
		CentreGestionDTO c = this.remoteServices.getCentreGestion(idCentreGestion);
		setObjectsForCentreGestion(c);
		return c;
	}
	/**
	 * @see org.esupportail.pstage.domain.CentreGestionDomainService#getCentreGestionFromNomCentre(java.lang.String, java.lang.String)
	 */
	public CentreGestionDTO getCentreGestionFromNomCentre(String nomCentre, String codeUniversite){
		CentreGestionDTO c = this.remoteServices.getCentreGestionFromNomCentre(nomCentre, codeUniversite);
		setObjectsForCentreGestion(c);
		return c;
	}
	/**
	 * @see org.esupportail.pstage.domain.CentreGestionDomainService#getNombreCentreGestion(String)
	 */
	public int getNombreCentreGestion(String codeUniversite){
		return this.remoteServices.getNombreCentreGestion(codeUniversite);
	}
	/**
	 * @see org.esupportail.pstage.domain.CentreGestionDomainService#getCentreDroitEcriture(java.lang.String, java.lang.String)
	 */
	public List<CentreGestionDTO> getCentreDroitEcriture(String uidPersonnel, String codeUniversite){
		List<CentreGestionDTO> c = this.remoteServices.getCentreDroitEcritureFromCodUniv(uidPersonnel, codeUniversite);
		setObjectsForCentreGestion(c);
		return c;
	}
	/**
	 * @see org.esupportail.pstage.domain.CentreGestionDomainService#getCentreFromUid(java.lang.String, java.lang.String)
	 */
	public List<CentreGestionDTO> getCentreFromUid(String uidPersonnel,String codeUniversite){
		List<CentreGestionDTO> c = this.remoteServices.getCentreFromUidFromCodUniv(uidPersonnel, codeUniversite);
		setObjectsForCentreGestion(c);
		return c;
	}
	

	/**
	 * @see org.esupportail.pstage.domain.CentreGestionDomainService#getCentreFromCritere(java.lang.String, java.lang.String)
	 */
	public CentreGestionDTO getCentreFromCritere(String codeCritere,
			String codeUniversite) {
		CentreGestionDTO c = this.remoteServices.getCentreFromCritere(codeCritere, codeUniversite);
		setObjectsForCentreGestion(c);
		return c;
	}
	
	/**
	 * @see org.esupportail.pstage.domain.CentreGestionDomainService#addCentreGestion(org.esupportail.pstagedata.domain.dto.CentreGestionDTO)
	 */
	public int addCentreGestion(CentreGestionDTO cg) throws DataAddException,WebServiceDataBaseException,CentreEtablissementDejaExistantException,CentreEntrepriseDejaExistantException{
		return this.remoteServices.addCentreGestion(cg);
	}

	/**
	 * @see org.esupportail.pstage.domain.CentreGestionDomainService#updateCentreGestion(org.esupportail.pstagedata.domain.dto.CentreGestionDTO)
	 */
	public boolean updateCentreGestion(CentreGestionDTO cg) throws DataUpdateException,WebServiceDataBaseException,CentreEtablissementDejaExistantException,CentreEntrepriseDejaExistantException{
		return this.remoteServices.updateCentreGestion(cg);
	}
	
	/**
	 * @see org.esupportail.pstage.domain.CentreGestionDomainService#deleteCentreGestion(int)
	 */
	public boolean deleteCentreGestion(int idCentreGestion) throws DataDeleteException,WebServiceDataBaseException,CentreReferenceException{
		return this.remoteServices.deleteCentreGestion(idCentreGestion);
	}
	
	/**
	 * @see org.esupportail.pstage.domain.CentreGestionDomainService#getCentreGestionSuperviseur()
	 */
	public List<CentreGestionSuperviseurDTO> getCentreGestionSuperviseur(){
		return this.remoteServices.getCentreGestionSuperviseur();
	}
	/**
	 * @see org.esupportail.pstage.domain.CentreGestionDomainService#addCentreGestionSuperviseur(org.esupportail.pstagedata.domain.dto.CentreGestionSuperviseurDTO)
	 */
	public int addCentreGestionSuperviseur(CentreGestionSuperviseurDTO cg) throws DataAddException,WebServiceDataBaseException{
		return this.remoteServices.addCentreGestionSuperviseur(cg);
	}
	
	/**
	 * @see org.esupportail.pstage.domain.CentreGestionDomainService#updateIdFichier(int, int)
	 */
	public boolean updateIdFichier(int idCentreGestion, int idFichier) throws DataUpdateException,WebServiceDataBaseException{
		return this.remoteServices.updateIdFichier(idCentreGestion, idFichier);
	}
	
	/**
	 * @see org.esupportail.pstage.domain.CentreGestionDomainService#setIdFichierNull(int)
	 */
	public boolean setIdFichierNull(int idCentreGestion) throws DataUpdateException,WebServiceDataBaseException{
		return this.remoteServices.setIdFichierNull(idCentreGestion);
	}
	
	/**
	 * @param lc
	 */
	public void setObjectsForCentreGestion(List<CentreGestionDTO> lc){
		if(lc!=null){
			for(CentreGestionDTO c : lc){
				setObjectsForCentreGestion(c);
			}
		}
	}
	
	/**
	 * @param c
	 */
	public void setObjectsForCentreGestion(CentreGestionDTO c){
		if(c!=null){
			if (c.getCodeConfidentialite() != null)
				c.setConfidentialite(nomenclatureDomainService.getConfidentialiteFromCode(c.getCodeConfidentialite()));
			if (c.getIdNiveauCentre() > 0)
				c.setNiveauCentre(nomenclatureDomainService.getNiveauCentreFromId(c.getIdNiveauCentre()));
			if (c.getIdFichier() > 0)
				c.setFichier(remoteServices.getFichierFromIdFichier(c.getIdFichier()));
			if (c.getIdModeValidationStage() > 0)
				c.setModeValidationStage(nomenclatureDomainService.getModeValidationStageDTOFromId(c.getIdModeValidationStage()));
		}
	}


}
