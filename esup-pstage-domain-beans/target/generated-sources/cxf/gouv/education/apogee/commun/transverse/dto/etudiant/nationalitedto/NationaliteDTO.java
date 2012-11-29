
package gouv.education.apogee.commun.transverse.dto.etudiant.nationalitedto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NationaliteDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NationaliteDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codeNationalite" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libNationalite" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NationaliteDTO", propOrder = {
    "codeNationalite",
    "libNationalite"
})
public class NationaliteDTO {

    @XmlElement(required = true, nillable = true)
    protected String codeNationalite;
    @XmlElement(required = true, nillable = true)
    protected String libNationalite;

    /**
     * Gets the value of the codeNationalite property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeNationalite() {
        return codeNationalite;
    }

    /**
     * Sets the value of the codeNationalite property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeNationalite(String value) {
        this.codeNationalite = value;
    }

    /**
     * Gets the value of the libNationalite property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibNationalite() {
        return libNationalite;
    }

    /**
     * Sets the value of the libNationalite property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibNationalite(String value) {
        this.libNationalite = value;
    }

}
