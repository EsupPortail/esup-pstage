package org.esupportail.pstage.services.stats;

import java.util.HashMap;
import java.util.Map;

import org.esupportail.pstage.utils.Configuration;
import org.springframework.beans.factory.InitializingBean;

public class DefaultCvtStatsBuilder extends AbstractStatsBuilder implements InitializingBean{
	//critere principale=chainevide ou autre
	private Map<String, String> preparedStats;
	@Override
	public Map<String, String> prepareStats() {
		preparedStats.put(Configuration.getString("convention.type"), "getTotalConventionsParType");
		preparedStats.put(Configuration.getString("convention.activite.domaine"), "getNumberOfConventionsByActivity"); //FIXME  methode a implementer dans remoteServices
		preparedStats.put(Configuration.getString("convention.gratification"), "getTotalConventionsParIndemnite");
		preparedStats.put(Configuration.getString("convention.temps.travail"), "getTotalConventionsParTpsDeTravail");
		preparedStats.put(Configuration.getString("convention.jour.hebdo"), "getTotalConventionsParJourSemaine");
		preparedStats.put(Configuration.getString("convention.origine"), "getTotalConventionsParOrigineStage");
		preparedStats.put(Configuration.getString("convention.enseignat.tuteur"), "getTotalConventionsParEnseignantTuteur");
		preparedStats.put(Configuration.getString("convention.structure"), "getTotalConventionsParStructure");
		preparedStats.put(Configuration.getString("convention.struct.juridique.type"), "getTotalConventionsParStructureType");
		preparedStats.put(Configuration.getString("convention.struct.taille"), "getTotalConventionsParTailleStructure");
		preparedStats.put(Configuration.getString("convention.dep.et.lieu"), "getTotalConventionsParDepLieuStage");
		preparedStats.put(Configuration.getString("convention.service.pays"), "getTotalConventionsParPaysDuService");	
		preparedStats.put(Configuration.getString("convention.thematique"), " ");//FIXME  methode a implementer dans remoteServic
		preparedStats.put(Configuration.getString("convention.default"), "getTotalConventions");
		
		// TODO Auto-generated method stub
		return preparedStats;
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		preparedStats = new HashMap<String, String>();
		this.prepareStats();
	}

	
	
}
