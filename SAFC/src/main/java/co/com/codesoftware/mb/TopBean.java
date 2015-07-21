package co.com.codesoftware.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIData;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import co.com.codesoftware.logic.SearchTopLogic;
import co.com.codesoftware.server.Cliente;

@ManagedBean
@ViewScoped
public class TopBean implements Serializable{
	private UIData usersDataTable;
	private List<Cliente> clientes;
	private List<Cliente> clientesFilter;
	private Cliente cliente;
	

	public UIData getUsersDataTable() {
		return usersDataTable;
	}

	public void setUsersDataTable(UIData usersDataTable) {
		this.usersDataTable = usersDataTable;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
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

	@PostConstruct
	public void init() {
		clientes = new ArrayList<Cliente>();
		SearchTopLogic logic = new SearchTopLogic();
		clientes = logic.searchClient();

	}
	
	public void getClient(){
		final String idUserSelected = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idClient");
		Long id = Long.parseLong(idUserSelected);
		SearchTopLogic logic = new SearchTopLogic();
		cliente = logic.getLogicClient(id);
	}
	
	public void edit(ActionEvent event){
		System.out.println("User selected " + ((Cliente) usersDataTable.getRowData()));
	}
	
	

}
