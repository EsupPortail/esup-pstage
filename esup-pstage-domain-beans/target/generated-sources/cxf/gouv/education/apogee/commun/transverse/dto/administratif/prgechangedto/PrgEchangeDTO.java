
package gouv.education.apogee.commun.transverse.dto.administratif.prgechangedto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gouv.education.apogee.commun.transverse.dto.administratif.etablissementetrangerdto.EtablissementEtrangerDTO;
import gouv.education.apogee.commun.transverse.dto.administratif.paysdto.PaysDTO;


/**
 * <p>Java class for PrgEchangeDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PrgEchangeDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codPrg" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codSens" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="etablissement" type="{EtablissementEtrangerDTO.administratif.dto.transverse.commun.apogee.education.gouv}EtablissementEtrangerDTO"/>
 *         &lt;element name="libLongPrg" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libSens" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libWebPrg" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="pays" type="{PaysDTO.administratif.dto.transverse.commun.apogee.education.gouv}PaysDTO"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PrgEchangeDTO", propOrder = {
    "codPrg",
    "codSens",
    "etablissement",
    "libLongPrg",
    "libSens",
    "libWebPrg",
    "pays"
})
public class PrgEchangeDTO {

    @XmlElement(required = true, nillable = true)
    protected String codPrg;
    @XmlElement(required = true, nillable = true)
    protected String codSens;
    @XmlElement(required = true, nillable = true)
    protected EtablissementEtrangerDTO etablissement;
    @XmlElement(required = true, nillable = true)
    protected String libLongPrg;
    @XmlElement(required = true, nillable = true)
    protected String libSens;
    @XmlElement(required = true, nillable = true)
    protected String libWebPrg;
    @XmlElement(required = true, nillable = true)
    protected PaysDTO pays;

    /**
     * Gets the value of the codPrg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodPrg() {
        return codPrg;
    }

    /**
     * Sets the value of the codPrg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodPrg(String value) {
        this.codPrg = value;
    }

    /**
     * Gets the value of the codSens property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodSens() {
        return codSens;
    }

    /**
     * Sets the value of the codSens property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodSens(String value) {
        this.codSens = value;
    }

    /**
     * Gets the value of the etablissement property.
     * 
     * @return
     *     possible object is
     *     {@link EtablissementEtrangerDTO }
     *     
     */
    public EtablissementEtrangerDTO getEtablissement() {
        return etablissement;
    }

    /**
     * Sets the value of the etablissement property.
     * 
     * @param value
     *     allowed object is
     *     {@link EtablissementEtrangerDTO }
     *     
     */
    public void setEtablissement(EtablissementEtrangerDTO value) {
        this.etablissement = value;
    }

    /**
     * Gets the value of the libLongPrg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibLongPrg() {
        return libLongPrg;
    }

    /**
     * Sets the value of the libLongPrg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibLongPrg(String value) {
        this.libLongPrg = value;
    }

    /**
     * Gets the value of the libSens property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibSens() {
        return libSens;
    }

    /**
     * Sets the value of the libSens property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibSens(String value) {
        this.libSens = value;
    }

    /**
     * Gets the value of the libWebPrg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibWebPrg() {
        return libWebPrg;
    }

    /**
     * Sets the value of the libWebPrg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibWebPrg(String value) {
        this.libWebPrg = value;
    }

    /**
     * Gets the value of the pays property.
     * 
     * @return
     *     possible object is
     *     {@link PaysDTO }
     *     
     */
    public PaysDTO getPays() {
        return pays;
    }

    /**
     * Sets the value of the pays property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaysDTO }
     *     
     */
    public void setPays(PaysDTO value) {
        this.pays = value;
    }

}
