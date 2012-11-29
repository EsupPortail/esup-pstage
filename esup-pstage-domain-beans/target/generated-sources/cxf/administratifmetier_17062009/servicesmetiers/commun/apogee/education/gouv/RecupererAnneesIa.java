
package administratifmetier_17062009.servicesmetiers.commun.apogee.education.gouv;

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
 *         &lt;element name="_etatInscriptionIA" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "etatInscriptionIA"
})
@XmlRootElement(name = "recupererAnneesIa")
public class RecupererAnneesIa {

    @XmlElement(name = "_codEtu", required = true)
    protected String codEtu;
    @XmlElement(name = "_etatInscriptionIA", required = true)
    protected String etatInscriptionIA;

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
     * Gets the value of the etatInscriptionIA property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEtatInscriptionIA() {
        return etatInscriptionIA;
    }

    /**
     * Sets the value of the etatInscriptionIA property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEtatInscriptionIA(String value) {
        this.etatInscriptionIA = value;
    }

}
