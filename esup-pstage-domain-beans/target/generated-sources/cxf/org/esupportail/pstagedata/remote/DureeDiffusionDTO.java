
package org.esupportail.pstagedata.remote;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dureeDiffusionDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dureeDiffusionDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://remote.pstagedata.esupportail.org/}nomenclatureIdDTO">
 *       &lt;sequence>
 *         &lt;element name="adminSeulement" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dureeDiffusionDTO", propOrder = {
    "adminSeulement"
})
public class DureeDiffusionDTO
    extends NomenclatureIdDTO
{

    protected boolean adminSeulement;

    /**
     * Gets the value of the adminSeulement property.
     * 
     */
    public boolean isAdminSeulement() {
        return adminSeulement;
    }

    /**
     * Sets the value of the adminSeulement property.
     * 
     */
    public void setAdminSeulement(boolean value) {
        this.adminSeulement = value;
    }

}
