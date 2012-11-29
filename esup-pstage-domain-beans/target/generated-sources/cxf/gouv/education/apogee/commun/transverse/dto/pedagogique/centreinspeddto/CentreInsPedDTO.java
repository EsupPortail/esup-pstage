
package gouv.education.apogee.commun.transverse.dto.pedagogique.centreinspeddto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CentreInsPedDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CentreInsPedDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codCip" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libCip" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CentreInsPedDTO", propOrder = {
    "codCip",
    "libCip"
})
public class CentreInsPedDTO {

    @XmlElement(required = true, nillable = true)
    protected String codCip;
    @XmlElement(required = true, nillable = true)
    protected String libCip;

    /**
     * Gets the value of the codCip property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodCip() {
        return codCip;
    }

    /**
     * Sets the value of the codCip property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodCip(String value) {
        this.codCip = value;
    }

    /**
     * Gets the value of the libCip property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibCip() {
        return libCip;
    }

    /**
     * Sets the value of the libCip property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibCip(String value) {
        this.libCip = value;
    }

}
