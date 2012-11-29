
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
 *         &lt;element name="_codCmp" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="_sens" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "codCmp",
    "sens"
})
@XmlRootElement(name = "recupererComposante_v2")
public class RecupererComposanteV2 {

    @XmlElement(name = "_codCmp", required = true)
    protected String codCmp;
    @XmlElement(name = "_sens", required = true)
    protected String sens;

    /**
     * Gets the value of the codCmp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodCmp() {
        return codCmp;
    }

    /**
     * Sets the value of the codCmp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodCmp(String value) {
        this.codCmp = value;
    }

    /**
     * Gets the value of the sens property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSens() {
        return sens;
    }

    /**
     * Sets the value of the sens property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSens(String value) {
        this.sens = value;
    }

}
