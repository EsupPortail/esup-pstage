
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
 *         &lt;element name="_codCtreInsPedag" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "codCtreInsPedag",
    "temoinEnService"
})
@XmlRootElement(name = "recupererCentreInscriptionPedagogique")
public class RecupererCentreInscriptionPedagogique {

    @XmlElement(name = "_codCtreInsPedag", required = true)
    protected String codCtreInsPedag;
    @XmlElement(name = "_temoinEnService", required = true)
    protected String temoinEnService;

    /**
     * Gets the value of the codCtreInsPedag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodCtreInsPedag() {
        return codCtreInsPedag;
    }

    /**
     * Sets the value of the codCtreInsPedag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodCtreInsPedag(String value) {
        this.codCtreInsPedag = value;
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
