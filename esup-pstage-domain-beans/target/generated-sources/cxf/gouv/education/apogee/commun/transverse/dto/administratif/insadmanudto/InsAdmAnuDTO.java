
package gouv.education.apogee.commun.transverse.dto.administratif.insadmanudto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import gouv.education.apogee.commun.transverse.dto.administratif.aidefinancieredto.AideFinanciereDTO;
import gouv.education.apogee.commun.transverse.dto.administratif.catsocprofdto.CatSocProfDTO;
import gouv.education.apogee.commun.transverse.dto.administratif.departementdto.DepartementDTO;
import gouv.education.apogee.commun.transverse.dto.administratif.domaineactiviteprofdto.DomaineActiviteProfDTO;
import gouv.education.apogee.commun.transverse.dto.administratif.etablissementdto.EtablissementDTO;
import gouv.education.apogee.commun.transverse.dto.administratif.etatiaadto.EtatIAADTO;
import gouv.education.apogee.commun.transverse.dto.administratif.paysdto.PaysDTO;
import gouv.education.apogee.commun.transverse.dto.administratif.prgechangedto.PrgEchangeDTO;
import gouv.education.apogee.commun.transverse.dto.administratif.profiletudto.ProfilEtuDTO;
import gouv.education.apogee.commun.transverse.dto.administratif.quotitetravdto.QuotiteTravDTO;
import gouv.education.apogee.commun.transverse.dto.administratif.regimeinsdto.RegimeInsDTO;
import gouv.education.apogee.commun.transverse.dto.administratif.situationsisedto.SituationSISEDTO;
import gouv.education.apogee.commun.transverse.dto.administratif.spohautnivdto.SpoHautNivDTO;
import gouv.education.apogee.commun.transverse.dto.administratif.statutetudto.StatutEtuDTO;
import gouv.education.apogee.commun.transverse.dto.administratif.typdiplomeextdto.TypDiplomeExtDTO;
import gouv.education.apogee.commun.transverse.dto.administratif.typdiplomesisedto.TypDiplomeSISEDTO;
import gouv.education.apogee.commun.transverse.dto.administratif.typeetablissementdto.TypeEtablissementDTO;


/**
 * <p>Java class for InsAdmAnuDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InsAdmAnuDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="aideFinanciere" type="{AideFinanciereDTO.administratif.dto.transverse.commun.apogee.education.gouv}AideFinanciereDTO"/>
 *         &lt;element name="anneeDernierDiplome" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="anneeDernierEtbFreq" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="anneeIAA" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="autreEtbAnneeEnCours" type="{EtablissementDTO.administratif.dto.transverse.commun.apogee.education.gouv}EtablissementDTO"/>
 *         &lt;element name="catSocProfChefFamille" type="{CatSocProfDTO.administratif.dto.transverse.commun.apogee.education.gouv}CatSocProfDTO"/>
 *         &lt;element name="catSocProfEtu" type="{CatSocProfDTO.administratif.dto.transverse.commun.apogee.education.gouv}CatSocProfDTO"/>
 *         &lt;element name="codeTransfertDossier" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dateIAA" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="departementDernierDiplomeExt" type="{DepartementDTO.administratif.dto.transverse.commun.apogee.education.gouv}DepartementDTO"/>
 *         &lt;element name="departementDernierEtbFreq" type="{DepartementDTO.administratif.dto.transverse.commun.apogee.education.gouv}DepartementDTO"/>
 *         &lt;element name="departementEtbAnneeEnCours" type="{DepartementDTO.administratif.dto.transverse.commun.apogee.education.gouv}DepartementDTO"/>
 *         &lt;element name="departementEtbAnneePrec" type="{DepartementDTO.administratif.dto.transverse.commun.apogee.education.gouv}DepartementDTO"/>
 *         &lt;element name="dernierEtbFreq" type="{EtablissementDTO.administratif.dto.transverse.commun.apogee.education.gouv}EtablissementDTO"/>
 *         &lt;element name="domaineActiviteProf" type="{DomaineActiviteProfDTO.administratif.dto.transverse.commun.apogee.education.gouv}DomaineActiviteProfDTO"/>
 *         &lt;element name="etatIaa" type="{EtatIAADTO.administratif.dto.transverse.commun.apogee.education.gouv}EtatIAADTO"/>
 *         &lt;element name="etbAnneePrec" type="{EtablissementDTO.administratif.dto.transverse.commun.apogee.education.gouv}EtablissementDTO"/>
 *         &lt;element name="etbDernierDiplomeExt" type="{EtablissementDTO.administratif.dto.transverse.commun.apogee.education.gouv}EtablissementDTO"/>
 *         &lt;element name="libTransfertDossier" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="paysDernierDiplomeExt" type="{PaysDTO.administratif.dto.transverse.commun.apogee.education.gouv}PaysDTO"/>
 *         &lt;element name="paysDernierEtbFreq" type="{PaysDTO.administratif.dto.transverse.commun.apogee.education.gouv}PaysDTO"/>
 *         &lt;element name="paysEtbAnneePrec" type="{PaysDTO.administratif.dto.transverse.commun.apogee.education.gouv}PaysDTO"/>
 *         &lt;element name="prgEchange" type="{PrgEchangeDTO.administratif.dto.transverse.commun.apogee.education.gouv}PrgEchangeDTO"/>
 *         &lt;element name="profil" type="{ProfilEtuDTO.administratif.dto.transverse.commun.apogee.education.gouv}ProfilEtuDTO"/>
 *         &lt;element name="quotiteTrav" type="{QuotiteTravDTO.administratif.dto.transverse.commun.apogee.education.gouv}QuotiteTravDTO"/>
 *         &lt;element name="regimeIns" type="{RegimeInsDTO.administratif.dto.transverse.commun.apogee.education.gouv}RegimeInsDTO"/>
 *         &lt;element name="situationAnneePrec" type="{SituationSISEDTO.administratif.dto.transverse.commun.apogee.education.gouv}SituationSISEDTO"/>
 *         &lt;element name="sportifHautNiveau" type="{SpoHautNivDTO.administratif.dto.transverse.commun.apogee.education.gouv}SpoHautNivDTO"/>
 *         &lt;element name="statut" type="{StatutEtuDTO.administratif.dto.transverse.commun.apogee.education.gouv}StatutEtuDTO"/>
 *         &lt;element name="temRgmAmgEtuIAA" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="temoinAffiliationSS" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="temoinAyantDroitAuto" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="typeAutreEtbAnneeEnCours" type="{TypeEtablissementDTO.administratif.dto.transverse.commun.apogee.education.gouv}TypeEtablissementDTO"/>
 *         &lt;element name="typeDernierDiplomeExt" type="{TypDiplomeExtDTO.administratif.dto.transverse.commun.apogee.education.gouv}TypDiplomeExtDTO"/>
 *         &lt;element name="typeEtbDernierEtbFreq" type="{TypeEtablissementDTO.administratif.dto.transverse.commun.apogee.education.gouv}TypeEtablissementDTO"/>
 *         &lt;element name="typeSISEDernierDiplomeExt" type="{TypDiplomeSISEDTO.administratif.dto.transverse.commun.apogee.education.gouv}TypDiplomeSISEDTO"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InsAdmAnuDTO", propOrder = {
    "aideFinanciere",
    "anneeDernierDiplome",
    "anneeDernierEtbFreq",
    "anneeIAA",
    "autreEtbAnneeEnCours",
    "catSocProfChefFamille",
    "catSocProfEtu",
    "codeTransfertDossier",
    "dateIAA",
    "departementDernierDiplomeExt",
    "departementDernierEtbFreq",
    "departementEtbAnneeEnCours",
    "departementEtbAnneePrec",
    "dernierEtbFreq",
    "domaineActiviteProf",
    "etatIaa",
    "etbAnneePrec",
    "etbDernierDiplomeExt",
    "libTransfertDossier",
    "paysDernierDiplomeExt",
    "paysDernierEtbFreq",
    "paysEtbAnneePrec",
    "prgEchange",
    "profil",
    "quotiteTrav",
    "regimeIns",
    "situationAnneePrec",
    "sportifHautNiveau",
    "statut",
    "temRgmAmgEtuIAA",
    "temoinAffiliationSS",
    "temoinAyantDroitAuto",
    "typeAutreEtbAnneeEnCours",
    "typeDernierDiplomeExt",
    "typeEtbDernierEtbFreq",
    "typeSISEDernierDiplomeExt"
})
public class InsAdmAnuDTO {

    @XmlElement(required = true, nillable = true)
    protected AideFinanciereDTO aideFinanciere;
    @XmlElement(required = true, nillable = true)
    protected String anneeDernierDiplome;
    @XmlElement(required = true, nillable = true)
    protected String anneeDernierEtbFreq;
    @XmlElement(required = true, nillable = true)
    protected String anneeIAA;
    @XmlElement(required = true, nillable = true)
    protected EtablissementDTO autreEtbAnneeEnCours;
    @XmlElement(required = true, nillable = true)
    protected CatSocProfDTO catSocProfChefFamille;
    @XmlElement(required = true, nillable = true)
    protected CatSocProfDTO catSocProfEtu;
    @XmlElement(required = true, nillable = true)
    protected String codeTransfertDossier;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateIAA;
    @XmlElement(required = true, nillable = true)
    protected DepartementDTO departementDernierDiplomeExt;
    @XmlElement(required = true, nillable = true)
    protected DepartementDTO departementDernierEtbFreq;
    @XmlElement(required = true, nillable = true)
    protected DepartementDTO departementEtbAnneeEnCours;
    @XmlElement(required = true, nillable = true)
    protected DepartementDTO departementEtbAnneePrec;
    @XmlElement(required = true, nillable = true)
    protected EtablissementDTO dernierEtbFreq;
    @XmlElement(required = true, nillable = true)
    protected DomaineActiviteProfDTO domaineActiviteProf;
    @XmlElement(required = true, nillable = true)
    protected EtatIAADTO etatIaa;
    @XmlElement(required = true, nillable = true)
    protected EtablissementDTO etbAnneePrec;
    @XmlElement(required = true, nillable = true)
    protected EtablissementDTO etbDernierDiplomeExt;
    @XmlElement(required = true, nillable = true)
    protected String libTransfertDossier;
    @XmlElement(required = true, nillable = true)
    protected PaysDTO paysDernierDiplomeExt;
    @XmlElement(required = true, nillable = true)
    protected PaysDTO paysDernierEtbFreq;
    @XmlElement(required = true, nillable = true)
    protected PaysDTO paysEtbAnneePrec;
    @XmlElement(required = true, nillable = true)
    protected PrgEchangeDTO prgEchange;
    @XmlElement(required = true, nillable = true)
    protected ProfilEtuDTO profil;
    @XmlElement(required = true, nillable = true)
    protected QuotiteTravDTO quotiteTrav;
    @XmlElement(required = true, nillable = true)
    protected RegimeInsDTO regimeIns;
    @XmlElement(required = true, nillable = true)
    protected SituationSISEDTO situationAnneePrec;
    @XmlElement(required = true, nillable = true)
    protected SpoHautNivDTO sportifHautNiveau;
    @XmlElement(required = true, nillable = true)
    protected StatutEtuDTO statut;
    @XmlElement(required = true, nillable = true)
    protected String temRgmAmgEtuIAA;
    @XmlElement(required = true, nillable = true)
    protected String temoinAffiliationSS;
    @XmlElement(required = true, nillable = true)
    protected String temoinAyantDroitAuto;
    @XmlElement(required = true, nillable = true)
    protected TypeEtablissementDTO typeAutreEtbAnneeEnCours;
    @XmlElement(required = true, nillable = true)
    protected TypDiplomeExtDTO typeDernierDiplomeExt;
    @XmlElement(required = true, nillable = true)
    protected TypeEtablissementDTO typeEtbDernierEtbFreq;
    @XmlElement(required = true, nillable = true)
    protected TypDiplomeSISEDTO typeSISEDernierDiplomeExt;

    /**
     * Gets the value of the aideFinanciere property.
     * 
     * @return
     *     possible object is
     *     {@link AideFinanciereDTO }
     *     
     */
    public AideFinanciereDTO getAideFinanciere() {
        return aideFinanciere;
    }

    /**
     * Sets the value of the aideFinanciere property.
     * 
     * @param value
     *     allowed object is
     *     {@link AideFinanciereDTO }
     *     
     */
    public void setAideFinanciere(AideFinanciereDTO value) {
        this.aideFinanciere = value;
    }

    /**
     * Gets the value of the anneeDernierDiplome property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnneeDernierDiplome() {
        return anneeDernierDiplome;
    }

    /**
     * Sets the value of the anneeDernierDiplome property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnneeDernierDiplome(String value) {
        this.anneeDernierDiplome = value;
    }

    /**
     * Gets the value of the anneeDernierEtbFreq property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnneeDernierEtbFreq() {
        return anneeDernierEtbFreq;
    }

    /**
     * Sets the value of the anneeDernierEtbFreq property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnneeDernierEtbFreq(String value) {
        this.anneeDernierEtbFreq = value;
    }

    /**
     * Gets the value of the anneeIAA property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnneeIAA() {
        return anneeIAA;
    }

    /**
     * Sets the value of the anneeIAA property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnneeIAA(String value) {
        this.anneeIAA = value;
    }

    /**
     * Gets the value of the autreEtbAnneeEnCours property.
     * 
     * @return
     *     possible object is
     *     {@link EtablissementDTO }
     *     
     */
    public EtablissementDTO getAutreEtbAnneeEnCours() {
        return autreEtbAnneeEnCours;
    }

    /**
     * Sets the value of the autreEtbAnneeEnCours property.
     * 
     * @param value
     *     allowed object is
     *     {@link EtablissementDTO }
     *     
     */
    public void setAutreEtbAnneeEnCours(EtablissementDTO value) {
        this.autreEtbAnneeEnCours = value;
    }

    /**
     * Gets the value of the catSocProfChefFamille property.
     * 
     * @return
     *     possible object is
     *     {@link CatSocProfDTO }
     *     
     */
    public CatSocProfDTO getCatSocProfChefFamille() {
        return catSocProfChefFamille;
    }

    /**
     * Sets the value of the catSocProfChefFamille property.
     * 
     * @param value
     *     allowed object is
     *     {@link CatSocProfDTO }
     *     
     */
    public void setCatSocProfChefFamille(CatSocProfDTO value) {
        this.catSocProfChefFamille = value;
    }

    /**
     * Gets the value of the catSocProfEtu property.
     * 
     * @return
     *     possible object is
     *     {@link CatSocProfDTO }
     *     
     */
    public CatSocProfDTO getCatSocProfEtu() {
        return catSocProfEtu;
    }

    /**
     * Sets the value of the catSocProfEtu property.
     * 
     * @param value
     *     allowed object is
     *     {@link CatSocProfDTO }
     *     
     */
    public void setCatSocProfEtu(CatSocProfDTO value) {
        this.catSocProfEtu = value;
    }

    /**
     * Gets the value of the codeTransfertDossier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeTransfertDossier() {
        return codeTransfertDossier;
    }

    /**
     * Sets the value of the codeTransfertDossier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeTransfertDossier(String value) {
        this.codeTransfertDossier = value;
    }

    /**
     * Gets the value of the dateIAA property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateIAA() {
        return dateIAA;
    }

    /**
     * Sets the value of the dateIAA property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateIAA(XMLGregorianCalendar value) {
        this.dateIAA = value;
    }

    /**
     * Gets the value of the departementDernierDiplomeExt property.
     * 
     * @return
     *     possible object is
     *     {@link DepartementDTO }
     *     
     */
    public DepartementDTO getDepartementDernierDiplomeExt() {
        return departementDernierDiplomeExt;
    }

    /**
     * Sets the value of the departementDernierDiplomeExt property.
     * 
     * @param value
     *     allowed object is
     *     {@link DepartementDTO }
     *     
     */
    public void setDepartementDernierDiplomeExt(DepartementDTO value) {
        this.departementDernierDiplomeExt = value;
    }

    /**
     * Gets the value of the departementDernierEtbFreq property.
     * 
     * @return
     *     possible object is
     *     {@link DepartementDTO }
     *     
     */
    public DepartementDTO getDepartementDernierEtbFreq() {
        return departementDernierEtbFreq;
    }

    /**
     * Sets the value of the departementDernierEtbFreq property.
     * 
     * @param value
     *     allowed object is
     *     {@link DepartementDTO }
     *     
     */
    public void setDepartementDernierEtbFreq(DepartementDTO value) {
        this.departementDernierEtbFreq = value;
    }

    /**
     * Gets the value of the departementEtbAnneeEnCours property.
     * 
     * @return
     *     possible object is
     *     {@link DepartementDTO }
     *     
     */
    public DepartementDTO getDepartementEtbAnneeEnCours() {
        return departementEtbAnneeEnCours;
    }

    /**
     * Sets the value of the departementEtbAnneeEnCours property.
     * 
     * @param value
     *     allowed object is
     *     {@link DepartementDTO }
     *     
     */
    public void setDepartementEtbAnneeEnCours(DepartementDTO value) {
        this.departementEtbAnneeEnCours = value;
    }

    /**
     * Gets the value of the departementEtbAnneePrec property.
     * 
     * @return
     *     possible object is
     *     {@link DepartementDTO }
     *     
     */
    public DepartementDTO getDepartementEtbAnneePrec() {
        return departementEtbAnneePrec;
    }

    /**
     * Sets the value of the departementEtbAnneePrec property.
     * 
     * @param value
     *     allowed object is
     *     {@link DepartementDTO }
     *     
     */
    public void setDepartementEtbAnneePrec(DepartementDTO value) {
        this.departementEtbAnneePrec = value;
    }

    /**
     * Gets the value of the dernierEtbFreq property.
     * 
     * @return
     *     possible object is
     *     {@link EtablissementDTO }
     *     
     */
    public EtablissementDTO getDernierEtbFreq() {
        return dernierEtbFreq;
    }

    /**
     * Sets the value of the dernierEtbFreq property.
     * 
     * @param value
     *     allowed object is
     *     {@link EtablissementDTO }
     *     
     */
    public void setDernierEtbFreq(EtablissementDTO value) {
        this.dernierEtbFreq = value;
    }

    /**
     * Gets the value of the domaineActiviteProf property.
     * 
     * @return
     *     possible object is
     *     {@link DomaineActiviteProfDTO }
     *     
     */
    public DomaineActiviteProfDTO getDomaineActiviteProf() {
        return domaineActiviteProf;
    }

    /**
     * Sets the value of the domaineActiviteProf property.
     * 
     * @param value
     *     allowed object is
     *     {@link DomaineActiviteProfDTO }
     *     
     */
    public void setDomaineActiviteProf(DomaineActiviteProfDTO value) {
        this.domaineActiviteProf = value;
    }

    /**
     * Gets the value of the etatIaa property.
     * 
     * @return
     *     possible object is
     *     {@link EtatIAADTO }
     *     
     */
    public EtatIAADTO getEtatIaa() {
        return etatIaa;
    }

    /**
     * Sets the value of the etatIaa property.
     * 
     * @param value
     *     allowed object is
     *     {@link EtatIAADTO }
     *     
     */
    public void setEtatIaa(EtatIAADTO value) {
        this.etatIaa = value;
    }

    /**
     * Gets the value of the etbAnneePrec property.
     * 
     * @return
     *     possible object is
     *     {@link EtablissementDTO }
     *     
     */
    public EtablissementDTO getEtbAnneePrec() {
        return etbAnneePrec;
    }

    /**
     * Sets the value of the etbAnneePrec property.
     * 
     * @param value
     *     allowed object is
     *     {@link EtablissementDTO }
     *     
     */
    public void setEtbAnneePrec(EtablissementDTO value) {
        this.etbAnneePrec = value;
    }

    /**
     * Gets the value of the etbDernierDiplomeExt property.
     * 
     * @return
     *     possible object is
     *     {@link EtablissementDTO }
     *     
     */
    public EtablissementDTO getEtbDernierDiplomeExt() {
        return etbDernierDiplomeExt;
    }

    /**
     * Sets the value of the etbDernierDiplomeExt property.
     * 
     * @param value
     *     allowed object is
     *     {@link EtablissementDTO }
     *     
     */
    public void setEtbDernierDiplomeExt(EtablissementDTO value) {
        this.etbDernierDiplomeExt = value;
    }

    /**
     * Gets the value of the libTransfertDossier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibTransfertDossier() {
        return libTransfertDossier;
    }

    /**
     * Sets the value of the libTransfertDossier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibTransfertDossier(String value) {
        this.libTransfertDossier = value;
    }

    /**
     * Gets the value of the paysDernierDiplomeExt property.
     * 
     * @return
     *     possible object is
     *     {@link PaysDTO }
     *     
     */
    public PaysDTO getPaysDernierDiplomeExt() {
        return paysDernierDiplomeExt;
    }

    /**
     * Sets the value of the paysDernierDiplomeExt property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaysDTO }
     *     
     */
    public void setPaysDernierDiplomeExt(PaysDTO value) {
        this.paysDernierDiplomeExt = value;
    }

    /**
     * Gets the value of the paysDernierEtbFreq property.
     * 
     * @return
     *     possible object is
     *     {@link PaysDTO }
     *     
     */
    public PaysDTO getPaysDernierEtbFreq() {
        return paysDernierEtbFreq;
    }

    /**
     * Sets the value of the paysDernierEtbFreq property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaysDTO }
     *     
     */
    public void setPaysDernierEtbFreq(PaysDTO value) {
        this.paysDernierEtbFreq = value;
    }

    /**
     * Gets the value of the paysEtbAnneePrec property.
     * 
     * @return
     *     possible object is
     *     {@link PaysDTO }
     *     
     */
    public PaysDTO getPaysEtbAnneePrec() {
        return paysEtbAnneePrec;
    }

    /**
     * Sets the value of the paysEtbAnneePrec property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaysDTO }
     *     
     */
    public void setPaysEtbAnneePrec(PaysDTO value) {
        this.paysEtbAnneePrec = value;
    }

    /**
     * Gets the value of the prgEchange property.
     * 
     * @return
     *     possible object is
     *     {@link PrgEchangeDTO }
     *     
     */
    public PrgEchangeDTO getPrgEchange() {
        return prgEchange;
    }

    /**
     * Sets the value of the prgEchange property.
     * 
     * @param value
     *     allowed object is
     *     {@link PrgEchangeDTO }
     *     
     */
    public void setPrgEchange(PrgEchangeDTO value) {
        this.prgEchange = value;
    }

    /**
     * Gets the value of the profil property.
     * 
     * @return
     *     possible object is
     *     {@link ProfilEtuDTO }
     *     
     */
    public ProfilEtuDTO getProfil() {
        return profil;
    }

    /**
     * Sets the value of the profil property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProfilEtuDTO }
     *     
     */
    public void setProfil(ProfilEtuDTO value) {
        this.profil = value;
    }

    /**
     * Gets the value of the quotiteTrav property.
     * 
     * @return
     *     possible object is
     *     {@link QuotiteTravDTO }
     *     
     */
    public QuotiteTravDTO getQuotiteTrav() {
        return quotiteTrav;
    }

    /**
     * Sets the value of the quotiteTrav property.
     * 
     * @param value
     *     allowed object is
     *     {@link QuotiteTravDTO }
     *     
     */
    public void setQuotiteTrav(QuotiteTravDTO value) {
        this.quotiteTrav = value;
    }

    /**
     * Gets the value of the regimeIns property.
     * 
     * @return
     *     possible object is
     *     {@link RegimeInsDTO }
     *     
     */
    public RegimeInsDTO getRegimeIns() {
        return regimeIns;
    }

    /**
     * Sets the value of the regimeIns property.
     * 
     * @param value
     *     allowed object is
     *     {@link RegimeInsDTO }
     *     
     */
    public void setRegimeIns(RegimeInsDTO value) {
        this.regimeIns = value;
    }

    /**
     * Gets the value of the situationAnneePrec property.
     * 
     * @return
     *     possible object is
     *     {@link SituationSISEDTO }
     *     
     */
    public SituationSISEDTO getSituationAnneePrec() {
        return situationAnneePrec;
    }

    /**
     * Sets the value of the situationAnneePrec property.
     * 
     * @param value
     *     allowed object is
     *     {@link SituationSISEDTO }
     *     
     */
    public void setSituationAnneePrec(SituationSISEDTO value) {
        this.situationAnneePrec = value;
    }

    /**
     * Gets the value of the sportifHautNiveau property.
     * 
     * @return
     *     possible object is
     *     {@link SpoHautNivDTO }
     *     
     */
    public SpoHautNivDTO getSportifHautNiveau() {
        return sportifHautNiveau;
    }

    /**
     * Sets the value of the sportifHautNiveau property.
     * 
     * @param value
     *     allowed object is
     *     {@link SpoHautNivDTO }
     *     
     */
    public void setSportifHautNiveau(SpoHautNivDTO value) {
        this.sportifHautNiveau = value;
    }

    /**
     * Gets the value of the statut property.
     * 
     * @return
     *     possible object is
     *     {@link StatutEtuDTO }
     *     
     */
    public StatutEtuDTO getStatut() {
        return statut;
    }

    /**
     * Sets the value of the statut property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatutEtuDTO }
     *     
     */
    public void setStatut(StatutEtuDTO value) {
        this.statut = value;
    }

    /**
     * Gets the value of the temRgmAmgEtuIAA property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemRgmAmgEtuIAA() {
        return temRgmAmgEtuIAA;
    }

    /**
     * Sets the value of the temRgmAmgEtuIAA property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemRgmAmgEtuIAA(String value) {
        this.temRgmAmgEtuIAA = value;
    }

    /**
     * Gets the value of the temoinAffiliationSS property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemoinAffiliationSS() {
        return temoinAffiliationSS;
    }

    /**
     * Sets the value of the temoinAffiliationSS property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemoinAffiliationSS(String value) {
        this.temoinAffiliationSS = value;
    }

    /**
     * Gets the value of the temoinAyantDroitAuto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemoinAyantDroitAuto() {
        return temoinAyantDroitAuto;
    }

    /**
     * Sets the value of the temoinAyantDroitAuto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemoinAyantDroitAuto(String value) {
        this.temoinAyantDroitAuto = value;
    }

    /**
     * Gets the value of the typeAutreEtbAnneeEnCours property.
     * 
     * @return
     *     possible object is
     *     {@link TypeEtablissementDTO }
     *     
     */
    public TypeEtablissementDTO getTypeAutreEtbAnneeEnCours() {
        return typeAutreEtbAnneeEnCours;
    }

    /**
     * Sets the value of the typeAutreEtbAnneeEnCours property.
     * 
     * @param value
     *     allowed object is
     *     {@link TypeEtablissementDTO }
     *     
     */
    public void setTypeAutreEtbAnneeEnCours(TypeEtablissementDTO value) {
        this.typeAutreEtbAnneeEnCours = value;
    }

    /**
     * Gets the value of the typeDernierDiplomeExt property.
     * 
     * @return
     *     possible object is
     *     {@link TypDiplomeExtDTO }
     *     
     */
    public TypDiplomeExtDTO getTypeDernierDiplomeExt() {
        return typeDernierDiplomeExt;
    }

    /**
     * Sets the value of the typeDernierDiplomeExt property.
     * 
     * @param value
     *     allowed object is
     *     {@link TypDiplomeExtDTO }
     *     
     */
    public void setTypeDernierDiplomeExt(TypDiplomeExtDTO value) {
        this.typeDernierDiplomeExt = value;
    }

    /**
     * Gets the value of the typeEtbDernierEtbFreq property.
     * 
     * @return
     *     possible object is
     *     {@link TypeEtablissementDTO }
     *     
     */
    public TypeEtablissementDTO getTypeEtbDernierEtbFreq() {
        return typeEtbDernierEtbFreq;
    }

    /**
     * Sets the value of the typeEtbDernierEtbFreq property.
     * 
     * @param value
     *     allowed object is
     *     {@link TypeEtablissementDTO }
     *     
     */
    public void setTypeEtbDernierEtbFreq(TypeEtablissementDTO value) {
        this.typeEtbDernierEtbFreq = value;
    }

    /**
     * Gets the value of the typeSISEDernierDiplomeExt property.
     * 
     * @return
     *     possible object is
     *     {@link TypDiplomeSISEDTO }
     *     
     */
    public TypDiplomeSISEDTO getTypeSISEDernierDiplomeExt() {
        return typeSISEDernierDiplomeExt;
    }

    /**
     * Sets the value of the typeSISEDernierDiplomeExt property.
     * 
     * @param value
     *     allowed object is
     *     {@link TypDiplomeSISEDTO }
     *     
     */
    public void setTypeSISEDernierDiplomeExt(TypDiplomeSISEDTO value) {
        this.typeSISEDernierDiplomeExt = value;
    }

}
