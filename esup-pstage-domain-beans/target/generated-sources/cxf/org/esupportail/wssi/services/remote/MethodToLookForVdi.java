
package org.esupportail.wssi.services.remote;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for methodToLookForVdi.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="methodToLookForVdi">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="vdiToVet"/>
 *     &lt;enumeration value="vdiToListCodDip"/>
 *     &lt;enumeration value="vdiTovdi"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "methodToLookForVdi")
@XmlEnum
public enum MethodToLookForVdi {

    @XmlEnumValue("vdiToVet")
    VDI_TO_VET("vdiToVet"),
    @XmlEnumValue("vdiToListCodDip")
    VDI_TO_LIST_COD_DIP("vdiToListCodDip"),
    @XmlEnumValue("vdiTovdi")
    VDI_TOVDI("vdiTovdi");
    private final String value;

    MethodToLookForVdi(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static MethodToLookForVdi fromValue(String v) {
        for (MethodToLookForVdi c: MethodToLookForVdi.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
