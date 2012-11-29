
package gouv.education.apogee.commun.transverse.dto.etudiant.adressemajdto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gouv.education.apogee.commun.transverse.dto.etudiant.communemajdto.CommuneMajDTO;


/**
 * <p>Java class for AdresseMajDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AdresseMajDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codPays" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="commune" type="{CommuneMajDTO.etudiant.dto.transverse.commun.apogee.education.gouv}CommuneMajDTO"/>
 *         &lt;element name="libAd1" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libAd2" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libAd3" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libAde" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="numTel" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AdresseMajDTO", propOrder = {
    "codPays",
    "commune",
    "libAd1",
    "libAd2",
    "libAd3",
    "libAde",
    "numTel"
})
public class AdresseMajDTO {

    @XmlElement(required = true, nillable = true)
    protected String codPays;
    @XmlElement(required = true, nillable = true)
    protected CommuneMajDTO commune;
    @XmlElement(required = true, nillable = true)
    protected String libAd1;
    @XmlElement(required = true, nillable = true)
    protected String libAd2;
    @XmlElement(required = true, nillable = true)
    protected String libAd3;
    @XmlElement(required = true, nillable = true)
    protected String libAde;
    @XmlElement(required = true, nillable = true)
    protected String numTel;

    /**
     * Gets the value of the codPays property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodPays() {
        return codPays;
    }

    /**
     * Sets the value of the codPays property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodPays(String value) {
        this.codPays = value;
    }

    /**
     * Gets the value of the commune property.
     * 
     * @return
     *     possible object is
     *     {@link CommuneMajDTO }
     *     
     */
    public CommuneMajDTO getCommune() {
        return commune;
    }

    /**
     * Sets the value of the commune property.
     * 
     * @param value
     *     allowed object is
     *     {@link CommuneMajDTO }
     *     
     */
    public void setCommune(CommuneMajDTO value) {
        this.commune = value;
    }

    /**
     * Gets the value of the libAd1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibAd1() {
        return libAd1;
    }

    /**
     * Sets the value of the libAd1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibAd1(String value) {
        this.libAd1 = value;
    }

    /**
     * Gets the value of the libAd2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibAd2() {
        return libAd2;
    }

    /**
     * Sets the value of the libAd2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibAd2(String value) {
        this.libAd2 = value;
    }

    /**
     * Gets the value of the libAd3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibAd3() {
        return libAd3;
    }

    /**
     * Sets the value of the libAd3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibAd3(String value) {
        this.libAd3 = value;
    }

    /**
     * Gets the value of the libAde property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibAde() {
        return libAde;
    }

    /**
     * Sets the value of the libAde property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibAde(String value) {
        this.libAde = value;
    }

    /**
     * Gets the value of the numTel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumTel() {
        return numTel;
    }

    /**
     * Sets the value of the numTel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumTel(String value) {
        this.numTel = value;
    }

}
