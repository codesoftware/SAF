package co.com.codesoftware.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import co.com.codesoftware.entities.ClienteEntity;
import co.com.codesoftware.entities.DatosSessionEntity;
import co.com.codesoftware.entities.GenericProductEntity;
import co.com.codesoftware.logic.ClienteLogic;
import co.com.codesoftware.logic.ProductsLogic;
import co.com.codesoftware.logic.RecetasLogic;
import co.com.codesoftware.logic.SearchTopLogic;
import co.com.codesoftware.server.Cliente;
import co.com.codesoftware.server.PantallaPrincipalFacTable;
import co.com.codesoftware.server.RecetaTable;

@ManagedBean
@ViewScoped
public class ClienteBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ClienteEntity cliente;
	private List<Cliente> clientes;
	private List<Cliente> clientesFilter;
	private Long clienteId;
	private List<PantallaPrincipalFacTable> recetas;
	private List<PantallaPrincipalFacTable> productos;
	private List<RecetaTable> dishes;
	private List<RecetaTable> dishesFilter;
	private GenericProductEntity prod;
	private DatosSessionEntity entitySession;

	@PostConstruct
	/*
	 * Metodo en el cual carga todo lo que se necesita al inicio
	 */
	public void init() {
		try {
			FacesMessage message = null;
			FacesContext context = FacesContext.getCurrentInstance();
			this.entitySession = (DatosSessionEntity) context.getExternalContext().getSessionMap().get("dataSession");
			if (entitySession == null) {
				message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Esta intentando a un sitio no permitido porfavor realice el login primero");
				context.getExternalContext().redirect("../index.jsf");
			} else {
				RecetasLogic logic = new RecetasLogic();
				ProductsLogic logicPrd = new ProductsLogic();
				this.productos = logicPrd.getEspecialProduct(entitySession.getDataUser().getSede());
				this.recetas = logic.getEspecialReceta(entitySession.getDataUser().getSede());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<RecetaTable> getDishesFilter() {
		return dishesFilter;
	}

	public void setDishesFilter(List<RecetaTable> dishesFilter) {
		this.dishesFilter = dishesFilter;
	}

	public List<RecetaTable> getDishes() {
		return dishes;
	}

	public void setDishes(List<RecetaTable> dishes) {
		this.dishes = dishes;
	}

	public List<PantallaPrincipalFacTable> getProductos() {
		return productos;
	}

	public void setProductos(List<PantallaPrincipalFacTable> productos) {
		this.productos = productos;
	}

	public List<PantallaPrincipalFacTable> getRecetas() {
		return recetas;
	}

	public void setRecetas(List<PantallaPrincipalFacTable> recetas) {
		this.recetas = recetas;
	}

	public ClienteBean() {

		cliente = new ClienteEntity();
	}

	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}

	public ClienteEntity getCliente() {
		return cliente;
	}

	public void setCliente(ClienteEntity cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public List<Cliente> getClientesFilter() {
		return clientesFilter;
	}

	public void setClientesFilter(List<Cliente> clientesFilter) {
		this.clientesFilter = clientesFilter;
	}

	public GenericProductEntity getProd() {
		return prod;
	}

	public void setProd(GenericProductEntity prod) {
		this.prod = prod;
	}

	/**
	 * Funcion encargada de insertar un cliente en la base de datos del sistema
	 */
	public void addCliente() {
		SearchTopLogic logic = new SearchTopLogic();
		this.clienteId = logic.getLogicAddClient(setData(cliente));
		if (this.clienteId != null) {
			this.cliente.setId(clienteId);
			RequestContext.getCurrentInstance().execute("PF('insertClient').hide()");
		} else {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "No Inserto Correctamente", "Error");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}

	}

	public Cliente setData(ClienteEntity entity) {
		Cliente cliente = new Cliente();
		cliente.setId(null);
		cliente.setApellidos(entity.getApellido());
		cliente.setCedula(entity.getCedula());
		cliente.setCorreo(entity.getCorreo());
		cliente.setNombres(entity.getNombre());
		cliente.setTelefono(entity.getTelefono());
		cliente.setDireccion(entity.getDireccion());
		return cliente;
	}

	public Cliente setDataWithId(ClienteEntity entity) {
		Cliente cliente = new Cliente();
		cliente.setId(entity.getId());
		cliente.setApellidos(entity.getApellido());
		cliente.setCedula(entity.getCedula());
		cliente.setCorreo(entity.getCorreo());
		cliente.setNombres(entity.getNombre());
		cliente.setTelefono(entity.getTelefono());
		cliente.setDireccion(entity.getDireccion());
		return cliente;
	}

	public ClienteEntity setDataEntity(Cliente entity) {
		ClienteEntity cliente = new ClienteEntity();
		cliente.setId(entity.getId());
		cliente.setApellido(entity.getApellidos());
		cliente.setCedula(entity.getCedula());
		cliente.setCorreo(entity.getCorreo());
		cliente.setNombre(entity.getNombres());
		cliente.setTelefono(entity.getTelefono());
		cliente.setDireccion(entity.getDireccion());
		return cliente;
	}

	/**
	 * Funcion encargada de Buscar los cliente del sistema
	 */
	public void buscaClientes() {
		try {
			clientes = new ArrayList<Cliente>();
			SearchTopLogic logic = new SearchTopLogic();
			clientes = logic.searchClient();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Funcion con la cual selecciono un cliente
	 */
	public void seleccionarCliente(Cliente cliente) {
		try {
			this.cliente = setDataEntity(cliente);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setDataDishes() {
		try {
			RecetasLogic logic = new RecetasLogic();
			this.dishes = logic.getReceta();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * metodo que consulta el cliente Generico
	 */

	public void genericClient() {
		ClienteLogic logic = new ClienteLogic();
		this.cliente = setDataEntity(logic.getDefaultClient());

	}

	/**
	 * Funcion con la cual se setea el cliente para prepararlo para actualizarlo
	 * 
	 * @param cliente
	 */
	public void preUpdCliente(Cliente cliente) {
		try {
			this.cliente = setDataEntity(cliente);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Funcion con la cual actualizo el cliente
	 * 
	 * @param cliente
	 */
	public void updatecliente() {
		try {
			ClienteLogic logic = new ClienteLogic();
			boolean valida = logic.updateCliente(setDataWithId(this.cliente));
			if (valida) {
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Ok", "Cliente Actualizado correctamente");
				FacesContext.getCurrentInstance().addMessage(null, message);
				RequestContext.getCurrentInstance().execute("PF('actualizarClient').hide()");
			} else {
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al actualizar el Cliente", "Error");
				FacesContext.getCurrentInstance().addMessage(null, message);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public DatosSessionEntity getEntitySession() {
		return entitySession;
	}

	public void setEntitySession(DatosSessionEntity entitySession) {
		this.entitySession = entitySession;
	}
}
