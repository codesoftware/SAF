package co.com.codesoftware.logic;

import java.util.ArrayList;
import java.util.List;

import co.com.codesoftware.entities.GenericProductEntity;
import co.com.codesoftware.server.PantallaPrincipalFacTable;
import co.com.codesoftware.server.RecetaTable;
import co.com.codesoftware.server.SAFWS;
import co.com.codesoftware.server.SAFWSService;

public class RecetasLogic {

	/**
	 * Metodo que consulta las recetas de la pantalla principal
	 * @return
	 */
	public List<PantallaPrincipalFacTable> getEspecialReceta() {
		List<PantallaPrincipalFacTable> list = new ArrayList<PantallaPrincipalFacTable>();
		SAFWSService service = new SAFWSService();
		SAFWS port = service.getSAFWSPort();
		list = port.getDishesPrincipalScreen();
		return list;
	}

	public List<RecetaTable> getReceta() {
		List<RecetaTable> list = new ArrayList<RecetaTable>();
		SAFWSService service = new SAFWSService();
		SAFWS port = service.getSAFWSPort();
		list = port.getRecetas(1);
		return list;

	}
	
	public GenericProductEntity setGenericProduct(GenericProductEntity result,RecetaTable product,int cantidad){
		result.setCode(product.getCodigo());
		result.setId(product.getId());
		result.setName(product.getNombre());	
		result.setAmount(cantidad);
		result.setPrice(String.valueOf(product.getPrecios().get(0).getPrecio()));
		return result;
	}
	
}
