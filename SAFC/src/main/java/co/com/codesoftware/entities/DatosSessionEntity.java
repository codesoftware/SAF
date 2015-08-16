package co.com.codesoftware.entities;

import java.io.Serializable;
import java.util.List;

import co.com.codesoftware.server.ParametrosEmpresaTable;
import co.com.codesoftware.server.UsuarioTable;

public class DatosSessionEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	private List<ParametrosEmpresaTable> dataCompany;
	private UsuarioTable dataUser;
	
	public List<ParametrosEmpresaTable> getDataCompany() {
		return dataCompany;
	}
	public void setDataCompany(List<ParametrosEmpresaTable> dataCompany) {
		this.dataCompany = dataCompany;
	}
	public UsuarioTable getDataUser() {
		return dataUser;
	}
	public void setDataUser(UsuarioTable dataUser) {
		this.dataUser = dataUser;
	}
	
	
	

}
