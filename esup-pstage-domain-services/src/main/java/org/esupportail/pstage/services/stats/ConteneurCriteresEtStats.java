package org.esupportail.pstage.services.stats;

import java.util.ArrayList;
import java.util.List;

public class ConteneurCriteresEtStats {
	/**
	 * exemple les criters sur le choix UFR 
	 */
	private List<CriteresEtStats> criteresParCategories=new ArrayList<CriteresEtStats>();
	
	
  private String criterePrincipale;

/**
 * @return the criterePrincipale
 */
public String getCriterePrincipale() {
	return criterePrincipale;
}

/**
 * @param criterePrincipale the criterePrincipale to set
 */
public void setCriterePrincipale(String secondCritere) {
	this.criterePrincipale = secondCritere;
}

public void ajouter(CriteresEtStats unCriteresEtStats){
	this.criteresParCategories.add(unCriteresEtStats);
}

public CriteresEtStats getOne(String choix2) {
	
	CriteresEtStats resultat = null;
	
for(CriteresEtStats cs : this.criteresParCategories){
	if(cs.getCritereSecondaire().equals(choix2)){
		
		resultat = cs;
		break;
	}
}
	return resultat;
}
}
