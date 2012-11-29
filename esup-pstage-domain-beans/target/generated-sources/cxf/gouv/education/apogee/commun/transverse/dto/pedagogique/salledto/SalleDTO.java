
package gouv.education.apogee.commun.transverse.dto.pedagogique.salledto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gouv.education.apogee.commun.transverse.dto.pedagogique.epreuvedto4.TableauCaracTechDTO;


/**
 * <p>Java class for SalleDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SalleDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codBat" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codSalle" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codTypeSalle" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dateExamen" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="heureDebut" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libBat" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libSalle" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="listCaracTechSalle" type="{EpreuveDTO4.pedagogique.dto.transverse.commun.apogee.education.gouv}TableauCaracTechDTO"/>
 *         &lt;element name="listEnsAff" type="{SalleDTO.pedagogique.dto.transverse.commun.apogee.education.gouv}TableauPersonnelDTO3"/>
 *         &lt;element name="localisationBat" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SalleDTO", propOrder = {
    "codBat",
    "codSalle",
    "codTypeSalle",
    "dateExamen",
    "heureDebut",
    "libBat",
    "libSalle",
    "libType",
    "listCaracTechSalle",
    "listEnsAff",
    "localisationBat"
})
public class SalleDTO {

    @XmlElement(required = true, nillable = true)
    protected String codBat;
    @XmlElement(required = true, nillable = true)
    protected String codSalle;
    @XmlElement(required = true, nillable = true)
    protected String codTypeSalle;
    @XmlElement(required = true, nillable = true)
    protected String dateExamen;
    @XmlElement(required = true, nillable = true)
    protected String heureDebut;
    @XmlElement(required = true, nillable = true)
    protected String libBat;
    @XmlElement(required = true, nillable = true)
    protected String libSalle;
    @XmlElement(required = true, nillable = true)
    protected String libType;
    @XmlElement(required = true, nillable = true)
    protected TableauCaracTechDTO listCaracTechSalle;
    @XmlElement(required = true, nillable = true)
    protected TableauPersonnelDTO3 listEnsAff;
    @XmlElement(required = true, nillable = true)
    protected String localisationBat;

    /**
     * Gets the value of the codBat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodBat() {
        return codBat;
    }

    /**
     * Sets the value of the codBat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodBat(String value) {
        this.codBat = value;
    }

    /**
     * Gets the value of the codSalle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodSalle() {
        return codSalle;
    }

    /**
     * Sets the value of the codSalle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodSalle(String value) {
        this.codSalle = value;
    }

    /**
     * Gets the value of the codTypeSalle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodTypeSalle() {
        return codTypeSalle;
    }

    /**
     * Sets the value of the codTypeSalle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodTypeSalle(String value) {
        this.codTypeSalle = value;
    }

    /**
     * Gets the value of the dateExamen property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateExamen() {
        return dateExamen;
    }

    /**
     * Sets the value of the dateExamen property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateExamen(String value) {
        this.dateExamen = value;
    }

    /**
     * Gets the value of the heureDebut property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHeureDebut() {
        return heureDebut;
    }

    /**
     * Sets the value of the heureDebut property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHeureDebut(String value) {
        this.heureDebut = value;
    }

    /**
     * Gets the value of the libBat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibBat() {
        return libBat;
    }

    /**
     * Sets the value of the libBat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibBat(String value) {
        this.libBat = value;
    }

    /**
     * Gets the value of the libSalle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibSalle() {
        return libSalle;
    }

    /**
     * Sets the value of the libSalle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibSalle(String value) {
        this.libSalle = value;
    }

    /**
     * Gets the value of the libType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibType() {
        return libType;
    }

    /**
     * Sets the value of the libType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibType(String value) {
        this.libType = value;
    }

    /**
     * Gets the value of the listCaracTechSalle property.
     * 
     * @return
     *     possible object is
     *     {@link TableauCaracTechDTO }
     *     
     */
    public TableauCaracTechDTO getListCaracTechSalle() {
        return listCaracTechSalle;
    }

    /**
     * Sets the value of the listCaracTechSalle property.
     * 
     * @param value
     *     allowed object is
     *     {@link TableauCaracTechDTO }
     *     
     */
    public void setListCaracTechSalle(TableauCaracTechDTO value) {
        this.listCaracTechSalle = value;
    }

    /**
     * Gets the value of the listEnsAff property.
     * 
     * @return
     *     possible object is
     *     {@link TableauPersonnelDTO3 }
     *     
     */
    public TableauPersonnelDTO3 getListEnsAff() {
        return listEnsAff;
    }

    /**
     * Sets the value of the listEnsAff property.
     * 
     * @param value
     *     allowed object is
     *     {@link TableauPersonnelDTO3 }
     *     
     */
    public void setListEnsAff(TableauPersonnelDTO3 value) {
        this.listEnsAff = value;
    }

    /**
     * Gets the value of the localisationBat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocalisationBat() {
        return localisationBat;
    }

    /**
     * Sets the value of the localisationBat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocalisationBat(String value) {
        this.localisationBat = value;
    }

}
