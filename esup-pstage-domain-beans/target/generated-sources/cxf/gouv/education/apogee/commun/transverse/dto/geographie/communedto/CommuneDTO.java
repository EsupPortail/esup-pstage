
package gouv.education.apogee.commun.transverse.dto.geographie.communedto;

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
 *         &lt;element name="codeCommune" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codePostal" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libBureauDis" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libCommune" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="temSevBureauDis" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="temSevCommune" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "codeCommune",
    "codePostal",
    "libBureauDis",
    "libCommune",
    "temSevBureauDis",
    "temSevCommune"
})
public class CommuneDTO {

    @XmlElement(required = true, nillable = true)
    protected String codeCommune;
    @XmlElement(required = true, nillable = true)
    protected String codePostal;
    @XmlElement(required = true, nillable = true)
    protected String libBureauDis;
    @XmlElement(required = true, nillable = true)
    protected String libCommune;
    @XmlElement(required = true, nillable = true)
    protected String temSevBureauDis;
    @XmlElement(required = true, nillable = true)
    protected String temSevCommune;

    /**
     * Gets the value of the codeCommune property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeCommune() {
        return codeCommune;
    }

    /**
     * Sets the value of the codeCommune property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeCommune(String value) {
        this.codeCommune = value;
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
     * Gets the value of the libBureauDis property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibBureauDis() {
        return libBureauDis;
    }

    /**
     * Sets the value of the libBureauDis property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibBureauDis(String value) {
        this.libBureauDis = value;
    }

    /**
     * Gets the value of the libCommune property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibCommune() {
        return libCommune;
    }

    /**
     * Sets the value of the libCommune property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibCommune(String value) {
        this.libCommune = value;
    }

    /**
     * Gets the value of the temSevBureauDis property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemSevBureauDis() {
        return temSevBureauDis;
    }

    /**
     * Sets the value of the temSevBureauDis property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemSevBureauDis(String value) {
        this.temSevBureauDis = value;
    }

    /**
     * Gets the value of the temSevCommune property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemSevCommune() {
        return temSevCommune;
    }

    /**
     * Sets the value of the temSevCommune property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemSevCommune(String value) {
        this.temSevCommune = value;
    }

}
