
package gouv.education.apogee.commun.transverse.dto.pedagogique.centreincompdto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CentreIncompDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CentreIncompDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codCtreIncomp" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libCtreIncomp" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlType(name = "CentreIncompDTO", propOrder = {
    "codCtreIncomp",
    "libCtreIncomp",
    "temEnSve"
})
public class CentreIncompDTO {

    @XmlElement(required = true, nillable = true)
    protected String codCtreIncomp;
    @XmlElement(required = true, nillable = true)
    protected String libCtreIncomp;
    @XmlElement(required = true, nillable = true)
    protected String temEnSve;

    /**
     * Gets the value of the codCtreIncomp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodCtreIncomp() {
        return codCtreIncomp;
    }

    /**
     * Sets the value of the codCtreIncomp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodCtreIncomp(String value) {
        this.codCtreIncomp = value;
    }

    /**
     * Gets the value of the libCtreIncomp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibCtreIncomp() {
        return libCtreIncomp;
    }

    /**
     * Sets the value of the libCtreIncomp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibCtreIncomp(String value) {
        this.libCtreIncomp = value;
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
