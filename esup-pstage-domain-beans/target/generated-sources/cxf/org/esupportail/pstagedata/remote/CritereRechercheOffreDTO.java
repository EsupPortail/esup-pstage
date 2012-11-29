
package org.esupportail.pstagedata.remote;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for critereRechercheOffreDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="critereRechercheOffreDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="anneeUniversitaire" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="contratOffre" type="{http://remote.pstagedata.esupportail.org/}contratOffreDTO" minOccurs="0"/>
 *         &lt;element name="diffusionTerminee" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="estAccessERQTH" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="estDiffusee" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="estFrance" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="estPrioERQTH" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="estSupprimee" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="fapN1" type="{http://remote.pstagedata.esupportail.org/}fapN1DTO" minOccurs="0"/>
 *         &lt;element name="fapN2" type="{http://remote.pstagedata.esupportail.org/}fapN2DTO" minOccurs="0"/>
 *         &lt;element name="fapN3" type="{http://remote.pstagedata.esupportail.org/}fapN3DTO" minOccurs="0"/>
 *         &lt;element name="fapQualificationSimplifiee" type="{http://remote.pstagedata.esupportail.org/}fapQualificationSimplifieeDTO" minOccurs="0"/>
 *         &lt;element name="idOffre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idsCentreGestion" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="inclureOffresEntreprise" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="intitule" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lieuCodesPostal" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="lieuCommune" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lieuPays" type="{http://remote.pstagedata.esupportail.org/}paysDTO" minOccurs="0"/>
 *         &lt;element name="motsCles" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nafN1" type="{http://remote.pstagedata.esupportail.org/}nafN1DTO" minOccurs="0"/>
 *         &lt;element name="niveauFormation" type="{http://remote.pstagedata.esupportail.org/}niveauFormationDTO" minOccurs="0"/>
 *         &lt;element name="typeOffre" type="{http://remote.pstagedata.esupportail.org/}typeOffreDTO" minOccurs="0"/>
 *         &lt;element name="typeStructure" type="{http://remote.pstagedata.esupportail.org/}typeStructureDTO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "critereRechercheOffreDTO", propOrder = {
    "anneeUniversitaire",
    "contratOffre",
    "diffusionTerminee",
    "estAccessERQTH",
    "estDiffusee",
    "estFrance",
    "estPrioERQTH",
    "estSupprimee",
    "fapN1",
    "fapN2",
    "fapN3",
    "fapQualificationSimplifiee",
    "idOffre",
    "idsCentreGestion",
    "inclureOffresEntreprise",
    "intitule",
    "lieuCodesPostal",
    "lieuCommune",
    "lieuPays",
    "motsCles",
    "nafN1",
    "niveauFormation",
    "typeOffre",
    "typeStructure"
})
public class CritereRechercheOffreDTO {

    protected String anneeUniversitaire;
    protected ContratOffreDTO contratOffre;
    protected boolean diffusionTerminee;
    protected boolean estAccessERQTH;
    protected boolean estDiffusee;
    protected boolean estFrance;
    protected boolean estPrioERQTH;
    protected boolean estSupprimee;
    protected FapN1DTO fapN1;
    protected FapN2DTO fapN2;
    protected FapN3DTO fapN3;
    protected FapQualificationSimplifieeDTO fapQualificationSimplifiee;
    protected String idOffre;
    @XmlElement(nillable = true)
    protected List<Integer> idsCentreGestion;
    protected boolean inclureOffresEntreprise;
    protected String intitule;
    @XmlElement(nillable = true)
    protected List<String> lieuCodesPostal;
    protected String lieuCommune;
    protected PaysDTO lieuPays;
    protected String motsCles;
    protected NafN1DTO nafN1;
    protected NiveauFormationDTO niveauFormation;
    protected TypeOffreDTO typeOffre;
    protected TypeStructureDTO typeStructure;

    /**
     * Gets the value of the anneeUniversitaire property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnneeUniversitaire() {
        return anneeUniversitaire;
    }

    /**
     * Sets the value of the anneeUniversitaire property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnneeUniversitaire(String value) {
        this.anneeUniversitaire = value;
    }

    /**
     * Gets the value of the contratOffre property.
     * 
     * @return
     *     possible object is
     *     {@link ContratOffreDTO }
     *     
     */
    public ContratOffreDTO getContratOffre() {
        return contratOffre;
    }

    /**
     * Sets the value of the contratOffre property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContratOffreDTO }
     *     
     */
    public void setContratOffre(ContratOffreDTO value) {
        this.contratOffre = value;
    }

    /**
     * Gets the value of the diffusionTerminee property.
     * 
     */
    public boolean isDiffusionTerminee() {
        return diffusionTerminee;
    }

    /**
     * Sets the value of the diffusionTerminee property.
     * 
     */
    public void setDiffusionTerminee(boolean value) {
        this.diffusionTerminee = value;
    }

    /**
     * Gets the value of the estAccessERQTH property.
     * 
     */
    public boolean isEstAccessERQTH() {
        return estAccessERQTH;
    }

    /**
     * Sets the value of the estAccessERQTH property.
     * 
     */
    public void setEstAccessERQTH(boolean value) {
        this.estAccessERQTH = value;
    }

    /**
     * Gets the value of the estDiffusee property.
     * 
     */
    public boolean isEstDiffusee() {
        return estDiffusee;
    }

    /**
     * Sets the value of the estDiffusee property.
     * 
     */
    public void setEstDiffusee(boolean value) {
        this.estDiffusee = value;
    }

    /**
     * Gets the value of the estFrance property.
     * 
     */
    public boolean isEstFrance() {
        return estFrance;
    }

    /**
     * Sets the value of the estFrance property.
     * 
     */
    public void setEstFrance(boolean value) {
        this.estFrance = value;
    }

    /**
     * Gets the value of the estPrioERQTH property.
     * 
     */
    public boolean isEstPrioERQTH() {
        return estPrioERQTH;
    }

    /**
     * Sets the value of the estPrioERQTH property.
     * 
     */
    public void setEstPrioERQTH(boolean value) {
        this.estPrioERQTH = value;
    }

    /**
     * Gets the value of the estSupprimee property.
     * 
     */
    public boolean isEstSupprimee() {
        return estSupprimee;
    }

    /**
     * Sets the value of the estSupprimee property.
     * 
     */
    public void setEstSupprimee(boolean value) {
        this.estSupprimee = value;
    }

    /**
     * Gets the value of the fapN1 property.
     * 
     * @return
     *     possible object is
     *     {@link FapN1DTO }
     *     
     */
    public FapN1DTO getFapN1() {
        return fapN1;
    }

    /**
     * Sets the value of the fapN1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link FapN1DTO }
     *     
     */
    public void setFapN1(FapN1DTO value) {
        this.fapN1 = value;
    }

    /**
     * Gets the value of the fapN2 property.
     * 
     * @return
     *     possible object is
     *     {@link FapN2DTO }
     *     
     */
    public FapN2DTO getFapN2() {
        return fapN2;
    }

    /**
     * Sets the value of the fapN2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link FapN2DTO }
     *     
     */
    public void setFapN2(FapN2DTO value) {
        this.fapN2 = value;
    }

    /**
     * Gets the value of the fapN3 property.
     * 
     * @return
     *     possible object is
     *     {@link FapN3DTO }
     *     
     */
    public FapN3DTO getFapN3() {
        return fapN3;
    }

    /**
     * Sets the value of the fapN3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link FapN3DTO }
     *     
     */
    public void setFapN3(FapN3DTO value) {
        this.fapN3 = value;
    }

    /**
     * Gets the value of the fapQualificationSimplifiee property.
     * 
     * @return
     *     possible object is
     *     {@link FapQualificationSimplifieeDTO }
     *     
     */
    public FapQualificationSimplifieeDTO getFapQualificationSimplifiee() {
        return fapQualificationSimplifiee;
    }

    /**
     * Sets the value of the fapQualificationSimplifiee property.
     * 
     * @param value
     *     allowed object is
     *     {@link FapQualificationSimplifieeDTO }
     *     
     */
    public void setFapQualificationSimplifiee(FapQualificationSimplifieeDTO value) {
        this.fapQualificationSimplifiee = value;
    }

    /**
     * Gets the value of the idOffre property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdOffre() {
        return idOffre;
    }

    /**
     * Sets the value of the idOffre property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdOffre(String value) {
        this.idOffre = value;
    }

    /**
     * Gets the value of the idsCentreGestion property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the idsCentreGestion property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIdsCentreGestion().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Integer }
     * 
     * 
     */
    public List<Integer> getIdsCentreGestion() {
        if (idsCentreGestion == null) {
            idsCentreGestion = new ArrayList<Integer>();
        }
        return this.idsCentreGestion;
    }

    /**
     * Gets the value of the inclureOffresEntreprise property.
     * 
     */
    public boolean isInclureOffresEntreprise() {
        return inclureOffresEntreprise;
    }

    /**
     * Sets the value of the inclureOffresEntreprise property.
     * 
     */
    public void setInclureOffresEntreprise(boolean value) {
        this.inclureOffresEntreprise = value;
    }

    /**
     * Gets the value of the intitule property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIntitule() {
        return intitule;
    }

    /**
     * Sets the value of the intitule property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIntitule(String value) {
        this.intitule = value;
    }

    /**
     * Gets the value of the lieuCodesPostal property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the lieuCodesPostal property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLieuCodesPostal().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getLieuCodesPostal() {
        if (lieuCodesPostal == null) {
            lieuCodesPostal = new ArrayList<String>();
        }
        return this.lieuCodesPostal;
    }

    /**
     * Gets the value of the lieuCommune property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLieuCommune() {
        return lieuCommune;
    }

    /**
     * Sets the value of the lieuCommune property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLieuCommune(String value) {
        this.lieuCommune = value;
    }

    /**
     * Gets the value of the lieuPays property.
     * 
     * @return
     *     possible object is
     *     {@link PaysDTO }
     *     
     */
    public PaysDTO getLieuPays() {
        return lieuPays;
    }

    /**
     * Sets the value of the lieuPays property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaysDTO }
     *     
     */
    public void setLieuPays(PaysDTO value) {
        this.lieuPays = value;
    }

    /**
     * Gets the value of the motsCles property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMotsCles() {
        return motsCles;
    }

    /**
     * Sets the value of the motsCles property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMotsCles(String value) {
        this.motsCles = value;
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
     * Gets the value of the niveauFormation property.
     * 
     * @return
     *     possible object is
     *     {@link NiveauFormationDTO }
     *     
     */
    public NiveauFormationDTO getNiveauFormation() {
        return niveauFormation;
    }

    /**
     * Sets the value of the niveauFormation property.
     * 
     * @param value
     *     allowed object is
     *     {@link NiveauFormationDTO }
     *     
     */
    public void setNiveauFormation(NiveauFormationDTO value) {
        this.niveauFormation = value;
    }

    /**
     * Gets the value of the typeOffre property.
     * 
     * @return
     *     possible object is
     *     {@link TypeOffreDTO }
     *     
     */
    public TypeOffreDTO getTypeOffre() {
        return typeOffre;
    }

    /**
     * Sets the value of the typeOffre property.
     * 
     * @param value
     *     allowed object is
     *     {@link TypeOffreDTO }
     *     
     */
    public void setTypeOffre(TypeOffreDTO value) {
        this.typeOffre = value;
    }

    /**
     * Gets the value of the typeStructure property.
     * 
     * @return
     *     possible object is
     *     {@link TypeStructureDTO }
     *     
     */
    public TypeStructureDTO getTypeStructure() {
        return typeStructure;
    }

    /**
     * Sets the value of the typeStructure property.
     * 
     * @param value
     *     allowed object is
     *     {@link TypeStructureDTO }
     *     
     */
    public void setTypeStructure(TypeStructureDTO value) {
        this.typeStructure = value;
    }

}
