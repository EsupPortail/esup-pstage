
package gouv.education.apogee.commun.transverse.dto.pedagogique.etapesisdto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EtapeSisDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EtapeSisDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codEtpSISE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libEtpSISE" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlType(name = "EtapeSisDTO", propOrder = {
    "codEtpSISE",
    "libEtpSISE",
    "temEnSve"
})
public class EtapeSisDTO {

    @XmlElement(required = true, nillable = true)
    protected String codEtpSISE;
    @XmlElement(required = true, nillable = true)
    protected String libEtpSISE;
    @XmlElement(required = true, nillable = true)
    protected String temEnSve;

    /**
     * Gets the value of the codEtpSISE property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodEtpSISE() {
        return codEtpSISE;
    }

    /**
     * Sets the value of the codEtpSISE property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodEtpSISE(String value) {
        this.codEtpSISE = value;
    }

    /**
     * Gets the value of the libEtpSISE property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibEtpSISE() {
        return libEtpSISE;
    }

    /**
     * Sets the value of the libEtpSISE property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibEtpSISE(String value) {
        this.libEtpSISE = value;
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
