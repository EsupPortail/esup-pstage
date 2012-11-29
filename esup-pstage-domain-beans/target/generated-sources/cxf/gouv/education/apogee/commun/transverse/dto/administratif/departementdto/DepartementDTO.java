
package gouv.education.apogee.commun.transverse.dto.administratif.departementdto;

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
 *         &lt;element name="codeDept" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libDept" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "codeDept",
    "libDept"
})
public class DepartementDTO {

    @XmlElement(required = true, nillable = true)
    protected String codeDept;
    @XmlElement(required = true, nillable = true)
    protected String libDept;

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

}
