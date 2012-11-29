
package gouv.education.apogee.commun.transverse.dto.etudiant.numssocdto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NumSSocDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NumSSocDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cleNumSSoc" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="numSSoc" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NumSSocDTO", propOrder = {
    "cleNumSSoc",
    "numSSoc"
})
public class NumSSocDTO {

    @XmlElement(required = true, nillable = true)
    protected String cleNumSSoc;
    @XmlElement(required = true, nillable = true)
    protected String numSSoc;

    /**
     * Gets the value of the cleNumSSoc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCleNumSSoc() {
        return cleNumSSoc;
    }

    /**
     * Sets the value of the cleNumSSoc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCleNumSSoc(String value) {
        this.cleNumSSoc = value;
    }

    /**
     * Gets the value of the numSSoc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumSSoc() {
        return numSSoc;
    }

    /**
     * Sets the value of the numSSoc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumSSoc(String value) {
        this.numSSoc = value;
    }

}
