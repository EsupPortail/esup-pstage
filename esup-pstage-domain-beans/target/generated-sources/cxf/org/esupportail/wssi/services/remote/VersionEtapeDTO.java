
package org.esupportail.wssi.services.remote;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for versionEtapeDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="versionEtapeDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://remote.services.wssi.esupportail.org/}dto">
 *       &lt;sequence>
 *         &lt;element name="codCgeMinVet" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codCgeMinpVet" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codEtp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codVrsVet" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="datDebMinVet" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="datDebMinpVet" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="datFinMinVet" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="datFinMinpVet" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="libCmtVet" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="libWebVet" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="licEtp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "versionEtapeDTO", propOrder = {
    "codCgeMinVet",
    "codCgeMinpVet",
    "codEtp",
    "codVrsVet",
    "datDebMinVet",
    "datDebMinpVet",
    "datFinMinVet",
    "datFinMinpVet",
    "libCmtVet",
    "libWebVet",
    "licEtp"
})
public class VersionEtapeDTO
    extends Dto
{

    protected String codCgeMinVet;
    protected String codCgeMinpVet;
    protected String codEtp;
    protected Integer codVrsVet;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar datDebMinVet;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar datDebMinpVet;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar datFinMinVet;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar datFinMinpVet;
    protected String libCmtVet;
    protected String libWebVet;
    protected String licEtp;

    /**
     * Gets the value of the codCgeMinVet property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodCgeMinVet() {
        return codCgeMinVet;
    }

    /**
     * Sets the value of the codCgeMinVet property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodCgeMinVet(String value) {
        this.codCgeMinVet = value;
    }

    /**
     * Gets the value of the codCgeMinpVet property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodCgeMinpVet() {
        return codCgeMinpVet;
    }

    /**
     * Sets the value of the codCgeMinpVet property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodCgeMinpVet(String value) {
        this.codCgeMinpVet = value;
    }

    /**
     * Gets the value of the codEtp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodEtp() {
        return codEtp;
    }

    /**
     * Sets the value of the codEtp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodEtp(String value) {
        this.codEtp = value;
    }

    /**
     * Gets the value of the codVrsVet property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCodVrsVet() {
        return codVrsVet;
    }

    /**
     * Sets the value of the codVrsVet property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCodVrsVet(Integer value) {
        this.codVrsVet = value;
    }

    /**
     * Gets the value of the datDebMinVet property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatDebMinVet() {
        return datDebMinVet;
    }

    /**
     * Sets the value of the datDebMinVet property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatDebMinVet(XMLGregorianCalendar value) {
        this.datDebMinVet = value;
    }

    /**
     * Gets the value of the datDebMinpVet property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatDebMinpVet() {
        return datDebMinpVet;
    }

    /**
     * Sets the value of the datDebMinpVet property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatDebMinpVet(XMLGregorianCalendar value) {
        this.datDebMinpVet = value;
    }

    /**
     * Gets the value of the datFinMinVet property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatFinMinVet() {
        return datFinMinVet;
    }

    /**
     * Sets the value of the datFinMinVet property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatFinMinVet(XMLGregorianCalendar value) {
        this.datFinMinVet = value;
    }

    /**
     * Gets the value of the datFinMinpVet property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatFinMinpVet() {
        return datFinMinpVet;
    }

    /**
     * Sets the value of the datFinMinpVet property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatFinMinpVet(XMLGregorianCalendar value) {
        this.datFinMinpVet = value;
    }

    /**
     * Gets the value of the libCmtVet property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibCmtVet() {
        return libCmtVet;
    }

    /**
     * Sets the value of the libCmtVet property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibCmtVet(String value) {
        this.libCmtVet = value;
    }

    /**
     * Gets the value of the libWebVet property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibWebVet() {
        return libWebVet;
    }

    /**
     * Sets the value of the libWebVet property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibWebVet(String value) {
        this.libWebVet = value;
    }

    /**
     * Gets the value of the licEtp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLicEtp() {
        return licEtp;
    }

    /**
     * Sets the value of the licEtp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLicEtp(String value) {
        this.licEtp = value;
    }

}
