
package gouv.education.apogee.commun.transverse.dto.administratif.insadmetpdto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import gouv.education.apogee.commun.transverse.dto.administratif.boursedto.BourseDTO;
import gouv.education.apogee.commun.transverse.dto.administratif.cgedto.CgeDTO;
import gouv.education.apogee.commun.transverse.dto.administratif.composantedto.ComposanteDTO;
import gouv.education.apogee.commun.transverse.dto.administratif.diplomedto.DiplomeDTO;
import gouv.education.apogee.commun.transverse.dto.administratif.etapedto.EtapeDTO;
import gouv.education.apogee.commun.transverse.dto.administratif.etatiaadto.EtatIAADTO;
import gouv.education.apogee.commun.transverse.dto.administratif.etatiaedto.EtatIAEDTO;
import gouv.education.apogee.commun.transverse.dto.administratif.profiletudto.ProfilEtuDTO;


/**
 * <p>Java class for InsAdmEtpDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InsAdmEtpDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="anneeIAE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="bourse" type="{BourseDTO.administratif.dto.transverse.commun.apogee.education.gouv}BourseDTO"/>
 *         &lt;element name="cge" type="{CgeDTO.administratif.dto.transverse.commun.apogee.education.gouv}CgeDTO"/>
 *         &lt;element name="composante" type="{ComposanteDTO.administratif.dto.transverse.commun.apogee.education.gouv}ComposanteDTO"/>
 *         &lt;element name="dateIAE" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="diplome" type="{DiplomeDTO.administratif.dto.transverse.commun.apogee.education.gouv}DiplomeDTO"/>
 *         &lt;element name="etape" type="{EtapeDTO.administratif.dto.transverse.commun.apogee.education.gouv}EtapeDTO"/>
 *         &lt;element name="etapePremiere" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="etatIaa" type="{EtatIAADTO.administratif.dto.transverse.commun.apogee.education.gouv}EtatIAADTO"/>
 *         &lt;element name="etatIae" type="{EtatIAEDTO.administratif.dto.transverse.commun.apogee.education.gouv}EtatIAEDTO"/>
 *         &lt;element name="inscriptionPayee" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="inscriptionTeleEnseignement" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="listeSpecialiteSISE" type="{InsAdmEtpDTO.administratif.dto.transverse.commun.apogee.education.gouv}TableauSpecialitesDto"/>
 *         &lt;element name="nbrInscriptionCycle" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nbrInscriptionDiplome" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nbrInscriptionEtape" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="numBoursier" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="profilEtudiant" type="{ProfilEtuDTO.administratif.dto.transverse.commun.apogee.education.gouv}ProfilEtuDTO"/>
 *         &lt;element name="temoinInscriptionIaWeb" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="temoinPI" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="temoinVae" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InsAdmEtpDTO", propOrder = {
    "anneeIAE",
    "bourse",
    "cge",
    "composante",
    "dateIAE",
    "diplome",
    "etape",
    "etapePremiere",
    "etatIaa",
    "etatIae",
    "inscriptionPayee",
    "inscriptionTeleEnseignement",
    "listeSpecialiteSISE",
    "nbrInscriptionCycle",
    "nbrInscriptionDiplome",
    "nbrInscriptionEtape",
    "numBoursier",
    "profilEtudiant",
    "temoinInscriptionIaWeb",
    "temoinPI",
    "temoinVae"
})
public class InsAdmEtpDTO {

    @XmlElement(required = true, nillable = true)
    protected String anneeIAE;
    @XmlElement(required = true, nillable = true)
    protected BourseDTO bourse;
    @XmlElement(required = true, nillable = true)
    protected CgeDTO cge;
    @XmlElement(required = true, nillable = true)
    protected ComposanteDTO composante;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateIAE;
    @XmlElement(required = true, nillable = true)
    protected DiplomeDTO diplome;
    @XmlElement(required = true, nillable = true)
    protected EtapeDTO etape;
    @XmlElement(required = true, nillable = true)
    protected String etapePremiere;
    @XmlElement(required = true, nillable = true)
    protected EtatIAADTO etatIaa;
    @XmlElement(required = true, nillable = true)
    protected EtatIAEDTO etatIae;
    @XmlElement(required = true, nillable = true)
    protected String inscriptionPayee;
    @XmlElement(required = true, nillable = true)
    protected String inscriptionTeleEnseignement;
    @XmlElement(required = true, nillable = true)
    protected TableauSpecialitesDto listeSpecialiteSISE;
    @XmlElement(required = true, nillable = true)
    protected String nbrInscriptionCycle;
    @XmlElement(required = true, nillable = true)
    protected String nbrInscriptionDiplome;
    @XmlElement(required = true, nillable = true)
    protected String nbrInscriptionEtape;
    @XmlElement(required = true, nillable = true)
    protected String numBoursier;
    @XmlElement(required = true, nillable = true)
    protected ProfilEtuDTO profilEtudiant;
    @XmlElement(required = true, nillable = true)
    protected String temoinInscriptionIaWeb;
    @XmlElement(required = true, nillable = true)
    protected String temoinPI;
    @XmlElement(required = true, nillable = true)
    protected String temoinVae;

    /**
     * Gets the value of the anneeIAE property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnneeIAE() {
        return anneeIAE;
    }

    /**
     * Sets the value of the anneeIAE property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnneeIAE(String value) {
        this.anneeIAE = value;
    }

    /**
     * Gets the value of the bourse property.
     * 
     * @return
     *     possible object is
     *     {@link BourseDTO }
     *     
     */
    public BourseDTO getBourse() {
        return bourse;
    }

    /**
     * Sets the value of the bourse property.
     * 
     * @param value
     *     allowed object is
     *     {@link BourseDTO }
     *     
     */
    public void setBourse(BourseDTO value) {
        this.bourse = value;
    }

    /**
     * Gets the value of the cge property.
     * 
     * @return
     *     possible object is
     *     {@link CgeDTO }
     *     
     */
    public CgeDTO getCge() {
        return cge;
    }

    /**
     * Sets the value of the cge property.
     * 
     * @param value
     *     allowed object is
     *     {@link CgeDTO }
     *     
     */
    public void setCge(CgeDTO value) {
        this.cge = value;
    }

    /**
     * Gets the value of the composante property.
     * 
     * @return
     *     possible object is
     *     {@link ComposanteDTO }
     *     
     */
    public ComposanteDTO getComposante() {
        return composante;
    }

    /**
     * Sets the value of the composante property.
     * 
     * @param value
     *     allowed object is
     *     {@link ComposanteDTO }
     *     
     */
    public void setComposante(ComposanteDTO value) {
        this.composante = value;
    }

    /**
     * Gets the value of the dateIAE property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateIAE() {
        return dateIAE;
    }

    /**
     * Sets the value of the dateIAE property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateIAE(XMLGregorianCalendar value) {
        this.dateIAE = value;
    }

    /**
     * Gets the value of the diplome property.
     * 
     * @return
     *     possible object is
     *     {@link DiplomeDTO }
     *     
     */
    public DiplomeDTO getDiplome() {
        return diplome;
    }

    /**
     * Sets the value of the diplome property.
     * 
     * @param value
     *     allowed object is
     *     {@link DiplomeDTO }
     *     
     */
    public void setDiplome(DiplomeDTO value) {
        this.diplome = value;
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
     * Gets the value of the etapePremiere property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEtapePremiere() {
        return etapePremiere;
    }

    /**
     * Sets the value of the etapePremiere property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEtapePremiere(String value) {
        this.etapePremiere = value;
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
     * Gets the value of the etatIae property.
     * 
     * @return
     *     possible object is
     *     {@link EtatIAEDTO }
     *     
     */
    public EtatIAEDTO getEtatIae() {
        return etatIae;
    }

    /**
     * Sets the value of the etatIae property.
     * 
     * @param value
     *     allowed object is
     *     {@link EtatIAEDTO }
     *     
     */
    public void setEtatIae(EtatIAEDTO value) {
        this.etatIae = value;
    }

    /**
     * Gets the value of the inscriptionPayee property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInscriptionPayee() {
        return inscriptionPayee;
    }

    /**
     * Sets the value of the inscriptionPayee property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInscriptionPayee(String value) {
        this.inscriptionPayee = value;
    }

    /**
     * Gets the value of the inscriptionTeleEnseignement property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInscriptionTeleEnseignement() {
        return inscriptionTeleEnseignement;
    }

    /**
     * Sets the value of the inscriptionTeleEnseignement property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInscriptionTeleEnseignement(String value) {
        this.inscriptionTeleEnseignement = value;
    }

    /**
     * Gets the value of the listeSpecialiteSISE property.
     * 
     * @return
     *     possible object is
     *     {@link TableauSpecialitesDto }
     *     
     */
    public TableauSpecialitesDto getListeSpecialiteSISE() {
        return listeSpecialiteSISE;
    }

    /**
     * Sets the value of the listeSpecialiteSISE property.
     * 
     * @param value
     *     allowed object is
     *     {@link TableauSpecialitesDto }
     *     
     */
    public void setListeSpecialiteSISE(TableauSpecialitesDto value) {
        this.listeSpecialiteSISE = value;
    }

    /**
     * Gets the value of the nbrInscriptionCycle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNbrInscriptionCycle() {
        return nbrInscriptionCycle;
    }

    /**
     * Sets the value of the nbrInscriptionCycle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNbrInscriptionCycle(String value) {
        this.nbrInscriptionCycle = value;
    }

    /**
     * Gets the value of the nbrInscriptionDiplome property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNbrInscriptionDiplome() {
        return nbrInscriptionDiplome;
    }

    /**
     * Sets the value of the nbrInscriptionDiplome property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNbrInscriptionDiplome(String value) {
        this.nbrInscriptionDiplome = value;
    }

    /**
     * Gets the value of the nbrInscriptionEtape property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNbrInscriptionEtape() {
        return nbrInscriptionEtape;
    }

    /**
     * Sets the value of the nbrInscriptionEtape property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNbrInscriptionEtape(String value) {
        this.nbrInscriptionEtape = value;
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
     * Gets the value of the profilEtudiant property.
     * 
     * @return
     *     possible object is
     *     {@link ProfilEtuDTO }
     *     
     */
    public ProfilEtuDTO getProfilEtudiant() {
        return profilEtudiant;
    }

    /**
     * Sets the value of the profilEtudiant property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProfilEtuDTO }
     *     
     */
    public void setProfilEtudiant(ProfilEtuDTO value) {
        this.profilEtudiant = value;
    }

    /**
     * Gets the value of the temoinInscriptionIaWeb property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemoinInscriptionIaWeb() {
        return temoinInscriptionIaWeb;
    }

    /**
     * Sets the value of the temoinInscriptionIaWeb property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemoinInscriptionIaWeb(String value) {
        this.temoinInscriptionIaWeb = value;
    }

    /**
     * Gets the value of the temoinPI property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemoinPI() {
        return temoinPI;
    }

    /**
     * Sets the value of the temoinPI property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemoinPI(String value) {
        this.temoinPI = value;
    }

    /**
     * Gets the value of the temoinVae property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemoinVae() {
        return temoinVae;
    }

    /**
     * Sets the value of the temoinVae property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemoinVae(String value) {
        this.temoinVae = value;
    }

}
