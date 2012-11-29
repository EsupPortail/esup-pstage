
package gouv.education.apogee.commun.transverse.dto.etudiant.etudiantcriterelistedto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gouv.education.apogee.commun.transverse.exception.TableauString;


/**
 * <p>Java class for EtudiantCritereListeDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EtudiantCritereListeDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="listVersion" type="{exception.transverse.commun.apogee.education.gouv}TableauString"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EtudiantCritereListeDTO", propOrder = {
    "code",
    "listVersion"
})
public class EtudiantCritereListeDTO {

    @XmlElement(required = true, nillable = true)
    protected String code;
    @XmlElement(required = true, nillable = true)
    protected TableauString listVersion;

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * Gets the value of the listVersion property.
     * 
     * @return
     *     possible object is
     *     {@link TableauString }
     *     
     */
    public TableauString getListVersion() {
        return listVersion;
    }

    /**
     * Sets the value of the listVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link TableauString }
     *     
     */
    public void setListVersion(TableauString value) {
        this.listVersion = value;
    }

}
