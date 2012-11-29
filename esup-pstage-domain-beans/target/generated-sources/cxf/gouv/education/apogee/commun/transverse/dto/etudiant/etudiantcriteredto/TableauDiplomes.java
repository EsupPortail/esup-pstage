
package gouv.education.apogee.commun.transverse.dto.etudiant.etudiantcriteredto;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import gouv.education.apogee.commun.transverse.dto.etudiant.etudiantcriterelistedto.EtudiantCritereListeDTO;


/**
 * <p>Java class for TableauDiplomes complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TableauDiplomes">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="item" type="{EtudiantCritereListeDTO.etudiant.dto.transverse.commun.apogee.education.gouv}EtudiantCritereListeDTO" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TableauDiplomes", propOrder = {
    "item"
})
public class TableauDiplomes {

    protected List<EtudiantCritereListeDTO> item;

    /**
     * Gets the value of the item property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the item property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EtudiantCritereListeDTO }
     * 
     * 
     */
    public List<EtudiantCritereListeDTO> getItem() {
        if (item == null) {
            item = new ArrayList<EtudiantCritereListeDTO>();
        }
        return this.item;
    }

}
