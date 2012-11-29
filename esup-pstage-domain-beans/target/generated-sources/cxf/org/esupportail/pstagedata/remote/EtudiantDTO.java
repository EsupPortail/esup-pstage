
package org.esupportail.pstagedata.remote;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for etudiantDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="etudiantDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://remote.pstagedata.esupportail.org/}personneDTO">
 *       &lt;sequence>
 *         &lt;element name="codeSexe" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dateNais" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="identEtudiant" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nomMarital" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numEtudiant" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numSS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "etudiantDTO", propOrder = {
    "codeSexe",
    "dateNais",
    "identEtudiant",
    "nomMarital",
    "numEtudiant",
    "numSS"
})
public class EtudiantDTO
    extends PersonneDTO
{

    protected String codeSexe;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateNais;
    protected String identEtudiant;
    protected String nomMarital;
    protected String numEtudiant;
    protected String numSS;

    /**
     * Gets the value of the codeSexe property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeSexe() {
        return codeSexe;
    }

    /**
     * Sets the value of the codeSexe property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeSexe(String value) {
        this.codeSexe = value;
    }

    /**
     * Gets the value of the dateNais property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateNais() {
        return dateNais;
    }

    /**
     * Sets the value of the dateNais property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateNais(XMLGregorianCalendar value) {
        this.dateNais = value;
    }

    /**
     * Gets the value of the identEtudiant property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentEtudiant() {
        return identEtudiant;
    }

    /**
     * Sets the value of the identEtudiant property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentEtudiant(String value) {
        this.identEtudiant = value;
    }

    /**
     * Gets the value of the nomMarital property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomMarital() {
        return nomMarital;
    }

    /**
     * Sets the value of the nomMarital property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomMarital(String value) {
        this.nomMarital = value;
    }

    /**
     * Gets the value of the numEtudiant property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumEtudiant() {
        return numEtudiant;
    }

    /**
     * Sets the value of the numEtudiant property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumEtudiant(String value) {
        this.numEtudiant = value;
    }

    /**
     * Gets the value of the numSS property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumSS() {
        return numSS;
    }

    /**
     * Sets the value of the numSS property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumSS(String value) {
        this.numSS = value;
    }

}
