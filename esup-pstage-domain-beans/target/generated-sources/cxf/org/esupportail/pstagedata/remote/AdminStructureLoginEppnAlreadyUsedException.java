
package org.esupportail.pstagedata.remote;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AdminStructureLoginEppnAlreadyUsedException complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AdminStructureLoginEppnAlreadyUsedException">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="login" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="eppn" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AdminStructureLoginEppnAlreadyUsedException", propOrder = {
    "login",
    "eppn"
})
public class AdminStructureLoginEppnAlreadyUsedException {

    @XmlElement(required = true, type = Boolean.class, nillable = true)
    protected Boolean login;
    @XmlElement(required = true, type = Boolean.class, nillable = true)
    protected Boolean eppn;

    /**
     * Gets the value of the login property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isLogin() {
        return login;
    }

    /**
     * Sets the value of the login property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setLogin(Boolean value) {
        this.login = value;
    }

    /**
     * Gets the value of the eppn property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isEppn() {
        return eppn;
    }

    /**
     * Sets the value of the eppn property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEppn(Boolean value) {
        this.eppn = value;
    }

}
