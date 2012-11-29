
package org.esupportail.wssi.services.remote;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for eprSanctionneElp complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="eprSanctionneElp">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codElp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codEpr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codSes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="datCreEprSes" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="datModEprSes" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="datSusEprSes" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="temSusEprSes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "eprSanctionneElp", propOrder = {
    "codElp",
    "codEpr",
    "codSes",
    "datCreEprSes",
    "datModEprSes",
    "datSusEprSes",
    "temSusEprSes"
})
public class EprSanctionneElp {

    protected String codElp;
    protected String codEpr;
    protected String codSes;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar datCreEprSes;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar datModEprSes;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar datSusEprSes;
    protected String temSusEprSes;

    /**
     * Gets the value of the codElp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodElp() {
        return codElp;
    }

    /**
     * Sets the value of the codElp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodElp(String value) {
        this.codElp = value;
    }

    /**
     * Gets the value of the codEpr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodEpr() {
        return codEpr;
    }

    /**
     * Sets the value of the codEpr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodEpr(String value) {
        this.codEpr = value;
    }

    /**
     * Gets the value of the codSes property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodSes() {
        return codSes;
    }

    /**
     * Sets the value of the codSes property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodSes(String value) {
        this.codSes = value;
    }

    /**
     * Gets the value of the datCreEprSes property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatCreEprSes() {
        return datCreEprSes;
    }

    /**
     * Sets the value of the datCreEprSes property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatCreEprSes(XMLGregorianCalendar value) {
        this.datCreEprSes = value;
    }

    /**
     * Gets the value of the datModEprSes property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatModEprSes() {
        return datModEprSes;
    }

    /**
     * Sets the value of the datModEprSes property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatModEprSes(XMLGregorianCalendar value) {
        this.datModEprSes = value;
    }

    /**
     * Gets the value of the datSusEprSes property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatSusEprSes() {
        return datSusEprSes;
    }

    /**
     * Sets the value of the datSusEprSes property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatSusEprSes(XMLGregorianCalendar value) {
        this.datSusEprSes = value;
    }

    /**
     * Gets the value of the temSusEprSes property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemSusEprSes() {
        return temSusEprSes;
    }

    /**
     * Sets the value of the temSusEprSes property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemSusEprSes(String value) {
        this.temSusEprSes = value;
    }

}
