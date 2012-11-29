
package gouv.education.apogee.commun.transverse.dto.administratif.typdiplomesisedto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TypDiplomeSISEDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TypDiplomeSISEDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codeTypDiplomeSise" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libTypDiplomeSise" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TypDiplomeSISEDTO", propOrder = {
    "codeTypDiplomeSise",
    "libTypDiplomeSise"
})
public class TypDiplomeSISEDTO {

    @XmlElement(required = true, nillable = true)
    protected String codeTypDiplomeSise;
    @XmlElement(required = true, nillable = true)
    protected String libTypDiplomeSise;

    /**
     * Gets the value of the codeTypDiplomeSise property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeTypDiplomeSise() {
        return codeTypDiplomeSise;
    }

    /**
     * Sets the value of the codeTypDiplomeSise property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeTypDiplomeSise(String value) {
        this.codeTypDiplomeSise = value;
    }

    /**
     * Gets the value of the libTypDiplomeSise property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibTypDiplomeSise() {
        return libTypDiplomeSise;
    }

    /**
     * Sets the value of the libTypDiplomeSise property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibTypDiplomeSise(String value) {
        this.libTypDiplomeSise = value;
    }

}
