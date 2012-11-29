
package org.esupportail.pstagedata.remote;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for etapeDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="etapeDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://remote.pstagedata.esupportail.org/}nomenclatureCodeDTO">
 *       &lt;sequence>
 *         &lt;element name="codeUniversite" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "etapeDTO", propOrder = {
    "codeUniversite"
})
public class EtapeDTO
    extends NomenclatureCodeDTO
{

    protected String codeUniversite;

    /**
     * Gets the value of the codeUniversite property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeUniversite() {
        return codeUniversite;
    }

    /**
     * Sets the value of the codeUniversite property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeUniversite(String value) {
        this.codeUniversite = value;
    }

}
