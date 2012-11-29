package org.esupportail.pstage.domain.beans;

import java.io.Serializable;

/**
 * Filtre sur les recherches des composantes de l'annuaire.
 *
 */
@SuppressWarnings("serial")
public class LdapGroupeAttributsImpl implements LdapGroupeAttributs, Serializable {
	private String motif;
	private String  ldapComposanteLibelle;
	private String ldapComposanteCode;
	private String ldapStudentAffectation;
	
	private String ldapValCodeFormationsPrincipales;
	private String ldapCodePrincipalesFormations;
	/**
	 * @return the ldapStudentAffectation
	 */
	public String getLdapStudentAffectation() {
		return ldapStudentAffectation;
	}

	/**
	 * @param ldapStudentAffectation the ldapStudentAffectation to set
	 */
	public void setLdapStudentAffectation(String ldapStudentAffectation) {
		this.ldapStudentAffectation = ldapStudentAffectation;
	}

	/* (non-Javadoc)
	 * @see org.esupportail.pstage.services.ldap.LdapGroupeAttributs#getMotif()
	 */
	public String getMotif() {
		return motif;
	}

	/**
	 * @param motif the motif to set
	 */
	public void setMotif(String motif) {
		this.motif = motif;
	}

	/**
	 * @return the ldapComposanteLibelle
	 */
	public String getLdapComposanteLibelle() {
		return ldapComposanteLibelle;
	}

	/**
	 * @param ldapComposanteLibelle the ldapComposanteLibelle to set
	 */
	public void setLdapComposanteLibelle(String ldapComposanteLibelle) {
		this.ldapComposanteLibelle = ldapComposanteLibelle;
	}

	/**
	 * @return the ldapComposanteCode
	 */
	public String getLdapComposanteCode() {
		return ldapComposanteCode;
	}

	/**
	 * @param ldapComposanteCode the ldapComposanteCode to set
	 */
	public void setLdapComposanteCode(String ldapComposanteCode) {
		this.ldapComposanteCode = ldapComposanteCode;
	}
	
	@Override
	public String getLdapCodePrincipalesFormations() {
		return ldapCodePrincipalesFormations;
	}

	
	@Override
	public String getLdapValCodeFormationsPrincipales() {
		return ldapValCodeFormationsPrincipales;
	}

	/**
	 * @param ldapValCodeFormationsPrincipales the ldapValCodeFormationsPrincipales to set
	 */
	public void setLdapValCodeFormationsPrincipales(
			String ldapValCodeFormationsPrincipales) {
		this.ldapValCodeFormationsPrincipales = ldapValCodeFormationsPrincipales;
	}

	/**
	 * @param ldapCodePrincipalesFormations the ldapCodePrincipalesFormations to set
	 */
	public void setLdapCodePrincipalesFormations(
			String ldapCodePrincipalesFormations) {
		this.ldapCodePrincipalesFormations = ldapCodePrincipalesFormations;
	}


	

}
