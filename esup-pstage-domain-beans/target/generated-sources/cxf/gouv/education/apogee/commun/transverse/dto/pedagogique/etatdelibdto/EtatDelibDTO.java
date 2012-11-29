
package gouv.education.apogee.commun.transverse.dto.pedagogique.etatdelibdto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EtatDelibDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EtatDelibDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codEtaAvc" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libEtaAvc" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EtatDelibDTO", propOrder = {
    "codEtaAvc",
    "libEtaAvc"
})
public class EtatDelibDTO {

    @XmlElement(required = true, nillable = true)
    protected String codEtaAvc;
    @XmlElement(required = true, nillable = true)
    protected String libEtaAvc;

    /**
     * Gets the value of the codEtaAvc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodEtaAvc() {
        return codEtaAvc;
    }

    /**
     * Sets the value of the codEtaAvc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodEtaAvc(String value) {
        this.codEtaAvc = value;
    }

    /**
     * Gets the value of the libEtaAvc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibEtaAvc() {
        return libEtaAvc;
    }

    /**
     * Sets the value of the libEtaAvc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibEtaAvc(String value) {
        this.libEtaAvc = value;
    }

}
