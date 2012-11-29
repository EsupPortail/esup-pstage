
package geographiemetier_06062007.servicesmetiers.commun.apogee.education.gouv;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="_codeDept" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="_temoinEnService" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "codeDept",
    "temoinEnService"
})
@XmlRootElement(name = "recupererDepartement")
public class RecupererDepartement {

    @XmlElement(name = "_codeDept", required = true)
    protected String codeDept;
    @XmlElement(name = "_temoinEnService", required = true)
    protected String temoinEnService;

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
     * Gets the value of the temoinEnService property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemoinEnService() {
        return temoinEnService;
    }

    /**
     * Sets the value of the temoinEnService property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemoinEnService(String value) {
        this.temoinEnService = value;
    }

}
