
package org.esupportail.wssi.services.remote;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for diplome complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="diplome">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codCyc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codDfd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codDip" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codEtb" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codNdi" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codNim" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codSds" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codTpdEtb" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="libDip" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="licDip" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nbrMaxInscDeug" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="temCouAccTrvDip" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="temOuvDrtSsoDip" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "diplome", propOrder = {
    "codCyc",
    "codDfd",
    "codDip",
    "codEtb",
    "codNdi",
    "codNim",
    "codSds",
    "codTpdEtb",
    "libDip",
    "licDip",
    "nbrMaxInscDeug",
    "temCouAccTrvDip",
    "temOuvDrtSsoDip"
})
public class Diplome {

    protected String codCyc;
    protected String codDfd;
    protected String codDip;
    protected String codEtb;
    protected String codNdi;
    protected String codNim;
    protected String codSds;
    protected String codTpdEtb;
    protected String libDip;
    protected String licDip;
    protected String nbrMaxInscDeug;
    protected String temCouAccTrvDip;
    protected String temOuvDrtSsoDip;

    /**
     * Gets the value of the codCyc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodCyc() {
        return codCyc;
    }

    /**
     * Sets the value of the codCyc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodCyc(String value) {
        this.codCyc = value;
    }

    /**
     * Gets the value of the codDfd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodDfd() {
        return codDfd;
    }

    /**
     * Sets the value of the codDfd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodDfd(String value) {
        this.codDfd = value;
    }

    /**
     * Gets the value of the codDip property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodDip() {
        return codDip;
    }

    /**
     * Sets the value of the codDip property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodDip(String value) {
        this.codDip = value;
    }

    /**
     * Gets the value of the codEtb property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodEtb() {
        return codEtb;
    }

    /**
     * Sets the value of the codEtb property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodEtb(String value) {
        this.codEtb = value;
    }

    /**
     * Gets the value of the codNdi property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodNdi() {
        return codNdi;
    }

    /**
     * Sets the value of the codNdi property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodNdi(String value) {
        this.codNdi = value;
    }

    /**
     * Gets the value of the codNim property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodNim() {
        return codNim;
    }

    /**
     * Sets the value of the codNim property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodNim(String value) {
        this.codNim = value;
    }

    /**
     * Gets the value of the codSds property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodSds() {
        return codSds;
    }

    /**
     * Sets the value of the codSds property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodSds(String value) {
        this.codSds = value;
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
     * Gets the value of the libDip property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibDip() {
        return libDip;
    }

    /**
     * Sets the value of the libDip property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibDip(String value) {
        this.libDip = value;
    }

    /**
     * Gets the value of the licDip property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLicDip() {
        return licDip;
    }

    /**
     * Sets the value of the licDip property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLicDip(String value) {
        this.licDip = value;
    }

    /**
     * Gets the value of the nbrMaxInscDeug property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNbrMaxInscDeug() {
        return nbrMaxInscDeug;
    }

    /**
     * Sets the value of the nbrMaxInscDeug property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNbrMaxInscDeug(String value) {
        this.nbrMaxInscDeug = value;
    }

    /**
     * Gets the value of the temCouAccTrvDip property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemCouAccTrvDip() {
        return temCouAccTrvDip;
    }

    /**
     * Sets the value of the temCouAccTrvDip property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemCouAccTrvDip(String value) {
        this.temCouAccTrvDip = value;
    }

    /**
     * Gets the value of the temOuvDrtSsoDip property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemOuvDrtSsoDip() {
        return temOuvDrtSsoDip;
    }

    /**
     * Sets the value of the temOuvDrtSsoDip property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemOuvDrtSsoDip(String value) {
        this.temOuvDrtSsoDip = value;
    }

}
