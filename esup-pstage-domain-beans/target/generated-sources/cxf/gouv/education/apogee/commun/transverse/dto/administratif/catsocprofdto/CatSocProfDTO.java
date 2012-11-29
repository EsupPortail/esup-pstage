
package gouv.education.apogee.commun.transverse.dto.administratif.catsocprofdto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CatSocProfDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CatSocProfDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codeCategorie" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libPcs" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libWebPcs" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CatSocProfDTO", propOrder = {
    "codeCategorie",
    "libPcs",
    "libWebPcs"
})
public class CatSocProfDTO {

    @XmlElement(required = true, nillable = true)
    protected String codeCategorie;
    @XmlElement(required = true, nillable = true)
    protected String libPcs;
    @XmlElement(required = true, nillable = true)
    protected String libWebPcs;

    /**
     * Gets the value of the codeCategorie property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeCategorie() {
        return codeCategorie;
    }

    /**
     * Sets the value of the codeCategorie property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeCategorie(String value) {
        this.codeCategorie = value;
    }

    /**
     * Gets the value of the libPcs property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibPcs() {
        return libPcs;
    }

    /**
     * Sets the value of the libPcs property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibPcs(String value) {
        this.libPcs = value;
    }

    /**
     * Gets the value of the libWebPcs property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibWebPcs() {
        return libWebPcs;
    }

    /**
     * Sets the value of the libWebPcs property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibWebPcs(String value) {
        this.libWebPcs = value;
    }

}
