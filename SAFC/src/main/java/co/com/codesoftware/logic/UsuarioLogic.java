package co.com.codesoftware.logic;

import co.com.codesoftware.server.SAFWS;
import co.com.codesoftware.server.SAFWSService;
import co.com.codesoftware.server.UsuarioTable;

public class UsuarioLogic {
	/**
	 * Funcion la cual se encarga de llamar el Web Service para el cambio de
	 * contraseña
	 * 
	 * @return
	 */
	public boolean cambiaContrausuario(UsuarioTable usuario) {
		boolean rta = false;
		try {
			SAFWSService service = new SAFWSService();
			SAFWS port = service.getSAFWSPort();
			//rta = port.cambiaClaveUsuario(usuario);
		} catch (Exception e) {
			return false;
		}
		return rta;
	}

}
