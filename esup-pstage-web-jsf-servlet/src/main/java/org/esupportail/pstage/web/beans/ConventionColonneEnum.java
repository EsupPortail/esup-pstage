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
	 * col28 , Unite Duree Gratification.
	 */
	col28("EXPORTCONVENTION.UNITEDUREEGRATIF", "uniteDureeGratification.libelle"),
	
	/**
	 * col29 , Convention Validee.
	 */
	col29("EXPORTCONVENTION.VALIDEE", "validationConventionExport"),
	
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
	 * col33 , Nom signataire.
	 */
	col33("EXPORTCONVENTION.NOM.SIGNATAIRE", "signataire.nom"),
	
	/**
	 * col34 , Prenom signataire.
	 */
	col34("EXPORTCONVENTION.PRENOM.SIGNATAIRE", "signataire.prenom"),
	
	/**
	 * col35 , Mail signataire.
	 */
	col35("EXPORTCONVENTION.MAIL.SIGNATAIRE", "signataire.mail"),
	
	/**
	 * col36 , Fonction signataire.
	 */
	col36("EXPORTCONVENTION.FONCTION.SIGNATAIRE", "signataire.fonction"),
	
	/**
	 * col37 , Annee Universitaire.
	 */
	col37("EXPORTCONVENTION.ANNEEUNIV", "annee"),
	
	/**
	 * col38 , type de convention.
	 */
	col38("EXPORTCONVENTION.TYPECONVENTION", "typeConvention.libelle"),
	
	/**
	 * col39 , commentaire stage.
	 */
	col39("EXPORTCONVENTION.COMMENTAIRESTAGE", "commentaireStage"),
	
	/**
	 * col40 , commentaire stage.
	 */
	col40("EXPORTCONVENTION.COMMENTAIREDUREETRAVAIL", "commentaireDureeTravail"),
	
    /**
     * col41 , Element pédagogique - CODE
     */
    col41("EXPORTCONVENTION.CODEELP", "codeElp"),
    
    /**
     * col42 , Element pédagogique - LIBELLE
     */
    col42("EXPORTCONVENTION.LIBELLEELP", "libelleElp"),
    
    /**
     * col43 , code sexe etudiant
     */
    col43("EXPORTCONVENTION.CODESEXEETUDIANT", "etudiant.codeSexe"),
    
    /**
     * col44 , avantages nature
     */
    col44("EXPORTCONVENTION.AVANTAGESNATURE", "avantagesNature"),
    
    /**
     * col45 , adresse etudiant
     */
    col45("EXPORTCONVENTION.ADRESSETU", "adresseEtudiant"),
    
    /**
     * col46 , code postal etudiant
     */
    col46("EXPORTCONVENTION.CODEPOSTALETU", "codePostalEtudiant"),
    
    /**
     * col47 , pays etudiant
     */
    col47("EXPORTCONVENTION.PAYSETU", "paysEtudiant"),
    
    /**
     * col48 , ville etudiant
     */
    col48("EXPORTCONVENTION.VILLEETU", "villeEtudiant"),
    
    /**
     * col49 , mail etudiant
     */
    col49("EXPORTCONVENTION.MAILUNIVETU", "etudiant.mail"),
	
	/**
	 *   Convention Pedagogique Validee
	 */
	col50("EXPORTCONVENTION.VALIDEE.PEDAGOGIQUEMENT","validationPedagogiqueExport");
	
	
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
