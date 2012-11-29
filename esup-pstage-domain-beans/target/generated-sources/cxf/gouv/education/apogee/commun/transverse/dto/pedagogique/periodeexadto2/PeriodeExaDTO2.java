
package gouv.education.apogee.commun.transverse.dto.pedagogique.periodeexadto2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PeriodeExaDTO2 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PeriodeExaDTO2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codPeriode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dateDebutPeriode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dateFinPeriode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libPeriode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="listCalendriersExamen" type="{PeriodeExaDTO2.pedagogique.dto.transverse.commun.apogee.education.gouv}TableauCalendrierExamenDTO"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PeriodeExaDTO2", propOrder = {
    "codPeriode",
    "dateDebutPeriode",
    "dateFinPeriode",
    "libPeriode",
    "listCalendriersExamen"
})
public class PeriodeExaDTO2 {

    @XmlElement(required = true, nillable = true)
    protected String codPeriode;
    @XmlElement(required = true, nillable = true)
    protected String dateDebutPeriode;
    @XmlElement(required = true, nillable = true)
    protected String dateFinPeriode;
    @XmlElement(required = true, nillable = true)
    protected String libPeriode;
    @XmlElement(required = true, nillable = true)
    protected TableauCalendrierExamenDTO listCalendriersExamen;

    /**
     * Gets the value of the codPeriode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodPeriode() {
        return codPeriode;
    }

    /**
     * Sets the value of the codPeriode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodPeriode(String value) {
        this.codPeriode = value;
    }

    /**
     * Gets the value of the dateDebutPeriode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateDebutPeriode() {
        return dateDebutPeriode;
    }

    /**
     * Sets the value of the dateDebutPeriode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateDebutPeriode(String value) {
        this.dateDebutPeriode = value;
    }

    /**
     * Gets the value of the dateFinPeriode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateFinPeriode() {
        return dateFinPeriode;
    }

    /**
     * Sets the value of the dateFinPeriode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateFinPeriode(String value) {
        this.dateFinPeriode = value;
    }

    /**
     * Gets the value of the libPeriode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibPeriode() {
        return libPeriode;
    }

    /**
     * Sets the value of the libPeriode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibPeriode(String value) {
        this.libPeriode = value;
    }

    /**
     * Gets the value of the listCalendriersExamen property.
     * 
     * @return
     *     possible object is
     *     {@link TableauCalendrierExamenDTO }
     *     
     */
    public TableauCalendrierExamenDTO getListCalendriersExamen() {
        return listCalendriersExamen;
    }

    /**
     * Sets the value of the listCalendriersExamen property.
     * 
     * @param value
     *     allowed object is
     *     {@link TableauCalendrierExamenDTO }
     *     
     */
    public void setListCalendriersExamen(TableauCalendrierExamenDTO value) {
        this.listCalendriersExamen = value;
    }

}
