
package org.esupportail.pstagedata.remote;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for personnelCentreGestionDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="personnelCentreGestionDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://remote.pstagedata.esupportail.org/}personneDTO">
 *       &lt;sequence>
 *         &lt;element name="affectation" type="{http://remote.pstagedata.esupportail.org/}affectationDTO" minOccurs="0"/>
 *         &lt;element name="batiment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bureau" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="campus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="centreGestion" type="{http://remote.pstagedata.esupportail.org/}centreGestionDTO" minOccurs="0"/>
 *         &lt;element name="codeAffectation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codeUniversiteAffectation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="droitAdmin" type="{http://remote.pstagedata.esupportail.org/}droitAdministrationDTO" minOccurs="0"/>
 *         &lt;element name="fonction" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idCentreGestion" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idDroitAdmin" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="impressionConvention" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="uidPersonnel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "personnelCentreGestionDTO", propOrder = {
    "affectation",
    "batiment",
    "bureau",
    "campus",
    "centreGestion",
    "codeAffectation",
    "codeUniversiteAffectation",
    "droitAdmin",
    "fonction",
    "idCentreGestion",
    "idDroitAdmin",
    "impressionConvention",
    "uidPersonnel"
})
public class PersonnelCentreGestionDTO
    extends PersonneDTO
{

    protected AffectationDTO affectation;
    protected String batiment;
    protected String bureau;
    protected String campus;
    protected CentreGestionDTO centreGestion;
    protected String codeAffectation;
    protected String codeUniversiteAffectation;
    protected DroitAdministrationDTO droitAdmin;
    protected String fonction;
    protected int idCentreGestion;
    protected int idDroitAdmin;
    protected boolean impressionConvention;
    protected String uidPersonnel;

    /**
     * Gets the value of the affectation property.
     * 
     * @return
     *     possible object is
     *     {@link AffectationDTO }
     *     
     */
    public AffectationDTO getAffectation() {
        return affectation;
    }

    /**
     * Sets the value of the affectation property.
     * 
     * @param value
     *     allowed object is
     *     {@link AffectationDTO }
     *     
     */
    public void setAffectation(AffectationDTO value) {
        this.affectation = value;
    }

    /**
     * Gets the value of the batiment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBatiment() {
        return batiment;
    }

    /**
     * Sets the value of the batiment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBatiment(String value) {
        this.batiment = value;
    }

    /**
     * Gets the value of the bureau property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBureau() {
        return bureau;
    }

    /**
     * Sets the value of the bureau property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBureau(String value) {
        this.bureau = value;
    }

    /**
     * Gets the value of the campus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCampus() {
        return campus;
    }

    /**
     * Sets the value of the campus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCampus(String value) {
        this.campus = value;
    }

    /**
     * Gets the value of the centreGestion property.
     * 
     * @return
     *     possible object is
     *     {@link CentreGestionDTO }
     *     
     */
    public CentreGestionDTO getCentreGestion() {
        return centreGestion;
    }

    /**
     * Sets the value of the centreGestion property.
     * 
     * @param value
     *     allowed object is
     *     {@link CentreGestionDTO }
     *     
     */
    public void setCentreGestion(CentreGestionDTO value) {
        this.centreGestion = value;
    }

    /**
     * Gets the value of the codeAffectation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeAffectation() {
        return codeAffectation;
    }

    /**
     * Sets the value of the codeAffectation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeAffectation(String value) {
        this.codeAffectation = value;
    }

    /**
     * Gets the value of the codeUniversiteAffectation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeUniversiteAffectation() {
        return codeUniversiteAffectation;
    }

    /**
     * Sets the value of the codeUniversiteAffectation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeUniversiteAffectation(String value) {
        this.codeUniversiteAffectation = value;
    }

    /**
     * Gets the value of the droitAdmin property.
     * 
     * @return
     *     possible object is
     *     {@link DroitAdministrationDTO }
     *     
     */
    public DroitAdministrationDTO getDroitAdmin() {
        return droitAdmin;
    }

    /**
     * Sets the value of the droitAdmin property.
     * 
     * @param value
     *     allowed object is
     *     {@link DroitAdministrationDTO }
     *     
     */
    public void setDroitAdmin(DroitAdministrationDTO value) {
        this.droitAdmin = value;
    }

    /**
     * Gets the value of the fonction property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFonction() {
        return fonction;
    }

    /**
     * Sets the value of the fonction property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFonction(String value) {
        this.fonction = value;
    }

    /**
     * Gets the value of the idCentreGestion property.
     * 
     */
    public int getIdCentreGestion() {
        return idCentreGestion;
    }

    /**
     * Sets the value of the idCentreGestion property.
     * 
     */
    public void setIdCentreGestion(int value) {
        this.idCentreGestion = value;
    }

    /**
     * Gets the value of the idDroitAdmin property.
     * 
     */
    public int getIdDroitAdmin() {
        return idDroitAdmin;
    }

    /**
     * Sets the value of the idDroitAdmin property.
     * 
     */
    public void setIdDroitAdmin(int value) {
        this.idDroitAdmin = value;
    }

    /**
     * Gets the value of the impressionConvention property.
     * 
     */
    public boolean isImpressionConvention() {
        return impressionConvention;
    }

    /**
     * Sets the value of the impressionConvention property.
     * 
     */
    public void setImpressionConvention(boolean value) {
        this.impressionConvention = value;
    }

    /**
     * Gets the value of the uidPersonnel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUidPersonnel() {
        return uidPersonnel;
    }

    /**
     * Sets the value of the uidPersonnel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUidPersonnel(String value) {
        this.uidPersonnel = value;
    }

}
