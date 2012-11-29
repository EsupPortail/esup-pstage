
package administratifmetier_17062009.servicesmetiers.commun.apogee.education.gouv;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import gouv.education.apogee.commun.transverse.exception.WebBaseException;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the administratifmetier_17062009.servicesmetiers.commun.apogee.education.gouv package. 
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

    private final static QName _Fault_QNAME = new QName("gouv.education.apogee.commun.servicesmetiers.AdministratifMetier_17062009", "fault");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: administratifmetier_17062009.servicesmetiers.commun.apogee.education.gouv
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RecupererIAEtapesV2Response }
     * 
     */
    public RecupererIAEtapesV2Response createRecupererIAEtapesV2Response() {
        return new RecupererIAEtapesV2Response();
    }

    /**
     * Create an instance of {@link RecupererIAAnnuelles }
     * 
     */
    public RecupererIAAnnuelles createRecupererIAAnnuelles() {
        return new RecupererIAAnnuelles();
    }

    /**
     * Create an instance of {@link RecupererAnneesIaResponse }
     * 
     */
    public RecupererAnneesIaResponse createRecupererAnneesIaResponse() {
        return new RecupererAnneesIaResponse();
    }

    /**
     * Create an instance of {@link RecupererIAAnnuellesV2Response }
     * 
     */
    public RecupererIAAnnuellesV2Response createRecupererIAAnnuellesV2Response() {
        return new RecupererIAAnnuellesV2Response();
    }

    /**
     * Create an instance of {@link RecupererIAAnnuellesResponse }
     * 
     */
    public RecupererIAAnnuellesResponse createRecupererIAAnnuellesResponse() {
        return new RecupererIAAnnuellesResponse();
    }

    /**
     * Create an instance of {@link RecupererIAEtapes }
     * 
     */
    public RecupererIAEtapes createRecupererIAEtapes() {
        return new RecupererIAEtapes();
    }

    /**
     * Create an instance of {@link RecupererIAEtapesResponse }
     * 
     */
    public RecupererIAEtapesResponse createRecupererIAEtapesResponse() {
        return new RecupererIAEtapesResponse();
    }

    /**
     * Create an instance of {@link RecupererCursusExterneResponse }
     * 
     */
    public RecupererCursusExterneResponse createRecupererCursusExterneResponse() {
        return new RecupererCursusExterneResponse();
    }

    /**
     * Create an instance of {@link RecupererIAAnnuellesV2 }
     * 
     */
    public RecupererIAAnnuellesV2 createRecupererIAAnnuellesV2() {
        return new RecupererIAAnnuellesV2();
    }

    /**
     * Create an instance of {@link RecupererAnneesIa }
     * 
     */
    public RecupererAnneesIa createRecupererAnneesIa() {
        return new RecupererAnneesIa();
    }

    /**
     * Create an instance of {@link RecupererCursusExterne }
     * 
     */
    public RecupererCursusExterne createRecupererCursusExterne() {
        return new RecupererCursusExterne();
    }

    /**
     * Create an instance of {@link RecupererIAEtapesV2 }
     * 
     */
    public RecupererIAEtapesV2 createRecupererIAEtapesV2() {
        return new RecupererIAEtapesV2();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WebBaseException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "gouv.education.apogee.commun.servicesmetiers.AdministratifMetier_17062009", name = "fault")
    public JAXBElement<WebBaseException> createFault(WebBaseException value) {
        return new JAXBElement<WebBaseException>(_Fault_QNAME, WebBaseException.class, null, value);
    }

}
