
package gouv.education.apogee.commun.transverse.dto.pedagogique.naturediplomedto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NatureDiplomeDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NatureDiplomeDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codNatDip" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libNatDip" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="licNatDip" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlType(name = "NatureDiplomeDTO", propOrder = {
    "codNatDip",
    "libNatDip",
    "licNatDip",
    "temEnSve"
})
public class NatureDiplomeDTO {

    @XmlElement(required = true, nillable = true)
    protected String codNatDip;
    @XmlElement(required = true, nillable = true)
    protected String libNatDip;
    @XmlElement(required = true, nillable = true)
    protected String licNatDip;
    @XmlElement(required = true, nillable = true)
    protected String temEnSve;

    /**
     * Gets the value of the codNatDip property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodNatDip() {
        return codNatDip;
    }

    /**
     * Sets the value of the codNatDip property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodNatDip(String value) {
        this.codNatDip = value;
    }

    /**
     * Gets the value of the libNatDip property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibNatDip() {
        return libNatDip;
    }

    /**
     * Sets the value of the libNatDip property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibNatDip(String value) {
        this.libNatDip = value;
    }

    /**
     * Gets the value of the licNatDip property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLicNatDip() {
        return licNatDip;
    }

    /**
     * Sets the value of the licNatDip property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLicNatDip(String value) {
        this.licNatDip = value;
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
