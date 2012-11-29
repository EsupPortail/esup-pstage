
package gouv.education.apogee.commun.transverse.dto.administratif.domaineactiviteprofdto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DomaineActiviteProfDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DomaineActiviteProfDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codeDomaine" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libDomaine" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libWebDomaine" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DomaineActiviteProfDTO", propOrder = {
    "codeDomaine",
    "libDomaine",
    "libWebDomaine"
})
public class DomaineActiviteProfDTO {

    @XmlElement(required = true, nillable = true)
    protected String codeDomaine;
    @XmlElement(required = true, nillable = true)
    protected String libDomaine;
    @XmlElement(required = true, nillable = true)
    protected String libWebDomaine;

    /**
     * Gets the value of the codeDomaine property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeDomaine() {
        return codeDomaine;
    }

    /**
     * Sets the value of the codeDomaine property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeDomaine(String value) {
        this.codeDomaine = value;
    }

    /**
     * Gets the value of the libDomaine property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibDomaine() {
        return libDomaine;
    }

    /**
     * Sets the value of the libDomaine property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibDomaine(String value) {
        this.libDomaine = value;
    }

    /**
     * Gets the value of the libWebDomaine property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibWebDomaine() {
        return libWebDomaine;
    }

    /**
     * Sets the value of the libWebDomaine property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibWebDomaine(String value) {
        this.libWebDomaine = value;
    }

}
