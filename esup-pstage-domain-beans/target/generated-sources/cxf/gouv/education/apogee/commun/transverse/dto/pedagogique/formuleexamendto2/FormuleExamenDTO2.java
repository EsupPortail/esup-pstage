
package gouv.education.apogee.commun.transverse.dto.pedagogique.formuleexamendto2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FormuleExamenDTO2 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FormuleExamenDTO2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codFex" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libFex" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="licFex" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlType(name = "FormuleExamenDTO2", propOrder = {
    "codFex",
    "libFex",
    "licFex",
    "temEnSve"
})
public class FormuleExamenDTO2 {

    @XmlElement(required = true, nillable = true)
    protected String codFex;
    @XmlElement(required = true, nillable = true)
    protected String libFex;
    @XmlElement(required = true, nillable = true)
    protected String licFex;
    @XmlElement(required = true, nillable = true)
    protected String temEnSve;

    /**
     * Gets the value of the codFex property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodFex() {
        return codFex;
    }

    /**
     * Sets the value of the codFex property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodFex(String value) {
        this.codFex = value;
    }

    /**
     * Gets the value of the libFex property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibFex() {
        return libFex;
    }

    /**
     * Sets the value of the libFex property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibFex(String value) {
        this.libFex = value;
    }

    /**
     * Gets the value of the licFex property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLicFex() {
        return licFex;
    }

    /**
     * Sets the value of the licFex property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLicFex(String value) {
        this.licFex = value;
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
