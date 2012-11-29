/**
 * ESUP-PStage - Copyright (c) 2006 ESUP-Portail consortium
 * http://sourcesup.cru.fr/projects/esup-pstage
 */
package org.esupportail.pstage.domain;

import java.io.Serializable;
import java.util.List;

import org.esupportail.pstagedata.remote.AffectationDTO;
import org.esupportail.pstagedata.remote.AssuranceDTO;
import org.esupportail.pstagedata.remote.CaisseRegimeDTO;
import org.esupportail.pstagedata.remote.CiviliteDTO;
import org.esupportail.pstagedata.remote.ConfidentialiteDTO;
import org.esupportail.pstagedata.remote.ContratOffreDTO;
import org.esupportail.pstagedata.remote.CritereGestionDTO;
import org.esupportail.pstagedata.remote.DroitAdministrationDTO;
import org.esupportail.pstagedata.remote.EffectifDTO;
import org.esupportail.pstagedata.remote.FapN1DTO;
import org.esupportail.pstagedata.remote.FapN2DTO;
import org.esupportail.pstagedata.remote.FapN3DTO;
import org.esupportail.pstagedata.remote.FapQualificationDTO;
import org.esupportail.pstagedata.remote.FapQualificationSimplifieeDTO;
import org.esupportail.pstagedata.remote.IndemnisationDTO;
import org.esupportail.pstagedata.remote.LangueConventionDTO;
import org.esupportail.pstagedata.remote.ModeCandidatureDTO;
import org.esupportail.pstagedata.remote.ModeValidationStageDTO;
import org.esupportail.pstagedata.remote.ModeVersGratificationDTO;
import org.esupportail.pstagedata.remote.NafN1DTO;
import org.esupportail.pstagedata.remote.NafN5DTO;
import org.esupportail.pstagedata.remote.NatureTravailDTO;
import org.esupportail.pstagedata.remote.NiveauCentreDTO;
import org.esupportail.pstagedata.remote.NiveauFormationDTO;
import org.esupportail.pstagedata.remote.OrigineStageDTO;
import org.esupportail.pstagedata.remote.PaysDTO;
import org.esupportail.pstagedata.remote.StatutJuridiqueDTO;
import org.esupportail.pstagedata.remote.TempsTravailDTO;
import org.esupportail.pstagedata.remote.ThemeDTO;
import org.esupportail.pstagedata.remote.TypeConventionDTO;
import org.esupportail.pstagedata.remote.TypeOffreDTO;
import org.esupportail.pstagedata.remote.TypeStructureDTO;
import org.esupportail.pstagedata.remote.UniteDureeDTO;
import org.esupportail.pstagedata.remote.UniteGratificationDTO;

/**
 * The NomenclatureDaoService service interface.
 */
public interface NomenclatureDomainService extends Serializable {
	/* ****************************************************************************
	 * AFFECTATION
	 *****************************************************************************/
	/**
	 * @param codeUniversite 
	 * @return List<AffectationDTO>
	 */
	public List<AffectationDTO> getAffectations(String codeUniversite);	
	/**
	 * @param code
	 * @param codeUniversite 
	 * @return AffectationDTO
	 */
	public AffectationDTO getAffectationFromCode(String code, String codeUniversite);

	/* ****************************************************************************
	 * ASSURANCE
	 *****************************************************************************/
	/**
	 * @return List<AssuranceDTO>
	 */
	public List<AssuranceDTO> getAssurances();
	
	/**
	 * @param id
	 * @return AssuranceDTO
	 */
	public AssuranceDTO getAssuranceDTOFromId(int id);
	
	/* ****************************************************************************
	 * CAISSE REGIME
	 *****************************************************************************/
	
	/**
	 * @return List<CaisseRegimeDTO>
	 */
	public List<CaisseRegimeDTO> getCaisseRegimes();
	
	/**
	 * @param code
	 * @return CaisseRegimeDTO
	 */
	public CaisseRegimeDTO getCaisseRegimeDTOFromId(String code);
	
	/* ****************************************************************************
	 * CIVILITE
	 *****************************************************************************/
	/**
	 * @return List<CiviliteDTO>
	 */
	public List<CiviliteDTO> getCivilites();	
	/**
	 * @param id
	 * @return CiviliteDTO
	 */
	public CiviliteDTO getCiviliteFromId(int id);
	/* ****************************************************************************
	 * CONFIDENTIALITE
	 *****************************************************************************/
	/**
	 * @return List<ConfidentialiteDTO>
	 */
	public List<ConfidentialiteDTO> getConfidentialites();
	/**
	 * @param code
	 * @return ConfidentialiteDTO
	 */
	public ConfidentialiteDTO getConfidentialiteFromCode(String code);
	/* ****************************************************************************
	 * CONTRAT
	 *****************************************************************************/
	/**
	 * @return List<ContratOffreDTO>
	 */
	public List<ContratOffreDTO> getContrats();
	/**
	 * @param id
	 * @return ContratOffreDTO
	 */
	public ContratOffreDTO getContratOffreFromId(int id);
	/**
	 * @param id
	 * @return List<ContratOffreDTO>
	 */
	public List<ContratOffreDTO> getContratsOffreFromIdTypeOffre(int id);
	/* ****************************************************************************
	 * CRITERE GESTION
	 *****************************************************************************/
	/**
	 * @return List<CritereGestionDTO>
	 */
	public List<CritereGestionDTO> getCriteresGestion();
	/**
	 * @param idCentreGestion
	 * @return List<CritereGestionDTO>
	 */
	public List<CritereGestionDTO> getCritereGestionFromIdCentre(int idCentreGestion);
	/**
	 * @param code
	 * @return CritereGestionDTO
	 */
	public CritereGestionDTO getCritereGestionFromCode(String code);
	/* ****************************************************************************
	 * DROITS ADMINISTRATION
	 *****************************************************************************/
	/**
	 * @return List<DroitAdministrationDTO>
	 */
	public List<DroitAdministrationDTO> getDroitsAdmin();
	
	/**
	 * @param idDroitAdmin
	 * @return DroitAdministrationDTO
	 */
	public DroitAdministrationDTO getDroitAdministrationFromId(int idDroitAdmin);
	
	/* ****************************************************************************
	 * EFFECTIF
	 *****************************************************************************/
	/**
	 * @return List<EffectifDTO>
	 */
	public List<EffectifDTO> getEffectifs();
	/**
	 * @param id
	 * @return EffectifDTO
	 */
	public EffectifDTO getEffectifFromId(int id);
	/* ****************************************************************************
	 * FAPN1
	 *****************************************************************************/
	/**
	 * @return List<FapN1DTO>
	 */
	public List<FapN1DTO> getFapN1();
	/**
	 * @param code
	 * @return FapN1DTO
	 */
	public FapN1DTO getFapN1FromCode(String code);
	/* ****************************************************************************
	 * FAPN2
	 *****************************************************************************/
	/**
	 * @return List<FapN2DTO>
	 */
	public List<FapN2DTO> getFapN2();
	/**
	 * @param code
	 * @return FapN2DTO
	 */
	public FapN2DTO getFapN2FromCode(String code);
	/**
	 * @param code
	 * @return List<FapN2DTO>
	 */
	public List<FapN2DTO> getFapN2FromCodeFapN1(String code);
	/* ****************************************************************************
	 * FAPN3
	 *****************************************************************************/
	/**
	 * @return List<FapN3DTO>
	 */
	public List<FapN3DTO> getFapN3();
	/**
	 * @param code
	 * @return FapN3DTO
	 */
	public FapN3DTO getFapN3FromCode(String code);
	/**
	 * @param code
	 * @return List<FapN3DTO>
	 */
	public List<FapN3DTO> getFapN3FromCodeFapN2(String code);
	/**
	 * @param num
	 * @return List<FapN3DTO>
	 */
	public List<FapN3DTO> getFapN3FromNumQualif(int num);
	/**
	 * @param num
	 * @return List<FapN3DTO>
	 */
	public List<FapN3DTO> getFapN3FromNumQualifSimplifiee(int num);
	/* ****************************************************************************
	 * FAP QUALIFICATION
	 *****************************************************************************/
	/**
	 * @return List<FapQualificationDTO>
	 */
	public List<FapQualificationDTO> getFapQualifications();
	/**
	 * @param id
	 * @return FapQualificationDTO
	 */
	public FapQualificationDTO getFapQualificationFromId(int id);
	/**
	 * @param id
	 * @return List<FapQualificationDTO>
	 */
	public List<FapQualificationDTO> getFapQualificationFromNumQualifSimplifiee(int id);
	/* ****************************************************************************
	 * FAP QUALIFICATION SIMPLIFIEE
	 *****************************************************************************/
	/**
	 * @return List<FapQualificationSimplifieeDTO>
	 */
	public List<FapQualificationSimplifieeDTO> getFapQualificationsSimplifiees();
	/**
	 * @param id
	 * @return FapQualificationSimplifieeDTO
	 */
	public FapQualificationSimplifieeDTO getFapQualificationSimplifieeFromId(int id);
	

	/* ****************************************************************************
	 * INDEMNISATION
	 *****************************************************************************/
	/**
	 * @return List<IndemnisationDTO>
	 */
	public List<IndemnisationDTO> getIndemnisations();
	
	/**
	 * @param id
	 * @return IndemnisationDTO
	 */
	public IndemnisationDTO getIndemnisationDTOFromId(int id);
	
	/* ****************************************************************************
	 * LANGUE CONVENTION
	 *****************************************************************************/
	/**
	 * @return List<LangueConventionDTO>
	 */
	public List<LangueConventionDTO> getLangueConventions();
	
	/**
	 * @param code
	 * @return LangueConventionDTO
	 */
	public LangueConventionDTO getLangueConventionDTOFromId(String code);
	/* ****************************************************************************
	 * MODE CANDIDATURE
	 *****************************************************************************/
	/**
	 * @return List<ModeCandidatureDTO>
	 */
	public List<ModeCandidatureDTO> getModesCandidature();
	/**
	 * @param id
	 * @return ModeCandidatureDTO
	 */
	public ModeCandidatureDTO getModeCandidatureFromId(int id);
	
	/* ****************************************************************************
	 * MODE VADIDATION STAGE
	 *****************************************************************************/
	/**
	 * @return List<ModeValidationStageDTO>
	 */
	public List<ModeValidationStageDTO> getModeValidationStages();
	
	/**
	 * @param id
	 * @return ModeValidationStageDTO
	 */
	public ModeValidationStageDTO getModeValidationStageDTOFromId(int id);
	
	/* ****************************************************************************
	 * ModeVersGratification
	 *****************************************************************************/
	/**
	 * @return List<ModeValidationStageDTO>
	 */
	public List<ModeVersGratificationDTO> getModeVersGratifications();
	
	/**
	 * @param id
	 * @return ModeVersGratificationDTO
	 */
	public ModeVersGratificationDTO getModeVersGratificationDTOFromId(int id);
	
	/* ****************************************************************************
	 * NAFN1
	 *****************************************************************************/
	/**
	 * @return List<NafN1DTO>
	 */
	public List<NafN1DTO> getNafN1();
	/**
	 * @param code
	 * @return NafN1DTO
	 */
	public NafN1DTO getNafN1FromCode(String code);
	/* ****************************************************************************
	 * NAFN5
	 *****************************************************************************/
	/**
	 * @return List<NafN5DTO>
	 */
	public List<NafN5DTO> getNafN5();
	/**
	 * @param code
	 * @return NafN5DTO
	 */
	public NafN5DTO getNafN5FromCode(String code);
	/**
	 * @param code
	 * @return List<NafN5DTO>
	 */
	public List<NafN5DTO> getNafN5FromCodeNafN1(String code);
	
	/* ****************************************************************************
	 * NatureTravail
	 *****************************************************************************/
	/**
	 * @return List<NatureTravailDTO>
	 */
	public List<NatureTravailDTO> getNatureTravails();
	
	/**
	 * @param id
	 * @return NatureTravailDTO
	 */
	public NatureTravailDTO getNatureTravailDTOFromId(int id);
	
	/* ****************************************************************************
	 * NIVEAU CENTRE
	 *****************************************************************************/
	/**
	 * @return List<NiveauCentreDTO>
	 */
	public List<NiveauCentreDTO> getNiveauxCentre();
	/**
	 * @param id
	 * @return NiveauCentreDTO
	 */
	public NiveauCentreDTO getNiveauCentreFromId(int id);
	/**
	 * @param lib
	 * @return NiveauCentreDTO
	 */ 
	public NiveauCentreDTO getNiveauCentreFromLibelle(String lib);
	/* ****************************************************************************
	 * NIVEAU FORMATION
	 *****************************************************************************/
	/**
	 * @return List<NiveauFormationDTO>
	 */
	public List<NiveauFormationDTO> getNiveauxFormation();
	/**
	 * @param id
	 * @return NiveauFormationDTO
	 */
	public NiveauFormationDTO getNiveauFormationFromId(int id);
	
	
	/* ****************************************************************************
	 * OrigineStage
	 *****************************************************************************/
	/**
	 * @return List<OrigineStageDTO>
	 */
	public List<OrigineStageDTO> getOrigineStages();
	
	/**
	 * @param id
	 * @return OrigineStageDTO
	 */
	public OrigineStageDTO getOrigineStageDTOFromId(int id);
	/* ****************************************************************************
	 * PAYS
	 *****************************************************************************/
	/**
	 * @return List<PaysDTO>
	 */
	public List<PaysDTO> getPays();
	/**
	 * @param id
	 * @return PaysDTO
	 */
	public PaysDTO getPaysFromId(int id);
	/* ****************************************************************************
	 * STATUT JURIDIQUE
	 *****************************************************************************/
	/**
	 * @return List<StatutJuridiqueDTO>
	 */
	public List<StatutJuridiqueDTO> getStatutsJuridiques();
	/**
	 * @param id
	 * @return StatutJuridiqueDTO
	 */
	public StatutJuridiqueDTO getStatutJuridiqueFromId(int id);
	/**
	 * @param id
	 * @return List<StatutJuridiqueDTO>
	 */
	public List<StatutJuridiqueDTO> getStatutsJuridiquesFromIdTypeStructure(int id);
	/* ****************************************************************************
	 * TEMPS TRAVAIL
	 *****************************************************************************/
	/**
	 * @return List<TempsTravailDTO>
	 */
	public List<TempsTravailDTO> getTempsTravail();
	/**
	 * @param id
	 * @return TempsTravailDTO
	 */
	public TempsTravailDTO getTempsTravailFromId(int id);
	
	/* ****************************************************************************
	 * Theme
	 *****************************************************************************/
	/**
	 * @return List<ThemeDTO>
	 */
	public List<ThemeDTO> getThemes();
	
	/**
	 * @param id
	 * @return ThemeDTO
	 */
	public ThemeDTO getThemeDTOFromId(int id);
	
	/* ****************************************************************************
	 * TypeConvention
	 *****************************************************************************/
	/**
	 * @return List<TypeConventionDTO>
	 */
	public List<TypeConventionDTO> getTypeConventions();
	
	/**
	 * @param id
	 * @return TypeConventionDTO
	 */
	public TypeConventionDTO getTypeConventionDTOFromId(int id);
	/* ****************************************************************************
	 * TYPE OFFRE
	 *****************************************************************************/
	/**
	 * @return List<TypeOffreDTO>
	 */
	public List<TypeOffreDTO> getTypesOffre();
	/**
	 * @param id
	 * @return TypeOffreDTO
	 */
	public TypeOffreDTO getTypeOffreFromId(int id);
	/* ****************************************************************************
	 * TYPE STRUCTURE
	 *****************************************************************************/
	/**
	 * @return List<TypeStructureDTO>
	 */
	public List<TypeStructureDTO> getTypesStructure();
	/**
	 * @param id
	 * @return TypeStructureDTO
	 */
	public TypeStructureDTO getTypeStructureFromId(int id);
	/* ****************************************************************************
	 * UNITE DUREE
	 *****************************************************************************/
	/**
	 * @return List<UniteDureeDTO>
	 */
	public List<UniteDureeDTO> getUnitesDurees();
	/**
	 * @param id
	 * @return UniteDureeDTO
	 */
	public UniteDureeDTO getUniteDureeFromId(int id);

	
	/* ****************************************************************************
	 * UniteGratification
	 *****************************************************************************/
	/**
	 * @return List<UniteGratificationDTO>
	 */
	public List<UniteGratificationDTO> getUniteGratifications();
	
	/**
	 * @param id
	 * @return UniteGratificationDTO
	 */
	public UniteGratificationDTO getUniteGratificationDTOFromId(int id);
}
