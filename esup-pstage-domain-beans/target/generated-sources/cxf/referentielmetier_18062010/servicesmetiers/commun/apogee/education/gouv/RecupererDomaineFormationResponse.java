
package referentielmetier_18062010.servicesmetiers.commun.apogee.education.gouv;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gouv.education.apogee.commun.transverse.dto.pedagogique.domaineformationdiplomedto.DomaineFormationDiplomeDTO;


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
 *         &lt;element name="recupererDomaineFormationReturn" type="{DomaineFormationDiplomeDTO.pedagogique.dto.transverse.commun.apogee.education.gouv}DomaineFormationDiplomeDTO" maxOccurs="unbounded"/>
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
    "recupererDomaineFormationReturn"
})
@XmlRootElement(name = "recupererDomaineFormationResponse")
public class RecupererDomaineFormationResponse {

    @XmlElement(required = true)
    protected List<DomaineFormationDiplomeDTO> recupererDomaineFormationReturn;

    /**
     * Gets the value of the recupererDomaineFormationReturn property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the recupererDomaineFormationReturn property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRecupererDomaineFormationReturn().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DomaineFormationDiplomeDTO }
     * 
     * 
     */
    public List<DomaineFormationDiplomeDTO> getRecupererDomaineFormationReturn() {
        if (recupererDomaineFormationReturn == null) {
            recupererDomaineFormationReturn = new ArrayList<DomaineFormationDiplomeDTO>();
        }
        return this.recupererDomaineFormationReturn;
    }

}
