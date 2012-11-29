
package gouv.education.apogee.commun.transverse.dto.pedagogique.calendrierexamendto3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CalendrierExamenDTO3 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CalendrierExamenDTO3">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codCalendrier" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libCalendrier" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="listEpreuves" type="{CalendrierExamenDTO3.pedagogique.dto.transverse.commun.apogee.education.gouv}tableauEpreuveDTO6"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CalendrierExamenDTO3", propOrder = {
    "codCalendrier",
    "libCalendrier",
    "listEpreuves"
})
public class CalendrierExamenDTO3 {

    @XmlElement(required = true, nillable = true)
    protected String codCalendrier;
    @XmlElement(required = true, nillable = true)
    protected String libCalendrier;
    @XmlElement(required = true, nillable = true)
    protected TableauEpreuveDTO6 listEpreuves;

    /**
     * Gets the value of the codCalendrier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodCalendrier() {
        return codCalendrier;
    }

    /**
     * Sets the value of the codCalendrier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodCalendrier(String value) {
        this.codCalendrier = value;
    }

    /**
     * Gets the value of the libCalendrier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibCalendrier() {
        return libCalendrier;
    }

    /**
     * Sets the value of the libCalendrier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibCalendrier(String value) {
        this.libCalendrier = value;
    }

    /**
     * Gets the value of the listEpreuves property.
     * 
     * @return
     *     possible object is
     *     {@link TableauEpreuveDTO6 }
     *     
     */
    public TableauEpreuveDTO6 getListEpreuves() {
        return listEpreuves;
    }

    /**
     * Sets the value of the listEpreuves property.
     * 
     * @param value
     *     allowed object is
     *     {@link TableauEpreuveDTO6 }
     *     
     */
    public void setListEpreuves(TableauEpreuveDTO6 value) {
        this.listEpreuves = value;
    }

}
