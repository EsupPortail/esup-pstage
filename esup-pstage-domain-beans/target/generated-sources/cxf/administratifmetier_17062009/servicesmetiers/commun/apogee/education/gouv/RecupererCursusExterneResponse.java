
package administratifmetier_17062009.servicesmetiers.commun.apogee.education.gouv;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import gouv.education.apogee.commun.transverse.dto.administratif.cursusexternesettransfertsdto.CursusExternesEtTransfertsDTO;


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
 *         &lt;element name="recupererCursusExterneReturn" type="{CursusExternesEtTransfertsDTO.administratif.dto.transverse.commun.apogee.education.gouv}CursusExternesEtTransfertsDTO"/>
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
    "recupererCursusExterneReturn"
})
@XmlRootElement(name = "recupererCursusExterneResponse")
public class RecupererCursusExterneResponse {

    @XmlElement(required = true)
    protected CursusExternesEtTransfertsDTO recupererCursusExterneReturn;

    /**
     * Gets the value of the recupererCursusExterneReturn property.
     * 
     * @return
     *     possible object is
     *     {@link CursusExternesEtTransfertsDTO }
     *     
     */
    public CursusExternesEtTransfertsDTO getRecupererCursusExterneReturn() {
        return recupererCursusExterneReturn;
    }

    /**
     * Sets the value of the recupererCursusExterneReturn property.
     * 
     * @param value
     *     allowed object is
     *     {@link CursusExternesEtTransfertsDTO }
     *     
     */
    public void setRecupererCursusExterneReturn(CursusExternesEtTransfertsDTO value) {
        this.recupererCursusExterneReturn = value;
    }

}
