
package gouv.education.apogee.commun.transverse.dto.administratif.cgedto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CgeDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CgeDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codeCGE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libCGE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CgeDTO", propOrder = {
    "codeCGE",
    "libCGE"
})
public class CgeDTO {

    @XmlElement(required = true, nillable = true)
    protected String codeCGE;
    @XmlElement(required = true, nillable = true)
    protected String libCGE;

    /**
     * Gets the value of the codeCGE property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeCGE() {
        return codeCGE;
    }

    /**
     * Sets the value of the codeCGE property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeCGE(String value) {
        this.codeCGE = value;
    }

    /**
     * Gets the value of the libCGE property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibCGE() {
        return libCGE;
    }

    /**
     * Sets the value of the libCGE property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibCGE(String value) {
        this.libCGE = value;
    }

}
