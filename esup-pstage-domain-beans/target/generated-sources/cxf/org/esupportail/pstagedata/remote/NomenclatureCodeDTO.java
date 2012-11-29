
package org.esupportail.pstagedata.remote;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for nomenclatureCodeDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="nomenclatureCodeDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="libelle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="temEnServ" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "nomenclatureCodeDTO", propOrder = {
    "code",
    "libelle",
    "temEnServ"
})
@XmlSeeAlso({
    UfrDTO.class,
    ConfidentialiteDTO.class,
    CritereGestionDTO.class,
    LangueConventionDTO.class,
    AffectationDTO.class,
    FapN1DTO.class,
    NafN1DTO.class,
    CaisseRegimeDTO.class,
    EtapeDTO.class,
    NomenclatureCodeEnfantDTO.class
})
public class NomenclatureCodeDTO {

    protected String code;
    protected String libelle;
    protected String temEnServ;

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * Gets the value of the libelle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibelle() {
        return libelle;
    }

    /**
     * Sets the value of the libelle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibelle(String value) {
        this.libelle = value;
    }

    /**
     * Gets the value of the temEnServ property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemEnServ() {
        return temEnServ;
    }

    /**
     * Sets the value of the temEnServ property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemEnServ(String value) {
        this.temEnServ = value;
    }

}
