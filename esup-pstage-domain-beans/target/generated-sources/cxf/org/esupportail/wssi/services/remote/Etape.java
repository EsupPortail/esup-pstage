
package org.esupportail.wssi.services.remote;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for etape complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="etape">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codAct" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codCur" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codCyc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codEtp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="etpGererCge" type="{http://remote.services.wssi.esupportail.org/}etpGererCge" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="libEtp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="licEtp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nbrMaxIaeAut" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="nbrMaxInscDeug" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="temCouAccTrvEtp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="temOuvDrtSsoEtp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="temTypOpi" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "etape", propOrder = {
    "codAct",
    "codCur",
    "codCyc",
    "codEtp",
    "etpGererCge",
    "libEtp",
    "licEtp",
    "nbrMaxIaeAut",
    "nbrMaxInscDeug",
    "temCouAccTrvEtp",
    "temOuvDrtSsoEtp",
    "temTypOpi"
})
public class Etape {

    protected String codAct;
    protected String codCur;
    protected String codCyc;
    protected String codEtp;
    @XmlElement(nillable = true)
    protected List<EtpGererCge> etpGererCge;
    protected String libEtp;
    protected String licEtp;
    protected Integer nbrMaxIaeAut;
    protected Integer nbrMaxInscDeug;
    protected String temCouAccTrvEtp;
    protected String temOuvDrtSsoEtp;
    protected String temTypOpi;

    /**
     * Gets the value of the codAct property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodAct() {
        return codAct;
    }

    /**
     * Sets the value of the codAct property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodAct(String value) {
        this.codAct = value;
    }

    /**
     * Gets the value of the codCur property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodCur() {
        return codCur;
    }

    /**
     * Sets the value of the codCur property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodCur(String value) {
        this.codCur = value;
    }

    /**
     * Gets the value of the codCyc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodCyc() {
        return codCyc;
    }

    /**
     * Sets the value of the codCyc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodCyc(String value) {
        this.codCyc = value;
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
     * Gets the value of the etpGererCge property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the etpGererCge property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEtpGererCge().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EtpGererCge }
     * 
     * 
     */
    public List<EtpGererCge> getEtpGererCge() {
        if (etpGererCge == null) {
            etpGererCge = new ArrayList<EtpGererCge>();
        }
        return this.etpGererCge;
    }

    /**
     * Gets the value of the libEtp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibEtp() {
        return libEtp;
    }

    /**
     * Sets the value of the libEtp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibEtp(String value) {
        this.libEtp = value;
    }

    /**
     * Gets the value of the licEtp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLicEtp() {
        return licEtp;
    }

    /**
     * Sets the value of the licEtp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLicEtp(String value) {
        this.licEtp = value;
    }

    /**
     * Gets the value of the nbrMaxIaeAut property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNbrMaxIaeAut() {
        return nbrMaxIaeAut;
    }

    /**
     * Sets the value of the nbrMaxIaeAut property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNbrMaxIaeAut(Integer value) {
        this.nbrMaxIaeAut = value;
    }

    /**
     * Gets the value of the nbrMaxInscDeug property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNbrMaxInscDeug() {
        return nbrMaxInscDeug;
    }

    /**
     * Sets the value of the nbrMaxInscDeug property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNbrMaxInscDeug(Integer value) {
        this.nbrMaxInscDeug = value;
    }

    /**
     * Gets the value of the temCouAccTrvEtp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemCouAccTrvEtp() {
        return temCouAccTrvEtp;
    }

    /**
     * Sets the value of the temCouAccTrvEtp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemCouAccTrvEtp(String value) {
        this.temCouAccTrvEtp = value;
    }

    /**
     * Gets the value of the temOuvDrtSsoEtp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemOuvDrtSsoEtp() {
        return temOuvDrtSsoEtp;
    }

    /**
     * Sets the value of the temOuvDrtSsoEtp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemOuvDrtSsoEtp(String value) {
        this.temOuvDrtSsoEtp = value;
    }

    /**
     * Gets the value of the temTypOpi property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemTypOpi() {
        return temTypOpi;
    }

    /**
     * Sets the value of the temTypOpi property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemTypOpi(String value) {
        this.temTypOpi = value;
    }

}
