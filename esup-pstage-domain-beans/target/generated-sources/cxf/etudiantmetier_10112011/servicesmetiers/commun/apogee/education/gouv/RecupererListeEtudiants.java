
package etudiantmetier_10112011.servicesmetiers.commun.apogee.education.gouv;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gouv.education.apogee.commun.transverse.dto.etudiant.etudiantcriteredto.EtudiantCritereDTO;


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
 *         &lt;element name="_parametres" type="{EtudiantCritereDTO.etudiant.dto.transverse.commun.apogee.education.gouv}EtudiantCritereDTO"/>
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
    "parametres"
})
@XmlRootElement(name = "recupererListeEtudiants")
public class RecupererListeEtudiants {

    @XmlElement(name = "_parametres", required = true)
    protected EtudiantCritereDTO parametres;

    /**
     * Gets the value of the parametres property.
     * 
     * @return
     *     possible object is
     *     {@link EtudiantCritereDTO }
     *     
     */
    public EtudiantCritereDTO getParametres() {
        return parametres;
    }

    /**
     * Sets the value of the parametres property.
     * 
     * @param value
     *     allowed object is
     *     {@link EtudiantCritereDTO }
     *     
     */
    public void setParametres(EtudiantCritereDTO value) {
        this.parametres = value;
    }

}
