
package org.esupportail.pstagedata.remote;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for avenantDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="avenantDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://remote.pstagedata.esupportail.org/}objetMetiersDTO">
 *       &lt;sequence>
 *         &lt;element name="contact" type="{http://remote.pstagedata.esupportail.org/}contactDTO" minOccurs="0"/>
 *         &lt;element name="convention" type="{http://remote.pstagedata.esupportail.org/}conventionDTO" minOccurs="0"/>
 *         &lt;element name="dateDebutInterruption" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="dateDebutStage" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="dateFinInterruption" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="dateFinStage" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="enseignant" type="{http://remote.pstagedata.esupportail.org/}enseignantDTO" minOccurs="0"/>
 *         &lt;element name="idAvenant" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="idContact" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="idConvention" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="idEnseignant" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="idService" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="idUniteGratification" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="interruptionStage" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="modificationEnseignant" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="modificationLieu" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="modificationMontantGratification" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="modificationPeriode" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="modificationSalarie" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="modificationSujet" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="montantGratification" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="motifAvenant" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="rupture" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="service" type="{http://remote.pstagedata.esupportail.org/}serviceDTO" minOccurs="0"/>
 *         &lt;element name="sujetStage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="uniteGratification" type="{http://remote.pstagedata.esupportail.org/}uniteGratificationDTO" minOccurs="0"/>
 *         &lt;element name="validationAvenant" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "avenantDTO", propOrder = {
    "contact",
    "convention",
    "dateDebutInterruption",
    "dateDebutStage",
    "dateFinInterruption",
    "dateFinStage",
    "enseignant",
    "idAvenant",
    "idContact",
    "idConvention",
    "idEnseignant",
    "idService",
    "idUniteGratification",
    "interruptionStage",
    "modificationEnseignant",
    "modificationLieu",
    "modificationMontantGratification",
    "modificationPeriode",
    "modificationSalarie",
    "modificationSujet",
    "montantGratification",
    "motifAvenant",
    "rupture",
    "service",
    "sujetStage",
    "uniteGratification",
    "validationAvenant"
})
public class AvenantDTO
    extends ObjetMetiersDTO
{

    protected ContactDTO contact;
    protected ConventionDTO convention;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateDebutInterruption;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateDebutStage;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateFinInterruption;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateFinStage;
    protected EnseignantDTO enseignant;
    protected Integer idAvenant;
    protected Integer idContact;
    protected Integer idConvention;
    protected Integer idEnseignant;
    protected Integer idService;
    protected Integer idUniteGratification;
    protected boolean interruptionStage;
    protected boolean modificationEnseignant;
    protected boolean modificationLieu;
    protected boolean modificationMontantGratification;
    protected boolean modificationPeriode;
    protected boolean modificationSalarie;
    protected boolean modificationSujet;
    protected String montantGratification;
    protected String motifAvenant;
    protected boolean rupture;
    protected ServiceDTO service;
    protected String sujetStage;
    protected UniteGratificationDTO uniteGratification;
    protected boolean validationAvenant;

    /**
     * Gets the value of the contact property.
     * 
     * @return
     *     possible object is
     *     {@link ContactDTO }
     *     
     */
    public ContactDTO getContact() {
        return contact;
    }

    /**
     * Sets the value of the contact property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContactDTO }
     *     
     */
    public void setContact(ContactDTO value) {
        this.contact = value;
    }

    /**
     * Gets the value of the convention property.
     * 
     * @return
     *     possible object is
     *     {@link ConventionDTO }
     *     
     */
    public ConventionDTO getConvention() {
        return convention;
    }

    /**
     * Sets the value of the convention property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConventionDTO }
     *     
     */
    public void setConvention(ConventionDTO value) {
        this.convention = value;
    }

    /**
     * Gets the value of the dateDebutInterruption property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateDebutInterruption() {
        return dateDebutInterruption;
    }

    /**
     * Sets the value of the dateDebutInterruption property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateDebutInterruption(XMLGregorianCalendar value) {
        this.dateDebutInterruption = value;
    }

    /**
     * Gets the value of the dateDebutStage property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateDebutStage() {
        return dateDebutStage;
    }

    /**
     * Sets the value of the dateDebutStage property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateDebutStage(XMLGregorianCalendar value) {
        this.dateDebutStage = value;
    }

    /**
     * Gets the value of the dateFinInterruption property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateFinInterruption() {
        return dateFinInterruption;
    }

    /**
     * Sets the value of the dateFinInterruption property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateFinInterruption(XMLGregorianCalendar value) {
        this.dateFinInterruption = value;
    }

    /**
     * Gets the value of the dateFinStage property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateFinStage() {
        return dateFinStage;
    }

    /**
     * Sets the value of the dateFinStage property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateFinStage(XMLGregorianCalendar value) {
        this.dateFinStage = value;
    }

    /**
     * Gets the value of the enseignant property.
     * 
     * @return
     *     possible object is
     *     {@link EnseignantDTO }
     *     
     */
    public EnseignantDTO getEnseignant() {
        return enseignant;
    }

    /**
     * Sets the value of the enseignant property.
     * 
     * @param value
     *     allowed object is
     *     {@link EnseignantDTO }
     *     
     */
    public void setEnseignant(EnseignantDTO value) {
        this.enseignant = value;
    }

    /**
     * Gets the value of the idAvenant property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdAvenant() {
        return idAvenant;
    }

    /**
     * Sets the value of the idAvenant property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdAvenant(Integer value) {
        this.idAvenant = value;
    }

    /**
     * Gets the value of the idContact property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdContact() {
        return idContact;
    }

    /**
     * Sets the value of the idContact property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdContact(Integer value) {
        this.idContact = value;
    }

    /**
     * Gets the value of the idConvention property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdConvention() {
        return idConvention;
    }

    /**
     * Sets the value of the idConvention property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdConvention(Integer value) {
        this.idConvention = value;
    }

    /**
     * Gets the value of the idEnseignant property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdEnseignant() {
        return idEnseignant;
    }

    /**
     * Sets the value of the idEnseignant property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdEnseignant(Integer value) {
        this.idEnseignant = value;
    }

    /**
     * Gets the value of the idService property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdService() {
        return idService;
    }

    /**
     * Sets the value of the idService property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdService(Integer value) {
        this.idService = value;
    }

    /**
     * Gets the value of the idUniteGratification property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdUniteGratification() {
        return idUniteGratification;
    }

    /**
     * Sets the value of the idUniteGratification property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdUniteGratification(Integer value) {
        this.idUniteGratification = value;
    }

    /**
     * Gets the value of the interruptionStage property.
     * 
     */
    public boolean isInterruptionStage() {
        return interruptionStage;
    }

    /**
     * Sets the value of the interruptionStage property.
     * 
     */
    public void setInterruptionStage(boolean value) {
        this.interruptionStage = value;
    }

    /**
     * Gets the value of the modificationEnseignant property.
     * 
     */
    public boolean isModificationEnseignant() {
        return modificationEnseignant;
    }

    /**
     * Sets the value of the modificationEnseignant property.
     * 
     */
    public void setModificationEnseignant(boolean value) {
        this.modificationEnseignant = value;
    }

    /**
     * Gets the value of the modificationLieu property.
     * 
     */
    public boolean isModificationLieu() {
        return modificationLieu;
    }

    /**
     * Sets the value of the modificationLieu property.
     * 
     */
    public void setModificationLieu(boolean value) {
        this.modificationLieu = value;
    }

    /**
     * Gets the value of the modificationMontantGratification property.
     * 
     */
    public boolean isModificationMontantGratification() {
        return modificationMontantGratification;
    }

    /**
     * Sets the value of the modificationMontantGratification property.
     * 
     */
    public void setModificationMontantGratification(boolean value) {
        this.modificationMontantGratification = value;
    }

    /**
     * Gets the value of the modificationPeriode property.
     * 
     */
    public boolean isModificationPeriode() {
        return modificationPeriode;
    }

    /**
     * Sets the value of the modificationPeriode property.
     * 
     */
    public void setModificationPeriode(boolean value) {
        this.modificationPeriode = value;
    }

    /**
     * Gets the value of the modificationSalarie property.
     * 
     */
    public boolean isModificationSalarie() {
        return modificationSalarie;
    }

    /**
     * Sets the value of the modificationSalarie property.
     * 
     */
    public void setModificationSalarie(boolean value) {
        this.modificationSalarie = value;
    }

    /**
     * Gets the value of the modificationSujet property.
     * 
     */
    public boolean isModificationSujet() {
        return modificationSujet;
    }

    /**
     * Sets the value of the modificationSujet property.
     * 
     */
    public void setModificationSujet(boolean value) {
        this.modificationSujet = value;
    }

    /**
     * Gets the value of the montantGratification property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMontantGratification() {
        return montantGratification;
    }

    /**
     * Sets the value of the montantGratification property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMontantGratification(String value) {
        this.montantGratification = value;
    }

    /**
     * Gets the value of the motifAvenant property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMotifAvenant() {
        return motifAvenant;
    }

    /**
     * Sets the value of the motifAvenant property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMotifAvenant(String value) {
        this.motifAvenant = value;
    }

    /**
     * Gets the value of the rupture property.
     * 
     */
    public boolean isRupture() {
        return rupture;
    }

    /**
     * Sets the value of the rupture property.
     * 
     */
    public void setRupture(boolean value) {
        this.rupture = value;
    }

    /**
     * Gets the value of the service property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceDTO }
     *     
     */
    public ServiceDTO getService() {
        return service;
    }

    /**
     * Sets the value of the service property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceDTO }
     *     
     */
    public void setService(ServiceDTO value) {
        this.service = value;
    }

    /**
     * Gets the value of the sujetStage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSujetStage() {
        return sujetStage;
    }

    /**
     * Sets the value of the sujetStage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSujetStage(String value) {
        this.sujetStage = value;
    }

    /**
     * Gets the value of the uniteGratification property.
     * 
     * @return
     *     possible object is
     *     {@link UniteGratificationDTO }
     *     
     */
    public UniteGratificationDTO getUniteGratification() {
        return uniteGratification;
    }

    /**
     * Sets the value of the uniteGratification property.
     * 
     * @param value
     *     allowed object is
     *     {@link UniteGratificationDTO }
     *     
     */
    public void setUniteGratification(UniteGratificationDTO value) {
        this.uniteGratification = value;
    }

    /**
     * Gets the value of the validationAvenant property.
     * 
     */
    public boolean isValidationAvenant() {
        return validationAvenant;
    }

    /**
     * Sets the value of the validationAvenant property.
     * 
     */
    public void setValidationAvenant(boolean value) {
        this.validationAvenant = value;
    }

}
