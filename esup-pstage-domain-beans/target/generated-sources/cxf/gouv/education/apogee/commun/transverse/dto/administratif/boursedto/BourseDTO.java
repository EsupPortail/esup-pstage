
package gouv.education.apogee.commun.transverse.dto.administratif.boursedto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BourseDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BourseDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codeBourse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libBourse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BourseDTO", propOrder = {
    "codeBourse",
    "libBourse"
})
public class BourseDTO {

    @XmlElement(required = true, nillable = true)
    protected String codeBourse;
    @XmlElement(required = true, nillable = true)
    protected String libBourse;

    /**
     * Gets the value of the codeBourse property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeBourse() {
        return codeBourse;
    }

    /**
     * Sets the value of the codeBourse property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeBourse(String value) {
        this.codeBourse = value;
    }

    /**
     * Gets the value of the libBourse property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibBourse() {
        return libBourse;
    }

    /**
     * Sets the value of the libBourse property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibBourse(String value) {
        this.libBourse = value;
    }

}
