/**
 * 
 */
package org.esupportail.pstage.web.beans;

/**
 * @author dhouillo
 *
 */
public enum SequenceEtapeEnum {

	/*
	 ******************* ENUM VALUE ******************* */
	
	/**
	 * etape1 , etudiant
	 */
	etape1(1, "Etudiant", "creerConventionEtape1Etudiant"),
	
	/**
	 * etape 2, Etablissement d'Accueil
	 */
	etape2(2, "Etab. d'Accueil", "creerConventionEtape2Etab"),
	
	/**
	 * etape 3,Service d'accueil
	 */
	etape3(3,"Service d'accueil", "creerConventionEtape3Service"),
	
	/**
	 * etape 4, Tuteur Professionnel
	 */
	etape4(4, "Tuteur Professionnel", "creerConventionEtape4Contact"),
	
	/**
	 * etape 5, Stage
	 */
	etape5(5, "Stage", "creerConventionEtape5Stage"),
	
	/**
	 * etape6, Responsable Pédagogique
	 */
	etape6(6, "Resp. Pedagogique","creerConventionEtape6Enseignant"),
	
	/**
	 * etape7, Signataire
	 */
	etape7(7, "Signataire","creerConventionEtape7Signataire"),
	
	/**
	 * etape 8, Récapitulatif
	 */
	etape8(8,"Recapitulatif","creerConventionEtape8Recap"),
	
	/**
	 * etape 9, Impression
	 */
	//etape9(9,"Impression","creerConventionEtape9Impression"),
	
	/**
	 * etape 10,  
	 */
	etape10(10," ","");
	
	/*
	 ******************* PROPERTIES ******************* */
	
	/**
	 * number etape.
	 */
	private int numEtape;

	/**
	 * titre
	 */
	private String title;
	
	/**
	 * bouton disabled
	 */
	private Boolean disabled;
	
	/**
	 * actionEtape
	 */
	private String actionEtape;
	

	/*
	 ******************* INIT ******************* */
	/**
	 * @param numEtape
	 * @param title
	 * @param actionEtape
	 */
	private SequenceEtapeEnum(int numEtape, String title, String actionEtape) {
		this.numEtape = numEtape;
		this.title = title;
		disabled = true;
		this.actionEtape = actionEtape;
	}
	
	/*
	 ******************* METHOS ******************* */
	
	/**
	 * @return the actionEtape
	 */
	public String actionEtape() {
		return actionEtape;
	}

	/*
	 ******************* ACCESSORS ******************* */
	
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * @return the disabled
	 */
	public Boolean getDisabled() {
		return disabled;
	}

	/**
	 * @param disabled the disabled to set
	 */
	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}

	/**
	 * @return the numEtape
	 */
	public int getNumEtape() {
		return numEtape;
	}

	/**
	 * @param numEtape the numEtape to set
	 */
	public void setNumEtape(int numEtape) {
		this.numEtape = numEtape;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	

	
	
}
