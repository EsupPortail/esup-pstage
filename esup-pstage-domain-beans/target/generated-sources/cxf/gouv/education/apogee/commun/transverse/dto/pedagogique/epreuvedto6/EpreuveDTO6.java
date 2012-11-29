
package gouv.education.apogee.commun.transverse.dto.pedagogique.epreuvedto6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import etudiantwebserviceimpl.impl.webservices.commun.apogee.education.gouv.ArrayOfTns46SalleDTO3;
import gouv.education.apogee.commun.transverse.dto.pedagogique.epreuvedto4.TableauCaracTechDTO;
import gouv.education.apogee.commun.transverse.dto.pedagogique.salledto.TableauPersonnelDTO3;


/**
 * <p>Java class for EpreuveDTO6 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EpreuveDTO6">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codEpreuve" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="descDocsAuto" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="duree" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libCourtEpreuve" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libLongEpreuve" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="listCaracTech" type="{EpreuveDTO4.pedagogique.dto.transverse.commun.apogee.education.gouv}TableauCaracTechDTO"/>
 *         &lt;element name="listEnsResp" type="{SalleDTO.pedagogique.dto.transverse.commun.apogee.education.gouv}TableauPersonnelDTO3"/>
 *         &lt;element name="listSalles" type="{gouv.education.apogee.commun.webservices.impl.EtudiantWebServiceImpl}ArrayOf_tns46_SalleDTO3"/>
 *         &lt;element name="typeExercice" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EpreuveDTO6", propOrder = {
    "codEpreuve",
    "descDocsAuto",
    "duree",
    "libCourtEpreuve",
    "libLongEpreuve",
    "listCaracTech",
    "listEnsResp",
    "listSalles",
    "typeExercice"
})
public class EpreuveDTO6 {

    @XmlElement(required = true, nillable = true)
    protected String codEpreuve;
    @XmlElement(required = true, nillable = true)
    protected String descDocsAuto;
    @XmlElement(required = true, nillable = true)
    protected String duree;
    @XmlElement(required = true, nillable = true)
    protected String libCourtEpreuve;
    @XmlElement(required = true, nillable = true)
    protected String libLongEpreuve;
    @XmlElement(required = true, nillable = true)
    protected TableauCaracTechDTO listCaracTech;
    @XmlElement(required = true, nillable = true)
    protected TableauPersonnelDTO3 listEnsResp;
    @XmlElement(required = true, nillable = true)
    protected ArrayOfTns46SalleDTO3 listSalles;
    @XmlElement(required = true, nillable = true)
    protected String typeExercice;

    /**
     * Gets the value of the codEpreuve property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodEpreuve() {
        return codEpreuve;
    }

    /**
     * Sets the value of the codEpreuve property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodEpreuve(String value) {
        this.codEpreuve = value;
    }

    /**
     * Gets the value of the descDocsAuto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescDocsAuto() {
        return descDocsAuto;
    }

    /**
     * Sets the value of the descDocsAuto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescDocsAuto(String value) {
        this.descDocsAuto = value;
    }

    /**
     * Gets the value of the duree property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDuree() {
        return duree;
    }

    /**
     * Sets the value of the duree property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDuree(String value) {
        this.duree = value;
    }

    /**
     * Gets the value of the libCourtEpreuve property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibCourtEpreuve() {
        return libCourtEpreuve;
    }

    /**
     * Sets the value of the libCourtEpreuve property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibCourtEpreuve(String value) {
        this.libCourtEpreuve = value;
    }

    /**
     * Gets the value of the libLongEpreuve property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibLongEpreuve() {
        return libLongEpreuve;
    }

    /**
     * Sets the value of the libLongEpreuve property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibLongEpreuve(String value) {
        this.libLongEpreuve = value;
    }

    /**
     * Gets the value of the listCaracTech property.
     * 
     * @return
     *     possible object is
     *     {@link TableauCaracTechDTO }
     *     
     */
    public TableauCaracTechDTO getListCaracTech() {
        return listCaracTech;
    }

    /**
     * Sets the value of the listCaracTech property.
     * 
     * @param value
     *     allowed object is
     *     {@link TableauCaracTechDTO }
     *     
     */
    public void setListCaracTech(TableauCaracTechDTO value) {
        this.listCaracTech = value;
    }

    /**
     * Gets the value of the listEnsResp property.
     * 
     * @return
     *     possible object is
     *     {@link TableauPersonnelDTO3 }
     *     
     */
    public TableauPersonnelDTO3 getListEnsResp() {
        return listEnsResp;
    }

    /**
     * Sets the value of the listEnsResp property.
     * 
     * @param value
     *     allowed object is
     *     {@link TableauPersonnelDTO3 }
     *     
     */
    public void setListEnsResp(TableauPersonnelDTO3 value) {
        this.listEnsResp = value;
    }

    /**
     * Gets the value of the listSalles property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfTns46SalleDTO3 }
     *     
     */
    public ArrayOfTns46SalleDTO3 getListSalles() {
        return listSalles;
    }

    /**
     * Sets the value of the listSalles property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfTns46SalleDTO3 }
     *     
     */
    public void setListSalles(ArrayOfTns46SalleDTO3 value) {
        this.listSalles = value;
    }

    /**
     * Gets the value of the typeExercice property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypeExercice() {
        return typeExercice;
    }

    /**
     * Sets the value of the typeExercice property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypeExercice(String value) {
        this.typeExercice = value;
    }

}
