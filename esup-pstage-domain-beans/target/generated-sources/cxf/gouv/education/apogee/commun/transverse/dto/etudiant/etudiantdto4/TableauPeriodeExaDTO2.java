
package gouv.education.apogee.commun.transverse.dto.etudiant.etudiantdto4;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import gouv.education.apogee.commun.transverse.dto.pedagogique.periodeexadto4.PeriodeExaDTO4;


/**
 * <p>Java class for TableauPeriodeExaDTO2 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TableauPeriodeExaDTO2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="item" type="{PeriodeExaDTO4.pedagogique.dto.transverse.commun.apogee.education.gouv}PeriodeExaDTO4" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TableauPeriodeExaDTO2", propOrder = {
    "item"
})
public class TableauPeriodeExaDTO2 {

    protected List<PeriodeExaDTO4> item;

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
     * {@link PeriodeExaDTO4 }
     * 
     * 
     */
    public List<PeriodeExaDTO4> getItem() {
        if (item == null) {
            item = new ArrayList<PeriodeExaDTO4>();
        }
        return this.item;
    }

}
