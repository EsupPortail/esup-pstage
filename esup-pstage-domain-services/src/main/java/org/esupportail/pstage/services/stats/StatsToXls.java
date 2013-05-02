package org.esupportail.pstage.services.stats;

import java.util.List;
import java.util.Map;

import org.esupportail.pstagedata.domain.dto.StatisticItemDTO;

public class StatsToXls {

	private String titre;
	private String code;
	private String firstLevelStatCriterium;
	private String secondLevelStatCriterium;
	private String nomCentreGestion;

	private String codeDesc;
	private String annee;
	private String firstLevelDesc;
	private String secondLevelDesc;
	private int nombreStage;

	private CriteresEtStats criteresEtStats = new CriteresEtStats();

	private Map<String, List<StatisticItemDTO>> stats;
	/**
	 * @return the titre
	 */
	public String getTitre() {
		return titre;
	}
	/**
	 * @param titre the titre to set
	 */
	public void setTitre(String titre) {
		this.titre = titre;
		formatTitre();
		
	}
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
		this.formatCode();
	}
	/**
	 * @return the firstLevelStatCriterium
	 */
	public String getFirstLevelStatCriterium() {
		return firstLevelStatCriterium;
	}
	/**
	 * @param firstLevelStatCriterium the firstLevelStatCriterium to set
	 */
	public void setFirstLevelStatCriterium(String firstLevelStatCriterium) {
		this.firstLevelStatCriterium = firstLevelStatCriterium;
	}
	/**
	 * @return the secondLevelStatCriterium
	 */
	public String getSecondLevelStatCriterium() {
		return secondLevelStatCriterium;
	}
	/**
	 * @param secondLevelStatCriterium the secondLevelStatCriterium to set
	 */
	public void setSecondLevelStatCriterium(String scdlsCrit) {
		this.secondLevelStatCriterium = scdlsCrit;
	}


	private void formatCode(){
		StringBuilder builder = new StringBuilder("Code ").append(this.code);
		this.code = builder.toString();
	}


	private void formatTitre(){
		StringBuilder builder = new StringBuilder("Nombre de stages par ");
		builder.append(this.firstLevelStatCriterium);
		builder.append(" et par ");
		builder.append(this.secondLevelStatCriterium);
		builder.append(" pour le centre de gestion ");
		builder.append(nomCentreGestion);
		this.titre = builder.toString();
	}
	/**
	 * @return the nomCentreGestion
	 */
	public String getNomCentreGestion() {
		return nomCentreGestion;
	}
	/**
	 * @param nomCentreGestion the nomCentreGestion to set
	 */
	public void setNomCentreGestion(String nomCentreGestion) {
		this.nomCentreGestion = nomCentreGestion;
	}
	/**
	 * @return the stats
	 */
	public Map<String, List<StatisticItemDTO>> getStats() {
		
		return stats;
	}
	/**
	 * @param stats the stats to set
	 */
	public void setStats(Map<String, List<StatisticItemDTO>> stats) {

		this.stats = stats;
		
		
	}
	/**
	 * @return the criteresEtStats
	 */
	public CriteresEtStats getCriteresEtStats() {
		return criteresEtStats;
	}


	/**
	 * @param criteresEtStats the criteresEtStats to set
	 */
	public void setCriteresEtStats(CriteresEtStats criteresEtStats) {
		this.criteresEtStats = criteresEtStats;
	}
	/**
	 * @return the codeDesc
	 */
	public String getCodeDesc() {
		return codeDesc;
	}
	/**
	 * @param codeDesc the codeDesc to set
	 */
	public void setCodeDesc(String codeDesc) {
		this.codeDesc = codeDesc;
	}
	/**
	 * @return the annee
	 */
	public String getAnnee() {
		return annee;
	}
	/**
	 * @param annee the annee to set
	 */
	public void setAnnee(String annee) {
		this.annee = annee;
	}
	/**
	 * @return the firstLevelDesc
	 */
	public String getFirstLevelDesc() {
		return firstLevelDesc;
	}
	/**
	 * @param firstLevelDesc the firstLevelDesc to set
	 */
	public void setFirstLevelDesc(String firstLevelDesc) {
		this.firstLevelDesc = firstLevelDesc;
	}
	/**
	 * @return the secondLevelDesc
	 */
	public String getSecondLevelDesc() {
		return secondLevelDesc;
	}
	/**
	 * @param secondLevelDesc the secondLevelDesc to set
	 */
	public void setSecondLevelDesc(String secondLevelDesc) {
		this.secondLevelDesc = secondLevelDesc;
	}
	/**
	 * @return the nombreStage
	 */
	public int getNombreStage() {
		return nombreStage;
	}
	/**
	 * @param nombreStage the nombreStage to set
	 */
	public void setNombreStage(int nombreStage) {
		this.nombreStage = nombreStage;
	}
}
