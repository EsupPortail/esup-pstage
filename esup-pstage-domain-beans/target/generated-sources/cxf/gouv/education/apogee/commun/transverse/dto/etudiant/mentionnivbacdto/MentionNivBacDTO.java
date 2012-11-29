
package gouv.education.apogee.commun.transverse.dto.etudiant.mentionnivbacdto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MentionNivBacDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MentionNivBacDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codMention" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libMention" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MentionNivBacDTO", propOrder = {
    "codMention",
    "libMention"
})
public class MentionNivBacDTO {

    @XmlElement(required = true, nillable = true)
    protected String codMention;
    @XmlElement(required = true, nillable = true)
    protected String libMention;

    /**
     * Gets the value of the codMention property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodMention() {
        return codMention;
    }

    /**
     * Sets the value of the codMention property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodMention(String value) {
        this.codMention = value;
    }

    /**
     * Gets the value of the libMention property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibMention() {
        return libMention;
    }

    /**
     * Sets the value of the libMention property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibMention(String value) {
        this.libMention = value;
    }

}
