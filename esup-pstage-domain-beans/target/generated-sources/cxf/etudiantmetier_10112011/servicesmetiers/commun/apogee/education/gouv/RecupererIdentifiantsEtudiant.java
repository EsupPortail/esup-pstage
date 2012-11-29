
package etudiantmetier_10112011.servicesmetiers.commun.apogee.education.gouv;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="_codEtu" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="_codInd" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="_numINE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="_cleINE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="_numBoursier" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="_codOPI" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="_nom" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="_prenom" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="_dateNaiss" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="_temoinRecupAnnu" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "codEtu",
    "codInd",
    "numINE",
    "cleINE",
    "numBoursier",
    "codOPI",
    "nom",
    "prenom",
    "dateNaiss",
    "temoinRecupAnnu"
})
@XmlRootElement(name = "recupererIdentifiantsEtudiant")
public class RecupererIdentifiantsEtudiant {

    @XmlElement(name = "_codEtu", required = true)
    protected String codEtu;
    @XmlElement(name = "_codInd", required = true)
    protected String codInd;
    @XmlElement(name = "_numINE", required = true)
    protected String numINE;
    @XmlElement(name = "_cleINE", required = true)
    protected String cleINE;
    @XmlElement(name = "_numBoursier", required = true)
    protected String numBoursier;
    @XmlElement(name = "_codOPI", required = true)
    protected String codOPI;
    @XmlElement(name = "_nom", required = true)
    protected String nom;
    @XmlElement(name = "_prenom", required = true)
    protected String prenom;
    @XmlElement(name = "_dateNaiss", required = true)
    protected String dateNaiss;
    @XmlElement(name = "_temoinRecupAnnu", required = true)
    protected String temoinRecupAnnu;

    /**
     * Gets the value of the codEtu property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodEtu() {
        return codEtu;
    }

    /**
     * Sets the value of the codEtu property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodEtu(String value) {
        this.codEtu = value;
    }

    /**
     * Gets the value of the codInd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodInd() {
        return codInd;
    }

    /**
     * Sets the value of the codInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodInd(String value) {
        this.codInd = value;
    }

    /**
     * Gets the value of the numINE property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumINE() {
        return numINE;
    }

    /**
     * Sets the value of the numINE property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumINE(String value) {
        this.numINE = value;
    }

    /**
     * Gets the value of the cleINE property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCleINE() {
        return cleINE;
    }

    /**
     * Sets the value of the cleINE property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCleINE(String value) {
        this.cleINE = value;
    }

    /**
     * Gets the value of the numBoursier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumBoursier() {
        return numBoursier;
    }

    /**
     * Sets the value of the numBoursier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumBoursier(String value) {
        this.numBoursier = value;
    }

    /**
     * Gets the value of the codOPI property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodOPI() {
        return codOPI;
    }

    /**
     * Sets the value of the codOPI property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodOPI(String value) {
        this.codOPI = value;
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

    /**
     * Gets the value of the prenom property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Sets the value of the prenom property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrenom(String value) {
        this.prenom = value;
    }

    /**
     * Gets the value of the dateNaiss property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateNaiss() {
        return dateNaiss;
    }

    /**
     * Sets the value of the dateNaiss property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateNaiss(String value) {
        this.dateNaiss = value;
    }

    /**
     * Gets the value of the temoinRecupAnnu property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemoinRecupAnnu() {
        return temoinRecupAnnu;
    }

    /**
     * Sets the value of the temoinRecupAnnu property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemoinRecupAnnu(String value) {
        this.temoinRecupAnnu = value;
    }

}
