
package administratifmetier_17062009.servicesmetiers.commun.apogee.education.gouv;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gouv.education.apogee.commun.transverse.dto.administratif.insadmanudto2.InsAdmAnuDTO2;


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
 *         &lt;element name="recupererIAAnnuellesReturn_v2" type="{InsAdmAnuDTO2.administratif.dto.transverse.commun.apogee.education.gouv}InsAdmAnuDTO2" maxOccurs="unbounded"/>
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
    "recupererIAAnnuellesReturnV2"
})
@XmlRootElement(name = "recupererIAAnnuelles_v2Response")
public class RecupererIAAnnuellesV2Response {

    @XmlElement(name = "recupererIAAnnuellesReturn_v2", required = true)
    protected List<InsAdmAnuDTO2> recupererIAAnnuellesReturnV2;

    /**
     * Gets the value of the recupererIAAnnuellesReturnV2 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the recupererIAAnnuellesReturnV2 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRecupererIAAnnuellesReturnV2().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InsAdmAnuDTO2 }
     * 
     * 
     */
    public List<InsAdmAnuDTO2> getRecupererIAAnnuellesReturnV2() {
        if (recupererIAAnnuellesReturnV2 == null) {
            recupererIAAnnuellesReturnV2 = new ArrayList<InsAdmAnuDTO2>();
        }
        return this.recupererIAAnnuellesReturnV2;
    }

}
