
package gouv.education.apogee.commun.transverse.dto.wsreferentiel.recupererinformationetabref.variableappliwsetabrefdto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VariableAppliWSEtabRefDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VariableAppliWSEtabRefDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codVap" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libVap" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="parVap" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VariableAppliWSEtabRefDTO", propOrder = {
    "codVap",
    "libVap",
    "parVap"
})
public class VariableAppliWSEtabRefDTO {

    @XmlElement(required = true, nillable = true)
    protected String codVap;
    @XmlElement(required = true, nillable = true)
    protected String libVap;
    @XmlElement(required = true, nillable = true)
    protected String parVap;

    /**
     * Gets the value of the codVap property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodVap() {
        return codVap;
    }

    /**
     * Sets the value of the codVap property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodVap(String value) {
        this.codVap = value;
    }

    /**
     * Gets the value of the libVap property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibVap() {
        return libVap;
    }

    /**
     * Sets the value of the libVap property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibVap(String value) {
        this.libVap = value;
    }

    /**
     * Gets the value of the parVap property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParVap() {
        return parVap;
    }

    /**
     * Sets the value of the parVap property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParVap(String value) {
        this.parVap = value;
    }

}
