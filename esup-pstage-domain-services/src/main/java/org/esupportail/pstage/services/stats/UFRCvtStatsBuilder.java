package org.esupportail.pstage.services.stats;

import java.util.Map;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;


public class UFRCvtStatsBuilder extends AbstractStatsBuilder  implements InitializingBean{
	
	private Map<String, String> preparedStats;


	@Override
	public void afterPropertiesSet() throws Exception {
		
		Assert.notNull(this.getConteneurCriteresEtStats(),  this.getConteneurCriteresEtStats().getClass().getName()+ " Ne doit pas etre null");
	this.getConteneurCriteresEtStats().setCriterePrincipale("UFR"); //FIXME  plutot dans config  et pareil pour les autres 
	}
	

	@Override
	public Map<String, String> prepareStats() {
		preparedStats.put(Configuration.getString("convention.type"), "getNumberOfConventionsByStudyAndType");
		preparedStats.put(Configuration.getString("convention.activite.domaine"), ""); //FIXME  methode a implementer dans remoteServices
		preparedStats.put(Configuration.getString("convention.gratification"), "getNumberOfConventionsByStudyAndIndemnity");
		preparedStats.put(Configuration.getString("convention.temps.travail"), "");//FIXME a implmenter
		preparedStats.put(Configuration.getString("convention.jour.hebdo"), "getNumberOfConventionsByStudyAndNbDaysPerWeek");
		preparedStats.put(Configuration.getString("convention.origine"), "getNumberOfConventionsByStudyAndWayToFind");
		preparedStats.put(Configuration.getString("convention.enseignat.tuteur"), "getNumberOfConventionsByStudyAndTeacherGuide");
		preparedStats.put(Configuration.getString("convention.structure"), ""); //FIXME a implementer
		preparedStats.put(Configuration.getString("convention.struct.juridique.type"), "getNumberOfConventionsByStudyAndStructureType");
		preparedStats.put(Configuration.getString("convention.struct.taille"), ""); //FIXME
		preparedStats.put(Configuration.getString("convention.dep.et.lieu"), "");
		preparedStats.put(Configuration.getString("convention.service.pays"), "");	
		preparedStats.put(Configuration.getString("convention.thematique"), " ");//FIXME  methode a implementer dans remoteService
		preparedStats.put(Configuration.getString("convention.default"), "getNumberOfConventionsByStudy");
		return preparedStats;
	}

	/**
	 * @param preparedStats the preparedStats to set
	 */
	public void setPreparedStats(Map<String, String> preparedStats) {
		this.preparedStats = preparedStats;
	}

	
}
