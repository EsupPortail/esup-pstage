
package org.esupportail.wssi.services.remote;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for etpGererCge complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="etpGererCge">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="centreGestion" type="{http://remote.services.wssi.esupportail.org/}centreGestion" minOccurs="0"/>
 *         &lt;element name="codCge" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codCmp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codEtp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="etape" type="{http://remote.services.wssi.esupportail.org/}etape" minOccurs="0"/>
 *         &lt;element name="nbrCptAccEtu" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "etpGererCge", propOrder = {
    "centreGestion",
    "codCge",
    "codCmp",
    "codEtp",
    "etape",
    "nbrCptAccEtu"
})
public class EtpGererCge {

    protected CentreGestion centreGestion;
    protected String codCge;
    protected String codCmp;
    protected String codEtp;
    protected Etape etape;
    protected String nbrCptAccEtu;

    /**
     * Gets the value of the centreGestion property.
     * 
     * @return
     *     possible object is
     *     {@link CentreGestion }
     *     
     */
    public CentreGestion getCentreGestion() {
        return centreGestion;
    }

    /**
     * Sets the value of the centreGestion property.
     * 
     * @param value
     *     allowed object is
     *     {@link CentreGestion }
     *     
     */
    public void setCentreGestion(CentreGestion value) {
        this.centreGestion = value;
    }

    /**
     * Gets the value of the codCge property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodCge() {
        return codCge;
    }

    /**
     * Sets the value of the codCge property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodCge(String value) {
        this.codCge = value;
    }

    /**
     * Gets the value of the codCmp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodCmp() {
        return codCmp;
    }

    /**
     * Sets the value of the codCmp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodCmp(String value) {
        this.codCmp = value;
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
     * Gets the value of the etape property.
     * 
     * @return
     *     possible object is
     *     {@link Etape }
     *     
     */
    public Etape getEtape() {
        return etape;
    }

    /**
     * Sets the value of the etape property.
     * 
     * @param value
     *     allowed object is
     *     {@link Etape }
     *     
     */
    public void setEtape(Etape value) {
        this.etape = value;
    }

    /**
     * Gets the value of the nbrCptAccEtu property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNbrCptAccEtu() {
        return nbrCptAccEtu;
    }

    /**
     * Sets the value of the nbrCptAccEtu property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNbrCptAccEtu(String value) {
        this.nbrCptAccEtu = value;
    }

}
