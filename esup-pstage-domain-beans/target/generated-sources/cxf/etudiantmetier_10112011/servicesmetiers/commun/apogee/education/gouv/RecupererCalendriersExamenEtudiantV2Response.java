
package etudiantmetier_10112011.servicesmetiers.commun.apogee.education.gouv;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gouv.education.apogee.commun.transverse.dto.etudiant.calendrierexaetudto2.CalendrierExaEtuDTO2;


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
 *         &lt;element name="recupererCalendriersExamenEtudiant_v2Return" type="{CalendrierExaEtuDTO2.etudiant.dto.transverse.commun.apogee.education.gouv}CalendrierExaEtuDTO2"/>
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
    "recupererCalendriersExamenEtudiantV2Return"
})
@XmlRootElement(name = "recupererCalendriersExamenEtudiant_v2Response")
public class RecupererCalendriersExamenEtudiantV2Response {

    @XmlElement(name = "recupererCalendriersExamenEtudiant_v2Return", required = true)
    protected CalendrierExaEtuDTO2 recupererCalendriersExamenEtudiantV2Return;

    /**
     * Gets the value of the recupererCalendriersExamenEtudiantV2Return property.
     * 
     * @return
     *     possible object is
     *     {@link CalendrierExaEtuDTO2 }
     *     
     */
    public CalendrierExaEtuDTO2 getRecupererCalendriersExamenEtudiantV2Return() {
        return recupererCalendriersExamenEtudiantV2Return;
    }

    /**
     * Sets the value of the recupererCalendriersExamenEtudiantV2Return property.
     * 
     * @param value
     *     allowed object is
     *     {@link CalendrierExaEtuDTO2 }
     *     
     */
    public void setRecupererCalendriersExamenEtudiantV2Return(CalendrierExaEtuDTO2 value) {
        this.recupererCalendriersExamenEtudiantV2Return = value;
    }

}
