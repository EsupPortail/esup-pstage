
package gouv.education.apogee.commun.transverse.dto.pedagogique.resultateprdto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gouv.education.apogee.commun.transverse.dto.pedagogique.etatdelibdto.EtatDelibDTO;
import gouv.education.apogee.commun.transverse.dto.pedagogique.sessiondto.SessionDTO;
import gouv.education.apogee.commun.transverse.dto.pedagogique.typresultatdto.TypResultatDTO;


/**
 * <p>Java class for ResultatEprDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResultatEprDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="barNotEpr" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="codAnu" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="etatDelib" type="{EtatDelibDTO.pedagogique.dto.transverse.commun.apogee.education.gouv}EtatDelibDTO"/>
 *         &lt;element name="notEpr" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlType(name = "ResultatEprDTO", propOrder = {
    "barNotEpr",
    "codAnu",
    "etatDelib",
    "notEpr",
    "session",
    "typResultat"
})
public class ResultatEprDTO {

    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer barNotEpr;
    @XmlElement(required = true, nillable = true)
    protected String codAnu;
    @XmlElement(required = true, nillable = true)
    protected EtatDelibDTO etatDelib;
    @XmlElement(required = true, nillable = true)
    protected String notEpr;
    @XmlElement(required = true, nillable = true)
    protected SessionDTO session;
    @XmlElement(required = true, nillable = true)
    protected TypResultatDTO typResultat;

    /**
     * Gets the value of the barNotEpr property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBarNotEpr() {
        return barNotEpr;
    }

    /**
     * Sets the value of the barNotEpr property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBarNotEpr(Integer value) {
        this.barNotEpr = value;
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
     * Gets the value of the notEpr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNotEpr() {
        return notEpr;
    }

    /**
     * Sets the value of the notEpr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNotEpr(String value) {
        this.notEpr = value;
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
