
package gouv.education.apogee.commun.transverse.dto.etudiant.blocagedto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gouv.education.apogee.commun.transverse.dto.etudiant.etapedto.EtapeDTO;
import gouv.education.apogee.commun.transverse.dto.etudiant.typeblocagedto.TypeBlocageDTO;


/**
 * <p>Java class for BlocageDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BlocageDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codBlocage" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="etapeBlocage" type="{EtapeDTO.etudiant.dto.transverse.commun.apogee.education.gouv}EtapeDTO"/>
 *         &lt;element name="libBlocage" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="typBlocage" type="{TypeBlocageDTO.etudiant.dto.transverse.commun.apogee.education.gouv}TypeBlocageDTO"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BlocageDTO", propOrder = {
    "codBlocage",
    "etapeBlocage",
    "libBlocage",
    "typBlocage"
})
public class BlocageDTO {

    @XmlElement(required = true, nillable = true)
    protected String codBlocage;
    @XmlElement(required = true, nillable = true)
    protected EtapeDTO etapeBlocage;
    @XmlElement(required = true, nillable = true)
    protected String libBlocage;
    @XmlElement(required = true, nillable = true)
    protected TypeBlocageDTO typBlocage;

    /**
     * Gets the value of the codBlocage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodBlocage() {
        return codBlocage;
    }

    /**
     * Sets the value of the codBlocage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodBlocage(String value) {
        this.codBlocage = value;
    }

    /**
     * Gets the value of the etapeBlocage property.
     * 
     * @return
     *     possible object is
     *     {@link EtapeDTO }
     *     
     */
    public EtapeDTO getEtapeBlocage() {
        return etapeBlocage;
    }

    /**
     * Sets the value of the etapeBlocage property.
     * 
     * @param value
     *     allowed object is
     *     {@link EtapeDTO }
     *     
     */
    public void setEtapeBlocage(EtapeDTO value) {
        this.etapeBlocage = value;
    }

    /**
     * Gets the value of the libBlocage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibBlocage() {
        return libBlocage;
    }

    /**
     * Sets the value of the libBlocage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibBlocage(String value) {
        this.libBlocage = value;
    }

    /**
     * Gets the value of the typBlocage property.
     * 
     * @return
     *     possible object is
     *     {@link TypeBlocageDTO }
     *     
     */
    public TypeBlocageDTO getTypBlocage() {
        return typBlocage;
    }

    /**
     * Sets the value of the typBlocage property.
     * 
     * @param value
     *     allowed object is
     *     {@link TypeBlocageDTO }
     *     
     */
    public void setTypBlocage(TypeBlocageDTO value) {
        this.typBlocage = value;
    }

}
