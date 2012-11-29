
package gouv.education.apogee.commun.transverse.dto.administratif.diplomedto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DiplomeDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DiplomeDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codeDiplome" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libLongDiplome" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libVdi" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libWebVdi" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="versionDiplome" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DiplomeDTO", propOrder = {
    "codeDiplome",
    "libLongDiplome",
    "libVdi",
    "libWebVdi",
    "versionDiplome"
})
public class DiplomeDTO {

    @XmlElement(required = true, nillable = true)
    protected String codeDiplome;
    @XmlElement(required = true, nillable = true)
    protected String libLongDiplome;
    @XmlElement(required = true, nillable = true)
    protected String libVdi;
    @XmlElement(required = true, nillable = true)
    protected String libWebVdi;
    @XmlElement(required = true, nillable = true)
    protected String versionDiplome;

    /**
     * Gets the value of the codeDiplome property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeDiplome() {
        return codeDiplome;
    }

    /**
     * Sets the value of the codeDiplome property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeDiplome(String value) {
        this.codeDiplome = value;
    }

    /**
     * Gets the value of the libLongDiplome property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibLongDiplome() {
        return libLongDiplome;
    }

    /**
     * Sets the value of the libLongDiplome property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibLongDiplome(String value) {
        this.libLongDiplome = value;
    }

    /**
     * Gets the value of the libVdi property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibVdi() {
        return libVdi;
    }

    /**
     * Sets the value of the libVdi property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibVdi(String value) {
        this.libVdi = value;
    }

    /**
     * Gets the value of the libWebVdi property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibWebVdi() {
        return libWebVdi;
    }

    /**
     * Sets the value of the libWebVdi property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibWebVdi(String value) {
        this.libWebVdi = value;
    }

    /**
     * Gets the value of the versionDiplome property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersionDiplome() {
        return versionDiplome;
    }

    /**
     * Sets the value of the versionDiplome property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersionDiplome(String value) {
        this.versionDiplome = value;
    }

}
