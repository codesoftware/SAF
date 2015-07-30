package co.com.codesoftware.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import co.com.codesoftware.entities.ClienteEntity;
import co.com.codesoftware.entities.GenericProductEntity;
import co.com.codesoftware.logic.FacturacionLogic;
import co.com.codesoftware.logic.ProductsLogic;
import co.com.codesoftware.server.PantallaPrincipalFacTable;

@ManagedBean(name = "facturacionBean")
@ViewScoped
public class FacturacionBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private ClienteEntity cliente;
	private GenericProductEntity product;
	private PantallaPrincipalFacTable prod;
	@ManagedProperty(value = "#{clienteBean}")
	private ClienteBean clientebean;
	private String codigoProducto;
	private int cantidad = 1;
	private List<GenericProductEntity> listProd;
	private String codigoAdd;
	private String total;

	public FacturacionBean() {
		super();
		this.product = new GenericProductEntity();
	}
	

	public String getTotal() {
		return total;
	}


	public void setTotal(String total) {
		this.total = total;
	}


	public List<GenericProductEntity> getListProd() {
		return listProd;
	}

	public PantallaPrincipalFacTable getProd() {
		return prod;
	}

	public void setProd(PantallaPrincipalFacTable prod) {
		this.prod = prod;
	}

	public void setListProd(List<GenericProductEntity> listProd) {
		this.listProd = listProd;
	}

	public ClienteEntity getCliente() {
		return cliente;
	}

	public void setCliente(ClienteEntity cliente) {
		this.cliente = cliente;
	}

	public GenericProductEntity getProduct() {
		return product;
	}

	public void setProduct(GenericProductEntity product) {
		this.product = product;
	}

	public ClienteBean getClientebean() {
		return clientebean;
	}

	public void setClientebean(ClienteBean clientebean) {
		this.clientebean = clientebean;
	}

	public String getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getCodigoAdd() {
		return codigoAdd;
	}

	public void setCodigoAdd(String codigoAdd) {
		this.codigoAdd = codigoAdd;
	}

	/**
	 * Funcion que valida que tipo de producto es y asi poderlo mostrar
	 */
	public void searchProdId() {
		System.out.println("paso por aqui");
		if (codigoAdd.startsWith("1-")) {
			ProductsLogic prod = new ProductsLogic();
			product = prod.getProductXCode(codigoAdd, cantidad);

		} else if (product.getCode().startsWith("3-")) {
			
		} else {
			// Mensaje error;
		}
	}

	/**
	 * Funcion que añade los productos a la factura
	 */

	public void addProductFact() {
		if (this.listProd == null) {
			this.listProd = new ArrayList<GenericProductEntity>();
		}
		int exist = existProduct();
		if (exist > -1) {
			FacturacionLogic log = new FacturacionLogic();
			this.listProd.get(exist).setAmount(
					this.listProd.get(exist).getAmount() + cantidad);
			this.listProd.get(exist).setTotalPrice(log.updatePrice(this.listProd.get(exist).getPrice(),this.listProd.get(exist).getAmount()));
		} else {
			this.listProd.add(product);
		}
		addTotal();
	}

	/**
	 * Funcion que añade un producto al darle clic en el panel
	 */
	public void addProductPanel(PantallaPrincipalFacTable table) {
		if (this.listProd == null) {
			this.listProd = new ArrayList<GenericProductEntity>();
		}
		setData(table);
		int exist = existProduct();
		if (exist > -1) {
			this.listProd.get(exist).setAmount(
					this.listProd.get(exist).getAmount() + cantidad);
		} else {
			this.listProd.add(product);
		}
		addTotal();
	}

	/**
	 * Funcion que valida si el producto ya existe
	 * 
	 * @return
	 */

	public int existProduct() {
		int result = -1;
		for (int i = 0; i < this.listProd.size(); i++) {
			if (this.listProd.get(i).getCode()
					.equalsIgnoreCase(product.getCode())) {
				result = i;
				i = this.listProd.size();
			}

		}
		return result;
	}
	/**
	 * Funcion que setea al objeto generico de factura
	 * @param table
	 */

	public void setData(PantallaPrincipalFacTable table) {
		this.product = new GenericProductEntity();
		this.product.setAmount(1);
		this.product.setPrice(table.getPrecio());
		this.product.setCode(table.getCodigo());
		this.product.setName(table.getNombre());
	}
	
	/**
	 * Funcion que elimina una fila de la factura
	 * @param prod
	 */
	public void deleteRow(GenericProductEntity prod){
		this.listProd.remove(prod);
		addTotal();
	}
	/**
	 * funcion que actualiza la cantidad de productos 
	 * @param prod
	 */
	public void updateRow(GenericProductEntity prod){
		if(prod.getAmount()<2){
			this.listProd.remove(prod);
		}else{
			FacturacionLogic log = new FacturacionLogic();
			prod.setAmount(prod.getAmount()-1);
			prod.setTotalPrice(log.updatePrice(prod.getPrice(),prod.getAmount()));
		}
		addTotal();
	}
	
	public void addTotal(){
		Double result = 0.0;
		for(int i= 0;i<this.listProd.size();i++){
			FacturacionLogic log = new FacturacionLogic();
			result+=Double.parseDouble(log.updatePrice(this.listProd.get(i).getPrice(),this.listProd.get(i).getAmount()));
		}
		this.total = result.toString();
	}
	

}
