
package org.esupportail.wssi.services.remote;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for maqCalend complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="maqCalend">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codCln" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codPxa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="libCln" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "maqCalend", propOrder = {
    "codCln",
    "codPxa",
    "libCln"
})
public class MaqCalend {

    protected String codCln;
    protected String codPxa;
    protected String libCln;

    /**
     * Gets the value of the codCln property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodCln() {
        return codCln;
    }

    /**
     * Sets the value of the codCln property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodCln(String value) {
        this.codCln = value;
    }

    /**
     * Gets the value of the codPxa property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodPxa() {
        return codPxa;
    }

    /**
     * Sets the value of the codPxa property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodPxa(String value) {
        this.codPxa = value;
    }

    /**
     * Gets the value of the libCln property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibCln() {
        return libCln;
    }

    /**
     * Sets the value of the libCln property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibCln(String value) {
        this.libCln = value;
    }

}
