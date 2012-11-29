
package gouv.education.apogee.commun.transverse.dto.pedagogique.centregestiondto2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CentreGestionDTO2 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CentreGestionDTO2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codCge" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libCge" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="licCge" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlType(name = "CentreGestionDTO2", propOrder = {
    "codCge",
    "libCge",
    "licCge",
    "temEnSve"
})
public class CentreGestionDTO2 {

    @XmlElement(required = true, nillable = true)
    protected String codCge;
    @XmlElement(required = true, nillable = true)
    protected String libCge;
    @XmlElement(required = true, nillable = true)
    protected String licCge;
    @XmlElement(required = true, nillable = true)
    protected String temEnSve;

    /**
     * Gets the value of the codCge property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodCge() {
        return codCge;
    }

    /**
     * Sets the value of the codCge property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodCge(String value) {
        this.codCge = value;
    }

    /**
     * Gets the value of the libCge property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibCge() {
        return libCge;
    }

    /**
     * Sets the value of the libCge property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibCge(String value) {
        this.libCge = value;
    }

    /**
     * Gets the value of the licCge property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLicCge() {
        return licCge;
    }

    /**
     * Sets the value of the licCge property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLicCge(String value) {
        this.licCge = value;
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
