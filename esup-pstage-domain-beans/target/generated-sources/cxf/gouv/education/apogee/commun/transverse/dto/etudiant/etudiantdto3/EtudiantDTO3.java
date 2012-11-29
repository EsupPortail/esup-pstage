
package gouv.education.apogee.commun.transverse.dto.etudiant.etudiantdto3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EtudiantDTO3 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EtudiantDTO3">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="civilite" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codEtu" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dateNaissance" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="listPeriodeExamen" type="{EtudiantDTO3.etudiant.dto.transverse.commun.apogee.education.gouv}TableauPeriodeExaDTO"/>
 *         &lt;element name="nom" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="prenom" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EtudiantDTO3", propOrder = {
    "civilite",
    "codEtu",
    "dateNaissance",
    "listPeriodeExamen",
    "nom",
    "prenom"
})
public class EtudiantDTO3 {

    @XmlElement(required = true, nillable = true)
    protected String civilite;
    @XmlElement(required = true, nillable = true)
    protected String codEtu;
    @XmlElement(required = true, nillable = true)
    protected String dateNaissance;
    @XmlElement(required = true, nillable = true)
    protected TableauPeriodeExaDTO listPeriodeExamen;
    @XmlElement(required = true, nillable = true)
    protected String nom;
    @XmlElement(required = true, nillable = true)
    protected String prenom;

    /**
     * Gets the value of the civilite property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCivilite() {
        return civilite;
    }

    /**
     * Sets the value of the civilite property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCivilite(String value) {
        this.civilite = value;
    }

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
     * Gets the value of the dateNaissance property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateNaissance() {
        return dateNaissance;
    }

    /**
     * Sets the value of the dateNaissance property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateNaissance(String value) {
        this.dateNaissance = value;
    }

    /**
     * Gets the value of the listPeriodeExamen property.
     * 
     * @return
     *     possible object is
     *     {@link TableauPeriodeExaDTO }
     *     
     */
    public TableauPeriodeExaDTO getListPeriodeExamen() {
        return listPeriodeExamen;
    }

    /**
     * Sets the value of the listPeriodeExamen property.
     * 
     * @param value
     *     allowed object is
     *     {@link TableauPeriodeExaDTO }
     *     
     */
    public void setListPeriodeExamen(TableauPeriodeExaDTO value) {
        this.listPeriodeExamen = value;
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

}
