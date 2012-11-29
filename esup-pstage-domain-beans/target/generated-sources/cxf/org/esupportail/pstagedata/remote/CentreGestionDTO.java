
package org.esupportail.pstagedata.remote;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for centreGestionDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="centreGestionDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://remote.pstagedata.esupportail.org/}adresseDTO">
 *       &lt;sequence>
 *         &lt;element name="autoriserImpressionConvention" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="choixAnneeApresDebutAnnee" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="choixAnneeAvantDebutAnnee" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="codeConfidentialite" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codeUniversite" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="commentaire" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="confidentialite" type="{http://remote.pstagedata.esupportail.org/}confidentialiteDTO" minOccurs="0"/>
 *         &lt;element name="depotAnonyme" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="fax" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fichier" type="{http://remote.pstagedata.esupportail.org/}fichierDTO" minOccurs="0"/>
 *         &lt;element name="idCentreGestion" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idCentreGestionSuperViseur" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idFichier" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idNiveauCentre" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="mail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="niveauCentre" type="{http://remote.pstagedata.esupportail.org/}niveauCentreDTO" minOccurs="0"/>
 *         &lt;element name="nomCentre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nomViseur" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="prenomViseur" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="presenceTuteurEns" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="presenceTuteurPro" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="saisieTuteurProParEtudiant" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="siteWeb" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="telephone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="urlPageInstruction" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "centreGestionDTO", propOrder = {
    "autoriserImpressionConvention",
    "choixAnneeApresDebutAnnee",
    "choixAnneeAvantDebutAnnee",
    "codeConfidentialite",
    "codeUniversite",
    "commentaire",
    "confidentialite",
    "depotAnonyme",
    "fax",
    "fichier",
    "idCentreGestion",
    "idCentreGestionSuperViseur",
    "idFichier",
    "idNiveauCentre",
    "mail",
    "niveauCentre",
    "nomCentre",
    "nomViseur",
    "prenomViseur",
    "presenceTuteurEns",
    "presenceTuteurPro",
    "saisieTuteurProParEtudiant",
    "siteWeb",
    "telephone",
    "urlPageInstruction"
})
public class CentreGestionDTO
    extends AdresseDTO
{

    protected boolean autoriserImpressionConvention;
    protected boolean choixAnneeApresDebutAnnee;
    protected boolean choixAnneeAvantDebutAnnee;
    protected String codeConfidentialite;
    protected String codeUniversite;
    protected String commentaire;
    protected ConfidentialiteDTO confidentialite;
    protected boolean depotAnonyme;
    protected String fax;
    protected FichierDTO fichier;
    protected int idCentreGestion;
    protected int idCentreGestionSuperViseur;
    protected int idFichier;
    protected int idNiveauCentre;
    protected String mail;
    protected NiveauCentreDTO niveauCentre;
    protected String nomCentre;
    protected String nomViseur;
    protected String prenomViseur;
    protected boolean presenceTuteurEns;
    protected boolean presenceTuteurPro;
    protected boolean saisieTuteurProParEtudiant;
    protected String siteWeb;
    protected String telephone;
    protected String urlPageInstruction;

    /**
     * Gets the value of the autoriserImpressionConvention property.
     * 
     */
    public boolean isAutoriserImpressionConvention() {
        return autoriserImpressionConvention;
    }

    /**
     * Sets the value of the autoriserImpressionConvention property.
     * 
     */
    public void setAutoriserImpressionConvention(boolean value) {
        this.autoriserImpressionConvention = value;
    }

    /**
     * Gets the value of the choixAnneeApresDebutAnnee property.
     * 
     */
    public boolean isChoixAnneeApresDebutAnnee() {
        return choixAnneeApresDebutAnnee;
    }

    /**
     * Sets the value of the choixAnneeApresDebutAnnee property.
     * 
     */
    public void setChoixAnneeApresDebutAnnee(boolean value) {
        this.choixAnneeApresDebutAnnee = value;
    }

    /**
     * Gets the value of the choixAnneeAvantDebutAnnee property.
     * 
     */
    public boolean isChoixAnneeAvantDebutAnnee() {
        return choixAnneeAvantDebutAnnee;
    }

    /**
     * Sets the value of the choixAnneeAvantDebutAnnee property.
     * 
     */
    public void setChoixAnneeAvantDebutAnnee(boolean value) {
        this.choixAnneeAvantDebutAnnee = value;
    }

    /**
     * Gets the value of the codeConfidentialite property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeConfidentialite() {
        return codeConfidentialite;
    }

    /**
     * Sets the value of the codeConfidentialite property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeConfidentialite(String value) {
        this.codeConfidentialite = value;
    }

    /**
     * Gets the value of the codeUniversite property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeUniversite() {
        return codeUniversite;
    }

    /**
     * Sets the value of the codeUniversite property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeUniversite(String value) {
        this.codeUniversite = value;
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
     * Gets the value of the confidentialite property.
     * 
     * @return
     *     possible object is
     *     {@link ConfidentialiteDTO }
     *     
     */
    public ConfidentialiteDTO getConfidentialite() {
        return confidentialite;
    }

    /**
     * Sets the value of the confidentialite property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConfidentialiteDTO }
     *     
     */
    public void setConfidentialite(ConfidentialiteDTO value) {
        this.confidentialite = value;
    }

    /**
     * Gets the value of the depotAnonyme property.
     * 
     */
    public boolean isDepotAnonyme() {
        return depotAnonyme;
    }

    /**
     * Sets the value of the depotAnonyme property.
     * 
     */
    public void setDepotAnonyme(boolean value) {
        this.depotAnonyme = value;
    }

    /**
     * Gets the value of the fax property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFax() {
        return fax;
    }

    /**
     * Sets the value of the fax property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFax(String value) {
        this.fax = value;
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
     * Gets the value of the idCentreGestionSuperViseur property.
     * 
     */
    public int getIdCentreGestionSuperViseur() {
        return idCentreGestionSuperViseur;
    }

    /**
     * Sets the value of the idCentreGestionSuperViseur property.
     * 
     */
    public void setIdCentreGestionSuperViseur(int value) {
        this.idCentreGestionSuperViseur = value;
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
     * Gets the value of the idNiveauCentre property.
     * 
     */
    public int getIdNiveauCentre() {
        return idNiveauCentre;
    }

    /**
     * Sets the value of the idNiveauCentre property.
     * 
     */
    public void setIdNiveauCentre(int value) {
        this.idNiveauCentre = value;
    }

    /**
     * Gets the value of the mail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMail() {
        return mail;
    }

    /**
     * Sets the value of the mail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMail(String value) {
        this.mail = value;
    }

    /**
     * Gets the value of the niveauCentre property.
     * 
     * @return
     *     possible object is
     *     {@link NiveauCentreDTO }
     *     
     */
    public NiveauCentreDTO getNiveauCentre() {
        return niveauCentre;
    }

    /**
     * Sets the value of the niveauCentre property.
     * 
     * @param value
     *     allowed object is
     *     {@link NiveauCentreDTO }
     *     
     */
    public void setNiveauCentre(NiveauCentreDTO value) {
        this.niveauCentre = value;
    }

    /**
     * Gets the value of the nomCentre property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomCentre() {
        return nomCentre;
    }

    /**
     * Sets the value of the nomCentre property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomCentre(String value) {
        this.nomCentre = value;
    }

    /**
     * Gets the value of the nomViseur property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomViseur() {
        return nomViseur;
    }

    /**
     * Sets the value of the nomViseur property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomViseur(String value) {
        this.nomViseur = value;
    }

    /**
     * Gets the value of the prenomViseur property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrenomViseur() {
        return prenomViseur;
    }

    /**
     * Sets the value of the prenomViseur property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrenomViseur(String value) {
        this.prenomViseur = value;
    }

    /**
     * Gets the value of the presenceTuteurEns property.
     * 
     */
    public boolean isPresenceTuteurEns() {
        return presenceTuteurEns;
    }

    /**
     * Sets the value of the presenceTuteurEns property.
     * 
     */
    public void setPresenceTuteurEns(boolean value) {
        this.presenceTuteurEns = value;
    }

    /**
     * Gets the value of the presenceTuteurPro property.
     * 
     */
    public boolean isPresenceTuteurPro() {
        return presenceTuteurPro;
    }

    /**
     * Sets the value of the presenceTuteurPro property.
     * 
     */
    public void setPresenceTuteurPro(boolean value) {
        this.presenceTuteurPro = value;
    }

    /**
     * Gets the value of the saisieTuteurProParEtudiant property.
     * 
     */
    public boolean isSaisieTuteurProParEtudiant() {
        return saisieTuteurProParEtudiant;
    }

    /**
     * Sets the value of the saisieTuteurProParEtudiant property.
     * 
     */
    public void setSaisieTuteurProParEtudiant(boolean value) {
        this.saisieTuteurProParEtudiant = value;
    }

    /**
     * Gets the value of the siteWeb property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSiteWeb() {
        return siteWeb;
    }

    /**
     * Sets the value of the siteWeb property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSiteWeb(String value) {
        this.siteWeb = value;
    }

    /**
     * Gets the value of the telephone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * Sets the value of the telephone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelephone(String value) {
        this.telephone = value;
    }

    /**
     * Gets the value of the urlPageInstruction property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrlPageInstruction() {
        return urlPageInstruction;
    }

    /**
     * Sets the value of the urlPageInstruction property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrlPageInstruction(String value) {
        this.urlPageInstruction = value;
    }

}
