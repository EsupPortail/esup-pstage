
package org.esupportail.wssi.services.remote;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for centreGestion complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="centreGestion">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codCge" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codComAdrCge" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codCpa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codModPaiMinCge" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codModPaiMinpCge" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codPosAdrCge" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="datDebInsCge" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="datFinInsCge" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="etatypEdtCrtCge" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="libAd1Cge" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="libAd2Cge" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="libAd3Cge" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="libCge" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="libCmtCge" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="libCmtPcjMinCge" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="libNomRespCge" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="licCge" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="modEdtCrt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nbrEtuCpt" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="nbrMaxInsAut" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="numChrQutCge" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="numOccPrmQutVal" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="numOccQutEdt" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="numOccQutEdtLch" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="numOccQutEdtVdr" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="numOccQutVal" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="temCtrlPai" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="temCtrlRmb" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="temEnSveCge" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="temMinCge" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="temPaiMemePos" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "centreGestion", propOrder = {
    "codCge",
    "codComAdrCge",
    "codCpa",
    "codModPaiMinCge",
    "codModPaiMinpCge",
    "codPosAdrCge",
    "datDebInsCge",
    "datFinInsCge",
    "etatypEdtCrtCge",
    "libAd1Cge",
    "libAd2Cge",
    "libAd3Cge",
    "libCge",
    "libCmtCge",
    "libCmtPcjMinCge",
    "libNomRespCge",
    "licCge",
    "modEdtCrt",
    "nbrEtuCpt",
    "nbrMaxInsAut",
    "numChrQutCge",
    "numOccPrmQutVal",
    "numOccQutEdt",
    "numOccQutEdtLch",
    "numOccQutEdtVdr",
    "numOccQutVal",
    "temCtrlPai",
    "temCtrlRmb",
    "temEnSveCge",
    "temMinCge",
    "temPaiMemePos"
})
public class CentreGestion {

    protected String codCge;
    protected String codComAdrCge;
    protected String codCpa;
    protected String codModPaiMinCge;
    protected String codModPaiMinpCge;
    protected String codPosAdrCge;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar datDebInsCge;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar datFinInsCge;
    protected String etatypEdtCrtCge;
    protected String libAd1Cge;
    protected String libAd2Cge;
    protected String libAd3Cge;
    protected String libCge;
    protected String libCmtCge;
    protected String libCmtPcjMinCge;
    protected String libNomRespCge;
    protected String licCge;
    protected String modEdtCrt;
    protected Integer nbrEtuCpt;
    protected Integer nbrMaxInsAut;
    protected Integer numChrQutCge;
    protected Integer numOccPrmQutVal;
    protected Integer numOccQutEdt;
    protected Integer numOccQutEdtLch;
    protected Integer numOccQutEdtVdr;
    protected Integer numOccQutVal;
    protected String temCtrlPai;
    protected String temCtrlRmb;
    protected String temEnSveCge;
    protected String temMinCge;
    protected String temPaiMemePos;

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
     * Gets the value of the codComAdrCge property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodComAdrCge() {
        return codComAdrCge;
    }

    /**
     * Sets the value of the codComAdrCge property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodComAdrCge(String value) {
        this.codComAdrCge = value;
    }

    /**
     * Gets the value of the codCpa property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodCpa() {
        return codCpa;
    }

    /**
     * Sets the value of the codCpa property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodCpa(String value) {
        this.codCpa = value;
    }

    /**
     * Gets the value of the codModPaiMinCge property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodModPaiMinCge() {
        return codModPaiMinCge;
    }

    /**
     * Sets the value of the codModPaiMinCge property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodModPaiMinCge(String value) {
        this.codModPaiMinCge = value;
    }

    /**
     * Gets the value of the codModPaiMinpCge property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodModPaiMinpCge() {
        return codModPaiMinpCge;
    }

    /**
     * Sets the value of the codModPaiMinpCge property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodModPaiMinpCge(String value) {
        this.codModPaiMinpCge = value;
    }

    /**
     * Gets the value of the codPosAdrCge property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodPosAdrCge() {
        return codPosAdrCge;
    }

    /**
     * Sets the value of the codPosAdrCge property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodPosAdrCge(String value) {
        this.codPosAdrCge = value;
    }

    /**
     * Gets the value of the datDebInsCge property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatDebInsCge() {
        return datDebInsCge;
    }

    /**
     * Sets the value of the datDebInsCge property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatDebInsCge(XMLGregorianCalendar value) {
        this.datDebInsCge = value;
    }

    /**
     * Gets the value of the datFinInsCge property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatFinInsCge() {
        return datFinInsCge;
    }

    /**
     * Sets the value of the datFinInsCge property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatFinInsCge(XMLGregorianCalendar value) {
        this.datFinInsCge = value;
    }

    /**
     * Gets the value of the etatypEdtCrtCge property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEtatypEdtCrtCge() {
        return etatypEdtCrtCge;
    }

    /**
     * Sets the value of the etatypEdtCrtCge property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEtatypEdtCrtCge(String value) {
        this.etatypEdtCrtCge = value;
    }

    /**
     * Gets the value of the libAd1Cge property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibAd1Cge() {
        return libAd1Cge;
    }

    /**
     * Sets the value of the libAd1Cge property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibAd1Cge(String value) {
        this.libAd1Cge = value;
    }

    /**
     * Gets the value of the libAd2Cge property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibAd2Cge() {
        return libAd2Cge;
    }

    /**
     * Sets the value of the libAd2Cge property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibAd2Cge(String value) {
        this.libAd2Cge = value;
    }

    /**
     * Gets the value of the libAd3Cge property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibAd3Cge() {
        return libAd3Cge;
    }

    /**
     * Sets the value of the libAd3Cge property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibAd3Cge(String value) {
        this.libAd3Cge = value;
    }

    /**
     * Gets the value of the libCge property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibCge() {
        return libCge;
    }

    /**
     * Sets the value of the libCge property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibCge(String value) {
        this.libCge = value;
    }

    /**
     * Gets the value of the libCmtCge property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibCmtCge() {
        return libCmtCge;
    }

    /**
     * Sets the value of the libCmtCge property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibCmtCge(String value) {
        this.libCmtCge = value;
    }

    /**
     * Gets the value of the libCmtPcjMinCge property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibCmtPcjMinCge() {
        return libCmtPcjMinCge;
    }

    /**
     * Sets the value of the libCmtPcjMinCge property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibCmtPcjMinCge(String value) {
        this.libCmtPcjMinCge = value;
    }

    /**
     * Gets the value of the libNomRespCge property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibNomRespCge() {
        return libNomRespCge;
    }

    /**
     * Sets the value of the libNomRespCge property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibNomRespCge(String value) {
        this.libNomRespCge = value;
    }

    /**
     * Gets the value of the licCge property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLicCge() {
        return licCge;
    }

    /**
     * Sets the value of the licCge property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLicCge(String value) {
        this.licCge = value;
    }

    /**
     * Gets the value of the modEdtCrt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModEdtCrt() {
        return modEdtCrt;
    }

    /**
     * Sets the value of the modEdtCrt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModEdtCrt(String value) {
        this.modEdtCrt = value;
    }

    /**
     * Gets the value of the nbrEtuCpt property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNbrEtuCpt() {
        return nbrEtuCpt;
    }

    /**
     * Sets the value of the nbrEtuCpt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNbrEtuCpt(Integer value) {
        this.nbrEtuCpt = value;
    }

    /**
     * Gets the value of the nbrMaxInsAut property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNbrMaxInsAut() {
        return nbrMaxInsAut;
    }

    /**
     * Sets the value of the nbrMaxInsAut property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNbrMaxInsAut(Integer value) {
        this.nbrMaxInsAut = value;
    }

    /**
     * Gets the value of the numChrQutCge property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumChrQutCge() {
        return numChrQutCge;
    }

    /**
     * Sets the value of the numChrQutCge property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumChrQutCge(Integer value) {
        this.numChrQutCge = value;
    }

    /**
     * Gets the value of the numOccPrmQutVal property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumOccPrmQutVal() {
        return numOccPrmQutVal;
    }

    /**
     * Sets the value of the numOccPrmQutVal property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumOccPrmQutVal(Integer value) {
        this.numOccPrmQutVal = value;
    }

    /**
     * Gets the value of the numOccQutEdt property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumOccQutEdt() {
        return numOccQutEdt;
    }

    /**
     * Sets the value of the numOccQutEdt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumOccQutEdt(Integer value) {
        this.numOccQutEdt = value;
    }

    /**
     * Gets the value of the numOccQutEdtLch property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumOccQutEdtLch() {
        return numOccQutEdtLch;
    }

    /**
     * Sets the value of the numOccQutEdtLch property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumOccQutEdtLch(Integer value) {
        this.numOccQutEdtLch = value;
    }

    /**
     * Gets the value of the numOccQutEdtVdr property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumOccQutEdtVdr() {
        return numOccQutEdtVdr;
    }

    /**
     * Sets the value of the numOccQutEdtVdr property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumOccQutEdtVdr(Integer value) {
        this.numOccQutEdtVdr = value;
    }

    /**
     * Gets the value of the numOccQutVal property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumOccQutVal() {
        return numOccQutVal;
    }

    /**
     * Sets the value of the numOccQutVal property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumOccQutVal(Integer value) {
        this.numOccQutVal = value;
    }

    /**
     * Gets the value of the temCtrlPai property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemCtrlPai() {
        return temCtrlPai;
    }

    /**
     * Sets the value of the temCtrlPai property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemCtrlPai(String value) {
        this.temCtrlPai = value;
    }

    /**
     * Gets the value of the temCtrlRmb property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemCtrlRmb() {
        return temCtrlRmb;
    }

    /**
     * Sets the value of the temCtrlRmb property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemCtrlRmb(String value) {
        this.temCtrlRmb = value;
    }

    /**
     * Gets the value of the temEnSveCge property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemEnSveCge() {
        return temEnSveCge;
    }

    /**
     * Sets the value of the temEnSveCge property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemEnSveCge(String value) {
        this.temEnSveCge = value;
    }

    /**
     * Gets the value of the temMinCge property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemMinCge() {
        return temMinCge;
    }

    /**
     * Sets the value of the temMinCge property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemMinCge(String value) {
        this.temMinCge = value;
    }

    /**
     * Gets the value of the temPaiMemePos property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemPaiMemePos() {
        return temPaiMemePos;
    }

    /**
     * Sets the value of the temPaiMemePos property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemPaiMemePos(String value) {
        this.temPaiMemePos = value;
    }

}
