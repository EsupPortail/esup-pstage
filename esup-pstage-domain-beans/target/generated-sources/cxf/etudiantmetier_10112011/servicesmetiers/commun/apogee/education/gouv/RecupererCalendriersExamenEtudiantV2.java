
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
 *         &lt;element name="_codAnu" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="_codEtu" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="_codPxa" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="_codCln" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "codAnu",
    "codEtu",
    "codPxa",
    "codCln"
})
@XmlRootElement(name = "recupererCalendriersExamenEtudiant_v2")
public class RecupererCalendriersExamenEtudiantV2 {

    @XmlElement(name = "_codAnu", required = true)
    protected String codAnu;
    @XmlElement(name = "_codEtu", required = true)
    protected String codEtu;
    @XmlElement(name = "_codPxa", required = true)
    protected String codPxa;
    @XmlElement(name = "_codCln", required = true)
    protected String codCln;

    /**
     * Gets the value of the codAnu property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodAnu() {
        return codAnu;
    }

    /**
     * Sets the value of the codAnu property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodAnu(String value) {
        this.codAnu = value;
    }

    /**
     * Gets the value of the codEtu property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodEtu() {
        return codEtu;
    }

    /**
     * Sets the value of the codEtu property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodEtu(String value) {
        this.codEtu = value;
    }

    /**
     * Gets the value of the codPxa property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodPxa() {
        return codPxa;
    }

    /**
     * Sets the value of the codPxa property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodPxa(String value) {
        this.codPxa = value;
    }

    /**
     * Gets the value of the codCln property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodCln() {
        return codCln;
    }

    /**
     * Sets the value of the codCln property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodCln(String value) {
        this.codCln = value;
    }

}
