
package org.esupportail.pstagedata.remote;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for typeStructureDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="typeStructureDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://remote.pstagedata.esupportail.org/}nomenclatureIdDTO">
 *       &lt;sequence>
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
@XmlType(name = "typeStructureDTO", propOrder = {
    "siretObligatoire"
})
public class TypeStructureDTO
    extends NomenclatureIdDTO
{

    protected boolean siretObligatoire;

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
