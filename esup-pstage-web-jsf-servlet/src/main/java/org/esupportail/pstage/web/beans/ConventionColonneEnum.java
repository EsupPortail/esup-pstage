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
     * col8 , mail etudiant
     */
    col8("EXPORTCONVENTION.MAILUNIVETU", "etudiant.mail"),
	
	/**
	 * col9 , Code Ufr.
	 */
	col9("EXPORTCONVENTION.CODEUFR", "ufr.code"),
	
	/**
	 * col10 , libelle Ufr.
	 */
	col10("EXPORTCONVENTION.LIBELLEUFR", "ufr.libelle"),
	
	/**
	 * col11 , Code Departement.
	 */
	col11("EXPORTCONVENTION.CODEDEPT", "codeDepartement"),
	
	/**
	 * col12 , Code Etape.
	 */
	col12("EXPORTCONVENTION.CODEETAPE", "etape.code"),
	
	/**
	 * col13 , Libell� Etape.
	 */
	col13("EXPORTCONVENTION.LIBELLEETAPE", "etape.libelle"),
	
	/**
	 * col14 , Date D�but Stage.
	 */
	col14("EXPORTCONVENTION.DATEDEB", "dateDebutStage"),
	
	/**
	 * col15 , Date Fin Stage.
	 */
	col15("EXPORTCONVENTION.DATEFIN", "dateFinStage"),
	
	/**
	 * col16 , Interruption.
	 */
	col16("EXPORTCONVENTION.INTERRUPTION", "interruptionStageExport"),
	
	/**
	 * col17 , Date Debut Interruption Stage.
	 */
	col17("EXPORTCONVENTION.DATEDEB.INTERRUPT", "dateDebutInterruption"),
	
	/**
	 * col18 , Date Fin Interruption Stage.
	 */
	col18("EXPORTCONVENTION.DATEFIN.INTERRUPT", "dateFinInterruption"),
	
	/**
	 * col19 , Thematique.
	 */
	col19("EXPORTCONVENTION.THEMATIQUE", "theme.libelle"),
	
	/**
	 * col20 , Sujet.
	 */
	col20("EXPORTCONVENTION.SUJET", "sujetStage"),
	
	/**
	 * col21 , Fonction.
	 */
	col21("EXPORTCONVENTION.FONCTION", "fonctionsEtTaches"),
	
	/**
	 * col22 , D�tails.
	 */
	col22("EXPORTCONVENTION.DETAIL", "details"),
	
	/**
	 * col23 , Duree.
	 */
	col23("EXPORTCONVENTION.DUREE", "dureeStage"),
	
	/**
	 * col24 , Duree.
	 */
//	col24("EXPORTCONVENTION.DUREEEXCEPTION", "dureeExceptionnelle"),
	
	/**
	 * col25 , Duree.
	 */
//	col25("EXPORTCONVENTION.UNITEDUREEEXCEP", "uniteDuree.libelle"),
	
	/**
	 * col26 , nb jours travail.
	 */
	col26("EXPORTCONVENTION.NBJOURS", "nbJoursHebdo"),
	
	/**
	 * col27 , Gratification.
	 */
	col27("EXPORTCONVENTION.GRATIFICATION", "montantGratification"),
	
	/**
	 * col28 , Unite Gratification.
	 */
	col28("EXPORTCONVENTION.UNITEGRATIFICATION", "uniteGratification.libelle"),
	
	/**
	 * col29 , Unite Duree Gratification.
	 */
	col29("EXPORTCONVENTION.UNITEDUREEGRATIF", "uniteDureeGratification.libelle"),
	
	/**
	 * col30 , Convention Validee.
	 */
	col30("EXPORTCONVENTION.VALIDEE", "validationConventionExport"),
	
	/**
	 * col31 , Nom enseignant.
	 */
	col31("EXPORTCONVENTION.NOM.ENSEIGNANT", "enseignant.nom"),
	
	/**
	 * col32 , Prenom enseignant.
	 */
	col32("EXPORTCONVENTION.PRENOM.ENSEIGNANT", "enseignant.prenom"),
	
	/**
	 * col33 , Mail enseignant.
	 */
	col33("EXPORTCONVENTION.MAIL.ENSEIGNANT", "enseignant.mail"),
	
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
	col39("EXPORTCONVENTION.TYPECONVENTION", "typeConvention.libelle"),
	
	/**
	 * col40 , commentaire stage.
	 */
	col40("EXPORTCONVENTION.COMMENTAIRESTAGE", "commentaireStage"),
	
	/**
	 * col41 , commentaire stage.
	 */
	col41("EXPORTCONVENTION.COMMENTAIREDUREETRAVAIL", "commentaireDureeTravail"),
	
    /**
     * col42 , Element pédagogique - CODE
     */
    col42("EXPORTCONVENTION.CODEELP", "codeElp"),
    
    /**
     * col43 , Element pédagogique - LIBELLE
     */
    col43("EXPORTCONVENTION.LIBELLEELP", "libelleElp"),
    
    /**
     * col44, code sexe etudiant
     */
    col44("EXPORTCONVENTION.CODESEXEETUDIANT", "etudiant.codeSexe"),
    
    /**
     * col45 , avantages nature
     */
    col45("EXPORTCONVENTION.AVANTAGESNATURE", "avantagesNature"),
    
    /**
     * col46 , adresse etudiant
     */
    col46("EXPORTCONVENTION.ADRESSETU", "adresseEtudiant"),
    
    /**
     * col47 , code postal etudiant
     */
    col47("EXPORTCONVENTION.CODEPOSTALETU", "codePostalEtudiant"),
    
    /**
     * col48 , pays etudiant
     */
    col48("EXPORTCONVENTION.PAYSETU", "paysEtudiant"),
    
    /**
     * col49 , ville etudiant
     */
    col49("EXPORTCONVENTION.VILLEETU", "villeEtudiant"),
    	
	/**
	 *   Convention Pedagogique Validee
	 */
	col50("EXPORTCONVENTION.VALIDEE.PEDAGOGIQUEMENT","validationPedagogiqueExport"),
	
	/**
	 *   Nombre d'avenants rattaches
	 */
	col51("EXPORTCONVENTION.AVENANT","nbAvenant"),
	
	/**
	 *   Date de creation de la convention
	 */
	col52("EXPORTCONVENTION.DATECREATION","dateCreation"),
	
	/**
	 *   Date de modification de la convention
	 */
	col53("EXPORTCONVENTION.DATEMODIF","dateModif");
	
	
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
