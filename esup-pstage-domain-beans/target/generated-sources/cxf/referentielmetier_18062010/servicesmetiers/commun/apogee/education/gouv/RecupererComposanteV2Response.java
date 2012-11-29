
package referentielmetier_18062010.servicesmetiers.commun.apogee.education.gouv;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gouv.education.apogee.commun.transverse.dto.pedagogique.composantedto3.ComposanteDTO3;


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
 *         &lt;element name="recupererComposante_v2Return" type="{ComposanteDTO3.pedagogique.dto.transverse.commun.apogee.education.gouv}ComposanteDTO3" maxOccurs="unbounded"/>
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
    "recupererComposanteV2Return"
})
@XmlRootElement(name = "recupererComposante_v2Response")
public class RecupererComposanteV2Response {

    @XmlElement(name = "recupererComposante_v2Return", required = true)
    protected List<ComposanteDTO3> recupererComposanteV2Return;

    /**
     * Gets the value of the recupererComposanteV2Return property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the recupererComposanteV2Return property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRecupererComposanteV2Return().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ComposanteDTO3 }
     * 
     * 
     */
    public List<ComposanteDTO3> getRecupererComposanteV2Return() {
        if (recupererComposanteV2Return == null) {
            recupererComposanteV2Return = new ArrayList<ComposanteDTO3>();
        }
        return this.recupererComposanteV2Return;
    }

}
