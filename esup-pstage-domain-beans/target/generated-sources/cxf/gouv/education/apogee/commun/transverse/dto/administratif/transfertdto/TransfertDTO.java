
package gouv.education.apogee.commun.transverse.dto.administratif.transfertdto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import gouv.education.apogee.commun.transverse.dto.administratif.departementdto.DepartementDTO;
import gouv.education.apogee.commun.transverse.dto.administratif.etablissementdto.EtablissementDTO;
import gouv.education.apogee.commun.transverse.dto.administratif.paysdto.PaysDTO;
import gouv.education.apogee.commun.transverse.dto.administratif.typdiplomeextdto.TypDiplomeExtDTO;


/**
 * <p>Java class for TransfertDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TransfertDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="anneeTransfert" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="commentaireTransfert" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dateTransfert" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="departement" type="{DepartementDTO.administratif.dto.transverse.commun.apogee.education.gouv}DepartementDTO"/>
 *         &lt;element name="etablissement" type="{EtablissementDTO.administratif.dto.transverse.commun.apogee.education.gouv}EtablissementDTO"/>
 *         &lt;element name="pays" type="{PaysDTO.administratif.dto.transverse.commun.apogee.education.gouv}PaysDTO"/>
 *         &lt;element name="typeDiplomeExt" type="{TypDiplomeExtDTO.administratif.dto.transverse.commun.apogee.education.gouv}TypDiplomeExtDTO"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransfertDTO", propOrder = {
    "anneeTransfert",
    "commentaireTransfert",
    "dateTransfert",
    "departement",
    "etablissement",
    "pays",
    "typeDiplomeExt"
})
public class TransfertDTO {

    @XmlElement(required = true, nillable = true)
    protected String anneeTransfert;
    @XmlElement(required = true, nillable = true)
    protected String commentaireTransfert;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateTransfert;
    @XmlElement(required = true, nillable = true)
    protected DepartementDTO departement;
    @XmlElement(required = true, nillable = true)
    protected EtablissementDTO etablissement;
    @XmlElement(required = true, nillable = true)
    protected PaysDTO pays;
    @XmlElement(required = true, nillable = true)
    protected TypDiplomeExtDTO typeDiplomeExt;

    /**
     * Gets the value of the anneeTransfert property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnneeTransfert() {
        return anneeTransfert;
    }

    /**
     * Sets the value of the anneeTransfert property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnneeTransfert(String value) {
        this.anneeTransfert = value;
    }

    /**
     * Gets the value of the commentaireTransfert property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommentaireTransfert() {
        return commentaireTransfert;
    }

    /**
     * Sets the value of the commentaireTransfert property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommentaireTransfert(String value) {
        this.commentaireTransfert = value;
    }

    /**
     * Gets the value of the dateTransfert property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateTransfert() {
        return dateTransfert;
    }

    /**
     * Sets the value of the dateTransfert property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateTransfert(XMLGregorianCalendar value) {
        this.dateTransfert = value;
    }

    /**
     * Gets the value of the departement property.
     * 
     * @return
     *     possible object is
     *     {@link DepartementDTO }
     *     
     */
    public DepartementDTO getDepartement() {
        return departement;
    }

    /**
     * Sets the value of the departement property.
     * 
     * @param value
     *     allowed object is
     *     {@link DepartementDTO }
     *     
     */
    public void setDepartement(DepartementDTO value) {
        this.departement = value;
    }

    /**
     * Gets the value of the etablissement property.
     * 
     * @return
     *     possible object is
     *     {@link EtablissementDTO }
     *     
     */
    public EtablissementDTO getEtablissement() {
        return etablissement;
    }

    /**
     * Sets the value of the etablissement property.
     * 
     * @param value
     *     allowed object is
     *     {@link EtablissementDTO }
     *     
     */
    public void setEtablissement(EtablissementDTO value) {
        this.etablissement = value;
    }

    /**
     * Gets the value of the pays property.
     * 
     * @return
     *     possible object is
     *     {@link PaysDTO }
     *     
     */
    public PaysDTO getPays() {
        return pays;
    }

    /**
     * Sets the value of the pays property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaysDTO }
     *     
     */
    public void setPays(PaysDTO value) {
        this.pays = value;
    }

    /**
     * Gets the value of the typeDiplomeExt property.
     * 
     * @return
     *     possible object is
     *     {@link TypDiplomeExtDTO }
     *     
     */
    public TypDiplomeExtDTO getTypeDiplomeExt() {
        return typeDiplomeExt;
    }

    /**
     * Sets the value of the typeDiplomeExt property.
     * 
     * @param value
     *     allowed object is
     *     {@link TypDiplomeExtDTO }
     *     
     */
    public void setTypeDiplomeExt(TypDiplomeExtDTO value) {
        this.typeDiplomeExt = value;
    }

}
