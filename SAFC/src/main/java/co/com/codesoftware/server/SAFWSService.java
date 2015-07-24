
package co.com.codesoftware.server;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "SAFWSService", targetNamespace = "http://server.codesoftware.com.co/", wsdlLocation = "http://192.168.1.5:9999/WS/server/SAFWS?wsdl")
public class SAFWSService
    extends Service
{

    private final static URL SAFWSSERVICE_WSDL_LOCATION;
    private final static WebServiceException SAFWSSERVICE_EXCEPTION;
    private final static QName SAFWSSERVICE_QNAME = new QName("http://server.codesoftware.com.co/", "SAFWSService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://192.168.1.5:9999/WS/server/SAFWS?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        SAFWSSERVICE_WSDL_LOCATION = url;
        SAFWSSERVICE_EXCEPTION = e;
    }

    public SAFWSService() {
        super(__getWsdlLocation(), SAFWSSERVICE_QNAME);
    }

    public SAFWSService(WebServiceFeature... features) {
        super(__getWsdlLocation(), SAFWSSERVICE_QNAME, features);
    }

    public SAFWSService(URL wsdlLocation) {
        super(wsdlLocation, SAFWSSERVICE_QNAME);
    }

    public SAFWSService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SAFWSSERVICE_QNAME, features);
    }

    public SAFWSService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public SAFWSService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns SAFWS
     */
    @WebEndpoint(name = "SAFWSPort")
    public SAFWS getSAFWSPort() {
        return super.getPort(new QName("http://server.codesoftware.com.co/", "SAFWSPort"), SAFWS.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns SAFWS
     */
    @WebEndpoint(name = "SAFWSPort")
    public SAFWS getSAFWSPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://server.codesoftware.com.co/", "SAFWSPort"), SAFWS.class, features);
    }

    private static URL __getWsdlLocation() {
        if (SAFWSSERVICE_EXCEPTION!= null) {
            throw SAFWSSERVICE_EXCEPTION;
        }
        return SAFWSSERVICE_WSDL_LOCATION;
    }

}
