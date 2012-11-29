
package org.esupportail.pstagedata.remote;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for critereRechercheConventionDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="critereRechercheConventionDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="anneeUniversitaire" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codePostal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="commune" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dateStage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="effectif" type="{http://remote.pstagedata.esupportail.org/}effectifDTO" minOccurs="0"/>
 *         &lt;element name="estValidee" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="idConvention" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idOffre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idsCentreGestion" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="idsEtapes" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="idsUfrs" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="indemnisation" type="{http://remote.pstagedata.esupportail.org/}indemnisationDTO" minOccurs="0"/>
 *         &lt;element name="langueConvention" type="{http://remote.pstagedata.esupportail.org/}langueConventionDTO" minOccurs="0"/>
 *         &lt;element name="limit" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="nafN1" type="{http://remote.pstagedata.esupportail.org/}nafN1DTO" minOccurs="0"/>
 *         &lt;element name="nbExportMaxi" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nbJoursHebdo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nbRechercheMaxi" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nomEnseignant" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nomEtudiant" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numeroEtudiant" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numeroSiret" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pays" type="{http://remote.pstagedata.esupportail.org/}paysDTO" minOccurs="0"/>
 *         &lt;element name="prenomEnseignant" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="prenomEtudiant" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="raisonSociale" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="statutJuridique" type="{http://remote.pstagedata.esupportail.org/}statutJuridiqueDTO" minOccurs="0"/>
 *         &lt;element name="sujetStage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tempsTravail" type="{http://remote.pstagedata.esupportail.org/}tempsTravailDTO" minOccurs="0"/>
 *         &lt;element name="theme" type="{http://remote.pstagedata.esupportail.org/}themeDTO" minOccurs="0"/>
 *         &lt;element name="typeConvention" type="{http://remote.pstagedata.esupportail.org/}typeConventionDTO" minOccurs="0"/>
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
@XmlType(name = "critereRechercheConventionDTO", propOrder = {
    "anneeUniversitaire",
    "codePostal",
    "commune",
    "dateStage",
    "effectif",
    "estValidee",
    "idConvention",
    "idOffre",
    "idsCentreGestion",
    "idsEtapes",
    "idsUfrs",
    "indemnisation",
    "langueConvention",
    "limit",
    "nafN1",
    "nbExportMaxi",
    "nbJoursHebdo",
    "nbRechercheMaxi",
    "nomEnseignant",
    "nomEtudiant",
    "numeroEtudiant",
    "numeroSiret",
    "pays",
    "prenomEnseignant",
    "prenomEtudiant",
    "raisonSociale",
    "statutJuridique",
    "sujetStage",
    "tempsTravail",
    "theme",
    "typeConvention",
    "typeStructure"
})
public class CritereRechercheConventionDTO {

    protected String anneeUniversitaire;
    protected String codePostal;
    protected String commune;
    protected String dateStage;
    protected EffectifDTO effectif;
    protected Boolean estValidee;
    protected String idConvention;
    protected String idOffre;
    @XmlElement(nillable = true)
    protected List<Integer> idsCentreGestion;
    @XmlElement(nillable = true)
    protected List<Integer> idsEtapes;
    @XmlElement(nillable = true)
    protected List<Integer> idsUfrs;
    protected IndemnisationDTO indemnisation;
    protected LangueConventionDTO langueConvention;
    protected boolean limit;
    protected NafN1DTO nafN1;
    protected String nbExportMaxi;
    protected String nbJoursHebdo;
    protected String nbRechercheMaxi;
    protected String nomEnseignant;
    protected String nomEtudiant;
    protected String numeroEtudiant;
    protected String numeroSiret;
    protected PaysDTO pays;
    protected String prenomEnseignant;
    protected String prenomEtudiant;
    protected String raisonSociale;
    protected StatutJuridiqueDTO statutJuridique;
    protected String sujetStage;
    protected TempsTravailDTO tempsTravail;
    protected ThemeDTO theme;
    protected TypeConventionDTO typeConvention;
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
     * Gets the value of the commune property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommune() {
        return commune;
    }

    /**
     * Sets the value of the commune property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommune(String value) {
        this.commune = value;
    }

    /**
     * Gets the value of the dateStage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateStage() {
        return dateStage;
    }

    /**
     * Sets the value of the dateStage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateStage(String value) {
        this.dateStage = value;
    }

    /**
     * Gets the value of the effectif property.
     * 
     * @return
     *     possible object is
     *     {@link EffectifDTO }
     *     
     */
    public EffectifDTO getEffectif() {
        return effectif;
    }

    /**
     * Sets the value of the effectif property.
     * 
     * @param value
     *     allowed object is
     *     {@link EffectifDTO }
     *     
     */
    public void setEffectif(EffectifDTO value) {
        this.effectif = value;
    }

    /**
     * Gets the value of the estValidee property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isEstValidee() {
        return estValidee;
    }

    /**
     * Sets the value of the estValidee property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEstValidee(Boolean value) {
        this.estValidee = value;
    }

    /**
     * Gets the value of the idConvention property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdConvention() {
        return idConvention;
    }

    /**
     * Sets the value of the idConvention property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdConvention(String value) {
        this.idConvention = value;
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
     * Gets the value of the idsEtapes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the idsEtapes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIdsEtapes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Integer }
     * 
     * 
     */
    public List<Integer> getIdsEtapes() {
        if (idsEtapes == null) {
            idsEtapes = new ArrayList<Integer>();
        }
        return this.idsEtapes;
    }

    /**
     * Gets the value of the idsUfrs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the idsUfrs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIdsUfrs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Integer }
     * 
     * 
     */
    public List<Integer> getIdsUfrs() {
        if (idsUfrs == null) {
            idsUfrs = new ArrayList<Integer>();
        }
        return this.idsUfrs;
    }

    /**
     * Gets the value of the indemnisation property.
     * 
     * @return
     *     possible object is
     *     {@link IndemnisationDTO }
     *     
     */
    public IndemnisationDTO getIndemnisation() {
        return indemnisation;
    }

    /**
     * Sets the value of the indemnisation property.
     * 
     * @param value
     *     allowed object is
     *     {@link IndemnisationDTO }
     *     
     */
    public void setIndemnisation(IndemnisationDTO value) {
        this.indemnisation = value;
    }

    /**
     * Gets the value of the langueConvention property.
     * 
     * @return
     *     possible object is
     *     {@link LangueConventionDTO }
     *     
     */
    public LangueConventionDTO getLangueConvention() {
        return langueConvention;
    }

    /**
     * Sets the value of the langueConvention property.
     * 
     * @param value
     *     allowed object is
     *     {@link LangueConventionDTO }
     *     
     */
    public void setLangueConvention(LangueConventionDTO value) {
        this.langueConvention = value;
    }

    /**
     * Gets the value of the limit property.
     * 
     */
    public boolean isLimit() {
        return limit;
    }

    /**
     * Sets the value of the limit property.
     * 
     */
    public void setLimit(boolean value) {
        this.limit = value;
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
     * Gets the value of the nbExportMaxi property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNbExportMaxi() {
        return nbExportMaxi;
    }

    /**
     * Sets the value of the nbExportMaxi property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNbExportMaxi(String value) {
        this.nbExportMaxi = value;
    }

    /**
     * Gets the value of the nbJoursHebdo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNbJoursHebdo() {
        return nbJoursHebdo;
    }

    /**
     * Sets the value of the nbJoursHebdo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNbJoursHebdo(String value) {
        this.nbJoursHebdo = value;
    }

    /**
     * Gets the value of the nbRechercheMaxi property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNbRechercheMaxi() {
        return nbRechercheMaxi;
    }

    /**
     * Sets the value of the nbRechercheMaxi property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNbRechercheMaxi(String value) {
        this.nbRechercheMaxi = value;
    }

    /**
     * Gets the value of the nomEnseignant property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomEnseignant() {
        return nomEnseignant;
    }

    /**
     * Sets the value of the nomEnseignant property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomEnseignant(String value) {
        this.nomEnseignant = value;
    }

    /**
     * Gets the value of the nomEtudiant property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomEtudiant() {
        return nomEtudiant;
    }

    /**
     * Sets the value of the nomEtudiant property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomEtudiant(String value) {
        this.nomEtudiant = value;
    }

    /**
     * Gets the value of the numeroEtudiant property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroEtudiant() {
        return numeroEtudiant;
    }

    /**
     * Sets the value of the numeroEtudiant property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroEtudiant(String value) {
        this.numeroEtudiant = value;
    }

    /**
     * Gets the value of the numeroSiret property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroSiret() {
        return numeroSiret;
    }

    /**
     * Sets the value of the numeroSiret property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroSiret(String value) {
        this.numeroSiret = value;
    }

    /**
     * Gets the value of the pays property.
     * 
     * @return
     *     possible object is
     *     {@link PaysDTO }
     *     
     */
    public PaysDTO getPays() {
        return pays;
    }

    /**
     * Sets the value of the pays property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaysDTO }
     *     
     */
    public void setPays(PaysDTO value) {
        this.pays = value;
    }

    /**
     * Gets the value of the prenomEnseignant property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrenomEnseignant() {
        return prenomEnseignant;
    }

    /**
     * Sets the value of the prenomEnseignant property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrenomEnseignant(String value) {
        this.prenomEnseignant = value;
    }

    /**
     * Gets the value of the prenomEtudiant property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrenomEtudiant() {
        return prenomEtudiant;
    }

    /**
     * Sets the value of the prenomEtudiant property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrenomEtudiant(String value) {
        this.prenomEtudiant = value;
    }

    /**
     * Gets the value of the raisonSociale property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRaisonSociale() {
        return raisonSociale;
    }

    /**
     * Sets the value of the raisonSociale property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRaisonSociale(String value) {
        this.raisonSociale = value;
    }

    /**
     * Gets the value of the statutJuridique property.
     * 
     * @return
     *     possible object is
     *     {@link StatutJuridiqueDTO }
     *     
     */
    public StatutJuridiqueDTO getStatutJuridique() {
        return statutJuridique;
    }

    /**
     * Sets the value of the statutJuridique property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatutJuridiqueDTO }
     *     
     */
    public void setStatutJuridique(StatutJuridiqueDTO value) {
        this.statutJuridique = value;
    }

    /**
     * Gets the value of the sujetStage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSujetStage() {
        return sujetStage;
    }

    /**
     * Sets the value of the sujetStage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSujetStage(String value) {
        this.sujetStage = value;
    }

    /**
     * Gets the value of the tempsTravail property.
     * 
     * @return
     *     possible object is
     *     {@link TempsTravailDTO }
     *     
     */
    public TempsTravailDTO getTempsTravail() {
        return tempsTravail;
    }

    /**
     * Sets the value of the tempsTravail property.
     * 
     * @param value
     *     allowed object is
     *     {@link TempsTravailDTO }
     *     
     */
    public void setTempsTravail(TempsTravailDTO value) {
        this.tempsTravail = value;
    }

    /**
     * Gets the value of the theme property.
     * 
     * @return
     *     possible object is
     *     {@link ThemeDTO }
     *     
     */
    public ThemeDTO getTheme() {
        return theme;
    }

    /**
     * Sets the value of the theme property.
     * 
     * @param value
     *     allowed object is
     *     {@link ThemeDTO }
     *     
     */
    public void setTheme(ThemeDTO value) {
        this.theme = value;
    }

    /**
     * Gets the value of the typeConvention property.
     * 
     * @return
     *     possible object is
     *     {@link TypeConventionDTO }
     *     
     */
    public TypeConventionDTO getTypeConvention() {
        return typeConvention;
    }

    /**
     * Sets the value of the typeConvention property.
     * 
     * @param value
     *     allowed object is
     *     {@link TypeConventionDTO }
     *     
     */
    public void setTypeConvention(TypeConventionDTO value) {
        this.typeConvention = value;
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
