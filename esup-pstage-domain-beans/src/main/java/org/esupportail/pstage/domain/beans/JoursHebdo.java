package org.esupportail.pstage.domain.beans;

/**
 * @author dhouillo
 *
 */
public enum JoursHebdo {
	
	/**
	 * 
	 */
	/*
	 *************************** ENUM VALUES ******************************** */
	/**
	 * 
	 */
	jours5("5","5"),
	/**
	 * 
	 */
	jours4("4","4"),
	/**
	 * 
	 */
	jours3("3","3"),
	/**
	 * 
	 */
	jours2("2","2"),
	/**
	 * 
	 */
	jours1("1","1");
	
	/*
	 *************************** PROPERTIES ******************************** */

	/**
	 * valeur
	 */
	private String valeur;
	
	/**
	 * libelle
	 */
	private String libelle;
	
	/*
	 *************************** INIT ************************************** */

	/**
	 * @param libelle
	 * @param valeur
	 */
	private JoursHebdo(String libelle, String valeur) {
		this.libelle = libelle;
		this.valeur = valeur;
	}

	/*
	 *************************** ACCESSORS ********************************* */
	
	/**
	 * @return the valeur
	 */
	public String getValeur() {
		return valeur;
	}

	/**
	 * @param valeur the valeur to set
	 */
	public void setValeur(String valeur) {
		this.valeur = valeur;
	}

	/**
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	

	
	
}
