
package referentielmetier_18062010.servicesmetiers.commun.apogee.education.gouv;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gouv.education.apogee.commun.transverse.dto.pedagogique.composantedto2.ComposanteDTO2;


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
 *         &lt;element name="recupererComposanteReturn" type="{ComposanteDTO2.pedagogique.dto.transverse.commun.apogee.education.gouv}ComposanteDTO2" maxOccurs="unbounded"/>
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
    "recupererComposanteReturn"
})
@XmlRootElement(name = "recupererComposanteResponse")
public class RecupererComposanteResponse {

    @XmlElement(required = true)
    protected List<ComposanteDTO2> recupererComposanteReturn;

    /**
     * Gets the value of the recupererComposanteReturn property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the recupererComposanteReturn property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRecupererComposanteReturn().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ComposanteDTO2 }
     * 
     * 
     */
    public List<ComposanteDTO2> getRecupererComposanteReturn() {
        if (recupererComposanteReturn == null) {
            recupererComposanteReturn = new ArrayList<ComposanteDTO2>();
        }
        return this.recupererComposanteReturn;
    }

}
