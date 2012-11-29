
package etudiantmetier_10112011.servicesmetiers.commun.apogee.education.gouv;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gouv.education.apogee.commun.transverse.dto.etudiant.calendrierexaetudto3.CalendrierExaEtuDTO3;


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
 *         &lt;element name="recupererCalendriersExamenEtudiant_v3Return" type="{CalendrierExaEtuDTO3.etudiant.dto.transverse.commun.apogee.education.gouv}CalendrierExaEtuDTO3"/>
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
    "recupererCalendriersExamenEtudiantV3Return"
})
@XmlRootElement(name = "recupererCalendriersExamenEtudiant_v3Response")
public class RecupererCalendriersExamenEtudiantV3Response {

    @XmlElement(name = "recupererCalendriersExamenEtudiant_v3Return", required = true)
    protected CalendrierExaEtuDTO3 recupererCalendriersExamenEtudiantV3Return;

    /**
     * Gets the value of the recupererCalendriersExamenEtudiantV3Return property.
     * 
     * @return
     *     possible object is
     *     {@link CalendrierExaEtuDTO3 }
     *     
     */
    public CalendrierExaEtuDTO3 getRecupererCalendriersExamenEtudiantV3Return() {
        return recupererCalendriersExamenEtudiantV3Return;
    }

    /**
     * Sets the value of the recupererCalendriersExamenEtudiantV3Return property.
     * 
     * @param value
     *     allowed object is
     *     {@link CalendrierExaEtuDTO3 }
     *     
     */
    public void setRecupererCalendriersExamenEtudiantV3Return(CalendrierExaEtuDTO3 value) {
        this.recupererCalendriersExamenEtudiantV3Return = value;
    }

}
