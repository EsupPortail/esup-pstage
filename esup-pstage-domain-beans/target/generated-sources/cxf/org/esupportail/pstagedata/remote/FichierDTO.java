
package org.esupportail.pstagedata.remote;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for fichierDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="fichierDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idFichier" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nomFichier" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nomReel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "fichierDTO", propOrder = {
    "idFichier",
    "nomFichier",
    "nomReel"
})
public class FichierDTO {

    protected int idFichier;
    protected String nomFichier;
    protected String nomReel;

    /**
     * Gets the value of the idFichier property.
     * 
     */
    public int getIdFichier() {
        return idFichier;
    }

    /**
     * Sets the value of the idFichier property.
     * 
     */
    public void setIdFichier(int value) {
        this.idFichier = value;
    }

    /**
     * Gets the value of the nomFichier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomFichier() {
        return nomFichier;
    }

    /**
     * Sets the value of the nomFichier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomFichier(String value) {
        this.nomFichier = value;
    }

    /**
     * Gets the value of the nomReel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomReel() {
        return nomReel;
    }

    /**
     * Sets the value of the nomReel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomReel(String value) {
        this.nomReel = value;
    }

}
