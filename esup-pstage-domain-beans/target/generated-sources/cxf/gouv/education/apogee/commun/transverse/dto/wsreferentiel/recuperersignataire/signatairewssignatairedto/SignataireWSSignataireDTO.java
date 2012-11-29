
package gouv.education.apogee.commun.transverse.dto.wsreferentiel.recuperersignataire.signatairewssignatairedto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SignataireWSSignataireDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SignataireWSSignataireDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codSig" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nomSig" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="quaSig" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="temEnSveSig" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SignataireWSSignataireDTO", propOrder = {
    "codSig",
    "nomSig",
    "quaSig",
    "temEnSveSig"
})
public class SignataireWSSignataireDTO {

    @XmlElement(required = true, nillable = true)
    protected String codSig;
    @XmlElement(required = true, nillable = true)
    protected String nomSig;
    @XmlElement(required = true, nillable = true)
    protected String quaSig;
    @XmlElement(required = true, nillable = true)
    protected String temEnSveSig;

    /**
     * Gets the value of the codSig property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodSig() {
        return codSig;
    }

    /**
     * Sets the value of the codSig property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodSig(String value) {
        this.codSig = value;
    }

    /**
     * Gets the value of the nomSig property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomSig() {
        return nomSig;
    }

    /**
     * Sets the value of the nomSig property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomSig(String value) {
        this.nomSig = value;
    }

    /**
     * Gets the value of the quaSig property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQuaSig() {
        return quaSig;
    }

    /**
     * Sets the value of the quaSig property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQuaSig(String value) {
        this.quaSig = value;
    }

    /**
     * Gets the value of the temEnSveSig property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemEnSveSig() {
        return temEnSveSig;
    }

    /**
     * Sets the value of the temEnSveSig property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemEnSveSig(String value) {
        this.temEnSveSig = value;
    }

}
