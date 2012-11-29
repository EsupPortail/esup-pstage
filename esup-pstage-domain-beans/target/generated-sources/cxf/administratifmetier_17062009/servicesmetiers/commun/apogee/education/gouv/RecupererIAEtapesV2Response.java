
package administratifmetier_17062009.servicesmetiers.commun.apogee.education.gouv;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gouv.education.apogee.commun.transverse.dto.administratif.insadmetpdto2.InsAdmEtpDTO2;


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
 *         &lt;element name="recupererIAEtapes_v2Return" type="{InsAdmEtpDTO2.administratif.dto.transverse.commun.apogee.education.gouv}InsAdmEtpDTO2" maxOccurs="unbounded"/>
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
    "recupererIAEtapesV2Return"
})
@XmlRootElement(name = "recupererIAEtapes_v2Response")
public class RecupererIAEtapesV2Response {

    @XmlElement(name = "recupererIAEtapes_v2Return", required = true)
    protected List<InsAdmEtpDTO2> recupererIAEtapesV2Return;

    /**
     * Gets the value of the recupererIAEtapesV2Return property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the recupererIAEtapesV2Return property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRecupererIAEtapesV2Return().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InsAdmEtpDTO2 }
     * 
     * 
     */
    public List<InsAdmEtpDTO2> getRecupererIAEtapesV2Return() {
        if (recupererIAEtapesV2Return == null) {
            recupererIAEtapesV2Return = new ArrayList<InsAdmEtpDTO2>();
        }
        return this.recupererIAEtapesV2Return;
    }

}
