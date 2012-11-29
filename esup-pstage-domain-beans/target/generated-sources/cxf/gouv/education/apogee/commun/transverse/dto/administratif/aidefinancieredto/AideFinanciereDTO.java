
package gouv.education.apogee.commun.transverse.dto.administratif.aidefinancieredto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AideFinanciereDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AideFinanciereDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codeAide" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libAide" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libWebAide" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AideFinanciereDTO", propOrder = {
    "codeAide",
    "libAide",
    "libWebAide"
})
public class AideFinanciereDTO {

    @XmlElement(required = true, nillable = true)
    protected String codeAide;
    @XmlElement(required = true, nillable = true)
    protected String libAide;
    @XmlElement(required = true, nillable = true)
    protected String libWebAide;

    /**
     * Gets the value of the codeAide property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeAide() {
        return codeAide;
    }

    /**
     * Sets the value of the codeAide property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeAide(String value) {
        this.codeAide = value;
    }

    /**
     * Gets the value of the libAide property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibAide() {
        return libAide;
    }

    /**
     * Sets the value of the libAide property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibAide(String value) {
        this.libAide = value;
    }

    /**
     * Gets the value of the libWebAide property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibWebAide() {
        return libWebAide;
    }

    /**
     * Sets the value of the libWebAide property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibWebAide(String value) {
        this.libWebAide = value;
    }

}
