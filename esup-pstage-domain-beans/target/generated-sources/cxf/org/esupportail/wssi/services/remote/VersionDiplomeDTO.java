
package org.esupportail.wssi.services.remote;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for versionDiplomeDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="versionDiplomeDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://remote.services.wssi.esupportail.org/}dto">
 *       &lt;sequence>
 *         &lt;element name="codDip" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codVrsVdi" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="libWebVdi" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="licVdi" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "versionDiplomeDTO", propOrder = {
    "codDip",
    "codVrsVdi",
    "libWebVdi",
    "licVdi"
})
public class VersionDiplomeDTO
    extends Dto
{

    protected String codDip;
    protected Integer codVrsVdi;
    protected String libWebVdi;
    protected String licVdi;

    /**
     * Gets the value of the codDip property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodDip() {
        return codDip;
    }

    /**
     * Sets the value of the codDip property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodDip(String value) {
        this.codDip = value;
    }

    /**
     * Gets the value of the codVrsVdi property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCodVrsVdi() {
        return codVrsVdi;
    }

    /**
     * Sets the value of the codVrsVdi property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCodVrsVdi(Integer value) {
        this.codVrsVdi = value;
    }

    /**
     * Gets the value of the libWebVdi property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibWebVdi() {
        return libWebVdi;
    }

    /**
     * Sets the value of the libWebVdi property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibWebVdi(String value) {
        this.libWebVdi = value;
    }

    /**
     * Gets the value of the licVdi property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLicVdi() {
        return licVdi;
    }

    /**
     * Sets the value of the licVdi property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLicVdi(String value) {
        this.licVdi = value;
    }

}
