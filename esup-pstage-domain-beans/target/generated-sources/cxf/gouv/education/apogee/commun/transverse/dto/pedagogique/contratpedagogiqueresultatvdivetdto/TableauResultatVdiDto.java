
package gouv.education.apogee.commun.transverse.dto.pedagogique.contratpedagogiqueresultatvdivetdto;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import gouv.education.apogee.commun.transverse.dto.pedagogique.resultatvdidto.ResultatVdiDTO;


/**
 * <p>Java class for TableauResultatVdiDto complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TableauResultatVdiDto">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="item" type="{ResultatVdiDTO.pedagogique.dto.transverse.commun.apogee.education.gouv}ResultatVdiDTO" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TableauResultatVdiDto", propOrder = {
    "item"
})
public class TableauResultatVdiDto {

    protected List<ResultatVdiDTO> item;

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
     * {@link ResultatVdiDTO }
     * 
     * 
     */
    public List<ResultatVdiDTO> getItem() {
        if (item == null) {
            item = new ArrayList<ResultatVdiDTO>();
        }
        return this.item;
    }

}
