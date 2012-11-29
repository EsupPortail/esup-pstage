
package gouv.education.apogee.commun.transverse.dto.administratif.niveauformationdto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NiveauFormationDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NiveauFormationDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codeNiveauFormaSISE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libNiveauFormaSISE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NiveauFormationDTO", propOrder = {
    "codeNiveauFormaSISE",
    "libNiveauFormaSISE"
})
public class NiveauFormationDTO {

    @XmlElement(required = true, nillable = true)
    protected String codeNiveauFormaSISE;
    @XmlElement(required = true, nillable = true)
    protected String libNiveauFormaSISE;

    /**
     * Gets the value of the codeNiveauFormaSISE property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeNiveauFormaSISE() {
        return codeNiveauFormaSISE;
    }

    /**
     * Sets the value of the codeNiveauFormaSISE property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeNiveauFormaSISE(String value) {
        this.codeNiveauFormaSISE = value;
    }

    /**
     * Gets the value of the libNiveauFormaSISE property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibNiveauFormaSISE() {
        return libNiveauFormaSISE;
    }

    /**
     * Sets the value of the libNiveauFormaSISE property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibNiveauFormaSISE(String value) {
        this.libNiveauFormaSISE = value;
    }

}
