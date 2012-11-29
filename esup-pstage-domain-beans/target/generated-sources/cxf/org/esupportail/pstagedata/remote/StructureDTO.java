
package org.esupportail.pstagedata.remote;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for structureDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="structureDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://remote.pstagedata.esupportail.org/}adresseDTO">
 *       &lt;sequence>
 *         &lt;element name="accordPartenariat" type="{http://remote.pstagedata.esupportail.org/}accordPartenariatDTO" minOccurs="0"/>
 *         &lt;element name="activitePrincipale" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codeEtab" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codeNAF_N5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dateStopValidation" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="dateValidation" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="effectif" type="{http://remote.pstagedata.esupportail.org/}effectifDTO" minOccurs="0"/>
 *         &lt;element name="estValidee" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="fax" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="groupe" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idAccordPartenariat" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idEffectif" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idStatutJuridique" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idStructure" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idTypeStructure" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="infosAJour" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="loginInfosAJour" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="loginStopValidation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="loginValidation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="logo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nafN5" type="{http://remote.pstagedata.esupportail.org/}nafN5DTO" minOccurs="0"/>
 *         &lt;element name="numeroSiret" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="raisonSociale" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="siteWeb" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="statutJuridique" type="{http://remote.pstagedata.esupportail.org/}statutJuridiqueDTO" minOccurs="0"/>
 *         &lt;element name="telephone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="typeStructure" type="{http://remote.pstagedata.esupportail.org/}typeStructureDTO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "structureDTO", propOrder = {
    "accordPartenariat",
    "activitePrincipale",
    "codeEtab",
    "codeNAFN5",
    "dateStopValidation",
    "dateValidation",
    "effectif",
    "estValidee",
    "fax",
    "groupe",
    "idAccordPartenariat",
    "idEffectif",
    "idStatutJuridique",
    "idStructure",
    "idTypeStructure",
    "infosAJour",
    "loginInfosAJour",
    "loginStopValidation",
    "loginValidation",
    "logo",
    "mail",
    "nafN5",
    "numeroSiret",
    "raisonSociale",
    "siteWeb",
    "statutJuridique",
    "telephone",
    "typeStructure"
})
public class StructureDTO
    extends AdresseDTO
{

    protected AccordPartenariatDTO accordPartenariat;
    protected String activitePrincipale;
    protected String codeEtab;
    @XmlElement(name = "codeNAF_N5")
    protected String codeNAFN5;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateStopValidation;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateValidation;
    protected EffectifDTO effectif;
    protected boolean estValidee;
    protected String fax;
    protected String groupe;
    protected int idAccordPartenariat;
    protected int idEffectif;
    protected int idStatutJuridique;
    protected int idStructure;
    protected int idTypeStructure;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar infosAJour;
    protected String loginInfosAJour;
    protected String loginStopValidation;
    protected String loginValidation;
    protected String logo;
    protected String mail;
    protected NafN5DTO nafN5;
    protected String numeroSiret;
    protected String raisonSociale;
    protected String siteWeb;
    protected StatutJuridiqueDTO statutJuridique;
    protected String telephone;
    protected TypeStructureDTO typeStructure;

    /**
     * Gets the value of the accordPartenariat property.
     * 
     * @return
     *     possible object is
     *     {@link AccordPartenariatDTO }
     *     
     */
    public AccordPartenariatDTO getAccordPartenariat() {
        return accordPartenariat;
    }

    /**
     * Sets the value of the accordPartenariat property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccordPartenariatDTO }
     *     
     */
    public void setAccordPartenariat(AccordPartenariatDTO value) {
        this.accordPartenariat = value;
    }

    /**
     * Gets the value of the activitePrincipale property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActivitePrincipale() {
        return activitePrincipale;
    }

    /**
     * Sets the value of the activitePrincipale property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActivitePrincipale(String value) {
        this.activitePrincipale = value;
    }

    /**
     * Gets the value of the codeEtab property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeEtab() {
        return codeEtab;
    }

    /**
     * Sets the value of the codeEtab property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeEtab(String value) {
        this.codeEtab = value;
    }

    /**
     * Gets the value of the codeNAFN5 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeNAFN5() {
        return codeNAFN5;
    }

    /**
     * Sets the value of the codeNAFN5 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeNAFN5(String value) {
        this.codeNAFN5 = value;
    }

    /**
     * Gets the value of the dateStopValidation property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateStopValidation() {
        return dateStopValidation;
    }

    /**
     * Sets the value of the dateStopValidation property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateStopValidation(XMLGregorianCalendar value) {
        this.dateStopValidation = value;
    }

    /**
     * Gets the value of the dateValidation property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateValidation() {
        return dateValidation;
    }

    /**
     * Sets the value of the dateValidation property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateValidation(XMLGregorianCalendar value) {
        this.dateValidation = value;
    }

    /**
     * Gets the value of the effectif property.
     * 
     * @return
     *     possible object is
     *     {@link EffectifDTO }
     *     
     */
    public EffectifDTO getEffectif() {
        return effectif;
    }

    /**
     * Sets the value of the effectif property.
     * 
     * @param value
     *     allowed object is
     *     {@link EffectifDTO }
     *     
     */
    public void setEffectif(EffectifDTO value) {
        this.effectif = value;
    }

    /**
     * Gets the value of the estValidee property.
     * 
     */
    public boolean isEstValidee() {
        return estValidee;
    }

    /**
     * Sets the value of the estValidee property.
     * 
     */
    public void setEstValidee(boolean value) {
        this.estValidee = value;
    }

    /**
     * Gets the value of the fax property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFax() {
        return fax;
    }

    /**
     * Sets the value of the fax property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFax(String value) {
        this.fax = value;
    }

    /**
     * Gets the value of the groupe property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGroupe() {
        return groupe;
    }

    /**
     * Sets the value of the groupe property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGroupe(String value) {
        this.groupe = value;
    }

    /**
     * Gets the value of the idAccordPartenariat property.
     * 
     */
    public int getIdAccordPartenariat() {
        return idAccordPartenariat;
    }

    /**
     * Sets the value of the idAccordPartenariat property.
     * 
     */
    public void setIdAccordPartenariat(int value) {
        this.idAccordPartenariat = value;
    }

    /**
     * Gets the value of the idEffectif property.
     * 
     */
    public int getIdEffectif() {
        return idEffectif;
    }

    /**
     * Sets the value of the idEffectif property.
     * 
     */
    public void setIdEffectif(int value) {
        this.idEffectif = value;
    }

    /**
     * Gets the value of the idStatutJuridique property.
     * 
     */
    public int getIdStatutJuridique() {
        return idStatutJuridique;
    }

    /**
     * Sets the value of the idStatutJuridique property.
     * 
     */
    public void setIdStatutJuridique(int value) {
        this.idStatutJuridique = value;
    }

    /**
     * Gets the value of the idStructure property.
     * 
     */
    public int getIdStructure() {
        return idStructure;
    }

    /**
     * Sets the value of the idStructure property.
     * 
     */
    public void setIdStructure(int value) {
        this.idStructure = value;
    }

    /**
     * Gets the value of the idTypeStructure property.
     * 
     */
    public int getIdTypeStructure() {
        return idTypeStructure;
    }

    /**
     * Sets the value of the idTypeStructure property.
     * 
     */
    public void setIdTypeStructure(int value) {
        this.idTypeStructure = value;
    }

    /**
     * Gets the value of the infosAJour property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getInfosAJour() {
        return infosAJour;
    }

    /**
     * Sets the value of the infosAJour property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setInfosAJour(XMLGregorianCalendar value) {
        this.infosAJour = value;
    }

    /**
     * Gets the value of the loginInfosAJour property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoginInfosAJour() {
        return loginInfosAJour;
    }

    /**
     * Sets the value of the loginInfosAJour property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoginInfosAJour(String value) {
        this.loginInfosAJour = value;
    }

    /**
     * Gets the value of the loginStopValidation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoginStopValidation() {
        return loginStopValidation;
    }

    /**
     * Sets the value of the loginStopValidation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoginStopValidation(String value) {
        this.loginStopValidation = value;
    }

    /**
     * Gets the value of the loginValidation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoginValidation() {
        return loginValidation;
    }

    /**
     * Sets the value of the loginValidation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoginValidation(String value) {
        this.loginValidation = value;
    }

    /**
     * Gets the value of the logo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLogo() {
        return logo;
    }

    /**
     * Sets the value of the logo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLogo(String value) {
        this.logo = value;
    }

    /**
     * Gets the value of the mail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMail() {
        return mail;
    }

    /**
     * Sets the value of the mail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMail(String value) {
        this.mail = value;
    }

    /**
     * Gets the value of the nafN5 property.
     * 
     * @return
     *     possible object is
     *     {@link NafN5DTO }
     *     
     */
    public NafN5DTO getNafN5() {
        return nafN5;
    }

    /**
     * Sets the value of the nafN5 property.
     * 
     * @param value
     *     allowed object is
     *     {@link NafN5DTO }
     *     
     */
    public void setNafN5(NafN5DTO value) {
        this.nafN5 = value;
    }

    /**
     * Gets the value of the numeroSiret property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroSiret() {
        return numeroSiret;
    }

    /**
     * Sets the value of the numeroSiret property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroSiret(String value) {
        this.numeroSiret = value;
    }

    /**
     * Gets the value of the raisonSociale property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRaisonSociale() {
        return raisonSociale;
    }

    /**
     * Sets the value of the raisonSociale property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRaisonSociale(String value) {
        this.raisonSociale = value;
    }

    /**
     * Gets the value of the siteWeb property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSiteWeb() {
        return siteWeb;
    }

    /**
     * Sets the value of the siteWeb property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSiteWeb(String value) {
        this.siteWeb = value;
    }

    /**
     * Gets the value of the statutJuridique property.
     * 
     * @return
     *     possible object is
     *     {@link StatutJuridiqueDTO }
     *     
     */
    public StatutJuridiqueDTO getStatutJuridique() {
        return statutJuridique;
    }

    /**
     * Sets the value of the statutJuridique property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatutJuridiqueDTO }
     *     
     */
    public void setStatutJuridique(StatutJuridiqueDTO value) {
        this.statutJuridique = value;
    }

    /**
     * Gets the value of the telephone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * Sets the value of the telephone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelephone(String value) {
        this.telephone = value;
    }

    /**
     * Gets the value of the typeStructure property.
     * 
     * @return
     *     possible object is
     *     {@link TypeStructureDTO }
     *     
     */
    public TypeStructureDTO getTypeStructure() {
        return typeStructure;
    }

    /**
     * Sets the value of the typeStructure property.
     * 
     * @param value
     *     allowed object is
     *     {@link TypeStructureDTO }
     *     
     */
    public void setTypeStructure(TypeStructureDTO value) {
        this.typeStructure = value;
    }

}
