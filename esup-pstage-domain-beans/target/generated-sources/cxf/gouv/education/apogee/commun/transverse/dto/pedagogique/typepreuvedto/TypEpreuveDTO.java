
package gouv.education.apogee.commun.transverse.dto.pedagogique.typepreuvedto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TypEpreuveDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TypEpreuveDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codTep" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libTep" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TypEpreuveDTO", propOrder = {
    "codTep",
    "libTep"
})
public class TypEpreuveDTO {

    @XmlElement(required = true, nillable = true)
    protected String codTep;
    @XmlElement(required = true, nillable = true)
    protected String libTep;

    /**
     * Gets the value of the codTep property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodTep() {
        return codTep;
    }

    /**
     * Sets the value of the codTep property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodTep(String value) {
        this.codTep = value;
    }

    /**
     * Gets the value of the libTep property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibTep() {
        return libTep;
    }

    /**
     * Sets the value of the libTep property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibTep(String value) {
        this.libTep = value;
    }

}
