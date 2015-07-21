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
	
	public Cliente getLogicClient(Long param){
		SAFWSService service = new SAFWSService();
        SAFWS port = service.getSAFWSPort();
        Cliente response = new Cliente();
        response.setCedula(new Long(1012));
        response.setNombres("John");
        return response;
	}
}
