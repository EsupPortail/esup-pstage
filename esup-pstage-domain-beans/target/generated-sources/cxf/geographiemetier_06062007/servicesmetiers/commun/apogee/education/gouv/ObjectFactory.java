
package geographiemetier_06062007.servicesmetiers.commun.apogee.education.gouv;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import gouv.education.apogee.commun.transverse.exception.WebBaseException;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the geographiemetier_06062007.servicesmetiers.commun.apogee.education.gouv package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Fault_QNAME = new QName("gouv.education.apogee.commun.servicesmetiers.GeographieMetier_06062007", "fault");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: geographiemetier_06062007.servicesmetiers.commun.apogee.education.gouv
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RecupererCommune }
     * 
     */
    public RecupererCommune createRecupererCommune() {
        return new RecupererCommune();
    }

    /**
     * Create an instance of {@link RecupererCommuneResponse }
     * 
     */
    public RecupererCommuneResponse createRecupererCommuneResponse() {
        return new RecupererCommuneResponse();
    }

    /**
     * Create an instance of {@link RecupererPays }
     * 
     */
    public RecupererPays createRecupererPays() {
        return new RecupererPays();
    }

    /**
     * Create an instance of {@link RecupererDepartement }
     * 
     */
    public RecupererDepartement createRecupererDepartement() {
        return new RecupererDepartement();
    }

    /**
     * Create an instance of {@link RecupererDepartementResponse }
     * 
     */
    public RecupererDepartementResponse createRecupererDepartementResponse() {
        return new RecupererDepartementResponse();
    }

    /**
     * Create an instance of {@link RecupererPaysResponse }
     * 
     */
    public RecupererPaysResponse createRecupererPaysResponse() {
        return new RecupererPaysResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WebBaseException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "gouv.education.apogee.commun.servicesmetiers.GeographieMetier_06062007", name = "fault")
    public JAXBElement<WebBaseException> createFault(WebBaseException value) {
        return new JAXBElement<WebBaseException>(_Fault_QNAME, WebBaseException.class, null, value);
    }

}
