
package etudiantmetier_10112011.servicesmetiers.commun.apogee.education.gouv;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gouv.education.apogee.commun.transverse.dto.etudiant.identifiantsetudiantdto.IdentifiantsEtudiantDTO;


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
 *         &lt;element name="recupererIdentifiantsEtudiantReturn" type="{IdentifiantsEtudiantDTO.etudiant.dto.transverse.commun.apogee.education.gouv}IdentifiantsEtudiantDTO"/>
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
    "recupererIdentifiantsEtudiantReturn"
})
@XmlRootElement(name = "recupererIdentifiantsEtudiantResponse")
public class RecupererIdentifiantsEtudiantResponse {

    @XmlElement(required = true)
    protected IdentifiantsEtudiantDTO recupererIdentifiantsEtudiantReturn;

    /**
     * Gets the value of the recupererIdentifiantsEtudiantReturn property.
     * 
     * @return
     *     possible object is
     *     {@link IdentifiantsEtudiantDTO }
     *     
     */
    public IdentifiantsEtudiantDTO getRecupererIdentifiantsEtudiantReturn() {
        return recupererIdentifiantsEtudiantReturn;
    }

    /**
     * Sets the value of the recupererIdentifiantsEtudiantReturn property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentifiantsEtudiantDTO }
     *     
     */
    public void setRecupererIdentifiantsEtudiantReturn(IdentifiantsEtudiantDTO value) {
        this.recupererIdentifiantsEtudiantReturn = value;
    }

}
