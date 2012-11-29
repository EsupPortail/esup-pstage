
package referentielmetier_18062010.servicesmetiers.commun.apogee.education.gouv;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gouv.education.apogee.commun.transverse.dto.pedagogique.centregestiondto2.CentreGestionDTO2;


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
 *         &lt;element name="recupererCGEReturn" type="{CentreGestionDTO2.pedagogique.dto.transverse.commun.apogee.education.gouv}CentreGestionDTO2" maxOccurs="unbounded"/>
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
    "recupererCGEReturn"
})
@XmlRootElement(name = "recupererCGEResponse")
public class RecupererCGEResponse {

    @XmlElement(required = true)
    protected List<CentreGestionDTO2> recupererCGEReturn;

    /**
     * Gets the value of the recupererCGEReturn property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the recupererCGEReturn property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRecupererCGEReturn().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CentreGestionDTO2 }
     * 
     * 
     */
    public List<CentreGestionDTO2> getRecupererCGEReturn() {
        if (recupererCGEReturn == null) {
            recupererCGEReturn = new ArrayList<CentreGestionDTO2>();
        }
        return this.recupererCGEReturn;
    }

}
