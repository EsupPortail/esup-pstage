
package gouv.education.apogee.commun.transverse.dto.pedagogique.diplomedto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DiplomeDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DiplomeDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codDip" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codVrsVdi" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="libDip" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libWebVdi" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="licVdi" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DiplomeDTO", propOrder = {
    "codDip",
    "codVrsVdi",
    "libDip",
    "libWebVdi",
    "licVdi"
})
public class DiplomeDTO {

    @XmlElement(required = true, nillable = true)
    protected String codDip;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer codVrsVdi;
    @XmlElement(required = true, nillable = true)
    protected String libDip;
    @XmlElement(required = true, nillable = true)
    protected String libWebVdi;
    @XmlElement(required = true, nillable = true)
    protected String licVdi;

    /**
     * Gets the value of the codDip property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodDip() {
        return codDip;
    }

    /**
     * Sets the value of the codDip property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodDip(String value) {
        this.codDip = value;
    }

    /**
     * Gets the value of the codVrsVdi property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCodVrsVdi() {
        return codVrsVdi;
    }

    /**
     * Sets the value of the codVrsVdi property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCodVrsVdi(Integer value) {
        this.codVrsVdi = value;
    }

    /**
     * Gets the value of the libDip property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibDip() {
        return libDip;
    }

    /**
     * Sets the value of the libDip property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibDip(String value) {
        this.libDip = value;
    }

    /**
     * Gets the value of the libWebVdi property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibWebVdi() {
        return libWebVdi;
    }

    /**
     * Sets the value of the libWebVdi property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibWebVdi(String value) {
        this.libWebVdi = value;
    }

    /**
     * Gets the value of the licVdi property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLicVdi() {
        return licVdi;
    }

    /**
     * Sets the value of the licVdi property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLicVdi(String value) {
        this.licVdi = value;
    }

}
