
package org.esupportail.pstagedata.remote;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for critereRechercheStructureAdresseDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="critereRechercheStructureAdresseDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codePostal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="rechBatimentResidence" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="rechPays" type="{http://remote.pstagedata.esupportail.org/}paysDTO" minOccurs="0"/>
 *         &lt;element name="rechVille" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="rechVoie" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "critereRechercheStructureAdresseDTO", propOrder = {
    "codePostal",
    "rechBatimentResidence",
    "rechPays",
    "rechVille",
    "rechVoie"
})
public class CritereRechercheStructureAdresseDTO {

    protected String codePostal;
    protected String rechBatimentResidence;
    protected PaysDTO rechPays;
    protected String rechVille;
    protected String rechVoie;

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
     * Gets the value of the rechBatimentResidence property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRechBatimentResidence() {
        return rechBatimentResidence;
    }

    /**
     * Sets the value of the rechBatimentResidence property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRechBatimentResidence(String value) {
        this.rechBatimentResidence = value;
    }

    /**
     * Gets the value of the rechPays property.
     * 
     * @return
     *     possible object is
     *     {@link PaysDTO }
     *     
     */
    public PaysDTO getRechPays() {
        return rechPays;
    }

    /**
     * Sets the value of the rechPays property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaysDTO }
     *     
     */
    public void setRechPays(PaysDTO value) {
        this.rechPays = value;
    }

    /**
     * Gets the value of the rechVille property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRechVille() {
        return rechVille;
    }

    /**
     * Sets the value of the rechVille property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRechVille(String value) {
        this.rechVille = value;
    }

    /**
     * Gets the value of the rechVoie property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRechVoie() {
        return rechVoie;
    }

    /**
     * Sets the value of the rechVoie property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRechVoie(String value) {
        this.rechVoie = value;
    }

}
