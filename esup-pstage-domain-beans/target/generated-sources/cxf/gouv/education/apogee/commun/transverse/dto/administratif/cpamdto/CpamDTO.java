
package gouv.education.apogee.commun.transverse.dto.administratif.cpamdto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CpamDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CpamDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codeCpam" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libCpam" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CpamDTO", propOrder = {
    "codeCpam",
    "libCpam"
})
public class CpamDTO {

    @XmlElement(required = true, nillable = true)
    protected String codeCpam;
    @XmlElement(required = true, nillable = true)
    protected String libCpam;

    /**
     * Gets the value of the codeCpam property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeCpam() {
        return codeCpam;
    }

    /**
     * Sets the value of the codeCpam property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeCpam(String value) {
        this.codeCpam = value;
    }

    /**
     * Gets the value of the libCpam property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibCpam() {
        return libCpam;
    }

    /**
     * Sets the value of the libCpam property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibCpam(String value) {
        this.libCpam = value;
    }

}
