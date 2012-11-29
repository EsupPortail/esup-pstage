
package org.esupportail.wssi.services.remote;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for critereVdiDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="critereVdiDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codDip" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codEtp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codTpdEtb" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="codVrsVdi" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="codVrsVet" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="codeDiplome" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="dateRct" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="libWebVdi" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="methodToExecute" type="{http://remote.services.wssi.esupportail.org/}methodToLookForVdi" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="onlyTerminaux" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="typeCritere" type="{http://remote.services.wssi.esupportail.org/}typeCritereVdi" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "critereVdiDTO", propOrder = {
    "codDip",
    "codEtp",
    "codTpdEtb",
    "codVrsVdi",
    "codVrsVet",
    "codeDiplome",
    "dateRct",
    "libWebVdi",
    "methodToExecute",
    "onlyTerminaux",
    "typeCritere"
})
public class CritereVdiDTO {

    protected String codDip;
    protected String codEtp;
    @XmlElement(nillable = true)
    protected List<String> codTpdEtb;
    protected Integer codVrsVdi;
    protected Integer codVrsVet;
    @XmlElement(nillable = true)
    protected List<String> codeDiplome;
    protected String dateRct;
    protected String libWebVdi;
    @XmlElement(nillable = true)
    protected List<MethodToLookForVdi> methodToExecute;
    protected Boolean onlyTerminaux;
    protected TypeCritereVdi typeCritere;

    /**
     * Gets the value of the codDip property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodDip() {
        return codDip;
    }

    /**
     * Sets the value of the codDip property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodDip(String value) {
        this.codDip = value;
    }

    /**
     * Gets the value of the codEtp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodEtp() {
        return codEtp;
    }

    /**
     * Sets the value of the codEtp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodEtp(String value) {
        this.codEtp = value;
    }

    /**
     * Gets the value of the codTpdEtb property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the codTpdEtb property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCodTpdEtb().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getCodTpdEtb() {
        if (codTpdEtb == null) {
            codTpdEtb = new ArrayList<String>();
        }
        return this.codTpdEtb;
    }

    /**
     * Gets the value of the codVrsVdi property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCodVrsVdi() {
        return codVrsVdi;
    }

    /**
     * Sets the value of the codVrsVdi property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCodVrsVdi(Integer value) {
        this.codVrsVdi = value;
    }

    /**
     * Gets the value of the codVrsVet property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCodVrsVet() {
        return codVrsVet;
    }

    /**
     * Sets the value of the codVrsVet property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCodVrsVet(Integer value) {
        this.codVrsVet = value;
    }

    /**
     * Gets the value of the codeDiplome property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the codeDiplome property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCodeDiplome().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getCodeDiplome() {
        if (codeDiplome == null) {
            codeDiplome = new ArrayList<String>();
        }
        return this.codeDiplome;
    }

    /**
     * Gets the value of the dateRct property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateRct() {
        return dateRct;
    }

    /**
     * Sets the value of the dateRct property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateRct(String value) {
        this.dateRct = value;
    }

    /**
     * Gets the value of the libWebVdi property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibWebVdi() {
        return libWebVdi;
    }

    /**
     * Sets the value of the libWebVdi property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibWebVdi(String value) {
        this.libWebVdi = value;
    }

    /**
     * Gets the value of the methodToExecute property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the methodToExecute property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMethodToExecute().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MethodToLookForVdi }
     * 
     * 
     */
    public List<MethodToLookForVdi> getMethodToExecute() {
        if (methodToExecute == null) {
            methodToExecute = new ArrayList<MethodToLookForVdi>();
        }
        return this.methodToExecute;
    }

    /**
     * Gets the value of the onlyTerminaux property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isOnlyTerminaux() {
        return onlyTerminaux;
    }

    /**
     * Sets the value of the onlyTerminaux property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setOnlyTerminaux(Boolean value) {
        this.onlyTerminaux = value;
    }

    /**
     * Gets the value of the typeCritere property.
     * 
     * @return
     *     possible object is
     *     {@link TypeCritereVdi }
     *     
     */
    public TypeCritereVdi getTypeCritere() {
        return typeCritere;
    }

    /**
     * Sets the value of the typeCritere property.
     * 
     * @param value
     *     allowed object is
     *     {@link TypeCritereVdi }
     *     
     */
    public void setTypeCritere(TypeCritereVdi value) {
        this.typeCritere = value;
    }

}
