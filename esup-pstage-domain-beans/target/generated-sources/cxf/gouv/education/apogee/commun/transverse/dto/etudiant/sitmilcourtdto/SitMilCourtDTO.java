
package gouv.education.apogee.commun.transverse.dto.etudiant.sitmilcourtdto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SitMilCourtDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SitMilCourtDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codeMil" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libMil" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libSim" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SitMilCourtDTO", propOrder = {
    "codeMil",
    "libMil",
    "libSim"
})
public class SitMilCourtDTO {

    @XmlElement(required = true, nillable = true)
    protected String codeMil;
    @XmlElement(required = true, nillable = true)
    protected String libMil;
    @XmlElement(required = true, nillable = true)
    protected String libSim;

    /**
     * Gets the value of the codeMil property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeMil() {
        return codeMil;
    }

    /**
     * Sets the value of the codeMil property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeMil(String value) {
        this.codeMil = value;
    }

    /**
     * Gets the value of the libMil property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibMil() {
        return libMil;
    }

    /**
     * Sets the value of the libMil property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibMil(String value) {
        this.libMil = value;
    }

    /**
     * Gets the value of the libSim property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibSim() {
        return libSim;
    }

    /**
     * Sets the value of the libSim property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibSim(String value) {
        this.libSim = value;
    }

}
