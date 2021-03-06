package co.com.codesoftware.logic;

import co.com.codesoftware.server.Cliente;
import co.com.codesoftware.server.SAFWS;
import co.com.codesoftware.server.SAFWSService;

public class ClienteLogic {

	/**
	 * Funcion que consulta el cliente generico
	 * @return
	 */
	public Cliente getDefaultClient() {
		Cliente cliente = new Cliente();
		SAFWSService service = new SAFWSService();
		SAFWS port = service.getSAFWSPort();
		cliente=port.getClienteXCedula(0);
		return cliente;
	}
	/**
	 * Funcion con la cual actualizo un cliente
	 * @param cliente
	 * @return
	 */
	public boolean updateCliente(Cliente cliente){
		boolean valida;
		try {
			SAFWSService service = new SAFWSService();
			SAFWS port = service.getSAFWSPort();
			valida = port.updateCliente(cliente);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return valida;
	}

}
