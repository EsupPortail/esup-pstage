
package gouv.education.apogee.commun.transverse.dto.pedagogique.regimeinscdto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RegimeInscDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RegimeInscDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codRegIns" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libRegIns" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="licRegIns" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlType(name = "RegimeInscDTO", propOrder = {
    "codRegIns",
    "libRegIns",
    "licRegIns",
    "temEnSve"
})
public class RegimeInscDTO {

    @XmlElement(required = true, nillable = true)
    protected String codRegIns;
    @XmlElement(required = true, nillable = true)
    protected String libRegIns;
    @XmlElement(required = true, nillable = true)
    protected String licRegIns;
    @XmlElement(required = true, nillable = true)
    protected String temEnSve;

    /**
     * Gets the value of the codRegIns property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodRegIns() {
        return codRegIns;
    }

    /**
     * Sets the value of the codRegIns property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodRegIns(String value) {
        this.codRegIns = value;
    }

    /**
     * Gets the value of the libRegIns property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibRegIns() {
        return libRegIns;
    }

    /**
     * Sets the value of the libRegIns property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibRegIns(String value) {
        this.libRegIns = value;
    }

    /**
     * Gets the value of the licRegIns property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLicRegIns() {
        return licRegIns;
    }

    /**
     * Sets the value of the licRegIns property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLicRegIns(String value) {
        this.licRegIns = value;
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
