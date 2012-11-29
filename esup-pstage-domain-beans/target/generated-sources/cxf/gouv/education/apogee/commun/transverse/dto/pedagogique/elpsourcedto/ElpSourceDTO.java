
package gouv.education.apogee.commun.transverse.dto.pedagogique.elpsourcedto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ElpSourceDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ElpSourceDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codElp" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libElp" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ElpSourceDTO", propOrder = {
    "codElp",
    "libElp"
})
public class ElpSourceDTO {

    @XmlElement(required = true, nillable = true)
    protected String codElp;
    @XmlElement(required = true, nillable = true)
    protected String libElp;

    /**
     * Gets the value of the codElp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodElp() {
        return codElp;
    }

    /**
     * Sets the value of the codElp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodElp(String value) {
        this.codElp = value;
    }

    /**
     * Gets the value of the libElp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibElp() {
        return libElp;
    }

    /**
     * Sets the value of the libElp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibElp(String value) {
        this.libElp = value;
    }

}
