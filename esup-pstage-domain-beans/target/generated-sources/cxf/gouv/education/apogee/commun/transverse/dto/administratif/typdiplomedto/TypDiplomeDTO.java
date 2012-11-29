
package gouv.education.apogee.commun.transverse.dto.administratif.typdiplomedto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TypDiplomeDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TypDiplomeDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codeTypeDiplome" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libTypeDiplome" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TypDiplomeDTO", propOrder = {
    "codeTypeDiplome",
    "libTypeDiplome"
})
public class TypDiplomeDTO {

    @XmlElement(required = true, nillable = true)
    protected String codeTypeDiplome;
    @XmlElement(required = true, nillable = true)
    protected String libTypeDiplome;

    /**
     * Gets the value of the codeTypeDiplome property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeTypeDiplome() {
        return codeTypeDiplome;
    }

    /**
     * Sets the value of the codeTypeDiplome property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeTypeDiplome(String value) {
        this.codeTypeDiplome = value;
    }

    /**
     * Gets the value of the libTypeDiplome property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibTypeDiplome() {
        return libTypeDiplome;
    }

    /**
     * Sets the value of the libTypeDiplome property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibTypeDiplome(String value) {
        this.libTypeDiplome = value;
    }

}
