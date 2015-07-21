
package co.com.codesoftware.server;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the co.com.codesoftware.server package. 
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

    private final static QName _LoginResponse_QNAME = new QName("http://server.codesoftware.com.co/", "loginResponse");
    private final static QName _AddCliente_QNAME = new QName("http://server.codesoftware.com.co/", "addCliente");
    private final static QName _AddClienteResponse_QNAME = new QName("http://server.codesoftware.com.co/", "addClienteResponse");
    private final static QName _GetClientes_QNAME = new QName("http://server.codesoftware.com.co/", "getClientes");
    private final static QName _UpdateCliente_QNAME = new QName("http://server.codesoftware.com.co/", "updateCliente");
    private final static QName _UpdateClienteResponse_QNAME = new QName("http://server.codesoftware.com.co/", "updateClienteResponse");
    private final static QName _Login_QNAME = new QName("http://server.codesoftware.com.co/", "login");
    private final static QName _GetSedes_QNAME = new QName("http://server.codesoftware.com.co/", "getSedes");
    private final static QName _GetSedesResponse_QNAME = new QName("http://server.codesoftware.com.co/", "getSedesResponse");
    private final static QName _GetClientesResponse_QNAME = new QName("http://server.codesoftware.com.co/", "getClientesResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: co.com.codesoftware.server
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetClientes }
     * 
     */
    public GetClientes createGetClientes() {
        return new GetClientes();
    }

    /**
     * Create an instance of {@link UpdateCliente }
     * 
     */
    public UpdateCliente createUpdateCliente() {
        return new UpdateCliente();
    }

    /**
     * Create an instance of {@link AddCliente }
     * 
     */
    public AddCliente createAddCliente() {
        return new AddCliente();
    }

    /**
     * Create an instance of {@link AddClienteResponse }
     * 
     */
    public AddClienteResponse createAddClienteResponse() {
        return new AddClienteResponse();
    }

    /**
     * Create an instance of {@link LoginResponse }
     * 
     */
    public LoginResponse createLoginResponse() {
        return new LoginResponse();
    }

    /**
     * Create an instance of {@link GetClientesResponse }
     * 
     */
    public GetClientesResponse createGetClientesResponse() {
        return new GetClientesResponse();
    }

    /**
     * Create an instance of {@link GetSedes }
     * 
     */
    public GetSedes createGetSedes() {
        return new GetSedes();
    }

    /**
     * Create an instance of {@link GetSedesResponse }
     * 
     */
    public GetSedesResponse createGetSedesResponse() {
        return new GetSedesResponse();
    }

    /**
     * Create an instance of {@link Login }
     * 
     */
    public Login createLogin() {
        return new Login();
    }

    /**
     * Create an instance of {@link UpdateClienteResponse }
     * 
     */
    public UpdateClienteResponse createUpdateClienteResponse() {
        return new UpdateClienteResponse();
    }

    /**
     * Create an instance of {@link Cliente }
     * 
     */
    public Cliente createCliente() {
        return new Cliente();
    }

    /**
     * Create an instance of {@link Sede }
     * 
     */
    public Sede createSede() {
        return new Sede();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.codesoftware.com.co/", name = "loginResponse")
    public JAXBElement<LoginResponse> createLoginResponse(LoginResponse value) {
        return new JAXBElement<LoginResponse>(_LoginResponse_QNAME, LoginResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddCliente }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.codesoftware.com.co/", name = "addCliente")
    public JAXBElement<AddCliente> createAddCliente(AddCliente value) {
        return new JAXBElement<AddCliente>(_AddCliente_QNAME, AddCliente.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddClienteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.codesoftware.com.co/", name = "addClienteResponse")
    public JAXBElement<AddClienteResponse> createAddClienteResponse(AddClienteResponse value) {
        return new JAXBElement<AddClienteResponse>(_AddClienteResponse_QNAME, AddClienteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetClientes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.codesoftware.com.co/", name = "getClientes")
    public JAXBElement<GetClientes> createGetClientes(GetClientes value) {
        return new JAXBElement<GetClientes>(_GetClientes_QNAME, GetClientes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateCliente }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.codesoftware.com.co/", name = "updateCliente")
    public JAXBElement<UpdateCliente> createUpdateCliente(UpdateCliente value) {
        return new JAXBElement<UpdateCliente>(_UpdateCliente_QNAME, UpdateCliente.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateClienteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.codesoftware.com.co/", name = "updateClienteResponse")
    public JAXBElement<UpdateClienteResponse> createUpdateClienteResponse(UpdateClienteResponse value) {
        return new JAXBElement<UpdateClienteResponse>(_UpdateClienteResponse_QNAME, UpdateClienteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Login }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.codesoftware.com.co/", name = "login")
    public JAXBElement<Login> createLogin(Login value) {
        return new JAXBElement<Login>(_Login_QNAME, Login.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSedes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.codesoftware.com.co/", name = "getSedes")
    public JAXBElement<GetSedes> createGetSedes(GetSedes value) {
        return new JAXBElement<GetSedes>(_GetSedes_QNAME, GetSedes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSedesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.codesoftware.com.co/", name = "getSedesResponse")
    public JAXBElement<GetSedesResponse> createGetSedesResponse(GetSedesResponse value) {
        return new JAXBElement<GetSedesResponse>(_GetSedesResponse_QNAME, GetSedesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetClientesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.codesoftware.com.co/", name = "getClientesResponse")
    public JAXBElement<GetClientesResponse> createGetClientesResponse(GetClientesResponse value) {
        return new JAXBElement<GetClientesResponse>(_GetClientesResponse_QNAME, GetClientesResponse.class, null, value);
    }

}
