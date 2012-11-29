
package referentielmetier_18062010.servicesmetiers.commun.apogee.education.gouv;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gouv.education.apogee.commun.transverse.dto.pedagogique.regimeinscdto.RegimeInscDTO;


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
 *         &lt;element name="recupererRegimeInscriptionReturn" type="{RegimeInscDTO.pedagogique.dto.transverse.commun.apogee.education.gouv}RegimeInscDTO" maxOccurs="unbounded"/>
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
    "recupererRegimeInscriptionReturn"
})
@XmlRootElement(name = "recupererRegimeInscriptionResponse")
public class RecupererRegimeInscriptionResponse {

    @XmlElement(required = true)
    protected List<RegimeInscDTO> recupererRegimeInscriptionReturn;

    /**
     * Gets the value of the recupererRegimeInscriptionReturn property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the recupererRegimeInscriptionReturn property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRecupererRegimeInscriptionReturn().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RegimeInscDTO }
     * 
     * 
     */
    public List<RegimeInscDTO> getRecupererRegimeInscriptionReturn() {
        if (recupererRegimeInscriptionReturn == null) {
            recupererRegimeInscriptionReturn = new ArrayList<RegimeInscDTO>();
        }
        return this.recupererRegimeInscriptionReturn;
    }

}
