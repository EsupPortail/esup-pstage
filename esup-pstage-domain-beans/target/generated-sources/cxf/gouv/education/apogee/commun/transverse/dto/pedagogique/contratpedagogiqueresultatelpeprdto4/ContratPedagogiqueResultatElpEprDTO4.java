
package gouv.education.apogee.commun.transverse.dto.pedagogique.contratpedagogiqueresultatelpeprdto4;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gouv.education.apogee.commun.transverse.dto.pedagogique.centreinspeddto.CentreInsPedDTO;
import gouv.education.apogee.commun.transverse.dto.pedagogique.contratpedagogiqueresultatelpeprdto2.TableauEpreuveElpDto2;
import gouv.education.apogee.commun.transverse.dto.pedagogique.elementpedagogidto5.ElementPedagogiDTO5;
import gouv.education.apogee.commun.transverse.dto.pedagogique.formuleexamendto.FormuleExamenDTO;


/**
 * <p>Java class for ContratPedagogiqueResultatElpEprDTO4 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ContratPedagogiqueResultatElpEprDTO4">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cip" type="{CentreInsPedDTO.pedagogique.dto.transverse.commun.apogee.education.gouv}CentreInsPedDTO"/>
 *         &lt;element name="codAnu" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codElpSup" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codTypIpe" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="elp" type="{ElementPedagogiDTO5.pedagogique.dto.transverse.commun.apogee.education.gouv}ElementPedagogiDTO5"/>
 *         &lt;element name="epreuvesElp" type="{ContratPedagogiqueResultatElpEprDTO2.pedagogique.dto.transverse.commun.apogee.education.gouv}TableauEpreuveElpDto2"/>
 *         &lt;element name="fex" type="{FormuleExamenDTO.pedagogique.dto.transverse.commun.apogee.education.gouv}FormuleExamenDTO"/>
 *         &lt;element name="groupes" type="{ContratPedagogiqueResultatElpEprDTO4.pedagogique.dto.transverse.commun.apogee.education.gouv}TableauGroupeEtpDto"/>
 *         &lt;element name="resultatsElp" type="{ContratPedagogiqueResultatElpEprDTO4.pedagogique.dto.transverse.commun.apogee.education.gouv}TableauResultatElpDto3"/>
 *         &lt;element name="rngElp" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ContratPedagogiqueResultatElpEprDTO4", propOrder = {
    "cip",
    "codAnu",
    "codElpSup",
    "codTypIpe",
    "elp",
    "epreuvesElp",
    "fex",
    "groupes",
    "resultatsElp",
    "rngElp"
})
public class ContratPedagogiqueResultatElpEprDTO4 {

    @XmlElement(required = true, nillable = true)
    protected CentreInsPedDTO cip;
    @XmlElement(required = true, nillable = true)
    protected String codAnu;
    @XmlElement(required = true, nillable = true)
    protected String codElpSup;
    @XmlElement(required = true, nillable = true)
    protected String codTypIpe;
    @XmlElement(required = true, nillable = true)
    protected ElementPedagogiDTO5 elp;
    @XmlElement(required = true, nillable = true)
    protected TableauEpreuveElpDto2 epreuvesElp;
    @XmlElement(required = true, nillable = true)
    protected FormuleExamenDTO fex;
    @XmlElement(required = true, nillable = true)
    protected TableauGroupeEtpDto groupes;
    @XmlElement(required = true, nillable = true)
    protected TableauResultatElpDto3 resultatsElp;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer rngElp;

    /**
     * Gets the value of the cip property.
     * 
     * @return
     *     possible object is
     *     {@link CentreInsPedDTO }
     *     
     */
    public CentreInsPedDTO getCip() {
        return cip;
    }

    /**
     * Sets the value of the cip property.
     * 
     * @param value
     *     allowed object is
     *     {@link CentreInsPedDTO }
     *     
     */
    public void setCip(CentreInsPedDTO value) {
        this.cip = value;
    }

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
     * Gets the value of the codElpSup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodElpSup() {
        return codElpSup;
    }

    /**
     * Sets the value of the codElpSup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodElpSup(String value) {
        this.codElpSup = value;
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
     * Gets the value of the elp property.
     * 
     * @return
     *     possible object is
     *     {@link ElementPedagogiDTO5 }
     *     
     */
    public ElementPedagogiDTO5 getElp() {
        return elp;
    }

    /**
     * Sets the value of the elp property.
     * 
     * @param value
     *     allowed object is
     *     {@link ElementPedagogiDTO5 }
     *     
     */
    public void setElp(ElementPedagogiDTO5 value) {
        this.elp = value;
    }

    /**
     * Gets the value of the epreuvesElp property.
     * 
     * @return
     *     possible object is
     *     {@link TableauEpreuveElpDto2 }
     *     
     */
    public TableauEpreuveElpDto2 getEpreuvesElp() {
        return epreuvesElp;
    }

    /**
     * Sets the value of the epreuvesElp property.
     * 
     * @param value
     *     allowed object is
     *     {@link TableauEpreuveElpDto2 }
     *     
     */
    public void setEpreuvesElp(TableauEpreuveElpDto2 value) {
        this.epreuvesElp = value;
    }

    /**
     * Gets the value of the fex property.
     * 
     * @return
     *     possible object is
     *     {@link FormuleExamenDTO }
     *     
     */
    public FormuleExamenDTO getFex() {
        return fex;
    }

    /**
     * Sets the value of the fex property.
     * 
     * @param value
     *     allowed object is
     *     {@link FormuleExamenDTO }
     *     
     */
    public void setFex(FormuleExamenDTO value) {
        this.fex = value;
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
     * Gets the value of the resultatsElp property.
     * 
     * @return
     *     possible object is
     *     {@link TableauResultatElpDto3 }
     *     
     */
    public TableauResultatElpDto3 getResultatsElp() {
        return resultatsElp;
    }

    /**
     * Sets the value of the resultatsElp property.
     * 
     * @param value
     *     allowed object is
     *     {@link TableauResultatElpDto3 }
     *     
     */
    public void setResultatsElp(TableauResultatElpDto3 value) {
        this.resultatsElp = value;
    }

    /**
     * Gets the value of the rngElp property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRngElp() {
        return rngElp;
    }

    /**
     * Sets the value of the rngElp property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRngElp(Integer value) {
        this.rngElp = value;
    }

}
