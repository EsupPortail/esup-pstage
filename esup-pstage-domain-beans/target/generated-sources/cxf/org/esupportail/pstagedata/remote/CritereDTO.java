
package org.esupportail.pstagedata.remote;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for critereDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="critereDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="clef" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idCritere" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="niveau" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="typeCategorie" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="valeur" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "critereDTO", propOrder = {
    "clef",
    "idCritere",
    "niveau",
    "typeCategorie",
    "valeur"
})
public class CritereDTO {

    protected String clef;
    protected Integer idCritere;
    protected Integer niveau;
    protected Integer typeCategorie;
    protected String valeur;

    /**
     * Gets the value of the clef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClef() {
        return clef;
    }

    /**
     * Sets the value of the clef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClef(String value) {
        this.clef = value;
    }

    /**
     * Gets the value of the idCritere property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdCritere() {
        return idCritere;
    }

    /**
     * Sets the value of the idCritere property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdCritere(Integer value) {
        this.idCritere = value;
    }

    /**
     * Gets the value of the niveau property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNiveau() {
        return niveau;
    }

    /**
     * Sets the value of the niveau property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNiveau(Integer value) {
        this.niveau = value;
    }

    /**
     * Gets the value of the typeCategorie property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTypeCategorie() {
        return typeCategorie;
    }

    /**
     * Sets the value of the typeCategorie property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTypeCategorie(Integer value) {
        this.typeCategorie = value;
    }

    /**
     * Gets the value of the valeur property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValeur() {
        return valeur;
    }

    /**
     * Sets the value of the valeur property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValeur(String value) {
        this.valeur = value;
    }

}
