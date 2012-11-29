
package gouv.education.apogee.commun.transverse.dto.pedagogique.cycledto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CycleDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CycleDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codCycleSISE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libCycleSISE" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlType(name = "CycleDTO", propOrder = {
    "codCycleSISE",
    "libCycleSISE",
    "temEnSve"
})
public class CycleDTO {

    @XmlElement(required = true, nillable = true)
    protected String codCycleSISE;
    @XmlElement(required = true, nillable = true)
    protected String libCycleSISE;
    @XmlElement(required = true, nillable = true)
    protected String temEnSve;

    /**
     * Gets the value of the codCycleSISE property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodCycleSISE() {
        return codCycleSISE;
    }

    /**
     * Sets the value of the codCycleSISE property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodCycleSISE(String value) {
        this.codCycleSISE = value;
    }

    /**
     * Gets the value of the libCycleSISE property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibCycleSISE() {
        return libCycleSISE;
    }

    /**
     * Sets the value of the libCycleSISE property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibCycleSISE(String value) {
        this.libCycleSISE = value;
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
