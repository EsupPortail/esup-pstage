
package gouv.education.apogee.commun.transverse.exception;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WebBaseException complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WebBaseException">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="domaine" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="element" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="lastErrorMsg" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="messages" type="{exception.transverse.commun.apogee.education.gouv}TableauString"/>
 *         &lt;element name="nature" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WebBaseException", propOrder = {
    "domaine",
    "element",
    "lastErrorMsg",
    "messages",
    "nature",
    "type"
})
public class WebBaseException {

    @XmlElement(required = true, nillable = true)
    protected String domaine;
    @XmlElement(required = true, nillable = true)
    protected String element;
    @XmlElement(required = true, nillable = true)
    protected String lastErrorMsg;
    @XmlElement(required = true, nillable = true)
    protected TableauString messages;
    @XmlElement(required = true, nillable = true)
    protected String nature;
    @XmlElement(required = true, nillable = true)
    protected String type;

    /**
     * Gets the value of the domaine property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDomaine() {
        return domaine;
    }

    /**
     * Sets the value of the domaine property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDomaine(String value) {
        this.domaine = value;
    }

    /**
     * Gets the value of the element property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getElement() {
        return element;
    }

    /**
     * Sets the value of the element property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setElement(String value) {
        this.element = value;
    }

    /**
     * Gets the value of the lastErrorMsg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastErrorMsg() {
        return lastErrorMsg;
    }

    /**
     * Sets the value of the lastErrorMsg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastErrorMsg(String value) {
        this.lastErrorMsg = value;
    }

    /**
     * Gets the value of the messages property.
     * 
     * @return
     *     possible object is
     *     {@link TableauString }
     *     
     */
    public TableauString getMessages() {
        return messages;
    }

    /**
     * Sets the value of the messages property.
     * 
     * @param value
     *     allowed object is
     *     {@link TableauString }
     *     
     */
    public void setMessages(TableauString value) {
        this.messages = value;
    }

    /**
     * Gets the value of the nature property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNature() {
        return nature;
    }

    /**
     * Sets the value of the nature property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNature(String value) {
        this.nature = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

}
