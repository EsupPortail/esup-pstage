
package gouv.education.apogee.commun.transverse.dto.administratif.situationsisedto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SituationSISEDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SituationSISEDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codeSitSISE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libSitSISE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libWebSitSISE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SituationSISEDTO", propOrder = {
    "codeSitSISE",
    "libSitSISE",
    "libWebSitSISE"
})
public class SituationSISEDTO {

    @XmlElement(required = true, nillable = true)
    protected String codeSitSISE;
    @XmlElement(required = true, nillable = true)
    protected String libSitSISE;
    @XmlElement(required = true, nillable = true)
    protected String libWebSitSISE;

    /**
     * Gets the value of the codeSitSISE property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeSitSISE() {
        return codeSitSISE;
    }

    /**
     * Sets the value of the codeSitSISE property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeSitSISE(String value) {
        this.codeSitSISE = value;
    }

    /**
     * Gets the value of the libSitSISE property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibSitSISE() {
        return libSitSISE;
    }

    /**
     * Sets the value of the libSitSISE property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibSitSISE(String value) {
        this.libSitSISE = value;
    }

    /**
     * Gets the value of the libWebSitSISE property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibWebSitSISE() {
        return libWebSitSISE;
    }

    /**
     * Sets the value of the libWebSitSISE property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibWebSitSISE(String value) {
        this.libWebSitSISE = value;
    }

}
