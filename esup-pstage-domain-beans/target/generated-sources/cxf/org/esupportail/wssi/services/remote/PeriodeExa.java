
package org.esupportail.wssi.services.remote;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for periodeExa complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="periodeExa">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codCin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codPxa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="datDebPxa" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="datDerTrtPxa" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="datFinPxa" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="libPxa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="temEnSvePxa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="temPrdValidPxa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "periodeExa", propOrder = {
    "codCin",
    "codPxa",
    "datDebPxa",
    "datDerTrtPxa",
    "datFinPxa",
    "libPxa",
    "temEnSvePxa",
    "temPrdValidPxa"
})
public class PeriodeExa {

    protected String codCin;
    protected String codPxa;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar datDebPxa;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar datDerTrtPxa;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar datFinPxa;
    protected String libPxa;
    protected String temEnSvePxa;
    protected String temPrdValidPxa;

    /**
     * Gets the value of the codCin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodCin() {
        return codCin;
    }

    /**
     * Sets the value of the codCin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodCin(String value) {
        this.codCin = value;
    }

    /**
     * Gets the value of the codPxa property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodPxa() {
        return codPxa;
    }

    /**
     * Sets the value of the codPxa property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodPxa(String value) {
        this.codPxa = value;
    }

    /**
     * Gets the value of the datDebPxa property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatDebPxa() {
        return datDebPxa;
    }

    /**
     * Sets the value of the datDebPxa property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatDebPxa(XMLGregorianCalendar value) {
        this.datDebPxa = value;
    }

    /**
     * Gets the value of the datDerTrtPxa property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatDerTrtPxa() {
        return datDerTrtPxa;
    }

    /**
     * Sets the value of the datDerTrtPxa property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatDerTrtPxa(XMLGregorianCalendar value) {
        this.datDerTrtPxa = value;
    }

    /**
     * Gets the value of the datFinPxa property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatFinPxa() {
        return datFinPxa;
    }

    /**
     * Sets the value of the datFinPxa property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatFinPxa(XMLGregorianCalendar value) {
        this.datFinPxa = value;
    }

    /**
     * Gets the value of the libPxa property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibPxa() {
        return libPxa;
    }

    /**
     * Sets the value of the libPxa property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibPxa(String value) {
        this.libPxa = value;
    }

    /**
     * Gets the value of the temEnSvePxa property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemEnSvePxa() {
        return temEnSvePxa;
    }

    /**
     * Sets the value of the temEnSvePxa property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemEnSvePxa(String value) {
        this.temEnSvePxa = value;
    }

    /**
     * Gets the value of the temPrdValidPxa property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemPrdValidPxa() {
        return temPrdValidPxa;
    }

    /**
     * Sets the value of the temPrdValidPxa property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemPrdValidPxa(String value) {
        this.temPrdValidPxa = value;
    }

}
