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

public class ProductsLogic {
	/**
	 * Funcion que consulta los productos que apareceran en el home
	 * @return
	 */	
	public List<PantallaPrincipalFacTable> getEspecialProduct(){
		List<PantallaPrincipalFacTable> list = new ArrayList<PantallaPrincipalFacTable>();
		SAFWSService service = new SAFWSService();
		SAFWS port = service.getSAFWSPort();
		list = port.getProductPrincipalScreen(1);
		list = getImage(list);
		return list;
	}
	/**
	 * Funcion que consulta un producto por codigo y devuelve la entidad de este
	 * @param id
	 * @return
	 */
	
	public GenericProductEntity getProductXCode(String code,int cantidad){
		ProductoTable product = null;
		GenericProductEntity result = new GenericProductEntity();
		try {
			product = new ProductoTable();
			SAFWSService service = new SAFWSService();
			SAFWS port = service.getSAFWSPort();
			product = port.getProductForCode(code,1);
			result = setGenericProduct(result, product,cantidad);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public GenericProductEntity setGenericProduct(GenericProductEntity result,ProductoTable product,int cantidad){
		result.setCode(product.getCodigo());
		result.setId(product.getId());
		result.setName(product.getNombre());	
		result.setAmount(cantidad);
		result.setPrice(String.valueOf(product.getPrecios().get(0).getPrecio()));
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
			if(ut.encodeB64ToImage(list.get(i).getImagen(),list.get(i).getNombre()+".jpeg")){
				list.get(i).setRuta(list.get(i).getCodigo()+".jpeg");
			}
		}
		return list;
	}
	
	

}
