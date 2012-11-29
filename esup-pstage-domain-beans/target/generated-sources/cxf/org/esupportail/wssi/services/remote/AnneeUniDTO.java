
package org.esupportail.wssi.services.remote;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anneeUniDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="anneeUniDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://remote.services.wssi.esupportail.org/}dto">
 *       &lt;sequence>
 *         &lt;element name="codAnu" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="libAnu" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "anneeUniDTO", propOrder = {
    "codAnu",
    "libAnu"
})
public class AnneeUniDTO
    extends Dto
{

    protected String codAnu;
    protected String libAnu;

    /**
     * Gets the value of the codAnu property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodAnu() {
        return codAnu;
    }

    /**
     * Sets the value of the codAnu property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodAnu(String value) {
        this.codAnu = value;
    }

    /**
     * Gets the value of the libAnu property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibAnu() {
        return libAnu;
    }

    /**
     * Sets the value of the libAnu property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibAnu(String value) {
        this.libAnu = value;
    }

}
