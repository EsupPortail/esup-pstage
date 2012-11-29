
package gouv.education.apogee.commun.transverse.dto.pedagogique.elementpedagogidto5;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gouv.education.apogee.commun.transverse.dto.pedagogique.natureelpdto.NatureElpDTO;


/**
 * <p>Java class for ElementPedagogiDTO5 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ElementPedagogiDTO5">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codElp" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libElp" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="natureElp" type="{NatureElpDTO.pedagogique.dto.transverse.commun.apogee.education.gouv}NatureElpDTO"/>
 *         &lt;element name="nbrCrdElp" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="numPreElp" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="temCtlValCadElp" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="temElpTypeStage" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ElementPedagogiDTO5", propOrder = {
    "codElp",
    "libElp",
    "natureElp",
    "nbrCrdElp",
    "numPreElp",
    "temCtlValCadElp",
    "temElpTypeStage"
})
public class ElementPedagogiDTO5 {

    @XmlElement(required = true, nillable = true)
    protected String codElp;
    @XmlElement(required = true, nillable = true)
    protected String libElp;
    @XmlElement(required = true, nillable = true)
    protected NatureElpDTO natureElp;
    @XmlElement(required = true, nillable = true)
    protected BigDecimal nbrCrdElp;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer numPreElp;
    @XmlElement(required = true, nillable = true)
    protected String temCtlValCadElp;
    @XmlElement(required = true, nillable = true)
    protected String temElpTypeStage;

    /**
     * Gets the value of the codElp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodElp() {
        return codElp;
    }

    /**
     * Sets the value of the codElp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodElp(String value) {
        this.codElp = value;
    }

    /**
     * Gets the value of the libElp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibElp() {
        return libElp;
    }

    /**
     * Sets the value of the libElp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibElp(String value) {
        this.libElp = value;
    }

    /**
     * Gets the value of the natureElp property.
     * 
     * @return
     *     possible object is
     *     {@link NatureElpDTO }
     *     
     */
    public NatureElpDTO getNatureElp() {
        return natureElp;
    }

    /**
     * Sets the value of the natureElp property.
     * 
     * @param value
     *     allowed object is
     *     {@link NatureElpDTO }
     *     
     */
    public void setNatureElp(NatureElpDTO value) {
        this.natureElp = value;
    }

    /**
     * Gets the value of the nbrCrdElp property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getNbrCrdElp() {
        return nbrCrdElp;
    }

    /**
     * Sets the value of the nbrCrdElp property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setNbrCrdElp(BigDecimal value) {
        this.nbrCrdElp = value;
    }

    /**
     * Gets the value of the numPreElp property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumPreElp() {
        return numPreElp;
    }

    /**
     * Sets the value of the numPreElp property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumPreElp(Integer value) {
        this.numPreElp = value;
    }

    /**
     * Gets the value of the temCtlValCadElp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemCtlValCadElp() {
        return temCtlValCadElp;
    }

    /**
     * Sets the value of the temCtlValCadElp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemCtlValCadElp(String value) {
        this.temCtlValCadElp = value;
    }

    /**
     * Gets the value of the temElpTypeStage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemElpTypeStage() {
        return temElpTypeStage;
    }

    /**
     * Sets the value of the temElpTypeStage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemElpTypeStage(String value) {
        this.temElpTypeStage = value;
    }

}
