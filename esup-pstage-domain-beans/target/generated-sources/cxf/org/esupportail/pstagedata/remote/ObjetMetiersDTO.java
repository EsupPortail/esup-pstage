
package org.esupportail.pstagedata.remote;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for objetMetiersDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="objetMetiersDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dateCreation" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="dateModif" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="loginCreation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="loginModif" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "objetMetiersDTO", propOrder = {
    "dateCreation",
    "dateModif",
    "loginCreation",
    "loginModif"
})
@XmlSeeAlso({
    ConventionDTO.class,
    OffreDiffusionDTO.class,
    AvenantDTO.class,
    OffreDTO.class,
    AdresseDTO.class,
    PersonneDTO.class,
    AccordPartenariatDTO.class
})
public class ObjetMetiersDTO {

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateCreation;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateModif;
    protected String loginCreation;
    protected String loginModif;

    /**
     * Gets the value of the dateCreation property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateCreation() {
        return dateCreation;
    }

    /**
     * Sets the value of the dateCreation property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateCreation(XMLGregorianCalendar value) {
        this.dateCreation = value;
    }

    /**
     * Gets the value of the dateModif property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateModif() {
        return dateModif;
    }

    /**
     * Sets the value of the dateModif property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateModif(XMLGregorianCalendar value) {
        this.dateModif = value;
    }

    /**
     * Gets the value of the loginCreation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoginCreation() {
        return loginCreation;
    }

    /**
     * Sets the value of the loginCreation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoginCreation(String value) {
        this.loginCreation = value;
    }

    /**
     * Gets the value of the loginModif property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoginModif() {
        return loginModif;
    }

    /**
     * Sets the value of the loginModif property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoginModif(String value) {
        this.loginModif = value;
    }

}
