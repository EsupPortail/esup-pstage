
package gouv.education.apogee.commun.transverse.dto.geographie.paysdto;

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
 *         &lt;element name="codePay" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libNat" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libPay" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="temEnSvePay" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "codePay",
    "libNat",
    "libPay",
    "temEnSvePay"
})
public class PaysDTO {

    @XmlElement(required = true, nillable = true)
    protected String codePay;
    @XmlElement(required = true, nillable = true)
    protected String libNat;
    @XmlElement(required = true, nillable = true)
    protected String libPay;
    @XmlElement(required = true, nillable = true)
    protected String temEnSvePay;

    /**
     * Gets the value of the codePay property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodePay() {
        return codePay;
    }

    /**
     * Sets the value of the codePay property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodePay(String value) {
        this.codePay = value;
    }

    /**
     * Gets the value of the libNat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibNat() {
        return libNat;
    }

    /**
     * Sets the value of the libNat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibNat(String value) {
        this.libNat = value;
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

    /**
     * Gets the value of the temEnSvePay property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemEnSvePay() {
        return temEnSvePay;
    }

    /**
     * Sets the value of the temEnSvePay property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemEnSvePay(String value) {
        this.temEnSvePay = value;
    }

}
