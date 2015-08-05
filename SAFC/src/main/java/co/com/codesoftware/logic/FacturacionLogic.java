package co.com.codesoftware.logic;

import java.util.List;

import co.com.codesoftware.entities.ClienteEntity;
import co.com.codesoftware.entities.GenericProductEntity;
import co.com.codesoftware.server.Facturacion;
import co.com.codesoftware.server.SAFWS;
import co.com.codesoftware.server.SAFWSService;
import co.com.codesoftware.server.TemporalProdTable;
import co.com.codesoftware.server.TemporalRecTable;


public class FacturacionLogic {
	private List<TemporalProdTable> products;
	private List<TemporalRecTable> receta;
	
	
	public List<TemporalProdTable> getProducts() {
		return products;
	}

	public void setProducts(List<TemporalProdTable> products) {
		this.products = products;
	}

	public List<TemporalRecTable> getReceta() {
		return receta;
	}

	public void setReceta(List<TemporalRecTable> receta) {
		this.receta = receta;
	}

	/**
	 * Funcion que hace la multiplicacion del precio del producto por la
	 * cantidad
	 * 
	 * @param price
	 * @param amount
	 * @return
	 */
	public String updatePrice(String price, int amount) {
		String result = "";
		if(price!=null){
		Double total = Double.parseDouble(price) * amount;
		result = String.valueOf(total);
		}else{
			result= null;
		}
		return result;
	}

	public boolean validateCantidad(int cantidad) {
		if (cantidad > 0)
			return true;
		else
			return false;
	}
	public boolean validateCodigo(String codigo){
		if((codigo.startsWith("1-") || codigo.startsWith("3-")) &&  codigo != null && codigo !="")
			return true;
		else
			return false;
			
		
	}
	/**
	 * Funcion que genera toda la logica para facturar
	 * @param list
	 * @return
	 */
	
	public String facturar(List<GenericProductEntity> list,ClienteEntity cliente){
		String rta="";
		Facturacion fact = new Facturacion();
		
		try {
			fact.setIdCliente(cliente.getId());
			//Agregar las listas
			SAFWSService service = new SAFWSService();
	        SAFWS port = service.getSAFWSPort();
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rta;
	}
	
	/**
	 * Funcion que recorre el listado de productos y recetas y dependendiendo del codigo lo setea
	 * @param list
	 * @return
	 */
	public boolean recorreLista(List<GenericProductEntity> list){
		for(int i = 0;i < list.size();i++){
			if(list.get(i).getCode().startsWith("1-")){
				this.products.add(addProduct(list.get(i)));
			}
			if(list.get(i).getCode().startsWith("3-")){
				this.receta.add(addReceta(list.get(i)));
			}
			
		}
		return true;
	}
	
	/**
	 * Funcion que setea el objeto si es un producto lo que viene en la lista
	 * @param product
	 * @return
	 */
	public TemporalProdTable addProduct(GenericProductEntity product){
		TemporalProdTable prodTable = new TemporalProdTable();
		prodTable.setCantidad(product.getAmount());
		prodTable.setDescuento(0);
		prodTable.setIdDska(product.getId());
		//no se cuales son los campos que tengo que enviar
		return prodTable;
	}
	/**
	 * Funcion que setea la receta en el nuevo objeto
	 * @param product
	 * @return
	 */
	
	public TemporalRecTable addReceta(GenericProductEntity product){
		TemporalRecTable prodTable = new TemporalRecTable();
		//Falta descripcion de recetas
		return prodTable;
	}
	
	
	
	

}
