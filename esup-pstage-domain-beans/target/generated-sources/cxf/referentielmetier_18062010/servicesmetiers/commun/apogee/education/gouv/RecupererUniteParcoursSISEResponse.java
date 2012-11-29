
package referentielmetier_18062010.servicesmetiers.commun.apogee.education.gouv;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gouv.education.apogee.commun.transverse.dto.pedagogique.etapesisdto.EtapeSisDTO;


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
 *         &lt;element name="recupererUniteParcoursSISEReturn" type="{EtapeSisDTO.pedagogique.dto.transverse.commun.apogee.education.gouv}EtapeSisDTO" maxOccurs="unbounded"/>
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
    "recupererUniteParcoursSISEReturn"
})
@XmlRootElement(name = "recupererUniteParcoursSISEResponse")
public class RecupererUniteParcoursSISEResponse {

    @XmlElement(required = true)
    protected List<EtapeSisDTO> recupererUniteParcoursSISEReturn;

    /**
     * Gets the value of the recupererUniteParcoursSISEReturn property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the recupererUniteParcoursSISEReturn property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRecupererUniteParcoursSISEReturn().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EtapeSisDTO }
     * 
     * 
     */
    public List<EtapeSisDTO> getRecupererUniteParcoursSISEReturn() {
        if (recupererUniteParcoursSISEReturn == null) {
            recupererUniteParcoursSISEReturn = new ArrayList<EtapeSisDTO>();
        }
        return this.recupererUniteParcoursSISEReturn;
    }

}
