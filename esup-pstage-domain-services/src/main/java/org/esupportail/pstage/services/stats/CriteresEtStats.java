package org.esupportail.pstage.services.stats;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.esupportail.pstagedata.domain.dto.StatisticItemDTO;

/**
 * 
 * Gestion des stats selon un crit&#232;re principale et une listes de crit&#232;res 
 * secondaires
 *
 */
public class CriteresEtStats {
	private String criterePrincipale;
	private String critereSecondaire;

	private Map<String,List<StatisticItemDTO>> statistiques = new HashMap<String, List<StatisticItemDTO>>();

	/**
	 * @return the criterePrincipale
	 */
	public String getCriterePrincipale() {
		return criterePrincipale;
	}
	/**
	 * @param criterePrincipale the criterePrincipale to set
	 */
	public void setCriterePrincipale(String criterePrincipale) {
		this.criterePrincipale = criterePrincipale;
	}
	/**
	 * @return the critereSecondaire
	 */
	public String getCritereSecondaire() {
		return critereSecondaire;
	}
	/**
	 * @param critereSecondaire the critereSecondaire to set
	 */
	public void setCritereSecondaire(String critereSecondaire) {
		this.critereSecondaire = critereSecondaire;
	}
	/**
	 * @return the statistiques
	 */
	public Map<String, List<StatisticItemDTO>> getStatistiques() {
		return statistiques;
	}
	/**
	 * @param statistiques the statistiques to set
	 */
	public void setStatistiques(Map<String, List<StatisticItemDTO>> statistiques) {
		this.statistiques = statistiques;
	}

	public void ajouter(String uneAnne ,List<StatisticItemDTO> statsSurUneAnnee){
		this.statistiques.put(uneAnne, statsSurUneAnnee);
	}

}
