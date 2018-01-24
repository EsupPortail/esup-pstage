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
	 * col27 , nb jours travail.
	 */
	col27("EXPORTCONVENTION.NBHEURESHEBDO", "nbHeuresHebdo"),
	
	/**
	 * col28 , Gratification.
	 */
	col28("EXPORTCONVENTION.GRATIFICATION", "montantGratification"),
	
	/**
	 * col29 , Unite Gratification.
	 */
	col29("EXPORTCONVENTION.UNITEGRATIFICATION", "uniteGratification.libelle"),
	
	/**
	 * col30 , Unite Duree Gratification.
	 */
	col30("EXPORTCONVENTION.UNITEDUREEGRATIF", "uniteDureeGratification.libelle"),
	
	/**
	 * col31 , Convention Validee.
	 */
	col31("EXPORTCONVENTION.VALIDEE", "validationConventionExport"),
	
	/**
	 * col32 , Nom enseignant.
	 */
	col32("EXPORTCONVENTION.NOM.ENSEIGNANT", "enseignant.nom"),
	
	/**
	 * col33 , Prenom enseignant.
	 */
	col33("EXPORTCONVENTION.PRENOM.ENSEIGNANT", "enseignant.prenom"),

	/**
	 * col34 , Mail enseignant.
	 */
	col34("EXPORTCONVENTION.MAIL.ENSEIGNANT", "enseignant.mail"),
	
	/**
	 * col35 , Nom signataire.
	 */
	col35("EXPORTCONVENTION.NOM.SIGNATAIRE", "signataire.nom"),
	
	/**
	 * col36 , Prenom signataire.
	 */
	col36("EXPORTCONVENTION.PRENOM.SIGNATAIRE", "signataire.prenom"),
	
	/**
	 * col37 , Mail signataire.
	 */
	col37("EXPORTCONVENTION.MAIL.SIGNATAIRE", "signataire.mail"),
	
	/**
	 * col38 , Fonction signataire.
	 */
	col38("EXPORTCONVENTION.FONCTION.SIGNATAIRE", "signataire.fonction"),
	
	/**
	 * col39 , Annee Universitaire.
	 */
	col39("EXPORTCONVENTION.ANNEEUNIV", "annee"),
	
	/**
	 * col40 , type de convention.
	 */
	col40("EXPORTCONVENTION.TYPECONVENTION", "typeConvention.libelle"),
	
	/**
	 * col41 , commentaire stage.
	 */
	col41("EXPORTCONVENTION.COMMENTAIRESTAGE", "commentaireStage"),
	
	/**
	 * col42 , commentaire stage.
	 */
	col42("EXPORTCONVENTION.COMMENTAIREDUREETRAVAIL", "commentaireDureeTravail"),
	
    /**
     * col43 , Element pédagogique - CODE
     */
	col43("EXPORTCONVENTION.CODEELP", "codeElp"),
    
    /**
     * col44 , Element pédagogique - LIBELLE
     */
	col44("EXPORTCONVENTION.LIBELLEELP", "libelleElp"),
    
    /**
     * col45, code sexe etudiant
     */
	col45("EXPORTCONVENTION.CODESEXEETUDIANT", "etudiant.codeSexe"),
    
    /**
     * col46 , avantages nature
     */
	col46("EXPORTCONVENTION.AVANTAGESNATURE", "avantagesNature"),
    
    /**
     * col47 , adresse etudiant
     */
	col47("EXPORTCONVENTION.ADRESSETU", "adresseEtudiant"),
    
    /**
     * col48 , code postal etudiant
     */
	col48("EXPORTCONVENTION.CODEPOSTALETU", "codePostalEtudiant"),
    
    /**
     * col49 , pays etudiant
     */
	col49("EXPORTCONVENTION.PAYSETU", "paysEtudiant"),
    
    /**
     * col50 , ville etudiant
     */
	col50("EXPORTCONVENTION.VILLEETU", "villeEtudiant"),
    	
	/**
	 *   Convention Pedagogique Validee
	 */
	col51("EXPORTCONVENTION.VALIDEE.PEDAGOGIQUEMENT","validationPedagogiqueExport"),
	
	/**
	 *   Nombre d'avenants rattaches
	 */
	col52("EXPORTCONVENTION.AVENANT","nbAvenant"),
	
	/**
	 *   Date de creation de la convention
	 */
	col53("EXPORTCONVENTION.DATECREATION","dateCreation"),

	/**
	 *   Date de modification de la convention
	 */
	col54("EXPORTCONVENTION.DATEMODIF","dateModif");
	
	
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
	ConventionColonneEnum(final String keyLabe, final String nameProperty) {
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
	void setKeyLabel(final String keyLabel) {
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
	void setNameProperty(final String nameProperty) {
		this.nameProperty = nameProperty;
	}
	
}
