
package gouv.education.apogee.commun.transverse.dto.pedagogique.formuleexamendto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FormuleExamenDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FormuleExamenDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codFex" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libFex" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FormuleExamenDTO", propOrder = {
    "codFex",
    "libFex"
})
public class FormuleExamenDTO {

    @XmlElement(required = true, nillable = true)
    protected String codFex;
    @XmlElement(required = true, nillable = true)
    protected String libFex;

    /**
     * Gets the value of the codFex property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodFex() {
        return codFex;
    }

    /**
     * Sets the value of the codFex property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodFex(String value) {
        this.codFex = value;
    }

    /**
     * Gets the value of the libFex property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibFex() {
        return libFex;
    }

    /**
     * Sets the value of the libFex property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibFex(String value) {
        this.libFex = value;
    }

}
