
package referentielmetier_18062010.servicesmetiers.commun.apogee.education.gouv;

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
 *         &lt;element name="_codCycleSISE" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "codCycleSISE",
    "temoinEnService"
})
@XmlRootElement(name = "recupererCycleSISE")
public class RecupererCycleSISE {

    @XmlElement(name = "_codCycleSISE", required = true)
    protected String codCycleSISE;
    @XmlElement(name = "_temoinEnService", required = true)
    protected String temoinEnService;

    /**
     * Gets the value of the codCycleSISE property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodCycleSISE() {
        return codCycleSISE;
    }

    /**
     * Sets the value of the codCycleSISE property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodCycleSISE(String value) {
        this.codCycleSISE = value;
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
