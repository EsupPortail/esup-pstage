
package referentielmetier_18062010.servicesmetiers.commun.apogee.education.gouv;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gouv.education.apogee.commun.transverse.dto.pedagogique.formuleexamendto2.FormuleExamenDTO2;


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
 *         &lt;element name="recupererFormuleExamReturn" type="{FormuleExamenDTO2.pedagogique.dto.transverse.commun.apogee.education.gouv}FormuleExamenDTO2" maxOccurs="unbounded"/>
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
    "recupererFormuleExamReturn"
})
@XmlRootElement(name = "recupererFormuleExamResponse")
public class RecupererFormuleExamResponse {

    @XmlElement(required = true)
    protected List<FormuleExamenDTO2> recupererFormuleExamReturn;

    /**
     * Gets the value of the recupererFormuleExamReturn property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the recupererFormuleExamReturn property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRecupererFormuleExamReturn().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FormuleExamenDTO2 }
     * 
     * 
     */
    public List<FormuleExamenDTO2> getRecupererFormuleExamReturn() {
        if (recupererFormuleExamReturn == null) {
            recupererFormuleExamReturn = new ArrayList<FormuleExamenDTO2>();
        }
        return this.recupererFormuleExamReturn;
    }

}
