package co.com.codesoftware.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import co.com.codesoftware.logic.SearchTopLogic;
import co.com.codesoftware.server.Cliente;

@ManagedBean
@ViewScoped
public class TopBean implements Serializable{
	private List<Cliente> clientes;
	private List<Cliente> clientesFilter;

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

}
