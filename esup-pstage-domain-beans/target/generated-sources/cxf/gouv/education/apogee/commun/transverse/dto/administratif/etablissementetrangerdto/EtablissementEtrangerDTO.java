
package gouv.education.apogee.commun.transverse.dto.administratif.etablissementetrangerdto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EtablissementEtrangerDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EtablissementEtrangerDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codeEtb" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libEtb" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libWebEtb" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EtablissementEtrangerDTO", propOrder = {
    "codeEtb",
    "libEtb",
    "libWebEtb"
})
public class EtablissementEtrangerDTO {

    @XmlElement(required = true, nillable = true)
    protected String codeEtb;
    @XmlElement(required = true, nillable = true)
    protected String libEtb;
    @XmlElement(required = true, nillable = true)
    protected String libWebEtb;

    /**
     * Gets the value of the codeEtb property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeEtb() {
        return codeEtb;
    }

    /**
     * Sets the value of the codeEtb property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeEtb(String value) {
        this.codeEtb = value;
    }

    /**
     * Gets the value of the libEtb property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibEtb() {
        return libEtb;
    }

    /**
     * Sets the value of the libEtb property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibEtb(String value) {
        this.libEtb = value;
    }

    /**
     * Gets the value of the libWebEtb property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibWebEtb() {
        return libWebEtb;
    }

    /**
     * Sets the value of the libWebEtb property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibWebEtb(String value) {
        this.libWebEtb = value;
    }

}
