
package gouv.education.apogee.commun.transverse.dto.administratif.quotitetravdto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for QuotiteTravDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="QuotiteTravDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codeQuotite" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libQuotite" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libWebQuotite" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "QuotiteTravDTO", propOrder = {
    "codeQuotite",
    "libQuotite",
    "libWebQuotite"
})
public class QuotiteTravDTO {

    @XmlElement(required = true, nillable = true)
    protected String codeQuotite;
    @XmlElement(required = true, nillable = true)
    protected String libQuotite;
    @XmlElement(required = true, nillable = true)
    protected String libWebQuotite;

    /**
     * Gets the value of the codeQuotite property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeQuotite() {
        return codeQuotite;
    }

    /**
     * Sets the value of the codeQuotite property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeQuotite(String value) {
        this.codeQuotite = value;
    }

    /**
     * Gets the value of the libQuotite property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibQuotite() {
        return libQuotite;
    }

    /**
     * Sets the value of the libQuotite property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibQuotite(String value) {
        this.libQuotite = value;
    }

    /**
     * Gets the value of the libWebQuotite property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibWebQuotite() {
        return libWebQuotite;
    }

    /**
     * Sets the value of the libWebQuotite property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibWebQuotite(String value) {
        this.libWebQuotite = value;
    }

}
