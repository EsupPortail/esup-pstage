
package gouv.education.apogee.commun.transverse.dto.administratif.typeetablissementdto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TypeEtablissementDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TypeEtablissementDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codTypeEtb" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libLongTpe" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libWebTpe" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TypeEtablissementDTO", propOrder = {
    "codTypeEtb",
    "libLongTpe",
    "libWebTpe"
})
public class TypeEtablissementDTO {

    @XmlElement(required = true, nillable = true)
    protected String codTypeEtb;
    @XmlElement(required = true, nillable = true)
    protected String libLongTpe;
    @XmlElement(required = true, nillable = true)
    protected String libWebTpe;

    /**
     * Gets the value of the codTypeEtb property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodTypeEtb() {
        return codTypeEtb;
    }

    /**
     * Sets the value of the codTypeEtb property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodTypeEtb(String value) {
        this.codTypeEtb = value;
    }

    /**
     * Gets the value of the libLongTpe property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibLongTpe() {
        return libLongTpe;
    }

    /**
     * Sets the value of the libLongTpe property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibLongTpe(String value) {
        this.libLongTpe = value;
    }

    /**
     * Gets the value of the libWebTpe property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibWebTpe() {
        return libWebTpe;
    }

    /**
     * Sets the value of the libWebTpe property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibWebTpe(String value) {
        this.libWebTpe = value;
    }

}
