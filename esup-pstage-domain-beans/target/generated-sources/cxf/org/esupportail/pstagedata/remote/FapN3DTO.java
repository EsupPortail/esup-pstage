
package org.esupportail.pstagedata.remote;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for fapN3DTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="fapN3DTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://remote.pstagedata.esupportail.org/}nomenclatureCodeEnfantDTO">
 *       &lt;sequence>
 *         &lt;element name="numQualification" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "fapN3DTO", propOrder = {
    "numQualification"
})
public class FapN3DTO
    extends NomenclatureCodeEnfantDTO
{

    protected int numQualification;

    /**
     * Gets the value of the numQualification property.
     * 
     */
    public int getNumQualification() {
        return numQualification;
    }

    /**
     * Sets the value of the numQualification property.
     * 
     */
    public void setNumQualification(int value) {
        this.numQualification = value;
    }

}
