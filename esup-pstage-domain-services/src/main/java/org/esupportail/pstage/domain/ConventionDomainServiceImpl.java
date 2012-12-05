/**
 * ESUP-Portail PStageData - Copyright (c) 2006 ESUP-Portail consortium
 * http://sourcesup.cru.fr/projects/esup-pstagedata
 */
package org.esupportail.pstage.domain;

import java.io.Serializable;
import java.util.List;

import org.esupportail.pstagedata.remote.ConventionDTO;
import org.esupportail.pstagedata.remote.CritereRechercheConventionDTO;
import org.esupportail.pstagedata.remote.DataAddException_Exception;
import org.esupportail.pstagedata.remote.DataDeleteException_Exception;
import org.esupportail.pstagedata.remote.DataUpdateException_Exception;
import org.esupportail.pstagedata.remote.EtapeAlreadyExistingForCodeException_Exception;
import org.esupportail.pstagedata.remote.EtapeDTO;
import org.esupportail.pstagedata.remote.RemoteServices;
import org.esupportail.pstagedata.remote.UfrAlreadyExistingForCodeException_Exception;
import org.esupportail.pstagedata.remote.UfrDTO;
import org.esupportail.pstagedata.remote.WebServiceDataBaseException_Exception;


/**
 * Convention Domain service interface.
 */
/**
 * @author Danielle Martineau : danielle.martineau@univ-rennes1.fr
 *
 */
public class ConventionDomainServiceImpl implements Serializable, ConventionDomainService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	 * @see org.esupportail.pstage.domain.ConventionDomainService#addConvention(org.esupportail.pstagedata.domain.dto.ConventionDTO)
	 */
	public int addConvention(ConventionDTO convention) throws DataAddException_Exception,
	WebServiceDataBaseException_Exception {

		return this.remoteServices.addConvention(convention);
	}


	/**
	 * @see org.esupportail.pstage.domain.ConventionDomainService#deleteConvention(int)
	 */
	public boolean deleteConvention(int idConvention)
	throws DataDeleteException_Exception, WebServiceDataBaseException_Exception {

		return this.remoteServices.deleteConvention(idConvention);
	}


	/**
	 * @see org.esupportail.pstage.domain.ConventionDomainService#getConventionFromId(int)
	 */
	public ConventionDTO getConventionFromId(int id) {

		ConventionDTO c = this.remoteServices.getConventionFromId(id);
		setObjects(c);
		return c;
	}


	/**
	 * @see org.esupportail.pstage.domain.ConventionDomainService#getConventions(java.lang.String)
	 */
	public List<ConventionDTO> getConventions(String codeUniversite) {
		List<ConventionDTO> lc = this.remoteServices.getConventionsFromCodUniv(codeUniversite);
		setObjects(lc);
		return lc;
	}


	/**
	 * @see org.esupportail.pstage.domain.ConventionDomainService#updateConvention(org.esupportail.pstagedata.domain.dto.ConventionDTO)
	 */
	public boolean updateConvention(ConventionDTO convention)
	throws DataUpdateException_Exception, WebServiceDataBaseException_Exception {

		return this.remoteServices.updateConvention(convention);
	}
	/**
	 * @see org.esupportail.pstage.domain.ConventionDomainService#updateCentreConventionByUfr(java.lang.String, int, java.lang.String)
	 */
	public boolean updateCentreConventionByUfr(String code, int idCentreGestion, String codeUniversite)
	throws DataUpdateException_Exception, WebServiceDataBaseException_Exception {
		return this.remoteServices.updateCentreConventionByUfrCodUniv(code, idCentreGestion, codeUniversite);
	}
	/**
	 * @see org.esupportail.pstage.domain.ConventionDomainService#updateCentreConventionByEtape(java.lang.String, int, java.lang.String)
	 */
	public boolean updateCentreConventionByEtape(String code, int idCentreGestion, String codeUniversite)
	throws DataUpdateException_Exception, WebServiceDataBaseException_Exception {
		return this.remoteServices.updateCentreConventionByEtapeCodUniv(code, idCentreGestion, codeUniversite);
	}
	/**
	 * @see org.esupportail.pstage.domain.ConventionDomainService#getAnneesConvention(java.lang.String)
	 */
	public List<String> getAnneesConvention(String codeUniversite) {
		return this.remoteServices.getAnneesConventionFromCodUniv(codeUniversite);
	}
	/**
	 * @see org.esupportail.pstage.domain.ConventionDomainService#getConventionsFromCriteres(CritereRechercheConventionDTO)
	 */
	public List<ConventionDTO> getConventionsFromCriteres(CritereRechercheConventionDTO critereRechercheConvention){
		return this.remoteServices.getConventionsFromCriteres(critereRechercheConvention);
	}
	
	/**
	 * @see org.esupportail.pstage.domain.ConventionDomainService#getConventionsFromCriteresByEnseignantTuteur(int, org.esupportail.pstagedata.domain.dto.CritereRechercheConventionDTO)
	 */
	public List<ConventionDTO> getConventionsFromCriteresByEnseignantTuteur(int idEnseignant, 
			CritereRechercheConventionDTO critereRechercheConvention) {
		return this.remoteServices.getConventionsFromCriteresByEnseignantTuteur(idEnseignant, critereRechercheConvention);
	}

	/**
	 * @see org.esupportail.pstage.domain.ConventionDomainService#getConventionsFromCriteresExport(org.esupportail.pstagedata.domain.dto.CritereRechercheConventionDTO)
	 */
	public List<ConventionDTO> getConventionsFromCriteresExport(CritereRechercheConventionDTO critereRechercheConvention){
		List<ConventionDTO> lc = this.remoteServices.getConventionsFromCriteresExport(critereRechercheConvention);
		//		if(lc!=null){
		//			for(ConventionDTO c : lc){
		//				setObjectsExport(c);
		//			}
		//		}
		return lc;
	}


	/**
	 * @see org.esupportail.pstage.domain.ConventionDomainService#getConventionFromExport(int)
	 */
	public ConventionDTO getConventionFromExport(int id) {
		ConventionDTO c = this.remoteServices.getConventionFromExport(id);
		setObjectsExport(c);
		return c;
	}


	/**
	 * @see org.esupportail.pstage.domain.ConventionDomainService#getConventionsEtudiant(java.lang.String, java.lang.String)
	 */
	public List<ConventionDTO> getConventionsEtudiant(String identEtudiant, String codeUniversite) {
		return this.remoteServices.getConventionsEtudiantFromCodUniv(identEtudiant, codeUniversite);
	}

	/**
	 * @see org.esupportail.pstage.domain.ConventionDomainService#getNombreConventionByCentreGestion(int, java.lang.String)
	 */
	public int getNombreConventionByCentreGestion(int idCentreGestion, String codeUniversite){
		return this.remoteServices.getNombreConventionByCentreGestionFromCodUniv(idCentreGestion, codeUniversite);
	}


	/**
	 * @param idEnseignant
	 * @param annee
	 * @return List<ConventionDTO>
	 */
	public List<ConventionDTO> getConventionsByEnseignant(int idEnseignant, String annee) {
		return this.remoteServices.getConventionsByEnseignant(idEnseignant, annee);
	}

	/**
	 * @see org.esupportail.pstage.domain.ConventionDomainService#getEtapesFromIdsCentreGestion(java.util.List, java.lang.String)
	 */
	public List<EtapeDTO> getEtapesFromIdsCentreGestion(List<Integer> idsCentreGestion, String codeUniversite){
		List<EtapeDTO> l = null;
		if(idsCentreGestion!=null &&! idsCentreGestion.isEmpty()){
			l = this.remoteServices.getEtapesFromIdsCentreGestionFromCodUniv(idsCentreGestion, codeUniversite);
		}
		return l;
	}

	/**
	 * @see org.esupportail.pstage.domain.ConventionDomainService#getUfrsFromIdsCentreGestion(java.util.List, java.lang.String)
	 */
	public List<UfrDTO> getUfrsFromIdsCentreGestion(List<Integer> idsCentreGestion, String codeUniversite){
		List<UfrDTO> l = null;
		if(idsCentreGestion!=null &&! idsCentreGestion.isEmpty()){
			l = this.remoteServices.getUfrsFromIdsCentreGestionFromCodUniv(idsCentreGestion, codeUniversite);
		}
		return l;
	}

	/**
	 * Rempli les divers objets (TypeConvention, ...) depuis les listes en caches
	 * @param lc
	 */
	public void setObjects(List<ConventionDTO> lc){
		if(lc!=null){
			for(ConventionDTO c : lc){
				setObjects(c);
			}
		}
	}

	/**
	 * Rempli les divers objets (TypeConvention, ...) depuis les listes en caches
	 * @param c
	 */
	public void setObjects(ConventionDTO c){
		if(c!=null){
			if (c.getIdTypeConvention() != null && c.getIdTypeConvention() > 0){
				c.setTypeConvention(this.nomenclatureDomainService.getTypeConventionDTOFromId(c.getIdTypeConvention()));
			}
			if (c.getIdTheme() != null && c.getIdTheme() > 0){
				c.setTheme(this.nomenclatureDomainService.getThemeDTOFromId(c.getIdTheme()));
			}
			if (c.getIdUniteDureeExceptionnelle() != null && c.getIdUniteDureeExceptionnelle() > 0){
				c.setUniteDuree(this.nomenclatureDomainService.getUniteDureeFromId(c.getIdUniteDureeExceptionnelle()));
			}
			if (c.getIdTempsTravail() != null && c.getIdTempsTravail() > 0){
				c.setTempsTravail(this.nomenclatureDomainService.getTempsTravailFromId(c.getIdTempsTravail()));
			}
			if (c.getIdIndemnisation() != null && c.getIdTempsTravail() > 0){
				c.setIndemnisation(this.nomenclatureDomainService.getIndemnisationDTOFromId(c.getIdIndemnisation()));
			}
			if (c.getIdUniteGratification() != null && c.getIdUniteGratification() > 0){
				c.setUniteGratification(this.nomenclatureDomainService.getUniteGratificationDTOFromId(c.getIdUniteGratification()));
			}
			if (c.getIdModeVersGratification() != null && c.getIdModeVersGratification() > 0){
				c.setModeVersGratification(this.nomenclatureDomainService.getModeVersGratificationDTOFromId(c.getIdModeVersGratification()));
			}
			if (c.getIdNatureTravail() != null && c.getIdNatureTravail() > 0){
				c.setNatureTravail(this.nomenclatureDomainService.getNatureTravailDTOFromId(c.getIdNatureTravail()));
			}
			if (c.getIdModeValidationStage() != null && c.getIdModeValidationStage() > 0){
				c.setModeValidationStage(this.nomenclatureDomainService.getModeValidationStageDTOFromId(c.getIdModeValidationStage()));
			}
			if (c.getIdOrigineStage() != null && c.getIdOrigineStage() > 0){
				c.setOrigineStage(this.nomenclatureDomainService.getOrigineStageDTOFromId(c.getIdOrigineStage()));
			}
			if (c.getIdAssurance() != null && c.getIdAssurance() > 0){
				c.setAssurance(this.nomenclatureDomainService.getAssuranceDTOFromId(c.getIdAssurance()));
			}
			if (c.getCodeCaisse() != null && !c.getCodeCaisse().isEmpty()){
				c.setCaisseRegime(this.nomenclatureDomainService.getCaisseRegimeDTOFromId(c.getCodeCaisse()));
			}
			if (c.getCodeLangueConvention() != null && !c.getCodeLangueConvention().isEmpty()){
				c.setLangueConvention(this.nomenclatureDomainService.getLangueConventionDTOFromId(c.getCodeLangueConvention()));
			}
			if (c.getIdService() != null && c.getIdService() > 0){
				c.setService(this.structureDomainService.getServiceFromId(c.getIdService()));
			}
			if (c.getIdContact() != null && c.getIdContact() > 0){
				c.setContact(this.structureDomainService.getContactFromId(c.getIdContact()));
			}
			if(c.getCodeUFR()!=null){
				c.setUfr(getUfrFromId(c.getCodeUFR(), c.getCodeUniversiteUFR()));
			}
			if(c.getCodeEtape()!=null){
				c.setEtape(getEtapeFromId(c.getCodeEtape(), c.getCodeUniversiteEtape()));
			}
		}
	}

	/**
	 * Rempli les divers objets (TypeConvention, ...) depuis les listes en caches
	 * @param c
	 */
	public void setObjectsExport(final ConventionDTO c) {
		if (c != null) {
			if (c.getIdTheme() != null) {
				c.setTheme(this.nomenclatureDomainService.getThemeDTOFromId(c.getIdTheme()));
			}
			if (c.getIdIndemnisation() != null) {
				c.setIndemnisation(this.nomenclatureDomainService.getIndemnisationDTOFromId(c.getIdIndemnisation()));
			}
			if (c.getIdUniteGratification() != null) {
				c.setUniteGratification(this.nomenclatureDomainService.getUniteGratificationDTOFromId(c.getIdUniteGratification()));
			}
			if (c.getStructure() != null) {
				if (c.getStructure().getIdTypeStructure() > 0 ) {
					c.getStructure().setTypeStructure(this.nomenclatureDomainService.getTypeStructureFromId(c.getStructure().getIdTypeStructure()));
				}
				if (c.getStructure().getIdStatutJuridique() > 0 ) {
					c.getStructure().setStatutJuridique(this.nomenclatureDomainService.getStatutJuridiqueFromId(c.getStructure().getIdStatutJuridique()));
				}
				if (c.getStructure().getIdEffectif() > 0 ) {
					c.getStructure().setEffectif(this.nomenclatureDomainService.getEffectifFromId(c.getStructure().getIdEffectif()));
				}
				if (c.getStructure().getIdPays() > 0 ) {
					c.getStructure().setPays(this.nomenclatureDomainService.getPaysFromId(c.getStructure().getIdPays()));
				}
			}
			if (c.getService() != null) {
				if (c.getService().getIdPays() > 0) {
					c.getService().setPays(this.nomenclatureDomainService.getPaysFromId(c.getService().getIdPays()));
				}

			}
			if (c.getContact() != null) {
				if (c.getContact().getIdCivilite() > 0) {
					c.getContact().setCivilite(nomenclatureDomainService.getCiviliteFromId(c.getContact().getIdCivilite()));
				}
			}
			
			if (c.getSignataire() != null) {
				if (c.getSignataire().getIdCivilite() > 0) {
					c.getSignataire().setCivilite(nomenclatureDomainService.getCiviliteFromId(c.getSignataire().getIdCivilite()));
				}
			}
			
			if (c.getEnseignant() != null) {
				if (c.getEnseignant().getIdCivilite() > 0) {
					c.getEnseignant().setCivilite(nomenclatureDomainService.getCiviliteFromId(c.getEnseignant().getIdCivilite()));
				}
			}
			if (c.getIdUniteDureeExceptionnelle() != null) {
				if (c.getIdUniteDureeExceptionnelle() > 0) {
					c.setUniteDuree(this.nomenclatureDomainService.getUniteDureeFromId(c.getIdUniteDureeExceptionnelle()));
				}

			}
			if (c.getIdTypeConvention() != null) {
				c.setTypeConvention(this.nomenclatureDomainService.getTypeConventionDTOFromId(c.getIdTypeConvention()));
			}
			if(c.getCodeUFR()!=null){
				c.setUfr(getUfrFromId(c.getCodeUFR(), c.getCodeUniversiteUFR()));
			}
			if(c.getCodeEtape()!=null){
				c.setEtape(getEtapeFromId(c.getCodeEtape(), c.getCodeUniversiteEtape()));
			}
		}
	}

	/**
	 * @see org.esupportail.pstage.domain.ConventionDomainService#addEtape(org.esupportail.pstagedata.domain.dto.EtapeDTO)
	 */
	public int addEtape(EtapeDTO etape) throws DataAddException_Exception,
	WebServiceDataBaseException_Exception, EtapeAlreadyExistingForCodeException_Exception {
		return this.remoteServices.addEtape(etape);
	}


	/**
	 * @see org.esupportail.pstage.domain.ConventionDomainService#addUfr(org.esupportail.pstagedata.domain.dto.UfrDTO)
	 */
	public int addUfr(UfrDTO ufr) throws DataAddException_Exception,
	WebServiceDataBaseException_Exception, UfrAlreadyExistingForCodeException_Exception {
		return this.remoteServices.addUfr(ufr);
	}


	/**
	 * @see org.esupportail.pstage.domain.ConventionDomainService#getEtapeFromId(java.lang.String, java.lang.String)
	 */
	public EtapeDTO getEtapeFromId(String code, String codeUniversite) {
		return this.remoteServices.getEtapeFromIdFromCodUniv(code, codeUniversite);
	}


	/**
	 * @see org.esupportail.pstage.domain.ConventionDomainService#getUfrFromId(java.lang.String, java.lang.String)
	 */
	public UfrDTO getUfrFromId(String code, String codeUniversite) {
		return this.remoteServices.getUfrFromIdFromCodUniv(code, codeUniversite);
	}

	/**
	 * @see org.esupportail.pstage.domain.ConventionDomainService#getCodeUFRFromCodeEtape(java.lang.String, java.lang.String)
	 */
	public String getCodeUFRFromCodeEtape(String codeEtape, String codeUniversite) {
		return this.remoteServices.getCodeUFRFromCodeEtapeFromCodUniv(codeEtape, codeUniversite);
	}
}
