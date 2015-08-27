
package co.com.codesoftware.server;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "SAFWS", targetNamespace = "http://server.codesoftware.com.co/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface SAFWS {


    /**
     * 
     * @return
     *     returns java.util.List<co.com.codesoftware.server.Sede>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getSedes", targetNamespace = "http://server.codesoftware.com.co/", className = "co.com.codesoftware.server.GetSedes")
    @ResponseWrapper(localName = "getSedesResponse", targetNamespace = "http://server.codesoftware.com.co/", className = "co.com.codesoftware.server.GetSedesResponse")
    @Action(input = "http://server.codesoftware.com.co/SAFWS/getSedesRequest", output = "http://server.codesoftware.com.co/SAFWS/getSedesResponse")
    public List<Sede> getSedes();

    /**
     * 
     * @return
     *     returns java.util.List<co.com.codesoftware.server.Cliente>
     */
    @WebMethod
    @WebResult(name = "Cliente", targetNamespace = "")
    @RequestWrapper(localName = "getClientes", targetNamespace = "http://server.codesoftware.com.co/", className = "co.com.codesoftware.server.GetClientes")
    @ResponseWrapper(localName = "getClientesResponse", targetNamespace = "http://server.codesoftware.com.co/", className = "co.com.codesoftware.server.GetClientesResponse")
    @Action(input = "http://server.codesoftware.com.co/SAFWS/getClientesRequest", output = "http://server.codesoftware.com.co/SAFWS/getClientesResponse")
    public List<Cliente> getClientes();

    /**
     * 
     * @param cedula
     * @return
     *     returns co.com.codesoftware.server.Cliente
     */
    @WebMethod
    @WebResult(name = "Cliente", targetNamespace = "")
    @RequestWrapper(localName = "getClienteXCedula", targetNamespace = "http://server.codesoftware.com.co/", className = "co.com.codesoftware.server.GetClienteXCedula")
    @ResponseWrapper(localName = "getClienteXCedulaResponse", targetNamespace = "http://server.codesoftware.com.co/", className = "co.com.codesoftware.server.GetClienteXCedulaResponse")
    @Action(input = "http://server.codesoftware.com.co/SAFWS/getClienteXCedulaRequest", output = "http://server.codesoftware.com.co/SAFWS/getClienteXCedulaResponse")
    public Cliente getClienteXCedula(
        @WebParam(name = "cedula", targetNamespace = "")
        long cedula);

    /**
     * 
     * @param cliente
     * @return
     *     returns java.lang.Long
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "addCliente", targetNamespace = "http://server.codesoftware.com.co/", className = "co.com.codesoftware.server.AddCliente")
    @ResponseWrapper(localName = "addClienteResponse", targetNamespace = "http://server.codesoftware.com.co/", className = "co.com.codesoftware.server.AddClienteResponse")
    @Action(input = "http://server.codesoftware.com.co/SAFWS/addClienteRequest", output = "http://server.codesoftware.com.co/SAFWS/addClienteResponse")
    public Long addCliente(
        @WebParam(name = "Cliente", targetNamespace = "")
        Cliente cliente);

    /**
     * 
     * @param cliente
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "updateCliente", targetNamespace = "http://server.codesoftware.com.co/", className = "co.com.codesoftware.server.UpdateCliente")
    @ResponseWrapper(localName = "updateClienteResponse", targetNamespace = "http://server.codesoftware.com.co/", className = "co.com.codesoftware.server.UpdateClienteResponse")
    @Action(input = "http://server.codesoftware.com.co/SAFWS/updateClienteRequest", output = "http://server.codesoftware.com.co/SAFWS/updateClienteResponse")
    public boolean updateCliente(
        @WebParam(name = "Cliente", targetNamespace = "")
        Cliente cliente);

    /**
     * 
     * @param sedeSede
     * @return
     *     returns java.util.List<co.com.codesoftware.server.RecetaTable>
     */
    @WebMethod
    @WebResult(name = "RecetaTable", targetNamespace = "")
    @RequestWrapper(localName = "getRecetas", targetNamespace = "http://server.codesoftware.com.co/", className = "co.com.codesoftware.server.GetRecetas")
    @ResponseWrapper(localName = "getRecetasResponse", targetNamespace = "http://server.codesoftware.com.co/", className = "co.com.codesoftware.server.GetRecetasResponse")
    @Action(input = "http://server.codesoftware.com.co/SAFWS/getRecetasRequest", output = "http://server.codesoftware.com.co/SAFWS/getRecetasResponse")
    public List<RecetaTable> getRecetas(
        @WebParam(name = "sede_sede", targetNamespace = "")
        Integer sedeSede);

    /**
     * 
     * @param sedeSede
     * @return
     *     returns java.util.List<co.com.codesoftware.server.ProductoTable>
     */
    @WebMethod
    @WebResult(name = "ProductoTable", targetNamespace = "")
    @RequestWrapper(localName = "getProducts", targetNamespace = "http://server.codesoftware.com.co/", className = "co.com.codesoftware.server.GetProducts")
    @ResponseWrapper(localName = "getProductsResponse", targetNamespace = "http://server.codesoftware.com.co/", className = "co.com.codesoftware.server.GetProductsResponse")
    @Action(input = "http://server.codesoftware.com.co/SAFWS/getProductsRequest", output = "http://server.codesoftware.com.co/SAFWS/getProductsResponse")
    public List<ProductoTable> getProducts(
        @WebParam(name = "sede_sede", targetNamespace = "")
        Integer sedeSede);

    /**
     * 
     * @param sedeSede
     * @param dskaCod
     * @return
     *     returns co.com.codesoftware.server.ProductoTable
     */
    @WebMethod
    @WebResult(name = "ProductoTable", targetNamespace = "")
    @RequestWrapper(localName = "getProductForCode", targetNamespace = "http://server.codesoftware.com.co/", className = "co.com.codesoftware.server.GetProductForCode")
    @ResponseWrapper(localName = "getProductForCodeResponse", targetNamespace = "http://server.codesoftware.com.co/", className = "co.com.codesoftware.server.GetProductForCodeResponse")
    @Action(input = "http://server.codesoftware.com.co/SAFWS/getProductForCodeRequest", output = "http://server.codesoftware.com.co/SAFWS/getProductForCodeResponse")
    public ProductoTable getProductForCode(
        @WebParam(name = "dska_cod", targetNamespace = "")
        String dskaCod,
        @WebParam(name = "sede_sede", targetNamespace = "")
        Integer sedeSede);

    /**
     * 
     * @param sedeSede
     * @return
     *     returns java.util.List<co.com.codesoftware.server.PantallaPrincipalFacTable>
     */
    @WebMethod
    @WebResult(name = "PantallaPrincipalFactTable", targetNamespace = "")
    @RequestWrapper(localName = "getProductPrincipalScreen", targetNamespace = "http://server.codesoftware.com.co/", className = "co.com.codesoftware.server.GetProductPrincipalScreen")
    @ResponseWrapper(localName = "getProductPrincipalScreenResponse", targetNamespace = "http://server.codesoftware.com.co/", className = "co.com.codesoftware.server.GetProductPrincipalScreenResponse")
    @Action(input = "http://server.codesoftware.com.co/SAFWS/getProductPrincipalScreenRequest", output = "http://server.codesoftware.com.co/SAFWS/getProductPrincipalScreenResponse")
    public List<PantallaPrincipalFacTable> getProductPrincipalScreen(
        @WebParam(name = "sede_sede", targetNamespace = "")
        Integer sedeSede);

    /**
     * 
     * @param sedeSede
     * @return
     *     returns java.util.List<co.com.codesoftware.server.PantallaPrincipalFacTable>
     */
    @WebMethod
    @WebResult(name = "PantallaPrincipalFactTable", targetNamespace = "")
    @RequestWrapper(localName = "getDishesPrincipalScreen", targetNamespace = "http://server.codesoftware.com.co/", className = "co.com.codesoftware.server.GetDishesPrincipalScreen")
    @ResponseWrapper(localName = "getDishesPrincipalScreenResponse", targetNamespace = "http://server.codesoftware.com.co/", className = "co.com.codesoftware.server.GetDishesPrincipalScreenResponse")
    @Action(input = "http://server.codesoftware.com.co/SAFWS/getDishesPrincipalScreenRequest", output = "http://server.codesoftware.com.co/SAFWS/getDishesPrincipalScreenResponse")
    public List<PantallaPrincipalFacTable> getDishesPrincipalScreen(
        @WebParam(name = "sede_sede", targetNamespace = "")
        Integer sedeSede);

    /**
     * 
     * @param tiusUsuario
     * @return
     *     returns co.com.codesoftware.server.UsuarioTable
     */
    @WebMethod
    @WebResult(name = "UsuarioTable", targetNamespace = "")
    @RequestWrapper(localName = "getUserForUser", targetNamespace = "http://server.codesoftware.com.co/", className = "co.com.codesoftware.server.GetUserForUser")
    @ResponseWrapper(localName = "getUserForUserResponse", targetNamespace = "http://server.codesoftware.com.co/", className = "co.com.codesoftware.server.GetUserForUserResponse")
    @Action(input = "http://server.codesoftware.com.co/SAFWS/getUserForUserRequest", output = "http://server.codesoftware.com.co/SAFWS/getUserForUserResponse")
    public UsuarioTable getUserForUser(
        @WebParam(name = "tius_usuario", targetNamespace = "")
        String tiusUsuario);

    /**
     * 
     * @param sedeSede
     * @param dskaDska
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(name = "existencia", targetNamespace = "")
    @RequestWrapper(localName = "findExistsForSede", targetNamespace = "http://server.codesoftware.com.co/", className = "co.com.codesoftware.server.FindExistsForSede")
    @ResponseWrapper(localName = "findExistsForSedeResponse", targetNamespace = "http://server.codesoftware.com.co/", className = "co.com.codesoftware.server.FindExistsForSedeResponse")
    @Action(input = "http://server.codesoftware.com.co/SAFWS/findExistsForSedeRequest", output = "http://server.codesoftware.com.co/SAFWS/findExistsForSedeResponse")
    public String findExistsForSede(
        @WebParam(name = "sede_sede", targetNamespace = "")
        String sedeSede,
        @WebParam(name = "dska_dska", targetNamespace = "")
        String dskaDska);

    /**
     * 
     * @param facturacion
     * @return
     *     returns co.com.codesoftware.server.RespuestaFacturacion
     */
    @WebMethod
    @WebResult(name = "respuestaFacturacon", targetNamespace = "")
    @RequestWrapper(localName = "facturar", targetNamespace = "http://server.codesoftware.com.co/", className = "co.com.codesoftware.server.Facturar")
    @ResponseWrapper(localName = "facturarResponse", targetNamespace = "http://server.codesoftware.com.co/", className = "co.com.codesoftware.server.FacturarResponse")
    @Action(input = "http://server.codesoftware.com.co/SAFWS/facturarRequest", output = "http://server.codesoftware.com.co/SAFWS/facturarResponse")
    public RespuestaFacturacion facturar(
        @WebParam(name = "Facturacion", targetNamespace = "")
        Facturacion facturacion);

    /**
     * 
     * @return
     *     returns java.util.List<co.com.codesoftware.server.FacturaTable>
     */
    @WebMethod
    @WebResult(name = "listaFacturas", targetNamespace = "")
    @RequestWrapper(localName = "getFacturas", targetNamespace = "http://server.codesoftware.com.co/", className = "co.com.codesoftware.server.GetFacturas")
    @ResponseWrapper(localName = "getFacturasResponse", targetNamespace = "http://server.codesoftware.com.co/", className = "co.com.codesoftware.server.GetFacturasResponse")
    @Action(input = "http://server.codesoftware.com.co/SAFWS/getFacturasRequest", output = "http://server.codesoftware.com.co/SAFWS/getFacturasResponse")
    public List<FacturaTable> getFacturas();

    /**
     * 
     * @param idFactura
     * @return
     *     returns co.com.codesoftware.server.FacturaTable
     */
    @WebMethod
    @WebResult(name = "FacturaTable", targetNamespace = "")
    @RequestWrapper(localName = "getFacturaForId", targetNamespace = "http://server.codesoftware.com.co/", className = "co.com.codesoftware.server.GetFacturaForId")
    @ResponseWrapper(localName = "getFacturaForIdResponse", targetNamespace = "http://server.codesoftware.com.co/", className = "co.com.codesoftware.server.GetFacturaForIdResponse")
    @Action(input = "http://server.codesoftware.com.co/SAFWS/getFacturaForIdRequest", output = "http://server.codesoftware.com.co/SAFWS/getFacturaForIdResponse")
    public FacturaTable getFacturaForId(
        @WebParam(name = "idFactura", targetNamespace = "")
        int idFactura);

    /**
     * 
     * @return
     *     returns java.util.List<co.com.codesoftware.server.ParametrosEmpresaTable>
     */
    @WebMethod
    @WebResult(name = "parametros", targetNamespace = "")
    @RequestWrapper(localName = "getParamsEmpresa", targetNamespace = "http://server.codesoftware.com.co/", className = "co.com.codesoftware.server.GetParamsEmpresa")
    @ResponseWrapper(localName = "getParamsEmpresaResponse", targetNamespace = "http://server.codesoftware.com.co/", className = "co.com.codesoftware.server.GetParamsEmpresaResponse")
    @Action(input = "http://server.codesoftware.com.co/SAFWS/getParamsEmpresaRequest", output = "http://server.codesoftware.com.co/SAFWS/getParamsEmpresaResponse")
    public List<ParametrosEmpresaTable> getParamsEmpresa();

    /**
     * 
     * @return
     *     returns java.util.List<co.com.codesoftware.server.UsuarioTable>
     */
    @WebMethod
    @WebResult(name = "UsuarioTable", targetNamespace = "")
    @RequestWrapper(localName = "getUsers", targetNamespace = "http://server.codesoftware.com.co/", className = "co.com.codesoftware.server.GetUsers")
    @ResponseWrapper(localName = "getUsersResponse", targetNamespace = "http://server.codesoftware.com.co/", className = "co.com.codesoftware.server.GetUsersResponse")
    @Action(input = "http://server.codesoftware.com.co/SAFWS/getUsersRequest", output = "http://server.codesoftware.com.co/SAFWS/getUsersResponse")
    public List<UsuarioTable> getUsers();

    /**
     * 
     * @param password
     * @param nombre
     * @return
     *     returns java.util.List<java.lang.String>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "login", targetNamespace = "http://server.codesoftware.com.co/", className = "co.com.codesoftware.server.Login")
    @ResponseWrapper(localName = "loginResponse", targetNamespace = "http://server.codesoftware.com.co/", className = "co.com.codesoftware.server.LoginResponse")
    @Action(input = "http://server.codesoftware.com.co/SAFWS/loginRequest", output = "http://server.codesoftware.com.co/SAFWS/loginResponse")
    public List<String> login(
        @WebParam(name = "nombre", targetNamespace = "")
        String nombre,
        @WebParam(name = "password", targetNamespace = "")
        String password);

}
