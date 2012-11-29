
package org.esupportail.pstagedata.remote;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for nomenclatureIdDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="nomenclatureIdDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codeCtrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
@XmlType(name = "nomenclatureIdDTO", propOrder = {
    "codeCtrl",
    "id",
    "libelle",
    "temEnServ"
})
@XmlSeeAlso({
    PaysDTO.class,
    ModeCandidatureDTO.class,
    ThemeDTO.class,
    IndemnisationDTO.class,
    FapQualificationSimplifieeDTO.class,
    UniteDureeDTO.class,
    ModeValidationStageDTO.class,
    TypeStructureDTO.class,
    UniteGratificationDTO.class,
    DureeDiffusionDTO.class,
    NatureTravailDTO.class,
    CiviliteDTO.class,
    DroitAdministrationDTO.class,
    OrigineStageDTO.class,
    TypeOffreDTO.class,
    NomenclatureIdEnfantDTO.class,
    TypeConventionDTO.class,
    EffectifDTO.class,
    NiveauFormationDTO.class,
    AssuranceDTO.class,
    TempsTravailDTO.class,
    ModeVersGratificationDTO.class,
    NiveauCentreDTO.class
})
public class NomenclatureIdDTO {

    protected String codeCtrl;
    protected int id;
    protected String libelle;
    protected String temEnServ;

    /**
     * Gets the value of the codeCtrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeCtrl() {
        return codeCtrl;
    }

    /**
     * Sets the value of the codeCtrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeCtrl(String value) {
        this.codeCtrl = value;
    }

    /**
     * Gets the value of the id property.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(int value) {
        this.id = value;
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
