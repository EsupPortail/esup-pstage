
package referentielmetier_18062010.servicesmetiers.commun.apogee.education.gouv;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gouv.education.apogee.commun.transverse.dto.pedagogique.natureeprdto2.NatureEprDTO2;


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
 *         &lt;element name="recupererNatureEpreuveReturn" type="{NatureEprDTO2.pedagogique.dto.transverse.commun.apogee.education.gouv}NatureEprDTO2" maxOccurs="unbounded"/>
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
    "recupererNatureEpreuveReturn"
})
@XmlRootElement(name = "recupererNatureEpreuveResponse")
public class RecupererNatureEpreuveResponse {

    @XmlElement(required = true)
    protected List<NatureEprDTO2> recupererNatureEpreuveReturn;

    /**
     * Gets the value of the recupererNatureEpreuveReturn property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the recupererNatureEpreuveReturn property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRecupererNatureEpreuveReturn().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NatureEprDTO2 }
     * 
     * 
     */
    public List<NatureEprDTO2> getRecupererNatureEpreuveReturn() {
        if (recupererNatureEpreuveReturn == null) {
            recupererNatureEpreuveReturn = new ArrayList<NatureEprDTO2>();
        }
        return this.recupererNatureEpreuveReturn;
    }

}
