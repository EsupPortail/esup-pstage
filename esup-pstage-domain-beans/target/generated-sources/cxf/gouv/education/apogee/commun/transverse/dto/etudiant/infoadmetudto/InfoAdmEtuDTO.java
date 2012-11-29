
package gouv.education.apogee.commun.transverse.dto.etudiant.infoadmetudto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import gouv.education.apogee.commun.transverse.dto.etudiant.departementcourtdto.DepartementCourtDTO;
import gouv.education.apogee.commun.transverse.dto.etudiant.etablissementdto.EtablissementDTO;
import gouv.education.apogee.commun.transverse.dto.etudiant.nationalitedto.NationaliteDTO;
import gouv.education.apogee.commun.transverse.dto.etudiant.paysdto.PaysDTO;
import gouv.education.apogee.commun.transverse.dto.etudiant.sitfamcourtdto.SitFamCourtDTO;
import gouv.education.apogee.commun.transverse.dto.etudiant.sitmilcourtdto.SitMilCourtDTO;
import gouv.education.apogee.commun.transverse.dto.etudiant.typhandicapcourtdto.TypHandicapCourtDTO;


/**
 * <p>Java class for InfoAdmEtuDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InfoAdmEtuDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="anneePremiereInscEnsSup" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="anneePremiereInscEtb" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="anneePremiereInscEtr" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="anneePremiereInscUniv" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cleINE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dateNaissance" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="departementNaissance" type="{DepartementCourtDTO.etudiant.dto.transverse.commun.apogee.education.gouv}DepartementCourtDTO"/>
 *         &lt;element name="etbPremiereInscUniv" type="{EtablissementDTO.etudiant.dto.transverse.commun.apogee.education.gouv}EtablissementDTO"/>
 *         &lt;element name="handicap" type="{TypHandicapCourtDTO.etudiant.dto.transverse.commun.apogee.education.gouv}TypHandicapCourtDTO"/>
 *         &lt;element name="libVilleNaissance" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="listeBacs" type="{InfoAdmEtuDTO.etudiant.dto.transverse.commun.apogee.education.gouv}TableauIndBacDTO"/>
 *         &lt;element name="listeBlocages" type="{InfoAdmEtuDTO.etudiant.dto.transverse.commun.apogee.education.gouv}TableauBlocages"/>
 *         &lt;element name="nationaliteDTO" type="{NationaliteDTO.etudiant.dto.transverse.commun.apogee.education.gouv}NationaliteDTO"/>
 *         &lt;element name="nomPatronymique" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nomUsuel" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="numBoursier" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="numEtu" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="numeroINE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="paysNaissance" type="{PaysDTO.etudiant.dto.transverse.commun.apogee.education.gouv}PaysDTO"/>
 *         &lt;element name="prenom1" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="prenom2" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sexe" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="situationFamiliale" type="{SitFamCourtDTO.etudiant.dto.transverse.commun.apogee.education.gouv}SitFamCourtDTO"/>
 *         &lt;element name="situationMilitaire" type="{SitMilCourtDTO.etudiant.dto.transverse.commun.apogee.education.gouv}SitMilCourtDTO"/>
 *         &lt;element name="temoinDateNaissEstimee" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="temoinSitMilEnRegle" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InfoAdmEtuDTO", propOrder = {
    "anneePremiereInscEnsSup",
    "anneePremiereInscEtb",
    "anneePremiereInscEtr",
    "anneePremiereInscUniv",
    "cleINE",
    "dateNaissance",
    "departementNaissance",
    "etbPremiereInscUniv",
    "handicap",
    "libVilleNaissance",
    "listeBacs",
    "listeBlocages",
    "nationaliteDTO",
    "nomPatronymique",
    "nomUsuel",
    "numBoursier",
    "numEtu",
    "numeroINE",
    "paysNaissance",
    "prenom1",
    "prenom2",
    "sexe",
    "situationFamiliale",
    "situationMilitaire",
    "temoinDateNaissEstimee",
    "temoinSitMilEnRegle"
})
public class InfoAdmEtuDTO {

    @XmlElement(required = true, nillable = true)
    protected String anneePremiereInscEnsSup;
    @XmlElement(required = true, nillable = true)
    protected String anneePremiereInscEtb;
    @XmlElement(required = true, nillable = true)
    protected String anneePremiereInscEtr;
    @XmlElement(required = true, nillable = true)
    protected String anneePremiereInscUniv;
    @XmlElement(required = true, nillable = true)
    protected String cleINE;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateNaissance;
    @XmlElement(required = true, nillable = true)
    protected DepartementCourtDTO departementNaissance;
    @XmlElement(required = true, nillable = true)
    protected EtablissementDTO etbPremiereInscUniv;
    @XmlElement(required = true, nillable = true)
    protected TypHandicapCourtDTO handicap;
    @XmlElement(required = true, nillable = true)
    protected String libVilleNaissance;
    @XmlElement(required = true, nillable = true)
    protected TableauIndBacDTO listeBacs;
    @XmlElement(required = true, nillable = true)
    protected TableauBlocages listeBlocages;
    @XmlElement(required = true, nillable = true)
    protected NationaliteDTO nationaliteDTO;
    @XmlElement(required = true, nillable = true)
    protected String nomPatronymique;
    @XmlElement(required = true, nillable = true)
    protected String nomUsuel;
    @XmlElement(required = true, nillable = true)
    protected String numBoursier;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer numEtu;
    @XmlElement(required = true, nillable = true)
    protected String numeroINE;
    @XmlElement(required = true, nillable = true)
    protected PaysDTO paysNaissance;
    @XmlElement(required = true, nillable = true)
    protected String prenom1;
    @XmlElement(required = true, nillable = true)
    protected String prenom2;
    @XmlElement(required = true, nillable = true)
    protected String sexe;
    @XmlElement(required = true, nillable = true)
    protected SitFamCourtDTO situationFamiliale;
    @XmlElement(required = true, nillable = true)
    protected SitMilCourtDTO situationMilitaire;
    @XmlElement(required = true, nillable = true)
    protected String temoinDateNaissEstimee;
    @XmlElement(required = true, nillable = true)
    protected String temoinSitMilEnRegle;

    /**
     * Gets the value of the anneePremiereInscEnsSup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnneePremiereInscEnsSup() {
        return anneePremiereInscEnsSup;
    }

    /**
     * Sets the value of the anneePremiereInscEnsSup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnneePremiereInscEnsSup(String value) {
        this.anneePremiereInscEnsSup = value;
    }

    /**
     * Gets the value of the anneePremiereInscEtb property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnneePremiereInscEtb() {
        return anneePremiereInscEtb;
    }

    /**
     * Sets the value of the anneePremiereInscEtb property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnneePremiereInscEtb(String value) {
        this.anneePremiereInscEtb = value;
    }

    /**
     * Gets the value of the anneePremiereInscEtr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnneePremiereInscEtr() {
        return anneePremiereInscEtr;
    }

    /**
     * Sets the value of the anneePremiereInscEtr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnneePremiereInscEtr(String value) {
        this.anneePremiereInscEtr = value;
    }

    /**
     * Gets the value of the anneePremiereInscUniv property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnneePremiereInscUniv() {
        return anneePremiereInscUniv;
    }

    /**
     * Sets the value of the anneePremiereInscUniv property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnneePremiereInscUniv(String value) {
        this.anneePremiereInscUniv = value;
    }

    /**
     * Gets the value of the cleINE property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCleINE() {
        return cleINE;
    }

    /**
     * Sets the value of the cleINE property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCleINE(String value) {
        this.cleINE = value;
    }

    /**
     * Gets the value of the dateNaissance property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateNaissance() {
        return dateNaissance;
    }

    /**
     * Sets the value of the dateNaissance property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateNaissance(XMLGregorianCalendar value) {
        this.dateNaissance = value;
    }

    /**
     * Gets the value of the departementNaissance property.
     * 
     * @return
     *     possible object is
     *     {@link DepartementCourtDTO }
     *     
     */
    public DepartementCourtDTO getDepartementNaissance() {
        return departementNaissance;
    }

    /**
     * Sets the value of the departementNaissance property.
     * 
     * @param value
     *     allowed object is
     *     {@link DepartementCourtDTO }
     *     
     */
    public void setDepartementNaissance(DepartementCourtDTO value) {
        this.departementNaissance = value;
    }

    /**
     * Gets the value of the etbPremiereInscUniv property.
     * 
     * @return
     *     possible object is
     *     {@link EtablissementDTO }
     *     
     */
    public EtablissementDTO getEtbPremiereInscUniv() {
        return etbPremiereInscUniv;
    }

    /**
     * Sets the value of the etbPremiereInscUniv property.
     * 
     * @param value
     *     allowed object is
     *     {@link EtablissementDTO }
     *     
     */
    public void setEtbPremiereInscUniv(EtablissementDTO value) {
        this.etbPremiereInscUniv = value;
    }

    /**
     * Gets the value of the handicap property.
     * 
     * @return
     *     possible object is
     *     {@link TypHandicapCourtDTO }
     *     
     */
    public TypHandicapCourtDTO getHandicap() {
        return handicap;
    }

    /**
     * Sets the value of the handicap property.
     * 
     * @param value
     *     allowed object is
     *     {@link TypHandicapCourtDTO }
     *     
     */
    public void setHandicap(TypHandicapCourtDTO value) {
        this.handicap = value;
    }

    /**
     * Gets the value of the libVilleNaissance property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibVilleNaissance() {
        return libVilleNaissance;
    }

    /**
     * Sets the value of the libVilleNaissance property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibVilleNaissance(String value) {
        this.libVilleNaissance = value;
    }

    /**
     * Gets the value of the listeBacs property.
     * 
     * @return
     *     possible object is
     *     {@link TableauIndBacDTO }
     *     
     */
    public TableauIndBacDTO getListeBacs() {
        return listeBacs;
    }

    /**
     * Sets the value of the listeBacs property.
     * 
     * @param value
     *     allowed object is
     *     {@link TableauIndBacDTO }
     *     
     */
    public void setListeBacs(TableauIndBacDTO value) {
        this.listeBacs = value;
    }

    /**
     * Gets the value of the listeBlocages property.
     * 
     * @return
     *     possible object is
     *     {@link TableauBlocages }
     *     
     */
    public TableauBlocages getListeBlocages() {
        return listeBlocages;
    }

    /**
     * Sets the value of the listeBlocages property.
     * 
     * @param value
     *     allowed object is
     *     {@link TableauBlocages }
     *     
     */
    public void setListeBlocages(TableauBlocages value) {
        this.listeBlocages = value;
    }

    /**
     * Gets the value of the nationaliteDTO property.
     * 
     * @return
     *     possible object is
     *     {@link NationaliteDTO }
     *     
     */
    public NationaliteDTO getNationaliteDTO() {
        return nationaliteDTO;
    }

    /**
     * Sets the value of the nationaliteDTO property.
     * 
     * @param value
     *     allowed object is
     *     {@link NationaliteDTO }
     *     
     */
    public void setNationaliteDTO(NationaliteDTO value) {
        this.nationaliteDTO = value;
    }

    /**
     * Gets the value of the nomPatronymique property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomPatronymique() {
        return nomPatronymique;
    }

    /**
     * Sets the value of the nomPatronymique property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomPatronymique(String value) {
        this.nomPatronymique = value;
    }

    /**
     * Gets the value of the nomUsuel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomUsuel() {
        return nomUsuel;
    }

    /**
     * Sets the value of the nomUsuel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomUsuel(String value) {
        this.nomUsuel = value;
    }

    /**
     * Gets the value of the numBoursier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumBoursier() {
        return numBoursier;
    }

    /**
     * Sets the value of the numBoursier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumBoursier(String value) {
        this.numBoursier = value;
    }

    /**
     * Gets the value of the numEtu property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumEtu() {
        return numEtu;
    }

    /**
     * Sets the value of the numEtu property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumEtu(Integer value) {
        this.numEtu = value;
    }

    /**
     * Gets the value of the numeroINE property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroINE() {
        return numeroINE;
    }

    /**
     * Sets the value of the numeroINE property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroINE(String value) {
        this.numeroINE = value;
    }

    /**
     * Gets the value of the paysNaissance property.
     * 
     * @return
     *     possible object is
     *     {@link PaysDTO }
     *     
     */
    public PaysDTO getPaysNaissance() {
        return paysNaissance;
    }

    /**
     * Sets the value of the paysNaissance property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaysDTO }
     *     
     */
    public void setPaysNaissance(PaysDTO value) {
        this.paysNaissance = value;
    }

    /**
     * Gets the value of the prenom1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrenom1() {
        return prenom1;
    }

    /**
     * Sets the value of the prenom1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrenom1(String value) {
        this.prenom1 = value;
    }

    /**
     * Gets the value of the prenom2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrenom2() {
        return prenom2;
    }

    /**
     * Sets the value of the prenom2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrenom2(String value) {
        this.prenom2 = value;
    }

    /**
     * Gets the value of the sexe property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSexe() {
        return sexe;
    }

    /**
     * Sets the value of the sexe property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSexe(String value) {
        this.sexe = value;
    }

    /**
     * Gets the value of the situationFamiliale property.
     * 
     * @return
     *     possible object is
     *     {@link SitFamCourtDTO }
     *     
     */
    public SitFamCourtDTO getSituationFamiliale() {
        return situationFamiliale;
    }

    /**
     * Sets the value of the situationFamiliale property.
     * 
     * @param value
     *     allowed object is
     *     {@link SitFamCourtDTO }
     *     
     */
    public void setSituationFamiliale(SitFamCourtDTO value) {
        this.situationFamiliale = value;
    }

    /**
     * Gets the value of the situationMilitaire property.
     * 
     * @return
     *     possible object is
     *     {@link SitMilCourtDTO }
     *     
     */
    public SitMilCourtDTO getSituationMilitaire() {
        return situationMilitaire;
    }

    /**
     * Sets the value of the situationMilitaire property.
     * 
     * @param value
     *     allowed object is
     *     {@link SitMilCourtDTO }
     *     
     */
    public void setSituationMilitaire(SitMilCourtDTO value) {
        this.situationMilitaire = value;
    }

    /**
     * Gets the value of the temoinDateNaissEstimee property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemoinDateNaissEstimee() {
        return temoinDateNaissEstimee;
    }

    /**
     * Sets the value of the temoinDateNaissEstimee property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemoinDateNaissEstimee(String value) {
        this.temoinDateNaissEstimee = value;
    }

    /**
     * Gets the value of the temoinSitMilEnRegle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemoinSitMilEnRegle() {
        return temoinSitMilEnRegle;
    }

    /**
     * Sets the value of the temoinSitMilEnRegle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemoinSitMilEnRegle(String value) {
        this.temoinSitMilEnRegle = value;
    }

}
