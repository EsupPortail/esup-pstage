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

import org.esupportail.pstage.domain.StatistiquesDomainService;
import org.esupportail.pstage.exceptions.StatistiquesException;
import org.esupportail.pstage.web.beans.StatisticCriteria;
import org.esupportail.pstage.web.servlet.EditXlsServlet;
import org.esupportail.pstagedata.domain.dto.StatisticItemDTO;



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

	transient List<StatisticItemDTO> statsItemList;

	private Integer idCentreGestion;
	private String libelle;
	private int total;
	private int pourcentage;

	boolean validation;
	boolean publication;

	private String annee_scolaire = "";
	private List<SelectItem> anneesOffres;

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
		String cle;
		String valeur;
		String value=critere;

		for(Entry<String, String> entry : map.entrySet()) {
			cle = entry.getKey();
			valeur = entry.getValue();
			if(critere.equals(valeur)){
				value=cle;
				break;
			}
		}//fin boucle
		return value;
	}

	//arrondir le double x à n décimales : pour que le pourcentage n'est que 2 décimales
	/*private static double arrondiNDecimales(double x, int n)
	{
		double pow = Math.pow(10, n);
		return (Math.floor(x * pow)) / pow;
	}*/

	/*******************Resultats de la recherche******************************/

	public void gotoResultatOffresStats () throws StatistiquesException {

		map= new LinkedHashMap<String,List<StatisticItemDTO>>();

		String etat = "SansETAT";

		if (critereUnLib == null) critereUnLib = "";
		if (critereDeuxLib == null) critereDeuxLib = "";

		critereUnCle = ValueToKeyForCritere(firstStatsCriteriumList,critereUnLib);
		critereDeuxCle = ValueToKeyForCritere(secondStatsCriteriumList,critereDeuxLib);

		String uneAnnee = this.annee_scolaire;

		//Critere 1 et critere 2 vides
		if("".equals(critereUnCle) && "".equals(critereDeuxCle)){
			uneAnnee = "all";
			statsItemList = statistiquesDomainService.getNumberOfOffers(idCentreGestion, etat);
			message = getString("OFFRES.STATS.ANNEE");
		}
		else {
			validation = "VAL".equals(critereUnCle);
			publication = "PUB".equals(critereUnCle);

			//Appel de la fonction selon le critere 2
			if ("TYP".equals(critereDeuxCle)){
				statsItemList = statistiquesDomainService.getNumberOfOffersByType(idCentreGestion, uneAnnee, etat, validation, publication);
				message = getString("OFFRES.STATS.TYP");
			}
			else if ("FON".equals(critereDeuxCle)){
				statsItemList = statistiquesDomainService.getNumberOfOffersByFunction(idCentreGestion, uneAnnee, etat, validation, publication);
				message = getString("OFFRES.STATS.FON");
			}
			else if ("FOR".equals(critereDeuxCle)){
				statsItemList = statistiquesDomainService.getNumberOfOffersByFormation(idCentreGestion, uneAnnee, etat, validation, publication);
				message = getString("OFFRES.STATS.FOR");
			}
			else if ("NIV".equals(critereDeuxCle)){
				statsItemList = statistiquesDomainService.getNumberOfOffersByLevel(idCentreGestion, uneAnnee, etat, validation, publication);
				message = getString("OFFRES.STATS.NIV");
			}
			else if ("ENT".equals(critereDeuxCle)){
				statsItemList = statistiquesDomainService.getNumberOfOffersByStructure(idCentreGestion, uneAnnee, etat, validation, publication);
				message = getString("OFFRES.STATS.ENT");
			}
			else if ("DOM".equals(critereDeuxCle)){
				statsItemList = statistiquesDomainService.getNumberOfOffersByActivity(idCentreGestion, uneAnnee, etat, validation, publication);
				message = getString("OFFRES.STATS.DOM");
			}
			else if ("JUR".equals(critereDeuxCle)){
				statsItemList = statistiquesDomainService.getNumberOfOffersByStructureType(idCentreGestion, uneAnnee, etat, validation, publication);
				message = getString("OFFRES.STATS.JUR");
			}
			else if ("SIZE".equals(critereDeuxCle)){
				statsItemList = statistiquesDomainService.getNumberOfOffersByStructureSize(idCentreGestion, uneAnnee, etat, validation, publication);
				message = getString("OFFRES.STATS.SIZE");
			}
			else if ("DEPGEO".equals(critereDeuxCle)){
				statsItemList = statistiquesDomainService.getNumberOfOffersByStructureDep(idCentreGestion, uneAnnee, etat, validation, publication);
				message = getString("OFFRES.STATS.DEPGEO");
			}
			else if ("PAYS".equals(critereDeuxCle)){
				statsItemList = statistiquesDomainService.getNumberOfOffersByStructureCountry(idCentreGestion, uneAnnee, etat, validation, publication);
				message = getString("OFFRES.STATS.PAYS");
			}
			else if ("POURVU".equals(critereDeuxCle)){
				statsItemList = statistiquesDomainService.getNumberOfOffersByCandidateFound(idCentreGestion, uneAnnee, etat, validation, publication);
				message = getString("OFFRES.STATS.POURVU");
			}
			else if ("ORI".equals(critereDeuxCle)){
				statsItemList = statistiquesDomainService.getNumberOfOffersByLocalStudent(idCentreGestion, uneAnnee, etat, validation, publication);
				message = getString("OFFRES.STATS.ORI");
			}

			else if ("".equals(critereDeuxCle)){
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
				if (!"".equals(critereDeuxCle)){
					message = message + getString("OFFRES.STATS.VAL.ET");
				}

			}
			else{
				if (publication && !"".equals(critereDeuxCle)){
						message = message + getString("OFFRES.STATS.PUB.ET");
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
				if (total != 0) {
					pourcentage = (unItem.getNumber() * 100) / total;
				} else {
					pourcentage = 0;
				}
				//pourcentage = arrondiNDecimales(pourcentage,2);
				unItem.setPercentage(pourcentage);
				//System.out.println("pourcentage="+pourcentage);
			}
			map.put(uneAnnee,statsItemList);
		}

		getSessionController().setConsultationCentreCurrentPage("_consultationCentre_statsOffres");
	}

	public void edition () throws ServletException, IOException{

		String statType = "offre";

		EditXlsServlet edit = new EditXlsServlet();
		edit.doGet(statType, critereUnCle, critereDeuxCle, map);
	}

	/**
	 * @return the annee_scolaire
	 */
	public String getAnnee_scolaire() {
		return annee_scolaire;
	}

	/**
	 * @param annee_scolaire the annee_scolaire to set
	 */
	public void setAnnee_scolaire(String annee_scolaire) {
		this.annee_scolaire = annee_scolaire;
	}

	/**
	 * @return List<SelectItem>
	 * @throws StatistiquesException 
	 */
	public List<SelectItem> getAnneesOffres() throws StatistiquesException {

		if (this.anneesOffres == null || this.anneesOffres.isEmpty()){
			this.anneesOffres = new ArrayList<SelectItem>();

			List<String> an = getStatistiquesDomainService().getAnneesOffres(this.idCentreGestion, "SansETAT");

			if(an!=null && !an.isEmpty()){
				for(String s : an){
					this.anneesOffres.add(new SelectItem(s,s));
				}
			}
		}

		return this.anneesOffres;
	}
	/**
	 * @param anneesOffres the anneesOffres to set
	 */
	public void setAnneesOffres(List<SelectItem> anneesOffres) {
		this.anneesOffres = anneesOffres;
	}
}
