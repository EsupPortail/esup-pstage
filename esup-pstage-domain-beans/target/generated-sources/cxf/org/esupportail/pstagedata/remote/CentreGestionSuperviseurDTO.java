
package org.esupportail.pstagedata.remote;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for centreGestionSuperviseurDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="centreGestionSuperviseurDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://remote.pstagedata.esupportail.org/}adresseDTO">
 *       &lt;sequence>
 *         &lt;element name="idCentreGestionSuperviseur" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nomCentreGestionSuperviseur" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "centreGestionSuperviseurDTO", propOrder = {
    "idCentreGestionSuperviseur",
    "nomCentreGestionSuperviseur"
})
public class CentreGestionSuperviseurDTO
    extends AdresseDTO
{

    protected int idCentreGestionSuperviseur;
    protected String nomCentreGestionSuperviseur;

    /**
     * Gets the value of the idCentreGestionSuperviseur property.
     * 
     */
    public int getIdCentreGestionSuperviseur() {
        return idCentreGestionSuperviseur;
    }

    /**
     * Sets the value of the idCentreGestionSuperviseur property.
     * 
     */
    public void setIdCentreGestionSuperviseur(int value) {
        this.idCentreGestionSuperviseur = value;
    }

    /**
     * Gets the value of the nomCentreGestionSuperviseur property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomCentreGestionSuperviseur() {
        return nomCentreGestionSuperviseur;
    }

    /**
     * Sets the value of the nomCentreGestionSuperviseur property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomCentreGestionSuperviseur(String value) {
        this.nomCentreGestionSuperviseur = value;
    }

}
