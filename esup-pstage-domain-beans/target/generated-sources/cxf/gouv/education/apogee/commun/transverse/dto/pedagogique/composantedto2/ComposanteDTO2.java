
package gouv.education.apogee.commun.transverse.dto.pedagogique.composantedto2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gouv.education.apogee.commun.transverse.dto.pedagogique.adressecomposantedto.AdresseComposanteDTO;
import gouv.education.apogee.commun.transverse.dto.pedagogique.typecomposantedto.TypeComposanteDTO;


/**
 * <p>Java class for ComposanteDTO2 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ComposanteDTO2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="adresseComposante" type="{AdresseComposanteDTO.pedagogique.dto.transverse.commun.apogee.education.gouv}AdresseComposanteDTO"/>
 *         &lt;element name="codCmp" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codNatCmp" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codRneCmp" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libCmp" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libWebCmp" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="listeComposanteFils" type="{ComposanteDTO2.pedagogique.dto.transverse.commun.apogee.education.gouv}TableauComposanteDTO2"/>
 *         &lt;element name="listeComposantePere" type="{ComposanteDTO2.pedagogique.dto.transverse.commun.apogee.education.gouv}TableauComposanteDTO2"/>
 *         &lt;element name="temElcCmp" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="temEnSveCmp" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="typeComposante" type="{TypeComposanteDTO.pedagogique.dto.transverse.commun.apogee.education.gouv}TypeComposanteDTO"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ComposanteDTO2", propOrder = {
    "adresseComposante",
    "codCmp",
    "codNatCmp",
    "codRneCmp",
    "libCmp",
    "libWebCmp",
    "listeComposanteFils",
    "listeComposantePere",
    "temElcCmp",
    "temEnSveCmp",
    "typeComposante"
})
public class ComposanteDTO2 {

    @XmlElement(required = true, nillable = true)
    protected AdresseComposanteDTO adresseComposante;
    @XmlElement(required = true, nillable = true)
    protected String codCmp;
    @XmlElement(required = true, nillable = true)
    protected String codNatCmp;
    @XmlElement(required = true, nillable = true)
    protected String codRneCmp;
    @XmlElement(required = true, nillable = true)
    protected String libCmp;
    @XmlElement(required = true, nillable = true)
    protected String libWebCmp;
    @XmlElement(required = true, nillable = true)
    protected TableauComposanteDTO2 listeComposanteFils;
    @XmlElement(required = true, nillable = true)
    protected TableauComposanteDTO2 listeComposantePere;
    @XmlElement(required = true, nillable = true)
    protected String temElcCmp;
    @XmlElement(required = true, nillable = true)
    protected String temEnSveCmp;
    @XmlElement(required = true, nillable = true)
    protected TypeComposanteDTO typeComposante;

    /**
     * Gets the value of the adresseComposante property.
     * 
     * @return
     *     possible object is
     *     {@link AdresseComposanteDTO }
     *     
     */
    public AdresseComposanteDTO getAdresseComposante() {
        return adresseComposante;
    }

    /**
     * Sets the value of the adresseComposante property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdresseComposanteDTO }
     *     
     */
    public void setAdresseComposante(AdresseComposanteDTO value) {
        this.adresseComposante = value;
    }

    /**
     * Gets the value of the codCmp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodCmp() {
        return codCmp;
    }

    /**
     * Sets the value of the codCmp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodCmp(String value) {
        this.codCmp = value;
    }

    /**
     * Gets the value of the codNatCmp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodNatCmp() {
        return codNatCmp;
    }

    /**
     * Sets the value of the codNatCmp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodNatCmp(String value) {
        this.codNatCmp = value;
    }

    /**
     * Gets the value of the codRneCmp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodRneCmp() {
        return codRneCmp;
    }

    /**
     * Sets the value of the codRneCmp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodRneCmp(String value) {
        this.codRneCmp = value;
    }

    /**
     * Gets the value of the libCmp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibCmp() {
        return libCmp;
    }

    /**
     * Sets the value of the libCmp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibCmp(String value) {
        this.libCmp = value;
    }

    /**
     * Gets the value of the libWebCmp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibWebCmp() {
        return libWebCmp;
    }

    /**
     * Sets the value of the libWebCmp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibWebCmp(String value) {
        this.libWebCmp = value;
    }

    /**
     * Gets the value of the listeComposanteFils property.
     * 
     * @return
     *     possible object is
     *     {@link TableauComposanteDTO2 }
     *     
     */
    public TableauComposanteDTO2 getListeComposanteFils() {
        return listeComposanteFils;
    }

    /**
     * Sets the value of the listeComposanteFils property.
     * 
     * @param value
     *     allowed object is
     *     {@link TableauComposanteDTO2 }
     *     
     */
    public void setListeComposanteFils(TableauComposanteDTO2 value) {
        this.listeComposanteFils = value;
    }

    /**
     * Gets the value of the listeComposantePere property.
     * 
     * @return
     *     possible object is
     *     {@link TableauComposanteDTO2 }
     *     
     */
    public TableauComposanteDTO2 getListeComposantePere() {
        return listeComposantePere;
    }

    /**
     * Sets the value of the listeComposantePere property.
     * 
     * @param value
     *     allowed object is
     *     {@link TableauComposanteDTO2 }
     *     
     */
    public void setListeComposantePere(TableauComposanteDTO2 value) {
        this.listeComposantePere = value;
    }

    /**
     * Gets the value of the temElcCmp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemElcCmp() {
        return temElcCmp;
    }

    /**
     * Sets the value of the temElcCmp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemElcCmp(String value) {
        this.temElcCmp = value;
    }

    /**
     * Gets the value of the temEnSveCmp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemEnSveCmp() {
        return temEnSveCmp;
    }

    /**
     * Sets the value of the temEnSveCmp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemEnSveCmp(String value) {
        this.temEnSveCmp = value;
    }

    /**
     * Gets the value of the typeComposante property.
     * 
     * @return
     *     possible object is
     *     {@link TypeComposanteDTO }
     *     
     */
    public TypeComposanteDTO getTypeComposante() {
        return typeComposante;
    }

    /**
     * Sets the value of the typeComposante property.
     * 
     * @param value
     *     allowed object is
     *     {@link TypeComposanteDTO }
     *     
     */
    public void setTypeComposante(TypeComposanteDTO value) {
        this.typeComposante = value;
    }

}
