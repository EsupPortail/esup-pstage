
package org.esupportail.pstagedata.remote;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for personneDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="personneDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://remote.pstagedata.esupportail.org/}objetMetiersDTO">
 *       &lt;sequence>
 *         &lt;element name="avantDerniereConnexion" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="civilite" type="{http://remote.pstagedata.esupportail.org/}civiliteDTO" minOccurs="0"/>
 *         &lt;element name="codeUniversite" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="derniereConnexion" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="fax" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idCivilite" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="mail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nom" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="prenom" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="typePersonne" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "personneDTO", propOrder = {
    "avantDerniereConnexion",
    "civilite",
    "codeUniversite",
    "derniereConnexion",
    "fax",
    "id",
    "idCivilite",
    "mail",
    "nom",
    "prenom",
    "tel",
    "typePersonne"
})
@XmlSeeAlso({
    AdminStructureDTO.class,
    PersonnelCentreGestionDTO.class,
    ContactDTO.class,
    EnseignantDTO.class,
    EtudiantDTO.class
})
public class PersonneDTO
    extends ObjetMetiersDTO
{

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar avantDerniereConnexion;
    protected CiviliteDTO civilite;
    protected String codeUniversite;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar derniereConnexion;
    protected String fax;
    protected int id;
    protected int idCivilite;
    protected String mail;
    protected String nom;
    protected String prenom;
    protected String tel;
    protected String typePersonne;

    /**
     * Gets the value of the avantDerniereConnexion property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getAvantDerniereConnexion() {
        return avantDerniereConnexion;
    }

    /**
     * Sets the value of the avantDerniereConnexion property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setAvantDerniereConnexion(XMLGregorianCalendar value) {
        this.avantDerniereConnexion = value;
    }

    /**
     * Gets the value of the civilite property.
     * 
     * @return
     *     possible object is
     *     {@link CiviliteDTO }
     *     
     */
    public CiviliteDTO getCivilite() {
        return civilite;
    }

    /**
     * Sets the value of the civilite property.
     * 
     * @param value
     *     allowed object is
     *     {@link CiviliteDTO }
     *     
     */
    public void setCivilite(CiviliteDTO value) {
        this.civilite = value;
    }

    /**
     * Gets the value of the codeUniversite property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeUniversite() {
        return codeUniversite;
    }

    /**
     * Sets the value of the codeUniversite property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeUniversite(String value) {
        this.codeUniversite = value;
    }

    /**
     * Gets the value of the derniereConnexion property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDerniereConnexion() {
        return derniereConnexion;
    }

    /**
     * Sets the value of the derniereConnexion property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDerniereConnexion(XMLGregorianCalendar value) {
        this.derniereConnexion = value;
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
     * Gets the value of the id property.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Gets the value of the idCivilite property.
     * 
     */
    public int getIdCivilite() {
        return idCivilite;
    }

    /**
     * Sets the value of the idCivilite property.
     * 
     */
    public void setIdCivilite(int value) {
        this.idCivilite = value;
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
     * Gets the value of the nom property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNom() {
        return nom;
    }

    /**
     * Sets the value of the nom property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNom(String value) {
        this.nom = value;
    }

    /**
     * Gets the value of the prenom property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Sets the value of the prenom property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrenom(String value) {
        this.prenom = value;
    }

    /**
     * Gets the value of the tel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTel() {
        return tel;
    }

    /**
     * Sets the value of the tel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTel(String value) {
        this.tel = value;
    }

    /**
     * Gets the value of the typePersonne property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypePersonne() {
        return typePersonne;
    }

    /**
     * Sets the value of the typePersonne property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypePersonne(String value) {
        this.typePersonne = value;
    }

}
