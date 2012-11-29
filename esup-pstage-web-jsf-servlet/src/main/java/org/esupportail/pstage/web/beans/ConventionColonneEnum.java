/**
 * 
 */
package org.esupportail.pstage.web.beans;

/**
 * @author dhouillo
 *
 */
public enum ConventionColonneEnum {

	/*
	 ******************* ENUM VALUE ******************* */
	
	/**
	 * col1 , Numero Convention.
	 */
	col1("EXPORTCONVENTION.NUMEROCONVENTION", "idConvention"),
	/**
	 * col2 , Numero Etudiant.
	 */
	col2("EXPORTCONVENTION.NUMEROETUDIANT", "etudiant.numEtudiant"),
	/**
	 * col3 , Nom Etudiant.
	 */
	col3("EXPORTCONVENTION.NOMETUDIANT", "etudiant.nom"),
	/**
	 * col4 , Prenom Etudiant.
	 */
	col4("EXPORTCONVENTION.PRENOMETUDIANT", "etudiant.prenom"),
	/**
	 * col5 , telephone perso etudiant.
	 */
	col5("EXPORTCONVENTION.TELPERSOETUDIANT", "telEtudiant"),
	
	/**
	 * col6 , telephone portable etudiant.
	 */
	col6("EXPORTCONVENTION.TELPORTABLEETUDIANT", "telPortableEtudiant"),
	
	/**
	 * col7 , mail perso etudiant.
	 */
	col7("EXPORTCONVENTION.MAILPERSOETUDIANT", "courrielPersoEtudiant"),
	
	/**
	 * col8 , Code Ufr.
	 */
	col8("EXPORTCONVENTION.CODEUFR", "ufr.code"),
	
	/**
	 * col9 , libelle Ufr.
	 */
	col9("EXPORTCONVENTION.LIBELLEUFR", "ufr.libelle"),
	
	/**
	 * col10 , Code Departement.
	 */
	col10("EXPORTCONVENTION.CODEDEPT", "codeDepartement"),
	
	/**
	 * col11 , Code Etape.
	 */
	col11("EXPORTCONVENTION.CODEETAPE", "etape.code"),
	
	/**
	 * col12 , Libellé Etape.
	 */
	col12("EXPORTCONVENTION.LIBELLEETAPE", "etape.libelle"),
	
	/**
	 * col13 , Date Début Stage.
	 */
	col13("EXPORTCONVENTION.DATEDEB", "dateDebutStage"),
	
	/**
	 * col14 , Date Fin Stage.
	 */
	col14("EXPORTCONVENTION.DATEFIN", "dateFinStage"),
	
	/**
	 * col15 , Interruption.
	 */
	col15("EXPORTCONVENTION.INTERRUPTION", "interruptionStageExport"),
	
	/**
	 * col16 , Date Debut Interruption Stage.
	 */
	col16("EXPORTCONVENTION.DATEDEB.INTERRUPT", "dateDebutInterruption"),
	
	/**
	 * col17 , Date Fin Interruption Stage.
	 */
	col17("EXPORTCONVENTION.DATEFIN.INTERRUPT", "dateFinInterruption"),
	
	/**
	 * col18 , Thematique.
	 */
	col18("EXPORTCONVENTION.THEMATIQUE", "theme.libelle"),
	
	/**
	 * col19 , Sujet.
	 */
	col19("EXPORTCONVENTION.SUJET", "sujetStage"),
	
	/**
	 * col20 , Fonction.
	 */
	col20("EXPORTCONVENTION.FONCTION", "fonctionsEtTaches"),
	
	/**
	 * col21 , Détails.
	 */
	col21("EXPORTCONVENTION.DETAIL", "details"),
	
	/**
	 * col22 , Duree.
	 */
	col22("EXPORTCONVENTION.DUREE", "dureeStage"),
	
	/**
	 * col23 , Duree.
	 */
	col23("EXPORTCONVENTION.DUREEEXCEPTION", "dureeExceptionnelle"),
	
	/**
	 * col24 , Duree.
	 */
	col24("EXPORTCONVENTION.UNITEDUREEEXCEP", "uniteDuree.libelle"),
	
	/**
	 * col25 , nb jours travail.
	 */
	col25("EXPORTCONVENTION.NBJOURS", "nbJoursHebdo"),
	
	/**
	 * col26 , Gratification.
	 */
	col26("EXPORTCONVENTION.GRATIFICATION", "montantGratification"),
	
	/**
	 * col27 , Unite Gratification.
	 */
	col27("EXPORTCONVENTION.UNITEGRATIFICATION", "uniteGratification.libelle"),
	
	/**
	 * col28 , Convention Validee.
	 */
	col28("EXPORTCONVENTION.VALIDEE", "validationConventionExport"),
	/**
	 * col29 , Civilite enseignant.
	 */
	col29("EXPORTCONVENTION.CIVILITE.ENSEIGNANT", "enseignant.civilite.libelle"),
	
	/**
	 * col30 , Nom enseignant.
	 */
	col30("EXPORTCONVENTION.NOM.ENSEIGNANT", "enseignant.nom"),
	
	/**
	 * col31 , Prenom enseignant.
	 */
	col31("EXPORTCONVENTION.PRENOM.ENSEIGNANT", "enseignant.prenom"),
	
	/**
	 * col32 , Mail enseignant.
	 */
	col32("EXPORTCONVENTION.MAIL.ENSEIGNANT", "enseignant.mail"),
	
	/**
	 * col33 , Civilite signataire.
	 */
	col33("EXPORTCONVENTION.CIVILITE.SIGNATAIRE", "signataire.civilite.libelle"),
	
	/**
	 * col34 , Nom signataire.
	 */
	col34("EXPORTCONVENTION.NOM.SIGNATAIRE", "signataire.nom"),
	
	/**
	 * col35 , Prenom signataire.
	 */
	col35("EXPORTCONVENTION.PRENOM.SIGNATAIRE", "signataire.prenom"),
	
	/**
	 * col36 , Mail signataire.
	 */
	col36("EXPORTCONVENTION.MAIL.SIGNATAIRE", "signataire.mail"),
	
	/**
	 * col37 , Fonction signataire.
	 */
	col37("EXPORTCONVENTION.FONCTION.SIGNATAIRE", "signataire.fonction"),
	
	/**
	 * col38 , Annee Universitaire.
	 */
	col38("EXPORTCONVENTION.ANNEEUNIV", "annee"),
	
	/**
	 * col39 , type de convention.
	 */
	col39("EXPORTCONVENTION.TYPECONVENTION", "typeConvention.libelle");
	
	/*
	 ******************* PROPERTIES ******************* */
	
	/**
	 * i18n key to the label.
	 */
	private String keyLabel;
	
	/**
	 * nameProperty.
	 */
	private String nameProperty;

	/*
	 ******************* INIT ******************* */

	
	/**
	 * @param keyLabe
	 * @param nameProperty 
	 */
	private ConventionColonneEnum(final String keyLabe, final String nameProperty) {
		this.keyLabel = keyLabe;
		this.nameProperty = nameProperty; 
	}
	
	/*
	 ******************* METHOS ******************* */
	
	

	/*
	 ******************* ACCESSORS ******************* */


	/**
	 * @return the keyLabel
	 */
	public String getKeyLabel() {
		return keyLabel;
	}

	/**
	 * @param keyLabel the keyLabel to set
	 */
	public void setKeyLabel(final String keyLabel) {
		this.keyLabel = keyLabel;
	}

	/**
	 * @return the nameProperty
	 */
	public String getNameProperty() {
		return nameProperty;
	}

	/**
	 * @param nameProperty the nameProperty to set
	 */
	public void setNameProperty(final String nameProperty) {
		this.nameProperty = nameProperty;
	}
	
}
