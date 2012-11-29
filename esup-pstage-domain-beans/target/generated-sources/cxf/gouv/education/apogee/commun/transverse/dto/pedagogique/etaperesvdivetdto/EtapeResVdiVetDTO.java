
package gouv.education.apogee.commun.transverse.dto.pedagogique.etaperesvdivetdto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gouv.education.apogee.commun.transverse.dto.pedagogique.contratpedagogiqueresultatelpeprdto4.TableauGroupeEtpDto;
import gouv.education.apogee.commun.transverse.dto.pedagogique.etapedto.EtapeDTO;


/**
 * <p>Java class for EtapeResVdiVetDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EtapeResVdiVetDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codAnu" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codEtaIae" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codTypIpe" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="etape" type="{EtapeDTO.pedagogique.dto.transverse.commun.apogee.education.gouv}EtapeDTO"/>
 *         &lt;element name="groupes" type="{ContratPedagogiqueResultatElpEprDTO4.pedagogique.dto.transverse.commun.apogee.education.gouv}TableauGroupeEtpDto"/>
 *         &lt;element name="libEtaIae" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libTypIpe" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="resultatVet" type="{EtapeResVdiVetDTO.pedagogique.dto.transverse.commun.apogee.education.gouv}TableauResultatVetDto"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EtapeResVdiVetDTO", propOrder = {
    "codAnu",
    "codEtaIae",
    "codTypIpe",
    "etape",
    "groupes",
    "libEtaIae",
    "libTypIpe",
    "resultatVet"
})
public class EtapeResVdiVetDTO {

    @XmlElement(required = true, nillable = true)
    protected String codAnu;
    @XmlElement(required = true, nillable = true)
    protected String codEtaIae;
    @XmlElement(required = true, nillable = true)
    protected String codTypIpe;
    @XmlElement(required = true, nillable = true)
    protected EtapeDTO etape;
    @XmlElement(required = true, nillable = true)
    protected TableauGroupeEtpDto groupes;
    @XmlElement(required = true, nillable = true)
    protected String libEtaIae;
    @XmlElement(required = true, nillable = true)
    protected String libTypIpe;
    @XmlElement(required = true, nillable = true)
    protected TableauResultatVetDto resultatVet;

    /**
     * Gets the value of the codAnu property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodAnu() {
        return codAnu;
    }

    /**
     * Sets the value of the codAnu property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodAnu(String value) {
        this.codAnu = value;
    }

    /**
     * Gets the value of the codEtaIae property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodEtaIae() {
        return codEtaIae;
    }

    /**
     * Sets the value of the codEtaIae property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodEtaIae(String value) {
        this.codEtaIae = value;
    }

    /**
     * Gets the value of the codTypIpe property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodTypIpe() {
        return codTypIpe;
    }

    /**
     * Sets the value of the codTypIpe property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodTypIpe(String value) {
        this.codTypIpe = value;
    }

    /**
     * Gets the value of the etape property.
     * 
     * @return
     *     possible object is
     *     {@link EtapeDTO }
     *     
     */
    public EtapeDTO getEtape() {
        return etape;
    }

    /**
     * Sets the value of the etape property.
     * 
     * @param value
     *     allowed object is
     *     {@link EtapeDTO }
     *     
     */
    public void setEtape(EtapeDTO value) {
        this.etape = value;
    }

    /**
     * Gets the value of the groupes property.
     * 
     * @return
     *     possible object is
     *     {@link TableauGroupeEtpDto }
     *     
     */
    public TableauGroupeEtpDto getGroupes() {
        return groupes;
    }

    /**
     * Sets the value of the groupes property.
     * 
     * @param value
     *     allowed object is
     *     {@link TableauGroupeEtpDto }
     *     
     */
    public void setGroupes(TableauGroupeEtpDto value) {
        this.groupes = value;
    }

    /**
     * Gets the value of the libEtaIae property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibEtaIae() {
        return libEtaIae;
    }

    /**
     * Sets the value of the libEtaIae property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibEtaIae(String value) {
        this.libEtaIae = value;
    }

    /**
     * Gets the value of the libTypIpe property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibTypIpe() {
        return libTypIpe;
    }

    /**
     * Sets the value of the libTypIpe property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibTypIpe(String value) {
        this.libTypIpe = value;
    }

    /**
     * Gets the value of the resultatVet property.
     * 
     * @return
     *     possible object is
     *     {@link TableauResultatVetDto }
     *     
     */
    public TableauResultatVetDto getResultatVet() {
        return resultatVet;
    }

    /**
     * Sets the value of the resultatVet property.
     * 
     * @param value
     *     allowed object is
     *     {@link TableauResultatVetDto }
     *     
     */
    public void setResultatVet(TableauResultatVetDto value) {
        this.resultatVet = value;
    }

}
