
package gouv.education.apogee.commun.transverse.dto.pedagogique.resultatelpdto3;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gouv.education.apogee.commun.transverse.dto.pedagogique.elpcorrespondelpdto.ElpCorrespondElpDTO;
import gouv.education.apogee.commun.transverse.dto.pedagogique.etatdelibdto.EtatDelibDTO;
import gouv.education.apogee.commun.transverse.dto.pedagogique.mentiondto.MentionDTO;
import gouv.education.apogee.commun.transverse.dto.pedagogique.natureresdto.NatureResDTO;
import gouv.education.apogee.commun.transverse.dto.pedagogique.sessiondto.SessionDTO;
import gouv.education.apogee.commun.transverse.dto.pedagogique.typresultatdto.TypResultatDTO;


/**
 * <p>Java class for ResultatElpDTO3 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResultatElpDTO3">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="barNotElp" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="codAnu" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="etatDelib" type="{EtatDelibDTO.pedagogique.dto.transverse.commun.apogee.education.gouv}EtatDelibDTO"/>
 *         &lt;element name="lcc" type="{ElpCorrespondElpDTO.pedagogique.dto.transverse.commun.apogee.education.gouv}ElpCorrespondElpDTO"/>
 *         &lt;element name="libCmtTrv" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libRvn" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="mention" type="{MentionDTO.pedagogique.dto.transverse.commun.apogee.education.gouv}MentionDTO"/>
 *         &lt;element name="natureResultat" type="{NatureResDTO.pedagogique.dto.transverse.commun.apogee.education.gouv}NatureResDTO"/>
 *         &lt;element name="nbrCrdElp" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="nbrRngEtuElp" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nbrRngEtuElpTot" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="notElp" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="notPntJurElp" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="session" type="{SessionDTO.pedagogique.dto.transverse.commun.apogee.education.gouv}SessionDTO"/>
 *         &lt;element name="temResEstComp" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="temResMeiNot" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="temResSerComp" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlType(name = "ResultatElpDTO3", propOrder = {
    "barNotElp",
    "codAnu",
    "etatDelib",
    "lcc",
    "libCmtTrv",
    "libRvn",
    "mention",
    "natureResultat",
    "nbrCrdElp",
    "nbrRngEtuElp",
    "nbrRngEtuElpTot",
    "notElp",
    "notPntJurElp",
    "session",
    "temResEstComp",
    "temResMeiNot",
    "temResSerComp",
    "typResultat"
})
public class ResultatElpDTO3 {

    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer barNotElp;
    @XmlElement(required = true, nillable = true)
    protected String codAnu;
    @XmlElement(required = true, nillable = true)
    protected EtatDelibDTO etatDelib;
    @XmlElement(required = true, nillable = true)
    protected ElpCorrespondElpDTO lcc;
    @XmlElement(required = true, nillable = true)
    protected String libCmtTrv;
    @XmlElement(required = true, nillable = true)
    protected String libRvn;
    @XmlElement(required = true, nillable = true)
    protected MentionDTO mention;
    @XmlElement(required = true, nillable = true)
    protected NatureResDTO natureResultat;
    @XmlElement(required = true, nillable = true)
    protected BigDecimal nbrCrdElp;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer nbrRngEtuElp;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer nbrRngEtuElpTot;
    @XmlElement(required = true, nillable = true)
    protected String notElp;
    @XmlElement(required = true, nillable = true)
    protected BigDecimal notPntJurElp;
    @XmlElement(required = true, nillable = true)
    protected SessionDTO session;
    @XmlElement(required = true, nillable = true)
    protected String temResEstComp;
    @XmlElement(required = true, nillable = true)
    protected String temResMeiNot;
    @XmlElement(required = true, nillable = true)
    protected String temResSerComp;
    @XmlElement(required = true, nillable = true)
    protected TypResultatDTO typResultat;

    /**
     * Gets the value of the barNotElp property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBarNotElp() {
        return barNotElp;
    }

    /**
     * Sets the value of the barNotElp property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBarNotElp(Integer value) {
        this.barNotElp = value;
    }

    /**
     * Gets the value of the codAnu property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodAnu() {
        return codAnu;
    }

    /**
     * Sets the value of the codAnu property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodAnu(String value) {
        this.codAnu = value;
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
     * Gets the value of the lcc property.
     * 
     * @return
     *     possible object is
     *     {@link ElpCorrespondElpDTO }
     *     
     */
    public ElpCorrespondElpDTO getLcc() {
        return lcc;
    }

    /**
     * Sets the value of the lcc property.
     * 
     * @param value
     *     allowed object is
     *     {@link ElpCorrespondElpDTO }
     *     
     */
    public void setLcc(ElpCorrespondElpDTO value) {
        this.lcc = value;
    }

    /**
     * Gets the value of the libCmtTrv property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibCmtTrv() {
        return libCmtTrv;
    }

    /**
     * Sets the value of the libCmtTrv property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibCmtTrv(String value) {
        this.libCmtTrv = value;
    }

    /**
     * Gets the value of the libRvn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibRvn() {
        return libRvn;
    }

    /**
     * Sets the value of the libRvn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibRvn(String value) {
        this.libRvn = value;
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
     * Gets the value of the nbrCrdElp property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getNbrCrdElp() {
        return nbrCrdElp;
    }

    /**
     * Sets the value of the nbrCrdElp property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setNbrCrdElp(BigDecimal value) {
        this.nbrCrdElp = value;
    }

    /**
     * Gets the value of the nbrRngEtuElp property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNbrRngEtuElp() {
        return nbrRngEtuElp;
    }

    /**
     * Sets the value of the nbrRngEtuElp property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNbrRngEtuElp(Integer value) {
        this.nbrRngEtuElp = value;
    }

    /**
     * Gets the value of the nbrRngEtuElpTot property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNbrRngEtuElpTot() {
        return nbrRngEtuElpTot;
    }

    /**
     * Sets the value of the nbrRngEtuElpTot property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNbrRngEtuElpTot(Integer value) {
        this.nbrRngEtuElpTot = value;
    }

    /**
     * Gets the value of the notElp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNotElp() {
        return notElp;
    }

    /**
     * Sets the value of the notElp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNotElp(String value) {
        this.notElp = value;
    }

    /**
     * Gets the value of the notPntJurElp property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getNotPntJurElp() {
        return notPntJurElp;
    }

    /**
     * Sets the value of the notPntJurElp property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setNotPntJurElp(BigDecimal value) {
        this.notPntJurElp = value;
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
     * Gets the value of the temResEstComp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemResEstComp() {
        return temResEstComp;
    }

    /**
     * Sets the value of the temResEstComp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemResEstComp(String value) {
        this.temResEstComp = value;
    }

    /**
     * Gets the value of the temResMeiNot property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemResMeiNot() {
        return temResMeiNot;
    }

    /**
     * Sets the value of the temResMeiNot property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemResMeiNot(String value) {
        this.temResMeiNot = value;
    }

    /**
     * Gets the value of the temResSerComp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemResSerComp() {
        return temResSerComp;
    }

    /**
     * Sets the value of the temResSerComp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemResSerComp(String value) {
        this.temResSerComp = value;
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
