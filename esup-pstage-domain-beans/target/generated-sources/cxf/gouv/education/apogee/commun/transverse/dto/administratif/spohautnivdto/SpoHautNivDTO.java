
package gouv.education.apogee.commun.transverse.dto.administratif.spohautnivdto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SpoHautNivDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SpoHautNivDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codSportif" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libelle" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libelleWeb" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SpoHautNivDTO", propOrder = {
    "codSportif",
    "libelle",
    "libelleWeb"
})
public class SpoHautNivDTO {

    @XmlElement(required = true, nillable = true)
    protected String codSportif;
    @XmlElement(required = true, nillable = true)
    protected String libelle;
    @XmlElement(required = true, nillable = true)
    protected String libelleWeb;

    /**
     * Gets the value of the codSportif property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodSportif() {
        return codSportif;
    }

    /**
     * Sets the value of the codSportif property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodSportif(String value) {
        this.codSportif = value;
    }

    /**
     * Gets the value of the libelle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibelle() {
        return libelle;
    }

    /**
     * Sets the value of the libelle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibelle(String value) {
        this.libelle = value;
    }

    /**
     * Gets the value of the libelleWeb property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibelleWeb() {
        return libelleWeb;
    }

    /**
     * Sets the value of the libelleWeb property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibelleWeb(String value) {
        this.libelleWeb = value;
    }

}
