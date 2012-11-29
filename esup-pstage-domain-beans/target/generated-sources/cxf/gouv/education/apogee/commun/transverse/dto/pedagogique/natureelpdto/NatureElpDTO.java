
package gouv.education.apogee.commun.transverse.dto.pedagogique.natureelpdto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NatureElpDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NatureElpDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codNel" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libNel" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="temFictif" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="temSemestre" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="temUe" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NatureElpDTO", propOrder = {
    "codNel",
    "libNel",
    "temFictif",
    "temSemestre",
    "temUe"
})
public class NatureElpDTO {

    @XmlElement(required = true, nillable = true)
    protected String codNel;
    @XmlElement(required = true, nillable = true)
    protected String libNel;
    @XmlElement(required = true, nillable = true)
    protected String temFictif;
    @XmlElement(required = true, nillable = true)
    protected String temSemestre;
    @XmlElement(required = true, nillable = true)
    protected String temUe;

    /**
     * Gets the value of the codNel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodNel() {
        return codNel;
    }

    /**
     * Sets the value of the codNel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodNel(String value) {
        this.codNel = value;
    }

    /**
     * Gets the value of the libNel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibNel() {
        return libNel;
    }

    /**
     * Sets the value of the libNel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibNel(String value) {
        this.libNel = value;
    }

    /**
     * Gets the value of the temFictif property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemFictif() {
        return temFictif;
    }

    /**
     * Sets the value of the temFictif property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemFictif(String value) {
        this.temFictif = value;
    }

    /**
     * Gets the value of the temSemestre property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemSemestre() {
        return temSemestre;
    }

    /**
     * Sets the value of the temSemestre property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemSemestre(String value) {
        this.temSemestre = value;
    }

    /**
     * Gets the value of the temUe property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemUe() {
        return temUe;
    }

    /**
     * Sets the value of the temUe property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemUe(String value) {
        this.temUe = value;
    }

}
