package org.esupportail.pstage.web.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.faces.model.SelectItem;
import javax.servlet.ServletException;

import org.esupportail.pstage.domain.referentiel.StatistiquesDomainService;
import org.esupportail.pstage.exceptions.StatistiquesException;
import org.esupportail.pstage.web.beans.StatisticCriteria;
import org.esupportail.pstage.web.servlet.EditXlsServlet;
import org.esupportail.pstagedata.remote.StatisticItemDTO;



@SuppressWarnings("serial")
public class StatistiquesOffresController extends AbstractContextAwareController {

	//Liste du 1er critere
	LinkedHashMap<String,String> firstStatsCriteriumList;
	//Liste du 2eme critere
	LinkedHashMap<String,String> secondStatsCriteriumList;

	//critere de niveau 1 pour les conventions 
	private List<SelectItem> firstLevelStatCriteriaForOffer ;
	//critere de niveau 2 pour les conventions 
	private List<SelectItem> secondLevelStatCriteriaForOffer ; 

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

	boolean validation;
	boolean publication;

	/********************Initialise la liste des criteres **************************************/

	public void prepareOffres(){
	}

	public void initAll(){
	}


	public List<SelectItem> getFirstLevelStatCriteriaForOffer() {
		initOffreCriteresNiveauUn();
		return firstLevelStatCriteriaForOffer;
	}

	public void setFirstLevelStatCriteriaForOffre(List<SelectItem> firstLevelStatCriteriaForOffre) {
		this.firstLevelStatCriteriaForOffer = firstLevelStatCriteriaForOffre;
	}

	public List<SelectItem> getSecondLevelStatCriteriaForOffer() {
		initOffreCriteresNiveauDeux();
		return secondLevelStatCriteriaForOffer;
	}

	public void setSecondLevelStatCriteriaForOffre(List<SelectItem> secondLevelStatCriteriaForOffre) {
		this.secondLevelStatCriteriaForOffer = secondLevelStatCriteriaForOffre;
	}

	private void initOffreCriteresNiveauUn() {

		StatisticCriteria statCriteria = new StatisticCriteria();
		firstStatsCriteriumList = statCriteria.getFirstLevelStatCriteriaForOffer();
		firstLevelStatCriteriaForOffer = new ArrayList<SelectItem>(firstStatsCriteriumList.size());		

		for(Entry<String, String> entry : firstStatsCriteriumList.entrySet()) {
			String valeur = entry.getValue();
			firstLevelStatCriteriaForOffer.add(new SelectItem(valeur));
		}
	}

	private void initOffreCriteresNiveauDeux() {

		StatisticCriteria statCriteria = new StatisticCriteria();
		secondStatsCriteriumList = statCriteria.getSecondLevelStatCriteriaForOffer();
		secondLevelStatCriteriaForOffer = new ArrayList<SelectItem>(secondStatsCriteriumList.size());		

		for(Entry<String, String> entry : secondStatsCriteriumList.entrySet()) {
			String valeur = entry.getValue();
			secondLevelStatCriteriaForOffer.add(new SelectItem(valeur));
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
	/*public void setStatsItemList(HashMap<String, List<StatisticItemDTO>> map) {
		this.map = map;
	}*/

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

	public String gotoResultatOffresStats () throws StatistiquesException {
		
		map= new LinkedHashMap<String,List<StatisticItemDTO>>();
//		idCentreGestion = new Integer(1);
		String etat = "SansETAT";
//		System.out.println("idCentreGestion="+idCentreGestion);

		// récupère les différentes années, soit 2007 à 2012
//		System.out.println("idCentreGestion = " + idCentreGestion);
		years = statistiquesDomainService.getAnneesOffres(idCentreGestion, etat);
//		System.out.println("years="+years);

		//System.out.println("Critere 1 Lib = "+critereUnLib);
		critereUnCle = ValueToKeyForCritere(firstStatsCriteriumList,critereUnLib);
		//System.out.println("Critere 1 Cle = "+critereUnCle);

		//System.out.println("Critere 2 Lib = "+critereDeuxLib);
		critereDeuxCle = ValueToKeyForCritere(secondStatsCriteriumList,critereDeuxLib);
		//System.out.println("Critere 2 Cle = "+critereDeuxCle);

		    /*Statistiques pour tout le centre de gestion*/
		 if(years != null){
		    //boucle sur les differentes années universitaires depuis 2007
		    for (String uneAnnee:years){
		    			
			    //Critere 1 et critere 2 vides
			    if(critereUnCle.equals("") && critereDeuxCle.equals("")){
					statsItemList = statistiquesDomainService.getNumberOfOffers(idCentreGestion, etat);
					// S'il n'y a aucun critere, on met "all" en tant qu'annee en cours afin de pouvoir recuperer 
					// correctement les resultats pour chaque annee dans la jsp
					uneAnnee = "all";
					message = getString("OFFRES.STATS.ANNEE");
			    }
			    else {
			    	validation = critereUnCle.equals("VAL");
			    	publication = critereUnCle.equals("PUB");
			    	
		    			//Appel de la fonction selon le critere 2
	    				if (critereDeuxCle.equals("TYP")){
		    				statsItemList = statistiquesDomainService.getNumberOfOffersByType(idCentreGestion, uneAnnee, etat, validation, publication);
		    				message = getString("OFFRES.STATS.TYP");
		    			}
		    			else if (critereDeuxCle.equals("FON")){
		    				statsItemList = statistiquesDomainService.getNumberOfOffersByFunction(idCentreGestion, uneAnnee, etat, validation, publication);
		    				message = getString("OFFRES.STATS.FON");
		    			}
		    			else if (critereDeuxCle.equals("FOR")){
		    				statsItemList = statistiquesDomainService.getNumberOfOffersByFormation(idCentreGestion, uneAnnee, etat, validation, publication);
		    				message = getString("OFFRES.STATS.FOR");
		    			}
		    			else if (critereDeuxCle.equals("NIV")){
		    				statsItemList = statistiquesDomainService.getNumberOfOffersByLevel(idCentreGestion, uneAnnee, etat, validation, publication);
		    				message = getString("OFFRES.STATS.NIV");
		    			}
		    			else if (critereDeuxCle.equals("ENT")){
		    				statsItemList = statistiquesDomainService.getNumberOfOffersByStructure(idCentreGestion, uneAnnee, etat, validation, publication);
		    				message = getString("OFFRES.STATS.ENT");
		    			}
		    			else if (critereDeuxCle.equals("DOM")){
		    				statsItemList = statistiquesDomainService.getNumberOfOffersByActivity(idCentreGestion, uneAnnee, etat, validation, publication);
		    				message = getString("OFFRES.STATS.DOM");
		    			}
		    			else if (critereDeuxCle.equals("JUR")){
		    				statsItemList = statistiquesDomainService.getNumberOfOffersByStructureType(idCentreGestion, uneAnnee, etat, validation, publication);
		    				message = getString("OFFRES.STATS.JUR");
		    			}
		    			else if (critereDeuxCle.equals("SIZE")){
		    				statsItemList = statistiquesDomainService.getNumberOfOffersByStructureSize(idCentreGestion, uneAnnee, etat, validation, publication);
		    				message = getString("OFFRES.STATS.SIZE");
		    			}
		    			else if (critereDeuxCle.equals("DEPGEO")){
		    				statsItemList = statistiquesDomainService.getNumberOfOffersByStructureDep(idCentreGestion, uneAnnee, etat, validation, publication);
		    				message = getString("OFFRES.STATS.DEPGEO");
		    			}
		    			else if (critereDeuxCle.equals("PAYS")){
		    				statsItemList = statistiquesDomainService.getNumberOfOffersByStructureCountry(idCentreGestion, uneAnnee, etat, validation, publication);
		    				message = getString("OFFRES.STATS.PAYS");
		    			}
		    			else if (critereDeuxCle.equals("POURVU")){
		    				statsItemList = statistiquesDomainService.getNumberOfOffersByCandidateFound(idCentreGestion, uneAnnee, etat, validation, publication);
		    				message = getString("OFFRES.STATS.POURVU");
		    			}
		    			else if (critereDeuxCle.equals("ORI")){
		    				statsItemList = statistiquesDomainService.getNumberOfOffersByLocalStudent(idCentreGestion, uneAnnee, etat, validation, publication);
		    				message = getString("OFFRES.STATS.ORI");
		    			}
	    				
		    			else if (critereDeuxCle.equals("")){
		    				if(validation){
			    				statsItemList = statistiquesDomainService.getNumberOfOffersByValidation(idCentreGestion, uneAnnee, etat);
			    				message = getString("OFFRES.STATS.VAL.SEUL");
		    				}
		    				if(publication){
			    				statsItemList = statistiquesDomainService.getNumberOfOffersByPublication(idCentreGestion, uneAnnee, etat);
			    				message = getString("OFFRES.STATS.PUB.SEUL");
		    				}

		    			}
		    			
	    				//Complete le message par validation ou publication
	    				if (validation ){
	    		   			if (!critereDeuxCle.equals("")){
	    		   				message = message + getString("OFFRES.STATS.VAL.ET");
	    		   			}
	    		   			
	    		   		}
	    		   		else{
	    		   			if (publication){
	    		   				if (!critereDeuxCle.equals("")){
	    		   					message = message + getString("OFFRES.STATS.PUB.ET");
	    		   				}
	    		   			}
	    		   		}
	    				
			    	}//fin Criteres pas vide
		    			    		
			    
		    			//Calcul du résultat
		    			 if (statsItemList!=null && !statsItemList.isEmpty()){
		 	   				  total = 0;
		 	   				  //connaitre le nombre de conventions ramenés
		 	   				  for (StatisticItemDTO unItem : statsItemList){
		 	   					  libelle = unItem.getLib();
		 	   					  total = total + unItem.getNumber();
		 	   					  //System.out.println("total="+total);
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
		return "resultatOffresStats";
	}

	public String edition () throws ServletException, IOException{

		String statType = "offre";

		EditXlsServlet edit = new EditXlsServlet();
		edit.doGet(statType, critereUnCle, critereDeuxCle, map);

		return "resultatEditionStats";

	}

}
