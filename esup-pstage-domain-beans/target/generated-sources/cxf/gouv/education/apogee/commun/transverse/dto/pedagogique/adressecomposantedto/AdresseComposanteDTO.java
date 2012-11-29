
package gouv.education.apogee.commun.transverse.dto.pedagogique.adressecomposantedto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AdresseComposanteDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AdresseComposanteDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codComAdrCmp" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codPosAdrCmp" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libAdr1Cmp" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libAdr2Cmp" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libAdr3Cmp" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AdresseComposanteDTO", propOrder = {
    "codComAdrCmp",
    "codPosAdrCmp",
    "libAdr1Cmp",
    "libAdr2Cmp",
    "libAdr3Cmp"
})
public class AdresseComposanteDTO {

    @XmlElement(required = true, nillable = true)
    protected String codComAdrCmp;
    @XmlElement(required = true, nillable = true)
    protected String codPosAdrCmp;
    @XmlElement(required = true, nillable = true)
    protected String libAdr1Cmp;
    @XmlElement(required = true, nillable = true)
    protected String libAdr2Cmp;
    @XmlElement(required = true, nillable = true)
    protected String libAdr3Cmp;

    /**
     * Gets the value of the codComAdrCmp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodComAdrCmp() {
        return codComAdrCmp;
    }

    /**
     * Sets the value of the codComAdrCmp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodComAdrCmp(String value) {
        this.codComAdrCmp = value;
    }

    /**
     * Gets the value of the codPosAdrCmp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodPosAdrCmp() {
        return codPosAdrCmp;
    }

    /**
     * Sets the value of the codPosAdrCmp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodPosAdrCmp(String value) {
        this.codPosAdrCmp = value;
    }

    /**
     * Gets the value of the libAdr1Cmp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibAdr1Cmp() {
        return libAdr1Cmp;
    }

    /**
     * Sets the value of the libAdr1Cmp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibAdr1Cmp(String value) {
        this.libAdr1Cmp = value;
    }

    /**
     * Gets the value of the libAdr2Cmp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibAdr2Cmp() {
        return libAdr2Cmp;
    }

    /**
     * Sets the value of the libAdr2Cmp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibAdr2Cmp(String value) {
        this.libAdr2Cmp = value;
    }

    /**
     * Gets the value of the libAdr3Cmp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibAdr3Cmp() {
        return libAdr3Cmp;
    }

    /**
     * Sets the value of the libAdr3Cmp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibAdr3Cmp(String value) {
        this.libAdr3Cmp = value;
    }

}
