
package org.esupportail.pstage.web.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.faces.model.SelectItem;
import javax.servlet.ServletException;

import org.esupportail.pstage.domain.referentiel.StatistiquesDomainService;
import org.esupportail.pstage.exceptions.StatistiquesException;
import org.esupportail.pstage.web.servlet.EditXlsServlet;
import org.esupportail.pstagedata.domain.dto.StatisticItemDTO;
import org.esupportail.pstagedata.domain.beans.StatisticCriteria;
import java.util.LinkedHashMap;



@SuppressWarnings("serial")
public class StatistiquesConventionController extends AbstractContextAwareController {

	//Liste du 1er critere
	LinkedHashMap<String,String> firstStatsCriteriumList;
	//Liste du 2eme critere
	LinkedHashMap<String,String> secondStatsCriteriumList;

	//critere de niveau 1 pour les conventions 
	private 	List<SelectItem> firstLevelStatCriteriaForConvention ;
	//critere de niveau 2 pour les conventions 
	private 	List<SelectItem> secondLevelStatCriteriaForConvention ; 

	private String critereUnLib;
	private String 	critereDeuxLib;

	private String critereUnCle;
	private String 	critereDeuxCle;

	private String message = "";

	private StatistiquesDomainService statistiquesDomainService;

	private HashMap<String, List<StatisticItemDTO>> map;

	List<StatisticItemDTO> statsItemList;

	private List<String> years;
	private Integer idCentreGestion;
	private String libelle;
	private int total;
	private int pourcentage;

	/********************Initialise la liste des criteres **************************************/

	public void initAll(){
	}


	public List<SelectItem> getFirstLevelStatCriteriaForConvention() {
		initCvtCriteresNiveauUn();
		return firstLevelStatCriteriaForConvention;
	}

	public void setFirstLevelStatCriteriaForConvention(List<SelectItem> firstLevelStatCriteriaForConvention) {
		this.firstLevelStatCriteriaForConvention = firstLevelStatCriteriaForConvention;
	}

	public List<SelectItem> getSecondLevelStatCriteriaForConvention() {
		initCvtCriteresNiveauDeux();
		return secondLevelStatCriteriaForConvention;
	}

	public void setSecondLevelStatCriteriaForConvention(List<SelectItem> secondLevelStatCriteriaForConvention) {
		this.secondLevelStatCriteriaForConvention = secondLevelStatCriteriaForConvention;
	}

	private void initCvtCriteresNiveauUn() {

		StatisticCriteria statCriteria = new StatisticCriteria();
		firstStatsCriteriumList = statCriteria.getFirstLevelStatCriteriaForConvention();
		firstLevelStatCriteriaForConvention = new ArrayList<SelectItem>(firstStatsCriteriumList.size());		

		for(Entry<String, String> entry : firstStatsCriteriumList.entrySet()) {
			String cle = entry.getKey();
			String valeur = entry.getValue();
			firstLevelStatCriteriaForConvention.add(new SelectItem(valeur));
		}
	}

	private void initCvtCriteresNiveauDeux() {

		StatisticCriteria statCriteria = new StatisticCriteria();
		secondStatsCriteriumList = statCriteria.getSecondLevelStatCriteriaForConvention();
		secondLevelStatCriteriaForConvention = new ArrayList<SelectItem>(secondStatsCriteriumList.size());		

		for(Entry<String, String> entry : secondStatsCriteriumList.entrySet()) {
			String cle = entry.getKey();
			String valeur = entry.getValue();
			secondLevelStatCriteriaForConvention.add(new SelectItem(valeur));
		}
	}



	/*************************************************************************/


	public StatistiquesDomainService getStatistiquesDomainService() {
		return statistiquesDomainService;
	}
	public void setStatistiquesDomainService(StatistiquesDomainService statistiquesDomainService) {
		this.statistiquesDomainService = statistiquesDomainService;
	}

	public List<StatisticItemDTO> getStatsItemList() {
		return statsItemList;
	}
	public void setStatsItemList(List<StatisticItemDTO> statsItemList) {
		this.statsItemList = statsItemList;
	}

	public Map<String, List<StatisticItemDTO>> getMap() {
		return map;
	}
	public void setStatsItemList(HashMap<String, List<StatisticItemDTO>> map) {
		this.map = map;
	}

	public String getCritereUnLib() {
		return critereUnLib;
	}
	public void setCritereUnLib(String critereUnLib) {
		this.critereUnLib = critereUnLib;
	}

	public String getCritereUnCle() {
		return critereUnCle;
	}
	public void setCritereUnCle(String critereUnCle) {
		this.critereUnCle = critereUnCle;
	}

	public String getCritereDeuxLib() {
		return critereDeuxLib;
	}
	public void setCritereDeuxLib(String critereDeuxLib) {
		this.critereDeuxLib = critereDeuxLib;
	}

	public String getCritereDeuxCle() {
		return critereDeuxCle;
	}
	public void setCritereDeuxCle(String critereDeuxCle) {
		this.critereDeuxCle = critereDeuxCle;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getidCentreGestion() {
		return idCentreGestion;
	}
	public void setidCentreGestion(Integer idCentreGestion) {
		this.idCentreGestion = idCentreGestion;
	}

	public List<String> getYears() {
		return years;
	}
	public void setYears(List<String> years) {
		this.years = years;
	}

	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}

	public int getPourcentage() {
		return pourcentage;
	}
	public void setPourcentage(int pourcentage) {
		this.pourcentage = pourcentage;
	}

	public String ValueToKeyForCritere (LinkedHashMap<String,String> map, String critere ) {
		String cle="";
		String valeur="";

		for(Entry<String, String> entry : map.entrySet()) {
			cle = entry.getKey();
			valeur = entry.getValue();
			if(critere.equals(valeur)){
				critere=cle;
				break;
			}
		}//fin boucle
		return critere;
	}

	//arrondir le double x à n décimales : pour que le pourcentage n'est que 2 décimales
	/*private static double arrondiNDecimales(double x, int n)
	{
		double pow = Math.pow(10, n);
		return (Math.floor(x * pow)) / pow;
	}*/

	/*******************Resultats de la recherche******************************/

	public String gotoResultatStagesStats () throws StatistiquesException{

		map= new LinkedHashMap<String,List<StatisticItemDTO>>();
		//		idCentreGestion = new Integer(1);
		String etab = "CDG";
		//		System.out.println("idCentreGestion="+idCentreGestion);

		// récupère les différentes années, soit 2007 à 2012
		years = statistiquesDomainService.getAnneesConventions(idCentreGestion, etab);

		//		System.out.println("Critere 1 Lib = "+critereUnLib);
		critereUnCle = ValueToKeyForCritere(firstStatsCriteriumList,critereUnLib);
		//		System.out.println("Critere 1 Cle = "+critereUnCle);

		//		System.out.println("Critere 2 Lib = "+critereDeuxLib);
		critereDeuxCle = ValueToKeyForCritere(secondStatsCriteriumList,critereDeuxLib);
		//		System.out.println("Critere 2 Cle = "+critereDeuxCle);
		//		System.out.println("years="+years);

		/*Statistiques pour tout le centre de gestion*/

		if(years != null){
			//boucle sur les differentes années universitaires depuis 2007
			for (String uneAnnee:years){

				//Critere 1 = vide
				if(critereUnCle.equals("")){

					//Appel de la fonction selon le critere 2
					if (critereDeuxCle.equals("")){
						statsItemList = statistiquesDomainService.getNumberOfConventions(idCentreGestion, etab);
						// S'il n'y a aucun critere, on met "all" en tant qu'annee en cours afin de pouvoir recuperer 
						// correctement les resultats pour chaque annee dans la jsp
						uneAnnee = "all";
						message = getString("CONVENTION.STATS.ANNEE");
					}
					else if (critereDeuxCle.equals("TYPE")){
						statsItemList = statistiquesDomainService.getNumberOfConventionsByType(idCentreGestion, uneAnnee, etab);
						message = getString("CONVENTION.STATS.TYPE");
					}
					else if (critereDeuxCle.equals("GRA")){
						statsItemList = statistiquesDomainService.getNumberOfConventionsByIndemnity(idCentreGestion, uneAnnee, etab);
						message = getString("CONVENTION.STATS.GRA");
					}
					else if (critereDeuxCle.equals("TEMPS")){
						statsItemList = statistiquesDomainService.getNumberOfConventionsByWorkDuration(idCentreGestion, uneAnnee, etab);
						message = getString("CONVENTION.STATS.TEMPS");
					}
					else if (critereDeuxCle.equals("NB")){
						statsItemList = statistiquesDomainService.getNumberOfConventionsByNbDaysPerWeek(idCentreGestion, uneAnnee, etab);
						message = getString("CONVENTION.STATS.NB");
					}
					else if (critereDeuxCle.equals("ORI")){
						statsItemList = statistiquesDomainService.getNumberOfConventionsByWayToFind(idCentreGestion, uneAnnee, etab);
						message = getString("CONVENTION.STATS.ORI");
					}
					else if (critereDeuxCle.equals("ENS")){
						statsItemList = statistiquesDomainService.getNumberOfConventionsByTeacherGuide(idCentreGestion, uneAnnee, etab);
						message = getString("CONVENTION.STATS.ENS");
					}
					else if (critereDeuxCle.equals("ENT")){
						statsItemList = statistiquesDomainService.getNumberOfConventionsByStructure(idCentreGestion, uneAnnee, etab);
						message = getString("CONVENTION.STATS.ENT");
					}
					else if (critereDeuxCle.equals("DOM")){
						statsItemList = statistiquesDomainService.getNumberOfConventionsByStructureActivity(idCentreGestion, uneAnnee, etab);
						message = getString("CONVENTION.STATS.DOM");
					}
					else if (critereDeuxCle.equals("JUR")){
						statsItemList = statistiquesDomainService.getNumberOfConventionsByStructureType(idCentreGestion, uneAnnee, etab);
						message = getString("CONVENTION.STATS.JUR");
					}
					else if (critereDeuxCle.equals("SIZE")){
						statsItemList = statistiquesDomainService.getNumberOfConventionsByStructureSize(idCentreGestion, uneAnnee, etab);
						message = getString("CONVENTION.STATS.SIZE");
					}
					else if (critereDeuxCle.equals("DEPGEO")){
						statsItemList = statistiquesDomainService.getNumberOfConventionsByServiceDep(idCentreGestion, uneAnnee, etab);
						message = getString("CONVENTION.STATS.DEPGEO");
					}
					else if (critereDeuxCle.equals("PAYS")){
						statsItemList = statistiquesDomainService.getNumberOfConventionsByServiceCountry(idCentreGestion, uneAnnee, etab);
						message = getString("CONVENTION.STATS.PAYS");
					}
					else if (critereDeuxCle.equals("THEME")){
						statsItemList = statistiquesDomainService.getNumberOfConventionsByTheme(idCentreGestion, uneAnnee, etab);
						message = getString("CONVENTION.STATS.THEME");
					}

				}//fin Critere 1 = vide 


				//Critere 1 = UFR
				if(critereUnCle.equals("UFR")){

					//Appel de la fonction selon le critere 2
					if (critereDeuxCle.equals("")){
						statsItemList = statistiquesDomainService.getNumberOfConventionsByStudy(idCentreGestion, uneAnnee, etab);
						message = getString("CONVENTION.STATS.UFR");
					}
					else if (critereDeuxCle.equals("TYPE")){
						statsItemList = statistiquesDomainService.getNumberOfConventionsByStudyAndType(idCentreGestion, uneAnnee, etab);
						message = getString("CONVENTION.STATS.UFR.TYPE");
					}
					else if (critereDeuxCle.equals("GRA")){
						statsItemList = statistiquesDomainService.getNumberOfConventionsByStudyAndIndemnity(idCentreGestion, uneAnnee, etab);
						message = getString("CONVENTION.STATS.UFR.GRA");
					}
					else if (critereDeuxCle.equals("TEMPS")){
						statsItemList = statistiquesDomainService.getNumberOfConventionsByStudyAndWorkDuration(idCentreGestion, uneAnnee, etab);
						message = getString("CONVENTION.STATS.UFR.TEMPS");
					}
					else if (critereDeuxCle.equals("NB")){
						statsItemList = statistiquesDomainService.getNumberOfConventionsByStudyAndNbDaysPerWeek(idCentreGestion, uneAnnee, etab);
						message = getString("CONVENTION.STATS.UFR.NB");
					}
					else if (critereDeuxCle.equals("ORI")){
						statsItemList = statistiquesDomainService.getNumberOfConventionsByStudyAndWayToFind(idCentreGestion, uneAnnee, etab);
						message = getString("CONVENTION.STATS.UFR.ORI");
					}
					else if (critereDeuxCle.equals("ENS")){
						statsItemList = statistiquesDomainService.getNumberOfConventionsByStudyAndTeacherGuide(idCentreGestion, uneAnnee, etab);
						message = getString("CONVENTION.STATS.UFR.ENS");
					}
					else if (critereDeuxCle.equals("ENT")){
						statsItemList = statistiquesDomainService.getNumberOfConventionsByStudyAndStructure(idCentreGestion, uneAnnee, etab);
						message = getString("CONVENTION.STATS.UFR.ENT");
					}
					else if (critereDeuxCle.equals("DOM")){
						statsItemList = statistiquesDomainService.getNumberOfConventionsByStudyAndActivity(idCentreGestion, uneAnnee, etab);
						message = getString("CONVENTION.STATS.UFR.DOM");
					}
					else if (critereDeuxCle.equals("JUR")){
						statsItemList = statistiquesDomainService.getNumberOfConventionsByStudyAndStructureType(idCentreGestion, uneAnnee, etab);
						message = getString("CONVENTION.STATS.UFR.JUR");
					}
					else if (critereDeuxCle.equals("SIZE")){
						statsItemList = statistiquesDomainService.getNumberOfConventionsByStudyAndStructureSize(idCentreGestion, uneAnnee, etab);
						message = getString("CONVENTION.STATS.UFR.SIZE");
					}
					else if (critereDeuxCle.equals("DEPGEO")){
						statsItemList = statistiquesDomainService.getNumberOfConventionsByStudyAndServiceDep(idCentreGestion, uneAnnee, etab);
						message = getString("CONVENTION.STATS.UFR.DEPGEO");
					}
					else if (critereDeuxCle.equals("PAYS")){
						statsItemList = statistiquesDomainService.getNumberOfConventionsByStudyAndServiceCountry(idCentreGestion, uneAnnee, etab);
						message = getString("CONVENTION.STATS.UFR.PAYS");
					}
					else if (critereDeuxCle.equals("THEME")){
						statsItemList = statistiquesDomainService.getNumberOfConventionsByStudyAndTheme(idCentreGestion, uneAnnee, etab);
						message = getString("CONVENTION.STATS.UFR.THEME");
					}

				}//fin Critere 1 = UFR

				//Critere 1 = DEP
				if(critereUnCle.equals("DEP")){

					//Appel de la fonction selon le critere 2
					if (critereDeuxCle.equals("")){
						statsItemList = statistiquesDomainService.getNumberOfConventionsByDepartment(idCentreGestion, uneAnnee, etab);
						message = getString("CONVENTION.STATS.DEP");
					}
					else if (critereDeuxCle.equals("TYPE")){
						statsItemList = statistiquesDomainService.getNumberOfConventionsByDepartmentAndType(idCentreGestion, uneAnnee, etab);
						message = getString("CONVENTION.STATS.DEP.TYPE");
					}
					else if (critereDeuxCle.equals("DOM")){
						statsItemList = statistiquesDomainService.getNumberOfConventionsByDepartmentAndActivity(idCentreGestion, uneAnnee, etab);
						message = getString("CONVENTION.STATS.DEP.DOM");
					}
					else if (critereDeuxCle.equals("GRA")){
						statsItemList = statistiquesDomainService.getNumberOfConventionsByDepartmentAndIndemnity(idCentreGestion, uneAnnee, etab);
						message = getString("CONVENTION.STATS.DEP.GRA");
					}
					else if (critereDeuxCle.equals("TEMPS")){
						statsItemList = statistiquesDomainService.getNumberOfConventionsByDepartmentAndWorkDuration(idCentreGestion, uneAnnee, etab);
						message = getString("CONVENTION.STATS.DEP.TEMPS");
					}
					else if (critereDeuxCle.equals("NB")){
						statsItemList = statistiquesDomainService.getNumberOfConventionsByDepartmentAndNbDaysPerWeek(idCentreGestion, uneAnnee, etab);
						message = getString("CONVENTION.STATS.DEP.NB");
					}
					else if (critereDeuxCle.equals("ORI")){
						statsItemList = statistiquesDomainService.getNumberOfConventionsByDepartmentAndWayToFind(idCentreGestion, uneAnnee, etab);
						message = getString("CONVENTION.STATS.DEP.ORI");
					}
					else if (critereDeuxCle.equals("ENS")){
						statsItemList = statistiquesDomainService.getNumberOfConventionsByDepartmentAndTeacherGuide(idCentreGestion, uneAnnee, etab);
						message = getString("CONVENTION.STATS.DEP.ENS");
					}
					else if (critereDeuxCle.equals("ENT")){
						statsItemList = statistiquesDomainService.getNumberOfConventionsByDepartmentAndStructure(idCentreGestion, uneAnnee, etab);
						message = getString("CONVENTION.STATS.DEP.ENT");
					}
					else if (critereDeuxCle.equals("JUR")){
						statsItemList = statistiquesDomainService.getNumberOfConventionsByDepartmentAndStructureType(idCentreGestion, uneAnnee, etab);
						message = getString("CONVENTION.STATS.DEP.JUR");
					}
					else if (critereDeuxCle.equals("SIZE")){
						statsItemList = statistiquesDomainService.getNumberOfConventionsByDepartmentAndStructureSize(idCentreGestion, uneAnnee, etab);
						message = getString("CONVENTION.STATS.DEP.SIZE");
					}
					else if (critereDeuxCle.equals("DEPGEO")){
						statsItemList = statistiquesDomainService.getNumberOfConventionsByDepartmentAndServiceDep(idCentreGestion, uneAnnee, etab);
						message = getString("CONVENTION.STATS.DEP.DEPGEO");
					}
					else if (critereDeuxCle.equals("PAYS")){
						statsItemList = statistiquesDomainService.getNumberOfConventionsByDepartmentAndServiceCountry(idCentreGestion, uneAnnee, etab);
						message = getString("CONVENTION.STATS.DEP.PAYS");
					}
					else if (critereDeuxCle.equals("THEME")){
						statsItemList = statistiquesDomainService.getNumberOfConventionsByDepartmentAndTheme(idCentreGestion, uneAnnee, etab);
						message = getString("CONVENTION.STATS.DEP.THEME");
					}

				}//fin Critere 1 = ETAPE

				//Critere 1 = ETAPE
				if(critereUnCle.equals("ETAPE")){

					//Appel de la fonction selon le critere 2
					if (critereDeuxCle.equals("")){
						statsItemList = statistiquesDomainService.getNumberOfConventionsByStep(idCentreGestion, uneAnnee, etab);
						message = getString("CONVENTION.STATS.ETAPE");
					}
					else if (critereDeuxCle.equals("TYPE")){
						statsItemList = statistiquesDomainService.getNumberOfConventionsByStepAndType(idCentreGestion, uneAnnee, etab);
						message = getString("CONVENTION.STATS.ETAPE.TYPE");
					}
					else if (critereDeuxCle.equals("DOM")){
						statsItemList = statistiquesDomainService.getNumberOfConventionsByStepAndActivity(idCentreGestion, uneAnnee, etab);
						message = getString("CONVENTION.STATS.ETAPE.DOM");
					}
					else if (critereDeuxCle.equals("GRA")){
						statsItemList = statistiquesDomainService.getNumberOfConventionsByStepAndIndemnity(idCentreGestion, uneAnnee, etab);
						message = getString("CONVENTION.STATS.ETAPE.GRA");
					}
					else if (critereDeuxCle.equals("TEMPS")){
						statsItemList = statistiquesDomainService.getNumberOfConventionsByStepAndWorkDuration(idCentreGestion, uneAnnee, etab);
						message = getString("CONVENTION.STATS.ETAPE.TEMPS");
					}
					else if (critereDeuxCle.equals("NB")){
						statsItemList = statistiquesDomainService.getNumberOfConventionsByStepAndNbDaysPerWeek(idCentreGestion, uneAnnee, etab);
						message = getString("CONVENTION.STATS.ETAPE.NB");
					}
					else if (critereDeuxCle.equals("ORI")){
						statsItemList = statistiquesDomainService.getNumberOfConventionsByStepAndWayToFind(idCentreGestion, uneAnnee, etab);
						message = getString("CONVENTION.STATS.ETAPE.ORI");
					}
					else if (critereDeuxCle.equals("ENS")){
						statsItemList = statistiquesDomainService.getNumberOfConventionsByStepAndTeacherGuide(idCentreGestion, uneAnnee, etab);
						message = getString("CONVENTION.STATS.ETAPE.ENS");
					}
					else if (critereDeuxCle.equals("ENT")){
						statsItemList = statistiquesDomainService.getNumberOfConventionsByStepAndStructure(idCentreGestion, uneAnnee, etab);
						message = getString("CONVENTION.STATS.ETAPE.ENT");
					}
					else if (critereDeuxCle.equals("JUR")){
						statsItemList = statistiquesDomainService.getNumberOfConventionsByStepAndStructureType(idCentreGestion, uneAnnee, etab);
						message = getString("CONVENTION.STATS.ETAPE.JUR");
					}
					else if (critereDeuxCle.equals("SIZE")){
						statsItemList = statistiquesDomainService.getNumberOfConventionsByStepAndStructureSize(idCentreGestion, uneAnnee, etab);
						message = getString("CONVENTION.STATS.ETAPE.SIZE");
					}
					else if (critereDeuxCle.equals("DEPGEO")){
						statsItemList = statistiquesDomainService.getNumberOfConventionsByStepAndServiceDep(idCentreGestion, uneAnnee, etab);
						message = getString("CONVENTION.STATS.ETAPE.DEPGEO");
					}
					else if (critereDeuxCle.equals("PAYS")){
						statsItemList = statistiquesDomainService.getNumberOfConventionsByStepAndServiceCountry(idCentreGestion, uneAnnee, etab);
						message = getString("CONVENTION.STATS.ETAPE.PAYS");
					}
					else if (critereDeuxCle.equals("THEME")){
						statsItemList = statistiquesDomainService.getNumberOfConventionsByStepAndTheme(idCentreGestion, uneAnnee, etab);
						message = getString("CONVENTION.STATS.ETAPE.THEME");
					}

				}//fin Critere 1 = ETAPE


				//Calcul du résultat
				if (statsItemList!=null && !statsItemList.isEmpty()){
					total = 0;
					//connaitre le nombre de conventions ramenés
					for (StatisticItemDTO unItem : statsItemList){
						libelle = unItem.getLib();
						total = total + unItem.getNumber();
					}
					//connaitre le pourcentage de conventions ramenés
					pourcentage=0;
					for (StatisticItemDTO unItem : statsItemList){
						pourcentage = (unItem.getNumber()*100)/total;
						//pourcentage = arrondiNDecimales(pourcentage,2);
						unItem.setPercentage(pourcentage);
						//System.out.println("pourcentage="+pourcentage);
					}
					map.put(uneAnnee,statsItemList);
				}
			}//fin boucle sur les annees

			//resultat dans map
			/*for(Entry<String, List<StatisticItemDTO>> entry : map.entrySet()) {
				String cle = entry.getKey();
				System.out.print("cle="+cle);
				//boucle sur la liste
				List<StatisticItemDTO> liste = entry.getValue();
				for(int i=0; i<liste.size(); i++) {
					System.out.print("  Libelle="+liste.get(i).getLib());
					System.out.print("  Nombre="+liste.get(i).getNumber());
					System.out.println("  Pourcentage="+liste.get(i).getPercentage());
				}
			}*/
		}//fin years != null
		return "resultatStagesStats";
	}

	public String edition () throws ServletException, IOException{

		String statType = "stage";

		EditXlsServlet edit = new EditXlsServlet();
		edit.doGet(statType, critereUnCle, critereDeuxCle, map);

		return "resultatEditionStats";

	}

}
