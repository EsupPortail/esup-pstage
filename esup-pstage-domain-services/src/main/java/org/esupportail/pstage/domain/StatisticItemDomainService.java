package org.esupportail.pstage.domain;

import java.util.List;

import org.esupportail.pstagedata.domain.dto.StatisticItemDTO;

public interface StatisticItemDomainService {
	public List<StatisticItemDTO> getNumberOfConventionsByActivity(String idCenter, String year) ;
	public List<StatisticItemDTO> getNumberOfConventionsByStudy(String idCenter, String year) ;
	public List<StatisticItemDTO> getNumberOfConventionsByStudyAndType(String idCenter, String year) ;

	/**
	 * recupere les annees universitaires existant dans les conventions de ce centre de gestion
	 * @param idCenter
	 * @return
	 */
	public List<String> getYears(String idCenter) ;
	/**
	 * recupere le nombre de convention pour le centre specifie 
	 * @param idCenter : identifiant du centre de gestion
	 *  @return
	 */
	public List<StatisticItemDTO> getNumberOfConventions(String idCenter) ;

	/**
	 * recupere le nombre de convention par type de convention pour le centre specifie et l'annee universitaire
	 * @param idCenter : identifiant du centre de gestion
	 * @param year : annee universitaire
	 *  @return
	 */
	public List<StatisticItemDTO> getNumberOfConventionsByType(String idCenter, String year) ;
	/**
	 * recupere le nombre de convention par gratification pour le centre specifie et l'annee universitaire
	 * @param idCenter : identifiant du centre de gestion
	 * @param year : annee universitaire
	 *  @return
	 */
	public List<StatisticItemDTO> getNumberOfConventionsByIndemnity(String idCenter, String year) ;
	/**
	 * recupere le nombre de convention par teamps de travail pour le centre specifie et l'annee universitaire
	 * @param idCenter : identifiant du centre de gestion
	 * @param year : annee universitaire
	 *  @return
	 */
	public List<StatisticItemDTO> getNumberOfConventionsByWorkDuration(String idCenter, String year) ;
	/**
	 * recupere le nombre de convention par nb jours de travail par semaine pour le centre specifie et l'annee universitaire
	 * @param idCenter : identifiant du centre de gestion
	 * @param year : annee universitaire
	 *  @return
	 */
	public List<StatisticItemDTO> getNumberOfConventionsByNbDaysPerWeek(String idCenter, String year) ;

	/**
	 * recupere le nombre de convention par origine du stage pour le centre specifie et l'annee universitaire
	 * @param idCenter : identifiant du centre de gestion
	 * @param year : annee universitaire
	 *  @return
	 */
	public List<StatisticItemDTO> getNumberOfConventionsByWayToFind(String idCenter, String year) ;

	/**
	 * recupere le nombre de convention par enseignant pour le centre specifie et l'annee universitaire
	 * @param idCenter : identifiant du centre de gestion
	 * @param year : annee universitaire
	 *  @return
	 */
	public List<StatisticItemDTO> getNumberOfConventionsByTeacherGuide(String idCenter, String year) ;

	/**
	 * recupere le nombre de convention par structure pour le centre specifie et l'annee universitaire
	 * @param idCenter : identifiant du centre de gestion
	 * @param year : annee universitaire
	 *  @return
	 */
	public List<StatisticItemDTO> getNumberOfConventionsByStructure(String idCenter, String year) ;

	/**
	 * recupere le nombre de convention par type de structure pour le centre specifie et l'annee universitaire
	 * @param idCenter : identifiant du centre de gestion
	 * @param year : annee universitaire
	 *  @return
	 */
	public List<StatisticItemDTO> getNumberOfConventionsByStructureType(String idCenter, String year) ;

	/**
	 * recupere le nombre de convention par taille de structure pour le centre specifie et l'annee universitaire
	 * @param idCenter : identifiant du centre de gestion
	 * @param year : annee universitaire
	 *  @return
	 */
	public List<StatisticItemDTO> getNumberOfConventionsByStructureSize(String idCenter, String year) ;
	/**
	 * recupere le nombre de convention par department lieu de stage pour le centre specifie et l'annee universitaire
	 * @param idCenter : identifiant du centre de gestion
	 * @param year : annee universitaire
	 *  @return
	 */
	public List<StatisticItemDTO> getNumberOfConventionsByServiceDep(String idCenter, String year) ;

	/**
	 * recupere le nombre de convention par pays du lieu de stage pour le centre specifie et l'annee universitaire
	 * @param idCenter : identifiant du centre de gestion
	 * @param year : annee universitaire
	 *  @return
	 */
	public List<StatisticItemDTO> getNumberOfConventionsByServiceCountry(String idCenter, String year) ;

	/**
	 * recupere le nombre de convention par activite et UFR pour le centre specifie et l'annee universitaire
	 * @param idCenter : identifiant du centre de gestion
	 * @param year : annee universitaire
	 *  @return
	 */
	public List<StatisticItemDTO> getNumberOfConventionsByStudyAndActivity(String idCenter, String year) ;

	/**
	 * recupere le nombre de convention par UFR et gratification pour le centre specifie et l'annee universitaire
	 * @param idCenter : identifiant du centre de gestion
	 * @param year : annee universitaire
	 *  @return
	 */
	public List<StatisticItemDTO> getNumberOfConventionsByStudyAndIndemnity(String idCenter, String year) ;

	/**
	 * recupere le nombre de convention par UFR et duree de travail pour le centre specifie et l'annee universitaire
	 * @param idCenter : identifiant du centre de gestion
	 * @param year : annee universitaire
	 *  @return
	 */
	public List<StatisticItemDTO> getNumberOfConventionsByStudyAndWorkDuration(String idCenter, String year) ;

	/**
	 * recupere le nombre de convention par UFR et nb jours hebdo pour le centre specifie et l'annee universitaire
	 * @param idCenter : identifiant du centre de gestion
	 * @param year : annee universitaire
	 *  @return
	 */
	public List<StatisticItemDTO> getNumberOfConventionsByStudyAndNbDaysPerWeek(String idCenter, String year) ;


	/**
	 * recupere le nombre de convention par UFR et origine du stage pour le centre specifie et l'annee universitaire
	 * @param idCenter : identifiant du centre de gestion
	 * @param year : annee universitaire
	 *  @return
	 */
	public List<StatisticItemDTO> getNumberOfConventionsByStudyAndWayToFind(String idCenter, String year) ;

	/**
	 * recupere le nombre de convention par UFR et enseignant pour le centre specifie et l'annee universitaire
	 * @param idCenter : identifiant du centre de gestion
	 * @param year : annee universitaire
	 *  @return
	 */
	public List<StatisticItemDTO> getNumberOfConventionsByStudyAndTeacherGuide(String idCenter, String year) ;

	/**
	 * recupere le nombre de convention par UFR et structure pour le centre specifie et l'annee universitaire
	 * @param idCenter : identifiant du centre de gestion
	 * @param year : annee universitaire
	 *  @return
	 */
	public List<StatisticItemDTO> getNumberOfConventionsByStudyAndStructure(String idCenter, String year) ;


	/**
	 * recupere le nombre de convention par UFR et statut juridique structure pour le centre specifie et l'annee universitaire
	 * @param idCenter : identifiant du centre de gestion
	 * @param year : annee universitaire
	 *  @return
	 */
	public List<StatisticItemDTO> getNumberOfConventionsByStudyAndStructureType(String idCenter, String year) ;


	/**
	 * recupere le nombre de convention par UFR et taille structure pour le centre specifie et l'annee universitaire
	 * @param idCenter : identifiant du centre de gestion
	 * @param year : annee universitaire
	 *  @return
	 */
	public List<StatisticItemDTO> getNumberOfConventionsByStudyAndStructureSize(String idCenter, String year) ;

	/**
	 * recupere le nombre de convention par UFR et departement du lieu d'acccueil pour le centre specifie et l'annee universitaire
	 * @param idCenter : identifiant du centre de gestion
	 * @param year : annee universitaire
	 *  @return
	 */
	public List<StatisticItemDTO> getNumberOfConventionsByStudyAndServiceDep(String idCenter, String year) ;

	/**
	 * recupere le nombre de convention par UFR et pays du lieu d'acccueil pour le centre specifie et l'annee universitaire
	 * @param idCenter : identifiant du centre de gestion
	 * @param year : annee universitaire
	 *  @return
	 */
	public List<StatisticItemDTO> getNumberOfConventionsByStudyAndServiceCountry(String idCenter, String year) ;

	/**
	 * recupere le nombre de convention par  etape d'etude pour le centre specifie et l'annee universitaire
	 * @param idCenter : identifiant du centre de gestion
	 * @param year : annee universitaire
	 *  @return
	 */
	public List<StatisticItemDTO> getNumberOfConventionsByStep(String idCenter, String year) ;

	/**
	 * recupere le nombre de convention par  etape d'etude et type de stage pour le centre specifie et l'annee universitaire
	 * @param idCenter : identifiant du centre de gestion
	 * @param year : annee universitaire
	 *  @return
	 */

	public List<StatisticItemDTO> getNumberOfConventionsByStepAndType(String idCenter, String year) ;
	/**
	 * recupere le nombre de convention par domaine d'acitivite et par etape pour le centre specifie et l'annee universitaire
	 * @param idCenter : identifiant du centre de gestion
	 * @param year : annee universitaire
	 *  @return
	 */

	public List<StatisticItemDTO> getNumberOfConventionsByStepAndActivity(String idCenter, String year) ;
	/**
	 * recupere le nombre de convention par etape et par gratification pour le centre specifie et l'annee universitaire
	 * @param idCenter : identifiant du centre de gestion
	 * @param year : annee universitaire
	 *  @return
	 */

	public List<StatisticItemDTO> getNumberOfConventionsByStepAndIndemnity(String idCenter, String year) ;
	/**
	 * recupere le nombre de convention par etape et par temps de travail pour le centre specifie et l'annee universitaire
	 * @param idCenter : identifiant du centre de gestion
	 * @param year : annee universitaire
	 *  @return
	 */

	public List<StatisticItemDTO> getNumberOfConventionsByStepAndWorkDuration(String idCenter, String year) ;
	/**
	 * recupere le nombre de convention par etape et par nb jours hebdo pour le centre specifie et l'annee universitaire
	 * @param idCenter : identifiant du centre de gestion
	 * @param year : annee universitaire
	 *  @return
	 */

	public List<StatisticItemDTO> getNumberOfConventionsByStepAndNbDaysPerWeek(String idCenter, String year) ;
	/**
	 * recupere le nombre de convention par etape et par origine de stage pour le centre specifie et l'annee universitaire
	 * @param idCenter : identifiant du centre de gestion
	 * @param year : annee universitaire
	 *  @return
	 */

	public List<StatisticItemDTO> getNumberOfConventionsByStepAndWayToFind(String idCenter, String year) ;
	/**
	 * recupere le nombre de convention par etape et par enseignant pour le centre specifie et l'annee universitaire
	 * @param idCenter : identifiant du centre de gestion
	 * @param year : annee universitaire
	 *  @return
	 */

	public List<StatisticItemDTO> getNumberOfConventionsByStepAndTeacherGuide(String idCenter, String year) ;
	/**
	 * recupere le nombre de convention par etape et par etablissement d'accueil pour le centre specifie et l'annee universitaire
	 * @param idCenter : identifiant du centre de gestion
	 * @param year : annee universitaire
	 *  @return
	 */

	public List<StatisticItemDTO> getNumberOfConventionsByStepAndStructure(String idCenter, String year) ;
	/**
	 * recupere le nombre de convention par etape et par statut juridique de l'etablissement d'accueil pour le centre specifie et l'annee universitaire
	 * @param idCenter : identifiant du centre de gestion
	 * @param year : annee universitaire
	 *  @return
	 */

	public List<StatisticItemDTO> getNumberOfConventionsByStepAndStructureType(String idCenter, String year) ;
	/**
	 * recupere le nombre de convention par etape et par taille de l'etablissement d'accueil pour le centre specifie et l'annee universitaire
	 * @param idCenter : identifiant du centre de gestion
	 * @param year : annee universitaire
	 *  @return
	 */

	public List<StatisticItemDTO> getNumberOfConventionsByStepAndStructureSize(String idCenter, String year) ;
	/**
	 * recupere le nombre de convention par etape et par dep du lieu de stage pour le centre specifie et l'annee universitaire
	 * @param idCenter : identifiant du centre de gestion
	 * @param year : annee universitaire
	 *  @return
	 */

	public List<StatisticItemDTO> getNumberOfConventionsByStepAndServiceDep(String idCenter, String year) ;
	/**
	 * recupere le nombre de convention par etape et par pays du lieu de stage pour le centre specifie et l'annee universitaire
	 * @param idCenter : identifiant du centre de gestion
	 * @param year : annee universitaire
	 *  @return
	 */

	public List<StatisticItemDTO> getNumberOfConventionsByStepAndServiceCountry(String idCenter, String year) ;
	/**
	 * recupere le nombre de convention par  departement d'etude pour le centre specifie et l'annee universitaire
	 * @param idCenter : identifiant du centre de gestion
	 * @param year : annee universitaire
	 *  @return
	 */
	public List<StatisticItemDTO> getNumberOfConventionsByDepartment(String idCenter, String year) ;

	/**
	 * recupere le nombre de convention par  departement d'etude et type de stage pour le centre specifie et l'annee universitaire
	 * @param idCenter : identifiant du centre de gestion
	 * @param year : annee universitaire
	 *  @return
	 */

	public List<StatisticItemDTO> getNumberOfConventionsByDepartmentAndType(String idCenter, String year) ;
	/**
	 * recupere le nombre de convention par domaine d'acitivite et par departement pour le centre specifie et l'annee universitaire
	 * @param idCenter : identifiant du centre de gestion
	 * @param year : annee universitaire
	 *  @return
	 */

	public List<StatisticItemDTO> getNumberOfConventionsByDepartmentAndActivity(String idCenter, String year) ;
	/**
	 * recupere le nombre de convention par departement et par gratification pour le centre specifie et l'annee universitaire
	 * @param idCenter : identifiant du centre de gestion
	 * @param year : annee universitaire
	 *  @return
	 */

	public List<StatisticItemDTO> getNumberOfConventionsByDepartmentAndIndemnity(String idCenter, String year) ;
	/**
	 * recupere le nombre de convention par departement et par temps de travail pour le centre specifie et l'annee universitaire
	 * @param idCenter : identifiant du centre de gestion
	 * @param year : annee universitaire
	 *  @return
	 */

	public List<StatisticItemDTO> getNumberOfConventionsByDepartmentAndWorkDuration(String idCenter, String year) ;
	/**
	 * recupere le nombre de convention par departement et par nb jours hebdo pour le centre specifie et l'annee universitaire
	 * @param idCenter : identifiant du centre de gestion
	 * @param year : annee universitaire
	 *  @return
	 */

	public List<StatisticItemDTO> getNumberOfConventionsByDepartmentAndNbDaysPerWeek(String idCenter, String year) ;
	/**
	 * recupere le nombre de convention par departement et par origine de stage pour le centre specifie et l'annee universitaire
	 * @param idCenter : identifiant du centre de gestion
	 * @param year : annee universitaire
	 *  @return
	 */

	public List<StatisticItemDTO> getNumberOfConventionsByDepartmentAndWayToFind(String idCenter, String year) ;
	/**
	 * recupere le nombre de convention par departement et par enseignant pour le centre specifie et l'annee universitaire
	 * @param idCenter : identifiant du centre de gestion
	 * @param year : annee universitaire
	 *  @return
	 */

	public List<StatisticItemDTO> getNumberOfConventionsByDepartmentAndTeacherGuide(String idCenter, String year) ;
	/**
	 * recupere le nombre de convention par departement et par etablissement d'accueil pour le centre specifie et l'annee universitaire
	 * @param idCenter : identifiant du centre de gestion
	 * @param year : annee universitaire
	 *  @return
	 */

	public List<StatisticItemDTO> getNumberOfConventionsByDepartmentAndStructure(String idCenter, String year) ;
	/**
	 * recupere le nombre de convention par departement et par statut juridique de l'etablissement d'accueil pour le centre specifie et l'annee universitaire
	 * @param idCenter : identifiant du centre de gestion
	 * @param year : annee universitaire
	 *  @return
	 */

	public List<StatisticItemDTO> getNumberOfConventionsByDepartmentAndStructureType(String idCenter, String year) ;
	/**
	 * recupere le nombre de convention par departement et par taille de l'etablissement d'accueil pour le centre specifie et l'annee universitaire
	 * @param idCenter : identifiant du centre de gestion
	 * @param year : annee universitaire
	 *  @return
	 */

	public List<StatisticItemDTO> getNumberOfConventionsByDepartmentAndStructureSize(String idCenter, String year) ;
	/**
	 * recupere le nombre de convention par departement et par dep du lieu de stage pour le centre specifie et l'annee universitaire
	 * @param idCenter : identifiant du centre de gestion
	 * @param year : annee universitaire
	 *  @return
	 */

	public List<StatisticItemDTO> getNumberOfConventionsByDepartmentAndServiceDep(String idCenter, String year) ;
	/**
	 * recupere le nombre de convention par departement et par pays du lieu de stage pour le centre specifie et l'annee universitaire
	 * @param idCenter : identifiant du centre de gestion
	 * @param year : annee universitaire
	 *  @return
	 */

	public List<StatisticItemDTO> getNumberOfConventionsByDepartmentAndServiceCountry(String idCenter, String year) ;
	/**
	 * recupere le nombre de convention par thematique du stage pour le centre specifie et l'annee universitaire
	 * @param idCenter : identifiant du centre de gestion
	 * @param year : annee universitaire
	 *  @return
	 */

	public List<StatisticItemDTO> getNumberOfConventionsByTheme(String idCenter, String year) ;
	/**
	 * recupere le nombre de convention par UFR et thematique du stage pour le centre specifie et l'annee universitaire
	 * @param idCenter : identifiant du centre de gestion
	 * @param year : annee universitaire
	 *  @return
	 */

	public List<StatisticItemDTO> getNumberOfConventionsByStudyAndTheme(String idCenter, String year) ;

	/**
	 * recupere le nombre de convention par departement et thematique du stage pour le centre specifie et l'annee universitaire
	 * @param idCenter : identifiant du centre de gestion
	 * @param year : annee universitaire
	 *  @return
	 */

	public List<StatisticItemDTO> getNumberOfConventionsByDepartmentAndTheme(String idCenter, String year) ;

	/**
	 * recupere le nombre de convention par etape d'etude et thematique du stage pour le centre specifie et l'annee universitaire
	 * @param idCenter : identifiant du centre de gestion
	 * @param year : annee universitaire
	 *  @return
	 */

	public List<StatisticItemDTO> getNumberOfConventionsByStepAndTheme(String idCenter, String year) ;
	/**
	 * recupere le nombre d'offres pour le centre specifie et  par annee universitaire
	 * @param idCenter : identifiant du centre de gestion
	 *  @return
	 */
	public List<StatisticItemDTO> getNumberOfOffers(String idCenter) ;

	/**
	 * recupere les annees existant dans les offres de ce centre de gestion
	 * @param idCenter
	 * @return
	 */
	public List<String> getOfferYears(String idCenter) ;

	/**
	 * recupere le nombre d'offres par activite de l'etablisssment, par annee universitaire, par validation et diffusion
	 * @param idCenter : identifiant du centre de gestion
	 * @param year : annee universitaire
	 * @param validation 
	 * @param publication
	 *  @return
	 */
	public List<StatisticItemDTO> getNumberOfOffersByActivity(String idCenter, String year, boolean validation, boolean publication);

	/**
	 * recupere le nombre d'offres par etablisssment, par annee universitaire, par validation et diffusion
	 * @param idCenter : identifiant du centre de gestion
	 * @param year : annee universitaire
	 * @param validation 
	 * @param publication
	 *  @return
	 */
	public List<StatisticItemDTO> getNumberOfOffersByStructure(String idCenter, String year, boolean validation, boolean publication);


	/**
	 * recupere le nombre d'offres par statut juridique etablisssment, par annee universitaire, par validation et diffusion
	 * @param idCenter : identifiant du centre de gestion
	 * @param year : annee universitaire
	 * @param validation 
	 * @param publication
	 *  @return
	 */
	public List<StatisticItemDTO> getNumberOfOffersByStructureType(String idCenter, String year, boolean validation, boolean publication);


	/**
	 * recupere le nombre d'offres par taille etablisssment, par annee universitaire, par validation et diffusion
	 * @param idCenter : identifiant du centre de gestion
	 * @param year : annee universitaire
	 * @param validation 
	 * @param publication
	 *  @return
	 */
	public List<StatisticItemDTO> getNumberOfOffersByStructureSize(String idCenter, String year, boolean validation, boolean publication);


	/**
	 * recupere le nombre d'offres par departement etablisssment, par annee universitaire, par validation et diffusion
	 * @param idCenter : identifiant du centre de gestion
	 * @param year : annee universitaire
	 * @param validation 
	 * @param publication
	 *  @return
	 */
	public List<StatisticItemDTO> getNumberOfOffersByStructureDep(String idCenter, String year, boolean validation, boolean publication);


	/**
	 * recupere le nombre d'offres par pays etablisssment, par annee universitaire, par validation et diffusion
	 * @param idCenter : identifiant du centre de gestion
	 * @param year : annee universitaire
	 * @param validation 
	 * @param publication
	 *  @return
	 */
	public List<StatisticItemDTO> getNumberOfOffersByStructureCountry(String idCenter, String year, boolean validation, boolean publication);
	/**
	 * recupere le nombre d'offres par fonction, par validation et diffusion
	 * @param idCenter : identifiant du centre de gestion
	 * @param year : annee universitaire
	 * @param validation 
	 * @param publication
	 *  @return
	 */
	public List<StatisticItemDTO> getNumberOfOffersByFunction(String idCenter, String year, boolean validation, boolean publication);

	/**
	 * recupere le nombre d'offres par formation, par validation et diffusion
	 * @param idCenter : identifiant du centre de gestion
	 * @param year : annee universitaire
	 * @param validation 
	 * @param publication
	 *  @return
	 */
	public List<StatisticItemDTO> getNumberOfOffersByFormation(String idCenter, String year, boolean validation, boolean publication);

	/**
	 * recupere le nombre d'offres par niveau de formation, par validation et diffusion
	 * @param idCenter : identifiant du centre de gestion
	 * @param year : annee universitaire
	 * @param validation 
	 * @param publication
	 *  @return
	 */
	public List<StatisticItemDTO> getNumberOfOffersByLevel(String idCenter, String year, boolean validation, boolean publication);

	/**
	 * recupere le nombre d'offres par type d'offre, par validation et diffusion
	 * @param idCenter : identifiant du centre de gestion
	 * @param year : annee universitaire
	 * @param validation 
	 * @param publication
	 *  @return
	 */
	public List<StatisticItemDTO> getNumberOfOffersByType(String idCenter, String year, boolean validation, boolean publication);


	/** recupere le nombre d'offres par validation
	 * @param idCenter : identifiant du centre de gestion
	 * @param year : annee universitaire
	 *  @return
	 */
	public List<StatisticItemDTO> getNumberOfOffersByValidation(String idCenter, String year);

	/** recupere le nombre d'offres par publication
	 * @param idCenter : identifiant du centre de gestion
	 * @param year : annee universitaire
	 *  @return
	 */
	public List<StatisticItemDTO> getNumberOfOffersByPublication(String idCenter, String year);

	/**
	 * recupere le nombre d'offres par designation d'un candidat (offre pourvue ou non), par validation et diffusion
	 * @param idCenter : identifiant du centre de gestion
	 * @param year : annee universitaire
	 * @param validation 
	 * @param publication
	 *  @return
	 */
	public List<StatisticItemDTO> getNumberOfOffersByCandidateFound(String idCenter, String year, boolean validation, boolean publication);

	/**
	 * recupere le nombre d'offres par origine du candidat (etudiant local ou non), par validation et diffusion
	 * @param idCenter : identifiant du centre de gestion
	 * @param year : annee universitaire
	 * @param validation 
	 * @param publication
	 *  @return
	 */
	public List<StatisticItemDTO> getNumberOfOffersByLocalStudent(String idCenter, String year, boolean validation, boolean publication);

}
