package co.com.codesoftware.mb;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import co.com.codesoftware.entities.DatosSessionEntity;
import co.com.codesoftware.logic.ConsultaFacturaLogic;
import co.com.codesoftware.server.FacturaTable;

@ManagedBean
@ViewScoped
public class ConsultaFacturacionBean {

	private Date fechaInicio;
	private Date fechaFinal;
	private List<FacturaTable> facturas;
	private List<FacturaTable> facturasFiltradas;
	private FacturaTable factComplete;
	private DatosSessionEntity entitySession;
	private BigDecimal totalCaja;

	public DatosSessionEntity getEntitySession() {
		return entitySession;
	}

	public void setEntitySession(DatosSessionEntity entitySession) {
		this.entitySession = entitySession;
	}

	public BigDecimal getTotalCaja() {
		return totalCaja;
	}

	public void setTotalCaja(BigDecimal totalCaja) {
		this.totalCaja = totalCaja;
	}

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

	public FacturaTable getFactComplete() {
		return factComplete;
	}

	public void setFactComplete(FacturaTable factComplete) {
		this.factComplete = factComplete;
	}
	@PostConstruct
	public void init() {
		try {
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
	 * Funcion con la cual busco las facturas en un rango determinado de fechas
	 */
	public void consultaFacturasXFechas() {
		if (fechaInicio == null) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "La fecha inicial no puede ser nula"));
			return;
		}
		if (fechaFinal == null) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "La fecha final no puede ser nula"));
			return;
		}
		ConsultaFacturaLogic logic = new ConsultaFacturaLogic();
		this.facturas = logic.consultaFacturasRangoFechas(fechaInicio, fechaFinal);
		if (this.facturas == null) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "La consulta no arrojo ningun resultado"));
		}

	}

	/**
	 * Funcion que actualiza la pantalla de consultar el saldo
	 */
	public void consultaSaldoCaja(){
		ConsultaFacturaLogic logic = new ConsultaFacturaLogic();
		totalCaja = logic.consultaCajaXSede(this.entitySession.getDataUser().getSede());
	}

	/**
	 * Funcion encargada de realizar la busqueda de una factura en especifico
	 * 
	 * @param obj
	 */
	public void buscaFacturaEspecifico(FacturaTable obj) {
		ConsultaFacturaLogic logic = new ConsultaFacturaLogic();
		try {
			this.factComplete = logic.consutlaFacturaXId(obj.getId());
			if (this.factComplete == null) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Error!", "La consulta de la factura especifica no arrojo ningun resultado"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String redireccionConsultaFacturacion() {
		return "/ACTIONS/FACTURACION/buscaFacturas";
	}

}
