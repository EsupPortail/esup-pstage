
package gouv.education.apogee.commun.transverse.dto.pedagogique.epreuveelpdto2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gouv.education.apogee.commun.transverse.dto.pedagogique.epreuvedto2.EpreuveDTO2;
import gouv.education.apogee.commun.transverse.dto.pedagogique.natureresdto.NatureResDTO;


/**
 * <p>Java class for EpreuveElpDTO2 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EpreuveElpDTO2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="annee" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="epreuve" type="{EpreuveDTO2.pedagogique.dto.transverse.commun.apogee.education.gouv}EpreuveDTO2"/>
 *         &lt;element name="natureResultat" type="{NatureResDTO.pedagogique.dto.transverse.commun.apogee.education.gouv}NatureResDTO"/>
 *         &lt;element name="resultatEpr" type="{EpreuveElpDTO2.pedagogique.dto.transverse.commun.apogee.education.gouv}TableauResultatEprDto2"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EpreuveElpDTO2", propOrder = {
    "annee",
    "epreuve",
    "natureResultat",
    "resultatEpr"
})
public class EpreuveElpDTO2 {

    @XmlElement(required = true, nillable = true)
    protected String annee;
    @XmlElement(required = true, nillable = true)
    protected EpreuveDTO2 epreuve;
    @XmlElement(required = true, nillable = true)
    protected NatureResDTO natureResultat;
    @XmlElement(required = true, nillable = true)
    protected TableauResultatEprDto2 resultatEpr;

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
     * Gets the value of the epreuve property.
     * 
     * @return
     *     possible object is
     *     {@link EpreuveDTO2 }
     *     
     */
    public EpreuveDTO2 getEpreuve() {
        return epreuve;
    }

    /**
     * Sets the value of the epreuve property.
     * 
     * @param value
     *     allowed object is
     *     {@link EpreuveDTO2 }
     *     
     */
    public void setEpreuve(EpreuveDTO2 value) {
        this.epreuve = value;
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
     * Gets the value of the resultatEpr property.
     * 
     * @return
     *     possible object is
     *     {@link TableauResultatEprDto2 }
     *     
     */
    public TableauResultatEprDto2 getResultatEpr() {
        return resultatEpr;
    }

    /**
     * Sets the value of the resultatEpr property.
     * 
     * @param value
     *     allowed object is
     *     {@link TableauResultatEprDto2 }
     *     
     */
    public void setResultatEpr(TableauResultatEprDto2 value) {
        this.resultatEpr = value;
    }

}
