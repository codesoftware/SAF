
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

    private final static QName _GetFacturas_QNAME = new QName("http://server.codesoftware.com.co/", "getFacturas");
    private final static QName _LoginResponse_QNAME = new QName("http://server.codesoftware.com.co/", "loginResponse");
    private final static QName _FindExistsForSedeResponse_QNAME = new QName("http://server.codesoftware.com.co/", "findExistsForSedeResponse");
    private final static QName _GetFacturaForId_QNAME = new QName("http://server.codesoftware.com.co/", "getFacturaForId");
    private final static QName _UpdateClienteResponse_QNAME = new QName("http://server.codesoftware.com.co/", "updateClienteResponse");
    private final static QName _GetParamsEmpresaResponse_QNAME = new QName("http://server.codesoftware.com.co/", "getParamsEmpresaResponse");
    private final static QName _GetSedes_QNAME = new QName("http://server.codesoftware.com.co/", "getSedes");
    private final static QName _GetClientesResponse_QNAME = new QName("http://server.codesoftware.com.co/", "getClientesResponse");
    private final static QName _CambiaClaveUsuario_QNAME = new QName("http://server.codesoftware.com.co/", "cambiaClaveUsuario");
    private final static QName _GetProductForCode_QNAME = new QName("http://server.codesoftware.com.co/", "getProductForCode");
    private final static QName _GetProductForCodeResponse_QNAME = new QName("http://server.codesoftware.com.co/", "getProductForCodeResponse");
    private final static QName _GetRecetas_QNAME = new QName("http://server.codesoftware.com.co/", "getRecetas");
    private final static QName _AddClienteResponse_QNAME = new QName("http://server.codesoftware.com.co/", "addClienteResponse");
    private final static QName _GetRecetaForcode_QNAME = new QName("http://server.codesoftware.com.co/", "getRecetaForcode");
    private final static QName _GetUsersResponse_QNAME = new QName("http://server.codesoftware.com.co/", "getUsersResponse");
    private final static QName _GetFacturasResponse_QNAME = new QName("http://server.codesoftware.com.co/", "getFacturasResponse");
    private final static QName _CambiaClaveUsuarioResponse_QNAME = new QName("http://server.codesoftware.com.co/", "cambiaClaveUsuarioResponse");
    private final static QName _Facturar_QNAME = new QName("http://server.codesoftware.com.co/", "facturar");
    private final static QName _GetDishesPrincipalScreenResponse_QNAME = new QName("http://server.codesoftware.com.co/", "getDishesPrincipalScreenResponse");
    private final static QName _GetClienteXCedula_QNAME = new QName("http://server.codesoftware.com.co/", "getClienteXCedula");
    private final static QName _FindExistsForSede_QNAME = new QName("http://server.codesoftware.com.co/", "findExistsForSede");
    private final static QName _GetProductPrincipalScreen_QNAME = new QName("http://server.codesoftware.com.co/", "getProductPrincipalScreen");
    private final static QName _GetRecetasResponse_QNAME = new QName("http://server.codesoftware.com.co/", "getRecetasResponse");
    private final static QName _GetProductPrincipalScreenResponse_QNAME = new QName("http://server.codesoftware.com.co/", "getProductPrincipalScreenResponse");
    private final static QName _GetRecetaForcodeResponse_QNAME = new QName("http://server.codesoftware.com.co/", "getRecetaForcodeResponse");
    private final static QName _Login_QNAME = new QName("http://server.codesoftware.com.co/", "login");
    private final static QName _GetProductsResponse_QNAME = new QName("http://server.codesoftware.com.co/", "getProductsResponse");
    private final static QName _GetParamsEmpresa_QNAME = new QName("http://server.codesoftware.com.co/", "getParamsEmpresa");
    private final static QName _FacturarResponse_QNAME = new QName("http://server.codesoftware.com.co/", "facturarResponse");
    private final static QName _GetClienteXCedulaResponse_QNAME = new QName("http://server.codesoftware.com.co/", "getClienteXCedulaResponse");
    private final static QName _GetUsers_QNAME = new QName("http://server.codesoftware.com.co/", "getUsers");
    private final static QName _FindProductosAndDishesResponse_QNAME = new QName("http://server.codesoftware.com.co/", "findProductosAndDishesResponse");
    private final static QName _AddCliente_QNAME = new QName("http://server.codesoftware.com.co/", "addCliente");
    private final static QName _FindProductosAndDishes_QNAME = new QName("http://server.codesoftware.com.co/", "findProductosAndDishes");
    private final static QName _GetFacturaForIdResponse_QNAME = new QName("http://server.codesoftware.com.co/", "getFacturaForIdResponse");
    private final static QName _GetClientes_QNAME = new QName("http://server.codesoftware.com.co/", "getClientes");
    private final static QName _GetDishesPrincipalScreen_QNAME = new QName("http://server.codesoftware.com.co/", "getDishesPrincipalScreen");
    private final static QName _UpdateCliente_QNAME = new QName("http://server.codesoftware.com.co/", "updateCliente");
    private final static QName _GetUserForUser_QNAME = new QName("http://server.codesoftware.com.co/", "getUserForUser");
    private final static QName _GetProducts_QNAME = new QName("http://server.codesoftware.com.co/", "getProducts");
    private final static QName _GetSedesResponse_QNAME = new QName("http://server.codesoftware.com.co/", "getSedesResponse");
    private final static QName _GetUserForUserResponse_QNAME = new QName("http://server.codesoftware.com.co/", "getUserForUserResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: co.com.codesoftware.server
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetRecetasResponse }
     * 
     */
    public GetRecetasResponse createGetRecetasResponse() {
        return new GetRecetasResponse();
    }

    /**
     * Create an instance of {@link GetProductPrincipalScreen }
     * 
     */
    public GetProductPrincipalScreen createGetProductPrincipalScreen() {
        return new GetProductPrincipalScreen();
    }

    /**
     * Create an instance of {@link FindExistsForSede }
     * 
     */
    public FindExistsForSede createFindExistsForSede() {
        return new FindExistsForSede();
    }

    /**
     * Create an instance of {@link GetClienteXCedula }
     * 
     */
    public GetClienteXCedula createGetClienteXCedula() {
        return new GetClienteXCedula();
    }

    /**
     * Create an instance of {@link Facturar }
     * 
     */
    public Facturar createFacturar() {
        return new Facturar();
    }

    /**
     * Create an instance of {@link GetDishesPrincipalScreenResponse }
     * 
     */
    public GetDishesPrincipalScreenResponse createGetDishesPrincipalScreenResponse() {
        return new GetDishesPrincipalScreenResponse();
    }

    /**
     * Create an instance of {@link GetParamsEmpresa }
     * 
     */
    public GetParamsEmpresa createGetParamsEmpresa() {
        return new GetParamsEmpresa();
    }

    /**
     * Create an instance of {@link GetProductsResponse }
     * 
     */
    public GetProductsResponse createGetProductsResponse() {
        return new GetProductsResponse();
    }

    /**
     * Create an instance of {@link Login }
     * 
     */
    public Login createLogin() {
        return new Login();
    }

    /**
     * Create an instance of {@link GetRecetaForcodeResponse }
     * 
     */
    public GetRecetaForcodeResponse createGetRecetaForcodeResponse() {
        return new GetRecetaForcodeResponse();
    }

    /**
     * Create an instance of {@link GetProductPrincipalScreenResponse }
     * 
     */
    public GetProductPrincipalScreenResponse createGetProductPrincipalScreenResponse() {
        return new GetProductPrincipalScreenResponse();
    }

    /**
     * Create an instance of {@link GetClientes }
     * 
     */
    public GetClientes createGetClientes() {
        return new GetClientes();
    }

    /**
     * Create an instance of {@link GetDishesPrincipalScreen }
     * 
     */
    public GetDishesPrincipalScreen createGetDishesPrincipalScreen() {
        return new GetDishesPrincipalScreen();
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
     * Create an instance of {@link FindProductosAndDishes }
     * 
     */
    public FindProductosAndDishes createFindProductosAndDishes() {
        return new FindProductosAndDishes();
    }

    /**
     * Create an instance of {@link GetFacturaForIdResponse }
     * 
     */
    public GetFacturaForIdResponse createGetFacturaForIdResponse() {
        return new GetFacturaForIdResponse();
    }

    /**
     * Create an instance of {@link FindProductosAndDishesResponse }
     * 
     */
    public FindProductosAndDishesResponse createFindProductosAndDishesResponse() {
        return new FindProductosAndDishesResponse();
    }

    /**
     * Create an instance of {@link GetUsers }
     * 
     */
    public GetUsers createGetUsers() {
        return new GetUsers();
    }

    /**
     * Create an instance of {@link FacturarResponse }
     * 
     */
    public FacturarResponse createFacturarResponse() {
        return new FacturarResponse();
    }

    /**
     * Create an instance of {@link GetClienteXCedulaResponse }
     * 
     */
    public GetClienteXCedulaResponse createGetClienteXCedulaResponse() {
        return new GetClienteXCedulaResponse();
    }

    /**
     * Create an instance of {@link GetSedesResponse }
     * 
     */
    public GetSedesResponse createGetSedesResponse() {
        return new GetSedesResponse();
    }

    /**
     * Create an instance of {@link GetUserForUserResponse }
     * 
     */
    public GetUserForUserResponse createGetUserForUserResponse() {
        return new GetUserForUserResponse();
    }

    /**
     * Create an instance of {@link GetProducts }
     * 
     */
    public GetProducts createGetProducts() {
        return new GetProducts();
    }

    /**
     * Create an instance of {@link GetUserForUser }
     * 
     */
    public GetUserForUser createGetUserForUser() {
        return new GetUserForUser();
    }

    /**
     * Create an instance of {@link LoginResponse }
     * 
     */
    public LoginResponse createLoginResponse() {
        return new LoginResponse();
    }

    /**
     * Create an instance of {@link GetFacturas }
     * 
     */
    public GetFacturas createGetFacturas() {
        return new GetFacturas();
    }

    /**
     * Create an instance of {@link CambiaClaveUsuario }
     * 
     */
    public CambiaClaveUsuario createCambiaClaveUsuario() {
        return new CambiaClaveUsuario();
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
     * Create an instance of {@link GetParamsEmpresaResponse }
     * 
     */
    public GetParamsEmpresaResponse createGetParamsEmpresaResponse() {
        return new GetParamsEmpresaResponse();
    }

    /**
     * Create an instance of {@link GetFacturaForId }
     * 
     */
    public GetFacturaForId createGetFacturaForId() {
        return new GetFacturaForId();
    }

    /**
     * Create an instance of {@link UpdateClienteResponse }
     * 
     */
    public UpdateClienteResponse createUpdateClienteResponse() {
        return new UpdateClienteResponse();
    }

    /**
     * Create an instance of {@link FindExistsForSedeResponse }
     * 
     */
    public FindExistsForSedeResponse createFindExistsForSedeResponse() {
        return new FindExistsForSedeResponse();
    }

    /**
     * Create an instance of {@link AddClienteResponse }
     * 
     */
    public AddClienteResponse createAddClienteResponse() {
        return new AddClienteResponse();
    }

    /**
     * Create an instance of {@link GetRecetas }
     * 
     */
    public GetRecetas createGetRecetas() {
        return new GetRecetas();
    }

    /**
     * Create an instance of {@link GetProductForCodeResponse }
     * 
     */
    public GetProductForCodeResponse createGetProductForCodeResponse() {
        return new GetProductForCodeResponse();
    }

    /**
     * Create an instance of {@link GetProductForCode }
     * 
     */
    public GetProductForCode createGetProductForCode() {
        return new GetProductForCode();
    }

    /**
     * Create an instance of {@link CambiaClaveUsuarioResponse }
     * 
     */
    public CambiaClaveUsuarioResponse createCambiaClaveUsuarioResponse() {
        return new CambiaClaveUsuarioResponse();
    }

    /**
     * Create an instance of {@link GetFacturasResponse }
     * 
     */
    public GetFacturasResponse createGetFacturasResponse() {
        return new GetFacturasResponse();
    }

    /**
     * Create an instance of {@link GetUsersResponse }
     * 
     */
    public GetUsersResponse createGetUsersResponse() {
        return new GetUsersResponse();
    }

    /**
     * Create an instance of {@link GetRecetaForcode }
     * 
     */
    public GetRecetaForcode createGetRecetaForcode() {
        return new GetRecetaForcode();
    }

    /**
     * Create an instance of {@link Facturacion }
     * 
     */
    public Facturacion createFacturacion() {
        return new Facturacion();
    }

    /**
     * Create an instance of {@link RespuestaFacturacion }
     * 
     */
    public RespuestaFacturacion createRespuestaFacturacion() {
        return new RespuestaFacturacion();
    }

    /**
     * Create an instance of {@link UsuarioTable }
     * 
     */
    public UsuarioTable createUsuarioTable() {
        return new UsuarioTable();
    }

    /**
     * Create an instance of {@link ProductoGenericoEntity }
     * 
     */
    public ProductoGenericoEntity createProductoGenericoEntity() {
        return new ProductoGenericoEntity();
    }

    /**
     * Create an instance of {@link DetReceFacturacionTable }
     * 
     */
    public DetReceFacturacionTable createDetReceFacturacionTable() {
        return new DetReceFacturacionTable();
    }

    /**
     * Create an instance of {@link RecetaTable }
     * 
     */
    public RecetaTable createRecetaTable() {
        return new RecetaTable();
    }

    /**
     * Create an instance of {@link FacturaTable }
     * 
     */
    public FacturaTable createFacturaTable() {
        return new FacturaTable();
    }

    /**
     * Create an instance of {@link Cliente }
     * 
     */
    public Cliente createCliente() {
        return new Cliente();
    }

    /**
     * Create an instance of {@link ParametrosEmpresaTable }
     * 
     */
    public ParametrosEmpresaTable createParametrosEmpresaTable() {
        return new ParametrosEmpresaTable();
    }

    /**
     * Create an instance of {@link TemporalProdTable }
     * 
     */
    public TemporalProdTable createTemporalProdTable() {
        return new TemporalProdTable();
    }

    /**
     * Create an instance of {@link PrecioRecetaTable }
     * 
     */
    public PrecioRecetaTable createPrecioRecetaTable() {
        return new PrecioRecetaTable();
    }

    /**
     * Create an instance of {@link PrecioProductoTable }
     * 
     */
    public PrecioProductoTable createPrecioProductoTable() {
        return new PrecioProductoTable();
    }

    /**
     * Create an instance of {@link TemporalRecTable }
     * 
     */
    public TemporalRecTable createTemporalRecTable() {
        return new TemporalRecTable();
    }

    /**
     * Create an instance of {@link ProductoTable }
     * 
     */
    public ProductoTable createProductoTable() {
        return new ProductoTable();
    }

    /**
     * Create an instance of {@link Sede }
     * 
     */
    public Sede createSede() {
        return new Sede();
    }

    /**
     * Create an instance of {@link PersonaUsuarioTable }
     * 
     */
    public PersonaUsuarioTable createPersonaUsuarioTable() {
        return new PersonaUsuarioTable();
    }

    /**
     * Create an instance of {@link PantallaPrincipalFacTable }
     * 
     */
    public PantallaPrincipalFacTable createPantallaPrincipalFacTable() {
        return new PantallaPrincipalFacTable();
    }

    /**
     * Create an instance of {@link DetProdFacturaTable }
     * 
     */
    public DetProdFacturaTable createDetProdFacturaTable() {
        return new DetProdFacturaTable();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFacturas }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.codesoftware.com.co/", name = "getFacturas")
    public JAXBElement<GetFacturas> createGetFacturas(GetFacturas value) {
        return new JAXBElement<GetFacturas>(_GetFacturas_QNAME, GetFacturas.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link FindExistsForSedeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.codesoftware.com.co/", name = "findExistsForSedeResponse")
    public JAXBElement<FindExistsForSedeResponse> createFindExistsForSedeResponse(FindExistsForSedeResponse value) {
        return new JAXBElement<FindExistsForSedeResponse>(_FindExistsForSedeResponse_QNAME, FindExistsForSedeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFacturaForId }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.codesoftware.com.co/", name = "getFacturaForId")
    public JAXBElement<GetFacturaForId> createGetFacturaForId(GetFacturaForId value) {
        return new JAXBElement<GetFacturaForId>(_GetFacturaForId_QNAME, GetFacturaForId.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetParamsEmpresaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.codesoftware.com.co/", name = "getParamsEmpresaResponse")
    public JAXBElement<GetParamsEmpresaResponse> createGetParamsEmpresaResponse(GetParamsEmpresaResponse value) {
        return new JAXBElement<GetParamsEmpresaResponse>(_GetParamsEmpresaResponse_QNAME, GetParamsEmpresaResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetClientesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.codesoftware.com.co/", name = "getClientesResponse")
    public JAXBElement<GetClientesResponse> createGetClientesResponse(GetClientesResponse value) {
        return new JAXBElement<GetClientesResponse>(_GetClientesResponse_QNAME, GetClientesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CambiaClaveUsuario }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.codesoftware.com.co/", name = "cambiaClaveUsuario")
    public JAXBElement<CambiaClaveUsuario> createCambiaClaveUsuario(CambiaClaveUsuario value) {
        return new JAXBElement<CambiaClaveUsuario>(_CambiaClaveUsuario_QNAME, CambiaClaveUsuario.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProductForCode }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.codesoftware.com.co/", name = "getProductForCode")
    public JAXBElement<GetProductForCode> createGetProductForCode(GetProductForCode value) {
        return new JAXBElement<GetProductForCode>(_GetProductForCode_QNAME, GetProductForCode.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProductForCodeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.codesoftware.com.co/", name = "getProductForCodeResponse")
    public JAXBElement<GetProductForCodeResponse> createGetProductForCodeResponse(GetProductForCodeResponse value) {
        return new JAXBElement<GetProductForCodeResponse>(_GetProductForCodeResponse_QNAME, GetProductForCodeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRecetas }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.codesoftware.com.co/", name = "getRecetas")
    public JAXBElement<GetRecetas> createGetRecetas(GetRecetas value) {
        return new JAXBElement<GetRecetas>(_GetRecetas_QNAME, GetRecetas.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRecetaForcode }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.codesoftware.com.co/", name = "getRecetaForcode")
    public JAXBElement<GetRecetaForcode> createGetRecetaForcode(GetRecetaForcode value) {
        return new JAXBElement<GetRecetaForcode>(_GetRecetaForcode_QNAME, GetRecetaForcode.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUsersResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.codesoftware.com.co/", name = "getUsersResponse")
    public JAXBElement<GetUsersResponse> createGetUsersResponse(GetUsersResponse value) {
        return new JAXBElement<GetUsersResponse>(_GetUsersResponse_QNAME, GetUsersResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFacturasResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.codesoftware.com.co/", name = "getFacturasResponse")
    public JAXBElement<GetFacturasResponse> createGetFacturasResponse(GetFacturasResponse value) {
        return new JAXBElement<GetFacturasResponse>(_GetFacturasResponse_QNAME, GetFacturasResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CambiaClaveUsuarioResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.codesoftware.com.co/", name = "cambiaClaveUsuarioResponse")
    public JAXBElement<CambiaClaveUsuarioResponse> createCambiaClaveUsuarioResponse(CambiaClaveUsuarioResponse value) {
        return new JAXBElement<CambiaClaveUsuarioResponse>(_CambiaClaveUsuarioResponse_QNAME, CambiaClaveUsuarioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Facturar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.codesoftware.com.co/", name = "facturar")
    public JAXBElement<Facturar> createFacturar(Facturar value) {
        return new JAXBElement<Facturar>(_Facturar_QNAME, Facturar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDishesPrincipalScreenResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.codesoftware.com.co/", name = "getDishesPrincipalScreenResponse")
    public JAXBElement<GetDishesPrincipalScreenResponse> createGetDishesPrincipalScreenResponse(GetDishesPrincipalScreenResponse value) {
        return new JAXBElement<GetDishesPrincipalScreenResponse>(_GetDishesPrincipalScreenResponse_QNAME, GetDishesPrincipalScreenResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetClienteXCedula }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.codesoftware.com.co/", name = "getClienteXCedula")
    public JAXBElement<GetClienteXCedula> createGetClienteXCedula(GetClienteXCedula value) {
        return new JAXBElement<GetClienteXCedula>(_GetClienteXCedula_QNAME, GetClienteXCedula.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindExistsForSede }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.codesoftware.com.co/", name = "findExistsForSede")
    public JAXBElement<FindExistsForSede> createFindExistsForSede(FindExistsForSede value) {
        return new JAXBElement<FindExistsForSede>(_FindExistsForSede_QNAME, FindExistsForSede.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProductPrincipalScreen }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.codesoftware.com.co/", name = "getProductPrincipalScreen")
    public JAXBElement<GetProductPrincipalScreen> createGetProductPrincipalScreen(GetProductPrincipalScreen value) {
        return new JAXBElement<GetProductPrincipalScreen>(_GetProductPrincipalScreen_QNAME, GetProductPrincipalScreen.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRecetasResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.codesoftware.com.co/", name = "getRecetasResponse")
    public JAXBElement<GetRecetasResponse> createGetRecetasResponse(GetRecetasResponse value) {
        return new JAXBElement<GetRecetasResponse>(_GetRecetasResponse_QNAME, GetRecetasResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProductPrincipalScreenResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.codesoftware.com.co/", name = "getProductPrincipalScreenResponse")
    public JAXBElement<GetProductPrincipalScreenResponse> createGetProductPrincipalScreenResponse(GetProductPrincipalScreenResponse value) {
        return new JAXBElement<GetProductPrincipalScreenResponse>(_GetProductPrincipalScreenResponse_QNAME, GetProductPrincipalScreenResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRecetaForcodeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.codesoftware.com.co/", name = "getRecetaForcodeResponse")
    public JAXBElement<GetRecetaForcodeResponse> createGetRecetaForcodeResponse(GetRecetaForcodeResponse value) {
        return new JAXBElement<GetRecetaForcodeResponse>(_GetRecetaForcodeResponse_QNAME, GetRecetaForcodeResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProductsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.codesoftware.com.co/", name = "getProductsResponse")
    public JAXBElement<GetProductsResponse> createGetProductsResponse(GetProductsResponse value) {
        return new JAXBElement<GetProductsResponse>(_GetProductsResponse_QNAME, GetProductsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetParamsEmpresa }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.codesoftware.com.co/", name = "getParamsEmpresa")
    public JAXBElement<GetParamsEmpresa> createGetParamsEmpresa(GetParamsEmpresa value) {
        return new JAXBElement<GetParamsEmpresa>(_GetParamsEmpresa_QNAME, GetParamsEmpresa.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FacturarResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.codesoftware.com.co/", name = "facturarResponse")
    public JAXBElement<FacturarResponse> createFacturarResponse(FacturarResponse value) {
        return new JAXBElement<FacturarResponse>(_FacturarResponse_QNAME, FacturarResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetClienteXCedulaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.codesoftware.com.co/", name = "getClienteXCedulaResponse")
    public JAXBElement<GetClienteXCedulaResponse> createGetClienteXCedulaResponse(GetClienteXCedulaResponse value) {
        return new JAXBElement<GetClienteXCedulaResponse>(_GetClienteXCedulaResponse_QNAME, GetClienteXCedulaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUsers }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.codesoftware.com.co/", name = "getUsers")
    public JAXBElement<GetUsers> createGetUsers(GetUsers value) {
        return new JAXBElement<GetUsers>(_GetUsers_QNAME, GetUsers.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindProductosAndDishesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.codesoftware.com.co/", name = "findProductosAndDishesResponse")
    public JAXBElement<FindProductosAndDishesResponse> createFindProductosAndDishesResponse(FindProductosAndDishesResponse value) {
        return new JAXBElement<FindProductosAndDishesResponse>(_FindProductosAndDishesResponse_QNAME, FindProductosAndDishesResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link FindProductosAndDishes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.codesoftware.com.co/", name = "findProductosAndDishes")
    public JAXBElement<FindProductosAndDishes> createFindProductosAndDishes(FindProductosAndDishes value) {
        return new JAXBElement<FindProductosAndDishes>(_FindProductosAndDishes_QNAME, FindProductosAndDishes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFacturaForIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.codesoftware.com.co/", name = "getFacturaForIdResponse")
    public JAXBElement<GetFacturaForIdResponse> createGetFacturaForIdResponse(GetFacturaForIdResponse value) {
        return new JAXBElement<GetFacturaForIdResponse>(_GetFacturaForIdResponse_QNAME, GetFacturaForIdResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDishesPrincipalScreen }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.codesoftware.com.co/", name = "getDishesPrincipalScreen")
    public JAXBElement<GetDishesPrincipalScreen> createGetDishesPrincipalScreen(GetDishesPrincipalScreen value) {
        return new JAXBElement<GetDishesPrincipalScreen>(_GetDishesPrincipalScreen_QNAME, GetDishesPrincipalScreen.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserForUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.codesoftware.com.co/", name = "getUserForUser")
    public JAXBElement<GetUserForUser> createGetUserForUser(GetUserForUser value) {
        return new JAXBElement<GetUserForUser>(_GetUserForUser_QNAME, GetUserForUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProducts }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.codesoftware.com.co/", name = "getProducts")
    public JAXBElement<GetProducts> createGetProducts(GetProducts value) {
        return new JAXBElement<GetProducts>(_GetProducts_QNAME, GetProducts.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserForUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.codesoftware.com.co/", name = "getUserForUserResponse")
    public JAXBElement<GetUserForUserResponse> createGetUserForUserResponse(GetUserForUserResponse value) {
        return new JAXBElement<GetUserForUserResponse>(_GetUserForUserResponse_QNAME, GetUserForUserResponse.class, null, value);
    }

}
