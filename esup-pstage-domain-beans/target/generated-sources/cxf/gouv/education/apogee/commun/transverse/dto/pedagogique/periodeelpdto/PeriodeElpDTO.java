
package gouv.education.apogee.commun.transverse.dto.pedagogique.periodeelpdto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PeriodeElpDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PeriodeElpDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codPerEnsElp" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libPerEnsElp" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="licPerEnsElp" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="temEnSve" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PeriodeElpDTO", propOrder = {
    "codPerEnsElp",
    "libPerEnsElp",
    "licPerEnsElp",
    "temEnSve"
})
public class PeriodeElpDTO {

    @XmlElement(required = true, nillable = true)
    protected String codPerEnsElp;
    @XmlElement(required = true, nillable = true)
    protected String libPerEnsElp;
    @XmlElement(required = true, nillable = true)
    protected String licPerEnsElp;
    @XmlElement(required = true, nillable = true)
    protected String temEnSve;

    /**
     * Gets the value of the codPerEnsElp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodPerEnsElp() {
        return codPerEnsElp;
    }

    /**
     * Sets the value of the codPerEnsElp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodPerEnsElp(String value) {
        this.codPerEnsElp = value;
    }

    /**
     * Gets the value of the libPerEnsElp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibPerEnsElp() {
        return libPerEnsElp;
    }

    /**
     * Sets the value of the libPerEnsElp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibPerEnsElp(String value) {
        this.libPerEnsElp = value;
    }

    /**
     * Gets the value of the licPerEnsElp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLicPerEnsElp() {
        return licPerEnsElp;
    }

    /**
     * Sets the value of the licPerEnsElp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLicPerEnsElp(String value) {
        this.licPerEnsElp = value;
    }

    /**
     * Gets the value of the temEnSve property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemEnSve() {
        return temEnSve;
    }

    /**
     * Sets the value of the temEnSve property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemEnSve(String value) {
        this.temEnSve = value;
    }

}
