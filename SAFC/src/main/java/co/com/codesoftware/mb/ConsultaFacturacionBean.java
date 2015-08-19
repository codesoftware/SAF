package co.com.codesoftware.mb;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import co.com.codesoftware.logic.ConsultaFacturaLogic;
import co.com.codesoftware.server.FacturaTable;

@ManagedBean
@RequestScoped
public class ConsultaFacturacionBean {

	private Date fechaInicio;
	private Date fechaFinal;
	private List<FacturaTable> facturas;
	private List<FacturaTable> facturasFiltradas;

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public List<FacturaTable> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<FacturaTable> facturas) {
		this.facturas = facturas;
	}

	public List<FacturaTable> getFacturasFiltradas() {
		return facturasFiltradas;
	}

	public void setFacturasFiltradas(List<FacturaTable> facturasFiltradas) {
		this.facturasFiltradas = facturasFiltradas;
	}

	/**
	 * Funcion con la cual busco las facturas en un rango determinado de fechas
	 */
	public void consultaFacturasXFechas() {
		if (fechaInicio == null) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "La fecha inicial no puede ser nula"));
			return;
		}
		if (fechaFinal == null) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "La fecha final no puede ser nula"));
			return;
		}
		ConsultaFacturaLogic logic = new ConsultaFacturaLogic();
		this.facturas = logic.consultaFacturasRangoFechas(fechaInicio, fechaFinal);
		if (this.facturas == null) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "La consulta no arrojo ningun resultado"));
		}

	}

	/**
	 * Funcion encargada de realizar la busqueda de una factura en especifico
	 * 
	 * @param obj
	 */
	public void buscaFacturaEspecifico() {
		System.out.println("Paso por aqui");
		//System.out.println("pasa por aqui" + obj.toString());
	}

}
