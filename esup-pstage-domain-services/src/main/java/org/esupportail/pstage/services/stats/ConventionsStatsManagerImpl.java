package org.esupportail.pstage.services.stats;

import java.util.Map;

import org.apache.log4j.Logger;

public class ConventionsStatsManagerImpl implements ConventionsStatsManager {
	private final static Logger logger= Logger.getLogger(ConventionsStatsManagerImpl.class);
	
private AbstractStatsBuilder abstractStatsBuilder;


/**
 * @param abstractStatsBuilder the abstractStatsBuilder to set
 */
public void setAbstractStatsBuilder(AbstractStatsBuilder abstractStatsBuilder) {
	this.abstractStatsBuilder = abstractStatsBuilder;
}

/* (non-Javadoc)
 * @see org.esupportail.pstage.services.stats.ConventionsStatsManager#getConteneurCriteresEtStats()
 */
public ConteneurCriteresEtStats   getConteneurCriteresEtStats(){
	
	return abstractStatsBuilder.getConteneurCriteresEtStats();
}

/* (non-Javadoc)
 * @see org.esupportail.pstage.services.stats.ConventionsStatsManager#construireStats(java.lang.String, java.lang.Integer, java.lang.String)
 */
public void construireStats(String choix2, Integer idCentreGestion, String etat){
	Map<String, String> prepareStats = abstractStatsBuilder.prepareStats();
	 String methode = prepareStats.get(choix2);
	try {
		abstractStatsBuilder.construire(choix2, methode,idCentreGestion,etat);
	} catch (ClassNotFoundException cnfd) {
		logger.error(" Reflexion probleme oups !!! ", cnfd);
	}
	
}





}
