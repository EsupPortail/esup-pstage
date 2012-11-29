
package gouv.education.apogee.commun.transverse.dto.pedagogique.secteurdisciplinairedto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SecteurDisciplinaireDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SecteurDisciplinaireDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codSectDiscip" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libSectDiscip" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="licSectDiscip" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="temEnSve" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SecteurDisciplinaireDTO", propOrder = {
    "codSectDiscip",
    "libSectDiscip",
    "licSectDiscip",
    "temEnSve"
})
public class SecteurDisciplinaireDTO {

    @XmlElement(required = true, nillable = true)
    protected String codSectDiscip;
    @XmlElement(required = true, nillable = true)
    protected String libSectDiscip;
    @XmlElement(required = true, nillable = true)
    protected String licSectDiscip;
    @XmlElement(required = true, nillable = true)
    protected String temEnSve;

    /**
     * Gets the value of the codSectDiscip property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodSectDiscip() {
        return codSectDiscip;
    }

    /**
     * Sets the value of the codSectDiscip property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodSectDiscip(String value) {
        this.codSectDiscip = value;
    }

    /**
     * Gets the value of the libSectDiscip property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibSectDiscip() {
        return libSectDiscip;
    }

    /**
     * Sets the value of the libSectDiscip property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibSectDiscip(String value) {
        this.libSectDiscip = value;
    }

    /**
     * Gets the value of the licSectDiscip property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLicSectDiscip() {
        return licSectDiscip;
    }

    /**
     * Sets the value of the licSectDiscip property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLicSectDiscip(String value) {
        this.licSectDiscip = value;
    }

    /**
     * Gets the value of the temEnSve property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemEnSve() {
        return temEnSve;
    }

    /**
     * Sets the value of the temEnSve property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemEnSve(String value) {
        this.temEnSve = value;
    }

}
