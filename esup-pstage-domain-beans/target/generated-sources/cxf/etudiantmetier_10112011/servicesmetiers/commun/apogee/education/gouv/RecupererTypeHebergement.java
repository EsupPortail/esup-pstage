
package etudiantmetier_10112011.servicesmetiers.commun.apogee.education.gouv;

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
 *         &lt;element name="_code" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="_temoinService" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="_temoinAD" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "code",
    "temoinService",
    "temoinAD"
})
@XmlRootElement(name = "recupererTypeHebergement")
public class RecupererTypeHebergement {

    @XmlElement(name = "_code", required = true)
    protected String code;
    @XmlElement(name = "_temoinService", required = true)
    protected String temoinService;
    @XmlElement(name = "_temoinAD", required = true)
    protected String temoinAD;

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * Gets the value of the temoinService property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemoinService() {
        return temoinService;
    }

    /**
     * Sets the value of the temoinService property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemoinService(String value) {
        this.temoinService = value;
    }

    /**
     * Gets the value of the temoinAD property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemoinAD() {
        return temoinAD;
    }

    /**
     * Sets the value of the temoinAD property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemoinAD(String value) {
        this.temoinAD = value;
    }

}
