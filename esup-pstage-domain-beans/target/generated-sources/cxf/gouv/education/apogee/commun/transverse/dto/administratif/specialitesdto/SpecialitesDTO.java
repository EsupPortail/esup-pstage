
package gouv.education.apogee.commun.transverse.dto.administratif.specialitesdto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SpecialitesDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SpecialitesDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codeSpecialite" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libSpecialite" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libWebSpecialite" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SpecialitesDTO", propOrder = {
    "codeSpecialite",
    "libSpecialite",
    "libWebSpecialite"
})
public class SpecialitesDTO {

    @XmlElement(required = true, nillable = true)
    protected String codeSpecialite;
    @XmlElement(required = true, nillable = true)
    protected String libSpecialite;
    @XmlElement(required = true, nillable = true)
    protected String libWebSpecialite;

    /**
     * Gets the value of the codeSpecialite property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeSpecialite() {
        return codeSpecialite;
    }

    /**
     * Sets the value of the codeSpecialite property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeSpecialite(String value) {
        this.codeSpecialite = value;
    }

    /**
     * Gets the value of the libSpecialite property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibSpecialite() {
        return libSpecialite;
    }

    /**
     * Sets the value of the libSpecialite property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibSpecialite(String value) {
        this.libSpecialite = value;
    }

    /**
     * Gets the value of the libWebSpecialite property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibWebSpecialite() {
        return libWebSpecialite;
    }

    /**
     * Sets the value of the libWebSpecialite property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibWebSpecialite(String value) {
        this.libWebSpecialite = value;
    }

}
