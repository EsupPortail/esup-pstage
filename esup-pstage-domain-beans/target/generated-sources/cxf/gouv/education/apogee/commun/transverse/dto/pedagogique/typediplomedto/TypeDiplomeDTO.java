
package gouv.education.apogee.commun.transverse.dto.pedagogique.typediplomedto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TypeDiplomeDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TypeDiplomeDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codTypDip" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libTypDip" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="licTypDip" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlType(name = "TypeDiplomeDTO", propOrder = {
    "codTypDip",
    "libTypDip",
    "licTypDip",
    "temEnSve"
})
public class TypeDiplomeDTO {

    @XmlElement(required = true, nillable = true)
    protected String codTypDip;
    @XmlElement(required = true, nillable = true)
    protected String libTypDip;
    @XmlElement(required = true, nillable = true)
    protected String licTypDip;
    @XmlElement(required = true, nillable = true)
    protected String temEnSve;

    /**
     * Gets the value of the codTypDip property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodTypDip() {
        return codTypDip;
    }

    /**
     * Sets the value of the codTypDip property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodTypDip(String value) {
        this.codTypDip = value;
    }

    /**
     * Gets the value of the libTypDip property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibTypDip() {
        return libTypDip;
    }

    /**
     * Sets the value of the libTypDip property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibTypDip(String value) {
        this.libTypDip = value;
    }

    /**
     * Gets the value of the licTypDip property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLicTypDip() {
        return licTypDip;
    }

    /**
     * Sets the value of the licTypDip property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLicTypDip(String value) {
        this.licTypDip = value;
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
