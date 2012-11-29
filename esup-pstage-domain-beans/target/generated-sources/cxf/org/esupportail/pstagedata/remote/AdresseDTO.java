
package org.esupportail.pstagedata.remote;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for adresseDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="adresseDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://remote.pstagedata.esupportail.org/}objetMetiersDTO">
 *       &lt;sequence>
 *         &lt;element name="batimentResidence" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codeCommune" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="codePostal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="commune" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idPays" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="libCedex" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pays" type="{http://remote.pstagedata.esupportail.org/}paysDTO" minOccurs="0"/>
 *         &lt;element name="voie" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "adresseDTO", propOrder = {
    "batimentResidence",
    "codeCommune",
    "codePostal",
    "commune",
    "idPays",
    "libCedex",
    "pays",
    "voie"
})
@XmlSeeAlso({
    CentreGestionDTO.class,
    ServiceDTO.class,
    CentreGestionSuperviseurDTO.class,
    StructureDTO.class
})
public class AdresseDTO
    extends ObjetMetiersDTO
{

    protected String batimentResidence;
    protected int codeCommune;
    protected String codePostal;
    protected String commune;
    protected int idPays;
    protected String libCedex;
    protected PaysDTO pays;
    protected String voie;

    /**
     * Gets the value of the batimentResidence property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBatimentResidence() {
        return batimentResidence;
    }

    /**
     * Sets the value of the batimentResidence property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBatimentResidence(String value) {
        this.batimentResidence = value;
    }

    /**
     * Gets the value of the codeCommune property.
     * 
     */
    public int getCodeCommune() {
        return codeCommune;
    }

    /**
     * Sets the value of the codeCommune property.
     * 
     */
    public void setCodeCommune(int value) {
        this.codeCommune = value;
    }

    /**
     * Gets the value of the codePostal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodePostal() {
        return codePostal;
    }

    /**
     * Sets the value of the codePostal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodePostal(String value) {
        this.codePostal = value;
    }

    /**
     * Gets the value of the commune property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommune() {
        return commune;
    }

    /**
     * Sets the value of the commune property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommune(String value) {
        this.commune = value;
    }

    /**
     * Gets the value of the idPays property.
     * 
     */
    public int getIdPays() {
        return idPays;
    }

    /**
     * Sets the value of the idPays property.
     * 
     */
    public void setIdPays(int value) {
        this.idPays = value;
    }

    /**
     * Gets the value of the libCedex property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibCedex() {
        return libCedex;
    }

    /**
     * Sets the value of the libCedex property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibCedex(String value) {
        this.libCedex = value;
    }

    /**
     * Gets the value of the pays property.
     * 
     * @return
     *     possible object is
     *     {@link PaysDTO }
     *     
     */
    public PaysDTO getPays() {
        return pays;
    }

    /**
     * Sets the value of the pays property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaysDTO }
     *     
     */
    public void setPays(PaysDTO value) {
        this.pays = value;
    }

    /**
     * Gets the value of the voie property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVoie() {
        return voie;
    }

    /**
     * Sets the value of the voie property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVoie(String value) {
        this.voie = value;
    }

}
