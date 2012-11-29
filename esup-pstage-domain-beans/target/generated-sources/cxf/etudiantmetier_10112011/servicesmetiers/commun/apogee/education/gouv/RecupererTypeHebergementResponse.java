
package etudiantmetier_10112011.servicesmetiers.commun.apogee.education.gouv;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gouv.education.apogee.commun.transverse.dto.etudiant.typehebergementdto.TypeHebergementDTO;


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
 *         &lt;element name="recupererTypeHebergementReturn" type="{TypeHebergementDTO.etudiant.dto.transverse.commun.apogee.education.gouv}TypeHebergementDTO" maxOccurs="unbounded"/>
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
    "recupererTypeHebergementReturn"
})
@XmlRootElement(name = "recupererTypeHebergementResponse")
public class RecupererTypeHebergementResponse {

    @XmlElement(required = true)
    protected List<TypeHebergementDTO> recupererTypeHebergementReturn;

    /**
     * Gets the value of the recupererTypeHebergementReturn property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the recupererTypeHebergementReturn property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRecupererTypeHebergementReturn().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TypeHebergementDTO }
     * 
     * 
     */
    public List<TypeHebergementDTO> getRecupererTypeHebergementReturn() {
        if (recupererTypeHebergementReturn == null) {
            recupererTypeHebergementReturn = new ArrayList<TypeHebergementDTO>();
        }
        return this.recupererTypeHebergementReturn;
    }

}
