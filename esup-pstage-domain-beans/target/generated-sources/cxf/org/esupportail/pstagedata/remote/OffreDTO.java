
package org.esupportail.pstagedata.remote;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for offreDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="offreDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://remote.pstagedata.esupportail.org/}objetMetiersDTO">
 *       &lt;sequence>
 *         &lt;element name="anneeDebut" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="anneeUniversitaire" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="avantages" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="avecFichier" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="avecLien" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="cacherEtablissement" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="cacherFaxContactCand" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="cacherFaxContactInfo" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="cacherMailContactCand" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="cacherMailContactInfo" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="cacherNomContactCand" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="cacherNomContactInfo" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="cacherTelContactCand" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="cacherTelContactInfo" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="centreGestion" type="{http://remote.pstagedata.esupportail.org/}centreGestionDTO" minOccurs="0"/>
 *         &lt;element name="codeCommune" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="codeFAP_N3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codeROM" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="commentaireTempsTravail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="competences" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="contactCand" type="{http://remote.pstagedata.esupportail.org/}contactDTO" minOccurs="0"/>
 *         &lt;element name="contactInfo" type="{http://remote.pstagedata.esupportail.org/}contactDTO" minOccurs="0"/>
 *         &lt;element name="contactProprio" type="{http://remote.pstagedata.esupportail.org/}contactDTO" minOccurs="0"/>
 *         &lt;element name="contratOffre" type="{http://remote.pstagedata.esupportail.org/}contratOffreDTO" minOccurs="0"/>
 *         &lt;element name="dateDiffusion" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="dateFinDiffusion" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="dateStopDiffusion" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="dateStopValidation" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="dateValidation" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="deplacement" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="duree" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="estAccessERQTH" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="estDiffusee" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="estPourvue" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="estPrioERQTH" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="estSupprimee" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="estValidee" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="etatValidation" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="fapN1" type="{http://remote.pstagedata.esupportail.org/}fapN1DTO" minOccurs="0"/>
 *         &lt;element name="fapN3" type="{http://remote.pstagedata.esupportail.org/}fapN3DTO" minOccurs="0"/>
 *         &lt;element name="fapQualificationSimplifiee" type="{http://remote.pstagedata.esupportail.org/}fapQualificationSimplifieeDTO" minOccurs="0"/>
 *         &lt;element name="fichier" type="{http://remote.pstagedata.esupportail.org/}fichierDTO" minOccurs="0"/>
 *         &lt;element name="idCentreGestion" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idContactCand" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idContactInfo" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idContactProprio" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idContratOffre" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idFichier" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idLieuPays" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idNiveauFormation" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idOffre" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idQualificationSimplifiee" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idReferent" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idStructure" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idTempsTravail" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idTypeOffre" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idUniteDuree" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idsModeCandidature" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="intitule" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lienAttache" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lieuCodePostal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lieuCommune" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lieuPays" type="{http://remote.pstagedata.esupportail.org/}paysDTO" minOccurs="0"/>
 *         &lt;element name="loginDiffusion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="loginRejetValidation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="loginStopDiffusion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="loginStopValidation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="loginValidation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="modesCandidature" type="{http://remote.pstagedata.esupportail.org/}modeCandidatureDTO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="moisDebut" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="niveauFormation" type="{http://remote.pstagedata.esupportail.org/}niveauFormationDTO" minOccurs="0"/>
 *         &lt;element name="observations" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="offresDiffusion" type="{http://remote.pstagedata.esupportail.org/}offreDiffusionDTO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="permis" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="precisionDebut" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="precisionHandicap" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="precisionRemuneration" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="quotiteTravail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="referenceOffreEtablissement" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="remuneration" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="structure" type="{http://remote.pstagedata.esupportail.org/}structureDTO" minOccurs="0"/>
 *         &lt;element name="tempsTravail" type="{http://remote.pstagedata.esupportail.org/}tempsTravailDTO" minOccurs="0"/>
 *         &lt;element name="typeOffre" type="{http://remote.pstagedata.esupportail.org/}typeOffreDTO" minOccurs="0"/>
 *         &lt;element name="uniteDuree" type="{http://remote.pstagedata.esupportail.org/}uniteDureeDTO" minOccurs="0"/>
 *         &lt;element name="voiture" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "offreDTO", propOrder = {
    "anneeDebut",
    "anneeUniversitaire",
    "avantages",
    "avecFichier",
    "avecLien",
    "cacherEtablissement",
    "cacherFaxContactCand",
    "cacherFaxContactInfo",
    "cacherMailContactCand",
    "cacherMailContactInfo",
    "cacherNomContactCand",
    "cacherNomContactInfo",
    "cacherTelContactCand",
    "cacherTelContactInfo",
    "centreGestion",
    "codeCommune",
    "codeFAPN3",
    "codeROM",
    "commentaireTempsTravail",
    "competences",
    "contactCand",
    "contactInfo",
    "contactProprio",
    "contratOffre",
    "dateDiffusion",
    "dateFinDiffusion",
    "dateStopDiffusion",
    "dateStopValidation",
    "dateValidation",
    "deplacement",
    "description",
    "duree",
    "estAccessERQTH",
    "estDiffusee",
    "estPourvue",
    "estPrioERQTH",
    "estSupprimee",
    "estValidee",
    "etatValidation",
    "fapN1",
    "fapN3",
    "fapQualificationSimplifiee",
    "fichier",
    "idCentreGestion",
    "idContactCand",
    "idContactInfo",
    "idContactProprio",
    "idContratOffre",
    "idFichier",
    "idLieuPays",
    "idNiveauFormation",
    "idOffre",
    "idQualificationSimplifiee",
    "idReferent",
    "idStructure",
    "idTempsTravail",
    "idTypeOffre",
    "idUniteDuree",
    "idsModeCandidature",
    "intitule",
    "lienAttache",
    "lieuCodePostal",
    "lieuCommune",
    "lieuPays",
    "loginDiffusion",
    "loginRejetValidation",
    "loginStopDiffusion",
    "loginStopValidation",
    "loginValidation",
    "modesCandidature",
    "moisDebut",
    "niveauFormation",
    "observations",
    "offresDiffusion",
    "permis",
    "precisionDebut",
    "precisionHandicap",
    "precisionRemuneration",
    "quotiteTravail",
    "referenceOffreEtablissement",
    "remuneration",
    "structure",
    "tempsTravail",
    "typeOffre",
    "uniteDuree",
    "voiture"
})
public class OffreDTO
    extends ObjetMetiersDTO
{

    protected String anneeDebut;
    protected String anneeUniversitaire;
    protected String avantages;
    protected boolean avecFichier;
    protected boolean avecLien;
    protected boolean cacherEtablissement;
    protected boolean cacherFaxContactCand;
    protected boolean cacherFaxContactInfo;
    protected boolean cacherMailContactCand;
    protected boolean cacherMailContactInfo;
    protected boolean cacherNomContactCand;
    protected boolean cacherNomContactInfo;
    protected boolean cacherTelContactCand;
    protected boolean cacherTelContactInfo;
    protected CentreGestionDTO centreGestion;
    protected int codeCommune;
    @XmlElement(name = "codeFAP_N3")
    protected String codeFAPN3;
    protected int codeROM;
    protected String commentaireTempsTravail;
    protected String competences;
    protected ContactDTO contactCand;
    protected ContactDTO contactInfo;
    protected ContactDTO contactProprio;
    protected ContratOffreDTO contratOffre;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateDiffusion;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateFinDiffusion;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateStopDiffusion;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateStopValidation;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateValidation;
    protected boolean deplacement;
    protected String description;
    protected int duree;
    protected boolean estAccessERQTH;
    protected boolean estDiffusee;
    protected boolean estPourvue;
    protected boolean estPrioERQTH;
    protected boolean estSupprimee;
    protected boolean estValidee;
    protected int etatValidation;
    protected FapN1DTO fapN1;
    protected FapN3DTO fapN3;
    protected FapQualificationSimplifieeDTO fapQualificationSimplifiee;
    protected FichierDTO fichier;
    protected int idCentreGestion;
    protected int idContactCand;
    protected int idContactInfo;
    protected int idContactProprio;
    protected int idContratOffre;
    protected int idFichier;
    protected int idLieuPays;
    protected int idNiveauFormation;
    protected int idOffre;
    protected int idQualificationSimplifiee;
    protected int idReferent;
    protected int idStructure;
    protected int idTempsTravail;
    protected int idTypeOffre;
    protected int idUniteDuree;
    @XmlElement(nillable = true)
    protected List<Integer> idsModeCandidature;
    protected String intitule;
    protected String lienAttache;
    protected String lieuCodePostal;
    protected String lieuCommune;
    protected PaysDTO lieuPays;
    protected String loginDiffusion;
    protected String loginRejetValidation;
    protected String loginStopDiffusion;
    protected String loginStopValidation;
    protected String loginValidation;
    @XmlElement(nillable = true)
    protected List<ModeCandidatureDTO> modesCandidature;
    protected String moisDebut;
    protected NiveauFormationDTO niveauFormation;
    protected String observations;
    @XmlElement(nillable = true)
    protected List<OffreDiffusionDTO> offresDiffusion;
    protected boolean permis;
    protected String precisionDebut;
    protected String precisionHandicap;
    protected String precisionRemuneration;
    protected String quotiteTravail;
    protected String referenceOffreEtablissement;
    protected boolean remuneration;
    protected StructureDTO structure;
    protected TempsTravailDTO tempsTravail;
    protected TypeOffreDTO typeOffre;
    protected UniteDureeDTO uniteDuree;
    protected boolean voiture;

    /**
     * Gets the value of the anneeDebut property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnneeDebut() {
        return anneeDebut;
    }

    /**
     * Sets the value of the anneeDebut property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnneeDebut(String value) {
        this.anneeDebut = value;
    }

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
     * Gets the value of the avantages property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAvantages() {
        return avantages;
    }

    /**
     * Sets the value of the avantages property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAvantages(String value) {
        this.avantages = value;
    }

    /**
     * Gets the value of the avecFichier property.
     * 
     */
    public boolean isAvecFichier() {
        return avecFichier;
    }

    /**
     * Sets the value of the avecFichier property.
     * 
     */
    public void setAvecFichier(boolean value) {
        this.avecFichier = value;
    }

    /**
     * Gets the value of the avecLien property.
     * 
     */
    public boolean isAvecLien() {
        return avecLien;
    }

    /**
     * Sets the value of the avecLien property.
     * 
     */
    public void setAvecLien(boolean value) {
        this.avecLien = value;
    }

    /**
     * Gets the value of the cacherEtablissement property.
     * 
     */
    public boolean isCacherEtablissement() {
        return cacherEtablissement;
    }

    /**
     * Sets the value of the cacherEtablissement property.
     * 
     */
    public void setCacherEtablissement(boolean value) {
        this.cacherEtablissement = value;
    }

    /**
     * Gets the value of the cacherFaxContactCand property.
     * 
     */
    public boolean isCacherFaxContactCand() {
        return cacherFaxContactCand;
    }

    /**
     * Sets the value of the cacherFaxContactCand property.
     * 
     */
    public void setCacherFaxContactCand(boolean value) {
        this.cacherFaxContactCand = value;
    }

    /**
     * Gets the value of the cacherFaxContactInfo property.
     * 
     */
    public boolean isCacherFaxContactInfo() {
        return cacherFaxContactInfo;
    }

    /**
     * Sets the value of the cacherFaxContactInfo property.
     * 
     */
    public void setCacherFaxContactInfo(boolean value) {
        this.cacherFaxContactInfo = value;
    }

    /**
     * Gets the value of the cacherMailContactCand property.
     * 
     */
    public boolean isCacherMailContactCand() {
        return cacherMailContactCand;
    }

    /**
     * Sets the value of the cacherMailContactCand property.
     * 
     */
    public void setCacherMailContactCand(boolean value) {
        this.cacherMailContactCand = value;
    }

    /**
     * Gets the value of the cacherMailContactInfo property.
     * 
     */
    public boolean isCacherMailContactInfo() {
        return cacherMailContactInfo;
    }

    /**
     * Sets the value of the cacherMailContactInfo property.
     * 
     */
    public void setCacherMailContactInfo(boolean value) {
        this.cacherMailContactInfo = value;
    }

    /**
     * Gets the value of the cacherNomContactCand property.
     * 
     */
    public boolean isCacherNomContactCand() {
        return cacherNomContactCand;
    }

    /**
     * Sets the value of the cacherNomContactCand property.
     * 
     */
    public void setCacherNomContactCand(boolean value) {
        this.cacherNomContactCand = value;
    }

    /**
     * Gets the value of the cacherNomContactInfo property.
     * 
     */
    public boolean isCacherNomContactInfo() {
        return cacherNomContactInfo;
    }

    /**
     * Sets the value of the cacherNomContactInfo property.
     * 
     */
    public void setCacherNomContactInfo(boolean value) {
        this.cacherNomContactInfo = value;
    }

    /**
     * Gets the value of the cacherTelContactCand property.
     * 
     */
    public boolean isCacherTelContactCand() {
        return cacherTelContactCand;
    }

    /**
     * Sets the value of the cacherTelContactCand property.
     * 
     */
    public void setCacherTelContactCand(boolean value) {
        this.cacherTelContactCand = value;
    }

    /**
     * Gets the value of the cacherTelContactInfo property.
     * 
     */
    public boolean isCacherTelContactInfo() {
        return cacherTelContactInfo;
    }

    /**
     * Sets the value of the cacherTelContactInfo property.
     * 
     */
    public void setCacherTelContactInfo(boolean value) {
        this.cacherTelContactInfo = value;
    }

    /**
     * Gets the value of the centreGestion property.
     * 
     * @return
     *     possible object is
     *     {@link CentreGestionDTO }
     *     
     */
    public CentreGestionDTO getCentreGestion() {
        return centreGestion;
    }

    /**
     * Sets the value of the centreGestion property.
     * 
     * @param value
     *     allowed object is
     *     {@link CentreGestionDTO }
     *     
     */
    public void setCentreGestion(CentreGestionDTO value) {
        this.centreGestion = value;
    }

    /**
     * Gets the value of the codeCommune property.
     * 
     */
    public int getCodeCommune() {
        return codeCommune;
    }

    /**
     * Sets the value of the codeCommune property.
     * 
     */
    public void setCodeCommune(int value) {
        this.codeCommune = value;
    }

    /**
     * Gets the value of the codeFAPN3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeFAPN3() {
        return codeFAPN3;
    }

    /**
     * Sets the value of the codeFAPN3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeFAPN3(String value) {
        this.codeFAPN3 = value;
    }

    /**
     * Gets the value of the codeROM property.
     * 
     */
    public int getCodeROM() {
        return codeROM;
    }

    /**
     * Sets the value of the codeROM property.
     * 
     */
    public void setCodeROM(int value) {
        this.codeROM = value;
    }

    /**
     * Gets the value of the commentaireTempsTravail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommentaireTempsTravail() {
        return commentaireTempsTravail;
    }

    /**
     * Sets the value of the commentaireTempsTravail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommentaireTempsTravail(String value) {
        this.commentaireTempsTravail = value;
    }

    /**
     * Gets the value of the competences property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompetences() {
        return competences;
    }

    /**
     * Sets the value of the competences property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompetences(String value) {
        this.competences = value;
    }

    /**
     * Gets the value of the contactCand property.
     * 
     * @return
     *     possible object is
     *     {@link ContactDTO }
     *     
     */
    public ContactDTO getContactCand() {
        return contactCand;
    }

    /**
     * Sets the value of the contactCand property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContactDTO }
     *     
     */
    public void setContactCand(ContactDTO value) {
        this.contactCand = value;
    }

    /**
     * Gets the value of the contactInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ContactDTO }
     *     
     */
    public ContactDTO getContactInfo() {
        return contactInfo;
    }

    /**
     * Sets the value of the contactInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContactDTO }
     *     
     */
    public void setContactInfo(ContactDTO value) {
        this.contactInfo = value;
    }

    /**
     * Gets the value of the contactProprio property.
     * 
     * @return
     *     possible object is
     *     {@link ContactDTO }
     *     
     */
    public ContactDTO getContactProprio() {
        return contactProprio;
    }

    /**
     * Sets the value of the contactProprio property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContactDTO }
     *     
     */
    public void setContactProprio(ContactDTO value) {
        this.contactProprio = value;
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
     * Gets the value of the dateDiffusion property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateDiffusion() {
        return dateDiffusion;
    }

    /**
     * Sets the value of the dateDiffusion property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateDiffusion(XMLGregorianCalendar value) {
        this.dateDiffusion = value;
    }

    /**
     * Gets the value of the dateFinDiffusion property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateFinDiffusion() {
        return dateFinDiffusion;
    }

    /**
     * Sets the value of the dateFinDiffusion property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateFinDiffusion(XMLGregorianCalendar value) {
        this.dateFinDiffusion = value;
    }

    /**
     * Gets the value of the dateStopDiffusion property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateStopDiffusion() {
        return dateStopDiffusion;
    }

    /**
     * Sets the value of the dateStopDiffusion property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateStopDiffusion(XMLGregorianCalendar value) {
        this.dateStopDiffusion = value;
    }

    /**
     * Gets the value of the dateStopValidation property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateStopValidation() {
        return dateStopValidation;
    }

    /**
     * Sets the value of the dateStopValidation property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateStopValidation(XMLGregorianCalendar value) {
        this.dateStopValidation = value;
    }

    /**
     * Gets the value of the dateValidation property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateValidation() {
        return dateValidation;
    }

    /**
     * Sets the value of the dateValidation property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateValidation(XMLGregorianCalendar value) {
        this.dateValidation = value;
    }

    /**
     * Gets the value of the deplacement property.
     * 
     */
    public boolean isDeplacement() {
        return deplacement;
    }

    /**
     * Sets the value of the deplacement property.
     * 
     */
    public void setDeplacement(boolean value) {
        this.deplacement = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the duree property.
     * 
     */
    public int getDuree() {
        return duree;
    }

    /**
     * Sets the value of the duree property.
     * 
     */
    public void setDuree(int value) {
        this.duree = value;
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
     * Gets the value of the estPourvue property.
     * 
     */
    public boolean isEstPourvue() {
        return estPourvue;
    }

    /**
     * Sets the value of the estPourvue property.
     * 
     */
    public void setEstPourvue(boolean value) {
        this.estPourvue = value;
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
     * Gets the value of the estValidee property.
     * 
     */
    public boolean isEstValidee() {
        return estValidee;
    }

    /**
     * Sets the value of the estValidee property.
     * 
     */
    public void setEstValidee(boolean value) {
        this.estValidee = value;
    }

    /**
     * Gets the value of the etatValidation property.
     * 
     */
    public int getEtatValidation() {
        return etatValidation;
    }

    /**
     * Sets the value of the etatValidation property.
     * 
     */
    public void setEtatValidation(int value) {
        this.etatValidation = value;
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
     * Gets the value of the fichier property.
     * 
     * @return
     *     possible object is
     *     {@link FichierDTO }
     *     
     */
    public FichierDTO getFichier() {
        return fichier;
    }

    /**
     * Sets the value of the fichier property.
     * 
     * @param value
     *     allowed object is
     *     {@link FichierDTO }
     *     
     */
    public void setFichier(FichierDTO value) {
        this.fichier = value;
    }

    /**
     * Gets the value of the idCentreGestion property.
     * 
     */
    public int getIdCentreGestion() {
        return idCentreGestion;
    }

    /**
     * Sets the value of the idCentreGestion property.
     * 
     */
    public void setIdCentreGestion(int value) {
        this.idCentreGestion = value;
    }

    /**
     * Gets the value of the idContactCand property.
     * 
     */
    public int getIdContactCand() {
        return idContactCand;
    }

    /**
     * Sets the value of the idContactCand property.
     * 
     */
    public void setIdContactCand(int value) {
        this.idContactCand = value;
    }

    /**
     * Gets the value of the idContactInfo property.
     * 
     */
    public int getIdContactInfo() {
        return idContactInfo;
    }

    /**
     * Sets the value of the idContactInfo property.
     * 
     */
    public void setIdContactInfo(int value) {
        this.idContactInfo = value;
    }

    /**
     * Gets the value of the idContactProprio property.
     * 
     */
    public int getIdContactProprio() {
        return idContactProprio;
    }

    /**
     * Sets the value of the idContactProprio property.
     * 
     */
    public void setIdContactProprio(int value) {
        this.idContactProprio = value;
    }

    /**
     * Gets the value of the idContratOffre property.
     * 
     */
    public int getIdContratOffre() {
        return idContratOffre;
    }

    /**
     * Sets the value of the idContratOffre property.
     * 
     */
    public void setIdContratOffre(int value) {
        this.idContratOffre = value;
    }

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
     * Gets the value of the idLieuPays property.
     * 
     */
    public int getIdLieuPays() {
        return idLieuPays;
    }

    /**
     * Sets the value of the idLieuPays property.
     * 
     */
    public void setIdLieuPays(int value) {
        this.idLieuPays = value;
    }

    /**
     * Gets the value of the idNiveauFormation property.
     * 
     */
    public int getIdNiveauFormation() {
        return idNiveauFormation;
    }

    /**
     * Sets the value of the idNiveauFormation property.
     * 
     */
    public void setIdNiveauFormation(int value) {
        this.idNiveauFormation = value;
    }

    /**
     * Gets the value of the idOffre property.
     * 
     */
    public int getIdOffre() {
        return idOffre;
    }

    /**
     * Sets the value of the idOffre property.
     * 
     */
    public void setIdOffre(int value) {
        this.idOffre = value;
    }

    /**
     * Gets the value of the idQualificationSimplifiee property.
     * 
     */
    public int getIdQualificationSimplifiee() {
        return idQualificationSimplifiee;
    }

    /**
     * Sets the value of the idQualificationSimplifiee property.
     * 
     */
    public void setIdQualificationSimplifiee(int value) {
        this.idQualificationSimplifiee = value;
    }

    /**
     * Gets the value of the idReferent property.
     * 
     */
    public int getIdReferent() {
        return idReferent;
    }

    /**
     * Sets the value of the idReferent property.
     * 
     */
    public void setIdReferent(int value) {
        this.idReferent = value;
    }

    /**
     * Gets the value of the idStructure property.
     * 
     */
    public int getIdStructure() {
        return idStructure;
    }

    /**
     * Sets the value of the idStructure property.
     * 
     */
    public void setIdStructure(int value) {
        this.idStructure = value;
    }

    /**
     * Gets the value of the idTempsTravail property.
     * 
     */
    public int getIdTempsTravail() {
        return idTempsTravail;
    }

    /**
     * Sets the value of the idTempsTravail property.
     * 
     */
    public void setIdTempsTravail(int value) {
        this.idTempsTravail = value;
    }

    /**
     * Gets the value of the idTypeOffre property.
     * 
     */
    public int getIdTypeOffre() {
        return idTypeOffre;
    }

    /**
     * Sets the value of the idTypeOffre property.
     * 
     */
    public void setIdTypeOffre(int value) {
        this.idTypeOffre = value;
    }

    /**
     * Gets the value of the idUniteDuree property.
     * 
     */
    public int getIdUniteDuree() {
        return idUniteDuree;
    }

    /**
     * Sets the value of the idUniteDuree property.
     * 
     */
    public void setIdUniteDuree(int value) {
        this.idUniteDuree = value;
    }

    /**
     * Gets the value of the idsModeCandidature property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the idsModeCandidature property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIdsModeCandidature().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Integer }
     * 
     * 
     */
    public List<Integer> getIdsModeCandidature() {
        if (idsModeCandidature == null) {
            idsModeCandidature = new ArrayList<Integer>();
        }
        return this.idsModeCandidature;
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
     * Gets the value of the lienAttache property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLienAttache() {
        return lienAttache;
    }

    /**
     * Sets the value of the lienAttache property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLienAttache(String value) {
        this.lienAttache = value;
    }

    /**
     * Gets the value of the lieuCodePostal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLieuCodePostal() {
        return lieuCodePostal;
    }

    /**
     * Sets the value of the lieuCodePostal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLieuCodePostal(String value) {
        this.lieuCodePostal = value;
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
     * Gets the value of the loginDiffusion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoginDiffusion() {
        return loginDiffusion;
    }

    /**
     * Sets the value of the loginDiffusion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoginDiffusion(String value) {
        this.loginDiffusion = value;
    }

    /**
     * Gets the value of the loginRejetValidation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoginRejetValidation() {
        return loginRejetValidation;
    }

    /**
     * Sets the value of the loginRejetValidation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoginRejetValidation(String value) {
        this.loginRejetValidation = value;
    }

    /**
     * Gets the value of the loginStopDiffusion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoginStopDiffusion() {
        return loginStopDiffusion;
    }

    /**
     * Sets the value of the loginStopDiffusion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoginStopDiffusion(String value) {
        this.loginStopDiffusion = value;
    }

    /**
     * Gets the value of the loginStopValidation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoginStopValidation() {
        return loginStopValidation;
    }

    /**
     * Sets the value of the loginStopValidation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoginStopValidation(String value) {
        this.loginStopValidation = value;
    }

    /**
     * Gets the value of the loginValidation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoginValidation() {
        return loginValidation;
    }

    /**
     * Sets the value of the loginValidation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoginValidation(String value) {
        this.loginValidation = value;
    }

    /**
     * Gets the value of the modesCandidature property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the modesCandidature property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getModesCandidature().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ModeCandidatureDTO }
     * 
     * 
     */
    public List<ModeCandidatureDTO> getModesCandidature() {
        if (modesCandidature == null) {
            modesCandidature = new ArrayList<ModeCandidatureDTO>();
        }
        return this.modesCandidature;
    }

    /**
     * Gets the value of the moisDebut property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMoisDebut() {
        return moisDebut;
    }

    /**
     * Sets the value of the moisDebut property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMoisDebut(String value) {
        this.moisDebut = value;
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
     * Gets the value of the observations property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObservations() {
        return observations;
    }

    /**
     * Sets the value of the observations property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObservations(String value) {
        this.observations = value;
    }

    /**
     * Gets the value of the offresDiffusion property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the offresDiffusion property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOffresDiffusion().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OffreDiffusionDTO }
     * 
     * 
     */
    public List<OffreDiffusionDTO> getOffresDiffusion() {
        if (offresDiffusion == null) {
            offresDiffusion = new ArrayList<OffreDiffusionDTO>();
        }
        return this.offresDiffusion;
    }

    /**
     * Gets the value of the permis property.
     * 
     */
    public boolean isPermis() {
        return permis;
    }

    /**
     * Sets the value of the permis property.
     * 
     */
    public void setPermis(boolean value) {
        this.permis = value;
    }

    /**
     * Gets the value of the precisionDebut property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrecisionDebut() {
        return precisionDebut;
    }

    /**
     * Sets the value of the precisionDebut property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrecisionDebut(String value) {
        this.precisionDebut = value;
    }

    /**
     * Gets the value of the precisionHandicap property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrecisionHandicap() {
        return precisionHandicap;
    }

    /**
     * Sets the value of the precisionHandicap property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrecisionHandicap(String value) {
        this.precisionHandicap = value;
    }

    /**
     * Gets the value of the precisionRemuneration property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrecisionRemuneration() {
        return precisionRemuneration;
    }

    /**
     * Sets the value of the precisionRemuneration property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrecisionRemuneration(String value) {
        this.precisionRemuneration = value;
    }

    /**
     * Gets the value of the quotiteTravail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQuotiteTravail() {
        return quotiteTravail;
    }

    /**
     * Sets the value of the quotiteTravail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQuotiteTravail(String value) {
        this.quotiteTravail = value;
    }

    /**
     * Gets the value of the referenceOffreEtablissement property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferenceOffreEtablissement() {
        return referenceOffreEtablissement;
    }

    /**
     * Sets the value of the referenceOffreEtablissement property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferenceOffreEtablissement(String value) {
        this.referenceOffreEtablissement = value;
    }

    /**
     * Gets the value of the remuneration property.
     * 
     */
    public boolean isRemuneration() {
        return remuneration;
    }

    /**
     * Sets the value of the remuneration property.
     * 
     */
    public void setRemuneration(boolean value) {
        this.remuneration = value;
    }

    /**
     * Gets the value of the structure property.
     * 
     * @return
     *     possible object is
     *     {@link StructureDTO }
     *     
     */
    public StructureDTO getStructure() {
        return structure;
    }

    /**
     * Sets the value of the structure property.
     * 
     * @param value
     *     allowed object is
     *     {@link StructureDTO }
     *     
     */
    public void setStructure(StructureDTO value) {
        this.structure = value;
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
     * Gets the value of the uniteDuree property.
     * 
     * @return
     *     possible object is
     *     {@link UniteDureeDTO }
     *     
     */
    public UniteDureeDTO getUniteDuree() {
        return uniteDuree;
    }

    /**
     * Sets the value of the uniteDuree property.
     * 
     * @param value
     *     allowed object is
     *     {@link UniteDureeDTO }
     *     
     */
    public void setUniteDuree(UniteDureeDTO value) {
        this.uniteDuree = value;
    }

    /**
     * Gets the value of the voiture property.
     * 
     */
    public boolean isVoiture() {
        return voiture;
    }

    /**
     * Sets the value of the voiture property.
     * 
     */
    public void setVoiture(boolean value) {
        this.voiture = value;
    }

}
