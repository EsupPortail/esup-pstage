
package org.esupportail.wssi.services.remote;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for typDiplome complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="typDiplome">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="aglCur" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="aglForm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="aglTemMast" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codNif" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="codTds" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codTdsInt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codTpdEtb" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codTpdSis" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="etaThsHdrDrt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="libTpd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="licTpd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="temCrdSis" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="temEnSveTpd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="temEnqSisTpd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="temNatEur" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="temPrior" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="temSante" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "typDiplome", propOrder = {
    "aglCur",
    "aglForm",
    "aglTemMast",
    "codNif",
    "codTds",
    "codTdsInt",
    "codTpdEtb",
    "codTpdSis",
    "etaThsHdrDrt",
    "libTpd",
    "licTpd",
    "temCrdSis",
    "temEnSveTpd",
    "temEnqSisTpd",
    "temNatEur",
    "temPrior",
    "temSante"
})
public class TypDiplome {

    protected String aglCur;
    protected String aglForm;
    protected String aglTemMast;
    protected Integer codNif;
    protected String codTds;
    protected String codTdsInt;
    protected String codTpdEtb;
    protected String codTpdSis;
    protected String etaThsHdrDrt;
    protected String libTpd;
    protected String licTpd;
    protected String temCrdSis;
    protected String temEnSveTpd;
    protected String temEnqSisTpd;
    protected String temNatEur;
    protected String temPrior;
    protected String temSante;

    /**
     * Gets the value of the aglCur property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAglCur() {
        return aglCur;
    }

    /**
     * Sets the value of the aglCur property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAglCur(String value) {
        this.aglCur = value;
    }

    /**
     * Gets the value of the aglForm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAglForm() {
        return aglForm;
    }

    /**
     * Sets the value of the aglForm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAglForm(String value) {
        this.aglForm = value;
    }

    /**
     * Gets the value of the aglTemMast property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAglTemMast() {
        return aglTemMast;
    }

    /**
     * Sets the value of the aglTemMast property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAglTemMast(String value) {
        this.aglTemMast = value;
    }

    /**
     * Gets the value of the codNif property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCodNif() {
        return codNif;
    }

    /**
     * Sets the value of the codNif property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCodNif(Integer value) {
        this.codNif = value;
    }

    /**
     * Gets the value of the codTds property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodTds() {
        return codTds;
    }

    /**
     * Sets the value of the codTds property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodTds(String value) {
        this.codTds = value;
    }

    /**
     * Gets the value of the codTdsInt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodTdsInt() {
        return codTdsInt;
    }

    /**
     * Sets the value of the codTdsInt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodTdsInt(String value) {
        this.codTdsInt = value;
    }

    /**
     * Gets the value of the codTpdEtb property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodTpdEtb() {
        return codTpdEtb;
    }

    /**
     * Sets the value of the codTpdEtb property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodTpdEtb(String value) {
        this.codTpdEtb = value;
    }

    /**
     * Gets the value of the codTpdSis property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodTpdSis() {
        return codTpdSis;
    }

    /**
     * Sets the value of the codTpdSis property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodTpdSis(String value) {
        this.codTpdSis = value;
    }

    /**
     * Gets the value of the etaThsHdrDrt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEtaThsHdrDrt() {
        return etaThsHdrDrt;
    }

    /**
     * Sets the value of the etaThsHdrDrt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEtaThsHdrDrt(String value) {
        this.etaThsHdrDrt = value;
    }

    /**
     * Gets the value of the libTpd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibTpd() {
        return libTpd;
    }

    /**
     * Sets the value of the libTpd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibTpd(String value) {
        this.libTpd = value;
    }

    /**
     * Gets the value of the licTpd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLicTpd() {
        return licTpd;
    }

    /**
     * Sets the value of the licTpd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLicTpd(String value) {
        this.licTpd = value;
    }

    /**
     * Gets the value of the temCrdSis property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemCrdSis() {
        return temCrdSis;
    }

    /**
     * Sets the value of the temCrdSis property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemCrdSis(String value) {
        this.temCrdSis = value;
    }

    /**
     * Gets the value of the temEnSveTpd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemEnSveTpd() {
        return temEnSveTpd;
    }

    /**
     * Sets the value of the temEnSveTpd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemEnSveTpd(String value) {
        this.temEnSveTpd = value;
    }

    /**
     * Gets the value of the temEnqSisTpd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemEnqSisTpd() {
        return temEnqSisTpd;
    }

    /**
     * Sets the value of the temEnqSisTpd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemEnqSisTpd(String value) {
        this.temEnqSisTpd = value;
    }

    /**
     * Gets the value of the temNatEur property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemNatEur() {
        return temNatEur;
    }

    /**
     * Sets the value of the temNatEur property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemNatEur(String value) {
        this.temNatEur = value;
    }

    /**
     * Gets the value of the temPrior property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemPrior() {
        return temPrior;
    }

    /**
     * Sets the value of the temPrior property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemPrior(String value) {
        this.temPrior = value;
    }

    /**
     * Gets the value of the temSante property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemSante() {
        return temSante;
    }

    /**
     * Sets the value of the temSante property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemSante(String value) {
        this.temSante = value;
    }

}
