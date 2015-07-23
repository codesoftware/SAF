package co.com.codesoftware.mb;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

import co.com.codesoftware.entities.ClienteEntity;

@ManagedBean
public class ClienteBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ClienteEntity cliente;
	

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

	public void insertarCliente() {
		System.out.println("Paso por aqui");
	}

}
