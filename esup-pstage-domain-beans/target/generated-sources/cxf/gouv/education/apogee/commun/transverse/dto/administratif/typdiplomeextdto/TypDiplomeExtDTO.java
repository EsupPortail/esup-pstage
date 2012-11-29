
package gouv.education.apogee.commun.transverse.dto.administratif.typdiplomeextdto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TypDiplomeExtDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TypDiplomeExtDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codeTypDiplomeExt" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libTypDiplomeExt" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TypDiplomeExtDTO", propOrder = {
    "codeTypDiplomeExt",
    "libTypDiplomeExt"
})
public class TypDiplomeExtDTO {

    @XmlElement(required = true, nillable = true)
    protected String codeTypDiplomeExt;
    @XmlElement(required = true, nillable = true)
    protected String libTypDiplomeExt;

    /**
     * Gets the value of the codeTypDiplomeExt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeTypDiplomeExt() {
        return codeTypDiplomeExt;
    }

    /**
     * Sets the value of the codeTypDiplomeExt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeTypDiplomeExt(String value) {
        this.codeTypDiplomeExt = value;
    }

    /**
     * Gets the value of the libTypDiplomeExt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibTypDiplomeExt() {
        return libTypDiplomeExt;
    }

    /**
     * Sets the value of the libTypDiplomeExt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibTypDiplomeExt(String value) {
        this.libTypDiplomeExt = value;
    }

}
