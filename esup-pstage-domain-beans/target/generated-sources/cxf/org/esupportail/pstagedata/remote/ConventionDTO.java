
package org.esupportail.pstagedata.remote;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for conventionDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="conventionDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://remote.pstagedata.esupportail.org/}objetMetiersDTO">
 *       &lt;sequence>
 *         &lt;element name="adresseEtabRef" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="adresseEtudiant" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="annee" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="assurance" type="{http://remote.pstagedata.esupportail.org/}assuranceDTO" minOccurs="0"/>
 *         &lt;element name="avantagesNature" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="caisseRegime" type="{http://remote.pstagedata.esupportail.org/}caisseRegimeDTO" minOccurs="0"/>
 *         &lt;element name="centreGestion" type="{http://remote.pstagedata.esupportail.org/}centreGestionDTO" minOccurs="0"/>
 *         &lt;element name="codeCaisse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codeCursusLMD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codeDepartement" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codeElp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codeEtape" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codeFinalite" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codeLangueConvention" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codePostalEtudiant" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codeRGI" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codeUFR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codeUniversiteEtape" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codeUniversiteUFR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="commentaireDureeTravail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="commentaireStage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="contact" type="{http://remote.pstagedata.esupportail.org/}contactDTO" minOccurs="0"/>
 *         &lt;element name="conventionStructure" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="conversionEnContrat" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="courrielPersoEtudiant" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="creditECTS" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="dateDebutInterruption" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="dateDebutStage" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="dateFinInterruption" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="dateFinStage" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="dateSignature" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="dateValidation" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="details" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dureeExceptionnelle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dureeStage" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="enseignant" type="{http://remote.pstagedata.esupportail.org/}enseignantDTO" minOccurs="0"/>
 *         &lt;element name="etape" type="{http://remote.pstagedata.esupportail.org/}etapeDTO" minOccurs="0"/>
 *         &lt;element name="etudiant" type="{http://remote.pstagedata.esupportail.org/}etudiantDTO" minOccurs="0"/>
 *         &lt;element name="fonctionsEtTaches" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idAssurance" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="idCentreGestion" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="idContact" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="idConvention" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="idEnseignant" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="idEtudiant" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="idFicheEvaluation" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="idIndemnisation" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="idModeValidationStage" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="idModeVersGratification" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="idNatureTravail" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="idOffre" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="idOrigineStage" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="idService" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="idSignataire" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="idStructure" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="idTempsTravail" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="idTheme" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="idTypeConvention" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="idUniteDureeExceptionnelle" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="idUniteGratification" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="indemnisation" type="{http://remote.pstagedata.esupportail.org/}indemnisationDTO" minOccurs="0"/>
 *         &lt;element name="insee" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="interruptionStage" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="langueConvention" type="{http://remote.pstagedata.esupportail.org/}langueConventionDTO" minOccurs="0"/>
 *         &lt;element name="libelleCPAM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="libelleELP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="libelleFinalite" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="loginSignature" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="loginValidation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="modeEncadreSuivi" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="modeValidationStage" type="{http://remote.pstagedata.esupportail.org/}modeValidationStageDTO" minOccurs="0"/>
 *         &lt;element name="modeVersGratification" type="{http://remote.pstagedata.esupportail.org/}modeVersGratificationDTO" minOccurs="0"/>
 *         &lt;element name="montantGratification" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="natureTravail" type="{http://remote.pstagedata.esupportail.org/}natureTravailDTO" minOccurs="0"/>
 *         &lt;element name="nbAvenant" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nbHeuresHebdo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nbJoursHebdo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nomEtabRef" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nomSignataireComposante" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="origineStage" type="{http://remote.pstagedata.esupportail.org/}origineStageDTO" minOccurs="0"/>
 *         &lt;element name="paysEtudiant" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="priseEnChargeFraisMission" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="qualiteSignataire" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="quotiteTravail" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="selected" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="service" type="{http://remote.pstagedata.esupportail.org/}serviceDTO" minOccurs="0"/>
 *         &lt;element name="signataire" type="{http://remote.pstagedata.esupportail.org/}contactDTO" minOccurs="0"/>
 *         &lt;element name="structure" type="{http://remote.pstagedata.esupportail.org/}structureDTO" minOccurs="0"/>
 *         &lt;element name="sujetStage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="telEtudiant" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="telPortableEtudiant" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="temConfSujetTeme" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tempsTravail" type="{http://remote.pstagedata.esupportail.org/}tempsTravailDTO" minOccurs="0"/>
 *         &lt;element name="theme" type="{http://remote.pstagedata.esupportail.org/}themeDTO" minOccurs="0"/>
 *         &lt;element name="travailNuitFerie" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="typeConvention" type="{http://remote.pstagedata.esupportail.org/}typeConventionDTO" minOccurs="0"/>
 *         &lt;element name="ufr" type="{http://remote.pstagedata.esupportail.org/}ufrDTO" minOccurs="0"/>
 *         &lt;element name="uniteDuree" type="{http://remote.pstagedata.esupportail.org/}uniteDureeDTO" minOccurs="0"/>
 *         &lt;element name="uniteGratification" type="{http://remote.pstagedata.esupportail.org/}uniteGratificationDTO" minOccurs="0"/>
 *         &lt;element name="validationConvention" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="villeEtudiant" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "conventionDTO", propOrder = {
    "adresseEtabRef",
    "adresseEtudiant",
    "annee",
    "assurance",
    "avantagesNature",
    "caisseRegime",
    "centreGestion",
    "codeCaisse",
    "codeCursusLMD",
    "codeDepartement",
    "codeElp",
    "codeEtape",
    "codeFinalite",
    "codeLangueConvention",
    "codePostalEtudiant",
    "codeRGI",
    "codeUFR",
    "codeUniversiteEtape",
    "codeUniversiteUFR",
    "commentaireDureeTravail",
    "commentaireStage",
    "contact",
    "conventionStructure",
    "conversionEnContrat",
    "courrielPersoEtudiant",
    "creditECTS",
    "dateDebutInterruption",
    "dateDebutStage",
    "dateFinInterruption",
    "dateFinStage",
    "dateSignature",
    "dateValidation",
    "details",
    "dureeExceptionnelle",
    "dureeStage",
    "enseignant",
    "etape",
    "etudiant",
    "fonctionsEtTaches",
    "idAssurance",
    "idCentreGestion",
    "idContact",
    "idConvention",
    "idEnseignant",
    "idEtudiant",
    "idFicheEvaluation",
    "idIndemnisation",
    "idModeValidationStage",
    "idModeVersGratification",
    "idNatureTravail",
    "idOffre",
    "idOrigineStage",
    "idService",
    "idSignataire",
    "idStructure",
    "idTempsTravail",
    "idTheme",
    "idTypeConvention",
    "idUniteDureeExceptionnelle",
    "idUniteGratification",
    "indemnisation",
    "insee",
    "interruptionStage",
    "langueConvention",
    "libelleCPAM",
    "libelleELP",
    "libelleFinalite",
    "loginSignature",
    "loginValidation",
    "modeEncadreSuivi",
    "modeValidationStage",
    "modeVersGratification",
    "montantGratification",
    "natureTravail",
    "nbAvenant",
    "nbHeuresHebdo",
    "nbJoursHebdo",
    "nomEtabRef",
    "nomSignataireComposante",
    "origineStage",
    "paysEtudiant",
    "priseEnChargeFraisMission",
    "qualiteSignataire",
    "quotiteTravail",
    "selected",
    "service",
    "signataire",
    "structure",
    "sujetStage",
    "telEtudiant",
    "telPortableEtudiant",
    "temConfSujetTeme",
    "tempsTravail",
    "theme",
    "travailNuitFerie",
    "typeConvention",
    "ufr",
    "uniteDuree",
    "uniteGratification",
    "validationConvention",
    "villeEtudiant"
})
public class ConventionDTO
    extends ObjetMetiersDTO
{

    protected String adresseEtabRef;
    protected String adresseEtudiant;
    protected String annee;
    protected AssuranceDTO assurance;
    protected String avantagesNature;
    protected CaisseRegimeDTO caisseRegime;
    protected CentreGestionDTO centreGestion;
    protected String codeCaisse;
    protected String codeCursusLMD;
    protected String codeDepartement;
    protected String codeElp;
    protected String codeEtape;
    protected String codeFinalite;
    protected String codeLangueConvention;
    protected String codePostalEtudiant;
    protected String codeRGI;
    protected String codeUFR;
    protected String codeUniversiteEtape;
    protected String codeUniversiteUFR;
    protected String commentaireDureeTravail;
    protected String commentaireStage;
    protected ContactDTO contact;
    protected boolean conventionStructure;
    protected boolean conversionEnContrat;
    protected String courrielPersoEtudiant;
    protected BigDecimal creditECTS;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateDebutInterruption;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateDebutStage;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateFinInterruption;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateFinStage;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateSignature;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateValidation;
    protected String details;
    protected String dureeExceptionnelle;
    protected Integer dureeStage;
    protected EnseignantDTO enseignant;
    protected EtapeDTO etape;
    protected EtudiantDTO etudiant;
    protected String fonctionsEtTaches;
    protected Integer idAssurance;
    protected Integer idCentreGestion;
    protected Integer idContact;
    protected Integer idConvention;
    protected Integer idEnseignant;
    protected Integer idEtudiant;
    protected Integer idFicheEvaluation;
    protected Integer idIndemnisation;
    protected Integer idModeValidationStage;
    protected Integer idModeVersGratification;
    protected Integer idNatureTravail;
    protected Integer idOffre;
    protected Integer idOrigineStage;
    protected Integer idService;
    protected Integer idSignataire;
    protected Integer idStructure;
    protected Integer idTempsTravail;
    protected Integer idTheme;
    protected Integer idTypeConvention;
    protected Integer idUniteDureeExceptionnelle;
    protected Integer idUniteGratification;
    protected IndemnisationDTO indemnisation;
    protected String insee;
    protected boolean interruptionStage;
    protected LangueConventionDTO langueConvention;
    protected String libelleCPAM;
    protected String libelleELP;
    protected String libelleFinalite;
    protected String loginSignature;
    protected String loginValidation;
    protected String modeEncadreSuivi;
    protected ModeValidationStageDTO modeValidationStage;
    protected ModeVersGratificationDTO modeVersGratification;
    protected String montantGratification;
    protected NatureTravailDTO natureTravail;
    protected int nbAvenant;
    protected String nbHeuresHebdo;
    protected String nbJoursHebdo;
    protected String nomEtabRef;
    protected String nomSignataireComposante;
    protected OrigineStageDTO origineStage;
    protected String paysEtudiant;
    protected boolean priseEnChargeFraisMission;
    protected String qualiteSignataire;
    protected Integer quotiteTravail;
    protected boolean selected;
    protected ServiceDTO service;
    protected ContactDTO signataire;
    protected StructureDTO structure;
    protected String sujetStage;
    protected String telEtudiant;
    protected String telPortableEtudiant;
    protected String temConfSujetTeme;
    protected TempsTravailDTO tempsTravail;
    protected ThemeDTO theme;
    protected String travailNuitFerie;
    protected TypeConventionDTO typeConvention;
    protected UfrDTO ufr;
    protected UniteDureeDTO uniteDuree;
    protected UniteGratificationDTO uniteGratification;
    protected boolean validationConvention;
    protected String villeEtudiant;

    /**
     * Gets the value of the adresseEtabRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdresseEtabRef() {
        return adresseEtabRef;
    }

    /**
     * Sets the value of the adresseEtabRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdresseEtabRef(String value) {
        this.adresseEtabRef = value;
    }

    /**
     * Gets the value of the adresseEtudiant property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdresseEtudiant() {
        return adresseEtudiant;
    }

    /**
     * Sets the value of the adresseEtudiant property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdresseEtudiant(String value) {
        this.adresseEtudiant = value;
    }

    /**
     * Gets the value of the annee property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnnee() {
        return annee;
    }

    /**
     * Sets the value of the annee property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnnee(String value) {
        this.annee = value;
    }

    /**
     * Gets the value of the assurance property.
     * 
     * @return
     *     possible object is
     *     {@link AssuranceDTO }
     *     
     */
    public AssuranceDTO getAssurance() {
        return assurance;
    }

    /**
     * Sets the value of the assurance property.
     * 
     * @param value
     *     allowed object is
     *     {@link AssuranceDTO }
     *     
     */
    public void setAssurance(AssuranceDTO value) {
        this.assurance = value;
    }

    /**
     * Gets the value of the avantagesNature property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAvantagesNature() {
        return avantagesNature;
    }

    /**
     * Sets the value of the avantagesNature property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAvantagesNature(String value) {
        this.avantagesNature = value;
    }

    /**
     * Gets the value of the caisseRegime property.
     * 
     * @return
     *     possible object is
     *     {@link CaisseRegimeDTO }
     *     
     */
    public CaisseRegimeDTO getCaisseRegime() {
        return caisseRegime;
    }

    /**
     * Sets the value of the caisseRegime property.
     * 
     * @param value
     *     allowed object is
     *     {@link CaisseRegimeDTO }
     *     
     */
    public void setCaisseRegime(CaisseRegimeDTO value) {
        this.caisseRegime = value;
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
     * Gets the value of the codeCaisse property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeCaisse() {
        return codeCaisse;
    }

    /**
     * Sets the value of the codeCaisse property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeCaisse(String value) {
        this.codeCaisse = value;
    }

    /**
     * Gets the value of the codeCursusLMD property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeCursusLMD() {
        return codeCursusLMD;
    }

    /**
     * Sets the value of the codeCursusLMD property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeCursusLMD(String value) {
        this.codeCursusLMD = value;
    }

    /**
     * Gets the value of the codeDepartement property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeDepartement() {
        return codeDepartement;
    }

    /**
     * Sets the value of the codeDepartement property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeDepartement(String value) {
        this.codeDepartement = value;
    }

    /**
     * Gets the value of the codeElp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeElp() {
        return codeElp;
    }

    /**
     * Sets the value of the codeElp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeElp(String value) {
        this.codeElp = value;
    }

    /**
     * Gets the value of the codeEtape property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeEtape() {
        return codeEtape;
    }

    /**
     * Sets the value of the codeEtape property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeEtape(String value) {
        this.codeEtape = value;
    }

    /**
     * Gets the value of the codeFinalite property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeFinalite() {
        return codeFinalite;
    }

    /**
     * Sets the value of the codeFinalite property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeFinalite(String value) {
        this.codeFinalite = value;
    }

    /**
     * Gets the value of the codeLangueConvention property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeLangueConvention() {
        return codeLangueConvention;
    }

    /**
     * Sets the value of the codeLangueConvention property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeLangueConvention(String value) {
        this.codeLangueConvention = value;
    }

    /**
     * Gets the value of the codePostalEtudiant property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodePostalEtudiant() {
        return codePostalEtudiant;
    }

    /**
     * Sets the value of the codePostalEtudiant property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodePostalEtudiant(String value) {
        this.codePostalEtudiant = value;
    }

    /**
     * Gets the value of the codeRGI property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeRGI() {
        return codeRGI;
    }

    /**
     * Sets the value of the codeRGI property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeRGI(String value) {
        this.codeRGI = value;
    }

    /**
     * Gets the value of the codeUFR property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeUFR() {
        return codeUFR;
    }

    /**
     * Sets the value of the codeUFR property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeUFR(String value) {
        this.codeUFR = value;
    }

    /**
     * Gets the value of the codeUniversiteEtape property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeUniversiteEtape() {
        return codeUniversiteEtape;
    }

    /**
     * Sets the value of the codeUniversiteEtape property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeUniversiteEtape(String value) {
        this.codeUniversiteEtape = value;
    }

    /**
     * Gets the value of the codeUniversiteUFR property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeUniversiteUFR() {
        return codeUniversiteUFR;
    }

    /**
     * Sets the value of the codeUniversiteUFR property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeUniversiteUFR(String value) {
        this.codeUniversiteUFR = value;
    }

    /**
     * Gets the value of the commentaireDureeTravail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommentaireDureeTravail() {
        return commentaireDureeTravail;
    }

    /**
     * Sets the value of the commentaireDureeTravail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommentaireDureeTravail(String value) {
        this.commentaireDureeTravail = value;
    }

    /**
     * Gets the value of the commentaireStage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommentaireStage() {
        return commentaireStage;
    }

    /**
     * Sets the value of the commentaireStage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommentaireStage(String value) {
        this.commentaireStage = value;
    }

    /**
     * Gets the value of the contact property.
     * 
     * @return
     *     possible object is
     *     {@link ContactDTO }
     *     
     */
    public ContactDTO getContact() {
        return contact;
    }

    /**
     * Sets the value of the contact property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContactDTO }
     *     
     */
    public void setContact(ContactDTO value) {
        this.contact = value;
    }

    /**
     * Gets the value of the conventionStructure property.
     * 
     */
    public boolean isConventionStructure() {
        return conventionStructure;
    }

    /**
     * Sets the value of the conventionStructure property.
     * 
     */
    public void setConventionStructure(boolean value) {
        this.conventionStructure = value;
    }

    /**
     * Gets the value of the conversionEnContrat property.
     * 
     */
    public boolean isConversionEnContrat() {
        return conversionEnContrat;
    }

    /**
     * Sets the value of the conversionEnContrat property.
     * 
     */
    public void setConversionEnContrat(boolean value) {
        this.conversionEnContrat = value;
    }

    /**
     * Gets the value of the courrielPersoEtudiant property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCourrielPersoEtudiant() {
        return courrielPersoEtudiant;
    }

    /**
     * Sets the value of the courrielPersoEtudiant property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCourrielPersoEtudiant(String value) {
        this.courrielPersoEtudiant = value;
    }

    /**
     * Gets the value of the creditECTS property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCreditECTS() {
        return creditECTS;
    }

    /**
     * Sets the value of the creditECTS property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCreditECTS(BigDecimal value) {
        this.creditECTS = value;
    }

    /**
     * Gets the value of the dateDebutInterruption property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateDebutInterruption() {
        return dateDebutInterruption;
    }

    /**
     * Sets the value of the dateDebutInterruption property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateDebutInterruption(XMLGregorianCalendar value) {
        this.dateDebutInterruption = value;
    }

    /**
     * Gets the value of the dateDebutStage property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateDebutStage() {
        return dateDebutStage;
    }

    /**
     * Sets the value of the dateDebutStage property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateDebutStage(XMLGregorianCalendar value) {
        this.dateDebutStage = value;
    }

    /**
     * Gets the value of the dateFinInterruption property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateFinInterruption() {
        return dateFinInterruption;
    }

    /**
     * Sets the value of the dateFinInterruption property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateFinInterruption(XMLGregorianCalendar value) {
        this.dateFinInterruption = value;
    }

    /**
     * Gets the value of the dateFinStage property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateFinStage() {
        return dateFinStage;
    }

    /**
     * Sets the value of the dateFinStage property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateFinStage(XMLGregorianCalendar value) {
        this.dateFinStage = value;
    }

    /**
     * Gets the value of the dateSignature property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateSignature() {
        return dateSignature;
    }

    /**
     * Sets the value of the dateSignature property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateSignature(XMLGregorianCalendar value) {
        this.dateSignature = value;
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
     * Gets the value of the details property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDetails() {
        return details;
    }

    /**
     * Sets the value of the details property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDetails(String value) {
        this.details = value;
    }

    /**
     * Gets the value of the dureeExceptionnelle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDureeExceptionnelle() {
        return dureeExceptionnelle;
    }

    /**
     * Sets the value of the dureeExceptionnelle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDureeExceptionnelle(String value) {
        this.dureeExceptionnelle = value;
    }

    /**
     * Gets the value of the dureeStage property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDureeStage() {
        return dureeStage;
    }

    /**
     * Sets the value of the dureeStage property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDureeStage(Integer value) {
        this.dureeStage = value;
    }

    /**
     * Gets the value of the enseignant property.
     * 
     * @return
     *     possible object is
     *     {@link EnseignantDTO }
     *     
     */
    public EnseignantDTO getEnseignant() {
        return enseignant;
    }

    /**
     * Sets the value of the enseignant property.
     * 
     * @param value
     *     allowed object is
     *     {@link EnseignantDTO }
     *     
     */
    public void setEnseignant(EnseignantDTO value) {
        this.enseignant = value;
    }

    /**
     * Gets the value of the etape property.
     * 
     * @return
     *     possible object is
     *     {@link EtapeDTO }
     *     
     */
    public EtapeDTO getEtape() {
        return etape;
    }

    /**
     * Sets the value of the etape property.
     * 
     * @param value
     *     allowed object is
     *     {@link EtapeDTO }
     *     
     */
    public void setEtape(EtapeDTO value) {
        this.etape = value;
    }

    /**
     * Gets the value of the etudiant property.
     * 
     * @return
     *     possible object is
     *     {@link EtudiantDTO }
     *     
     */
    public EtudiantDTO getEtudiant() {
        return etudiant;
    }

    /**
     * Sets the value of the etudiant property.
     * 
     * @param value
     *     allowed object is
     *     {@link EtudiantDTO }
     *     
     */
    public void setEtudiant(EtudiantDTO value) {
        this.etudiant = value;
    }

    /**
     * Gets the value of the fonctionsEtTaches property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFonctionsEtTaches() {
        return fonctionsEtTaches;
    }

    /**
     * Sets the value of the fonctionsEtTaches property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFonctionsEtTaches(String value) {
        this.fonctionsEtTaches = value;
    }

    /**
     * Gets the value of the idAssurance property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdAssurance() {
        return idAssurance;
    }

    /**
     * Sets the value of the idAssurance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdAssurance(Integer value) {
        this.idAssurance = value;
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
     * Gets the value of the idContact property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdContact() {
        return idContact;
    }

    /**
     * Sets the value of the idContact property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdContact(Integer value) {
        this.idContact = value;
    }

    /**
     * Gets the value of the idConvention property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdConvention() {
        return idConvention;
    }

    /**
     * Sets the value of the idConvention property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdConvention(Integer value) {
        this.idConvention = value;
    }

    /**
     * Gets the value of the idEnseignant property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdEnseignant() {
        return idEnseignant;
    }

    /**
     * Sets the value of the idEnseignant property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdEnseignant(Integer value) {
        this.idEnseignant = value;
    }

    /**
     * Gets the value of the idEtudiant property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdEtudiant() {
        return idEtudiant;
    }

    /**
     * Sets the value of the idEtudiant property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdEtudiant(Integer value) {
        this.idEtudiant = value;
    }

    /**
     * Gets the value of the idFicheEvaluation property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdFicheEvaluation() {
        return idFicheEvaluation;
    }

    /**
     * Sets the value of the idFicheEvaluation property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdFicheEvaluation(Integer value) {
        this.idFicheEvaluation = value;
    }

    /**
     * Gets the value of the idIndemnisation property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdIndemnisation() {
        return idIndemnisation;
    }

    /**
     * Sets the value of the idIndemnisation property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdIndemnisation(Integer value) {
        this.idIndemnisation = value;
    }

    /**
     * Gets the value of the idModeValidationStage property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdModeValidationStage() {
        return idModeValidationStage;
    }

    /**
     * Sets the value of the idModeValidationStage property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdModeValidationStage(Integer value) {
        this.idModeValidationStage = value;
    }

    /**
     * Gets the value of the idModeVersGratification property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdModeVersGratification() {
        return idModeVersGratification;
    }

    /**
     * Sets the value of the idModeVersGratification property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdModeVersGratification(Integer value) {
        this.idModeVersGratification = value;
    }

    /**
     * Gets the value of the idNatureTravail property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdNatureTravail() {
        return idNatureTravail;
    }

    /**
     * Sets the value of the idNatureTravail property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdNatureTravail(Integer value) {
        this.idNatureTravail = value;
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
     * Gets the value of the idOrigineStage property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdOrigineStage() {
        return idOrigineStage;
    }

    /**
     * Sets the value of the idOrigineStage property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdOrigineStage(Integer value) {
        this.idOrigineStage = value;
    }

    /**
     * Gets the value of the idService property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdService() {
        return idService;
    }

    /**
     * Sets the value of the idService property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdService(Integer value) {
        this.idService = value;
    }

    /**
     * Gets the value of the idSignataire property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdSignataire() {
        return idSignataire;
    }

    /**
     * Sets the value of the idSignataire property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdSignataire(Integer value) {
        this.idSignataire = value;
    }

    /**
     * Gets the value of the idStructure property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdStructure() {
        return idStructure;
    }

    /**
     * Sets the value of the idStructure property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdStructure(Integer value) {
        this.idStructure = value;
    }

    /**
     * Gets the value of the idTempsTravail property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdTempsTravail() {
        return idTempsTravail;
    }

    /**
     * Sets the value of the idTempsTravail property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdTempsTravail(Integer value) {
        this.idTempsTravail = value;
    }

    /**
     * Gets the value of the idTheme property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdTheme() {
        return idTheme;
    }

    /**
     * Sets the value of the idTheme property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdTheme(Integer value) {
        this.idTheme = value;
    }

    /**
     * Gets the value of the idTypeConvention property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdTypeConvention() {
        return idTypeConvention;
    }

    /**
     * Sets the value of the idTypeConvention property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdTypeConvention(Integer value) {
        this.idTypeConvention = value;
    }

    /**
     * Gets the value of the idUniteDureeExceptionnelle property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdUniteDureeExceptionnelle() {
        return idUniteDureeExceptionnelle;
    }

    /**
     * Sets the value of the idUniteDureeExceptionnelle property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdUniteDureeExceptionnelle(Integer value) {
        this.idUniteDureeExceptionnelle = value;
    }

    /**
     * Gets the value of the idUniteGratification property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdUniteGratification() {
        return idUniteGratification;
    }

    /**
     * Sets the value of the idUniteGratification property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdUniteGratification(Integer value) {
        this.idUniteGratification = value;
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
     * Gets the value of the insee property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInsee() {
        return insee;
    }

    /**
     * Sets the value of the insee property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInsee(String value) {
        this.insee = value;
    }

    /**
     * Gets the value of the interruptionStage property.
     * 
     */
    public boolean isInterruptionStage() {
        return interruptionStage;
    }

    /**
     * Sets the value of the interruptionStage property.
     * 
     */
    public void setInterruptionStage(boolean value) {
        this.interruptionStage = value;
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
     * Gets the value of the libelleCPAM property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibelleCPAM() {
        return libelleCPAM;
    }

    /**
     * Sets the value of the libelleCPAM property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibelleCPAM(String value) {
        this.libelleCPAM = value;
    }

    /**
     * Gets the value of the libelleELP property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibelleELP() {
        return libelleELP;
    }

    /**
     * Sets the value of the libelleELP property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibelleELP(String value) {
        this.libelleELP = value;
    }

    /**
     * Gets the value of the libelleFinalite property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibelleFinalite() {
        return libelleFinalite;
    }

    /**
     * Sets the value of the libelleFinalite property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibelleFinalite(String value) {
        this.libelleFinalite = value;
    }

    /**
     * Gets the value of the loginSignature property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoginSignature() {
        return loginSignature;
    }

    /**
     * Sets the value of the loginSignature property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoginSignature(String value) {
        this.loginSignature = value;
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
     * Gets the value of the modeEncadreSuivi property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModeEncadreSuivi() {
        return modeEncadreSuivi;
    }

    /**
     * Sets the value of the modeEncadreSuivi property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModeEncadreSuivi(String value) {
        this.modeEncadreSuivi = value;
    }

    /**
     * Gets the value of the modeValidationStage property.
     * 
     * @return
     *     possible object is
     *     {@link ModeValidationStageDTO }
     *     
     */
    public ModeValidationStageDTO getModeValidationStage() {
        return modeValidationStage;
    }

    /**
     * Sets the value of the modeValidationStage property.
     * 
     * @param value
     *     allowed object is
     *     {@link ModeValidationStageDTO }
     *     
     */
    public void setModeValidationStage(ModeValidationStageDTO value) {
        this.modeValidationStage = value;
    }

    /**
     * Gets the value of the modeVersGratification property.
     * 
     * @return
     *     possible object is
     *     {@link ModeVersGratificationDTO }
     *     
     */
    public ModeVersGratificationDTO getModeVersGratification() {
        return modeVersGratification;
    }

    /**
     * Sets the value of the modeVersGratification property.
     * 
     * @param value
     *     allowed object is
     *     {@link ModeVersGratificationDTO }
     *     
     */
    public void setModeVersGratification(ModeVersGratificationDTO value) {
        this.modeVersGratification = value;
    }

    /**
     * Gets the value of the montantGratification property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMontantGratification() {
        return montantGratification;
    }

    /**
     * Sets the value of the montantGratification property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMontantGratification(String value) {
        this.montantGratification = value;
    }

    /**
     * Gets the value of the natureTravail property.
     * 
     * @return
     *     possible object is
     *     {@link NatureTravailDTO }
     *     
     */
    public NatureTravailDTO getNatureTravail() {
        return natureTravail;
    }

    /**
     * Sets the value of the natureTravail property.
     * 
     * @param value
     *     allowed object is
     *     {@link NatureTravailDTO }
     *     
     */
    public void setNatureTravail(NatureTravailDTO value) {
        this.natureTravail = value;
    }

    /**
     * Gets the value of the nbAvenant property.
     * 
     */
    public int getNbAvenant() {
        return nbAvenant;
    }

    /**
     * Sets the value of the nbAvenant property.
     * 
     */
    public void setNbAvenant(int value) {
        this.nbAvenant = value;
    }

    /**
     * Gets the value of the nbHeuresHebdo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNbHeuresHebdo() {
        return nbHeuresHebdo;
    }

    /**
     * Sets the value of the nbHeuresHebdo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNbHeuresHebdo(String value) {
        this.nbHeuresHebdo = value;
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
     * Gets the value of the nomEtabRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomEtabRef() {
        return nomEtabRef;
    }

    /**
     * Sets the value of the nomEtabRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomEtabRef(String value) {
        this.nomEtabRef = value;
    }

    /**
     * Gets the value of the nomSignataireComposante property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomSignataireComposante() {
        return nomSignataireComposante;
    }

    /**
     * Sets the value of the nomSignataireComposante property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomSignataireComposante(String value) {
        this.nomSignataireComposante = value;
    }

    /**
     * Gets the value of the origineStage property.
     * 
     * @return
     *     possible object is
     *     {@link OrigineStageDTO }
     *     
     */
    public OrigineStageDTO getOrigineStage() {
        return origineStage;
    }

    /**
     * Sets the value of the origineStage property.
     * 
     * @param value
     *     allowed object is
     *     {@link OrigineStageDTO }
     *     
     */
    public void setOrigineStage(OrigineStageDTO value) {
        this.origineStage = value;
    }

    /**
     * Gets the value of the paysEtudiant property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaysEtudiant() {
        return paysEtudiant;
    }

    /**
     * Sets the value of the paysEtudiant property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaysEtudiant(String value) {
        this.paysEtudiant = value;
    }

    /**
     * Gets the value of the priseEnChargeFraisMission property.
     * 
     */
    public boolean isPriseEnChargeFraisMission() {
        return priseEnChargeFraisMission;
    }

    /**
     * Sets the value of the priseEnChargeFraisMission property.
     * 
     */
    public void setPriseEnChargeFraisMission(boolean value) {
        this.priseEnChargeFraisMission = value;
    }

    /**
     * Gets the value of the qualiteSignataire property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQualiteSignataire() {
        return qualiteSignataire;
    }

    /**
     * Sets the value of the qualiteSignataire property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQualiteSignataire(String value) {
        this.qualiteSignataire = value;
    }

    /**
     * Gets the value of the quotiteTravail property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getQuotiteTravail() {
        return quotiteTravail;
    }

    /**
     * Sets the value of the quotiteTravail property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setQuotiteTravail(Integer value) {
        this.quotiteTravail = value;
    }

    /**
     * Gets the value of the selected property.
     * 
     */
    public boolean isSelected() {
        return selected;
    }

    /**
     * Sets the value of the selected property.
     * 
     */
    public void setSelected(boolean value) {
        this.selected = value;
    }

    /**
     * Gets the value of the service property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceDTO }
     *     
     */
    public ServiceDTO getService() {
        return service;
    }

    /**
     * Sets the value of the service property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceDTO }
     *     
     */
    public void setService(ServiceDTO value) {
        this.service = value;
    }

    /**
     * Gets the value of the signataire property.
     * 
     * @return
     *     possible object is
     *     {@link ContactDTO }
     *     
     */
    public ContactDTO getSignataire() {
        return signataire;
    }

    /**
     * Sets the value of the signataire property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContactDTO }
     *     
     */
    public void setSignataire(ContactDTO value) {
        this.signataire = value;
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
     * Gets the value of the telEtudiant property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelEtudiant() {
        return telEtudiant;
    }

    /**
     * Sets the value of the telEtudiant property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelEtudiant(String value) {
        this.telEtudiant = value;
    }

    /**
     * Gets the value of the telPortableEtudiant property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelPortableEtudiant() {
        return telPortableEtudiant;
    }

    /**
     * Sets the value of the telPortableEtudiant property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelPortableEtudiant(String value) {
        this.telPortableEtudiant = value;
    }

    /**
     * Gets the value of the temConfSujetTeme property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemConfSujetTeme() {
        return temConfSujetTeme;
    }

    /**
     * Sets the value of the temConfSujetTeme property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemConfSujetTeme(String value) {
        this.temConfSujetTeme = value;
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
     * Gets the value of the travailNuitFerie property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTravailNuitFerie() {
        return travailNuitFerie;
    }

    /**
     * Sets the value of the travailNuitFerie property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTravailNuitFerie(String value) {
        this.travailNuitFerie = value;
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
     * Gets the value of the ufr property.
     * 
     * @return
     *     possible object is
     *     {@link UfrDTO }
     *     
     */
    public UfrDTO getUfr() {
        return ufr;
    }

    /**
     * Sets the value of the ufr property.
     * 
     * @param value
     *     allowed object is
     *     {@link UfrDTO }
     *     
     */
    public void setUfr(UfrDTO value) {
        this.ufr = value;
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
     * Gets the value of the uniteGratification property.
     * 
     * @return
     *     possible object is
     *     {@link UniteGratificationDTO }
     *     
     */
    public UniteGratificationDTO getUniteGratification() {
        return uniteGratification;
    }

    /**
     * Sets the value of the uniteGratification property.
     * 
     * @param value
     *     allowed object is
     *     {@link UniteGratificationDTO }
     *     
     */
    public void setUniteGratification(UniteGratificationDTO value) {
        this.uniteGratification = value;
    }

    /**
     * Gets the value of the validationConvention property.
     * 
     */
    public boolean isValidationConvention() {
        return validationConvention;
    }

    /**
     * Sets the value of the validationConvention property.
     * 
     */
    public void setValidationConvention(boolean value) {
        this.validationConvention = value;
    }

    /**
     * Gets the value of the villeEtudiant property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVilleEtudiant() {
        return villeEtudiant;
    }

    /**
     * Sets the value of the villeEtudiant property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVilleEtudiant(String value) {
        this.villeEtudiant = value;
    }

}
