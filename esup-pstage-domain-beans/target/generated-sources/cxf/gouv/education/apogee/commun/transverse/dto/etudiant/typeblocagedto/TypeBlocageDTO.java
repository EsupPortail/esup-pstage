
package gouv.education.apogee.commun.transverse.dto.etudiant.typeblocagedto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TypeBlocageDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TypeBlocageDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codTypBlocage" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libTypBlocage" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TypeBlocageDTO", propOrder = {
    "codTypBlocage",
    "libTypBlocage"
})
public class TypeBlocageDTO {

    @XmlElement(required = true, nillable = true)
    protected String codTypBlocage;
    @XmlElement(required = true, nillable = true)
    protected String libTypBlocage;

    /**
     * Gets the value of the codTypBlocage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodTypBlocage() {
        return codTypBlocage;
    }

    /**
     * Sets the value of the codTypBlocage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodTypBlocage(String value) {
        this.codTypBlocage = value;
    }

    /**
     * Gets the value of the libTypBlocage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibTypBlocage() {
        return libTypBlocage;
    }

    /**
     * Sets the value of the libTypBlocage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibTypBlocage(String value) {
        this.libTypBlocage = value;
    }

}
