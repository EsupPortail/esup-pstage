
package gouv.education.apogee.commun.transverse.dto.etudiant.sitfamcourtdto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SitFamCourtDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SitFamCourtDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codeFam" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libFam" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libLongFam" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SitFamCourtDTO", propOrder = {
    "codeFam",
    "libFam",
    "libLongFam"
})
public class SitFamCourtDTO {

    @XmlElement(required = true, nillable = true)
    protected String codeFam;
    @XmlElement(required = true, nillable = true)
    protected String libFam;
    @XmlElement(required = true, nillable = true)
    protected String libLongFam;

    /**
     * Gets the value of the codeFam property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeFam() {
        return codeFam;
    }

    /**
     * Sets the value of the codeFam property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeFam(String value) {
        this.codeFam = value;
    }

    /**
     * Gets the value of the libFam property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibFam() {
        return libFam;
    }

    /**
     * Sets the value of the libFam property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibFam(String value) {
        this.libFam = value;
    }

    /**
     * Gets the value of the libLongFam property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibLongFam() {
        return libLongFam;
    }

    /**
     * Sets the value of the libLongFam property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibLongFam(String value) {
        this.libLongFam = value;
    }

}
