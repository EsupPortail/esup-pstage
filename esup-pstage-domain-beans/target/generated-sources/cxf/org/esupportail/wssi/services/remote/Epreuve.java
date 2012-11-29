
package org.esupportail.wssi.services.remote;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for epreuve complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="epreuve">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="barMinConEpr" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="barMinRptEpr" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="barSaiEpr" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="codAdmEpr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codCin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codEpr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codNep" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codPan1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codPan2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codPan3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codPan4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codPer" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="codPxa1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codPxa2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codTep" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="datCreEpr" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="datDebIeWeb" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="datFinIeWeb" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="datModEpr" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="durConEpr" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="durExaS1Epr" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="durExaS2Epr" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="eprSanctionneElps" type="{http://remote.services.wssi.esupportail.org/}eprSanctionneElp" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="libCmtEpr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="libDocAutEpr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="libEpr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="libTypExeEpr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="licEpr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="maqCalends" type="{http://remote.services.wssi.esupportail.org/}maqCalend" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="nbrEtuAidEpr" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="nbrEtuHanMotEpr" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="nbrEtuTieTpsEpr" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="notMinConEpr" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="notMinRptEpr" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="temAd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="temAjsEpr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="temAnlRptEpr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="temConEpr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="temCtlValCadEpr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="temDocAutEpr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="temIeObl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="temNotEpr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="temOrgEpr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="temRelPosSyt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="temResEpr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="temSesUni" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "epreuve", propOrder = {
    "barMinConEpr",
    "barMinRptEpr",
    "barSaiEpr",
    "codAdmEpr",
    "codCin",
    "codEpr",
    "codNep",
    "codPan1",
    "codPan2",
    "codPan3",
    "codPan4",
    "codPer",
    "codPxa1",
    "codPxa2",
    "codTep",
    "datCreEpr",
    "datDebIeWeb",
    "datFinIeWeb",
    "datModEpr",
    "durConEpr",
    "durExaS1Epr",
    "durExaS2Epr",
    "eprSanctionneElps",
    "libCmtEpr",
    "libDocAutEpr",
    "libEpr",
    "libTypExeEpr",
    "licEpr",
    "maqCalends",
    "nbrEtuAidEpr",
    "nbrEtuHanMotEpr",
    "nbrEtuTieTpsEpr",
    "notMinConEpr",
    "notMinRptEpr",
    "temAd",
    "temAjsEpr",
    "temAnlRptEpr",
    "temConEpr",
    "temCtlValCadEpr",
    "temDocAutEpr",
    "temIeObl",
    "temNotEpr",
    "temOrgEpr",
    "temRelPosSyt",
    "temResEpr",
    "temSesUni"
})
public class Epreuve {

    protected Integer barMinConEpr;
    protected Integer barMinRptEpr;
    protected Integer barSaiEpr;
    protected String codAdmEpr;
    protected String codCin;
    protected String codEpr;
    protected String codNep;
    protected String codPan1;
    protected String codPan2;
    protected String codPan3;
    protected String codPan4;
    protected Integer codPer;
    protected String codPxa1;
    protected String codPxa2;
    protected String codTep;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar datCreEpr;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar datDebIeWeb;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar datFinIeWeb;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar datModEpr;
    protected Integer durConEpr;
    protected Integer durExaS1Epr;
    protected Integer durExaS2Epr;
    @XmlElement(nillable = true)
    protected List<EprSanctionneElp> eprSanctionneElps;
    protected String libCmtEpr;
    protected String libDocAutEpr;
    protected String libEpr;
    protected String libTypExeEpr;
    protected String licEpr;
    @XmlElement(nillable = true)
    protected List<MaqCalend> maqCalends;
    protected Integer nbrEtuAidEpr;
    protected Integer nbrEtuHanMotEpr;
    protected Integer nbrEtuTieTpsEpr;
    protected Integer notMinConEpr;
    protected Integer notMinRptEpr;
    protected String temAd;
    protected String temAjsEpr;
    protected String temAnlRptEpr;
    protected String temConEpr;
    protected String temCtlValCadEpr;
    protected String temDocAutEpr;
    protected String temIeObl;
    protected String temNotEpr;
    protected String temOrgEpr;
    protected String temRelPosSyt;
    protected String temResEpr;
    protected String temSesUni;

    /**
     * Gets the value of the barMinConEpr property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBarMinConEpr() {
        return barMinConEpr;
    }

    /**
     * Sets the value of the barMinConEpr property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBarMinConEpr(Integer value) {
        this.barMinConEpr = value;
    }

    /**
     * Gets the value of the barMinRptEpr property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBarMinRptEpr() {
        return barMinRptEpr;
    }

    /**
     * Sets the value of the barMinRptEpr property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBarMinRptEpr(Integer value) {
        this.barMinRptEpr = value;
    }

    /**
     * Gets the value of the barSaiEpr property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBarSaiEpr() {
        return barSaiEpr;
    }

    /**
     * Sets the value of the barSaiEpr property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBarSaiEpr(Integer value) {
        this.barSaiEpr = value;
    }

    /**
     * Gets the value of the codAdmEpr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodAdmEpr() {
        return codAdmEpr;
    }

    /**
     * Sets the value of the codAdmEpr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodAdmEpr(String value) {
        this.codAdmEpr = value;
    }

    /**
     * Gets the value of the codCin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodCin() {
        return codCin;
    }

    /**
     * Sets the value of the codCin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodCin(String value) {
        this.codCin = value;
    }

    /**
     * Gets the value of the codEpr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodEpr() {
        return codEpr;
    }

    /**
     * Sets the value of the codEpr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodEpr(String value) {
        this.codEpr = value;
    }

    /**
     * Gets the value of the codNep property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodNep() {
        return codNep;
    }

    /**
     * Sets the value of the codNep property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodNep(String value) {
        this.codNep = value;
    }

    /**
     * Gets the value of the codPan1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodPan1() {
        return codPan1;
    }

    /**
     * Sets the value of the codPan1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodPan1(String value) {
        this.codPan1 = value;
    }

    /**
     * Gets the value of the codPan2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodPan2() {
        return codPan2;
    }

    /**
     * Sets the value of the codPan2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodPan2(String value) {
        this.codPan2 = value;
    }

    /**
     * Gets the value of the codPan3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodPan3() {
        return codPan3;
    }

    /**
     * Sets the value of the codPan3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodPan3(String value) {
        this.codPan3 = value;
    }

    /**
     * Gets the value of the codPan4 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodPan4() {
        return codPan4;
    }

    /**
     * Sets the value of the codPan4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodPan4(String value) {
        this.codPan4 = value;
    }

    /**
     * Gets the value of the codPer property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCodPer() {
        return codPer;
    }

    /**
     * Sets the value of the codPer property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCodPer(Integer value) {
        this.codPer = value;
    }

    /**
     * Gets the value of the codPxa1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodPxa1() {
        return codPxa1;
    }

    /**
     * Sets the value of the codPxa1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodPxa1(String value) {
        this.codPxa1 = value;
    }

    /**
     * Gets the value of the codPxa2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodPxa2() {
        return codPxa2;
    }

    /**
     * Sets the value of the codPxa2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodPxa2(String value) {
        this.codPxa2 = value;
    }

    /**
     * Gets the value of the codTep property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodTep() {
        return codTep;
    }

    /**
     * Sets the value of the codTep property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodTep(String value) {
        this.codTep = value;
    }

    /**
     * Gets the value of the datCreEpr property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatCreEpr() {
        return datCreEpr;
    }

    /**
     * Sets the value of the datCreEpr property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatCreEpr(XMLGregorianCalendar value) {
        this.datCreEpr = value;
    }

    /**
     * Gets the value of the datDebIeWeb property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatDebIeWeb() {
        return datDebIeWeb;
    }

    /**
     * Sets the value of the datDebIeWeb property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatDebIeWeb(XMLGregorianCalendar value) {
        this.datDebIeWeb = value;
    }

    /**
     * Gets the value of the datFinIeWeb property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatFinIeWeb() {
        return datFinIeWeb;
    }

    /**
     * Sets the value of the datFinIeWeb property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatFinIeWeb(XMLGregorianCalendar value) {
        this.datFinIeWeb = value;
    }

    /**
     * Gets the value of the datModEpr property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatModEpr() {
        return datModEpr;
    }

    /**
     * Sets the value of the datModEpr property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatModEpr(XMLGregorianCalendar value) {
        this.datModEpr = value;
    }

    /**
     * Gets the value of the durConEpr property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDurConEpr() {
        return durConEpr;
    }

    /**
     * Sets the value of the durConEpr property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDurConEpr(Integer value) {
        this.durConEpr = value;
    }

    /**
     * Gets the value of the durExaS1Epr property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDurExaS1Epr() {
        return durExaS1Epr;
    }

    /**
     * Sets the value of the durExaS1Epr property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDurExaS1Epr(Integer value) {
        this.durExaS1Epr = value;
    }

    /**
     * Gets the value of the durExaS2Epr property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDurExaS2Epr() {
        return durExaS2Epr;
    }

    /**
     * Sets the value of the durExaS2Epr property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDurExaS2Epr(Integer value) {
        this.durExaS2Epr = value;
    }

    /**
     * Gets the value of the eprSanctionneElps property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the eprSanctionneElps property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEprSanctionneElps().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EprSanctionneElp }
     * 
     * 
     */
    public List<EprSanctionneElp> getEprSanctionneElps() {
        if (eprSanctionneElps == null) {
            eprSanctionneElps = new ArrayList<EprSanctionneElp>();
        }
        return this.eprSanctionneElps;
    }

    /**
     * Gets the value of the libCmtEpr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibCmtEpr() {
        return libCmtEpr;
    }

    /**
     * Sets the value of the libCmtEpr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibCmtEpr(String value) {
        this.libCmtEpr = value;
    }

    /**
     * Gets the value of the libDocAutEpr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibDocAutEpr() {
        return libDocAutEpr;
    }

    /**
     * Sets the value of the libDocAutEpr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibDocAutEpr(String value) {
        this.libDocAutEpr = value;
    }

    /**
     * Gets the value of the libEpr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibEpr() {
        return libEpr;
    }

    /**
     * Sets the value of the libEpr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibEpr(String value) {
        this.libEpr = value;
    }

    /**
     * Gets the value of the libTypExeEpr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibTypExeEpr() {
        return libTypExeEpr;
    }

    /**
     * Sets the value of the libTypExeEpr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibTypExeEpr(String value) {
        this.libTypExeEpr = value;
    }

    /**
     * Gets the value of the licEpr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLicEpr() {
        return licEpr;
    }

    /**
     * Sets the value of the licEpr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLicEpr(String value) {
        this.licEpr = value;
    }

    /**
     * Gets the value of the maqCalends property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the maqCalends property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMaqCalends().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MaqCalend }
     * 
     * 
     */
    public List<MaqCalend> getMaqCalends() {
        if (maqCalends == null) {
            maqCalends = new ArrayList<MaqCalend>();
        }
        return this.maqCalends;
    }

    /**
     * Gets the value of the nbrEtuAidEpr property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNbrEtuAidEpr() {
        return nbrEtuAidEpr;
    }

    /**
     * Sets the value of the nbrEtuAidEpr property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNbrEtuAidEpr(Integer value) {
        this.nbrEtuAidEpr = value;
    }

    /**
     * Gets the value of the nbrEtuHanMotEpr property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNbrEtuHanMotEpr() {
        return nbrEtuHanMotEpr;
    }

    /**
     * Sets the value of the nbrEtuHanMotEpr property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNbrEtuHanMotEpr(Integer value) {
        this.nbrEtuHanMotEpr = value;
    }

    /**
     * Gets the value of the nbrEtuTieTpsEpr property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNbrEtuTieTpsEpr() {
        return nbrEtuTieTpsEpr;
    }

    /**
     * Sets the value of the nbrEtuTieTpsEpr property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNbrEtuTieTpsEpr(Integer value) {
        this.nbrEtuTieTpsEpr = value;
    }

    /**
     * Gets the value of the notMinConEpr property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNotMinConEpr() {
        return notMinConEpr;
    }

    /**
     * Sets the value of the notMinConEpr property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNotMinConEpr(Integer value) {
        this.notMinConEpr = value;
    }

    /**
     * Gets the value of the notMinRptEpr property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNotMinRptEpr() {
        return notMinRptEpr;
    }

    /**
     * Sets the value of the notMinRptEpr property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNotMinRptEpr(Integer value) {
        this.notMinRptEpr = value;
    }

    /**
     * Gets the value of the temAd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemAd() {
        return temAd;
    }

    /**
     * Sets the value of the temAd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemAd(String value) {
        this.temAd = value;
    }

    /**
     * Gets the value of the temAjsEpr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemAjsEpr() {
        return temAjsEpr;
    }

    /**
     * Sets the value of the temAjsEpr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemAjsEpr(String value) {
        this.temAjsEpr = value;
    }

    /**
     * Gets the value of the temAnlRptEpr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemAnlRptEpr() {
        return temAnlRptEpr;
    }

    /**
     * Sets the value of the temAnlRptEpr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemAnlRptEpr(String value) {
        this.temAnlRptEpr = value;
    }

    /**
     * Gets the value of the temConEpr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemConEpr() {
        return temConEpr;
    }

    /**
     * Sets the value of the temConEpr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemConEpr(String value) {
        this.temConEpr = value;
    }

    /**
     * Gets the value of the temCtlValCadEpr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemCtlValCadEpr() {
        return temCtlValCadEpr;
    }

    /**
     * Sets the value of the temCtlValCadEpr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemCtlValCadEpr(String value) {
        this.temCtlValCadEpr = value;
    }

    /**
     * Gets the value of the temDocAutEpr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemDocAutEpr() {
        return temDocAutEpr;
    }

    /**
     * Sets the value of the temDocAutEpr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemDocAutEpr(String value) {
        this.temDocAutEpr = value;
    }

    /**
     * Gets the value of the temIeObl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemIeObl() {
        return temIeObl;
    }

    /**
     * Sets the value of the temIeObl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemIeObl(String value) {
        this.temIeObl = value;
    }

    /**
     * Gets the value of the temNotEpr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemNotEpr() {
        return temNotEpr;
    }

    /**
     * Sets the value of the temNotEpr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemNotEpr(String value) {
        this.temNotEpr = value;
    }

    /**
     * Gets the value of the temOrgEpr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemOrgEpr() {
        return temOrgEpr;
    }

    /**
     * Sets the value of the temOrgEpr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemOrgEpr(String value) {
        this.temOrgEpr = value;
    }

    /**
     * Gets the value of the temRelPosSyt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemRelPosSyt() {
        return temRelPosSyt;
    }

    /**
     * Sets the value of the temRelPosSyt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemRelPosSyt(String value) {
        this.temRelPosSyt = value;
    }

    /**
     * Gets the value of the temResEpr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemResEpr() {
        return temResEpr;
    }

    /**
     * Sets the value of the temResEpr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemResEpr(String value) {
        this.temResEpr = value;
    }

    /**
     * Gets the value of the temSesUni property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemSesUni() {
        return temSesUni;
    }

    /**
     * Sets the value of the temSesUni property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemSesUni(String value) {
        this.temSesUni = value;
    }

}
