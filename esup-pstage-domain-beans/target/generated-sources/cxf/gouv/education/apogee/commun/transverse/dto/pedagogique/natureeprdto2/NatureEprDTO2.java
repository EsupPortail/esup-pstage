
package gouv.education.apogee.commun.transverse.dto.pedagogique.natureeprdto2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NatureEprDTO2 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NatureEprDTO2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codNatEpr" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libNatEpr" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="licNatEpr" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="temEnSve" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NatureEprDTO2", propOrder = {
    "codNatEpr",
    "libNatEpr",
    "licNatEpr",
    "temEnSve"
})
public class NatureEprDTO2 {

    @XmlElement(required = true, nillable = true)
    protected String codNatEpr;
    @XmlElement(required = true, nillable = true)
    protected String libNatEpr;
    @XmlElement(required = true, nillable = true)
    protected String licNatEpr;
    @XmlElement(required = true, nillable = true)
    protected String temEnSve;

    /**
     * Gets the value of the codNatEpr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodNatEpr() {
        return codNatEpr;
    }

    /**
     * Sets the value of the codNatEpr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodNatEpr(String value) {
        this.codNatEpr = value;
    }

    /**
     * Gets the value of the libNatEpr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibNatEpr() {
        return libNatEpr;
    }

    /**
     * Sets the value of the libNatEpr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibNatEpr(String value) {
        this.libNatEpr = value;
    }

    /**
     * Gets the value of the licNatEpr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLicNatEpr() {
        return licNatEpr;
    }

    /**
     * Sets the value of the licNatEpr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLicNatEpr(String value) {
        this.licNatEpr = value;
    }

    /**
     * Gets the value of the temEnSve property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemEnSve() {
        return temEnSve;
    }

    /**
     * Sets the value of the temEnSve property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemEnSve(String value) {
        this.temEnSve = value;
    }

}
