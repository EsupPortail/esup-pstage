/**
 * ESUP-PStage - Copyright (c) 2006 ESUP-Portail consortium
 * http://sourcesup.cru.fr/projects/esup-pstage
 */
package org.esupportail.pstage.domain;

import java.io.Serializable;
import java.util.List;

import org.esupportail.pstagedata.domain.dto.AffectationDTO;
import org.esupportail.pstagedata.domain.dto.AssuranceDTO;
import org.esupportail.pstagedata.domain.dto.CaisseRegimeDTO;
import org.esupportail.pstagedata.domain.dto.CiviliteDTO;
import org.esupportail.pstagedata.domain.dto.ConfidentialiteDTO;
import org.esupportail.pstagedata.domain.dto.ContratOffreDTO;
import org.esupportail.pstagedata.domain.dto.CritereGestionDTO;
import org.esupportail.pstagedata.domain.dto.DroitAdministrationDTO;
import org.esupportail.pstagedata.domain.dto.EffectifDTO;
import org.esupportail.pstagedata.domain.dto.FapN1DTO;
import org.esupportail.pstagedata.domain.dto.FapN2DTO;
import org.esupportail.pstagedata.domain.dto.FapN3DTO;
import org.esupportail.pstagedata.domain.dto.FapQualificationDTO;
import org.esupportail.pstagedata.domain.dto.FapQualificationSimplifieeDTO;
import org.esupportail.pstagedata.domain.dto.IndemnisationDTO;
import org.esupportail.pstagedata.domain.dto.LangueConventionDTO;
import org.esupportail.pstagedata.domain.dto.ModeCandidatureDTO;
import org.esupportail.pstagedata.domain.dto.ModeValidationStageDTO;
import org.esupportail.pstagedata.domain.dto.ModeVersGratificationDTO;
import org.esupportail.pstagedata.domain.dto.NafN1DTO;
import org.esupportail.pstagedata.domain.dto.NafN5DTO;
import org.esupportail.pstagedata.domain.dto.NatureTravailDTO;
import org.esupportail.pstagedata.domain.dto.NiveauCentreDTO;
import org.esupportail.pstagedata.domain.dto.NiveauFormationDTO;
import org.esupportail.pstagedata.domain.dto.OrigineStageDTO;
import org.esupportail.pstagedata.domain.dto.PaysDTO;
import org.esupportail.pstagedata.domain.dto.StatutJuridiqueDTO;
import org.esupportail.pstagedata.domain.dto.TempsTravailDTO;
import org.esupportail.pstagedata.domain.dto.ThemeDTO;
import org.esupportail.pstagedata.domain.dto.TypeConventionDTO;
import org.esupportail.pstagedata.domain.dto.TypeOffreDTO;
import org.esupportail.pstagedata.domain.dto.TypeStructureDTO;
import org.esupportail.pstagedata.domain.dto.UniteDureeDTO;
import org.esupportail.pstagedata.domain.dto.UniteGratificationDTO;
import org.esupportail.pstagedata.exceptions.DataAddException;
import org.esupportail.pstagedata.exceptions.DataDeleteException;
import org.esupportail.pstagedata.exceptions.DataUpdateException;
import org.esupportail.pstagedata.exceptions.WebServiceDataBaseException;

/**
 * The NomenclatureDaoService service interface.
 */
public interface NomenclatureDomainService extends Serializable {
	
	/* ****************************************************************************
	 * AJOUTS/UPDATES/SUPPRESSIONS
	 *****************************************************************************/
	/**
	 * @return int
	 * @throws DataAddException 
	 * @throws WebServiceDataBaseException 
	 */
	public int addCaisseRegime(CaisseRegimeDTO cr) throws DataAddException, WebServiceDataBaseException;
	/**
	 * @return boolean
	 * @throws DataUpdateException 
	 * @throws WebServiceDataBaseException 
	 */
	public boolean updateCaisseRegime(CaisseRegimeDTO cr, String codeCaisse) throws DataUpdateException,WebServiceDataBaseException;
	/**
	 * @return boolean
	 * @throws DataDeleteException 
	 * @throws WebServiceDataBaseException
	 */
	public boolean deleteCaisseRegime(String codeCaisse) throws DataDeleteException,WebServiceDataBaseException;
	
	/**
	 * @return int
	 * @throws DataAddException 
	 * @throws WebServiceDataBaseException 
	 */
	public int addNiveauFormation(NiveauFormationDTO nf) throws DataAddException, WebServiceDataBaseException;
	/**
	 * @return boolean
	 * @throws DataUpdateException 
	 * @throws WebServiceDataBaseException 
	 */
	public boolean updateNiveauFormation(NiveauFormationDTO nf) throws DataUpdateException,WebServiceDataBaseException;
	/**
	 * @return boolean
	 * @throws DataDeleteException 
	 * @throws WebServiceDataBaseException
	 */
	public boolean deleteNiveauFormation(int id) throws DataDeleteException,WebServiceDataBaseException;
	
	/**
	 * @return int
	 * @throws DataAddException 
	 * @throws WebServiceDataBaseException 
	 */
	public int addEffectif(EffectifDTO ef) throws DataAddException, WebServiceDataBaseException;
	/**
	 * @return boolean
	 * @throws DataUpdateException 
	 * @throws WebServiceDataBaseException 
	 */
	public boolean updateEffectif(EffectifDTO ef) throws DataUpdateException,WebServiceDataBaseException;
	/**
	 * @return boolean
	 * @throws DataDeleteException 
	 * @throws WebServiceDataBaseException
	 */
	public boolean deleteEffectif(int id) throws DataDeleteException,WebServiceDataBaseException;
	
	/**
	 * @return int
	 * @throws DataAddException 
	 * @throws WebServiceDataBaseException 
	 */
	public int addTempsTravail(TempsTravailDTO tt) throws DataAddException, WebServiceDataBaseException;
	/**
	 * @return boolean
	 * @throws DataUpdateException 
	 * @throws WebServiceDataBaseException 
	 */
	public boolean updateTempsTravail(TempsTravailDTO tt) throws DataUpdateException,WebServiceDataBaseException;
	/**
	 * @return boolean
	 * @throws DataDeleteException 
	 * @throws WebServiceDataBaseException
	 */
	public boolean deleteTempsTravail(int id) throws DataDeleteException,WebServiceDataBaseException;
	
	/**
	 * @return int
	 * @throws DataAddException 
	 * @throws WebServiceDataBaseException 
	 */
	public int addOrigineStage(OrigineStageDTO os) throws DataAddException, WebServiceDataBaseException;
	/**
	 * @return boolean
	 * @throws DataUpdateException 
	 * @throws WebServiceDataBaseException 
	 */
	public boolean updateOrigineStage(OrigineStageDTO os) throws DataUpdateException,WebServiceDataBaseException;
	/**
	 * @return boolean
	 * @throws DataDeleteException 
	 * @throws WebServiceDataBaseException
	 */
	public boolean deleteOrigineStage(int id) throws DataDeleteException,WebServiceDataBaseException;
	
	/**
	 * @return int
	 * @throws DataAddException 
	 * @throws WebServiceDataBaseException 
	 */
	public int addTypeConvention(TypeConventionDTO tc) throws DataAddException, WebServiceDataBaseException;
	/**
	 * @return boolean
	 * @throws DataUpdateException 
	 * @throws WebServiceDataBaseException 
	 */
	public boolean updateTypeConvention(TypeConventionDTO tc) throws DataUpdateException,WebServiceDataBaseException;
	/**
	 * @return boolean
	 * @throws DataDeleteException 
	 * @throws WebServiceDataBaseException
	 */
	public boolean deleteTypeConvention(int id) throws DataDeleteException,WebServiceDataBaseException;
	
	/**
	 * @return int
	 * @throws DataAddException 
	 * @throws WebServiceDataBaseException 
	 */
	public int addTypeStructure(TypeStructureDTO ts) throws DataAddException, WebServiceDataBaseException;
	/**
	 * @return boolean
	 * @throws DataUpdateException 
	 * @throws WebServiceDataBaseException 
	 */
	public boolean updateTypeStructure(TypeStructureDTO ts) throws DataUpdateException,WebServiceDataBaseException;
	/**
	 * @return boolean
	 * @throws DataDeleteException 
	 * @throws WebServiceDataBaseException
	 */
	public boolean deleteTypeStructure(int id) throws DataDeleteException,WebServiceDataBaseException;
	
	/**
	 * @return int
	 * @throws DataAddException 
	 * @throws WebServiceDataBaseException 
	 */
	public int addStatutJuridique(StatutJuridiqueDTO sj) throws DataAddException, WebServiceDataBaseException;
	/**
	 * @return boolean
	 * @throws DataUpdateException 
	 * @throws WebServiceDataBaseException 
	 */
	public boolean updateStatutJuridique(StatutJuridiqueDTO sj) throws DataUpdateException,WebServiceDataBaseException;
	/**
	 * @return boolean
	 * @throws DataDeleteException 
	 * @throws WebServiceDataBaseException
	 */
	public boolean deleteStatutJuridique(int id) throws DataDeleteException,WebServiceDataBaseException;
	
	/**
	 * @return int
	 * @throws DataAddException 
	 * @throws WebServiceDataBaseException 
	 */
	public int addTypeOffre(TypeOffreDTO to) throws DataAddException, WebServiceDataBaseException;
	/**
	 * @return boolean
	 * @throws DataUpdateException 
	 * @throws WebServiceDataBaseException 
	 */
	public boolean updateTypeOffre(TypeOffreDTO to) throws DataUpdateException,WebServiceDataBaseException;
	/**
	 * @return boolean
	 * @throws DataDeleteException 
	 * @throws WebServiceDataBaseException
	 */
	public boolean deleteTypeOffre(int id) throws DataDeleteException,WebServiceDataBaseException;
	
	/**
	 * @return int
	 * @throws DataAddException 
	 * @throws WebServiceDataBaseException 
	 */
	public int addContratOffre(ContratOffreDTO co) throws DataAddException, WebServiceDataBaseException;
	/**
	 * @return boolean
	 * @throws DataUpdateException 
	 * @throws WebServiceDataBaseException 
	 */
	public boolean updateContratOffre(ContratOffreDTO co) throws DataUpdateException,WebServiceDataBaseException;
	/**
	 * @return boolean
	 * @throws DataDeleteException 
	 * @throws WebServiceDataBaseException
	 */
	public boolean deleteContratOffre(int id) throws DataDeleteException,WebServiceDataBaseException;
	
	/**
	 * @return int
	 * @throws DataAddException 
	 * @throws WebServiceDataBaseException 
	 */
	public int addModeValidationStage(ModeValidationStageDTO mv) throws DataAddException, WebServiceDataBaseException;
	/**
	 * @return boolean
	 * @throws DataUpdateException 
	 * @throws WebServiceDataBaseException 
	 */
	public boolean updateModeValidationStage(ModeValidationStageDTO mv) throws DataUpdateException,WebServiceDataBaseException;
	/**
	 * @return boolean
	 * @throws DataDeleteException 
	 * @throws WebServiceDataBaseException
	 */
	public boolean deleteModeValidationStage(int id) throws DataDeleteException,WebServiceDataBaseException;
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
