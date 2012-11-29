
package org.esupportail.pstagedata.remote;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for critereGestionDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="critereGestionDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://remote.pstagedata.esupportail.org/}nomenclatureCodeDTO">
 *       &lt;sequence>
 *         &lt;element name="idCentreGestion" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "critereGestionDTO", propOrder = {
    "idCentreGestion"
})
public class CritereGestionDTO
    extends NomenclatureCodeDTO
{

    protected int idCentreGestion;

    /**
     * Gets the value of the idCentreGestion property.
     * 
     */
    public int getIdCentreGestion() {
        return idCentreGestion;
    }

    /**
     * Sets the value of the idCentreGestion property.
     * 
     */
    public void setIdCentreGestion(int value) {
        this.idCentreGestion = value;
    }

}
