
package referentielmetier_18062010.servicesmetiers.commun.apogee.education.gouv;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="_codPeriodeExam" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="_codCtreIncomp" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="_date" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="_temoinEnService" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "codPeriodeExam",
    "codCtreIncomp",
    "date",
    "temoinEnService"
})
@XmlRootElement(name = "recupererPeriodeExamen")
public class RecupererPeriodeExamen {

    @XmlElement(name = "_codPeriodeExam", required = true)
    protected String codPeriodeExam;
    @XmlElement(name = "_codCtreIncomp", required = true)
    protected String codCtreIncomp;
    @XmlElement(name = "_date", required = true)
    protected String date;
    @XmlElement(name = "_temoinEnService", required = true)
    protected String temoinEnService;

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
     * Gets the value of the date property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDate(String value) {
        this.date = value;
    }

    /**
     * Gets the value of the temoinEnService property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemoinEnService() {
        return temoinEnService;
    }

    /**
     * Sets the value of the temoinEnService property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemoinEnService(String value) {
        this.temoinEnService = value;
    }

}
