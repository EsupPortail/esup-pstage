
package org.esupportail.pstagedata.remote;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for accordPartenariatDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="accordPartenariatDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://remote.pstagedata.esupportail.org/}objetMetiersDTO">
 *       &lt;sequence>
 *         &lt;element name="comptesSupprimes" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="contact" type="{http://remote.pstagedata.esupportail.org/}contactDTO" minOccurs="0"/>
 *         &lt;element name="dateSuppressionComptes" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="dateValidation" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="estValide" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="idAccordPartenariat" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idContact" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idStructure" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="loginSuppressionComptes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="loginValidation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="raisonSuppressionComptes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="structure" type="{http://remote.pstagedata.esupportail.org/}structureDTO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "accordPartenariatDTO", propOrder = {
    "comptesSupprimes",
    "contact",
    "dateSuppressionComptes",
    "dateValidation",
    "estValide",
    "idAccordPartenariat",
    "idContact",
    "idStructure",
    "loginSuppressionComptes",
    "loginValidation",
    "raisonSuppressionComptes",
    "structure"
})
public class AccordPartenariatDTO
    extends ObjetMetiersDTO
{

    protected boolean comptesSupprimes;
    protected ContactDTO contact;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateSuppressionComptes;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateValidation;
    protected boolean estValide;
    protected int idAccordPartenariat;
    protected int idContact;
    protected int idStructure;
    protected String loginSuppressionComptes;
    protected String loginValidation;
    protected String raisonSuppressionComptes;
    protected StructureDTO structure;

    /**
     * Gets the value of the comptesSupprimes property.
     * 
     */
    public boolean isComptesSupprimes() {
        return comptesSupprimes;
    }

    /**
     * Sets the value of the comptesSupprimes property.
     * 
     */
    public void setComptesSupprimes(boolean value) {
        this.comptesSupprimes = value;
    }

    /**
     * Gets the value of the contact property.
     * 
     * @return
     *     possible object is
     *     {@link ContactDTO }
     *     
     */
    public ContactDTO getContact() {
        return contact;
    }

    /**
     * Sets the value of the contact property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContactDTO }
     *     
     */
    public void setContact(ContactDTO value) {
        this.contact = value;
    }

    /**
     * Gets the value of the dateSuppressionComptes property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateSuppressionComptes() {
        return dateSuppressionComptes;
    }

    /**
     * Sets the value of the dateSuppressionComptes property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateSuppressionComptes(XMLGregorianCalendar value) {
        this.dateSuppressionComptes = value;
    }

    /**
     * Gets the value of the dateValidation property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateValidation() {
        return dateValidation;
    }

    /**
     * Sets the value of the dateValidation property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateValidation(XMLGregorianCalendar value) {
        this.dateValidation = value;
    }

    /**
     * Gets the value of the estValide property.
     * 
     */
    public boolean isEstValide() {
        return estValide;
    }

    /**
     * Sets the value of the estValide property.
     * 
     */
    public void setEstValide(boolean value) {
        this.estValide = value;
    }

    /**
     * Gets the value of the idAccordPartenariat property.
     * 
     */
    public int getIdAccordPartenariat() {
        return idAccordPartenariat;
    }

    /**
     * Sets the value of the idAccordPartenariat property.
     * 
     */
    public void setIdAccordPartenariat(int value) {
        this.idAccordPartenariat = value;
    }

    /**
     * Gets the value of the idContact property.
     * 
     */
    public int getIdContact() {
        return idContact;
    }

    /**
     * Sets the value of the idContact property.
     * 
     */
    public void setIdContact(int value) {
        this.idContact = value;
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
     * Gets the value of the loginSuppressionComptes property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoginSuppressionComptes() {
        return loginSuppressionComptes;
    }

    /**
     * Sets the value of the loginSuppressionComptes property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoginSuppressionComptes(String value) {
        this.loginSuppressionComptes = value;
    }

    /**
     * Gets the value of the loginValidation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoginValidation() {
        return loginValidation;
    }

    /**
     * Sets the value of the loginValidation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoginValidation(String value) {
        this.loginValidation = value;
    }

    /**
     * Gets the value of the raisonSuppressionComptes property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRaisonSuppressionComptes() {
        return raisonSuppressionComptes;
    }

    /**
     * Sets the value of the raisonSuppressionComptes property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRaisonSuppressionComptes(String value) {
        this.raisonSuppressionComptes = value;
    }

    /**
     * Gets the value of the structure property.
     * 
     * @return
     *     possible object is
     *     {@link StructureDTO }
     *     
     */
    public StructureDTO getStructure() {
        return structure;
    }

    /**
     * Sets the value of the structure property.
     * 
     * @param value
     *     allowed object is
     *     {@link StructureDTO }
     *     
     */
    public void setStructure(StructureDTO value) {
        this.structure = value;
    }

}
