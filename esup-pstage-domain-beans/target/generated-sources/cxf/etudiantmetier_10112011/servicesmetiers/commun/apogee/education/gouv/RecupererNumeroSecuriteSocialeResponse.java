
package etudiantmetier_10112011.servicesmetiers.commun.apogee.education.gouv;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gouv.education.apogee.commun.transverse.dto.etudiant.numssocdto.NumSSocDTO;


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
 *         &lt;element name="numSSoc" type="{NumSSocDTO.etudiant.dto.transverse.commun.apogee.education.gouv}NumSSocDTO"/>
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
    "numSSoc"
})
@XmlRootElement(name = "recupererNumeroSecuriteSocialeResponse")
public class RecupererNumeroSecuriteSocialeResponse {

    @XmlElement(required = true)
    protected NumSSocDTO numSSoc;

    /**
     * Gets the value of the numSSoc property.
     * 
     * @return
     *     possible object is
     *     {@link NumSSocDTO }
     *     
     */
    public NumSSocDTO getNumSSoc() {
        return numSSoc;
    }

    /**
     * Sets the value of the numSSoc property.
     * 
     * @param value
     *     allowed object is
     *     {@link NumSSocDTO }
     *     
     */
    public void setNumSSoc(NumSSocDTO value) {
        this.numSSoc = value;
    }

}
