
package gouv.education.apogee.commun.transverse.dto.pedagogique.typecomposantedto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TypeComposanteDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TypeComposanteDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codTypCmp" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libTypCmp" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TypeComposanteDTO", propOrder = {
    "codTypCmp",
    "libTypCmp"
})
public class TypeComposanteDTO {

    @XmlElement(required = true, nillable = true)
    protected String codTypCmp;
    @XmlElement(required = true, nillable = true)
    protected String libTypCmp;

    /**
     * Gets the value of the codTypCmp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodTypCmp() {
        return codTypCmp;
    }

    /**
     * Sets the value of the codTypCmp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodTypCmp(String value) {
        this.codTypCmp = value;
    }

    /**
     * Gets the value of the libTypCmp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibTypCmp() {
        return libTypCmp;
    }

    /**
     * Sets the value of the libTypCmp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibTypCmp(String value) {
        this.libTypCmp = value;
    }

}
