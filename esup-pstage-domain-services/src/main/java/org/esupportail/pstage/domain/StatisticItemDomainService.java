package org.esupportail.pstage.domain;

import java.util.List;

public interface StatisticItemDomainService {
	    public List<StatisticItem> getNumberOfConventionsByActivity(String idCenter, String year) ;
	    public List<StatisticItem> getNumberOfConventionsByStudy(String idCenter, String year) ;
	    public List<StatisticItem> getNumberOfConventionsByStudyAndType(String idCenter, String year) ;
	   
	    
	    
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
	    public List<StatisticItem> getNumberOfConventions(String idCenter) ;
	   
	    /**
	     * recupere le nombre de convention par type de convention pour le centre specifie et l'annee universitaire
	     * @param idCenter : identifiant du centre de gestion
	     * @param year : annee universitaire
	     *  @return
	     */
	    public List<StatisticItem> getNumberOfConventionsByType(String idCenter, String year) ;
	    /**
	     * recupere le nombre de convention par gratification pour le centre specifie et l'annee universitaire
	     * @param idCenter : identifiant du centre de gestion
	     * @param year : annee universitaire
	     *  @return
	     */
	    public List<StatisticItem> getNumberOfConventionsByIndemnity(String idCenter, String year) ;
	    /**
	     * recupere le nombre de convention par teamps de travail pour le centre specifie et l'annee universitaire
	     * @param idCenter : identifiant du centre de gestion
	     * @param year : annee universitaire
	     *  @return
	     */
	    public List<StatisticItem> getNumberOfConventionsByWorkDuration(String idCenter, String year) ;
	    /**
	     * recupere le nombre de convention par nb jours de travail par semaine pour le centre specifie et l'annee universitaire
	     * @param idCenter : identifiant du centre de gestion
	     * @param year : annee universitaire
	     *  @return
	     */
	    public List<StatisticItem> getNumberOfConventionsByNbDaysPerWeek(String idCenter, String year) ;
	
	    /**
	     * recupere le nombre de convention par origine du stage pour le centre specifie et l'annee universitaire
	     * @param idCenter : identifiant du centre de gestion
	     * @param year : annee universitaire
	     *  @return
	     */
	    public List<StatisticItem> getNumberOfConventionsByWayToFind(String idCenter, String year) ;

	    /**
	     * recupere le nombre de convention par enseignant pour le centre specifie et l'annee universitaire
	     * @param idCenter : identifiant du centre de gestion
	     * @param year : annee universitaire
	     *  @return
	     */
	    public List<StatisticItem> getNumberOfConventionsByTeacherGuide(String idCenter, String year) ;

	    /**
	     * recupere le nombre de convention par structure pour le centre specifie et l'annee universitaire
	     * @param idCenter : identifiant du centre de gestion
	     * @param year : annee universitaire
	     *  @return
	     */
	    public List<StatisticItem> getNumberOfConventionsByStructure(String idCenter, String year) ;
  
	    /**
	     * recupere le nombre de convention par type de structure pour le centre specifie et l'annee universitaire
	     * @param idCenter : identifiant du centre de gestion
	     * @param year : annee universitaire
	     *  @return
	     */
	    public List<StatisticItem> getNumberOfConventionsByStructureType(String idCenter, String year) ;
 
	    /**
	     * recupere le nombre de convention par taille de structure pour le centre specifie et l'annee universitaire
	     * @param idCenter : identifiant du centre de gestion
	     * @param year : annee universitaire
	     *  @return
	     */
	    public List<StatisticItem> getNumberOfConventionsByStructureSize(String idCenter, String year) ;
	    /**
	     * recupere le nombre de convention par department lieu de stage pour le centre specifie et l'annee universitaire
	     * @param idCenter : identifiant du centre de gestion
	     * @param year : annee universitaire
	     *  @return
	     */
	    public List<StatisticItem> getNumberOfConventionsByServiceDep(String idCenter, String year) ;
 
	    /**
	     * recupere le nombre de convention par pays du lieu de stage pour le centre specifie et l'annee universitaire
	     * @param idCenter : identifiant du centre de gestion
	     * @param year : annee universitaire
	     *  @return
	     */
	    public List<StatisticItem> getNumberOfConventionsByServiceCountry(String idCenter, String year) ;
 
	    /**
	     * recupere le nombre de convention par activite et UFR pour le centre specifie et l'annee universitaire
	     * @param idCenter : identifiant du centre de gestion
	     * @param year : annee universitaire
	     *  @return
	     */
	    public List<StatisticItem> getNumberOfConventionsByStudyAndActivity(String idCenter, String year) ;

	    /**
	     * recupere le nombre de convention par UFR et gratification pour le centre specifie et l'annee universitaire
	     * @param idCenter : identifiant du centre de gestion
	     * @param year : annee universitaire
	     *  @return
	     */
	    public List<StatisticItem> getNumberOfConventionsByStudyAndIndemnity(String idCenter, String year) ;

	    /**
	     * recupere le nombre de convention par UFR et duree de travail pour le centre specifie et l'annee universitaire
	     * @param idCenter : identifiant du centre de gestion
	     * @param year : annee universitaire
	     *  @return
	     */
	    public List<StatisticItem> getNumberOfConventionsByStudyAndWorkDuration(String idCenter, String year) ;

	    /**
	     * recupere le nombre de convention par UFR et nb jours hebdo pour le centre specifie et l'annee universitaire
	     * @param idCenter : identifiant du centre de gestion
	     * @param year : annee universitaire
	     *  @return
	     */
	    public List<StatisticItem> getNumberOfConventionsByStudyAndNbDaysPerWeek(String idCenter, String year) ;

	    
	    /**
	     * recupere le nombre de convention par UFR et origine du stage pour le centre specifie et l'annee universitaire
	     * @param idCenter : identifiant du centre de gestion
	     * @param year : annee universitaire
	     *  @return
	     */
	    public List<StatisticItem> getNumberOfConventionsByStudyAndWayToFind(String idCenter, String year) ;

	    /**
	     * recupere le nombre de convention par UFR et enseignant pour le centre specifie et l'annee universitaire
	     * @param idCenter : identifiant du centre de gestion
	     * @param year : annee universitaire
	     *  @return
	     */
	    public List<StatisticItem> getNumberOfConventionsByStudyAndTeacherGuide(String idCenter, String year) ;

	    /**
	     * recupere le nombre de convention par UFR et structure pour le centre specifie et l'annee universitaire
	     * @param idCenter : identifiant du centre de gestion
	     * @param year : annee universitaire
	     *  @return
	     */
	    public List<StatisticItem> getNumberOfConventionsByStudyAndStructure(String idCenter, String year) ;

	    
	    /**
	     * recupere le nombre de convention par UFR et statut juridique structure pour le centre specifie et l'annee universitaire
	     * @param idCenter : identifiant du centre de gestion
	     * @param year : annee universitaire
	     *  @return
	     */
	    public List<StatisticItem> getNumberOfConventionsByStudyAndStructureType(String idCenter, String year) ;

	    
	    /**
	     * recupere le nombre de convention par UFR et taille structure pour le centre specifie et l'annee universitaire
	     * @param idCenter : identifiant du centre de gestion
	     * @param year : annee universitaire
	     *  @return
	     */
	    public List<StatisticItem> getNumberOfConventionsByStudyAndStructureSize(String idCenter, String year) ;

	    /**
	     * recupere le nombre de convention par UFR et departement du lieu d'acccueil pour le centre specifie et l'annee universitaire
	     * @param idCenter : identifiant du centre de gestion
	     * @param year : annee universitaire
	     *  @return
	     */
	    public List<StatisticItem> getNumberOfConventionsByStudyAndServiceDep(String idCenter, String year) ;
	    
	    /**
	     * recupere le nombre de convention par UFR et pays du lieu d'acccueil pour le centre specifie et l'annee universitaire
	     * @param idCenter : identifiant du centre de gestion
	     * @param year : annee universitaire
	     *  @return
	     */
	    public List<StatisticItem> getNumberOfConventionsByStudyAndServiceCountry(String idCenter, String year) ;

	    /**
	     * recupere le nombre de convention par  etape d'etude pour le centre specifie et l'annee universitaire
	     * @param idCenter : identifiant du centre de gestion
	     * @param year : annee universitaire
	     *  @return
	     */
	   public List<StatisticItem> getNumberOfConventionsByStep(String idCenter, String year) ;
	
	   /**
	     * recupere le nombre de convention par  etape d'etude et type de stage pour le centre specifie et l'annee universitaire
	     * @param idCenter : identifiant du centre de gestion
	     * @param year : annee universitaire
	     *  @return
	     */
	   
	   public List<StatisticItem> getNumberOfConventionsByStepAndType(String idCenter, String year) ;
	/**
	     * recupere le nombre de convention par domaine d'acitivite et par etape pour le centre specifie et l'annee universitaire
	     * @param idCenter : identifiant du centre de gestion
	     * @param year : annee universitaire
	     *  @return
	     */
	
	  public List<StatisticItem> getNumberOfConventionsByStepAndActivity(String idCenter, String year) ;
	/**
	     * recupere le nombre de convention par etape et par gratification pour le centre specifie et l'annee universitaire
	     * @param idCenter : identifiant du centre de gestion
	     * @param year : annee universitaire
	     *  @return
	     */
	
	  public List<StatisticItem> getNumberOfConventionsByStepAndIndemnity(String idCenter, String year) ;
	/**
	     * recupere le nombre de convention par etape et par temps de travail pour le centre specifie et l'annee universitaire
	     * @param idCenter : identifiant du centre de gestion
	     * @param year : annee universitaire
	     *  @return
	     */
	
	  public List<StatisticItem> getNumberOfConventionsByStepAndWorkDuration(String idCenter, String year) ;
	/**
	     * recupere le nombre de convention par etape et par nb jours hebdo pour le centre specifie et l'annee universitaire
	     * @param idCenter : identifiant du centre de gestion
	     * @param year : annee universitaire
	     *  @return
	     */
	
	  public List<StatisticItem> getNumberOfConventionsByStepAndNbDaysPerWeek(String idCenter, String year) ;
	/**
	     * recupere le nombre de convention par etape et par origine de stage pour le centre specifie et l'annee universitaire
	     * @param idCenter : identifiant du centre de gestion
	     * @param year : annee universitaire
	     *  @return
	     */
	
	  public List<StatisticItem> getNumberOfConventionsByStepAndWayToFind(String idCenter, String year) ;
	/**
	     * recupere le nombre de convention par etape et par enseignant pour le centre specifie et l'annee universitaire
	     * @param idCenter : identifiant du centre de gestion
	     * @param year : annee universitaire
	     *  @return
	     */
	
	  public List<StatisticItem> getNumberOfConventionsByStepAndTeacherGuide(String idCenter, String year) ;
	/**
	     * recupere le nombre de convention par etape et par etablissement d'accueil pour le centre specifie et l'annee universitaire
	     * @param idCenter : identifiant du centre de gestion
	     * @param year : annee universitaire
	     *  @return
	     */
	
	  public List<StatisticItem> getNumberOfConventionsByStepAndStructure(String idCenter, String year) ;
	/**
	     * recupere le nombre de convention par etape et par statut juridique de l'etablissement d'accueil pour le centre specifie et l'annee universitaire
	     * @param idCenter : identifiant du centre de gestion
	     * @param year : annee universitaire
	     *  @return
	     */
	
	  public List<StatisticItem> getNumberOfConventionsByStepAndStructureType(String idCenter, String year) ;
	/**
	     * recupere le nombre de convention par etape et par taille de l'etablissement d'accueil pour le centre specifie et l'annee universitaire
	     * @param idCenter : identifiant du centre de gestion
	     * @param year : annee universitaire
	     *  @return
	     */
	
	  public List<StatisticItem> getNumberOfConventionsByStepAndStructureSize(String idCenter, String year) ;
	/**
	     * recupere le nombre de convention par etape et par dep du lieu de stage pour le centre specifie et l'annee universitaire
	     * @param idCenter : identifiant du centre de gestion
	     * @param year : annee universitaire
	     *  @return
	     */
	
	  public List<StatisticItem> getNumberOfConventionsByStepAndServiceDep(String idCenter, String year) ;
	/**
	     * recupere le nombre de convention par etape et par pays du lieu de stage pour le centre specifie et l'annee universitaire
	     * @param idCenter : identifiant du centre de gestion
	     * @param year : annee universitaire
	     *  @return
	     */
	
	  public List<StatisticItem> getNumberOfConventionsByStepAndServiceCountry(String idCenter, String year) ;
	  /**
	     * recupere le nombre de convention par  departement d'etude pour le centre specifie et l'annee universitaire
	     * @param idCenter : identifiant du centre de gestion
	     * @param year : annee universitaire
	     *  @return
	     */
	   public List<StatisticItem> getNumberOfConventionsByDepartment(String idCenter, String year) ;
	
	   /**
	     * recupere le nombre de convention par  departement d'etude et type de stage pour le centre specifie et l'annee universitaire
	     * @param idCenter : identifiant du centre de gestion
	     * @param year : annee universitaire
	     *  @return
	     */
	   
	   public List<StatisticItem> getNumberOfConventionsByDepartmentAndType(String idCenter, String year) ;
	/**
	     * recupere le nombre de convention par domaine d'acitivite et par departement pour le centre specifie et l'annee universitaire
	     * @param idCenter : identifiant du centre de gestion
	     * @param year : annee universitaire
	     *  @return
	     */
	
	  public List<StatisticItem> getNumberOfConventionsByDepartmentAndActivity(String idCenter, String year) ;
	/**
	     * recupere le nombre de convention par departement et par gratification pour le centre specifie et l'annee universitaire
	     * @param idCenter : identifiant du centre de gestion
	     * @param year : annee universitaire
	     *  @return
	     */
	
	  public List<StatisticItem> getNumberOfConventionsByDepartmentAndIndemnity(String idCenter, String year) ;
	/**
	     * recupere le nombre de convention par departement et par temps de travail pour le centre specifie et l'annee universitaire
	     * @param idCenter : identifiant du centre de gestion
	     * @param year : annee universitaire
	     *  @return
	     */
	
	  public List<StatisticItem> getNumberOfConventionsByDepartmentAndWorkDuration(String idCenter, String year) ;
	/**
	     * recupere le nombre de convention par departement et par nb jours hebdo pour le centre specifie et l'annee universitaire
	     * @param idCenter : identifiant du centre de gestion
	     * @param year : annee universitaire
	     *  @return
	     */
	
	  public List<StatisticItem> getNumberOfConventionsByDepartmentAndNbDaysPerWeek(String idCenter, String year) ;
	/**
	     * recupere le nombre de convention par departement et par origine de stage pour le centre specifie et l'annee universitaire
	     * @param idCenter : identifiant du centre de gestion
	     * @param year : annee universitaire
	     *  @return
	     */
	
	  public List<StatisticItem> getNumberOfConventionsByDepartmentAndWayToFind(String idCenter, String year) ;
	/**
	     * recupere le nombre de convention par departement et par enseignant pour le centre specifie et l'annee universitaire
	     * @param idCenter : identifiant du centre de gestion
	     * @param year : annee universitaire
	     *  @return
	     */
	
	  public List<StatisticItem> getNumberOfConventionsByDepartmentAndTeacherGuide(String idCenter, String year) ;
	/**
	     * recupere le nombre de convention par departement et par etablissement d'accueil pour le centre specifie et l'annee universitaire
	     * @param idCenter : identifiant du centre de gestion
	     * @param year : annee universitaire
	     *  @return
	     */
	
	  public List<StatisticItem> getNumberOfConventionsByDepartmentAndStructure(String idCenter, String year) ;
	/**
	     * recupere le nombre de convention par departement et par statut juridique de l'etablissement d'accueil pour le centre specifie et l'annee universitaire
	     * @param idCenter : identifiant du centre de gestion
	     * @param year : annee universitaire
	     *  @return
	     */
	
	  public List<StatisticItem> getNumberOfConventionsByDepartmentAndStructureType(String idCenter, String year) ;
	/**
	     * recupere le nombre de convention par departement et par taille de l'etablissement d'accueil pour le centre specifie et l'annee universitaire
	     * @param idCenter : identifiant du centre de gestion
	     * @param year : annee universitaire
	     *  @return
	     */
	
	  public List<StatisticItem> getNumberOfConventionsByDepartmentAndStructureSize(String idCenter, String year) ;
	/**
	     * recupere le nombre de convention par departement et par dep du lieu de stage pour le centre specifie et l'annee universitaire
	     * @param idCenter : identifiant du centre de gestion
	     * @param year : annee universitaire
	     *  @return
	     */
	
	  public List<StatisticItem> getNumberOfConventionsByDepartmentAndServiceDep(String idCenter, String year) ;
	/**
	     * recupere le nombre de convention par departement et par pays du lieu de stage pour le centre specifie et l'annee universitaire
	     * @param idCenter : identifiant du centre de gestion
	     * @param year : annee universitaire
	     *  @return
	     */
	
	  public List<StatisticItem> getNumberOfConventionsByDepartmentAndServiceCountry(String idCenter, String year) ;
	  /**
	     * recupere le nombre de convention par thematique du stage pour le centre specifie et l'annee universitaire
	     * @param idCenter : identifiant du centre de gestion
	     * @param year : annee universitaire
	     *  @return
	     */
	
	  public List<StatisticItem> getNumberOfConventionsByTheme(String idCenter, String year) ;
	  /**
	     * recupere le nombre de convention par UFR et thematique du stage pour le centre specifie et l'annee universitaire
	     * @param idCenter : identifiant du centre de gestion
	     * @param year : annee universitaire
	     *  @return
	     */
	
	  public List<StatisticItem> getNumberOfConventionsByStudyAndTheme(String idCenter, String year) ;

	  /**
	     * recupere le nombre de convention par departement et thematique du stage pour le centre specifie et l'annee universitaire
	     * @param idCenter : identifiant du centre de gestion
	     * @param year : annee universitaire
	     *  @return
	     */
	
	  public List<StatisticItem> getNumberOfConventionsByDepartmentAndTheme(String idCenter, String year) ;
  
	  /**
	     * recupere le nombre de convention par etape d'etude et thematique du stage pour le centre specifie et l'annee universitaire
	     * @param idCenter : identifiant du centre de gestion
	     * @param year : annee universitaire
	     *  @return
	     */
	
	  public List<StatisticItem> getNumberOfConventionsByStepAndTheme(String idCenter, String year) ;
    /**
	     * recupere le nombre d'offres pour le centre specifie et  par annee universitaire
	     * @param idCenter : identifiant du centre de gestion
	     *  @return
	     */
	    public List<StatisticItem> getNumberOfOffers(String idCenter) ;
	
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
	  public List<StatisticItem> getNumberOfOffersByActivity(String idCenter, String year, boolean validation, boolean publication);
	  
	  /**
	     * recupere le nombre d'offres par etablisssment, par annee universitaire, par validation et diffusion
	     * @param idCenter : identifiant du centre de gestion
	     * @param year : annee universitaire
	    * @param validation 
	    * @param publication
	     *  @return
	     */
	  public List<StatisticItem> getNumberOfOffersByStructure(String idCenter, String year, boolean validation, boolean publication);
	
	  
	  /**
	     * recupere le nombre d'offres par statut juridique etablisssment, par annee universitaire, par validation et diffusion
	     * @param idCenter : identifiant du centre de gestion
	     * @param year : annee universitaire
	    * @param validation 
	    * @param publication
	     *  @return
	     */
	  public List<StatisticItem> getNumberOfOffersByStructureType(String idCenter, String year, boolean validation, boolean publication);
	
	  
	  /**
	     * recupere le nombre d'offres par taille etablisssment, par annee universitaire, par validation et diffusion
	     * @param idCenter : identifiant du centre de gestion
	     * @param year : annee universitaire
	    * @param validation 
	    * @param publication
	     *  @return
	     */
	  public List<StatisticItem> getNumberOfOffersByStructureSize(String idCenter, String year, boolean validation, boolean publication);
	
	  
	  /**
	     * recupere le nombre d'offres par departement etablisssment, par annee universitaire, par validation et diffusion
	     * @param idCenter : identifiant du centre de gestion
	     * @param year : annee universitaire
	    * @param validation 
	    * @param publication
	     *  @return
	     */
	  public List<StatisticItem> getNumberOfOffersByStructureDep(String idCenter, String year, boolean validation, boolean publication);
	
	  
	  /**
	     * recupere le nombre d'offres par pays etablisssment, par annee universitaire, par validation et diffusion
	     * @param idCenter : identifiant du centre de gestion
	     * @param year : annee universitaire
	    * @param validation 
	    * @param publication
	     *  @return
	     */
	  public List<StatisticItem> getNumberOfOffersByStructureCountry(String idCenter, String year, boolean validation, boolean publication);
	  /**
	     * recupere le nombre d'offres par fonction, par validation et diffusion
	     * @param idCenter : identifiant du centre de gestion
	     * @param year : annee universitaire
	    * @param validation 
	    * @param publication
	     *  @return
	     */
	  public List<StatisticItem> getNumberOfOffersByFunction(String idCenter, String year, boolean validation, boolean publication);

	  /**
	     * recupere le nombre d'offres par formation, par validation et diffusion
	     * @param idCenter : identifiant du centre de gestion
	     * @param year : annee universitaire
	    * @param validation 
	    * @param publication
	     *  @return
	     */
	  public List<StatisticItem> getNumberOfOffersByFormation(String idCenter, String year, boolean validation, boolean publication);

	  /**
	     * recupere le nombre d'offres par niveau de formation, par validation et diffusion
	     * @param idCenter : identifiant du centre de gestion
	     * @param year : annee universitaire
	    * @param validation 
	    * @param publication
	     *  @return
	     */
	  public List<StatisticItem> getNumberOfOffersByLevel(String idCenter, String year, boolean validation, boolean publication);

	  /**
	     * recupere le nombre d'offres par type d'offre, par validation et diffusion
	     * @param idCenter : identifiant du centre de gestion
	     * @param year : annee universitaire
	    * @param validation 
	    * @param publication
	     *  @return
	     */
	  public List<StatisticItem> getNumberOfOffersByType(String idCenter, String year, boolean validation, boolean publication);

	  
	     /** recupere le nombre d'offres par validation
	     * @param idCenter : identifiant du centre de gestion
	     * @param year : annee universitaire
	     *  @return
	     */
	  public List<StatisticItem> getNumberOfOffersByValidation(String idCenter, String year);

	     /** recupere le nombre d'offres par publication
	     * @param idCenter : identifiant du centre de gestion
	     * @param year : annee universitaire
	     *  @return
	     */
	  public List<StatisticItem> getNumberOfOffersByPublication(String idCenter, String year);
	  
	  /**
	     * recupere le nombre d'offres par designation d'un candidat (offre pourvue ou non), par validation et diffusion
	     * @param idCenter : identifiant du centre de gestion
	     * @param year : annee universitaire
	    * @param validation 
	    * @param publication
	     *  @return
	     */
	  public List<StatisticItem> getNumberOfOffersByCandidateFound(String idCenter, String year, boolean validation, boolean publication);

	  /**
	     * recupere le nombre d'offres par origine du candidat (etudiant local ou non), par validation et diffusion
	     * @param idCenter : identifiant du centre de gestion
	     * @param year : annee universitaire
	    * @param validation 
	    * @param publication
	     *  @return
	     */
	  public List<StatisticItem> getNumberOfOffersByLocalStudent(String idCenter, String year, boolean validation, boolean publication);

}
