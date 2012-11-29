
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
 *         &lt;element name="_codePostal" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="_temoinEnServiceCom" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="_temoinEnServiceBD" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "codePostal",
    "temoinEnServiceCom",
    "temoinEnServiceBD"
})
@XmlRootElement(name = "recupererCommune")
public class RecupererCommune {

    @XmlElement(name = "_codePostal", required = true)
    protected String codePostal;
    @XmlElement(name = "_temoinEnServiceCom", required = true)
    protected String temoinEnServiceCom;
    @XmlElement(name = "_temoinEnServiceBD", required = true)
    protected String temoinEnServiceBD;

    /**
     * Gets the value of the codePostal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodePostal() {
        return codePostal;
    }

    /**
     * Sets the value of the codePostal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodePostal(String value) {
        this.codePostal = value;
    }

    /**
     * Gets the value of the temoinEnServiceCom property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemoinEnServiceCom() {
        return temoinEnServiceCom;
    }

    /**
     * Sets the value of the temoinEnServiceCom property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemoinEnServiceCom(String value) {
        this.temoinEnServiceCom = value;
    }

    /**
     * Gets the value of the temoinEnServiceBD property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemoinEnServiceBD() {
        return temoinEnServiceBD;
    }

    /**
     * Sets the value of the temoinEnServiceBD property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemoinEnServiceBD(String value) {
        this.temoinEnServiceBD = value;
    }

}
