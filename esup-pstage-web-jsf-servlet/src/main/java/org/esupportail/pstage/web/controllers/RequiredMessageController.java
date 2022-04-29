/**
 * ESUP-PStage - Copyright (c) 2006 ESUP-Portail consortium
 * http://sourcesup.cru.fr/projects/esup-pstage
 */
package org.esupportail.pstage.web.controllers;


/**
 * AccordController
 */
public class RequiredMessageController extends AbstractContextAwareController {
	
	/* ***************************************************************
	 * Propriétés
	 ****************************************************************/

	/**
	 * The serialization id.
	 */
	private static final long serialVersionUID = 1L;
	
	/* ****************************
	 * Messages Converters
	 *****************************/
	
	/* ****************************
	 * Messages Required
	 *****************************/
	
	/**
	 * Champ obligatoire
	 */
	@SuppressWarnings("unused")
	private String champObligatoire;
	
	/* ****************************
	 * Messages Validators
	 *****************************/
	
	/**
	 * Numéro Siret non valide
	 */
	@SuppressWarnings("unused")
	private String numeroSiretNonValide;
	
	/**
	 * Code NAF non valide
	 */
	@SuppressWarnings("unused")
	private String codeNafNonValide;

	/**
	 * Adresse mail non valide
	 */
	@SuppressWarnings("unused")
	private String adresseMailNonValide;
	
	/**
	 * Code postal non valide 
	 */
	@SuppressWarnings("unused")
	private String codePostalNonValide;
	
	/**
	 * Confirmation Adresse mail non valide
	 */
	@SuppressWarnings("unused")
	private String confirmationMailNonValide;

	/**
	 * Adresse mail non valide
	 */
	@SuppressWarnings("unused")
	private String siteWebNonValide;
	
	/**
	 * insee non valide
	 */
	@SuppressWarnings("unused")
	private String inseeNonValide;
	
	/**
	 * mt Gratification non valide
	 */
	@SuppressWarnings("unused")
	private String mtGratificationNonValide;
	
	/**
	 * nb Heures Hebdo non valide
	 */
	@SuppressWarnings("unused")
	private String nbHeuresHebdoNonValide;
	
	/**
	 * Champs numérique non valide si inférieur ou égal à 0
	 */
	@SuppressWarnings("unused")
	private String superieurA0;
	
	/**
	 * Champs numérique non valide si inférieur ou égal à 0
	 * et supérieur à 100
	 */
	@SuppressWarnings("unused")
	private String pourcentage;
	
	/**
	 * Nouveau mot de passe : nb cractères min et max
	 */
	@SuppressWarnings("unused")
	private String nouveauMotDePasse;
	
	/**
	 * Bean constructor.
	 */
	public RequiredMessageController() {
		super();
	}
	
	/* ***************************************************************
	 * Actions
	 ****************************************************************/

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getClass().getSimpleName() + "#" + hashCode();
	}

	/**
	 * @see org.esupportail.pstage.web.controllers.AbstractDomainAwareBean#reset()
	 */
	@Override
	public void reset() {
		super.reset();
	}

	/**
	 * @return true if the current user is allowed to view the page.
	 */
	public boolean isPageAuthorized() {
		return true;
	}
	
	/* ***************************************************************
	 * Getters / Setters
	 ****************************************************************/
	
	/**
	 * @return the champObligatoire
	 */
	public String getChampObligatoire() {
		return getFacesErrorMessage("FORM.CHAMP_OBLIGATOIRE").getSummary();
	}

	/**
	 * @return the numeroSiretNonValide
	 */
	public String getNumeroSiretNonValide() {
		return getFacesErrorMessage("STRUCTURE.NUM_SIRET.VALIDATION").getSummary();
	}

	/**
	 * @return the codeNafNonValide
	 */
	public String getCodeNafNonValide() {
		return getFacesErrorMessage("STRUCTURE.CODE_NAF.VALIDATION").getSummary();
	}

	/**
	 * @return the adresseMailNonValide
	 */
	public String getAdresseMailNonValide() {
		return getFacesErrorMessage("MAIL.VALIDATION").getSummary();
	}
	
	/**
	 * @return the codePostalNonValide
	 */
	public String getCodePostalNonValide(){
		return getFacesErrorMessage("STRUCTURE.CODE_POSTAL.VALIDATION").getSummary();
	}

	/**
	 * @return the confirmationMailNonValide
	 */
	public String getConfirmationMailNonValide() {
		return getFacesErrorMessage("CONTACT.MAIL_CONFIRMATION.VALIDATION").getSummary();
	}

	/**
	 * @return the siteWebNonValide
	 */
	public String getSiteWebNonValide() {
		return getFacesErrorMessage("STRUCTURE.SITEWEB.VALIDATION").getSummary();
	}

	/**
	 * @return the inseeNonValide
	 */
	public String getInseeNonValide() {
		return getFacesErrorMessage("CONVENTION.CREERCONVENTION.INSEE.VALIDATION").getSummary();
	}

	/**
	 * @return the mtGratificationNonValide
	 */
	public String getMtGratificationNonValide() {
		return getFacesErrorMessage("CONVENTION.CREERCONVENTION.MT.GRATIFICATION.VALIDATION").getSummary();
	}
	
	/**
	 * @return the nbHeuresHebdoNonValide
	 */
	public String getNbHeuresHebdoNonValide() {
		return getFacesErrorMessage("CONVENTION.CREERCONVENTION.NBHEURES.HEBDO.VALIDATION").getSummary();
	}
	
	/**
	 * @return the superieurA0
	 */
	public String getSuperieurA0() {
		return getFacesErrorMessage("FORM.SUPERIEURA0.VALIDATION").getSummary();
	}
	
	/**
	 * @return the pourcentage
	 */
	public String getPourcentage() {
		return getFacesErrorMessage("FORM.POURCENTAGE.VALIDATION").getSummary();
	}

	/**
	 * @return the nouveauMotDePasse
	 */
	public String getNouveauMotDePasse() {
		return getFacesErrorMessage("CONTACT.GESTION.COMPTE.CHANGEMENTMOTDEPASSE.NOUVEAUMDP.AIDE").getSummary();
	}
}
