
package gouv.education.apogee.commun.transverse.dto.administratif.cursusexternedto;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gouv.education.apogee.commun.transverse.dto.administratif.departementdto.DepartementDTO;
import gouv.education.apogee.commun.transverse.dto.administratif.etablissementdto.EtablissementDTO;
import gouv.education.apogee.commun.transverse.dto.administratif.niveauformationdto.NiveauFormationDTO;
import gouv.education.apogee.commun.transverse.dto.administratif.paysdto.PaysDTO;
import gouv.education.apogee.commun.transverse.dto.administratif.situationsisedto.SituationSISEDTO;
import gouv.education.apogee.commun.transverse.dto.administratif.typdiplomedto.TypDiplomeDTO;
import gouv.education.apogee.commun.transverse.dto.administratif.typdiplomeextdto.TypDiplomeExtDTO;
import gouv.education.apogee.commun.transverse.dto.administratif.typeetablissementdto.TypeEtablissementDTO;


/**
 * <p>Java class for CursusExterneDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CursusExterneDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="annee" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="commentaire" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="creditAcquis" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="creditsAcquisSem1" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="creditsAcquisSem2" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="departement" type="{DepartementDTO.administratif.dto.transverse.commun.apogee.education.gouv}DepartementDTO"/>
 *         &lt;element name="etablissement" type="{EtablissementDTO.administratif.dto.transverse.commun.apogee.education.gouv}EtablissementDTO"/>
 *         &lt;element name="intituleDiplome" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libSem1" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libSem2" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="niveauFormation" type="{NiveauFormationDTO.administratif.dto.transverse.commun.apogee.education.gouv}NiveauFormationDTO"/>
 *         &lt;element name="obtentionSem1" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="obtentionSem2" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="pays" type="{PaysDTO.administratif.dto.transverse.commun.apogee.education.gouv}PaysDTO"/>
 *         &lt;element name="situationSise" type="{SituationSISEDTO.administratif.dto.transverse.commun.apogee.education.gouv}SituationSISEDTO"/>
 *         &lt;element name="temObtentionDip" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="temObtentionNiveau" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="temoinVAE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="typeAutreDiplome" type="{TypDiplomeDTO.administratif.dto.transverse.commun.apogee.education.gouv}TypDiplomeDTO"/>
 *         &lt;element name="typeDiplomeExt" type="{TypDiplomeExtDTO.administratif.dto.transverse.commun.apogee.education.gouv}TypDiplomeExtDTO"/>
 *         &lt;element name="typeEtb" type="{TypeEtablissementDTO.administratif.dto.transverse.commun.apogee.education.gouv}TypeEtablissementDTO"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CursusExterneDTO", propOrder = {
    "annee",
    "commentaire",
    "creditAcquis",
    "creditsAcquisSem1",
    "creditsAcquisSem2",
    "departement",
    "etablissement",
    "intituleDiplome",
    "libSem1",
    "libSem2",
    "niveauFormation",
    "obtentionSem1",
    "obtentionSem2",
    "pays",
    "situationSise",
    "temObtentionDip",
    "temObtentionNiveau",
    "temoinVAE",
    "typeAutreDiplome",
    "typeDiplomeExt",
    "typeEtb"
})
public class CursusExterneDTO {

    @XmlElement(required = true, nillable = true)
    protected String annee;
    @XmlElement(required = true, nillable = true)
    protected String commentaire;
    @XmlElement(required = true, nillable = true)
    protected BigDecimal creditAcquis;
    @XmlElement(required = true, nillable = true)
    protected String creditsAcquisSem1;
    @XmlElement(required = true, nillable = true)
    protected String creditsAcquisSem2;
    @XmlElement(required = true, nillable = true)
    protected DepartementDTO departement;
    @XmlElement(required = true, nillable = true)
    protected EtablissementDTO etablissement;
    @XmlElement(required = true, nillable = true)
    protected String intituleDiplome;
    @XmlElement(required = true, nillable = true)
    protected String libSem1;
    @XmlElement(required = true, nillable = true)
    protected String libSem2;
    @XmlElement(required = true, nillable = true)
    protected NiveauFormationDTO niveauFormation;
    @XmlElement(required = true, nillable = true)
    protected String obtentionSem1;
    @XmlElement(required = true, nillable = true)
    protected String obtentionSem2;
    @XmlElement(required = true, nillable = true)
    protected PaysDTO pays;
    @XmlElement(required = true, nillable = true)
    protected SituationSISEDTO situationSise;
    @XmlElement(required = true, nillable = true)
    protected String temObtentionDip;
    @XmlElement(required = true, nillable = true)
    protected String temObtentionNiveau;
    @XmlElement(required = true, nillable = true)
    protected String temoinVAE;
    @XmlElement(required = true, nillable = true)
    protected TypDiplomeDTO typeAutreDiplome;
    @XmlElement(required = true, nillable = true)
    protected TypDiplomeExtDTO typeDiplomeExt;
    @XmlElement(required = true, nillable = true)
    protected TypeEtablissementDTO typeEtb;

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
     * Gets the value of the commentaire property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommentaire() {
        return commentaire;
    }

    /**
     * Sets the value of the commentaire property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommentaire(String value) {
        this.commentaire = value;
    }

    /**
     * Gets the value of the creditAcquis property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCreditAcquis() {
        return creditAcquis;
    }

    /**
     * Sets the value of the creditAcquis property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCreditAcquis(BigDecimal value) {
        this.creditAcquis = value;
    }

    /**
     * Gets the value of the creditsAcquisSem1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreditsAcquisSem1() {
        return creditsAcquisSem1;
    }

    /**
     * Sets the value of the creditsAcquisSem1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreditsAcquisSem1(String value) {
        this.creditsAcquisSem1 = value;
    }

    /**
     * Gets the value of the creditsAcquisSem2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreditsAcquisSem2() {
        return creditsAcquisSem2;
    }

    /**
     * Sets the value of the creditsAcquisSem2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreditsAcquisSem2(String value) {
        this.creditsAcquisSem2 = value;
    }

    /**
     * Gets the value of the departement property.
     * 
     * @return
     *     possible object is
     *     {@link DepartementDTO }
     *     
     */
    public DepartementDTO getDepartement() {
        return departement;
    }

    /**
     * Sets the value of the departement property.
     * 
     * @param value
     *     allowed object is
     *     {@link DepartementDTO }
     *     
     */
    public void setDepartement(DepartementDTO value) {
        this.departement = value;
    }

    /**
     * Gets the value of the etablissement property.
     * 
     * @return
     *     possible object is
     *     {@link EtablissementDTO }
     *     
     */
    public EtablissementDTO getEtablissement() {
        return etablissement;
    }

    /**
     * Sets the value of the etablissement property.
     * 
     * @param value
     *     allowed object is
     *     {@link EtablissementDTO }
     *     
     */
    public void setEtablissement(EtablissementDTO value) {
        this.etablissement = value;
    }

    /**
     * Gets the value of the intituleDiplome property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIntituleDiplome() {
        return intituleDiplome;
    }

    /**
     * Sets the value of the intituleDiplome property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIntituleDiplome(String value) {
        this.intituleDiplome = value;
    }

    /**
     * Gets the value of the libSem1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibSem1() {
        return libSem1;
    }

    /**
     * Sets the value of the libSem1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibSem1(String value) {
        this.libSem1 = value;
    }

    /**
     * Gets the value of the libSem2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibSem2() {
        return libSem2;
    }

    /**
     * Sets the value of the libSem2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibSem2(String value) {
        this.libSem2 = value;
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
     * Gets the value of the obtentionSem1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObtentionSem1() {
        return obtentionSem1;
    }

    /**
     * Sets the value of the obtentionSem1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObtentionSem1(String value) {
        this.obtentionSem1 = value;
    }

    /**
     * Gets the value of the obtentionSem2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObtentionSem2() {
        return obtentionSem2;
    }

    /**
     * Sets the value of the obtentionSem2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObtentionSem2(String value) {
        this.obtentionSem2 = value;
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
     * Gets the value of the situationSise property.
     * 
     * @return
     *     possible object is
     *     {@link SituationSISEDTO }
     *     
     */
    public SituationSISEDTO getSituationSise() {
        return situationSise;
    }

    /**
     * Sets the value of the situationSise property.
     * 
     * @param value
     *     allowed object is
     *     {@link SituationSISEDTO }
     *     
     */
    public void setSituationSise(SituationSISEDTO value) {
        this.situationSise = value;
    }

    /**
     * Gets the value of the temObtentionDip property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemObtentionDip() {
        return temObtentionDip;
    }

    /**
     * Sets the value of the temObtentionDip property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemObtentionDip(String value) {
        this.temObtentionDip = value;
    }

    /**
     * Gets the value of the temObtentionNiveau property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemObtentionNiveau() {
        return temObtentionNiveau;
    }

    /**
     * Sets the value of the temObtentionNiveau property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemObtentionNiveau(String value) {
        this.temObtentionNiveau = value;
    }

    /**
     * Gets the value of the temoinVAE property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemoinVAE() {
        return temoinVAE;
    }

    /**
     * Sets the value of the temoinVAE property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemoinVAE(String value) {
        this.temoinVAE = value;
    }

    /**
     * Gets the value of the typeAutreDiplome property.
     * 
     * @return
     *     possible object is
     *     {@link TypDiplomeDTO }
     *     
     */
    public TypDiplomeDTO getTypeAutreDiplome() {
        return typeAutreDiplome;
    }

    /**
     * Sets the value of the typeAutreDiplome property.
     * 
     * @param value
     *     allowed object is
     *     {@link TypDiplomeDTO }
     *     
     */
    public void setTypeAutreDiplome(TypDiplomeDTO value) {
        this.typeAutreDiplome = value;
    }

    /**
     * Gets the value of the typeDiplomeExt property.
     * 
     * @return
     *     possible object is
     *     {@link TypDiplomeExtDTO }
     *     
     */
    public TypDiplomeExtDTO getTypeDiplomeExt() {
        return typeDiplomeExt;
    }

    /**
     * Sets the value of the typeDiplomeExt property.
     * 
     * @param value
     *     allowed object is
     *     {@link TypDiplomeExtDTO }
     *     
     */
    public void setTypeDiplomeExt(TypDiplomeExtDTO value) {
        this.typeDiplomeExt = value;
    }

    /**
     * Gets the value of the typeEtb property.
     * 
     * @return
     *     possible object is
     *     {@link TypeEtablissementDTO }
     *     
     */
    public TypeEtablissementDTO getTypeEtb() {
        return typeEtb;
    }

    /**
     * Sets the value of the typeEtb property.
     * 
     * @param value
     *     allowed object is
     *     {@link TypeEtablissementDTO }
     *     
     */
    public void setTypeEtb(TypeEtablissementDTO value) {
        this.typeEtb = value;
    }

}
