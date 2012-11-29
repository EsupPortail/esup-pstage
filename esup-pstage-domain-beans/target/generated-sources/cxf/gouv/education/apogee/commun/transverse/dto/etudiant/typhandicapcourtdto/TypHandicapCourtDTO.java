
package gouv.education.apogee.commun.transverse.dto.etudiant.typhandicapcourtdto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TypHandicapCourtDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TypHandicapCourtDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codeHandicap" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libHandicap" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libThp" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TypHandicapCourtDTO", propOrder = {
    "codeHandicap",
    "libHandicap",
    "libThp"
})
public class TypHandicapCourtDTO {

    @XmlElement(required = true, nillable = true)
    protected String codeHandicap;
    @XmlElement(required = true, nillable = true)
    protected String libHandicap;
    @XmlElement(required = true, nillable = true)
    protected String libThp;

    /**
     * Gets the value of the codeHandicap property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeHandicap() {
        return codeHandicap;
    }

    /**
     * Sets the value of the codeHandicap property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeHandicap(String value) {
        this.codeHandicap = value;
    }

    /**
     * Gets the value of the libHandicap property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibHandicap() {
        return libHandicap;
    }

    /**
     * Sets the value of the libHandicap property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibHandicap(String value) {
        this.libHandicap = value;
    }

    /**
     * Gets the value of the libThp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibThp() {
        return libThp;
    }

    /**
     * Sets the value of the libThp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibThp(String value) {
        this.libThp = value;
    }

}
