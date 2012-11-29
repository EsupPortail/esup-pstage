
package gouv.education.apogee.commun.transverse.dto.pedagogique.periodeexadto2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import gouv.education.apogee.commun.transverse.dto.pedagogique.calendrierexamendto.CalendrierExamenDTO;


/**
 * <p>Java class for TableauCalendrierExamenDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TableauCalendrierExamenDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="item" type="{CalendrierExamenDTO.pedagogique.dto.transverse.commun.apogee.education.gouv}CalendrierExamenDTO" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TableauCalendrierExamenDTO", propOrder = {
    "item"
})
public class TableauCalendrierExamenDTO {

    protected List<CalendrierExamenDTO> item;

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
     * {@link CalendrierExamenDTO }
     * 
     * 
     */
    public List<CalendrierExamenDTO> getItem() {
        if (item == null) {
            item = new ArrayList<CalendrierExamenDTO>();
        }
        return this.item;
    }

}
