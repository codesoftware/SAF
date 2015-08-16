package co.com.codesoftware.mb;

import java.awt.Desktop;
import java.io.File;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import co.com.codesoftware.entities.ClienteEntity;
import co.com.codesoftware.entities.GenericProductEntity;
import co.com.codesoftware.logic.FacturacionLogic;
import co.com.codesoftware.logic.ProductsLogic;
import co.com.codesoftware.server.PantallaPrincipalFacTable;
import co.com.codesoftware.utilities.ErrorEnum;

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
	private ErrorEnum enumer;

	public ErrorEnum getEnumer() {
		return enumer;
	}

	public void setEnumer(ErrorEnum enumer) {
		this.enumer = enumer;
	}

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
		FacturacionLogic log = new FacturacionLogic();
		if (log.validateCodigo(codigoAdd)) {
			ProductsLogic prod = new ProductsLogic();
			product = prod.getProductXCode(codigoAdd, cantidad);
			if (product == null) {
				this.setEnumer(ErrorEnum.ERROR);
				messageBean("Producto inexistente.");
			}
		} else {
			this.setEnumer(ErrorEnum.ERROR);
			messageBean("Codigo del producto incorrecto.");
		}
	}

	/**
	 * Funcion que añade los productos a la factura
	 */

	public void addProductFact() {
		if (this.listProd == null) {
			this.listProd = new ArrayList<GenericProductEntity>();
		}
		FacturacionLogic log = new FacturacionLogic();
		// Verifica si el codigo esta correcto
		if (log.validateCodigo(codigoAdd)) {
			// Verifica si la cantidad esta correcta
			if (log.validateCantidad(cantidad)) {
				int exist = existProduct();
				if (exist > -1) {
					this.listProd.get(exist).setAmount(
							this.listProd.get(exist).getAmount() + cantidad);
					if (log.updatePrice(this.listProd.get(exist).getPrice(),
							this.listProd.get(exist).getAmount()) == null) {
						this.setEnumer(ErrorEnum.ERROR);
						messageBean("Al producto no se le ha parametrizado el precio");
					} else {
						this.listProd.get(exist).setTotalPrice(
								log.updatePrice(this.listProd.get(exist)
										.getPrice(), this.listProd.get(exist)
										.getAmount()));
					}
				} else {
					this.listProd.add(product);
				}
				addTotal();

			} else {
				this.setEnumer(ErrorEnum.ERROR);
				messageBean("Digite cantidad valida");
			}

		} else {
			this.setEnumer(ErrorEnum.ERROR);
			messageBean("Codigo invalido");
		}
	}

	/**
	 * Funcion que añade un producto al darle clic en el panel
	 */
	public void addProductPanel(PantallaPrincipalFacTable table) {
		if (this.listProd == null) {
			this.listProd = new ArrayList<GenericProductEntity>();
		}
		if (table.getPrecio() == null) {
			this.setEnumer(ErrorEnum.ERROR);
			messageBean("Al producto no se le ha parametrizado el precio");
		} else {
			setData(table);
			int exist = existProduct();
			if (exist > -1) {
				this.listProd.get(exist).setAmount(
						this.listProd.get(exist).getAmount() + cantidad);
				this.listProd.get(exist).setTotalPrice(
						String.valueOf(Double.parseDouble(this.listProd.get(
								exist).getPrice())
								* this.listProd.get(exist).getAmount()));
			} else {
				this.listProd.add(product);
			}
			addTotal();
		}
	}

	/**
	 * Funcion que valida si el producto ya existe
	 * 
	 * @return
	 */

	public int existProduct() {
		int result = -1;
		if (listProd == null) {
			listProd = new ArrayList<GenericProductEntity>();
		}
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
	 * 
	 * @param table
	 */

	public void setData(PantallaPrincipalFacTable table) {
		System.out.println(table.getId());
		this.product = new GenericProductEntity();
		this.product.setAmount(1);
		this.product.setPrice(table.getPrecio());
		this.product.setCode(table.getCodigo());
		this.product.setName(table.getNombre());
		this.product.setTotalPrice(table.getPrecio());
		this.product.setId(table.getId());
	}

	/**
	 * Funcion que elimina una fila de la factura
	 * 
	 * @param prod
	 */
	public void deleteRow(GenericProductEntity prod) {
		this.listProd.remove(prod);
		addTotal();
	}

	/**
	 * funcion que actualiza la cantidad de productos
	 * 
	 * @param prod
	 */
	public void updateRow(GenericProductEntity prod) {
		if (prod.getAmount() < 2) {
			this.listProd.remove(prod);
		} else {
			FacturacionLogic log = new FacturacionLogic();
			prod.setAmount(prod.getAmount() - 1);
			prod.setTotalPrice(log.updatePrice(prod.getPrice(),
					prod.getAmount()));
		}
		addTotal();
	}

	public void addTotal() {
		Double result = 0.0;
		for (int i = 0; i < this.listProd.size(); i++) {
			FacturacionLogic log = new FacturacionLogic();
			if (log.updatePrice(this.listProd.get(i).getPrice(), this.listProd
					.get(i).getAmount()) == null) {
				this.setEnumer(ErrorEnum.ERROR);
				messageBean("Producto sin parametrizar precio.");
			} else {
				result += Double.parseDouble(log.updatePrice(
						this.listProd.get(i).getPrice(), this.listProd.get(i)
								.getAmount()));
				this.total = result.toString();
			}
		}

	}

	/**
	 * Metodo que toma el tipo de mensaje que se quiere mostrar
	 * 
	 * @param message
	 */
	public void messageBean(String message) {
		switch (this.enumer) {
		case ERROR:
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!",
							message));
			break;
		case FATAL:
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, "Fatal!",
							"Error de sistema"));
			break;

		default:
			break;
		}
	}

	/**
	 * metodo para facturar la compra
	 */
	public void facturar() {
		FacturacionLogic logic = new FacturacionLogic();
		ExternalContext tmpEC;
		tmpEC = FacesContext.getCurrentInstance().getExternalContext();
		String realPath = tmpEC.getRealPath("/resources/images/products/");
		logic.facturar(listProd, clientebean.getCliente(),realPath);
	}

	/**
	 * Metodo que solo llama el proceso de facturar
	 */
	public void registrar() {
		facturar();
		openBox();
	}

	public void facturarFactura() {
		facturar();
		
	}

	/**
	 * metodo que exporta a pdf la factura
	 */
	
	public void exportFact() {
		
	}

//	public void exportFact() {
//		try {
//			FacturacionLogic logic = new FacturacionLogic();
//			ExternalContext tmpEC;
//			tmpEC = FacesContext.getCurrentInstance().getExternalContext();
//			String realPath = tmpEC.getRealPath("/resources/images/products/");
//			String result = logic.createPDF(realPath);
//			if (result != "error") {
//				System.out.println("si lo creo");
//				try {
//					Desktop.getDesktop().open(new File(result));
//				} catch (Exception e) {
//					System.out.println(e);
//				}
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	public void openBox() {

	}

	public Connection generarConexion() {
		Connection con = null;
		try {
			Class.forName("org.postgresql.Driver");
			String url = "jdbc:postgresql://127.0.0.1:5432/Sigemco";
			con = DriverManager.getConnection(url, "postgres", "1234");
		} catch (Exception e) {
			System.out.println("Error al realizar la conexion...");
			e.printStackTrace();
		}
		return con;
	}

}
