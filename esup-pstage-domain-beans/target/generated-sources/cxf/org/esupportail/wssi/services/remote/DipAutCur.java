
package org.esupportail.wssi.services.remote;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dipAutCur complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dipAutCur">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codDac" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codSisDac" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="libDac" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="licDac" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="temEnSveDac" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dipAutCur", propOrder = {
    "codDac",
    "codSisDac",
    "libDac",
    "licDac",
    "temEnSveDac"
})
public class DipAutCur {

    protected String codDac;
    protected String codSisDac;
    protected String libDac;
    protected String licDac;
    protected String temEnSveDac;

    /**
     * Gets the value of the codDac property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodDac() {
        return codDac;
    }

    /**
     * Sets the value of the codDac property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodDac(String value) {
        this.codDac = value;
    }

    /**
     * Gets the value of the codSisDac property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodSisDac() {
        return codSisDac;
    }

    /**
     * Sets the value of the codSisDac property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodSisDac(String value) {
        this.codSisDac = value;
    }

    /**
     * Gets the value of the libDac property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibDac() {
        return libDac;
    }

    /**
     * Sets the value of the libDac property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibDac(String value) {
        this.libDac = value;
    }

    /**
     * Gets the value of the licDac property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLicDac() {
        return licDac;
    }

    /**
     * Sets the value of the licDac property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLicDac(String value) {
        this.licDac = value;
    }

    /**
     * Gets the value of the temEnSveDac property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemEnSveDac() {
        return temEnSveDac;
    }

    /**
     * Sets the value of the temEnSveDac property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemEnSveDac(String value) {
        this.temEnSveDac = value;
    }

}
