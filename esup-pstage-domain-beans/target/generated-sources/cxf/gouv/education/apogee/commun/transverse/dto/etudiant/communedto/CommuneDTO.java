
package gouv.education.apogee.commun.transverse.dto.etudiant.communedto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CommuneDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CommuneDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codeInsee" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codePostal" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nomCommune" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CommuneDTO", propOrder = {
    "codeInsee",
    "codePostal",
    "nomCommune"
})
public class CommuneDTO {

    @XmlElement(required = true, nillable = true)
    protected String codeInsee;
    @XmlElement(required = true, nillable = true)
    protected String codePostal;
    @XmlElement(required = true, nillable = true)
    protected String nomCommune;

    /**
     * Gets the value of the codeInsee property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeInsee() {
        return codeInsee;
    }

    /**
     * Sets the value of the codeInsee property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeInsee(String value) {
        this.codeInsee = value;
    }

    /**
     * Gets the value of the codePostal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodePostal() {
        return codePostal;
    }

    /**
     * Sets the value of the codePostal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodePostal(String value) {
        this.codePostal = value;
    }

    /**
     * Gets the value of the nomCommune property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomCommune() {
        return nomCommune;
    }

    /**
     * Sets the value of the nomCommune property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomCommune(String value) {
        this.nomCommune = value;
    }

}
