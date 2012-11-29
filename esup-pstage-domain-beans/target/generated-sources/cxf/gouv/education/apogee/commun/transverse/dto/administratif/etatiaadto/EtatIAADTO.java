
package gouv.education.apogee.commun.transverse.dto.administratif.etatiaadto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EtatIAADTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EtatIAADTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codeEtatIAA" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libEtatIAA" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EtatIAADTO", propOrder = {
    "codeEtatIAA",
    "libEtatIAA"
})
public class EtatIAADTO {

    @XmlElement(required = true, nillable = true)
    protected String codeEtatIAA;
    @XmlElement(required = true, nillable = true)
    protected String libEtatIAA;

    /**
     * Gets the value of the codeEtatIAA property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeEtatIAA() {
        return codeEtatIAA;
    }

    /**
     * Sets the value of the codeEtatIAA property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeEtatIAA(String value) {
        this.codeEtatIAA = value;
    }

    /**
     * Gets the value of the libEtatIAA property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibEtatIAA() {
        return libEtatIAA;
    }

    /**
     * Sets the value of the libEtatIAA property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibEtatIAA(String value) {
        this.libEtatIAA = value;
    }

}
