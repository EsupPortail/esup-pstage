
package etudiantmetier_10112011.servicesmetiers.commun.apogee.education.gouv;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gouv.education.apogee.commun.transverse.dto.etudiant.coordonneesdto.CoordonneesDTO;


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
 *         &lt;element name="recupererAdressesEtudiantReturn" type="{CoordonneesDTO.etudiant.dto.transverse.commun.apogee.education.gouv}CoordonneesDTO"/>
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
    "recupererAdressesEtudiantReturn"
})
@XmlRootElement(name = "recupererAdressesEtudiantResponse")
public class RecupererAdressesEtudiantResponse {

    @XmlElement(required = true)
    protected CoordonneesDTO recupererAdressesEtudiantReturn;

    /**
     * Gets the value of the recupererAdressesEtudiantReturn property.
     * 
     * @return
     *     possible object is
     *     {@link CoordonneesDTO }
     *     
     */
    public CoordonneesDTO getRecupererAdressesEtudiantReturn() {
        return recupererAdressesEtudiantReturn;
    }

    /**
     * Sets the value of the recupererAdressesEtudiantReturn property.
     * 
     * @param value
     *     allowed object is
     *     {@link CoordonneesDTO }
     *     
     */
    public void setRecupererAdressesEtudiantReturn(CoordonneesDTO value) {
        this.recupererAdressesEtudiantReturn = value;
    }

}
