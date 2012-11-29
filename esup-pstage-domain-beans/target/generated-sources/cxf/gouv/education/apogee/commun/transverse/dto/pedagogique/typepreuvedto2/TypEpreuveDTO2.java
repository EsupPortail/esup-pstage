
package gouv.education.apogee.commun.transverse.dto.pedagogique.typepreuvedto2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TypEpreuveDTO2 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TypEpreuveDTO2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codTypEpr" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libTypEpr" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="licTypEpr" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlType(name = "TypEpreuveDTO2", propOrder = {
    "codTypEpr",
    "libTypEpr",
    "licTypEpr",
    "temEnSve"
})
public class TypEpreuveDTO2 {

    @XmlElement(required = true, nillable = true)
    protected String codTypEpr;
    @XmlElement(required = true, nillable = true)
    protected String libTypEpr;
    @XmlElement(required = true, nillable = true)
    protected String licTypEpr;
    @XmlElement(required = true, nillable = true)
    protected String temEnSve;

    /**
     * Gets the value of the codTypEpr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodTypEpr() {
        return codTypEpr;
    }

    /**
     * Sets the value of the codTypEpr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodTypEpr(String value) {
        this.codTypEpr = value;
    }

    /**
     * Gets the value of the libTypEpr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibTypEpr() {
        return libTypEpr;
    }

    /**
     * Sets the value of the libTypEpr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibTypEpr(String value) {
        this.libTypEpr = value;
    }

    /**
     * Gets the value of the licTypEpr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLicTypEpr() {
        return licTypEpr;
    }

    /**
     * Sets the value of the licTypEpr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLicTypEpr(String value) {
        this.licTypEpr = value;
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
