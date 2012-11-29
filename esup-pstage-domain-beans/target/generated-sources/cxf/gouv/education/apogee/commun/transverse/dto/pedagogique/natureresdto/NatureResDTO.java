
package gouv.education.apogee.commun.transverse.dto.pedagogique.natureresdto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NatureResDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NatureResDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codAdm" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libAdm" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NatureResDTO", propOrder = {
    "codAdm",
    "libAdm"
})
public class NatureResDTO {

    @XmlElement(required = true, nillable = true)
    protected String codAdm;
    @XmlElement(required = true, nillable = true)
    protected String libAdm;

    /**
     * Gets the value of the codAdm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodAdm() {
        return codAdm;
    }

    /**
     * Sets the value of the codAdm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodAdm(String value) {
        this.codAdm = value;
    }

    /**
     * Gets the value of the libAdm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibAdm() {
        return libAdm;
    }

    /**
     * Sets the value of the libAdm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibAdm(String value) {
        this.libAdm = value;
    }

}
