/**
 * 
 */
package org.esupportail.pstage.domain.beans;

import org.esupportail.commons.utils.Assert;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author M
 *
 */
public class LdapAttributes implements InitializingBean {


	/*
	 ******************* PROPERTIES ******************* */

	/**
	 * ldapBase
	 */
	private String ldapBase;
	/**
	 * ldapUid
	 */
	private String ldapUid;
	/**
	 * ldapName
	 */
	private String ldapName;
	/**
	 * ldapFirstName
	 */
	private String ldapFirstName;
	/**
	 * ldapMail
	 */
	private String ldapMail;
	/**
	 * ldapStudentId
	 */
	private String ldapStudentId;
	/**
	 * ldapStudentAffectation
	 */
	private String ldapStudentAffectation;
	/**
	 * ldapMemberAffectation
	 */
	private String ldapMemberAffectation;

	/**
	 * ldapMemberLibelleAffectation
	 */
	private String ldapMemberLibelleAffectation;
	/**
	 * ldapMemberType
	 */
	private String ldapMemberType;
	/**
	 * ldapMemberPhone
	 */
	private String ldapMemberPhone;
	/**
	 * ldapMemberCampus
	 */
	private String ldapMemberCampus;
	/**
	 * ldapMemberRoom
	 */
	private String ldapMemberRoom;
	/**
	 * ldapMemberBuilding
	 */
	private String ldapMemberBuilding;
	/**
	 * ldapMemberCivility
	 */
	private String ldapMemberCivility;
	/**
	 * dn composante
	 */
	private String ldapComposante;
	/**
	 * ldapComposanteLibelle
	 */
	private String ldapComposanteLibelle;
	/**
	 * ldapComposanteCode
	 */
	private String ldapComposanteCode;
	/**
	 * ldapStudentAffiliation
	 */
	private String ldapStudentAffiliation;
	/**
	 * ldapEmployeeAffiliation
	 */
	private String ldapEmployeeAffiliation;
	/**
	 * ldapFacultytAffiliation
	 */
	private String ldapFacultytAffiliation;
	/**
	 * ldapMemeCodeApogeeLdap
	 */
	private boolean ldapMemeCodeApogeeLdap=false;
	/**
	 * ldapComposanteFilter
	 */
	private String ldapComposanteFilter;
	/**
	 * ldapComposanteApogee
	 */
	private String ldapCodeComposanteApogee;
	/**
	 * ldapAffiliation
	 */
	private String ldapAffiliation;

	/**
	 * code etape d'inscription d'un etudiant
	 */

	private String ldapStudentStep;

	/**
	 * 
	 */
	private String ldapDisplayname;

	/**
	 * attributs , memberType d'un enseignant  ne pouvant etre tuteur 
	 */
	private String ldapFacultyNonTuteur;

	/**
	 * uids  des employes  pouvant etre tuteur 
	 */
	private String ldapEmployeeTuteur;
	/*
	 ******************* INIT ************************* */
	/**
	 * @return the ldapEmployeeTuteur
	 */
	public String getLdapEmployeeTuteur() {
		return ldapEmployeeTuteur;
	}

	/**
	 * @param ldapEmployeeTuteur the ldapEmployeeTuteur to set
	 */
	public void setLdapEmployeeTuteur(String ldapEmployeeTuteur) {
		this.ldapEmployeeTuteur = ldapEmployeeTuteur;
	}
	/**
	 * @return the ldapFacultyNonTuteur
	 */
	public String getLdapFacultyNonTuteur() {
		return ldapFacultyNonTuteur;
	}

	/**
	 * @param ldapFacultyNonTuteur the ldapFacultyNonTuteur to set
	 */
	public void setLdapFacultyNonTuteur(String ldapFacultyNonTuteur) {
		this.ldapFacultyNonTuteur = ldapFacultyNonTuteur;
	}

	/**
	 * @return the ldapDisplayname
	 */
	public String getLdapDisplayname() {
		return ldapDisplayname;
	}

	/**
	 * @param ldapDisplayname the ldapDisplayname to set
	 */
	public void setLdapDisplayname(String ldapDisplayname) {
		this.ldapDisplayname = ldapDisplayname;
	}

	/**
	 * @return the ldapStudentStep
	 */
	public String getLdapStudentStep() {
		return ldapStudentStep;
	}

	/**
	 * @param ldapStudentStep the ldapStudentStep to set
	 */
	public void setLdapStudentStep(String ldapStudentStep) {
		this.ldapStudentStep = ldapStudentStep;
	}

	/**
	 * Constructors.
	 */
	public LdapAttributes() {
		super();
	}

	/**
	 * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	 */
	public void afterPropertiesSet() throws Exception {

		Assert.notNull(this.ldapUid, 
				"property ldapUid of class " + this.getClass().getName() 
				+ " can not be null");
		Assert.notNull(this.ldapName, 
				"property ldapName of class " + this.getClass().getName() 
				+ " can not be null");
		Assert.hasText(this.ldapFirstName, 
				"property ldapFirstName of class " + this.getClass().getName() 
				+ " can not be null");
		Assert.hasText(this.ldapStudentId, 
				"property ldapStudentId of class " + this.getClass().getName() 
				+ " can not be null");
		Assert.hasText(this.ldapStudentAffectation, 
				"property ldapStudentAffectation of class " + this.getClass().getName() 
				+ " can not be null");
		Assert.hasText(this.ldapMemberAffectation, 
				"property ldapMemberAffectation of class " + this.getClass().getName() 
				+ " can not be null");
		Assert.hasText(this.ldapMemberType, 
				"property ldapMemberType of class " + this.getClass().getName() 
				+ " can not be null");
		Assert.hasText(this.ldapStudentAffiliation, 
				"property ldapStudentAffiliation of class " + this.getClass().getName() 
				+ " can not be null");
		Assert.hasText(this.ldapEmployeeAffiliation, 
				"property ldapEmployeeAffiliation of class " + this.getClass().getName() 
				+ " can not be null");
		Assert.hasText(this.ldapFacultytAffiliation, 
				"property ldapFacultytAffiliation of class " + this.getClass().getName() 
				+ " can not be null");
		Assert.hasText(this.ldapAffiliation, 
				"property ldapAffiliation of class " + this.getClass().getName() 
				+ " can not be null");

	}

	/*
	 ******************* METHODS ********************** */

	/*
	 ******************* ACCESSORS ******************** */

	/**
	 * @return the ldapUid
	 */
	public String getLdapUid() {
		return ldapUid;
	}

	/**
	 * @return the ldapBase
	 */
	public String getLdapBase() {
		return ldapBase;
	}

	/**
	 * @param ldapBase the ldapBase to set
	 */
	public void setLdapBase(String ldapBase) {
		this.ldapBase = ldapBase;
	}

	/**
	 * @param ldapUid the ldapUid to set
	 */
	public void setLdapUid(String ldapUid) {
		this.ldapUid = ldapUid;
	}

	/**
	 * @return the ldapName
	 */
	public String getLdapName() {
		return ldapName;
	}

	/**
	 * @param ldapName the ldapName to set
	 */
	public void setLdapName(String ldapName) {
		this.ldapName = ldapName;
	}

	/**
	 * @return the ldapFirstName
	 */
	public String getLdapFirstName() {
		return ldapFirstName;
	}

	/**
	 * @param ldapFirstName the ldapFirstName to set
	 */
	public void setLdapFirstName(String ldapFirstName) {
		this.ldapFirstName = ldapFirstName;
	}


	/**
	 * @return the ldapMail
	 */
	public String getLdapMail() {
		return ldapMail;
	}

	/**
	 * @param ldapMail the ldapMail to set
	 */
	public void setLdapMail(String ldapMail) {
		this.ldapMail = ldapMail;
	}

	/**
	 * @return the ldapStudentId
	 */
	public String getLdapStudentId() {
		return ldapStudentId;
	}

	/**
	 * @param ldapStudentId the ldapStudentId to set
	 */
	public void setLdapStudentId(String ldapStudentId) {
		this.ldapStudentId = ldapStudentId;
	}

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

	/**
	 * @return the ldapMemberAffectation
	 */
	public String getLdapMemberAffectation() {
		return ldapMemberAffectation;
	}

	/**
	 * @param ldapMemberAffectation the ldapMemberAffectation to set
	 */
	public void setLdapMemberAffectation(String ldapMemberAffectation) {
		this.ldapMemberAffectation = ldapMemberAffectation;
	}

	/**
	 * @return the ldapMemberType
	 */
	public String getLdapMemberType() {
		return ldapMemberType;
	}

	/**
	 * @param ldapMemberType the ldapMemberType to set
	 */
	public void setLdapMemberType(String ldapMemberType) {
		this.ldapMemberType = ldapMemberType;
	}

	/**
	 * @return the ldapMemberPhone
	 */
	public String getLdapMemberPhone() {
		return ldapMemberPhone;
	}

	/**
	 * @param ldapMemberPhone the ldapMemberPhone to set
	 */
	public void setLdapMemberPhone(String ldapMemberPhone) {
		this.ldapMemberPhone = ldapMemberPhone;
	}

	/**
	 * @return the ldapMemberCampus
	 */
	public String getLdapMemberCampus() {
		return ldapMemberCampus;
	}

	/**
	 * @param ldapMemberCampus the ldapMemberCampus to set
	 */
	public void setLdapMemberCampus(String ldapMemberCampus) {
		this.ldapMemberCampus = ldapMemberCampus;
	}

	/**
	 * @return the ldapMemberRoom
	 */
	public String getLdapMemberRoom() {
		return ldapMemberRoom;
	}

	/**
	 * @param ldapMemberRoom the ldapMemberRoom to set
	 */
	public void setLdapMemberRoom(String ldapMemberRoom) {
		this.ldapMemberRoom = ldapMemberRoom;
	}

	/**
	 * @return the ldapMemberBuilding
	 */
	public String getLdapMemberBuilding() {
		return ldapMemberBuilding;
	}

	/**
	 * @param ldapMemberBuilding the ldapMemberBuilding to set
	 */
	public void setLdapMemberBuilding(String ldapMemberBuilding) {
		this.ldapMemberBuilding = ldapMemberBuilding;
	}

	/**
	 * @return the ldapMemberCivility
	 */
	public String getLdapMemberCivility() {
		return ldapMemberCivility;
	}

	/**
	 * @param ldapMemberCivility the ldapMemberCivility to set
	 */
	public void setLdapMemberCivility(String ldapMemberCivility) {
		this.ldapMemberCivility = ldapMemberCivility;
	}

	/**
	 * @return the ldapComposante
	 */
	public String getLdapComposante() {
		return ldapComposante;
	}

	/**
	 * @param ldapComposante the ldapComposante to set
	 */
	public void setLdapComposante(String ldapComposante) {
		this.ldapComposante = ldapComposante;
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

	/**
	 * @return the ldapStudentAffiliation
	 */
	public String getLdapStudentAffiliation() {
		return ldapStudentAffiliation;
	}

	/**
	 * @param ldapStudentAffiliation the ldapStudentAffiliation to set
	 */
	public void setLdapStudentAffiliation(String ldapStudentAffiliation) {
		this.ldapStudentAffiliation = ldapStudentAffiliation;
	}

	/**
	 * @return the ldapEmployeeAffiliation
	 */
	public String getLdapEmployeeAffiliation() {
		return ldapEmployeeAffiliation;
	}

	/**
	 * @param ldapEmployeeAffiliation the ldapEmployeeAffiliation to set
	 */
	public void setLdapEmployeeAffiliation(String ldapEmployeeAffiliation) {
		this.ldapEmployeeAffiliation = ldapEmployeeAffiliation;
	}

	/**
	 * @return the ldapFacultytAffiliation
	 */
	public String getLdapFacultytAffiliation() {
		return ldapFacultytAffiliation;
	}

	/**
	 * @param ldapFacultytAffiliation the ldapFacultytAffiliation to set
	 */
	public void setLdapFacultytAffiliation(String ldapFacultytAffiliation) {
		this.ldapFacultytAffiliation = ldapFacultytAffiliation;
	}

	/**
	 * @return the ldapComposanteFilter
	 */
	public String getLdapComposanteFilter() {
		return ldapComposanteFilter;
	}

	/**
	 * @param ldapComposanteFilter the ldapComposanteFilter to set
	 */
	public void setLdapComposanteFilter(String ldapComposanteFilter) {
		this.ldapComposanteFilter = ldapComposanteFilter;
	}

	/**
	 * @return the ldapMemeCodeApogeeLdap
	 */
	public boolean isLdapMemeCodeApogeeLdap() {
		return ldapMemeCodeApogeeLdap;
	}

	/**
	 * @param ldapMemeCodeApogeeLdap the ldapMemeCodeApogeeLdap to set
	 */
	public void setLdapMemeCodeApogeeLdap(boolean ldapMemeCodeApogeeLdap) {
		this.ldapMemeCodeApogeeLdap = ldapMemeCodeApogeeLdap;
	}

	/**
	 * @return the ldapCodeComposanteApogee
	 */
	public String getLdapCodeComposanteApogee() {
		return ldapCodeComposanteApogee;
	}

	/**
	 * @param ldapCodeComposanteApogee the ldapCodeComposanteApogee to set
	 */
	public void setLdapCodeComposanteApogee(String ldapCodeComposanteApogee) {
		this.ldapCodeComposanteApogee = ldapCodeComposanteApogee;
	}

	/**
	 * @return the ldapAffiliation
	 */
	public String getLdapAffiliation() {
		return ldapAffiliation;
	}

	/**
	 * @param ldapAffiliation the ldapAffiliation to set
	 */
	public void setLdapAffiliation(String ldapAffiliation) {
		this.ldapAffiliation = ldapAffiliation;
	}

	/**
	 * @return the ldapMemberLibelleAffectation
	 */
	public String getLdapMemberLibelleAffectation() {
		return ldapMemberLibelleAffectation;
	}

	/**
	 * @param ldapMemberLibelleAffectation the ldapMemberLibelleAffectation to set
	 */
	public void setLdapMemberLibelleAffectation(String ldapMemberLibelleAffectation) {
		this.ldapMemberLibelleAffectation = ldapMemberLibelleAffectation;
	}



}
