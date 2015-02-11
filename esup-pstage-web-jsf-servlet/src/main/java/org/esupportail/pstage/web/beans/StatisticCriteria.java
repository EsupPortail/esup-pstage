package org.esupportail.pstage.web.beans;

import java.io.Serializable;
import java.util.LinkedHashMap;

public class StatisticCriteria implements Serializable {
	
	/**
	 * critere  choisi pour le second critere pour les statistique sur les conventions
	 */ 	
	
	private String chosenSecondLevelStatCriteriumForConvention;
	
	/**
	 * critere  choisi pour le premierCritere pour les statistiques sur les conventions
	 */ 
	private String chosenFirstLevelStatCriteriumForConvention;

	/**
	 * critere  choisi pour le premierCritere pour les statistiques sur les offres
	 */ 
	private String chosenFirstLevelStatCriteriumForOffer;
	/**
	 * critere  choisi pour le second Critere pour les statistiques sur les offres
	 */ 
	private String chosenSecondLevelStatCriteriumForOffer;

	
	/**
	 * liste des criteres de choix possibles   pour le premier niveau pour les statistique sur les conventions
	 */ 	
	private LinkedHashMap<String,String> firstLevelStatCriteriaForConvention ;
	
	/**
	 * liste des criteres de choix possibles   pour le second niveau pour les statistique sur les conventions
	 */ 	
	private LinkedHashMap<String,String> secondLevelStatCriteriaForConvention ;

	
	/**
	 * liste des premiers criteres de choix possibles pour les statistique sur les offres
	 */ 	
	private LinkedHashMap<String,String> firstLevelStatCriteriaForOffer ;

	
	/**
	 * liste des criteres de choix possibles pour les statistique sur les offres
	 */ 	
	private LinkedHashMap<String,String> secondLevelStatCriteriaForOffer ;


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//TODO refaire
	public StatisticCriteria() {
		super();
		
		 firstLevelStatCriteriaForConvention = new LinkedHashMap<String,String>();
		 firstLevelStatCriteriaForConvention.put("","");
		 firstLevelStatCriteriaForConvention.put("UFR","UFR");
		 firstLevelStatCriteriaForConvention.put("DEP","D\u00E9partement");
		 firstLevelStatCriteriaForConvention.put("ETAPE","Etape d'\u00E9tude");
		 
		 secondLevelStatCriteriaForConvention = new LinkedHashMap<String,String>();
		 secondLevelStatCriteriaForConvention.put("","");
		 secondLevelStatCriteriaForConvention.put("TYPE","Type de stage");
		 secondLevelStatCriteriaForConvention.put("THEME","Th\u00E9matique du stage");
		 secondLevelStatCriteriaForConvention.put("GRA","Gratification");
		 secondLevelStatCriteriaForConvention.put("TEMPS","Temps de travail");
		 secondLevelStatCriteriaForConvention.put("NB","Nombre de jours de travail hebdomadaires");
		 secondLevelStatCriteriaForConvention.put("ORI","Origine du stage");	
		 secondLevelStatCriteriaForConvention.put("ENS","Enseignant r\u00E9f\u00E9rent");
		 secondLevelStatCriteriaForConvention.put("ENT","Etablissement d'accueil");
		 secondLevelStatCriteriaForConvention.put("DOM","Domaine d'activit\u00E9 de l'\u00E9tablissement d'accueil");
		 secondLevelStatCriteriaForConvention.put("JUR","Statut juridique de l'\u00E9tablissement d'accueil");
		 secondLevelStatCriteriaForConvention.put("SIZE","Taille de l'\u00E9tablissement d'accueil");
		 secondLevelStatCriteriaForConvention.put("DEPGEO","D\u00E9partement g\u00E9ograhique du lieu de stage");
		 secondLevelStatCriteriaForConvention.put("PAYS","Pays du lieu de stage");
		 secondLevelStatCriteriaForConvention.put("DUREE","Dur\u00E9e du stage");
			
		 
		 firstLevelStatCriteriaForOffer = new LinkedHashMap<String,String>();
		 firstLevelStatCriteriaForOffer.put("","");
		 firstLevelStatCriteriaForOffer.put("VAL","Validation");
		 firstLevelStatCriteriaForOffer.put("PUB","Publication");
		 
		 
		 
		 secondLevelStatCriteriaForOffer = new LinkedHashMap<String,String>();
		 secondLevelStatCriteriaForOffer.put("","");
		 secondLevelStatCriteriaForOffer.put("TYP","Type d'offre");
		 secondLevelStatCriteriaForOffer.put("FON","Fonction");		 
		 secondLevelStatCriteriaForOffer.put("FOR","Formation");
		 secondLevelStatCriteriaForOffer.put("NIV","Niveau de formation");
		 secondLevelStatCriteriaForOffer.put("ENT","Etablissement d'accueil");
		 secondLevelStatCriteriaForOffer.put("DOM","Domaine d'activit\u00E9 de l'\u00E9tablissement d'accueil");
		 secondLevelStatCriteriaForOffer.put("JUR","Statut juridique de l'\u00E9tablissement d'accueil");
		 secondLevelStatCriteriaForOffer.put("SIZE","Taille de l'\u00E9tablissement d'accueil");
		 secondLevelStatCriteriaForOffer.put("DEPGEO","D\u00E9partement de l'\u00E9tablissement d'accueil");
		 secondLevelStatCriteriaForOffer.put("PAYS","Pays de l'\u00E9tablissement d'accueil");
		 secondLevelStatCriteriaForOffer.put("POURVU","D\u00E9signation d'un candidat");
		 secondLevelStatCriteriaForOffer.put("ORI","Origine locale du candidat");
					
		 
		 
			
	}
	
	
	/**
	 * @return Returns the choosenFirstLevelCriterium.
	 */
	public String getChosenFirstLevelStatCriteriumForConvention() {
		return chosenFirstLevelStatCriteriumForConvention;
	}

	/**
	 * @param choosenFirstLevelCriteriumn The choosenFirstLevelCriterium to set.
	 */
	public void setChosenFirstLevelStatCriteriumForConvention(
			String chosenFirstLevelStatCriterium) {
		this.chosenFirstLevelStatCriteriumForConvention = chosenFirstLevelStatCriterium;
	}

	/**
	 * @return Returns the choosenSecondLevelCriteriumForConvention.
	 */
	public String getChosenSecondLevelStatCriteriumForConvention() {
		return chosenSecondLevelStatCriteriumForConvention;
	}

	/**
	 * @param choosenSecondLevelCriteriumForConvention The choosenSecondLevelCriteriumForConvention to set.
	 */
	public void setChosenSecondLevelStatCriteriumForConvention(
			String chosenSecondLevelStatCriteriumForConvention) {
		this.chosenSecondLevelStatCriteriumForConvention = chosenSecondLevelStatCriteriumForConvention;
	}
	
	/**
	 * @return retourne la liste des criteres possibles pour le premier niveau de choix
	 */
	public LinkedHashMap<String,String> getFirstLevelStatCriteriaForConvention(){
		return firstLevelStatCriteriaForConvention;
		
		
	}
	/**
	 * @return retourne le libelle du criteres choisi pour le premier niveau de choix
	 * pour les stat de  convention
	 */
	public String getFirstLevelStatCriteriumLibForConvention(String code){
		return firstLevelStatCriteriaForConvention.get(code);
	
	}
	
	/**
	 * @return retourne le libelle du criteres choisi pour le second niveau de choix
	 * pour les stat de convention
	 */
	public String getSecondLevelStatCriteriumLibForConvention(String code){
		return secondLevelStatCriteriaForConvention.get(code);
	
	}

	/**
	 * @return Returns the choosenStatCriteriumForOffer.
	 */
	public String getChosenFirstLevelStatCriteriumForOffer() {
		return chosenFirstLevelStatCriteriumForOffer;
	}

	/**
	 * @param choosenStatCriteriumForOffer The choosenStatCriteriumForOffer to set.
	 */
	public void setChosenFirstLevelStatCriteriumForOffer(String chosenStatCriteriumForOffer) {
		this.chosenFirstLevelStatCriteriumForOffer = chosenStatCriteriumForOffer;
	}

	/**
	 * @return Returns the statCriteriaForOffer.
	 */
	public LinkedHashMap<String, String> getSecondLevelStatCriteriaForOffer() {
		return secondLevelStatCriteriaForOffer;
	}
	
	/**
	 * @return Returns le libelle du premier critere choisi pour les offres
	 */
	public String getChosenFirstLevelStatCriteriumLibForOffer(String code) {
		return firstLevelStatCriteriaForOffer.get(code);
	}
	/**
	 * @return Returns le libelle du second critere choisi pour les offres
	 */
	public String getChosenSecondLevelStatCriteriumLibForOffer(String code) {
		return secondLevelStatCriteriaForOffer.get(code);
	}

	/**
	 * @return Returns the secondLevelStatCriteriaForConvention.
	 */
	public LinkedHashMap<String, String> getSecondLevelStatCriteriaForConvention() {
		return secondLevelStatCriteriaForConvention;
	}

	/**
	 * @return Returns the chosenSecondLevelStatCriteriumForOffer.
	 */
	public String getChosenSecondLevelStatCriteriumForOffer() {
		return chosenSecondLevelStatCriteriumForOffer;
	}

	/**
	 * @param chosenSecondLevelStatCriteriumForOffer The chosenSecondLevelStatCriteriumForOffer to set.
	 */
	public void setChosenSecondLevelStatCriteriumForOffer(
			String chosenSecondLevelStatCriteriumForOffer) {
		this.chosenSecondLevelStatCriteriumForOffer = chosenSecondLevelStatCriteriumForOffer;
	}

	/**
	 * @return Returns the firstLevelStatCriteriaForOffer.
	 */
	public LinkedHashMap<String, String> getFirstLevelStatCriteriaForOffer() {
		return firstLevelStatCriteriaForOffer;
	}

}
