
package org.esupportail.pstagedata.remote;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for offreDiffusionDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="offreDiffusionDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://remote.pstagedata.esupportail.org/}objetMetiersDTO">
 *       &lt;sequence>
 *         &lt;element name="estMiseEnAvant" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="idCentreGestion" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="idOffre" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="nomCentre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "offreDiffusionDTO", propOrder = {
    "estMiseEnAvant",
    "idCentreGestion",
    "idOffre",
    "nomCentre"
})
public class OffreDiffusionDTO
    extends ObjetMetiersDTO
{

    protected boolean estMiseEnAvant;
    protected Integer idCentreGestion;
    protected Integer idOffre;
    protected String nomCentre;

    /**
     * Gets the value of the estMiseEnAvant property.
     * 
     */
    public boolean isEstMiseEnAvant() {
        return estMiseEnAvant;
    }

    /**
     * Sets the value of the estMiseEnAvant property.
     * 
     */
    public void setEstMiseEnAvant(boolean value) {
        this.estMiseEnAvant = value;
    }

    /**
     * Gets the value of the idCentreGestion property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdCentreGestion() {
        return idCentreGestion;
    }

    /**
     * Sets the value of the idCentreGestion property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdCentreGestion(Integer value) {
        this.idCentreGestion = value;
    }

    /**
     * Gets the value of the idOffre property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdOffre() {
        return idOffre;
    }

    /**
     * Sets the value of the idOffre property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdOffre(Integer value) {
        this.idOffre = value;
    }

    /**
     * Gets the value of the nomCentre property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomCentre() {
        return nomCentre;
    }

    /**
     * Sets the value of the nomCentre property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomCentre(String value) {
        this.nomCentre = value;
    }

}
