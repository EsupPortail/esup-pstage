
package pedagogiquemetier_28022011.servicesmetiers.commun.apogee.education.gouv;

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
 *         &lt;element name="_codEtu" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="_codAnu" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="_codEtp" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="_codVrsVet" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="_sourceRes" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="_etatDelib" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="_codSes" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="_typeRes" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "codEtu",
    "codAnu",
    "codEtp",
    "codVrsVet",
    "sourceRes",
    "etatDelib",
    "codSes",
    "typeRes"
})
@XmlRootElement(name = "recupererContratPedagogiqueResultatElpEpr_v5")
public class RecupererContratPedagogiqueResultatElpEprV5 {

    @XmlElement(name = "_codEtu", required = true)
    protected String codEtu;
    @XmlElement(name = "_codAnu", required = true)
    protected String codAnu;
    @XmlElement(name = "_codEtp", required = true)
    protected String codEtp;
    @XmlElement(name = "_codVrsVet", required = true)
    protected String codVrsVet;
    @XmlElement(name = "_sourceRes", required = true)
    protected String sourceRes;
    @XmlElement(name = "_etatDelib", required = true)
    protected String etatDelib;
    @XmlElement(name = "_codSes", required = true)
    protected String codSes;
    @XmlElement(name = "_typeRes", required = true)
    protected String typeRes;

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
     * Gets the value of the codEtp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodEtp() {
        return codEtp;
    }

    /**
     * Sets the value of the codEtp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodEtp(String value) {
        this.codEtp = value;
    }

    /**
     * Gets the value of the codVrsVet property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodVrsVet() {
        return codVrsVet;
    }

    /**
     * Sets the value of the codVrsVet property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodVrsVet(String value) {
        this.codVrsVet = value;
    }

    /**
     * Gets the value of the sourceRes property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceRes() {
        return sourceRes;
    }

    /**
     * Sets the value of the sourceRes property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceRes(String value) {
        this.sourceRes = value;
    }

    /**
     * Gets the value of the etatDelib property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEtatDelib() {
        return etatDelib;
    }

    /**
     * Sets the value of the etatDelib property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEtatDelib(String value) {
        this.etatDelib = value;
    }

    /**
     * Gets the value of the codSes property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodSes() {
        return codSes;
    }

    /**
     * Sets the value of the codSes property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodSes(String value) {
        this.codSes = value;
    }

    /**
     * Gets the value of the typeRes property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypeRes() {
        return typeRes;
    }

    /**
     * Sets the value of the typeRes property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypeRes(String value) {
        this.typeRes = value;
    }

}
