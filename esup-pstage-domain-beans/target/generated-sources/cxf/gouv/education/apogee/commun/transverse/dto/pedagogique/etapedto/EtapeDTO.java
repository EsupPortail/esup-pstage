
package gouv.education.apogee.commun.transverse.dto.pedagogique.etapedto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EtapeDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EtapeDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codEtp" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codVrsVet" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="libEtp" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libWebVet" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="temDipVet" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EtapeDTO", propOrder = {
    "codEtp",
    "codVrsVet",
    "libEtp",
    "libWebVet",
    "temDipVet"
})
public class EtapeDTO {

    @XmlElement(required = true, nillable = true)
    protected String codEtp;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer codVrsVet;
    @XmlElement(required = true, nillable = true)
    protected String libEtp;
    @XmlElement(required = true, nillable = true)
    protected String libWebVet;
    @XmlElement(required = true, nillable = true)
    protected String temDipVet;

    /**
     * Gets the value of the codEtp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodEtp() {
        return codEtp;
    }

    /**
     * Sets the value of the codEtp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodEtp(String value) {
        this.codEtp = value;
    }

    /**
     * Gets the value of the codVrsVet property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCodVrsVet() {
        return codVrsVet;
    }

    /**
     * Sets the value of the codVrsVet property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCodVrsVet(Integer value) {
        this.codVrsVet = value;
    }

    /**
     * Gets the value of the libEtp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibEtp() {
        return libEtp;
    }

    /**
     * Sets the value of the libEtp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibEtp(String value) {
        this.libEtp = value;
    }

    /**
     * Gets the value of the libWebVet property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibWebVet() {
        return libWebVet;
    }

    /**
     * Sets the value of the libWebVet property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibWebVet(String value) {
        this.libWebVet = value;
    }

    /**
     * Gets the value of the temDipVet property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemDipVet() {
        return temDipVet;
    }

    /**
     * Sets the value of the temDipVet property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemDipVet(String value) {
        this.temDipVet = value;
    }

}
