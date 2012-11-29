
package gouv.education.apogee.commun.transverse.dto.administratif.regimeinsdto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RegimeInsDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RegimeInsDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codRgi" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libRgi" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RegimeInsDTO", propOrder = {
    "codRgi",
    "libRgi"
})
public class RegimeInsDTO {

    @XmlElement(required = true, nillable = true)
    protected String codRgi;
    @XmlElement(required = true, nillable = true)
    protected String libRgi;

    /**
     * Gets the value of the codRgi property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodRgi() {
        return codRgi;
    }

    /**
     * Sets the value of the codRgi property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodRgi(String value) {
        this.codRgi = value;
    }

    /**
     * Gets the value of the libRgi property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibRgi() {
        return libRgi;
    }

    /**
     * Sets the value of the libRgi property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibRgi(String value) {
        this.libRgi = value;
    }

}
