
package geographiemetier_06062007.servicesmetiers.commun.apogee.education.gouv;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gouv.education.apogee.commun.transverse.dto.geographie.departementdto.DepartementDTO;


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
 *         &lt;element name="recupererDepartementReturn" type="{DepartementDTO.geographie.dto.transverse.commun.apogee.education.gouv}DepartementDTO" maxOccurs="unbounded"/>
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
    "recupererDepartementReturn"
})
@XmlRootElement(name = "recupererDepartementResponse")
public class RecupererDepartementResponse {

    @XmlElement(required = true)
    protected List<DepartementDTO> recupererDepartementReturn;

    /**
     * Gets the value of the recupererDepartementReturn property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the recupererDepartementReturn property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRecupererDepartementReturn().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DepartementDTO }
     * 
     * 
     */
    public List<DepartementDTO> getRecupererDepartementReturn() {
        if (recupererDepartementReturn == null) {
            recupererDepartementReturn = new ArrayList<DepartementDTO>();
        }
        return this.recupererDepartementReturn;
    }

}
