
package gouv.education.apogee.commun.transverse.dto.pedagogique.resultatvetdto;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gouv.education.apogee.commun.transverse.dto.pedagogique.etatdelibdto.EtatDelibDTO;
import gouv.education.apogee.commun.transverse.dto.pedagogique.mentiondto.MentionDTO;
import gouv.education.apogee.commun.transverse.dto.pedagogique.natureresdto.NatureResDTO;
import gouv.education.apogee.commun.transverse.dto.pedagogique.sessiondto.SessionDTO;
import gouv.education.apogee.commun.transverse.dto.pedagogique.typresultatdto.TypResultatDTO;


/**
 * <p>Java class for ResultatVetDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResultatVetDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="barNotVet" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="etatDelib" type="{EtatDelibDTO.pedagogique.dto.transverse.commun.apogee.education.gouv}EtatDelibDTO"/>
 *         &lt;element name="mention" type="{MentionDTO.pedagogique.dto.transverse.commun.apogee.education.gouv}MentionDTO"/>
 *         &lt;element name="natureResultat" type="{NatureResDTO.pedagogique.dto.transverse.commun.apogee.education.gouv}NatureResDTO"/>
 *         &lt;element name="nbrCrdVet" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="nbrRngEtuVet" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nbrRngEtuVetTot" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="notPntJurVet" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="notVet" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="session" type="{SessionDTO.pedagogique.dto.transverse.commun.apogee.education.gouv}SessionDTO"/>
 *         &lt;element name="typResultat" type="{TypResultatDTO.pedagogique.dto.transverse.commun.apogee.education.gouv}TypResultatDTO"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResultatVetDTO", propOrder = {
    "barNotVet",
    "etatDelib",
    "mention",
    "natureResultat",
    "nbrCrdVet",
    "nbrRngEtuVet",
    "nbrRngEtuVetTot",
    "notPntJurVet",
    "notVet",
    "session",
    "typResultat"
})
public class ResultatVetDTO {

    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer barNotVet;
    @XmlElement(required = true, nillable = true)
    protected EtatDelibDTO etatDelib;
    @XmlElement(required = true, nillable = true)
    protected MentionDTO mention;
    @XmlElement(required = true, nillable = true)
    protected NatureResDTO natureResultat;
    @XmlElement(required = true, nillable = true)
    protected BigDecimal nbrCrdVet;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer nbrRngEtuVet;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer nbrRngEtuVetTot;
    @XmlElement(required = true, nillable = true)
    protected BigDecimal notPntJurVet;
    @XmlElement(required = true, nillable = true)
    protected String notVet;
    @XmlElement(required = true, nillable = true)
    protected SessionDTO session;
    @XmlElement(required = true, nillable = true)
    protected TypResultatDTO typResultat;

    /**
     * Gets the value of the barNotVet property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBarNotVet() {
        return barNotVet;
    }

    /**
     * Sets the value of the barNotVet property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBarNotVet(Integer value) {
        this.barNotVet = value;
    }

    /**
     * Gets the value of the etatDelib property.
     * 
     * @return
     *     possible object is
     *     {@link EtatDelibDTO }
     *     
     */
    public EtatDelibDTO getEtatDelib() {
        return etatDelib;
    }

    /**
     * Sets the value of the etatDelib property.
     * 
     * @param value
     *     allowed object is
     *     {@link EtatDelibDTO }
     *     
     */
    public void setEtatDelib(EtatDelibDTO value) {
        this.etatDelib = value;
    }

    /**
     * Gets the value of the mention property.
     * 
     * @return
     *     possible object is
     *     {@link MentionDTO }
     *     
     */
    public MentionDTO getMention() {
        return mention;
    }

    /**
     * Sets the value of the mention property.
     * 
     * @param value
     *     allowed object is
     *     {@link MentionDTO }
     *     
     */
    public void setMention(MentionDTO value) {
        this.mention = value;
    }

    /**
     * Gets the value of the natureResultat property.
     * 
     * @return
     *     possible object is
     *     {@link NatureResDTO }
     *     
     */
    public NatureResDTO getNatureResultat() {
        return natureResultat;
    }

    /**
     * Sets the value of the natureResultat property.
     * 
     * @param value
     *     allowed object is
     *     {@link NatureResDTO }
     *     
     */
    public void setNatureResultat(NatureResDTO value) {
        this.natureResultat = value;
    }

    /**
     * Gets the value of the nbrCrdVet property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getNbrCrdVet() {
        return nbrCrdVet;
    }

    /**
     * Sets the value of the nbrCrdVet property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setNbrCrdVet(BigDecimal value) {
        this.nbrCrdVet = value;
    }

    /**
     * Gets the value of the nbrRngEtuVet property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNbrRngEtuVet() {
        return nbrRngEtuVet;
    }

    /**
     * Sets the value of the nbrRngEtuVet property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNbrRngEtuVet(Integer value) {
        this.nbrRngEtuVet = value;
    }

    /**
     * Gets the value of the nbrRngEtuVetTot property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNbrRngEtuVetTot() {
        return nbrRngEtuVetTot;
    }

    /**
     * Sets the value of the nbrRngEtuVetTot property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNbrRngEtuVetTot(Integer value) {
        this.nbrRngEtuVetTot = value;
    }

    /**
     * Gets the value of the notPntJurVet property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getNotPntJurVet() {
        return notPntJurVet;
    }

    /**
     * Sets the value of the notPntJurVet property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setNotPntJurVet(BigDecimal value) {
        this.notPntJurVet = value;
    }

    /**
     * Gets the value of the notVet property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNotVet() {
        return notVet;
    }

    /**
     * Sets the value of the notVet property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNotVet(String value) {
        this.notVet = value;
    }

    /**
     * Gets the value of the session property.
     * 
     * @return
     *     possible object is
     *     {@link SessionDTO }
     *     
     */
    public SessionDTO getSession() {
        return session;
    }

    /**
     * Sets the value of the session property.
     * 
     * @param value
     *     allowed object is
     *     {@link SessionDTO }
     *     
     */
    public void setSession(SessionDTO value) {
        this.session = value;
    }

    /**
     * Gets the value of the typResultat property.
     * 
     * @return
     *     possible object is
     *     {@link TypResultatDTO }
     *     
     */
    public TypResultatDTO getTypResultat() {
        return typResultat;
    }

    /**
     * Sets the value of the typResultat property.
     * 
     * @param value
     *     allowed object is
     *     {@link TypResultatDTO }
     *     
     */
    public void setTypResultat(TypResultatDTO value) {
        this.typResultat = value;
    }

}
