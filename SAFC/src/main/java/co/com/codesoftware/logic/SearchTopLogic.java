package co.com.codesoftware.logic;

import java.util.List;

import co.com.codesoftware.server.Cliente;
import co.com.codesoftware.server.SAFWS;
import co.com.codesoftware.server.SAFWSService;

public class SearchTopLogic {

	public List<Cliente> searchClient(){
		SAFWSService service = new SAFWSService();
        SAFWS port = service.getSAFWSPort();
        List<Cliente> listResponse = port.getClientes();
        return listResponse;
	}
}
