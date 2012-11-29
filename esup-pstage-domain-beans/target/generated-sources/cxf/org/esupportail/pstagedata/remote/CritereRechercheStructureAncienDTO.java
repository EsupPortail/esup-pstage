
package org.esupportail.pstagedata.remote;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for critereRechercheStructureAncienDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="critereRechercheStructureAncienDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codePostal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="departement" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nafN1" type="{http://remote.pstagedata.esupportail.org/}nafN1DTO" minOccurs="0"/>
 *         &lt;element name="nafN5" type="{http://remote.pstagedata.esupportail.org/}nafN5DTO" minOccurs="0"/>
 *         &lt;element name="numeroSiret" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="raisonSociale" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "critereRechercheStructureAncienDTO", propOrder = {
    "codePostal",
    "departement",
    "nafN1",
    "nafN5",
    "numeroSiret",
    "raisonSociale"
})
public class CritereRechercheStructureAncienDTO {

    protected String codePostal;
    protected String departement;
    protected NafN1DTO nafN1;
    protected NafN5DTO nafN5;
    protected String numeroSiret;
    protected String raisonSociale;

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
     * Gets the value of the departement property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepartement() {
        return departement;
    }

    /**
     * Sets the value of the departement property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepartement(String value) {
        this.departement = value;
    }

    /**
     * Gets the value of the nafN1 property.
     * 
     * @return
     *     possible object is
     *     {@link NafN1DTO }
     *     
     */
    public NafN1DTO getNafN1() {
        return nafN1;
    }

    /**
     * Sets the value of the nafN1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link NafN1DTO }
     *     
     */
    public void setNafN1(NafN1DTO value) {
        this.nafN1 = value;
    }

    /**
     * Gets the value of the nafN5 property.
     * 
     * @return
     *     possible object is
     *     {@link NafN5DTO }
     *     
     */
    public NafN5DTO getNafN5() {
        return nafN5;
    }

    /**
     * Sets the value of the nafN5 property.
     * 
     * @param value
     *     allowed object is
     *     {@link NafN5DTO }
     *     
     */
    public void setNafN5(NafN5DTO value) {
        this.nafN5 = value;
    }

    /**
     * Gets the value of the numeroSiret property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroSiret() {
        return numeroSiret;
    }

    /**
     * Sets the value of the numeroSiret property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroSiret(String value) {
        this.numeroSiret = value;
    }

    /**
     * Gets the value of the raisonSociale property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRaisonSociale() {
        return raisonSociale;
    }

    /**
     * Sets the value of the raisonSociale property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRaisonSociale(String value) {
        this.raisonSociale = value;
    }

}
