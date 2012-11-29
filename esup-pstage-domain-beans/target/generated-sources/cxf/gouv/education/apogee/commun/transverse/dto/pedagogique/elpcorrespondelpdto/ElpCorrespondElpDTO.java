
package gouv.education.apogee.commun.transverse.dto.pedagogique.elpcorrespondelpdto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gouv.education.apogee.commun.transverse.dto.pedagogique.elpsourcedto.ElpSourceDTO;
import gouv.education.apogee.commun.transverse.dto.pedagogique.typresultatdto.TypResultatDTO;


/**
 * <p>Java class for ElpCorrespondElpDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ElpCorrespondElpDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="elpS1" type="{ElpSourceDTO.pedagogique.dto.transverse.commun.apogee.education.gouv}ElpSourceDTO"/>
 *         &lt;element name="elpS2" type="{ElpSourceDTO.pedagogique.dto.transverse.commun.apogee.education.gouv}ElpSourceDTO"/>
 *         &lt;element name="notElpS1Lcc" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="notElpS2Lcc" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="typeResS1" type="{TypResultatDTO.pedagogique.dto.transverse.commun.apogee.education.gouv}TypResultatDTO"/>
 *         &lt;element name="typeResS2" type="{TypResultatDTO.pedagogique.dto.transverse.commun.apogee.education.gouv}TypResultatDTO"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ElpCorrespondElpDTO", propOrder = {
    "elpS1",
    "elpS2",
    "notElpS1Lcc",
    "notElpS2Lcc",
    "typeResS1",
    "typeResS2"
})
public class ElpCorrespondElpDTO {

    @XmlElement(required = true, nillable = true)
    protected ElpSourceDTO elpS1;
    @XmlElement(required = true, nillable = true)
    protected ElpSourceDTO elpS2;
    @XmlElement(required = true, nillable = true)
    protected String notElpS1Lcc;
    @XmlElement(required = true, nillable = true)
    protected String notElpS2Lcc;
    @XmlElement(required = true, nillable = true)
    protected TypResultatDTO typeResS1;
    @XmlElement(required = true, nillable = true)
    protected TypResultatDTO typeResS2;

    /**
     * Gets the value of the elpS1 property.
     * 
     * @return
     *     possible object is
     *     {@link ElpSourceDTO }
     *     
     */
    public ElpSourceDTO getElpS1() {
        return elpS1;
    }

    /**
     * Sets the value of the elpS1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link ElpSourceDTO }
     *     
     */
    public void setElpS1(ElpSourceDTO value) {
        this.elpS1 = value;
    }

    /**
     * Gets the value of the elpS2 property.
     * 
     * @return
     *     possible object is
     *     {@link ElpSourceDTO }
     *     
     */
    public ElpSourceDTO getElpS2() {
        return elpS2;
    }

    /**
     * Sets the value of the elpS2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link ElpSourceDTO }
     *     
     */
    public void setElpS2(ElpSourceDTO value) {
        this.elpS2 = value;
    }

    /**
     * Gets the value of the notElpS1Lcc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNotElpS1Lcc() {
        return notElpS1Lcc;
    }

    /**
     * Sets the value of the notElpS1Lcc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNotElpS1Lcc(String value) {
        this.notElpS1Lcc = value;
    }

    /**
     * Gets the value of the notElpS2Lcc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNotElpS2Lcc() {
        return notElpS2Lcc;
    }

    /**
     * Sets the value of the notElpS2Lcc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNotElpS2Lcc(String value) {
        this.notElpS2Lcc = value;
    }

    /**
     * Gets the value of the typeResS1 property.
     * 
     * @return
     *     possible object is
     *     {@link TypResultatDTO }
     *     
     */
    public TypResultatDTO getTypeResS1() {
        return typeResS1;
    }

    /**
     * Sets the value of the typeResS1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link TypResultatDTO }
     *     
     */
    public void setTypeResS1(TypResultatDTO value) {
        this.typeResS1 = value;
    }

    /**
     * Gets the value of the typeResS2 property.
     * 
     * @return
     *     possible object is
     *     {@link TypResultatDTO }
     *     
     */
    public TypResultatDTO getTypeResS2() {
        return typeResS2;
    }

    /**
     * Sets the value of the typeResS2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link TypResultatDTO }
     *     
     */
    public void setTypeResS2(TypResultatDTO value) {
        this.typeResS2 = value;
    }

}
