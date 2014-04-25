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
	 * col12 , Libell� Etape.
	 */
	col12("EXPORTCONVENTION.LIBELLEETAPE", "etape.libelle"),
	
	/**
	 * col13 , Date D�but Stage.
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
	 * col21 , D�tails.
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
	 * col29 , Nom enseignant.
	 */
	col29("EXPORTCONVENTION.NOM.ENSEIGNANT", "enseignant.nom"),
	
	/**
	 * col30 , Prenom enseignant.
	 */
	col30("EXPORTCONVENTION.PRENOM.ENSEIGNANT", "enseignant.prenom"),
	
	/**
	 * col31 , Mail enseignant.
	 */
	col31("EXPORTCONVENTION.MAIL.ENSEIGNANT", "enseignant.mail"),
	
	/**
	 * col32 , Nom signataire.
	 */
	col32("EXPORTCONVENTION.NOM.SIGNATAIRE", "signataire.nom"),
	
	/**
	 * col33 , Prenom signataire.
	 */
	col33("EXPORTCONVENTION.PRENOM.SIGNATAIRE", "signataire.prenom"),
	
	/**
	 * col34 , Mail signataire.
	 */
	col34("EXPORTCONVENTION.MAIL.SIGNATAIRE", "signataire.mail"),
	
	/**
	 * col35 , Fonction signataire.
	 */
	col35("EXPORTCONVENTION.FONCTION.SIGNATAIRE", "signataire.fonction"),
	
	/**
	 * col36 , Annee Universitaire.
	 */
	col36("EXPORTCONVENTION.ANNEEUNIV", "annee"),
	
	/**
	 * col37 , type de convention.
	 */
	col37("EXPORTCONVENTION.TYPECONVENTION", "typeConvention.libelle"),
	
	/**
	 * col38 , commentaire stage.
	 */
	col38("EXPORTCONVENTION.COMMENTAIRESTAGE", "commentaireStage"),
	
	/**
	 * col39 , commentaire stage.
	 */
	col39("EXPORTCONVENTION.COMMENTAIREDUREETRAVAIL", "commentaireDureeTravail"),
	
    /**
     * col40 , Element pédagogique - CODE
     */
    col40("EXPORTCONVENTION.CODEELP", "codeElp"),
    
    /**
     * col41 , Element pédagogique - LIBELLE
     */
    col41("EXPORTCONVENTION.LIBELLEELP", "libelleElp"),
    
    /**
     * col42 , code sexe etudiant
     */
    col42("EXPORTCONVENTION.CODESEXEETUDIANT", "etudiant.codeSexe"),
    
    /**
     * col43 , avantages nature
     */
    col43("EXPORTCONVENTION.AVANTAGESNATURE", "avantagesNature"),
    
    /**
     * col44 , adresse etudiant
     */
    col44("EXPORTCONVENTION.ADRESSETU", "adresseEtudiant"),
    
    /**
     * col45 , code postal etudiant
     */
    col45("EXPORTCONVENTION.CODEPOSTALETU", "codePostalEtudiant"),
    
    /**
     * col46 , pays etudiant
     */
    col46("EXPORTCONVENTION.PAYSETU", "paysEtudiant"),
    
    /**
     * col47 , ville etudiant
     */
    col47("EXPORTCONVENTION.VILLEETU", "villeEtudiant");
	
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
