package co.com.codesoftware.logic;

import java.util.ArrayList;
import java.util.List;

import co.com.codesoftware.entities.DatosSessionEntity;
import co.com.codesoftware.entities.GenericProductEntity;
import co.com.codesoftware.server.PantallaPrincipalFacTable;
import co.com.codesoftware.server.ProductoGenericoEntity;
import co.com.codesoftware.server.ProductoTable;
import co.com.codesoftware.server.RecetaTable;
import co.com.codesoftware.server.SAFWS;
import co.com.codesoftware.server.SAFWSService;
import co.com.codesoftware.utilities.ImagesUtilities;

public class ProductsLogic {
	/**
	 * Funcion que consulta los productos que apareceran en el home
	 * 
	 * @return
	 */
	public List<PantallaPrincipalFacTable> getEspecialProduct(Integer sede_sede) {
		List<PantallaPrincipalFacTable> list = new ArrayList<PantallaPrincipalFacTable>();
		try {
			System.out.println("Esta es la sede " +sede_sede );
			SAFWSService service = new SAFWSService();
			SAFWS port = service.getSAFWSPort();
			list = port.getProductPrincipalScreen(sede_sede);
			list = getImage(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * Funcion que consulta un producto por codigo y devuelve la entidad de este
	 * 
	 * @param id
	 * @return
	 */

	public GenericProductEntity getProductXCode(String code, int cantidad,DatosSessionEntity session) {
		ProductoTable product = null;
		GenericProductEntity result = new GenericProductEntity();
		try {
			product = new ProductoTable();
			SAFWSService service = new SAFWSService();
			SAFWS port = service.getSAFWSPort();
			product = port.getProductForCode(code, session.getDataUser().getSede());
			if (product != null) {
				result = setGenericProduct(result, product, cantidad);
			} else {
				result = null;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * Consulta recetas por el codigo
	 * @param code
	 * @param cantidad
	 * @param session
	 * @return
	 */
	public GenericProductEntity getRecetaForCode(String code, int cantidad,DatosSessionEntity session){
		RecetaTable receta = null;
		GenericProductEntity result = new GenericProductEntity();
		try {
			SAFWSService service = new SAFWSService();
			SAFWS port = service.getSAFWSPort();
			receta = port.getRecetaForcode(code, session.getDataUser().getSede());
			if (receta != null) {
				result = setGenericReceta(result, receta, cantidad);
			} else {
				result = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

		
	}

	public GenericProductEntity setGenericProduct(GenericProductEntity result, ProductoTable product, int cantidad) {
		result.setCode(product.getCodigo());
		result.setId(product.getId());
		result.setName(product.getNombre());
		result.setAmount(cantidad);
		result.setPrice(String.valueOf(product.getPrecios().get(0).getPrecio()));
		result.setTotalPrice(String.valueOf(product.getPrecios().get(0).getPrecio()));
		return result;
	}

	public GenericProductEntity setGenericReceta(GenericProductEntity result, RecetaTable product, int cantidad) {
		result.setCode(product.getCodigo());
		result.setId(product.getId());
		result.setName(product.getNombre());
		result.setAmount(cantidad);
		result.setPrice(String.valueOf(product.getPrecios().get(0).getPrecio()));
		return result;
	}

	public List<PantallaPrincipalFacTable> getImage(List<PantallaPrincipalFacTable> list) {
		ImagesUtilities ut = new ImagesUtilities();
		for (PantallaPrincipalFacTable item : list) {
			if (ut.encodeB64ToImage(item.getImagen(), item.getNombre() + "." + item.getExtension())) {
				item.setRuta(item.getCodigo() + "." + item.getExtension());
			}
		}
		return list;
	}

	/**
	 * Funcion la cual busca todos los productos activos de la aplicacion
	 * 
	 * @return
	 */
	public List<ProductoTable> buscaProductosAplicacion(Integer sede) {
		List<ProductoTable> productos = null;
		try {
			SAFWSService service = new SAFWSService();
			SAFWS port = service.getSAFWSPort();
			productos = port.getProducts(sede);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productos;
	}

	/**
	 * Funcion con la cual obtengo todos los productos y recetas del sistema
	 * 
	 * @param sede_sede
	 * @return
	 */
	public List<ProductoGenericoEntity> buscaProductosAplicacionGenericos(Integer sede_sede) {
		List<ProductoGenericoEntity> productosGenericos = null;
		try {
			SAFWSService service = new SAFWSService();
			SAFWS port = service.getSAFWSPort();
			productosGenericos = port.findProductosAndDishes(sede_sede);						
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productosGenericos;

	}

}
