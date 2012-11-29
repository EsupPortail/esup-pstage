
package gouv.education.apogee.commun.transverse.dto.etudiant.coordonneesmajdto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gouv.education.apogee.commun.transverse.dto.etudiant.adressemajdto.AdresseMajDTO;


/**
 * <p>Java class for CoordonneesMajDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CoordonneesMajDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="adresseAnnuelle" type="{AdresseMajDTO.etudiant.dto.transverse.commun.apogee.education.gouv}AdresseMajDTO"/>
 *         &lt;element name="adresseFixe" type="{AdresseMajDTO.etudiant.dto.transverse.commun.apogee.education.gouv}AdresseMajDTO"/>
 *         &lt;element name="annee" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="numTelPortable" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="typeHebergement" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CoordonneesMajDTO", propOrder = {
    "adresseAnnuelle",
    "adresseFixe",
    "annee",
    "email",
    "numTelPortable",
    "typeHebergement"
})
public class CoordonneesMajDTO {

    @XmlElement(required = true, nillable = true)
    protected AdresseMajDTO adresseAnnuelle;
    @XmlElement(required = true, nillable = true)
    protected AdresseMajDTO adresseFixe;
    @XmlElement(required = true, nillable = true)
    protected String annee;
    @XmlElement(required = true, nillable = true)
    protected String email;
    @XmlElement(required = true, nillable = true)
    protected String numTelPortable;
    @XmlElement(required = true, nillable = true)
    protected String typeHebergement;

    /**
     * Gets the value of the adresseAnnuelle property.
     * 
     * @return
     *     possible object is
     *     {@link AdresseMajDTO }
     *     
     */
    public AdresseMajDTO getAdresseAnnuelle() {
        return adresseAnnuelle;
    }

    /**
     * Sets the value of the adresseAnnuelle property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdresseMajDTO }
     *     
     */
    public void setAdresseAnnuelle(AdresseMajDTO value) {
        this.adresseAnnuelle = value;
    }

    /**
     * Gets the value of the adresseFixe property.
     * 
     * @return
     *     possible object is
     *     {@link AdresseMajDTO }
     *     
     */
    public AdresseMajDTO getAdresseFixe() {
        return adresseFixe;
    }

    /**
     * Sets the value of the adresseFixe property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdresseMajDTO }
     *     
     */
    public void setAdresseFixe(AdresseMajDTO value) {
        this.adresseFixe = value;
    }

    /**
     * Gets the value of the annee property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnnee() {
        return annee;
    }

    /**
     * Sets the value of the annee property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnnee(String value) {
        this.annee = value;
    }

    /**
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Gets the value of the numTelPortable property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumTelPortable() {
        return numTelPortable;
    }

    /**
     * Sets the value of the numTelPortable property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumTelPortable(String value) {
        this.numTelPortable = value;
    }

    /**
     * Gets the value of the typeHebergement property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypeHebergement() {
        return typeHebergement;
    }

    /**
     * Sets the value of the typeHebergement property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypeHebergement(String value) {
        this.typeHebergement = value;
    }

}
