
package gouv.education.apogee.commun.transverse.dto.administratif.composantedto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ComposanteDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ComposanteDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codComposante" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libComposante" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ComposanteDTO", propOrder = {
    "codComposante",
    "libComposante"
})
public class ComposanteDTO {

    @XmlElement(required = true, nillable = true)
    protected String codComposante;
    @XmlElement(required = true, nillable = true)
    protected String libComposante;

    /**
     * Gets the value of the codComposante property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodComposante() {
        return codComposante;
    }

    /**
     * Sets the value of the codComposante property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodComposante(String value) {
        this.codComposante = value;
    }

    /**
     * Gets the value of the libComposante property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibComposante() {
        return libComposante;
    }

    /**
     * Sets the value of the libComposante property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibComposante(String value) {
        this.libComposante = value;
    }

}
