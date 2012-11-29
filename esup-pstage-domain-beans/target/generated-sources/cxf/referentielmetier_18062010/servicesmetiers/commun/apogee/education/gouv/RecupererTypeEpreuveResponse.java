
package referentielmetier_18062010.servicesmetiers.commun.apogee.education.gouv;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gouv.education.apogee.commun.transverse.dto.pedagogique.typepreuvedto2.TypEpreuveDTO2;


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
 *         &lt;element name="recupererTypeEpreuveReturn" type="{TypEpreuveDTO2.pedagogique.dto.transverse.commun.apogee.education.gouv}TypEpreuveDTO2" maxOccurs="unbounded"/>
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
    "recupererTypeEpreuveReturn"
})
@XmlRootElement(name = "recupererTypeEpreuveResponse")
public class RecupererTypeEpreuveResponse {

    @XmlElement(required = true)
    protected List<TypEpreuveDTO2> recupererTypeEpreuveReturn;

    /**
     * Gets the value of the recupererTypeEpreuveReturn property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the recupererTypeEpreuveReturn property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRecupererTypeEpreuveReturn().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TypEpreuveDTO2 }
     * 
     * 
     */
    public List<TypEpreuveDTO2> getRecupererTypeEpreuveReturn() {
        if (recupererTypeEpreuveReturn == null) {
            recupererTypeEpreuveReturn = new ArrayList<TypEpreuveDTO2>();
        }
        return this.recupererTypeEpreuveReturn;
    }

}
