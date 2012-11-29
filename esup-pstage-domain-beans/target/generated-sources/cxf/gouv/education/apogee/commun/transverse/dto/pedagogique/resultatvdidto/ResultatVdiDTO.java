
package gouv.education.apogee.commun.transverse.dto.pedagogique.resultatvdidto;

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
 * <p>Java class for ResultatVdiDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResultatVdiDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="barNotVdi" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="etatDelib" type="{EtatDelibDTO.pedagogique.dto.transverse.commun.apogee.education.gouv}EtatDelibDTO"/>
 *         &lt;element name="mention" type="{MentionDTO.pedagogique.dto.transverse.commun.apogee.education.gouv}MentionDTO"/>
 *         &lt;element name="natureResultat" type="{NatureResDTO.pedagogique.dto.transverse.commun.apogee.education.gouv}NatureResDTO"/>
 *         &lt;element name="nbrCrdVdi" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="nbrRngEtuVdi" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nbrRngEtuVdiTot" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="notPntJurVdi" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="notVdi" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlType(name = "ResultatVdiDTO", propOrder = {
    "barNotVdi",
    "etatDelib",
    "mention",
    "natureResultat",
    "nbrCrdVdi",
    "nbrRngEtuVdi",
    "nbrRngEtuVdiTot",
    "notPntJurVdi",
    "notVdi",
    "session",
    "typResultat"
})
public class ResultatVdiDTO {

    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer barNotVdi;
    @XmlElement(required = true, nillable = true)
    protected EtatDelibDTO etatDelib;
    @XmlElement(required = true, nillable = true)
    protected MentionDTO mention;
    @XmlElement(required = true, nillable = true)
    protected NatureResDTO natureResultat;
    @XmlElement(required = true, nillable = true)
    protected BigDecimal nbrCrdVdi;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer nbrRngEtuVdi;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer nbrRngEtuVdiTot;
    @XmlElement(required = true, nillable = true)
    protected BigDecimal notPntJurVdi;
    @XmlElement(required = true, nillable = true)
    protected String notVdi;
    @XmlElement(required = true, nillable = true)
    protected SessionDTO session;
    @XmlElement(required = true, nillable = true)
    protected TypResultatDTO typResultat;

    /**
     * Gets the value of the barNotVdi property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBarNotVdi() {
        return barNotVdi;
    }

    /**
     * Sets the value of the barNotVdi property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBarNotVdi(Integer value) {
        this.barNotVdi = value;
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
     * Gets the value of the nbrCrdVdi property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getNbrCrdVdi() {
        return nbrCrdVdi;
    }

    /**
     * Sets the value of the nbrCrdVdi property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setNbrCrdVdi(BigDecimal value) {
        this.nbrCrdVdi = value;
    }

    /**
     * Gets the value of the nbrRngEtuVdi property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNbrRngEtuVdi() {
        return nbrRngEtuVdi;
    }

    /**
     * Sets the value of the nbrRngEtuVdi property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNbrRngEtuVdi(Integer value) {
        this.nbrRngEtuVdi = value;
    }

    /**
     * Gets the value of the nbrRngEtuVdiTot property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNbrRngEtuVdiTot() {
        return nbrRngEtuVdiTot;
    }

    /**
     * Sets the value of the nbrRngEtuVdiTot property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNbrRngEtuVdiTot(Integer value) {
        this.nbrRngEtuVdiTot = value;
    }

    /**
     * Gets the value of the notPntJurVdi property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getNotPntJurVdi() {
        return notPntJurVdi;
    }

    /**
     * Sets the value of the notPntJurVdi property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setNotPntJurVdi(BigDecimal value) {
        this.notPntJurVdi = value;
    }

    /**
     * Gets the value of the notVdi property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNotVdi() {
        return notVdi;
    }

    /**
     * Sets the value of the notVdi property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNotVdi(String value) {
        this.notVdi = value;
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
