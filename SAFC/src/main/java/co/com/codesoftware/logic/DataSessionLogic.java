package co.com.codesoftware.logic;

import java.util.ArrayList;
import java.util.List;

import co.com.codesoftware.server.ParametrosEmpresaTable;
import co.com.codesoftware.server.SAFWS;
import co.com.codesoftware.server.SAFWSService;
import co.com.codesoftware.server.UsuarioTable;

public class DataSessionLogic {	

	// Metodo que consulta los datos empresariales para poderlos mostrar en la
	// factura
	public List<ParametrosEmpresaTable> getDataCompany() {
		List<ParametrosEmpresaTable> result = new ArrayList<ParametrosEmpresaTable>();
		SAFWSService service = new SAFWSService();
		SAFWS port = service.getSAFWSPort();
		result = port.getParamsEmpresa();
		return result;
	}

	// Metodo que consulta los datos del usuario logueado
	public UsuarioTable getDataUser(String user) {
		UsuarioTable result = new UsuarioTable();
		SAFWSService service = new SAFWSService();
		SAFWS port = service.getSAFWSPort();
		result = port.getUserForUser(user);
		return result;
	}
}
