
package gouv.education.apogee.commun.transverse.dto.etudiant.etudiantcriteredto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gouv.education.apogee.commun.transverse.exception.TableauString;


/**
 * <p>Java class for EtudiantCritereDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EtudiantCritereDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="annee" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codeCollectionELP" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codeCollectionVET" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codeEchInter" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codeGroupeELP" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codeGroupeVET" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codeRegimeInscrETP" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="etatThese" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="listCIP" type="{exception.transverse.commun.apogee.education.gouv}TableauString"/>
 *         &lt;element name="listCentreGestion" type="{exception.transverse.commun.apogee.education.gouv}TableauString"/>
 *         &lt;element name="listComposante" type="{exception.transverse.commun.apogee.education.gouv}TableauString"/>
 *         &lt;element name="listDiplomes" type="{EtudiantCritereDTO.etudiant.dto.transverse.commun.apogee.education.gouv}TableauDiplomes"/>
 *         &lt;element name="listELP" type="{exception.transverse.commun.apogee.education.gouv}TableauString"/>
 *         &lt;element name="listEPR" type="{exception.transverse.commun.apogee.education.gouv}TableauString"/>
 *         &lt;element name="listEtapes" type="{EtudiantCritereDTO.etudiant.dto.transverse.commun.apogee.education.gouv}TableauDiplomes"/>
 *         &lt;element name="listPaysEchInter" type="{exception.transverse.commun.apogee.education.gouv}TableauString"/>
 *         &lt;element name="listSitSociale" type="{exception.transverse.commun.apogee.education.gouv}TableauString"/>
 *         &lt;element name="listSportifHautNiv" type="{exception.transverse.commun.apogee.education.gouv}TableauString"/>
 *         &lt;element name="listTypeEtabFreq" type="{exception.transverse.commun.apogee.education.gouv}TableauString"/>
 *         &lt;element name="listTypeHandicap" type="{exception.transverse.commun.apogee.education.gouv}TableauString"/>
 *         &lt;element name="maintienInscrAutreEtab" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="objetResultat" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sensEchInter" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="temPartInternational" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="temValAcquisXP" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="typeResultat" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EtudiantCritereDTO", propOrder = {
    "annee",
    "codeCollectionELP",
    "codeCollectionVET",
    "codeEchInter",
    "codeGroupeELP",
    "codeGroupeVET",
    "codeRegimeInscrETP",
    "etatThese",
    "listCIP",
    "listCentreGestion",
    "listComposante",
    "listDiplomes",
    "listELP",
    "listEPR",
    "listEtapes",
    "listPaysEchInter",
    "listSitSociale",
    "listSportifHautNiv",
    "listTypeEtabFreq",
    "listTypeHandicap",
    "maintienInscrAutreEtab",
    "objetResultat",
    "sensEchInter",
    "temPartInternational",
    "temValAcquisXP",
    "typeResultat"
})
public class EtudiantCritereDTO {

    @XmlElement(required = true, nillable = true)
    protected String annee;
    @XmlElement(required = true, nillable = true)
    protected String codeCollectionELP;
    @XmlElement(required = true, nillable = true)
    protected String codeCollectionVET;
    @XmlElement(required = true, nillable = true)
    protected String codeEchInter;
    @XmlElement(required = true, nillable = true)
    protected String codeGroupeELP;
    @XmlElement(required = true, nillable = true)
    protected String codeGroupeVET;
    @XmlElement(required = true, nillable = true)
    protected String codeRegimeInscrETP;
    @XmlElement(required = true, nillable = true)
    protected String etatThese;
    @XmlElement(required = true, nillable = true)
    protected TableauString listCIP;
    @XmlElement(required = true, nillable = true)
    protected TableauString listCentreGestion;
    @XmlElement(required = true, nillable = true)
    protected TableauString listComposante;
    @XmlElement(required = true, nillable = true)
    protected TableauDiplomes listDiplomes;
    @XmlElement(required = true, nillable = true)
    protected TableauString listELP;
    @XmlElement(required = true, nillable = true)
    protected TableauString listEPR;
    @XmlElement(required = true, nillable = true)
    protected TableauDiplomes listEtapes;
    @XmlElement(required = true, nillable = true)
    protected TableauString listPaysEchInter;
    @XmlElement(required = true, nillable = true)
    protected TableauString listSitSociale;
    @XmlElement(required = true, nillable = true)
    protected TableauString listSportifHautNiv;
    @XmlElement(required = true, nillable = true)
    protected TableauString listTypeEtabFreq;
    @XmlElement(required = true, nillable = true)
    protected TableauString listTypeHandicap;
    @XmlElement(required = true, nillable = true)
    protected String maintienInscrAutreEtab;
    @XmlElement(required = true, nillable = true)
    protected String objetResultat;
    @XmlElement(required = true, nillable = true)
    protected String sensEchInter;
    @XmlElement(required = true, nillable = true)
    protected String temPartInternational;
    @XmlElement(required = true, nillable = true)
    protected String temValAcquisXP;
    @XmlElement(required = true, nillable = true)
    protected String typeResultat;

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
     * Gets the value of the codeCollectionELP property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeCollectionELP() {
        return codeCollectionELP;
    }

    /**
     * Sets the value of the codeCollectionELP property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeCollectionELP(String value) {
        this.codeCollectionELP = value;
    }

    /**
     * Gets the value of the codeCollectionVET property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeCollectionVET() {
        return codeCollectionVET;
    }

    /**
     * Sets the value of the codeCollectionVET property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeCollectionVET(String value) {
        this.codeCollectionVET = value;
    }

    /**
     * Gets the value of the codeEchInter property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeEchInter() {
        return codeEchInter;
    }

    /**
     * Sets the value of the codeEchInter property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeEchInter(String value) {
        this.codeEchInter = value;
    }

    /**
     * Gets the value of the codeGroupeELP property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeGroupeELP() {
        return codeGroupeELP;
    }

    /**
     * Sets the value of the codeGroupeELP property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeGroupeELP(String value) {
        this.codeGroupeELP = value;
    }

    /**
     * Gets the value of the codeGroupeVET property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeGroupeVET() {
        return codeGroupeVET;
    }

    /**
     * Sets the value of the codeGroupeVET property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeGroupeVET(String value) {
        this.codeGroupeVET = value;
    }

    /**
     * Gets the value of the codeRegimeInscrETP property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeRegimeInscrETP() {
        return codeRegimeInscrETP;
    }

    /**
     * Sets the value of the codeRegimeInscrETP property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeRegimeInscrETP(String value) {
        this.codeRegimeInscrETP = value;
    }

    /**
     * Gets the value of the etatThese property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEtatThese() {
        return etatThese;
    }

    /**
     * Sets the value of the etatThese property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEtatThese(String value) {
        this.etatThese = value;
    }

    /**
     * Gets the value of the listCIP property.
     * 
     * @return
     *     possible object is
     *     {@link TableauString }
     *     
     */
    public TableauString getListCIP() {
        return listCIP;
    }

    /**
     * Sets the value of the listCIP property.
     * 
     * @param value
     *     allowed object is
     *     {@link TableauString }
     *     
     */
    public void setListCIP(TableauString value) {
        this.listCIP = value;
    }

    /**
     * Gets the value of the listCentreGestion property.
     * 
     * @return
     *     possible object is
     *     {@link TableauString }
     *     
     */
    public TableauString getListCentreGestion() {
        return listCentreGestion;
    }

    /**
     * Sets the value of the listCentreGestion property.
     * 
     * @param value
     *     allowed object is
     *     {@link TableauString }
     *     
     */
    public void setListCentreGestion(TableauString value) {
        this.listCentreGestion = value;
    }

    /**
     * Gets the value of the listComposante property.
     * 
     * @return
     *     possible object is
     *     {@link TableauString }
     *     
     */
    public TableauString getListComposante() {
        return listComposante;
    }

    /**
     * Sets the value of the listComposante property.
     * 
     * @param value
     *     allowed object is
     *     {@link TableauString }
     *     
     */
    public void setListComposante(TableauString value) {
        this.listComposante = value;
    }

    /**
     * Gets the value of the listDiplomes property.
     * 
     * @return
     *     possible object is
     *     {@link TableauDiplomes }
     *     
     */
    public TableauDiplomes getListDiplomes() {
        return listDiplomes;
    }

    /**
     * Sets the value of the listDiplomes property.
     * 
     * @param value
     *     allowed object is
     *     {@link TableauDiplomes }
     *     
     */
    public void setListDiplomes(TableauDiplomes value) {
        this.listDiplomes = value;
    }

    /**
     * Gets the value of the listELP property.
     * 
     * @return
     *     possible object is
     *     {@link TableauString }
     *     
     */
    public TableauString getListELP() {
        return listELP;
    }

    /**
     * Sets the value of the listELP property.
     * 
     * @param value
     *     allowed object is
     *     {@link TableauString }
     *     
     */
    public void setListELP(TableauString value) {
        this.listELP = value;
    }

    /**
     * Gets the value of the listEPR property.
     * 
     * @return
     *     possible object is
     *     {@link TableauString }
     *     
     */
    public TableauString getListEPR() {
        return listEPR;
    }

    /**
     * Sets the value of the listEPR property.
     * 
     * @param value
     *     allowed object is
     *     {@link TableauString }
     *     
     */
    public void setListEPR(TableauString value) {
        this.listEPR = value;
    }

    /**
     * Gets the value of the listEtapes property.
     * 
     * @return
     *     possible object is
     *     {@link TableauDiplomes }
     *     
     */
    public TableauDiplomes getListEtapes() {
        return listEtapes;
    }

    /**
     * Sets the value of the listEtapes property.
     * 
     * @param value
     *     allowed object is
     *     {@link TableauDiplomes }
     *     
     */
    public void setListEtapes(TableauDiplomes value) {
        this.listEtapes = value;
    }

    /**
     * Gets the value of the listPaysEchInter property.
     * 
     * @return
     *     possible object is
     *     {@link TableauString }
     *     
     */
    public TableauString getListPaysEchInter() {
        return listPaysEchInter;
    }

    /**
     * Sets the value of the listPaysEchInter property.
     * 
     * @param value
     *     allowed object is
     *     {@link TableauString }
     *     
     */
    public void setListPaysEchInter(TableauString value) {
        this.listPaysEchInter = value;
    }

    /**
     * Gets the value of the listSitSociale property.
     * 
     * @return
     *     possible object is
     *     {@link TableauString }
     *     
     */
    public TableauString getListSitSociale() {
        return listSitSociale;
    }

    /**
     * Sets the value of the listSitSociale property.
     * 
     * @param value
     *     allowed object is
     *     {@link TableauString }
     *     
     */
    public void setListSitSociale(TableauString value) {
        this.listSitSociale = value;
    }

    /**
     * Gets the value of the listSportifHautNiv property.
     * 
     * @return
     *     possible object is
     *     {@link TableauString }
     *     
     */
    public TableauString getListSportifHautNiv() {
        return listSportifHautNiv;
    }

    /**
     * Sets the value of the listSportifHautNiv property.
     * 
     * @param value
     *     allowed object is
     *     {@link TableauString }
     *     
     */
    public void setListSportifHautNiv(TableauString value) {
        this.listSportifHautNiv = value;
    }

    /**
     * Gets the value of the listTypeEtabFreq property.
     * 
     * @return
     *     possible object is
     *     {@link TableauString }
     *     
     */
    public TableauString getListTypeEtabFreq() {
        return listTypeEtabFreq;
    }

    /**
     * Sets the value of the listTypeEtabFreq property.
     * 
     * @param value
     *     allowed object is
     *     {@link TableauString }
     *     
     */
    public void setListTypeEtabFreq(TableauString value) {
        this.listTypeEtabFreq = value;
    }

    /**
     * Gets the value of the listTypeHandicap property.
     * 
     * @return
     *     possible object is
     *     {@link TableauString }
     *     
     */
    public TableauString getListTypeHandicap() {
        return listTypeHandicap;
    }

    /**
     * Sets the value of the listTypeHandicap property.
     * 
     * @param value
     *     allowed object is
     *     {@link TableauString }
     *     
     */
    public void setListTypeHandicap(TableauString value) {
        this.listTypeHandicap = value;
    }

    /**
     * Gets the value of the maintienInscrAutreEtab property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaintienInscrAutreEtab() {
        return maintienInscrAutreEtab;
    }

    /**
     * Sets the value of the maintienInscrAutreEtab property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaintienInscrAutreEtab(String value) {
        this.maintienInscrAutreEtab = value;
    }

    /**
     * Gets the value of the objetResultat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObjetResultat() {
        return objetResultat;
    }

    /**
     * Sets the value of the objetResultat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObjetResultat(String value) {
        this.objetResultat = value;
    }

    /**
     * Gets the value of the sensEchInter property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSensEchInter() {
        return sensEchInter;
    }

    /**
     * Sets the value of the sensEchInter property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSensEchInter(String value) {
        this.sensEchInter = value;
    }

    /**
     * Gets the value of the temPartInternational property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemPartInternational() {
        return temPartInternational;
    }

    /**
     * Sets the value of the temPartInternational property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemPartInternational(String value) {
        this.temPartInternational = value;
    }

    /**
     * Gets the value of the temValAcquisXP property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemValAcquisXP() {
        return temValAcquisXP;
    }

    /**
     * Sets the value of the temValAcquisXP property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemValAcquisXP(String value) {
        this.temValAcquisXP = value;
    }

    /**
     * Gets the value of the typeResultat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypeResultat() {
        return typeResultat;
    }

    /**
     * Sets the value of the typeResultat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypeResultat(String value) {
        this.typeResultat = value;
    }

}
