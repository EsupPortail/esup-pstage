
package gouv.education.apogee.commun.transverse.dto.etudiant.paysdto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PaysDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PaysDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codPay" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libPay" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaysDTO", propOrder = {
    "codPay",
    "libPay"
})
public class PaysDTO {

    @XmlElement(required = true, nillable = true)
    protected String codPay;
    @XmlElement(required = true, nillable = true)
    protected String libPay;

    /**
     * Gets the value of the codPay property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodPay() {
        return codPay;
    }

    /**
     * Sets the value of the codPay property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodPay(String value) {
        this.codPay = value;
    }

    /**
     * Gets the value of the libPay property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibPay() {
        return libPay;
    }

    /**
     * Sets the value of the libPay property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibPay(String value) {
        this.libPay = value;
    }

}
