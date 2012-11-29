
package org.esupportail.pstagedata.remote;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for statisticItemDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="statisticItemDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idPriorCriteria" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idStatisticItem" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="lib" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="libPriorCriteria" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="number" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="percentage" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "statisticItemDTO", propOrder = {
    "id",
    "idPriorCriteria",
    "idStatisticItem",
    "lib",
    "libPriorCriteria",
    "number",
    "percentage"
})
public class StatisticItemDTO {

    protected String id;
    protected String idPriorCriteria;
    protected Integer idStatisticItem;
    protected String lib;
    protected String libPriorCriteria;
    protected int number;
    protected double percentage;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the idPriorCriteria property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdPriorCriteria() {
        return idPriorCriteria;
    }

    /**
     * Sets the value of the idPriorCriteria property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdPriorCriteria(String value) {
        this.idPriorCriteria = value;
    }

    /**
     * Gets the value of the idStatisticItem property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdStatisticItem() {
        return idStatisticItem;
    }

    /**
     * Sets the value of the idStatisticItem property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdStatisticItem(Integer value) {
        this.idStatisticItem = value;
    }

    /**
     * Gets the value of the lib property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLib() {
        return lib;
    }

    /**
     * Sets the value of the lib property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLib(String value) {
        this.lib = value;
    }

    /**
     * Gets the value of the libPriorCriteria property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibPriorCriteria() {
        return libPriorCriteria;
    }

    /**
     * Sets the value of the libPriorCriteria property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibPriorCriteria(String value) {
        this.libPriorCriteria = value;
    }

    /**
     * Gets the value of the number property.
     * 
     */
    public int getNumber() {
        return number;
    }

    /**
     * Sets the value of the number property.
     * 
     */
    public void setNumber(int value) {
        this.number = value;
    }

    /**
     * Gets the value of the percentage property.
     * 
     */
    public double getPercentage() {
        return percentage;
    }

    /**
     * Sets the value of the percentage property.
     * 
     */
    public void setPercentage(double value) {
        this.percentage = value;
    }

}
