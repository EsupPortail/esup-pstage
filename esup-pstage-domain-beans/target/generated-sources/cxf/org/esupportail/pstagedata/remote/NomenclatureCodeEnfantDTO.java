
package org.esupportail.pstagedata.remote;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for nomenclatureCodeEnfantDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="nomenclatureCodeEnfantDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://remote.pstagedata.esupportail.org/}nomenclatureCodeDTO">
 *       &lt;sequence>
 *         &lt;element name="codeParent" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "nomenclatureCodeEnfantDTO", propOrder = {
    "codeParent"
})
@XmlSeeAlso({
    NafN5DTO.class,
    FapN3DTO.class,
    FapN2DTO.class
})
public class NomenclatureCodeEnfantDTO
    extends NomenclatureCodeDTO
{

    protected String codeParent;

    /**
     * Gets the value of the codeParent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeParent() {
        return codeParent;
    }

    /**
     * Sets the value of the codeParent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeParent(String value) {
        this.codeParent = value;
    }

}
