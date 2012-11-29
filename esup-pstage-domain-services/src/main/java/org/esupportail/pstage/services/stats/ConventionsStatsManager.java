package org.esupportail.pstage.services.stats;


public interface ConventionsStatsManager {

	public ConteneurCriteresEtStats getConteneurCriteresEtStats();

	/**
	 * Contruit les stats en fonction du choix 2
	 * @param choix2
	 * @param idCentreGestion
	 * @param etat
	 */
	public void construireStats(String choix2, Integer idCentreGestion,String etat);
	public void setAbstractStatsBuilder(AbstractStatsBuilder builder);
	

}