
package pedagogiquemetier_28022011.servicesmetiers.commun.apogee.education.gouv;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gouv.education.apogee.commun.transverse.dto.pedagogique.contratpedagogiqueresultatelpeprdto4.ContratPedagogiqueResultatElpEprDTO4;


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
 *         &lt;element name="recupererContratPedagogiqueResultatElpEpr_v5Return" type="{ContratPedagogiqueResultatElpEprDTO4.pedagogique.dto.transverse.commun.apogee.education.gouv}ContratPedagogiqueResultatElpEprDTO4" maxOccurs="unbounded"/>
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
    "recupererContratPedagogiqueResultatElpEprV5Return"
})
@XmlRootElement(name = "recupererContratPedagogiqueResultatElpEpr_v5Response")
public class RecupererContratPedagogiqueResultatElpEprV5Response {

    @XmlElement(name = "recupererContratPedagogiqueResultatElpEpr_v5Return", required = true)
    protected List<ContratPedagogiqueResultatElpEprDTO4> recupererContratPedagogiqueResultatElpEprV5Return;

    /**
     * Gets the value of the recupererContratPedagogiqueResultatElpEprV5Return property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the recupererContratPedagogiqueResultatElpEprV5Return property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRecupererContratPedagogiqueResultatElpEprV5Return().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ContratPedagogiqueResultatElpEprDTO4 }
     * 
     * 
     */
    public List<ContratPedagogiqueResultatElpEprDTO4> getRecupererContratPedagogiqueResultatElpEprV5Return() {
        if (recupererContratPedagogiqueResultatElpEprV5Return == null) {
            recupererContratPedagogiqueResultatElpEprV5Return = new ArrayList<ContratPedagogiqueResultatElpEprDTO4>();
        }
        return this.recupererContratPedagogiqueResultatElpEprV5Return;
    }

}
