package co.com.codesoftware.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import co.com.codesoftware.entities.ClienteEntity;
import co.com.codesoftware.logic.SearchTopLogic;
import co.com.codesoftware.server.Cliente;

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

	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}

	public ClienteBean() {
		super();
		cliente = new ClienteEntity();
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

	public void addCliente() {
		SearchTopLogic logic = new SearchTopLogic();
		this.clienteId = logic.getLogicAddClient(setData(cliente));
		if (this.clienteId != null) {
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

}
