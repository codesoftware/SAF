package co.com.codesoftware.mb;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import co.com.codesoftware.entities.ClienteEntity;
import co.com.codesoftware.entities.DatosSessionEntity;
import co.com.codesoftware.entities.GenericProductEntity;
import co.com.codesoftware.logic.FacturacionLogic;
import co.com.codesoftware.logic.ProductsLogic;
import co.com.codesoftware.server.PantallaPrincipalFacTable;
import co.com.codesoftware.server.ProductoGenericoEntity;
import co.com.codesoftware.server.ProductoTable;
import co.com.codesoftware.utilities.ErrorEnum;

@ManagedBean(name = "facturacionBean")
@ViewScoped
public class FacturacionBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private ClienteEntity cliente;
	private GenericProductEntity product;
	private PantallaPrincipalFacTable prod;
	private DatosSessionEntity entitySession;
	@ManagedProperty(value = "#{clienteBean}")
	private ClienteBean clientebean;
	private String codigoProducto;
	private int cantidad;
	private List<GenericProductEntity> listProd;
	private String codigoAdd;
	private BigDecimal total;
	private String priceTotal;
	private ErrorEnum enumer;
	private List<ProductoTable> productos;
	private List<ProductoGenericoEntity> productosGenericos;
	private List<ProductoGenericoEntity> productosFilter;
	private BigDecimal totalChange;
	private BigDecimal totalCliente;
	private boolean domicilio;
	private String summary;
	private MathContext mc;

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getPriceTotal() {
		return priceTotal;
	}

	public void setPriceTotal(String priceTotal) {
		this.priceTotal = priceTotal;
	}

	public BigDecimal getTotalChange() {
		return totalChange;
	}

	public boolean isDomicilio() {
		return domicilio;
	}

	public void setDomicilio(boolean domicilio) {
		this.domicilio = domicilio;
	}

	public void setTotalChange(BigDecimal totalChange) {
		this.totalChange = totalChange;
	}

	public BigDecimal getTotalCliente() {
		return totalCliente;
	}

	public void setTotalCliente(BigDecimal totalCliente) {
		this.totalCliente = totalCliente;
	}

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

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
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

	public DatosSessionEntity getEntitySession() {
		return entitySession;
	}

	public void setEntitySession(DatosSessionEntity entitySession) {
		this.entitySession = entitySession;
	}

	public List<ProductoGenericoEntity> getProductosGenericos() {
		return productosGenericos;
	}

	public void setProductosGenericos(List<ProductoGenericoEntity> productosGenericos) {
		this.productosGenericos = productosGenericos;
	}

	@PostConstruct
	public void init() {
		try {
			mc = new MathContext(5); //Da la precicion de las operaciones a las operaciones con bigDecimal
			this.totalChange = new BigDecimal("0");
			this.cantidad = 1;
			this.total = new BigDecimal("0");
			FacesMessage message = null;
			FacesContext context = FacesContext.getCurrentInstance();
			this.entitySession = (DatosSessionEntity) context.getExternalContext().getSessionMap().get("dataSession");
			if (entitySession == null) {
				message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Esta intentando a un sitio no permitido porfavor realice el login primero");
				context.getExternalContext().redirect("../index.jsf");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo que ejecuta la facturacion
	 */

	public void facturar() {
		checkProducts("1");
	}

	/**
	 * metodo que ejecuta la facturacion sin imprimir el pdf
	 */
	public void registrar() {
		checkProducts("2");
	}

	public List<ProductoTable> getProductos() {
		return productos;
	}

	public void setProductos(List<ProductoTable> productos) {
		this.productos = productos;
	}

	public List<ProductoGenericoEntity> getProductosFilter() {
		return productosFilter;
	}

	public void setProductosFilter(List<ProductoGenericoEntity> productosFilter) {
		this.productosFilter = productosFilter;
	}

	/**
	 * Funcion que valida que tipo de producto es y asi poderlo mostrar
	 */
	public void searchProdId() {
		FacturacionLogic log = new FacturacionLogic();
		if (log.validateCodigo(codigoAdd)) {
			ProductsLogic prod = new ProductsLogic();
			if (codigoAdd.startsWith("1-")) {
				product = prod.getProductXCode(codigoAdd, cantidad, this.entitySession);
			} else if (codigoAdd.startsWith("3-")) {
				product = prod.getRecetaForCode(codigoAdd, cantidad, this.entitySession);
			}
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
					this.listProd.get(exist).setAmount(this.listProd.get(exist).getAmount() + cantidad);
					if (log.updatePrice(this.listProd.get(exist).getPrice(), this.listProd.get(exist).getAmount()) == null) {
						this.setEnumer(ErrorEnum.ERROR);
						messageBean("Al producto no se le ha parametrizado el precio");
					} else {
						this.listProd.get(exist).setTotalPrice(log.updatePrice(this.listProd.get(exist).getPrice(), this.listProd.get(exist).getAmount()));
					}
				} else {
					product.setAmount(this.cantidad);
					product.setTotalPrice(product.getPrice().multiply(new BigDecimal(cantidad),mc));
					//product.setTotalPrice(String.valueOf(Double.parseDouble(product.getPrice()) * this.cantidad));
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
				this.listProd.get(exist).setAmount(this.listProd.get(exist).getAmount() + cantidad);
				this.listProd.get(exist).setTotalPrice(this.listProd.get(exist).getPrice().multiply(new BigDecimal(listProd.get(exist).getAmount()), mc));
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
			if (this.listProd.get(i).getCode().equalsIgnoreCase(product.getCode())) {
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
		this.product = new GenericProductEntity();
		this.product.setAmount(1);
		this.product.setPrice(new BigDecimal(table.getPrecio()));
		this.product.setCode(table.getCodigo());
		this.product.setName(table.getNombre());
		this.product.setTotalPrice(new BigDecimal(table.getPrecio()));
		this.product.setId(table.getIdReceta());
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
			prod.setTotalPrice(log.updatePrice(prod.getPrice(), prod.getAmount()));
		}
		addTotal();
	}

	/**
	 * Funcion que actualiza el total de la factura
	 * 
	 */
	public void addTotal() {
		BigDecimal result = new BigDecimal("0");
		for (int i = 0; i < this.listProd.size(); i++) {
			FacturacionLogic factuacionLogic = new FacturacionLogic();
			BigDecimal aux = factuacionLogic.updatePrice(this.listProd.get(i).getPrice(), this.listProd.get(i).getAmount());
			if (aux.intValue() == 0) {
				this.setEnumer(ErrorEnum.ERROR);
				messageBean("Producto sin parametrizar precio.");
			} else {
				result = result.add(aux);
				this.total = result;
			}
		}

	}

	/**
	 * Funcion con la cual busco los productos del sistema
	 */
	public void buscaProductos() {
		try {
			ProductsLogic logic = new ProductsLogic();
			this.productos = logic.buscaProductosAplicacion(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Funcion con la cual busco los productos del sistema
	 */
	public void buscaProductosGenericos() {
		try {
			ProductsLogic logic = new ProductsLogic();
			this.productosGenericos = logic.buscaProductosAplicacionGenericos(this.entitySession.getDataUser().getSede());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Funcion que ejecuta la facturacion y envia el parametro dependiendo de la
	 * acción
	 * 
	 * @param type
	 */
	public void checkProducts(String type) {
		FacturacionLogic logic = new FacturacionLogic();
		// valida si no hay productos o si el cliente esta nulo
		String validate = logic.validaDatos(this.listProd, clientebean.getCliente(), this.summary);
		if (!"OK".equalsIgnoreCase(validate)) {
			this.setEnumer(ErrorEnum.ERROR);
			messageBean(validate);
		} else {
			ExternalContext tmpEC;
			tmpEC = FacesContext.getCurrentInstance().getExternalContext();
			String realPath = tmpEC.getRealPath("/resources/images/products/");
			String rta = logic.facturar(this.listProd, this.clientebean.getCliente(), realPath, this.entitySession, type, this.totalChange.toString(), this.totalCliente.toString(), this.summary);
			if ("OK".equalsIgnoreCase(rta)) {
				if ("1".equalsIgnoreCase(type)) {
					this.enumer = ErrorEnum.SUCCESS;
					messageBean("FACTURACIÓN REALIZADA CORRECTAMENTE");
					resetValuesBill();
					resetValuesClient();
					resetValuesCambio();
				}
				// Pop up de factura cuando no se imprime
				else {
					this.enumer = ErrorEnum.SUCCESS;
					messageBean("FACTURACIÓN REALIZADA CORRECTAMENTE");
					viewResumeBill();
				}
			} else {
				this.enumer = ErrorEnum.ERROR;
				messageBean(rta);
			}

		}
	}

	public void viewResumeBill() {
		RequestContext context = RequestContext.getCurrentInstance();
		context.execute("PF('viewBill').show();");

	}

	/**
	 * Metodo para cerrar el pop up del resumen de la factura
	 */

	public void cerrarFacturaProv() {
		resetValuesBill();
		resetValuesClient();
		resetValuesCambio();
	}

	/**
	 * Metodo el cual añade el producto a la lista de productos
	 * 
	 * @param productTable
	 */
	public void seleccionarProducto(ProductoTable productTable) {
		try {
			this.product = new GenericProductEntity();
			if (this.listProd == null) {
				this.listProd = new ArrayList<GenericProductEntity>();
			}
			this.product = setDataEntity(productTable);
			int exist = existProduct();

			if (exist > -1) {
				this.listProd.get(exist).setAmount(this.listProd.get(exist).getAmount() + 1);
				this.listProd.get(exist).setTotalPrice(this.listProd.get(exist).getPrice().multiply(new BigDecimal(this.listProd.get(exist).getAmount()), mc));
			} else {
				this.listProd.add(product);
			}
			addTotal();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo el cual añade el productoo receta a la lista de productos
	 * 
	 * @param productTable
	 */
	public void seleccionarProductoGenerico(ProductoGenericoEntity producto) {
		try {
			this.product = new GenericProductEntity();
			if (this.listProd == null) {
				this.listProd = new ArrayList<GenericProductEntity>();
			}
			this.product = setDataEntityGeneric(producto);
			int exist = existProduct();

			if (exist > -1) {
				this.listProd.get(exist).setAmount(this.listProd.get(exist).getAmount() + 1);
				this.listProd.get(exist).setTotalPrice(this.listProd.get(exist).getPrice().multiply(new BigDecimal(this.listProd.get(exist).getAmount()), mc));
			} else {
				product.setTotalPrice(producto.getPrecio());
				this.listProd.add(product);
			}
			addTotal();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Funcion con la cual convierte un objeto producto table y lo convierte en
	 * un objeto generico
	 * 
	 * @param prod
	 * @return
	 */
	public GenericProductEntity setDataEntity(ProductoTable prod) {
		GenericProductEntity genProduct = new GenericProductEntity();
		genProduct.setAmount(1);
		genProduct.setCode(prod.getCodigo());
		genProduct.setId(prod.getId());
		genProduct.setName(prod.getNombre());
		genProduct.setPrice(new BigDecimal(prod.getPrecios().get(0).getPrecio()));
		return genProduct;
	}

	/**
	 * Funcion con la cual convierte un objeto producto table y lo convierte en
	 * un objeto generico
	 * 
	 * @param prod
	 * @return
	 */
	public GenericProductEntity setDataEntityGeneric(ProductoGenericoEntity prod) {
		GenericProductEntity genProduct = new GenericProductEntity();
		genProduct.setAmount(1);
		genProduct.setCode(prod.getCodigo());
		genProduct.setId(prod.getId());
		genProduct.setName(prod.getNombre());
		genProduct.setPrice(prod.getPrecio());
		genProduct.setPrice(prod.getPrecio());
		return genProduct;
	}

	/**
	 * Funcion que resetea los valores de la factura
	 */
	public void resetValuesBill() {
		this.listProd = null;
		this.listProd = new ArrayList<GenericProductEntity>();
		this.total = new BigDecimal(0);
	}

	public void resetValuesCambio() {
		this.totalChange = new BigDecimal(0);
		this.totalCliente = new BigDecimal(0);
	}

	/**
	 * funcion que resetea los valores del cliente
	 */
	public void resetValuesClient() {
		this.clientebean.setCliente(null);
		this.clientebean.setCliente(new ClienteEntity());
	}

	/**
	 * Funcion con la cual se calcula el cambio que se tiene que dar al cliente
	 */
	public void getCambio() {
		this.totalChange = totalCliente.subtract(this.total);
		if (totalChange.doubleValue() < 0) {
			this.totalChange = new BigDecimal(0);
		}
	}

	/**
	 * Funcion donde se controla que la factura este lista para mostrar el pop
	 * up de facturacion donde el cliente ingresa el valor a pagar
	 */

	public void viewTotalPrice() {
		FacturacionLogic logic = new FacturacionLogic();
		// valida si no hay productos o si el cliente esta nulo;
		String validate = logic.validaDatos(this.listProd, clientebean.getCliente(), this.summary);
		if ("Ok".equalsIgnoreCase(validate)) {
			RequestContext context = RequestContext.getCurrentInstance();
			context.execute("PF('viewPrice').show();");
		} else {
			this.setEnumer(ErrorEnum.ERROR);
			messageBean(validate);
		}
	}

	/**
	 * Funcion que controla el check de domicilios
	 */
	public void addAjaxCheck() {
		this.summary = this.domicilio ? "Checked" : "Unchecked";
	}

	/**
	 * Metodo generico para mostrar mensajes de error o advertencia
	 * 
	 * @param message
	 */

	public void messageBean(String message) {
		switch (this.enumer) {
		case ERROR:
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", message));
			break;
		case FATAL:
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Fatal!", "Error de sistema"));
			break;
		case SUCCESS:
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Ok!", message));
			break;

		default:
			break;
		}
	}

}
