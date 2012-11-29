
package gouv.education.apogee.commun.transverse.dto.geographie.departementdto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DepartementDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DepartementDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codeAca" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codeDept" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libAca" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libDept" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="temEnSveDept" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DepartementDTO", propOrder = {
    "codeAca",
    "codeDept",
    "libAca",
    "libDept",
    "temEnSveDept"
})
public class DepartementDTO {

    @XmlElement(required = true, nillable = true)
    protected String codeAca;
    @XmlElement(required = true, nillable = true)
    protected String codeDept;
    @XmlElement(required = true, nillable = true)
    protected String libAca;
    @XmlElement(required = true, nillable = true)
    protected String libDept;
    @XmlElement(required = true, nillable = true)
    protected String temEnSveDept;

    /**
     * Gets the value of the codeAca property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeAca() {
        return codeAca;
    }

    /**
     * Sets the value of the codeAca property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeAca(String value) {
        this.codeAca = value;
    }

    /**
     * Gets the value of the codeDept property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeDept() {
        return codeDept;
    }

    /**
     * Sets the value of the codeDept property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeDept(String value) {
        this.codeDept = value;
    }

    /**
     * Gets the value of the libAca property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibAca() {
        return libAca;
    }

    /**
     * Sets the value of the libAca property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibAca(String value) {
        this.libAca = value;
    }

    /**
     * Gets the value of the libDept property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibDept() {
        return libDept;
    }

    /**
     * Sets the value of the libDept property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibDept(String value) {
        this.libDept = value;
    }

    /**
     * Gets the value of the temEnSveDept property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemEnSveDept() {
        return temEnSveDept;
    }

    /**
     * Sets the value of the temEnSveDept property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemEnSveDept(String value) {
        this.temEnSveDept = value;
    }

}
