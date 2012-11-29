
package gouv.education.apogee.commun.transverse.dto.administratif.etatiaedto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EtatIAEDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EtatIAEDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codeEtatIAE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libEtatIAE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EtatIAEDTO", propOrder = {
    "codeEtatIAE",
    "libEtatIAE"
})
public class EtatIAEDTO {

    @XmlElement(required = true, nillable = true)
    protected String codeEtatIAE;
    @XmlElement(required = true, nillable = true)
    protected String libEtatIAE;

    /**
     * Gets the value of the codeEtatIAE property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeEtatIAE() {
        return codeEtatIAE;
    }

    /**
     * Sets the value of the codeEtatIAE property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeEtatIAE(String value) {
        this.codeEtatIAE = value;
    }

    /**
     * Gets the value of the libEtatIAE property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibEtatIAE() {
        return libEtatIAE;
    }

    /**
     * Sets the value of the libEtatIAE property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibEtatIAE(String value) {
        this.libEtatIAE = value;
    }

}
