
package org.esupportail.wssi.services.remote;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for critereAnneeUniDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="critereAnneeUniDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="etatIAE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="etatIPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="etatRES" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "critereAnneeUniDTO", propOrder = {
    "etatIAE",
    "etatIPE",
    "etatRES"
})
public class CritereAnneeUniDTO {

    protected String etatIAE;
    protected String etatIPE;
    protected String etatRES;

    /**
     * Gets the value of the etatIAE property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEtatIAE() {
        return etatIAE;
    }

    /**
     * Sets the value of the etatIAE property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEtatIAE(String value) {
        this.etatIAE = value;
    }

    /**
     * Gets the value of the etatIPE property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEtatIPE() {
        return etatIPE;
    }

    /**
     * Sets the value of the etatIPE property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEtatIPE(String value) {
        this.etatIPE = value;
    }

    /**
     * Gets the value of the etatRES property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEtatRES() {
        return etatRES;
    }

    /**
     * Sets the value of the etatRES property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEtatRES(String value) {
        this.etatRES = value;
    }

}
