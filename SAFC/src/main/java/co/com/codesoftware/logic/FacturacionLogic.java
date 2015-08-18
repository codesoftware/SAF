package co.com.codesoftware.logic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfWriter;

import co.com.codesoftware.entities.ClienteEntity;
import co.com.codesoftware.entities.DatosSessionEntity;
import co.com.codesoftware.entities.GenericProductEntity;
import co.com.codesoftware.server.FacturaTable;
import co.com.codesoftware.server.Facturacion;
import co.com.codesoftware.server.RespuestaFacturacion;
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
		if (price != null) {
			Double total = Double.parseDouble(price) * amount;
			result = String.valueOf(total);
		} else {
			result = null;
		}
		return result;
	}

	public boolean validateCantidad(int cantidad) {
		if (cantidad > 0)
			return true;
		else
			return false;
	}

	public boolean validateCodigo(String codigo) {
		if ((codigo.startsWith("1-") || codigo.startsWith("3-")) && codigo != null && codigo != "")
			return true;
		else
			return false;

	}

	/**
	 * Funcion que genera toda la logica para facturar
	 * 
	 * @param list
	 * @return
	 */

	public String facturar(List<GenericProductEntity> list, ClienteEntity cliente, String path,
			DatosSessionEntity session, String type) {
		String rta = "";
		Facturacion fact = new Facturacion();
		RespuestaFacturacion res = new RespuestaFacturacion();
		recorreLista(list);
		try {
			fact.setIdSede(new Long(1));
			fact.setIdTius(session.getDataUser().getId());
			fact.setIdCliente(cliente.getId());
			fact.setProductos(this.products);
			fact.setRecetas(this.receta);
			SAFWSService service = new SAFWSService();
			SAFWS port = service.getSAFWSPort();
			res = port.facturar(fact);
			if ("error".equalsIgnoreCase(res.getRespuesta())) {
				rta = res.getTrazaExcepcion();
			} else {
				FacturaTable result = new FacturaTable();
				result = getDataFact(res.getIdFacturacion());
				if ("1".equalsIgnoreCase(type)) {
					createPDF(path, result,cliente,session);
					rta = "OK";
				} else {
					rta = "OK";
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return rta;
	}

	/**
	 * Metodo que trae los datos de la factura para mostrarlos e imprimirlos
	 * 
	 * @return
	 */

	public FacturaTable getDataFact(String idFactura) {
		FacturaTable table = new FacturaTable();
		try {
			SAFWSService service = new SAFWSService();
			SAFWS port = service.getSAFWSPort();
			table = port.getFacturaForId(Integer.parseInt(idFactura));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return table;
	}

	/**
	 * Funcion que recorre el listado de productos y recetas y dependendiendo
	 * del codigo lo setea
	 * 
	 * @param list
	 * @return
	 */
	public boolean recorreLista(List<GenericProductEntity> list) {
		for (GenericProductEntity productoGen : list) {
			if (productoGen.getCode().startsWith("1-")) {
				TemporalProdTable objAux = addProduct(productoGen);
				if (this.products == null) {
					this.products = new ArrayList<TemporalProdTable>();
				}
				this.products.add(objAux);
			}
			if (productoGen.getCode().startsWith("3-")) {
				TemporalRecTable objAux = addReceta(productoGen);
				if (this.receta == null) {
					this.receta = new ArrayList<TemporalRecTable>();
				}
				this.receta.add(objAux);
			}
		}
		return true;
	}

	/**
	 * Funcion que setea el objeto si es un producto lo que viene en la lista
	 * 
	 * @param product
	 * @return
	 */
	public TemporalProdTable addProduct(GenericProductEntity product) {
		TemporalProdTable prodTable = new TemporalProdTable();
		prodTable.setCantidad(product.getAmount());
		prodTable.setDescuento(0);
		prodTable.setIdDska(product.getId());
		prodTable.setId(null);
		return prodTable;
	}

	/**
	 * Funcion que setea la receta en el nuevo objeto
	 * 
	 * @param product
	 * @return
	 */

	public TemporalRecTable addReceta(GenericProductEntity product) {
		TemporalRecTable prodTable = new TemporalRecTable();
		// Falta descripcion de recetas
		prodTable.setCantidad(product.getAmount());
		prodTable.setDescuento(0);
		prodTable.setIdReceta(product.getId());
		return prodTable;
	}

	public String createPDF(String path, FacturaTable factura,ClienteEntity cliente,DatosSessionEntity session) {
		Rectangle rec = new Rectangle(2.0F, 8.0F);
		Document document = new Document();
		path += "factura.pdf";
		try {

			PdfWriter.getInstance(document, new FileOutputStream(path));
			document.open();
			document.add(new Paragraph("Fecha facturacion:" + factura.getFecha().toString()));
			document.add(new Paragraph("Tipo Pago:" + factura.getTipoPago()));
			for (int i = 0; i < factura.getDetalleProductos().size(); i++) {
				document.add(new Paragraph("Cantidad:" + factura.getDetalleProductos().get(i).getCantidad()));
				document.add(new Paragraph("Cantidad:" + factura.getDetalleProductos().get(i).getCantidad()));
			}
			document.close();
			print(path);
			return path;
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}

	}

	public boolean print(String path) {
		try {
			FileInputStream inputStream = null;
			try {
				inputStream = new FileInputStream(path);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			if (inputStream == null) {
				return false;
			}
			DocFlavor docFormat = DocFlavor.INPUT_STREAM.AUTOSENSE;
			Doc document = new SimpleDoc(inputStream, docFormat, null);

			PrintRequestAttributeSet attributeSet = new HashPrintRequestAttributeSet();

			PrintService defaultPrintService = PrintServiceLookup.lookupDefaultPrintService();

			if (defaultPrintService != null) {
				DocPrintJob printJob = defaultPrintService.createPrintJob();
				try {
					printJob.print(document, attributeSet);

				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				System.err.println("No existen impresoras instaladas");
			}

			inputStream.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public String validaDatos(List<GenericProductEntity> list, ClienteEntity cliente) {
		String rta = "OK";
		try {
			if (list == null || list.size() <= 0) {
				rta = "No puede facturar si no añade algún producto";
			} else if (cliente.getNombre() == null) {
				rta = "Debe añadir por lo menos un cliente";
			}
		} catch (Exception e) {
			rta = "ERROR";

		}
		return rta;

	}

}
