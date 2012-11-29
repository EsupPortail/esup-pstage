
package gouv.education.apogee.commun.transverse.dto.etudiant.indbacdto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gouv.education.apogee.commun.transverse.dto.etudiant.departementcourtdto.DepartementCourtDTO;
import gouv.education.apogee.commun.transverse.dto.etudiant.etablissementdto.EtablissementDTO;
import gouv.education.apogee.commun.transverse.dto.etudiant.mentionnivbacdto.MentionNivBacDTO;
import gouv.education.apogee.commun.transverse.dto.etudiant.typeetablissementdto.TypeEtablissementDTO;


/**
 * <p>Java class for IndBacDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IndBacDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="anneeObtentionBac" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codBac" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="departementBac" type="{DepartementCourtDTO.etudiant.dto.transverse.commun.apogee.education.gouv}DepartementCourtDTO"/>
 *         &lt;element name="etbBac" type="{EtablissementDTO.etudiant.dto.transverse.commun.apogee.education.gouv}EtablissementDTO"/>
 *         &lt;element name="libelleBac" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="mentionBac" type="{MentionNivBacDTO.etudiant.dto.transverse.commun.apogee.education.gouv}MentionNivBacDTO"/>
 *         &lt;element name="typeEtbBac" type="{TypeEtablissementDTO.etudiant.dto.transverse.commun.apogee.education.gouv}TypeEtablissementDTO"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IndBacDTO", propOrder = {
    "anneeObtentionBac",
    "codBac",
    "departementBac",
    "etbBac",
    "libelleBac",
    "mentionBac",
    "typeEtbBac"
})
public class IndBacDTO {

    @XmlElement(required = true, nillable = true)
    protected String anneeObtentionBac;
    @XmlElement(required = true, nillable = true)
    protected String codBac;
    @XmlElement(required = true, nillable = true)
    protected DepartementCourtDTO departementBac;
    @XmlElement(required = true, nillable = true)
    protected EtablissementDTO etbBac;
    @XmlElement(required = true, nillable = true)
    protected String libelleBac;
    @XmlElement(required = true, nillable = true)
    protected MentionNivBacDTO mentionBac;
    @XmlElement(required = true, nillable = true)
    protected TypeEtablissementDTO typeEtbBac;

    /**
     * Gets the value of the anneeObtentionBac property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnneeObtentionBac() {
        return anneeObtentionBac;
    }

    /**
     * Sets the value of the anneeObtentionBac property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnneeObtentionBac(String value) {
        this.anneeObtentionBac = value;
    }

    /**
     * Gets the value of the codBac property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodBac() {
        return codBac;
    }

    /**
     * Sets the value of the codBac property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodBac(String value) {
        this.codBac = value;
    }

    /**
     * Gets the value of the departementBac property.
     * 
     * @return
     *     possible object is
     *     {@link DepartementCourtDTO }
     *     
     */
    public DepartementCourtDTO getDepartementBac() {
        return departementBac;
    }

    /**
     * Sets the value of the departementBac property.
     * 
     * @param value
     *     allowed object is
     *     {@link DepartementCourtDTO }
     *     
     */
    public void setDepartementBac(DepartementCourtDTO value) {
        this.departementBac = value;
    }

    /**
     * Gets the value of the etbBac property.
     * 
     * @return
     *     possible object is
     *     {@link EtablissementDTO }
     *     
     */
    public EtablissementDTO getEtbBac() {
        return etbBac;
    }

    /**
     * Sets the value of the etbBac property.
     * 
     * @param value
     *     allowed object is
     *     {@link EtablissementDTO }
     *     
     */
    public void setEtbBac(EtablissementDTO value) {
        this.etbBac = value;
    }

    /**
     * Gets the value of the libelleBac property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibelleBac() {
        return libelleBac;
    }

    /**
     * Sets the value of the libelleBac property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibelleBac(String value) {
        this.libelleBac = value;
    }

    /**
     * Gets the value of the mentionBac property.
     * 
     * @return
     *     possible object is
     *     {@link MentionNivBacDTO }
     *     
     */
    public MentionNivBacDTO getMentionBac() {
        return mentionBac;
    }

    /**
     * Sets the value of the mentionBac property.
     * 
     * @param value
     *     allowed object is
     *     {@link MentionNivBacDTO }
     *     
     */
    public void setMentionBac(MentionNivBacDTO value) {
        this.mentionBac = value;
    }

    /**
     * Gets the value of the typeEtbBac property.
     * 
     * @return
     *     possible object is
     *     {@link TypeEtablissementDTO }
     *     
     */
    public TypeEtablissementDTO getTypeEtbBac() {
        return typeEtbBac;
    }

    /**
     * Sets the value of the typeEtbBac property.
     * 
     * @param value
     *     allowed object is
     *     {@link TypeEtablissementDTO }
     *     
     */
    public void setTypeEtbBac(TypeEtablissementDTO value) {
        this.typeEtbBac = value;
    }

}
