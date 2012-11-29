
package gouv.education.apogee.commun.transverse.dto.pedagogique.domaineformationdiplomedto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DomaineFormationDiplomeDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DomaineFormationDiplomeDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codDomForm" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libDomForm" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlType(name = "DomaineFormationDiplomeDTO", propOrder = {
    "codDomForm",
    "libDomForm",
    "temEnSve"
})
public class DomaineFormationDiplomeDTO {

    @XmlElement(required = true, nillable = true)
    protected String codDomForm;
    @XmlElement(required = true, nillable = true)
    protected String libDomForm;
    @XmlElement(required = true, nillable = true)
    protected String temEnSve;

    /**
     * Gets the value of the codDomForm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodDomForm() {
        return codDomForm;
    }

    /**
     * Sets the value of the codDomForm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodDomForm(String value) {
        this.codDomForm = value;
    }

    /**
     * Gets the value of the libDomForm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibDomForm() {
        return libDomForm;
    }

    /**
     * Sets the value of the libDomForm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibDomForm(String value) {
        this.libDomForm = value;
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
