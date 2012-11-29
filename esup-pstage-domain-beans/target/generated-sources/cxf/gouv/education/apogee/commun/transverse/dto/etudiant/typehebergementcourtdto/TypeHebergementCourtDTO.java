
package gouv.education.apogee.commun.transverse.dto.etudiant.typehebergementcourtdto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TypeHebergementCourtDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TypeHebergementCourtDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codTypeHebergement" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libTypeHebergement" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libWebTypeHebergement" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TypeHebergementCourtDTO", propOrder = {
    "codTypeHebergement",
    "libTypeHebergement",
    "libWebTypeHebergement"
})
public class TypeHebergementCourtDTO {

    @XmlElement(required = true, nillable = true)
    protected String codTypeHebergement;
    @XmlElement(required = true, nillable = true)
    protected String libTypeHebergement;
    @XmlElement(required = true, nillable = true)
    protected String libWebTypeHebergement;

    /**
     * Gets the value of the codTypeHebergement property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodTypeHebergement() {
        return codTypeHebergement;
    }

    /**
     * Sets the value of the codTypeHebergement property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodTypeHebergement(String value) {
        this.codTypeHebergement = value;
    }

    /**
     * Gets the value of the libTypeHebergement property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibTypeHebergement() {
        return libTypeHebergement;
    }

    /**
     * Sets the value of the libTypeHebergement property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibTypeHebergement(String value) {
        this.libTypeHebergement = value;
    }

    /**
     * Gets the value of the libWebTypeHebergement property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibWebTypeHebergement() {
        return libWebTypeHebergement;
    }

    /**
     * Sets the value of the libWebTypeHebergement property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibWebTypeHebergement(String value) {
        this.libWebTypeHebergement = value;
    }

}
