
package gouv.education.apogee.commun.transverse.dto.pedagogique.natureeprdto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NatureEprDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NatureEprDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codNep" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libNep" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NatureEprDTO", propOrder = {
    "codNep",
    "libNep"
})
public class NatureEprDTO {

    @XmlElement(required = true, nillable = true)
    protected String codNep;
    @XmlElement(required = true, nillable = true)
    protected String libNep;

    /**
     * Gets the value of the codNep property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodNep() {
        return codNep;
    }

    /**
     * Sets the value of the codNep property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodNep(String value) {
        this.codNep = value;
    }

    /**
     * Gets the value of the libNep property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibNep() {
        return libNep;
    }

    /**
     * Sets the value of the libNep property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibNep(String value) {
        this.libNep = value;
    }

}
