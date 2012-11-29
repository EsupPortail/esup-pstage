
package org.esupportail.pstagedata.remote;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for contactDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="contactDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://remote.pstagedata.esupportail.org/}personneDTO">
 *       &lt;sequence>
 *         &lt;element name="centreGestion" type="{http://remote.pstagedata.esupportail.org/}centreGestionDTO" minOccurs="0"/>
 *         &lt;element name="commentaire" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fonction" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idAccordPartenariat" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idCentreGestion" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idService" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="infosAJour" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="login" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="loginInfosAJour" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mdp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="service" type="{http://remote.pstagedata.esupportail.org/}serviceDTO" minOccurs="0"/>
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
@XmlType(name = "contactDTO", propOrder = {
    "centreGestion",
    "commentaire",
    "fonction",
    "idAccordPartenariat",
    "idCentreGestion",
    "idService",
    "infosAJour",
    "login",
    "loginInfosAJour",
    "mdp",
    "service",
    "structure"
})
public class ContactDTO
    extends PersonneDTO
{

    protected CentreGestionDTO centreGestion;
    protected String commentaire;
    protected String fonction;
    protected int idAccordPartenariat;
    protected int idCentreGestion;
    protected int idService;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar infosAJour;
    protected String login;
    protected String loginInfosAJour;
    protected String mdp;
    protected ServiceDTO service;
    protected StructureDTO structure;

    /**
     * Gets the value of the centreGestion property.
     * 
     * @return
     *     possible object is
     *     {@link CentreGestionDTO }
     *     
     */
    public CentreGestionDTO getCentreGestion() {
        return centreGestion;
    }

    /**
     * Sets the value of the centreGestion property.
     * 
     * @param value
     *     allowed object is
     *     {@link CentreGestionDTO }
     *     
     */
    public void setCentreGestion(CentreGestionDTO value) {
        this.centreGestion = value;
    }

    /**
     * Gets the value of the commentaire property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommentaire() {
        return commentaire;
    }

    /**
     * Sets the value of the commentaire property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommentaire(String value) {
        this.commentaire = value;
    }

    /**
     * Gets the value of the fonction property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFonction() {
        return fonction;
    }

    /**
     * Sets the value of the fonction property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFonction(String value) {
        this.fonction = value;
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
     * Gets the value of the idCentreGestion property.
     * 
     */
    public int getIdCentreGestion() {
        return idCentreGestion;
    }

    /**
     * Sets the value of the idCentreGestion property.
     * 
     */
    public void setIdCentreGestion(int value) {
        this.idCentreGestion = value;
    }

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
     * Gets the value of the login property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLogin() {
        return login;
    }

    /**
     * Sets the value of the login property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLogin(String value) {
        this.login = value;
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
     * Gets the value of the mdp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMdp() {
        return mdp;
    }

    /**
     * Sets the value of the mdp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMdp(String value) {
        this.mdp = value;
    }

    /**
     * Gets the value of the service property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceDTO }
     *     
     */
    public ServiceDTO getService() {
        return service;
    }

    /**
     * Sets the value of the service property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceDTO }
     *     
     */
    public void setService(ServiceDTO value) {
        this.service = value;
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
