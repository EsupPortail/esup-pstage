
package gouv.education.apogee.commun.transverse.dto.pedagogique.mentiondto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MentionDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MentionDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codMen" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libMen" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MentionDTO", propOrder = {
    "codMen",
    "libMen"
})
public class MentionDTO {

    @XmlElement(required = true, nillable = true)
    protected String codMen;
    @XmlElement(required = true, nillable = true)
    protected String libMen;

    /**
     * Gets the value of the codMen property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodMen() {
        return codMen;
    }

    /**
     * Sets the value of the codMen property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodMen(String value) {
        this.codMen = value;
    }

    /**
     * Gets the value of the libMen property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibMen() {
        return libMen;
    }

    /**
     * Sets the value of the libMen property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibMen(String value) {
        this.libMen = value;
    }

}
