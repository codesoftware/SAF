package co.com.codesoftware.logic;

import java.util.ArrayList;
import java.util.List;

import co.com.codesoftware.server.ProductoTable;

public class ProductsLogic {
	
	public List<ProductoTable> getEspecialProduct(){
		List<ProductoTable> list = new ArrayList<ProductoTable>();
		for(int i=1 ; i<= 10; i++){
			ProductoTable obj = new ProductoTable();
			obj.setNombre("nombre"+i);
			list.add(obj);
		}

		return list;
	}

}
