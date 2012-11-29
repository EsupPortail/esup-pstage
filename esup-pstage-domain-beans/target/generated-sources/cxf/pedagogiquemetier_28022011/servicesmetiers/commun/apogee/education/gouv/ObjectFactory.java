
package pedagogiquemetier_28022011.servicesmetiers.commun.apogee.education.gouv;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import gouv.education.apogee.commun.transverse.exception.WebBaseException;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the pedagogiquemetier_28022011.servicesmetiers.commun.apogee.education.gouv package. 
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

    private final static QName _Fault_QNAME = new QName("gouv.education.apogee.commun.servicesmetiers.PedagogiqueMetier_28022011", "fault");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: pedagogiquemetier_28022011.servicesmetiers.commun.apogee.education.gouv
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RecupererContratPedagogiqueResultatVdiVetResponse }
     * 
     */
    public RecupererContratPedagogiqueResultatVdiVetResponse createRecupererContratPedagogiqueResultatVdiVetResponse() {
        return new RecupererContratPedagogiqueResultatVdiVetResponse();
    }

    /**
     * Create an instance of {@link RecupererContratPedagogiqueResultatVdiVet }
     * 
     */
    public RecupererContratPedagogiqueResultatVdiVet createRecupererContratPedagogiqueResultatVdiVet() {
        return new RecupererContratPedagogiqueResultatVdiVet();
    }

    /**
     * Create an instance of {@link RecupererAnneesIPResultat }
     * 
     */
    public RecupererAnneesIPResultat createRecupererAnneesIPResultat() {
        return new RecupererAnneesIPResultat();
    }

    /**
     * Create an instance of {@link RecupererContratPedagogiqueResultatElpEprV5 }
     * 
     */
    public RecupererContratPedagogiqueResultatElpEprV5 createRecupererContratPedagogiqueResultatElpEprV5() {
        return new RecupererContratPedagogiqueResultatElpEprV5();
    }

    /**
     * Create an instance of {@link RecupererAnneesIPResultatResponse }
     * 
     */
    public RecupererAnneesIPResultatResponse createRecupererAnneesIPResultatResponse() {
        return new RecupererAnneesIPResultatResponse();
    }

    /**
     * Create an instance of {@link RecupererContratPedagogiqueResultatElpEprV5Response }
     * 
     */
    public RecupererContratPedagogiqueResultatElpEprV5Response createRecupererContratPedagogiqueResultatElpEprV5Response() {
        return new RecupererContratPedagogiqueResultatElpEprV5Response();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WebBaseException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "gouv.education.apogee.commun.servicesmetiers.PedagogiqueMetier_28022011", name = "fault")
    public JAXBElement<WebBaseException> createFault(WebBaseException value) {
        return new JAXBElement<WebBaseException>(_Fault_QNAME, WebBaseException.class, null, value);
    }

}
