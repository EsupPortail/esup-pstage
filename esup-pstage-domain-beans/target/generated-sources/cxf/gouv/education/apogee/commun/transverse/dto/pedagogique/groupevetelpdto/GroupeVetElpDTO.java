
package gouv.education.apogee.commun.transverse.dto.pedagogique.groupevetelpdto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GroupeVetElpDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GroupeVetElpDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codCol" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codGpe" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libDesOrgGpo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="libGpe" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GroupeVetElpDTO", propOrder = {
    "codCol",
    "codGpe",
    "libDesOrgGpo",
    "libGpe"
})
public class GroupeVetElpDTO {

    @XmlElement(required = true, nillable = true)
    protected String codCol;
    @XmlElement(required = true, nillable = true)
    protected String codGpe;
    @XmlElement(required = true, nillable = true)
    protected String libDesOrgGpo;
    @XmlElement(required = true, nillable = true)
    protected String libGpe;

    /**
     * Gets the value of the codCol property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodCol() {
        return codCol;
    }

    /**
     * Sets the value of the codCol property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodCol(String value) {
        this.codCol = value;
    }

    /**
     * Gets the value of the codGpe property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodGpe() {
        return codGpe;
    }

    /**
     * Sets the value of the codGpe property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodGpe(String value) {
        this.codGpe = value;
    }

    /**
     * Gets the value of the libDesOrgGpo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibDesOrgGpo() {
        return libDesOrgGpo;
    }

    /**
     * Sets the value of the libDesOrgGpo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibDesOrgGpo(String value) {
        this.libDesOrgGpo = value;
    }

    /**
     * Gets the value of the libGpe property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibGpe() {
        return libGpe;
    }

    /**
     * Sets the value of the libGpe property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibGpe(String value) {
        this.libGpe = value;
    }

}
