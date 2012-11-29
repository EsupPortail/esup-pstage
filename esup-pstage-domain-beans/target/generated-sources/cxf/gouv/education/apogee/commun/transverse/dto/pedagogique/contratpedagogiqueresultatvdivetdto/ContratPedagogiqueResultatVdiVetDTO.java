
package gouv.education.apogee.commun.transverse.dto.pedagogique.contratpedagogiqueresultatvdivetdto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gouv.education.apogee.commun.transverse.dto.pedagogique.diplomedto.DiplomeDTO;


/**
 * <p>Java class for ContratPedagogiqueResultatVdiVetDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ContratPedagogiqueResultatVdiVetDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="annee" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="datObtVdi" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="datValDip" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="diplome" type="{DiplomeDTO.pedagogique.dto.transverse.commun.apogee.education.gouv}DiplomeDTO"/>
 *         &lt;element name="etapes" type="{ContratPedagogiqueResultatVdiVetDTO.pedagogique.dto.transverse.commun.apogee.education.gouv}TableauEtapeResVdiVetDto"/>
 *         &lt;element name="resultatVdi" type="{ContratPedagogiqueResultatVdiVetDTO.pedagogique.dto.transverse.commun.apogee.education.gouv}TableauResultatVdiDto"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ContratPedagogiqueResultatVdiVetDTO", propOrder = {
    "annee",
    "datObtVdi",
    "datValDip",
    "diplome",
    "etapes",
    "resultatVdi"
})
public class ContratPedagogiqueResultatVdiVetDTO {

    @XmlElement(required = true, nillable = true)
    protected String annee;
    @XmlElement(required = true, nillable = true)
    protected String datObtVdi;
    @XmlElement(required = true, nillable = true)
    protected String datValDip;
    @XmlElement(required = true, nillable = true)
    protected DiplomeDTO diplome;
    @XmlElement(required = true, nillable = true)
    protected TableauEtapeResVdiVetDto etapes;
    @XmlElement(required = true, nillable = true)
    protected TableauResultatVdiDto resultatVdi;

    /**
     * Gets the value of the annee property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnnee() {
        return annee;
    }

    /**
     * Sets the value of the annee property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnnee(String value) {
        this.annee = value;
    }

    /**
     * Gets the value of the datObtVdi property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatObtVdi() {
        return datObtVdi;
    }

    /**
     * Sets the value of the datObtVdi property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatObtVdi(String value) {
        this.datObtVdi = value;
    }

    /**
     * Gets the value of the datValDip property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatValDip() {
        return datValDip;
    }

    /**
     * Sets the value of the datValDip property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatValDip(String value) {
        this.datValDip = value;
    }

    /**
     * Gets the value of the diplome property.
     * 
     * @return
     *     possible object is
     *     {@link DiplomeDTO }
     *     
     */
    public DiplomeDTO getDiplome() {
        return diplome;
    }

    /**
     * Sets the value of the diplome property.
     * 
     * @param value
     *     allowed object is
     *     {@link DiplomeDTO }
     *     
     */
    public void setDiplome(DiplomeDTO value) {
        this.diplome = value;
    }

    /**
     * Gets the value of the etapes property.
     * 
     * @return
     *     possible object is
     *     {@link TableauEtapeResVdiVetDto }
     *     
     */
    public TableauEtapeResVdiVetDto getEtapes() {
        return etapes;
    }

    /**
     * Sets the value of the etapes property.
     * 
     * @param value
     *     allowed object is
     *     {@link TableauEtapeResVdiVetDto }
     *     
     */
    public void setEtapes(TableauEtapeResVdiVetDto value) {
        this.etapes = value;
    }

    /**
     * Gets the value of the resultatVdi property.
     * 
     * @return
     *     possible object is
     *     {@link TableauResultatVdiDto }
     *     
     */
    public TableauResultatVdiDto getResultatVdi() {
        return resultatVdi;
    }

    /**
     * Sets the value of the resultatVdi property.
     * 
     * @param value
     *     allowed object is
     *     {@link TableauResultatVdiDto }
     *     
     */
    public void setResultatVdi(TableauResultatVdiDto value) {
        this.resultatVdi = value;
    }

}
