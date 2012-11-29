
package gouv.education.apogee.commun.transverse.dto.pedagogique.periodeexadto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PeriodeExaDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PeriodeExaDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codCtreIncomp" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codPeriodeExam" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="datDebPeriodeExam" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="datFinPeriodeExam" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libPeriodeExam" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PeriodeExaDTO", propOrder = {
    "codCtreIncomp",
    "codPeriodeExam",
    "datDebPeriodeExam",
    "datFinPeriodeExam",
    "libPeriodeExam"
})
public class PeriodeExaDTO {

    @XmlElement(required = true, nillable = true)
    protected String codCtreIncomp;
    @XmlElement(required = true, nillable = true)
    protected String codPeriodeExam;
    @XmlElement(required = true, nillable = true)
    protected String datDebPeriodeExam;
    @XmlElement(required = true, nillable = true)
    protected String datFinPeriodeExam;
    @XmlElement(required = true, nillable = true)
    protected String libPeriodeExam;

    /**
     * Gets the value of the codCtreIncomp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodCtreIncomp() {
        return codCtreIncomp;
    }

    /**
     * Sets the value of the codCtreIncomp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodCtreIncomp(String value) {
        this.codCtreIncomp = value;
    }

    /**
     * Gets the value of the codPeriodeExam property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodPeriodeExam() {
        return codPeriodeExam;
    }

    /**
     * Sets the value of the codPeriodeExam property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodPeriodeExam(String value) {
        this.codPeriodeExam = value;
    }

    /**
     * Gets the value of the datDebPeriodeExam property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatDebPeriodeExam() {
        return datDebPeriodeExam;
    }

    /**
     * Sets the value of the datDebPeriodeExam property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatDebPeriodeExam(String value) {
        this.datDebPeriodeExam = value;
    }

    /**
     * Gets the value of the datFinPeriodeExam property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatFinPeriodeExam() {
        return datFinPeriodeExam;
    }

    /**
     * Sets the value of the datFinPeriodeExam property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatFinPeriodeExam(String value) {
        this.datFinPeriodeExam = value;
    }

    /**
     * Gets the value of the libPeriodeExam property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibPeriodeExam() {
        return libPeriodeExam;
    }

    /**
     * Sets the value of the libPeriodeExam property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibPeriodeExam(String value) {
        this.libPeriodeExam = value;
    }

}
