
package gouv.education.apogee.commun.transverse.dto.pedagogique.sessiondto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SessionDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SessionDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codSes" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libSes" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SessionDTO", propOrder = {
    "codSes",
    "libSes"
})
public class SessionDTO {

    @XmlElement(required = true, nillable = true)
    protected String codSes;
    @XmlElement(required = true, nillable = true)
    protected String libSes;

    /**
     * Gets the value of the codSes property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodSes() {
        return codSes;
    }

    /**
     * Sets the value of the codSes property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodSes(String value) {
        this.codSes = value;
    }

    /**
     * Gets the value of the libSes property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibSes() {
        return libSes;
    }

    /**
     * Sets the value of the libSes property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibSes(String value) {
        this.libSes = value;
    }

}
