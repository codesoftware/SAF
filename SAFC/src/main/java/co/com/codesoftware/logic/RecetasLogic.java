package co.com.codesoftware.logic;

import java.util.ArrayList;
import java.util.List;

import co.com.codesoftware.entities.GenericProductEntity;
import co.com.codesoftware.server.PantallaPrincipalFacTable;
import co.com.codesoftware.server.ProductoTable;
import co.com.codesoftware.server.RecetaTable;
import co.com.codesoftware.server.SAFWS;
import co.com.codesoftware.server.SAFWSService;
import co.com.codesoftware.utilities.ImagesUtilities;

public class RecetasLogic {

	/**
	 * Metodo que consulta las recetas de la pantalla principal
	 * @return
	 */
	public List<PantallaPrincipalFacTable> getEspecialReceta(Integer sede_sede) {
		List<PantallaPrincipalFacTable> list = new ArrayList<PantallaPrincipalFacTable>();
		try {
			SAFWSService service = new SAFWSService();
			SAFWS port = service.getSAFWSPort();
			list = port.getDishesPrincipalScreen(sede_sede);
			list = getImage(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<RecetaTable> getReceta() {
		List<RecetaTable> list = new ArrayList<RecetaTable>();
		SAFWSService service = new SAFWSService();
		SAFWS port = service.getSAFWSPort();
		list = port.getRecetas(1);
		return list;

	}
	
	public GenericProductEntity getProductXCode(String code,int cantidad){
		RecetaTable receta = null;
		GenericProductEntity result = new GenericProductEntity();
		try {
			receta = new RecetaTable();
			SAFWSService service = new SAFWSService();
			SAFWS port = service.getSAFWSPort();
			//receta = port.getProductForCode(code,1);
			result = setGenericProduct(result, receta,cantidad);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public GenericProductEntity setGenericProduct(GenericProductEntity result,RecetaTable product,int cantidad){
		result.setCode(product.getCodigo());
		result.setId(product.getId());
		result.setName(product.getNombre());	
		result.setAmount(cantidad);
		result.setPrice(String.valueOf(product.getPrecios().get(0).getPrecio()));
		return result;
	}
	
	public  List<PantallaPrincipalFacTable> getImage(List<PantallaPrincipalFacTable> list){
		ImagesUtilities ut = new ImagesUtilities();
	
		for(int i=0;i<list.size();i++){
			if(ut.encodeB64ToImage(list.get(i).getImagen(),list.get(i).getNombre()+"."+list.get(i).getExtension())){
				list.get(i).setRuta(list.get(i).getCodigo()+"."+list.get(i).getExtension());
			}
		}
		return list;
	}
	
}
