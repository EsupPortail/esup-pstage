
package org.esupportail.pstagedata.remote;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getContactEntrepriseAvecCompteFromMailAndIdStructureResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getContactEntrepriseAvecCompteFromMailAndIdStructureResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://remote.pstagedata.esupportail.org/}contactDTO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getContactEntrepriseAvecCompteFromMailAndIdStructureResponse", propOrder = {
    "_return"
})
public class GetContactEntrepriseAvecCompteFromMailAndIdStructureResponse {

    @XmlElement(name = "return")
    protected ContactDTO _return;

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link ContactDTO }
     *     
     */
    public ContactDTO getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContactDTO }
     *     
     */
    public void setReturn(ContactDTO value) {
        this._return = value;
    }

}
