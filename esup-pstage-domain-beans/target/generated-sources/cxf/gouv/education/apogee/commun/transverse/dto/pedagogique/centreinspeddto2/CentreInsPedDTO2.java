
package gouv.education.apogee.commun.transverse.dto.pedagogique.centreinspeddto2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CentreInsPedDTO2 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CentreInsPedDTO2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codCtreInsPedag" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libCtreInsPedag" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="licCtreInsPedag" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="temEnSve" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CentreInsPedDTO2", propOrder = {
    "codCtreInsPedag",
    "libCtreInsPedag",
    "licCtreInsPedag",
    "temEnSve"
})
public class CentreInsPedDTO2 {

    @XmlElement(required = true, nillable = true)
    protected String codCtreInsPedag;
    @XmlElement(required = true, nillable = true)
    protected String libCtreInsPedag;
    @XmlElement(required = true, nillable = true)
    protected String licCtreInsPedag;
    @XmlElement(required = true, nillable = true)
    protected String temEnSve;

    /**
     * Gets the value of the codCtreInsPedag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodCtreInsPedag() {
        return codCtreInsPedag;
    }

    /**
     * Sets the value of the codCtreInsPedag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodCtreInsPedag(String value) {
        this.codCtreInsPedag = value;
    }

    /**
     * Gets the value of the libCtreInsPedag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibCtreInsPedag() {
        return libCtreInsPedag;
    }

    /**
     * Sets the value of the libCtreInsPedag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibCtreInsPedag(String value) {
        this.libCtreInsPedag = value;
    }

    /**
     * Gets the value of the licCtreInsPedag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLicCtreInsPedag() {
        return licCtreInsPedag;
    }

    /**
     * Sets the value of the licCtreInsPedag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLicCtreInsPedag(String value) {
        this.licCtreInsPedag = value;
    }

    /**
     * Gets the value of the temEnSve property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemEnSve() {
        return temEnSve;
    }

    /**
     * Sets the value of the temEnSve property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemEnSve(String value) {
        this.temEnSve = value;
    }

}
