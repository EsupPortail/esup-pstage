
package gouv.education.apogee.commun.transverse.dto.administratif.cursusexternesettransfertsdto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CursusExternesEtTransfertsDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CursusExternesEtTransfertsDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="listeCursusExternes" type="{CursusExternesEtTransfertsDTO.administratif.dto.transverse.commun.apogee.education.gouv}TableauCursusExterneDto"/>
 *         &lt;element name="listeTransferts" type="{CursusExternesEtTransfertsDTO.administratif.dto.transverse.commun.apogee.education.gouv}TableauTransfertDto"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CursusExternesEtTransfertsDTO", propOrder = {
    "listeCursusExternes",
    "listeTransferts"
})
public class CursusExternesEtTransfertsDTO {

    @XmlElement(required = true, nillable = true)
    protected TableauCursusExterneDto listeCursusExternes;
    @XmlElement(required = true, nillable = true)
    protected TableauTransfertDto listeTransferts;

    /**
     * Gets the value of the listeCursusExternes property.
     * 
     * @return
     *     possible object is
     *     {@link TableauCursusExterneDto }
     *     
     */
    public TableauCursusExterneDto getListeCursusExternes() {
        return listeCursusExternes;
    }

    /**
     * Sets the value of the listeCursusExternes property.
     * 
     * @param value
     *     allowed object is
     *     {@link TableauCursusExterneDto }
     *     
     */
    public void setListeCursusExternes(TableauCursusExterneDto value) {
        this.listeCursusExternes = value;
    }

    /**
     * Gets the value of the listeTransferts property.
     * 
     * @return
     *     possible object is
     *     {@link TableauTransfertDto }
     *     
     */
    public TableauTransfertDto getListeTransferts() {
        return listeTransferts;
    }

    /**
     * Sets the value of the listeTransferts property.
     * 
     * @param value
     *     allowed object is
     *     {@link TableauTransfertDto }
     *     
     */
    public void setListeTransferts(TableauTransfertDto value) {
        this.listeTransferts = value;
    }

}
