
package org.esupportail.pstagedata.remote;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for caisseRegimeDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="caisseRegimeDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://remote.pstagedata.esupportail.org/}nomenclatureCodeDTO">
 *       &lt;sequence>
 *         &lt;element name="infoCaisse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "caisseRegimeDTO", propOrder = {
    "infoCaisse"
})
public class CaisseRegimeDTO
    extends NomenclatureCodeDTO
{

    protected String infoCaisse;

    /**
     * Gets the value of the infoCaisse property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInfoCaisse() {
        return infoCaisse;
    }

    /**
     * Sets the value of the infoCaisse property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInfoCaisse(String value) {
        this.infoCaisse = value;
    }

}
