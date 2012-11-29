
package gouv.education.apogee.commun.transverse.dto.etudiant.etapedto;

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
 *         &lt;element name="codEtp" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libEtp" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "codEtp",
    "libEtp"
})
public class EtapeDTO {

    @XmlElement(required = true, nillable = true)
    protected String codEtp;
    @XmlElement(required = true, nillable = true)
    protected String libEtp;

    /**
     * Gets the value of the codEtp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodEtp() {
        return codEtp;
    }

    /**
     * Sets the value of the codEtp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodEtp(String value) {
        this.codEtp = value;
    }

    /**
     * Gets the value of the libEtp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibEtp() {
        return libEtp;
    }

    /**
     * Sets the value of the libEtp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibEtp(String value) {
        this.libEtp = value;
    }

}
