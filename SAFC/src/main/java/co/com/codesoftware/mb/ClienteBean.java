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
import co.com.codesoftware.logic.ProductsLogic;
import co.com.codesoftware.logic.RecetasLogic;
import co.com.codesoftware.logic.SearchTopLogic;
import co.com.codesoftware.server.Cliente;
import co.com.codesoftware.server.ProductoTable;
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
	private List<RecetaTable> recetas;
	private List<ProductoTable> productos;
	private List<RecetaTable> dishes;
	private List<RecetaTable> dishesFilter;

	@PostConstruct
	/*
	 * Metodo en el cual carga todo lo que se necesita al inicio
	 */
	public void init() {
		RecetasLogic logic = new RecetasLogic();
		ProductsLogic logicPrd = new ProductsLogic();
		this.productos = logicPrd.getEspecialProduct();
		this.recetas = logic.getEspecialReceta();
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

	public List<ProductoTable> getProductos() {
		return productos;
	}

	public void setProductos(List<ProductoTable> productos) {
		this.productos = productos;
	}

	public List<RecetaTable> getRecetas() {
		return recetas;
	}

	public void setRecetas(List<RecetaTable> recetas) {
		this.recetas = recetas;
	}

	public ClienteBean() {
		super();
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

	/**
	 * Funcion encargada de insertar un cliente en la base de datos del sistema
	 */
	public void addCliente() {
		SearchTopLogic logic = new SearchTopLogic();
		this.clienteId = logic.getLogicAddClient(setData(cliente));
		if (this.clienteId != null) {
			this.cliente.setId(clienteId);
			RequestContext.getCurrentInstance().execute(
					"PF('insertClient').hide()");
		} else {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "No Inserto Correctamente",
					"Error");
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
		return cliente;
	}

	/**
	 * Funcion encargada de Buscar los cliente del sistema
	 */
	public void buscaClientes() {
		try {
			System.out.println("Entro por aqui");
			clientes = new ArrayList<Cliente>();
			SearchTopLogic logic = new SearchTopLogic();
			clientes = logic.searchClient();
		} catch (Exception e) {
			// TODO: handle exception
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
}
