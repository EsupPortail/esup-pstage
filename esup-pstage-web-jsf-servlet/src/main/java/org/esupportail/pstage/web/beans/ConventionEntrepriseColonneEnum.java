/**
 * 
 */
package org.esupportail.pstage.web.beans;

/**
 * @author dhouillo
 *
 */
public enum ConventionEntrepriseColonneEnum {

	/*
	 ******************* ENUM VALUE ******************* */
	
	/**
	 * col1 , entreprise raisonSociale.
	 */
	col1("EXPORTCONVENTION.STRUCTURE.RAISONSOC", "structure.raisonSociale"),
	/**
	 * col2 , entreprise numeroSiret.
	 */
	col2("EXPORTCONVENTION.STRUCTURE.SIRET", "structure.numeroSiret"),
	/**
	 * col3 , entreprise batimentResidence.
	 */
	col3("EXPORTCONVENTION.STRUCTURE.RESIDENCE", "structure.batimentResidence"),
	/**
	 * col4  , entreprise voie.
	 */
	col4("EXPORTCONVENTION.STRUCTURE.VOIE", "structure.voie"),
	/**
	 * col5 , entreprise .Libellé Cedex.
	 */
	col5("EXPORTCONVENTION.STRUCTURE.LIBCEDEX", "structure.libCedex"),
	
	/**
	 * col6 , entreprise .codePostal.
	 */
	col6("EXPORTCONVENTION.STRUCTURE.CODEPOSTAL", "structure.codePostal"),
	
	/**
	 * col7 , entreprise commune.
	 */
	col7("EXPORTCONVENTION.STRUCTURE.COMMUNE", "structure.commune"),
	
	/**
	 * col8 , entreprise Pays.
	 */
	col8("EXPORTCONVENTION.STRUCTURE.PAYS", "structure.pays.libelle"),
	
	/**
	 * col9 , entreprise statut juridique.
	 */
	col9("EXPORTCONVENTION.STRUCTURE.STATUTJURIDIQUE", "structure.statutJuridique.libelle"),
	
	/**
	 * col10 , entreprise type de structure.
	 */
	col10("EXPORTCONVENTION.STRUCTURE.TYPESTRUCTURE", "structure.typeStructure.libelle"),
	
	/**
	 * col11 , entreprise effectifs.
	 */
	col11("EXPORTCONVENTION.STRUCTURE.EFFECTIF", "structure.effectif.libelle"),
	
	/**
	 * col12 , entreprise codeNAF.
	 */
	col12("EXPORTCONVENTION.STRUCTURE.CODENAF", "structure.codeNAF_N5"),
	
	/**
	 * col13 , entreprise telephone.
	 */
	col13("EXPORTCONVENTION.STRUCTURE.TELEPHONE", "structure.telephone"),
	
	/**
	 * col14 , entreprise fax.
	 */
	col14("EXPORTCONVENTION.STRUCTURE.FAX", "structure.fax"),
	
	/**
	 * col15 , entreprise mail.
	 */
	col15("EXPORTCONVENTION.STRUCTURE.MAIL", "structure.mail"),
	
	/**
	 * col16 , entreprise siteWeb.
	 */
	col16("EXPORTCONVENTION.STRUCTURE.SITEWEB", "structure.siteWeb"),
	
	/**
	 * co17 , service accueil.
	 */
	col17("EXPORTCONVENTION.SERVICE.NOM", "service.nom"),
	
	/**
	 * col18 , service batimentResidence.
	 */
	col18("EXPORTCONVENTION.SERVICE.RESIDENCE", "service.batimentResidence"),
	
	/**
	 * col19 , service voie.
	 */
	col19("EXPORTCONVENTION.SERVICE.VOIE", "service.voie"),
	
	/**
	 * col20 , service .Libellé Cedex.
	 */
	col20("EXPORTCONVENTION.SERVICE.LIBCEDEX", "service.libCedex"),
	
	/**
	 * col21 , service .codePostal.
	 */
	col21("EXPORTCONVENTION.SERVICE.CODEPOSTAL", "service.codePostal"),
	
	/**
	 * col22 , service commune.
	 */
	col22("EXPORTCONVENTION.SERVICE.COMMUNE", "service.commune"),
	
	/**
	 * col23 , service Pays.
	 */
	col23("EXPORTCONVENTION.SERVICE.PAYS", "service.pays.libelle"),

	/**
	 * col24 , Nom tuteur professionnel.
	 */
	col24("EXPORTCONVENTION.NOM.CONTACT", "contact.nom"),
	
	/**
	 * col25 , Prenom tuteur professionnel.
	 */
	col25("EXPORTCONVENTION.PRENOM.CONTACT", "contact.prenom"),
	
	/**
	 * col26 , Mail tuteur professionnel.
	 */
	col26("EXPORTCONVENTION.MAIL.CONTACT", "contact.mail"),
	
	/**
	 * col27 , tel tuteur professionnel.
	 */
	col27("EXPORTCONVENTION.TEL.CONTACT", "contact.tel"),
	
	/**
	 * col28 , fonction tuteur professionnel.
	 */
	col28("EXPORTCONVENTION.FONCTION.CONTACT", "contact.fonction");



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
	private ConventionEntrepriseColonneEnum(final String keyLabe, final String nameProperty) {
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
