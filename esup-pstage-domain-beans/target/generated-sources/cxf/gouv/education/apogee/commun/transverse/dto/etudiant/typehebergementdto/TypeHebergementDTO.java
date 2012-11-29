
package gouv.education.apogee.commun.transverse.dto.etudiant.typehebergementdto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TypeHebergementDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TypeHebergementDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codTypeHebergement" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libTypeHebergement" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libWebTypeHebergement" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="temEnSveTypeHebergement" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="temMinTypeHebergement" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TypeHebergementDTO", propOrder = {
    "codTypeHebergement",
    "libTypeHebergement",
    "libWebTypeHebergement",
    "temEnSveTypeHebergement",
    "temMinTypeHebergement"
})
public class TypeHebergementDTO {

    @XmlElement(required = true, nillable = true)
    protected String codTypeHebergement;
    @XmlElement(required = true, nillable = true)
    protected String libTypeHebergement;
    @XmlElement(required = true, nillable = true)
    protected String libWebTypeHebergement;
    @XmlElement(required = true, nillable = true)
    protected String temEnSveTypeHebergement;
    @XmlElement(required = true, nillable = true)
    protected String temMinTypeHebergement;

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

    /**
     * Gets the value of the temEnSveTypeHebergement property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemEnSveTypeHebergement() {
        return temEnSveTypeHebergement;
    }

    /**
     * Sets the value of the temEnSveTypeHebergement property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemEnSveTypeHebergement(String value) {
        this.temEnSveTypeHebergement = value;
    }

    /**
     * Gets the value of the temMinTypeHebergement property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemMinTypeHebergement() {
        return temMinTypeHebergement;
    }

    /**
     * Sets the value of the temMinTypeHebergement property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemMinTypeHebergement(String value) {
        this.temMinTypeHebergement = value;
    }

}
