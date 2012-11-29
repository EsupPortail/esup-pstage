
package gouv.education.apogee.commun.transverse.dto.administratif.paysdto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PaysDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PaysDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codePays" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libPays" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaysDTO", propOrder = {
    "codePays",
    "libPays"
})
public class PaysDTO {

    @XmlElement(required = true, nillable = true)
    protected String codePays;
    @XmlElement(required = true, nillable = true)
    protected String libPays;

    /**
     * Gets the value of the codePays property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodePays() {
        return codePays;
    }

    /**
     * Sets the value of the codePays property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodePays(String value) {
        this.codePays = value;
    }

    /**
     * Gets the value of the libPays property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibPays() {
        return libPays;
    }

    /**
     * Sets the value of the libPays property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibPays(String value) {
        this.libPays = value;
    }

}
