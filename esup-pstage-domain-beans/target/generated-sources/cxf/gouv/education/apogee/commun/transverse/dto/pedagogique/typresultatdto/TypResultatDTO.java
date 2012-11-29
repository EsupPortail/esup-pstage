
package gouv.education.apogee.commun.transverse.dto.pedagogique.typresultatdto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TypResultatDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TypResultatDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codNegTre" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codTre" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libTre" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TypResultatDTO", propOrder = {
    "codNegTre",
    "codTre",
    "libTre"
})
public class TypResultatDTO {

    @XmlElement(required = true, nillable = true)
    protected String codNegTre;
    @XmlElement(required = true, nillable = true)
    protected String codTre;
    @XmlElement(required = true, nillable = true)
    protected String libTre;

    /**
     * Gets the value of the codNegTre property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodNegTre() {
        return codNegTre;
    }

    /**
     * Sets the value of the codNegTre property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodNegTre(String value) {
        this.codNegTre = value;
    }

    /**
     * Gets the value of the codTre property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodTre() {
        return codTre;
    }

    /**
     * Sets the value of the codTre property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodTre(String value) {
        this.codTre = value;
    }

    /**
     * Gets the value of the libTre property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibTre() {
        return libTre;
    }

    /**
     * Sets the value of the libTre property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibTre(String value) {
        this.libTre = value;
    }

}
