
package gouv.education.apogee.commun.transverse.dto.administratif.etapedto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EtapeDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EtapeDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codeEtp" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libLongEtp" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libWebVet" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="versionEtp" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EtapeDTO", propOrder = {
    "codeEtp",
    "libLongEtp",
    "libWebVet",
    "versionEtp"
})
public class EtapeDTO {

    @XmlElement(required = true, nillable = true)
    protected String codeEtp;
    @XmlElement(required = true, nillable = true)
    protected String libLongEtp;
    @XmlElement(required = true, nillable = true)
    protected String libWebVet;
    @XmlElement(required = true, nillable = true)
    protected String versionEtp;

    /**
     * Gets the value of the codeEtp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeEtp() {
        return codeEtp;
    }

    /**
     * Sets the value of the codeEtp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeEtp(String value) {
        this.codeEtp = value;
    }

    /**
     * Gets the value of the libLongEtp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibLongEtp() {
        return libLongEtp;
    }

    /**
     * Sets the value of the libLongEtp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibLongEtp(String value) {
        this.libLongEtp = value;
    }

    /**
     * Gets the value of the libWebVet property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibWebVet() {
        return libWebVet;
    }

    /**
     * Sets the value of the libWebVet property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibWebVet(String value) {
        this.libWebVet = value;
    }

    /**
     * Gets the value of the versionEtp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersionEtp() {
        return versionEtp;
    }

    /**
     * Sets the value of the versionEtp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersionEtp(String value) {
        this.versionEtp = value;
    }

}
