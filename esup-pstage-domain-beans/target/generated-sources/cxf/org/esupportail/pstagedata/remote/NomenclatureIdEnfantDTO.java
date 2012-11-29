
package org.esupportail.pstagedata.remote;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for nomenclatureIdEnfantDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="nomenclatureIdEnfantDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://remote.pstagedata.esupportail.org/}nomenclatureIdDTO">
 *       &lt;sequence>
 *         &lt;element name="idParent" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "nomenclatureIdEnfantDTO", propOrder = {
    "idParent"
})
@XmlSeeAlso({
    FapQualificationDTO.class,
    ContratOffreDTO.class,
    StatutJuridiqueDTO.class
})
public class NomenclatureIdEnfantDTO
    extends NomenclatureIdDTO
{

    protected int idParent;

    /**
     * Gets the value of the idParent property.
     * 
     */
    public int getIdParent() {
        return idParent;
    }

    /**
     * Sets the value of the idParent property.
     * 
     */
    public void setIdParent(int value) {
        this.idParent = value;
    }

}
