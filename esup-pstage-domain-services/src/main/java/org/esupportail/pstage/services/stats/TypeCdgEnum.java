package org.esupportail.pstage.services.stats;

/**
 * 
 *Enumeration pour le type de centre . CDG = niveau centre de gestion, UNIV = toute l'universite
 *
 */
public enum TypeCdgEnum {
	  CDG("CDG"), UNIV("UNIV");
	    private String type;
	 
	    private TypeCdgEnum(String type) {
	    this.type = type;
	    }

	     public String getTypeCdgEnum() {
	    return type;
	    }
}
