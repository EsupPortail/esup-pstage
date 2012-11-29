
package gouv.education.apogee.commun.transverse.dto.etudiant.calendrierexaetudto2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gouv.education.apogee.commun.transverse.dto.etudiant.etudiantdto3.EtudiantDTO3;


/**
 * <p>Java class for CalendrierExaEtuDTO2 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CalendrierExaEtuDTO2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="annee" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="etudiant" type="{EtudiantDTO3.etudiant.dto.transverse.commun.apogee.education.gouv}EtudiantDTO3"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CalendrierExaEtuDTO2", propOrder = {
    "annee",
    "etudiant"
})
public class CalendrierExaEtuDTO2 {

    @XmlElement(required = true, nillable = true)
    protected String annee;
    @XmlElement(required = true, nillable = true)
    protected EtudiantDTO3 etudiant;

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
     *     {@link EtudiantDTO3 }
     *     
     */
    public EtudiantDTO3 getEtudiant() {
        return etudiant;
    }

    /**
     * Sets the value of the etudiant property.
     * 
     * @param value
     *     allowed object is
     *     {@link EtudiantDTO3 }
     *     
     */
    public void setEtudiant(EtudiantDTO3 value) {
        this.etudiant = value;
    }

}
