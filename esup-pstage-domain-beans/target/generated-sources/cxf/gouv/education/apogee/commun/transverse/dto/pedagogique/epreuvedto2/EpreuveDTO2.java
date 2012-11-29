
package gouv.education.apogee.commun.transverse.dto.pedagogique.epreuvedto2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gouv.education.apogee.commun.transverse.dto.pedagogique.natureeprdto.NatureEprDTO;
import gouv.education.apogee.commun.transverse.dto.pedagogique.typepreuvedto.TypEpreuveDTO;


/**
 * <p>Java class for EpreuveDTO2 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EpreuveDTO2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codEpr" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libEpr" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="natureEpr" type="{NatureEprDTO.pedagogique.dto.transverse.commun.apogee.education.gouv}NatureEprDTO"/>
 *         &lt;element name="temCtlValCadEpr" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="typEpreuve" type="{TypEpreuveDTO.pedagogique.dto.transverse.commun.apogee.education.gouv}TypEpreuveDTO"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EpreuveDTO2", propOrder = {
    "codEpr",
    "libEpr",
    "natureEpr",
    "temCtlValCadEpr",
    "typEpreuve"
})
public class EpreuveDTO2 {

    @XmlElement(required = true, nillable = true)
    protected String codEpr;
    @XmlElement(required = true, nillable = true)
    protected String libEpr;
    @XmlElement(required = true, nillable = true)
    protected NatureEprDTO natureEpr;
    @XmlElement(required = true, nillable = true)
    protected String temCtlValCadEpr;
    @XmlElement(required = true, nillable = true)
    protected TypEpreuveDTO typEpreuve;

    /**
     * Gets the value of the codEpr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodEpr() {
        return codEpr;
    }

    /**
     * Sets the value of the codEpr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodEpr(String value) {
        this.codEpr = value;
    }

    /**
     * Gets the value of the libEpr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibEpr() {
        return libEpr;
    }

    /**
     * Sets the value of the libEpr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibEpr(String value) {
        this.libEpr = value;
    }

    /**
     * Gets the value of the natureEpr property.
     * 
     * @return
     *     possible object is
     *     {@link NatureEprDTO }
     *     
     */
    public NatureEprDTO getNatureEpr() {
        return natureEpr;
    }

    /**
     * Sets the value of the natureEpr property.
     * 
     * @param value
     *     allowed object is
     *     {@link NatureEprDTO }
     *     
     */
    public void setNatureEpr(NatureEprDTO value) {
        this.natureEpr = value;
    }

    /**
     * Gets the value of the temCtlValCadEpr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemCtlValCadEpr() {
        return temCtlValCadEpr;
    }

    /**
     * Sets the value of the temCtlValCadEpr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemCtlValCadEpr(String value) {
        this.temCtlValCadEpr = value;
    }

    /**
     * Gets the value of the typEpreuve property.
     * 
     * @return
     *     possible object is
     *     {@link TypEpreuveDTO }
     *     
     */
    public TypEpreuveDTO getTypEpreuve() {
        return typEpreuve;
    }

    /**
     * Sets the value of the typEpreuve property.
     * 
     * @param value
     *     allowed object is
     *     {@link TypEpreuveDTO }
     *     
     */
    public void setTypEpreuve(TypEpreuveDTO value) {
        this.typEpreuve = value;
    }

}
