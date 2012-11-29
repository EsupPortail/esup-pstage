
package gouv.education.apogee.commun.transverse.dto.etudiant.identifiantsetudiantdto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IdentifiantsEtudiantDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IdentifiantsEtudiantDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cleINE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codEtu" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="codInd" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="emailAnnuaire" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="loginAnnuaire" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="numBoursier" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="numeroINE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IdentifiantsEtudiantDTO", propOrder = {
    "cleINE",
    "codEtu",
    "codInd",
    "emailAnnuaire",
    "loginAnnuaire",
    "numBoursier",
    "numeroINE"
})
public class IdentifiantsEtudiantDTO {

    @XmlElement(required = true, nillable = true)
    protected String cleINE;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer codEtu;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer codInd;
    @XmlElement(required = true, nillable = true)
    protected String emailAnnuaire;
    @XmlElement(required = true, nillable = true)
    protected String loginAnnuaire;
    @XmlElement(required = true, nillable = true)
    protected String numBoursier;
    @XmlElement(required = true, nillable = true)
    protected String numeroINE;

    /**
     * Gets the value of the cleINE property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCleINE() {
        return cleINE;
    }

    /**
     * Sets the value of the cleINE property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCleINE(String value) {
        this.cleINE = value;
    }

    /**
     * Gets the value of the codEtu property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCodEtu() {
        return codEtu;
    }

    /**
     * Sets the value of the codEtu property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCodEtu(Integer value) {
        this.codEtu = value;
    }

    /**
     * Gets the value of the codInd property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCodInd() {
        return codInd;
    }

    /**
     * Sets the value of the codInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCodInd(Integer value) {
        this.codInd = value;
    }

    /**
     * Gets the value of the emailAnnuaire property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmailAnnuaire() {
        return emailAnnuaire;
    }

    /**
     * Sets the value of the emailAnnuaire property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmailAnnuaire(String value) {
        this.emailAnnuaire = value;
    }

    /**
     * Gets the value of the loginAnnuaire property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoginAnnuaire() {
        return loginAnnuaire;
    }

    /**
     * Sets the value of the loginAnnuaire property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoginAnnuaire(String value) {
        this.loginAnnuaire = value;
    }

    /**
     * Gets the value of the numBoursier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumBoursier() {
        return numBoursier;
    }

    /**
     * Sets the value of the numBoursier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumBoursier(String value) {
        this.numBoursier = value;
    }

    /**
     * Gets the value of the numeroINE property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroINE() {
        return numeroINE;
    }

    /**
     * Sets the value of the numeroINE property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroINE(String value) {
        this.numeroINE = value;
    }

}
