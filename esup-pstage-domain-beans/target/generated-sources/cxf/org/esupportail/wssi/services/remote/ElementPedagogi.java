
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
 * <p>Java class for elementPedagogi complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="elementPedagogi">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="barMinConElp" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="barMinRptElp" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="barSaiElp" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="capIntElp" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="capMaxElp" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="codVolElp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codeELP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="datCreElp" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="datDebOpeIpe" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="datFinOpeIpe" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="datModElp" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="durConElp" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="eprSanctionneElp" type="{http://remote.services.wssi.esupportail.org/}eprSanctionneElp" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="etaElp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="libCmtElp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="libElp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="libLieElp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="libNomRspElp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="libSusElp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="licElp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nbrCrdElp" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="nbrEffPrvElp" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="nbrHeuCmElp" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="nbrHeuTPElp" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="nbrHeuTdElp" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="nbrVolElp" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="nbradmElp" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="nbradmEtr" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="nbradmFra" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="notMaxAdmDen" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="notMaxAdmNum" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="notMinAdmDen" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="notMinAdmNum" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="notMinConElp" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="notMinRptElp" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="notMinRptElpDen" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="notMinRptElpNum" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="notObtElpDen" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="notObtElpNum" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="numPreElp" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="temADisElp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="temAdi" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="temAdo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="temAjsElp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="temAnlRptElp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="temCapElp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="temConElp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="temCtlValCadElp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="temElpCap" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="temElpPrmNiv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="temHeuEnsElp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="temJurElp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="temMccElp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="temMeiNotElp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="temMndUni" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="temNotElp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="temPntJurElp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="temReiIpeAcq" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="temRelPosSyt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="temResElp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="temRptDscElp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="temScaElp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="temSesUni" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="temSusElp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "elementPedagogi", propOrder = {
    "barMinConElp",
    "barMinRptElp",
    "barSaiElp",
    "capIntElp",
    "capMaxElp",
    "codVolElp",
    "codeELP",
    "datCreElp",
    "datDebOpeIpe",
    "datFinOpeIpe",
    "datModElp",
    "durConElp",
    "eprSanctionneElp",
    "etaElp",
    "libCmtElp",
    "libElp",
    "libLieElp",
    "libNomRspElp",
    "libSusElp",
    "licElp",
    "nbrCrdElp",
    "nbrEffPrvElp",
    "nbrHeuCmElp",
    "nbrHeuTPElp",
    "nbrHeuTdElp",
    "nbrVolElp",
    "nbradmElp",
    "nbradmEtr",
    "nbradmFra",
    "notMaxAdmDen",
    "notMaxAdmNum",
    "notMinAdmDen",
    "notMinAdmNum",
    "notMinConElp",
    "notMinRptElp",
    "notMinRptElpDen",
    "notMinRptElpNum",
    "notObtElpDen",
    "notObtElpNum",
    "numPreElp",
    "temADisElp",
    "temAdi",
    "temAdo",
    "temAjsElp",
    "temAnlRptElp",
    "temCapElp",
    "temConElp",
    "temCtlValCadElp",
    "temElpCap",
    "temElpPrmNiv",
    "temHeuEnsElp",
    "temJurElp",
    "temMccElp",
    "temMeiNotElp",
    "temMndUni",
    "temNotElp",
    "temPntJurElp",
    "temReiIpeAcq",
    "temRelPosSyt",
    "temResElp",
    "temRptDscElp",
    "temScaElp",
    "temSesUni",
    "temSusElp"
})
public class ElementPedagogi {

    protected Integer barMinConElp;
    protected Integer barMinRptElp;
    protected Integer barSaiElp;
    protected Integer capIntElp;
    protected Integer capMaxElp;
    protected String codVolElp;
    protected String codeELP;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar datCreElp;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar datDebOpeIpe;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar datFinOpeIpe;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar datModElp;
    protected Integer durConElp;
    @XmlElement(nillable = true)
    protected List<EprSanctionneElp> eprSanctionneElp;
    protected String etaElp;
    protected String libCmtElp;
    protected String libElp;
    protected String libLieElp;
    protected String libNomRspElp;
    protected String libSusElp;
    protected String licElp;
    protected Integer nbrCrdElp;
    protected Integer nbrEffPrvElp;
    protected Integer nbrHeuCmElp;
    protected Integer nbrHeuTPElp;
    protected Integer nbrHeuTdElp;
    protected Integer nbrVolElp;
    protected Integer nbradmElp;
    protected Integer nbradmEtr;
    protected Integer nbradmFra;
    protected Integer notMaxAdmDen;
    protected Integer notMaxAdmNum;
    protected Integer notMinAdmDen;
    protected Integer notMinAdmNum;
    protected Integer notMinConElp;
    protected Integer notMinRptElp;
    protected Integer notMinRptElpDen;
    protected Integer notMinRptElpNum;
    protected Integer notObtElpDen;
    protected Integer notObtElpNum;
    protected Integer numPreElp;
    protected String temADisElp;
    protected String temAdi;
    protected String temAdo;
    protected String temAjsElp;
    protected String temAnlRptElp;
    protected String temCapElp;
    protected String temConElp;
    protected String temCtlValCadElp;
    protected String temElpCap;
    protected String temElpPrmNiv;
    protected String temHeuEnsElp;
    protected String temJurElp;
    protected String temMccElp;
    protected String temMeiNotElp;
    protected String temMndUni;
    protected String temNotElp;
    protected String temPntJurElp;
    protected String temReiIpeAcq;
    protected String temRelPosSyt;
    protected String temResElp;
    protected String temRptDscElp;
    protected String temScaElp;
    protected String temSesUni;
    protected String temSusElp;

    /**
     * Gets the value of the barMinConElp property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBarMinConElp() {
        return barMinConElp;
    }

    /**
     * Sets the value of the barMinConElp property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBarMinConElp(Integer value) {
        this.barMinConElp = value;
    }

    /**
     * Gets the value of the barMinRptElp property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBarMinRptElp() {
        return barMinRptElp;
    }

    /**
     * Sets the value of the barMinRptElp property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBarMinRptElp(Integer value) {
        this.barMinRptElp = value;
    }

    /**
     * Gets the value of the barSaiElp property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBarSaiElp() {
        return barSaiElp;
    }

    /**
     * Sets the value of the barSaiElp property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBarSaiElp(Integer value) {
        this.barSaiElp = value;
    }

    /**
     * Gets the value of the capIntElp property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCapIntElp() {
        return capIntElp;
    }

    /**
     * Sets the value of the capIntElp property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCapIntElp(Integer value) {
        this.capIntElp = value;
    }

    /**
     * Gets the value of the capMaxElp property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCapMaxElp() {
        return capMaxElp;
    }

    /**
     * Sets the value of the capMaxElp property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCapMaxElp(Integer value) {
        this.capMaxElp = value;
    }

    /**
     * Gets the value of the codVolElp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodVolElp() {
        return codVolElp;
    }

    /**
     * Sets the value of the codVolElp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodVolElp(String value) {
        this.codVolElp = value;
    }

    /**
     * Gets the value of the codeELP property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeELP() {
        return codeELP;
    }

    /**
     * Sets the value of the codeELP property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeELP(String value) {
        this.codeELP = value;
    }

    /**
     * Gets the value of the datCreElp property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatCreElp() {
        return datCreElp;
    }

    /**
     * Sets the value of the datCreElp property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatCreElp(XMLGregorianCalendar value) {
        this.datCreElp = value;
    }

    /**
     * Gets the value of the datDebOpeIpe property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatDebOpeIpe() {
        return datDebOpeIpe;
    }

    /**
     * Sets the value of the datDebOpeIpe property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatDebOpeIpe(XMLGregorianCalendar value) {
        this.datDebOpeIpe = value;
    }

    /**
     * Gets the value of the datFinOpeIpe property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatFinOpeIpe() {
        return datFinOpeIpe;
    }

    /**
     * Sets the value of the datFinOpeIpe property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatFinOpeIpe(XMLGregorianCalendar value) {
        this.datFinOpeIpe = value;
    }

    /**
     * Gets the value of the datModElp property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatModElp() {
        return datModElp;
    }

    /**
     * Sets the value of the datModElp property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatModElp(XMLGregorianCalendar value) {
        this.datModElp = value;
    }

    /**
     * Gets the value of the durConElp property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDurConElp() {
        return durConElp;
    }

    /**
     * Sets the value of the durConElp property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDurConElp(Integer value) {
        this.durConElp = value;
    }

    /**
     * Gets the value of the eprSanctionneElp property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the eprSanctionneElp property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEprSanctionneElp().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EprSanctionneElp }
     * 
     * 
     */
    public List<EprSanctionneElp> getEprSanctionneElp() {
        if (eprSanctionneElp == null) {
            eprSanctionneElp = new ArrayList<EprSanctionneElp>();
        }
        return this.eprSanctionneElp;
    }

    /**
     * Gets the value of the etaElp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEtaElp() {
        return etaElp;
    }

    /**
     * Sets the value of the etaElp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEtaElp(String value) {
        this.etaElp = value;
    }

    /**
     * Gets the value of the libCmtElp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibCmtElp() {
        return libCmtElp;
    }

    /**
     * Sets the value of the libCmtElp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibCmtElp(String value) {
        this.libCmtElp = value;
    }

    /**
     * Gets the value of the libElp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibElp() {
        return libElp;
    }

    /**
     * Sets the value of the libElp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibElp(String value) {
        this.libElp = value;
    }

    /**
     * Gets the value of the libLieElp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibLieElp() {
        return libLieElp;
    }

    /**
     * Sets the value of the libLieElp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibLieElp(String value) {
        this.libLieElp = value;
    }

    /**
     * Gets the value of the libNomRspElp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibNomRspElp() {
        return libNomRspElp;
    }

    /**
     * Sets the value of the libNomRspElp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibNomRspElp(String value) {
        this.libNomRspElp = value;
    }

    /**
     * Gets the value of the libSusElp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibSusElp() {
        return libSusElp;
    }

    /**
     * Sets the value of the libSusElp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibSusElp(String value) {
        this.libSusElp = value;
    }

    /**
     * Gets the value of the licElp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLicElp() {
        return licElp;
    }

    /**
     * Sets the value of the licElp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLicElp(String value) {
        this.licElp = value;
    }

    /**
     * Gets the value of the nbrCrdElp property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNbrCrdElp() {
        return nbrCrdElp;
    }

    /**
     * Sets the value of the nbrCrdElp property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNbrCrdElp(Integer value) {
        this.nbrCrdElp = value;
    }

    /**
     * Gets the value of the nbrEffPrvElp property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNbrEffPrvElp() {
        return nbrEffPrvElp;
    }

    /**
     * Sets the value of the nbrEffPrvElp property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNbrEffPrvElp(Integer value) {
        this.nbrEffPrvElp = value;
    }

    /**
     * Gets the value of the nbrHeuCmElp property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNbrHeuCmElp() {
        return nbrHeuCmElp;
    }

    /**
     * Sets the value of the nbrHeuCmElp property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNbrHeuCmElp(Integer value) {
        this.nbrHeuCmElp = value;
    }

    /**
     * Gets the value of the nbrHeuTPElp property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNbrHeuTPElp() {
        return nbrHeuTPElp;
    }

    /**
     * Sets the value of the nbrHeuTPElp property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNbrHeuTPElp(Integer value) {
        this.nbrHeuTPElp = value;
    }

    /**
     * Gets the value of the nbrHeuTdElp property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNbrHeuTdElp() {
        return nbrHeuTdElp;
    }

    /**
     * Sets the value of the nbrHeuTdElp property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNbrHeuTdElp(Integer value) {
        this.nbrHeuTdElp = value;
    }

    /**
     * Gets the value of the nbrVolElp property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNbrVolElp() {
        return nbrVolElp;
    }

    /**
     * Sets the value of the nbrVolElp property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNbrVolElp(Integer value) {
        this.nbrVolElp = value;
    }

    /**
     * Gets the value of the nbradmElp property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNbradmElp() {
        return nbradmElp;
    }

    /**
     * Sets the value of the nbradmElp property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNbradmElp(Integer value) {
        this.nbradmElp = value;
    }

    /**
     * Gets the value of the nbradmEtr property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNbradmEtr() {
        return nbradmEtr;
    }

    /**
     * Sets the value of the nbradmEtr property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNbradmEtr(Integer value) {
        this.nbradmEtr = value;
    }

    /**
     * Gets the value of the nbradmFra property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNbradmFra() {
        return nbradmFra;
    }

    /**
     * Sets the value of the nbradmFra property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNbradmFra(Integer value) {
        this.nbradmFra = value;
    }

    /**
     * Gets the value of the notMaxAdmDen property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNotMaxAdmDen() {
        return notMaxAdmDen;
    }

    /**
     * Sets the value of the notMaxAdmDen property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNotMaxAdmDen(Integer value) {
        this.notMaxAdmDen = value;
    }

    /**
     * Gets the value of the notMaxAdmNum property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNotMaxAdmNum() {
        return notMaxAdmNum;
    }

    /**
     * Sets the value of the notMaxAdmNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNotMaxAdmNum(Integer value) {
        this.notMaxAdmNum = value;
    }

    /**
     * Gets the value of the notMinAdmDen property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNotMinAdmDen() {
        return notMinAdmDen;
    }

    /**
     * Sets the value of the notMinAdmDen property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNotMinAdmDen(Integer value) {
        this.notMinAdmDen = value;
    }

    /**
     * Gets the value of the notMinAdmNum property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNotMinAdmNum() {
        return notMinAdmNum;
    }

    /**
     * Sets the value of the notMinAdmNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNotMinAdmNum(Integer value) {
        this.notMinAdmNum = value;
    }

    /**
     * Gets the value of the notMinConElp property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNotMinConElp() {
        return notMinConElp;
    }

    /**
     * Sets the value of the notMinConElp property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNotMinConElp(Integer value) {
        this.notMinConElp = value;
    }

    /**
     * Gets the value of the notMinRptElp property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNotMinRptElp() {
        return notMinRptElp;
    }

    /**
     * Sets the value of the notMinRptElp property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNotMinRptElp(Integer value) {
        this.notMinRptElp = value;
    }

    /**
     * Gets the value of the notMinRptElpDen property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNotMinRptElpDen() {
        return notMinRptElpDen;
    }

    /**
     * Sets the value of the notMinRptElpDen property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNotMinRptElpDen(Integer value) {
        this.notMinRptElpDen = value;
    }

    /**
     * Gets the value of the notMinRptElpNum property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNotMinRptElpNum() {
        return notMinRptElpNum;
    }

    /**
     * Sets the value of the notMinRptElpNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNotMinRptElpNum(Integer value) {
        this.notMinRptElpNum = value;
    }

    /**
     * Gets the value of the notObtElpDen property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNotObtElpDen() {
        return notObtElpDen;
    }

    /**
     * Sets the value of the notObtElpDen property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNotObtElpDen(Integer value) {
        this.notObtElpDen = value;
    }

    /**
     * Gets the value of the notObtElpNum property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNotObtElpNum() {
        return notObtElpNum;
    }

    /**
     * Sets the value of the notObtElpNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNotObtElpNum(Integer value) {
        this.notObtElpNum = value;
    }

    /**
     * Gets the value of the numPreElp property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumPreElp() {
        return numPreElp;
    }

    /**
     * Sets the value of the numPreElp property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumPreElp(Integer value) {
        this.numPreElp = value;
    }

    /**
     * Gets the value of the temADisElp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemADisElp() {
        return temADisElp;
    }

    /**
     * Sets the value of the temADisElp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemADisElp(String value) {
        this.temADisElp = value;
    }

    /**
     * Gets the value of the temAdi property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemAdi() {
        return temAdi;
    }

    /**
     * Sets the value of the temAdi property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemAdi(String value) {
        this.temAdi = value;
    }

    /**
     * Gets the value of the temAdo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemAdo() {
        return temAdo;
    }

    /**
     * Sets the value of the temAdo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemAdo(String value) {
        this.temAdo = value;
    }

    /**
     * Gets the value of the temAjsElp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemAjsElp() {
        return temAjsElp;
    }

    /**
     * Sets the value of the temAjsElp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemAjsElp(String value) {
        this.temAjsElp = value;
    }

    /**
     * Gets the value of the temAnlRptElp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemAnlRptElp() {
        return temAnlRptElp;
    }

    /**
     * Sets the value of the temAnlRptElp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemAnlRptElp(String value) {
        this.temAnlRptElp = value;
    }

    /**
     * Gets the value of the temCapElp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemCapElp() {
        return temCapElp;
    }

    /**
     * Sets the value of the temCapElp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemCapElp(String value) {
        this.temCapElp = value;
    }

    /**
     * Gets the value of the temConElp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemConElp() {
        return temConElp;
    }

    /**
     * Sets the value of the temConElp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemConElp(String value) {
        this.temConElp = value;
    }

    /**
     * Gets the value of the temCtlValCadElp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemCtlValCadElp() {
        return temCtlValCadElp;
    }

    /**
     * Sets the value of the temCtlValCadElp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemCtlValCadElp(String value) {
        this.temCtlValCadElp = value;
    }

    /**
     * Gets the value of the temElpCap property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemElpCap() {
        return temElpCap;
    }

    /**
     * Sets the value of the temElpCap property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemElpCap(String value) {
        this.temElpCap = value;
    }

    /**
     * Gets the value of the temElpPrmNiv property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemElpPrmNiv() {
        return temElpPrmNiv;
    }

    /**
     * Sets the value of the temElpPrmNiv property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemElpPrmNiv(String value) {
        this.temElpPrmNiv = value;
    }

    /**
     * Gets the value of the temHeuEnsElp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemHeuEnsElp() {
        return temHeuEnsElp;
    }

    /**
     * Sets the value of the temHeuEnsElp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemHeuEnsElp(String value) {
        this.temHeuEnsElp = value;
    }

    /**
     * Gets the value of the temJurElp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemJurElp() {
        return temJurElp;
    }

    /**
     * Sets the value of the temJurElp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemJurElp(String value) {
        this.temJurElp = value;
    }

    /**
     * Gets the value of the temMccElp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemMccElp() {
        return temMccElp;
    }

    /**
     * Sets the value of the temMccElp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemMccElp(String value) {
        this.temMccElp = value;
    }

    /**
     * Gets the value of the temMeiNotElp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemMeiNotElp() {
        return temMeiNotElp;
    }

    /**
     * Sets the value of the temMeiNotElp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemMeiNotElp(String value) {
        this.temMeiNotElp = value;
    }

    /**
     * Gets the value of the temMndUni property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemMndUni() {
        return temMndUni;
    }

    /**
     * Sets the value of the temMndUni property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemMndUni(String value) {
        this.temMndUni = value;
    }

    /**
     * Gets the value of the temNotElp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemNotElp() {
        return temNotElp;
    }

    /**
     * Sets the value of the temNotElp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemNotElp(String value) {
        this.temNotElp = value;
    }

    /**
     * Gets the value of the temPntJurElp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemPntJurElp() {
        return temPntJurElp;
    }

    /**
     * Sets the value of the temPntJurElp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemPntJurElp(String value) {
        this.temPntJurElp = value;
    }

    /**
     * Gets the value of the temReiIpeAcq property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemReiIpeAcq() {
        return temReiIpeAcq;
    }

    /**
     * Sets the value of the temReiIpeAcq property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemReiIpeAcq(String value) {
        this.temReiIpeAcq = value;
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
     * Gets the value of the temResElp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemResElp() {
        return temResElp;
    }

    /**
     * Sets the value of the temResElp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemResElp(String value) {
        this.temResElp = value;
    }

    /**
     * Gets the value of the temRptDscElp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemRptDscElp() {
        return temRptDscElp;
    }

    /**
     * Sets the value of the temRptDscElp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemRptDscElp(String value) {
        this.temRptDscElp = value;
    }

    /**
     * Gets the value of the temScaElp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemScaElp() {
        return temScaElp;
    }

    /**
     * Sets the value of the temScaElp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemScaElp(String value) {
        this.temScaElp = value;
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

    /**
     * Gets the value of the temSusElp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemSusElp() {
        return temSusElp;
    }

    /**
     * Sets the value of the temSusElp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemSusElp(String value) {
        this.temSusElp = value;
    }

}
