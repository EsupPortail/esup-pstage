
package org.esupportail.pstagedata.remote;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for paysDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="paysDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://remote.pstagedata.esupportail.org/}nomenclatureIdDTO">
 *       &lt;sequence>
 *         &lt;element name="actual" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="cog" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="crpay" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="iso2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="siretObligatoire" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "paysDTO", propOrder = {
    "actual",
    "cog",
    "crpay",
    "iso2",
    "siretObligatoire"
})
public class PaysDTO
    extends NomenclatureIdDTO
{

    protected int actual;
    protected int cog;
    protected int crpay;
    protected String iso2;
    protected boolean siretObligatoire;

    /**
     * Gets the value of the actual property.
     * 
     */
    public int getActual() {
        return actual;
    }

    /**
     * Sets the value of the actual property.
     * 
     */
    public void setActual(int value) {
        this.actual = value;
    }

    /**
     * Gets the value of the cog property.
     * 
     */
    public int getCog() {
        return cog;
    }

    /**
     * Sets the value of the cog property.
     * 
     */
    public void setCog(int value) {
        this.cog = value;
    }

    /**
     * Gets the value of the crpay property.
     * 
     */
    public int getCrpay() {
        return crpay;
    }

    /**
     * Sets the value of the crpay property.
     * 
     */
    public void setCrpay(int value) {
        this.crpay = value;
    }

    /**
     * Gets the value of the iso2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIso2() {
        return iso2;
    }

    /**
     * Sets the value of the iso2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIso2(String value) {
        this.iso2 = value;
    }

    /**
     * Gets the value of the siretObligatoire property.
     * 
     */
    public boolean isSiretObligatoire() {
        return siretObligatoire;
    }

    /**
     * Sets the value of the siretObligatoire property.
     * 
     */
    public void setSiretObligatoire(boolean value) {
        this.siretObligatoire = value;
    }

}
