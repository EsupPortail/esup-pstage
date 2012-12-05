package org.esupportail.pstage.domain.referentiel;

import java.io.Serializable;
import java.util.List;

import org.esupportail.pstage.exceptions.StatistiquesException;
import org.esupportail.pstagedata.remote.CritereDTO;
import org.esupportail.pstagedata.remote.StatisticItemDTO;

public interface StatistiquesDomainService extends Serializable {
	
	public List<CritereDTO> getCriteresPremierNiveauPrConvention()throws StatistiquesException;
	public List<CritereDTO>  getCriteresSecondNiveauPrConvention();
	public List<CritereDTO> getCriteresPremierNiveauPrOffres()throws StatistiquesException;
	public List<CritereDTO> getCriteresSecondNiveauPrOffres()throws StatistiquesException;
	public List<String> getAnneesConventions(Integer idCentreGestion, String etab)throws StatistiquesException;
	public List<String> getAnneesOffres(Integer idCentreGestion, String etat)throws StatistiquesException;
	
	//CONVENTIONS

	public List<StatisticItemDTO> getNumberOfConventions(Integer idCenter, String etab)throws StatistiquesException;
	public List<StatisticItemDTO> getNumberOfConventionsByType(Integer idCenter, String year, String etab)throws StatistiquesException;
    public List<StatisticItemDTO> getNumberOfConventionsByTheme(Integer idCenter, String year, String etab)throws StatistiquesException;
    public List<StatisticItemDTO> getNumberOfConventionsByIndemnity(Integer idCenter, String year, String etab)throws StatistiquesException;
    public List<StatisticItemDTO> getNumberOfConventionsByWorkDuration(Integer idCenter, String year, String etab)throws StatistiquesException;
    public List<StatisticItemDTO> getNumberOfConventionsByNbDaysPerWeek(Integer idCenter, String year, String etab)throws StatistiquesException;
    public List<StatisticItemDTO> getNumberOfConventionsByWayToFind(Integer idCenter, String year, String etab)throws StatistiquesException;
    public List<StatisticItemDTO> getNumberOfConventionsByTeacherGuide(Integer idCenter, String year, String etab)throws StatistiquesException;
    public List<StatisticItemDTO> getNumberOfConventionsByStructure(Integer idCenter, String year, String etab)throws StatistiquesException;
    public List<StatisticItemDTO> getNumberOfConventionsByStructureActivity(Integer idCenter, String year, String etab)throws StatistiquesException;
    public List<StatisticItemDTO> getNumberOfConventionsByStructureType(Integer idCenter, String year, String etab)throws StatistiquesException;
    public List<StatisticItemDTO> getNumberOfConventionsByStructureSize(Integer idCenter, String year, String etab)throws StatistiquesException;
    public List<StatisticItemDTO> getNumberOfConventionsByServiceDep(Integer idCenter, String year, String etab)throws StatistiquesException;
    public List<StatisticItemDTO> getNumberOfConventionsByServiceCountry(Integer idCenter, String year, String etab)throws StatistiquesException;
    
    public List<StatisticItemDTO> getNumberOfConventionsByStudy(Integer idCenter, String year, String etab)throws StatistiquesException;
	public List<StatisticItemDTO> getNumberOfConventionsByStudyAndType(Integer idCenter, String year, String etab)throws StatistiquesException;
    public List<StatisticItemDTO> getNumberOfConventionsByStudyAndIndemnity(Integer idCenter, String year, String etab)throws StatistiquesException;
    public List<StatisticItemDTO> getNumberOfConventionsByStudyAndWorkDuration(Integer idCenter, String year, String etab)throws StatistiquesException;
    public List<StatisticItemDTO> getNumberOfConventionsByStudyAndNbDaysPerWeek(Integer idCenter, String year, String etab)throws StatistiquesException;
    public List<StatisticItemDTO> getNumberOfConventionsByStudyAndWayToFind(Integer idCenter, String year, String etab)throws StatistiquesException;
    public List<StatisticItemDTO> getNumberOfConventionsByStudyAndTeacherGuide(Integer idCenter, String year, String etab)throws StatistiquesException;
    public List<StatisticItemDTO> getNumberOfConventionsByStudyAndStructure(Integer idCenter, String year, String etab)throws StatistiquesException;
    public List<StatisticItemDTO> getNumberOfConventionsByStudyAndActivity(Integer idCenter, String year, String etab)throws StatistiquesException;
    public List<StatisticItemDTO> getNumberOfConventionsByStudyAndStructureType(Integer idCenter, String year, String etab)throws StatistiquesException;
    public List<StatisticItemDTO> getNumberOfConventionsByStudyAndStructureSize(Integer idCenter, String year, String etab)throws StatistiquesException;
    public List<StatisticItemDTO> getNumberOfConventionsByStudyAndServiceDep(Integer idCenter, String year, String etab)throws StatistiquesException;
    public List<StatisticItemDTO> getNumberOfConventionsByStudyAndServiceCountry(Integer idCenter, String year, String etab)throws StatistiquesException;
    public List<StatisticItemDTO> getNumberOfConventionsByStudyAndTheme(Integer idCenter, String year, String etab)throws StatistiquesException;

    public List<StatisticItemDTO> getNumberOfConventionsByDepartment(Integer idCenter, String year, String etab)throws StatistiquesException;
	public List<StatisticItemDTO> getNumberOfConventionsByDepartmentAndType(Integer idCenter, String year, String etab)throws StatistiquesException;
    public List<StatisticItemDTO> getNumberOfConventionsByDepartmentAndActivity(Integer idCenter, String year, String etab)throws StatistiquesException;
    public List<StatisticItemDTO> getNumberOfConventionsByDepartmentAndIndemnity(Integer idCenter, String year, String etab)throws StatistiquesException;
    public List<StatisticItemDTO> getNumberOfConventionsByDepartmentAndWorkDuration(Integer idCenter, String year, String etab)throws StatistiquesException;
    public List<StatisticItemDTO> getNumberOfConventionsByDepartmentAndNbDaysPerWeek(Integer idCenter, String year, String etab)throws StatistiquesException;
    public List<StatisticItemDTO> getNumberOfConventionsByDepartmentAndWayToFind(Integer idCenter, String year, String etab)throws StatistiquesException;
    public List<StatisticItemDTO> getNumberOfConventionsByDepartmentAndTeacherGuide(Integer idCenter, String year, String etab)throws StatistiquesException;
    public List<StatisticItemDTO> getNumberOfConventionsByDepartmentAndStructure(Integer idCenter, String year, String etab)throws StatistiquesException;
    public List<StatisticItemDTO> getNumberOfConventionsByDepartmentAndStructureType(Integer idCenter, String year, String etab)throws StatistiquesException;
    public List<StatisticItemDTO> getNumberOfConventionsByDepartmentAndStructureSize(Integer idCenter, String year, String etab)throws StatistiquesException;
    public List<StatisticItemDTO> getNumberOfConventionsByDepartmentAndServiceDep(Integer idCenter, String year, String etab)throws StatistiquesException;
    public List<StatisticItemDTO> getNumberOfConventionsByDepartmentAndServiceCountry(Integer idCenter, String year, String etab)throws StatistiquesException;
    public List<StatisticItemDTO> getNumberOfConventionsByDepartmentAndTheme(Integer idCenter, String year, String etab)throws StatistiquesException;

    public List<StatisticItemDTO> getNumberOfConventionsByStep(Integer idCenter, String year, String etab)throws StatistiquesException;
	public List<StatisticItemDTO> getNumberOfConventionsByStepAndType(Integer idCenter, String year, String etab)throws StatistiquesException;
    public List<StatisticItemDTO> getNumberOfConventionsByStepAndActivity(Integer idCenter, String year, String etab)throws StatistiquesException;
    public List<StatisticItemDTO> getNumberOfConventionsByStepAndIndemnity(Integer idCenter, String year, String etab)throws StatistiquesException;
    public List<StatisticItemDTO> getNumberOfConventionsByStepAndWorkDuration(Integer idCenter, String year, String etab)throws StatistiquesException;
    public List<StatisticItemDTO> getNumberOfConventionsByStepAndNbDaysPerWeek(Integer idCenter, String year, String etab)throws StatistiquesException;
    public List<StatisticItemDTO> getNumberOfConventionsByStepAndWayToFind(Integer idCenter, String year, String etab)throws StatistiquesException;
    public List<StatisticItemDTO> getNumberOfConventionsByStepAndTeacherGuide(Integer idCenter, String year, String etab)throws StatistiquesException;
    public List<StatisticItemDTO> getNumberOfConventionsByStepAndStructure(Integer idCenter, String year, String etab)throws StatistiquesException;
    public List<StatisticItemDTO> getNumberOfConventionsByStepAndStructureType(Integer idCenter, String year, String etab)throws StatistiquesException;
    public List<StatisticItemDTO> getNumberOfConventionsByStepAndStructureSize(Integer idCenter, String year, String etab)throws StatistiquesException;
    public List<StatisticItemDTO> getNumberOfConventionsByStepAndServiceDep(Integer idCenter, String year, String etab)throws StatistiquesException;
    public List<StatisticItemDTO> getNumberOfConventionsByStepAndServiceCountry(Integer idCenter, String year, String etab)throws StatistiquesException;
    public List<StatisticItemDTO> getNumberOfConventionsByStepAndTheme(Integer idCenter, String year, String etab)throws StatistiquesException;

    //OFFRES
    
  public List<StatisticItemDTO> getNumberOfOffers(Integer idCenter, String etab) throws StatistiquesException;
  public List<StatisticItemDTO> getNumberOfOffersByActivity(Integer idCenter, String year, String etab, boolean validation, boolean publication) throws StatistiquesException;
  public List<StatisticItemDTO> getNumberOfOffersByStructure(Integer idCenter, String year, String etab, boolean validation, boolean publication) throws StatistiquesException;
  public List<StatisticItemDTO> getNumberOfOffersByStructureType(Integer idCenter, String year, String etab, boolean validation, boolean publication) throws StatistiquesException;
  public List<StatisticItemDTO> getNumberOfOffersByStructureSize(Integer idCenter, String year, String etab, boolean validation, boolean publication) throws StatistiquesException;
  public List<StatisticItemDTO> getNumberOfOffersByStructureDep(Integer idCenter, String year, String etab, boolean validation, boolean publication) throws StatistiquesException;
  public List<StatisticItemDTO> getNumberOfOffersByStructureCountry(Integer idCenter, String year, String etab, boolean validation, boolean publication) throws StatistiquesException;
  public List<StatisticItemDTO> getNumberOfOffersByFunction(Integer idCenter, String year, String etab, boolean validation, boolean publication) throws StatistiquesException;
  public List<StatisticItemDTO> getNumberOfOffersByFormation(Integer idCenter, String year, String etab, boolean validation, boolean publication) throws StatistiquesException;
  public List<StatisticItemDTO> getNumberOfOffersByLevel(Integer idCenter, String year, String etab, boolean validation, boolean publication) throws StatistiquesException;
  public List<StatisticItemDTO> getNumberOfOffersByType(Integer idCenter, String year, String etab, boolean validation, boolean publication) throws StatistiquesException;
  public List<StatisticItemDTO> getNumberOfOffersByValidation(Integer idCenter, String year, String etab) throws StatistiquesException;
  public List<StatisticItemDTO> getNumberOfOffersByPublication(Integer idCenter, String year, String etab) throws StatistiquesException;
  public List<StatisticItemDTO> getNumberOfOffersByCandidateFound(Integer idCenter, String year, String etab, boolean validation, boolean publication) throws StatistiquesException;
  public List<StatisticItemDTO> getNumberOfOffersByLocalStudent(Integer idCenter, String year, String etab, boolean validation, boolean publication) throws StatistiquesException;
    
}
