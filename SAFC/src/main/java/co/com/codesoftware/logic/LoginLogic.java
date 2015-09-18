package co.com.codesoftware.logic;

import java.util.List;

import co.com.codesoftware.server.SAFWS;
import co.com.codesoftware.server.SAFWSService;

public class LoginLogic {
	/**
	 * Metodo el cual consulta la operacion del webservice que muestra el
	 * resultado del logueo
	 * 
	 * @param user
	 * @param password
	 * @return
	 */
	public String login(String user, String password) {
		List<String> listResponse = null;
		try {
			SAFWSService service = new SAFWSService();
			SAFWS port = service.getSAFWSPort();
			listResponse = port.login(user, password);
		} catch (Exception e) {
			e.printStackTrace();
			return "Error_conexion";
		}
		return listResponse.get(0);
	}
	/**
	 * Metodo el cual valida si el usuario puede realizar facturacion o no
	 * @param idTius
	 * @return
	 */
	public boolean permisoFacturador(Long idTius ){
		try {
			SAFWSService service = new SAFWSService();
			SAFWS port = service.getSAFWSPort();
			return port.validaUsuarioFacturador(idTius);			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
