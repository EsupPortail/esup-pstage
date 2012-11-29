
package org.esupportail.pstagedata.remote;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for enseignantDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="enseignantDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://remote.pstagedata.esupportail.org/}personneDTO">
 *       &lt;sequence>
 *         &lt;element name="affectation" type="{http://remote.pstagedata.esupportail.org/}affectationDTO" minOccurs="0"/>
 *         &lt;element name="batiment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bureau" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="campus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codeAffectation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codeUniversiteAffectation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="uidEnseignant" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "enseignantDTO", propOrder = {
    "affectation",
    "batiment",
    "bureau",
    "campus",
    "codeAffectation",
    "codeUniversiteAffectation",
    "uidEnseignant"
})
public class EnseignantDTO
    extends PersonneDTO
{

    protected AffectationDTO affectation;
    protected String batiment;
    protected String bureau;
    protected String campus;
    protected String codeAffectation;
    protected String codeUniversiteAffectation;
    protected String uidEnseignant;

    /**
     * Gets the value of the affectation property.
     * 
     * @return
     *     possible object is
     *     {@link AffectationDTO }
     *     
     */
    public AffectationDTO getAffectation() {
        return affectation;
    }

    /**
     * Sets the value of the affectation property.
     * 
     * @param value
     *     allowed object is
     *     {@link AffectationDTO }
     *     
     */
    public void setAffectation(AffectationDTO value) {
        this.affectation = value;
    }

    /**
     * Gets the value of the batiment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBatiment() {
        return batiment;
    }

    /**
     * Sets the value of the batiment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBatiment(String value) {
        this.batiment = value;
    }

    /**
     * Gets the value of the bureau property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBureau() {
        return bureau;
    }

    /**
     * Sets the value of the bureau property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBureau(String value) {
        this.bureau = value;
    }

    /**
     * Gets the value of the campus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCampus() {
        return campus;
    }

    /**
     * Sets the value of the campus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCampus(String value) {
        this.campus = value;
    }

    /**
     * Gets the value of the codeAffectation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeAffectation() {
        return codeAffectation;
    }

    /**
     * Sets the value of the codeAffectation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeAffectation(String value) {
        this.codeAffectation = value;
    }

    /**
     * Gets the value of the codeUniversiteAffectation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeUniversiteAffectation() {
        return codeUniversiteAffectation;
    }

    /**
     * Sets the value of the codeUniversiteAffectation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeUniversiteAffectation(String value) {
        this.codeUniversiteAffectation = value;
    }

    /**
     * Gets the value of the uidEnseignant property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUidEnseignant() {
        return uidEnseignant;
    }

    /**
     * Sets the value of the uidEnseignant property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUidEnseignant(String value) {
        this.uidEnseignant = value;
    }

}
