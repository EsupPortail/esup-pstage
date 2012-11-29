
package org.esupportail.pstagedata.remote;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for serviceDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="serviceDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://remote.pstagedata.esupportail.org/}adresseDTO">
 *       &lt;sequence>
 *         &lt;element name="idService" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idStructure" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="infosAJour" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="loginInfosAJour" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nom" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "serviceDTO", propOrder = {
    "idService",
    "idStructure",
    "infosAJour",
    "loginInfosAJour",
    "nom"
})
public class ServiceDTO
    extends AdresseDTO
{

    protected int idService;
    protected int idStructure;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar infosAJour;
    protected String loginInfosAJour;
    protected String nom;

    /**
     * Gets the value of the idService property.
     * 
     */
    public int getIdService() {
        return idService;
    }

    /**
     * Sets the value of the idService property.
     * 
     */
    public void setIdService(int value) {
        this.idService = value;
    }

    /**
     * Gets the value of the idStructure property.
     * 
     */
    public int getIdStructure() {
        return idStructure;
    }

    /**
     * Sets the value of the idStructure property.
     * 
     */
    public void setIdStructure(int value) {
        this.idStructure = value;
    }

    /**
     * Gets the value of the infosAJour property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getInfosAJour() {
        return infosAJour;
    }

    /**
     * Sets the value of the infosAJour property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setInfosAJour(XMLGregorianCalendar value) {
        this.infosAJour = value;
    }

    /**
     * Gets the value of the loginInfosAJour property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoginInfosAJour() {
        return loginInfosAJour;
    }

    /**
     * Sets the value of the loginInfosAJour property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoginInfosAJour(String value) {
        this.loginInfosAJour = value;
    }

    /**
     * Gets the value of the nom property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNom() {
        return nom;
    }

    /**
     * Sets the value of the nom property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNom(String value) {
        this.nom = value;
    }

}
