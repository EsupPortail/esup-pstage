
package etudiantmetier_10112011.servicesmetiers.commun.apogee.education.gouv;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gouv.education.apogee.commun.transverse.dto.etudiant.coordonneesdto2.CoordonneesDTO2;


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
 *         &lt;element name="recupererAdressesEtudiant_v2Return" type="{CoordonneesDTO2.etudiant.dto.transverse.commun.apogee.education.gouv}CoordonneesDTO2"/>
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
    "recupererAdressesEtudiantV2Return"
})
@XmlRootElement(name = "recupererAdressesEtudiant_v2Response")
public class RecupererAdressesEtudiantV2Response {

    @XmlElement(name = "recupererAdressesEtudiant_v2Return", required = true)
    protected CoordonneesDTO2 recupererAdressesEtudiantV2Return;

    /**
     * Gets the value of the recupererAdressesEtudiantV2Return property.
     * 
     * @return
     *     possible object is
     *     {@link CoordonneesDTO2 }
     *     
     */
    public CoordonneesDTO2 getRecupererAdressesEtudiantV2Return() {
        return recupererAdressesEtudiantV2Return;
    }

    /**
     * Sets the value of the recupererAdressesEtudiantV2Return property.
     * 
     * @param value
     *     allowed object is
     *     {@link CoordonneesDTO2 }
     *     
     */
    public void setRecupererAdressesEtudiantV2Return(CoordonneesDTO2 value) {
        this.recupererAdressesEtudiantV2Return = value;
    }

}
