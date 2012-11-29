
package gouv.education.apogee.commun.transverse.dto.etudiant.calendrierexaetudto3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gouv.education.apogee.commun.transverse.dto.etudiant.etudiantdto4.EtudiantDTO4;


/**
 * <p>Java class for CalendrierExaEtuDTO3 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CalendrierExaEtuDTO3">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="annee" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="etudiant" type="{EtudiantDTO4.etudiant.dto.transverse.commun.apogee.education.gouv}EtudiantDTO4"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CalendrierExaEtuDTO3", propOrder = {
    "annee",
    "etudiant"
})
public class CalendrierExaEtuDTO3 {

    @XmlElement(required = true, nillable = true)
    protected String annee;
    @XmlElement(required = true, nillable = true)
    protected EtudiantDTO4 etudiant;

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
     * Gets the value of the etudiant property.
     * 
     * @return
     *     possible object is
     *     {@link EtudiantDTO4 }
     *     
     */
    public EtudiantDTO4 getEtudiant() {
        return etudiant;
    }

    /**
     * Sets the value of the etudiant property.
     * 
     * @param value
     *     allowed object is
     *     {@link EtudiantDTO4 }
     *     
     */
    public void setEtudiant(EtudiantDTO4 value) {
        this.etudiant = value;
    }

}
