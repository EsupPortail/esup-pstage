/**
 * ESUP-PStage - Copyright (c) 2006 ESUP-Portail consortium
 * http://sourcesup.cru.fr/projects/esup-pstage
 */
package org.esupportail.pstage.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.esupportail.pstagedata.remote.ContactDTO;
import org.esupportail.pstagedata.remote.CritereRechercheOffreDTO;
import org.esupportail.pstagedata.remote.DataAddException_Exception;
import org.esupportail.pstagedata.remote.DataDeleteException_Exception;
import org.esupportail.pstagedata.remote.DataUpdateException_Exception;
import org.esupportail.pstagedata.remote.DureeDiffusionDTO;
import org.esupportail.pstagedata.remote.FichierDTO;
import org.esupportail.pstagedata.remote.ModeCandidatureDTO;
import org.esupportail.pstagedata.remote.OffreDTO;
import org.esupportail.pstagedata.remote.OffreDiffusionDTO;
import org.esupportail.pstagedata.remote.RemoteServices;
import org.esupportail.pstagedata.remote.WebServiceDataBaseException_Exception;
import org.springframework.util.StringUtils;

/**
 * The OffreDomainService service impl.
 */
/**
 * @author Matthieu Manginot : matthieu.manginot@univ-nancy2.fr
 *
 */
public class OffreDomainServiceImpl implements Serializable, OffreDomainService{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * RemoteServices
	 */
	private RemoteServices remoteServices;
	/**
	 * NomenclatureDomainService
	 */
	private NomenclatureDomainService nomenclatureDomainService;
	
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
	 * OFFRE
	 *****************************************************************************/

	/**
	 * @see org.esupportail.pstage.domain.OffreDomainService#getAnneesUnivOffres()
	 */
	public List<String> getAnneesUnivOffres() {
		return this.remoteServices.getAnneesUnivOffres();
	}

	/**
	 * @see org.esupportail.pstage.domain.OffreDomainService#getNombreOffreByCentreGestion(int)
	 */
	public int getNombreOffreByCentreGestion(int idCentreGestion){
		return this.remoteServices.getNombreOffreByCentreGestion(idCentreGestion);
	}
	
	/**
	 * @see org.esupportail.pstage.domain.OffreDomainService#getOffresFromIdStructureAndIdsCentreGestion(int, java.util.List, boolean)
	 */
	public List<OffreDTO> getOffresFromIdStructureAndIdsCentreGestion(int idStructure, List<Integer> idsCentreGestion, boolean isEtudiant){
		List<OffreDTO> l = this.remoteServices.getOffresFromIdStructureAndIdsCentreGestion(idStructure, idsCentreGestion, isEtudiant);
		setObjects(l,false);
		return l;
	}	
	/**
	 * @see org.esupportail.pstage.domain.OffreDomainService#getOffreFromId(int)
	 */
	public OffreDTO getOffreFromId(int id) {
		OffreDTO o = this.remoteServices.getOffreFromId(id);
		setObjects(o,false);
		return o;
	}
	
	/**
	 * @see org.esupportail.pstage.domain.OffreDomainService#getOffresFromCriteres(org.esupportail.pstagedata.domain.dto.CritereRechercheOffreDTO)
	 */
	public List<OffreDTO> getOffresFromCriteres(
			CritereRechercheOffreDTO critereRechercheOffre) {
		List<OffreDTO> l = this.remoteServices.getOffresFromCriteres(critereRechercheOffre);
		setObjects(l,true);
		return l;
	}

	/**
	 * @see org.esupportail.pstage.domain.OffreDomainService#addOffre(org.esupportail.pstagedata.domain.dto.OffreDTO)
	 */
	public int addOffre(OffreDTO o) throws DataAddException_Exception, WebServiceDataBaseException_Exception{
		return this.remoteServices.addOffre(o);
	}
	
	/**
	 * @see org.esupportail.pstage.domain.OffreDomainService#updateOffre(org.esupportail.pstagedata.domain.dto.OffreDTO)
	 */
	public boolean updateOffre(OffreDTO o) throws DataUpdateException_Exception, WebServiceDataBaseException_Exception{
		return this.remoteServices.updateOffre(o);
	}
	
	/**
	 * @see org.esupportail.pstage.domain.OffreDomainService#deleteOffreLogique(int)
	 */
	public boolean deleteOffreLogique(int idOffre) throws DataUpdateException_Exception, WebServiceDataBaseException_Exception{
		return this.remoteServices.deleteOffreLogique(idOffre);
	}
	
	/**
	 * @see org.esupportail.pstage.domain.OffreDomainService#updateValidationOffre(int, java.lang.String)
	 */
	public boolean updateValidationOffre(int idOffre, String loginValidation) throws DataUpdateException_Exception, WebServiceDataBaseException_Exception{
		return this.remoteServices.updateValidationOffre(idOffre, loginValidation);
	}
	
	/**
	 * @see org.esupportail.pstage.domain.OffreDomainService#updateStopValidationOffre(int, java.lang.String)
	 */
	public boolean updateStopValidationOffre(int idOffre, String loginStopValidation) throws DataUpdateException_Exception, WebServiceDataBaseException_Exception{
		return this.remoteServices.updateStopValidationOffre(idOffre, loginStopValidation);
	}
	
	/**
	 * @see org.esupportail.pstage.domain.OffreDomainService#updateDiffusionOffre(int, java.lang.String, java.util.Date)
	 */
	public boolean updateDiffusionOffre(int idOffre, String loginDffusion, Date dateFinDiffusion) throws DataUpdateException_Exception, WebServiceDataBaseException_Exception{
		return this.remoteServices.updateDiffusionOffre(idOffre, loginDffusion, dateFinDiffusion);
	}
	
	/**
	 * @see org.esupportail.pstage.domain.OffreDomainService#updateStopDiffusionOffre(int, java.lang.String)
	 */
	public boolean updateStopDiffusionOffre(int idOffre, String loginStopDiffusion) throws DataUpdateException_Exception, WebServiceDataBaseException_Exception{
		return this.remoteServices.updateStopDiffusionOffre(idOffre, loginStopDiffusion);
	}
	
	/**
	 * @see org.esupportail.pstage.domain.OffreDomainService#updateRejetOffre(int, java.lang.String)
	 */
	public boolean updateRejetOffre(int idOffre, String loginRejetValidation) throws DataUpdateException_Exception,WebServiceDataBaseException_Exception{
		return this.remoteServices.updateRejetOffre(idOffre, loginRejetValidation);
	}
	
	/**
	 * @see org.esupportail.pstage.domain.OffreDomainService#updateOffrePourvue(int, boolean)
	 */
	public boolean updateOffrePourvue(int idOffre, boolean estPourvue) throws DataUpdateException_Exception, WebServiceDataBaseException_Exception{
		return this.remoteServices.updateOffrePourvue(idOffre, estPourvue);
	}
	
	/* ****************************************************************************
	 * FICHIER
	 *****************************************************************************/	
	
	/**
	 * @see org.esupportail.pstage.domain.OffreDomainService#getFichierFromIdFichier(int)
	 */
	public FichierDTO getFichierFromIdFichier(int idFichier){
		return this.remoteServices.getFichierFromIdFichier(idFichier);
	}
	
	/**
	 * @see org.esupportail.pstage.domain.OffreDomainService#addFichier(org.esupportail.pstagedata.domain.dto.FichierDTO)
	 */
	public int addFichier(FichierDTO o) throws DataAddException_Exception, WebServiceDataBaseException_Exception{
		return this.remoteServices.addFichier(o);
	}

	/**
	 * @see org.esupportail.pstage.domain.OffreDomainService#updateFichier(org.esupportail.pstagedata.domain.dto.FichierDTO)
	 */
	public boolean updateFichier(FichierDTO o) throws DataUpdateException_Exception, WebServiceDataBaseException_Exception{
		return this.remoteServices.updateFichier(o);
	}
	
	/**
	 * @see org.esupportail.pstage.domain.OffreDomainService#deleteFichier(int)
	 */
	public boolean deleteFichier(int idFichier) throws DataDeleteException_Exception, WebServiceDataBaseException_Exception{
		return this.remoteServices.deleteFichier(idFichier);
	}
	
	/**
	 * @see org.esupportail.pstage.domain.OffreDomainService#cleanFichiers()
	 */
	public boolean cleanFichiers() throws DataDeleteException_Exception, WebServiceDataBaseException_Exception{
		return this.remoteServices.cleanFichiers();
	}
	/* ****************************************************************************
	 * OFFRE MODE CANDIDATURE
	 *****************************************************************************/

	/**
	 * @see org.esupportail.pstage.domain.OffreDomainService#addOffreModeCandidature(int, java.util.List)
	 */
	public int addOffreModeCandidature(int idOffre, List<Integer> idsModeCandidature) throws DataAddException_Exception, DataDeleteException_Exception, WebServiceDataBaseException_Exception{
		return this.remoteServices.addOffreModeCandidature(idOffre, idsModeCandidature);
	}
	
	/**
	 * @see org.esupportail.pstage.domain.OffreDomainService#deleteOffreModeCandidatureFromId(int)
	 */
	public boolean deleteOffreModeCandidatureFromId(int idOffre) throws DataAddException_Exception, WebServiceDataBaseException_Exception{
		return this.remoteServices.deleteOffreModeCandidatureFromId(idOffre);
	}

	/* ****************************************************************************
	 * OFFRE DIFFUSION
	 *****************************************************************************/
	/**
	 * @see org.esupportail.pstage.domain.OffreDomainService#getOffreDiffusionFromIdOffre(int)
	 */
	public List<OffreDiffusionDTO> getOffreDiffusionFromIdOffre(int idOffre){
		List<OffreDiffusionDTO> l = null;
		if(idOffre>0){
			l = this.remoteServices.getOffreDiffusionFromIdOffre(idOffre);
		}
		return l;
	}
	
	/**
	 * @see org.esupportail.pstage.domain.OffreDomainService#addOffreDiffusion(java.util.List)
	 */
	public int addOffreDiffusion(List<OffreDiffusionDTO> lod) throws DataAddException_Exception, DataDeleteException_Exception, WebServiceDataBaseException_Exception{
		int b=0;
		if(lod!=null && !lod.isEmpty()){
			b = this.remoteServices.addOffreDiffusion(lod);
		}
		return b;
	}
	
	/**
	 * @see org.esupportail.pstage.domain.OffreDomainService#deleteOffreDiffusionFromId(int)
	 */
	public boolean deleteOffreDiffusionFromId(int idOffre) throws DataDeleteException_Exception, WebServiceDataBaseException_Exception{
		boolean b = false;
		if(idOffre>0){
			b = this.remoteServices.deleteOffreDiffusionFromId(idOffre);
		}
		return b;
	}
	/**
	 * @see org.esupportail.pstage.domain.OffreDomainService#getDureeDiffusion()
	 */
	public List<DureeDiffusionDTO> getDureeDiffusion(){
		List<DureeDiffusionDTO> l = this.remoteServices.getDureeDiffusion();
		return l;
	}

	/**
	 * @see org.esupportail.pstage.domain.OffreDomainService#countOffreADiffuser()
	 */
	public int countOffreADiffuser(){
		return this.remoteServices.countOffreADiffuser();
	}
	
	/**
	 * Rempli les divers objets de nomenclatures depuis les listes en caches
	 * @param lo
	 * @param light 
	 */
	public void setObjects(List<OffreDTO> lo, boolean light){
		if(lo!=null){
			for(OffreDTO o : lo){
				setObjects(o, light);
			}
		}
	}
	
	/**
	 * Rempli les divers objets de nomenclatures depuis les listes en caches
	 * @param o
	 * @param light 
	 */
	public void setObjects(OffreDTO o, boolean light){
		if(o!=null){
			if (o.getIdTypeOffre() > 0){
				o.setTypeOffre(this.nomenclatureDomainService.getTypeOffreFromId(o.getIdTypeOffre()));
			}
			if (o.getIdContratOffre() > 0){
				o.setContratOffre(this.nomenclatureDomainService.getContratOffreFromId(o.getIdContratOffre()));
			}
			if (o.getIdLieuPays() > 0){
				o.setLieuPays(this.nomenclatureDomainService.getPaysFromId(o.getIdLieuPays()));
			}
			if(!light){
				if (o.getIdUniteDuree() > 0){
					o.setUniteDuree(this.nomenclatureDomainService.getUniteDureeFromId(o.getIdUniteDuree()));
				}
				if (o.getIdQualificationSimplifiee() > 0){
					o.setFapQualificationSimplifiee(this.nomenclatureDomainService.getFapQualificationSimplifieeFromId(o.getIdQualificationSimplifiee()));
				}
				if (StringUtils.hasText(o.getCodeFAP_N3())){
					//o.setFapN3(this.nomenclatureDomainService.getFapN3FromCode(o.getCodeFAP_N3()));
					o.setFapN1(this.nomenclatureDomainService.getFapN1FromCode(o.getCodeFAP_N3()));
				}
				if (o.getIdTempsTravail() > 0){
					o.setTempsTravail(this.nomenclatureDomainService.getTempsTravailFromId(o.getIdTempsTravail()));
				}
				
				List<ModeCandidatureDTO> lm = new ArrayList<ModeCandidatureDTO>();
				
				if(o.getIdsModeCandidature()!=null && !o.getIdsModeCandidature().isEmpty()){
					for(int i : o.getIdsModeCandidature()){
						lm.add(this.nomenclatureDomainService.getModeCandidatureFromId(i));
					}
				}
				o.setModesCandidature(lm);
				if (o.getIdNiveauFormation() > 0){
					o.setNiveauFormation(this.nomenclatureDomainService.getNiveauFormationFromId(o.getIdNiveauFormation()));
				}
				if(o.getIdContactCand()>0 && o.getContactCand()!=null) setObjectsForContact(o.getContactCand());
				if(o.getIdContactInfo()>0 && o.getContactInfo()!=null) setObjectsForContact(o.getContactInfo());
				if(o.getIdContactProprio()>0 && o.getContactProprio()!=null) setObjectsForContact(o.getContactProprio());
			}
		}
	}
	/**
	 * @param lc
	 */
	public void setObjectsForContact(List<ContactDTO> lc){
		if(lc!=null){
			for(ContactDTO c : lc){
				setObjectsForContact(c);
			}
		}
	}
	
	/**
	 * @param c
	 */
	public void setObjectsForContact(ContactDTO c){
		if(c!=null){
			if (c.getIdCivilite() != 0)
				c.setCivilite(nomenclatureDomainService.getCiviliteFromId(c.getIdCivilite()));
		}
	}

	
}
