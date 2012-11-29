
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
 *         &lt;element name="_codEtu" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="_annee" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="_recupAnnuaire" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "annee",
    "recupAnnuaire"
})
@XmlRootElement(name = "recupererAdressesEtudiant_v2")
public class RecupererAdressesEtudiantV2 {

    @XmlElement(name = "_codEtu", required = true)
    protected String codEtu;
    @XmlElement(name = "_annee", required = true)
    protected String annee;
    @XmlElement(name = "_recupAnnuaire", required = true)
    protected String recupAnnuaire;

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
     * Gets the value of the annee property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnnee() {
        return annee;
    }

    /**
     * Sets the value of the annee property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnnee(String value) {
        this.annee = value;
    }

    /**
     * Gets the value of the recupAnnuaire property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecupAnnuaire() {
        return recupAnnuaire;
    }

    /**
     * Sets the value of the recupAnnuaire property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecupAnnuaire(String value) {
        this.recupAnnuaire = value;
    }

}
