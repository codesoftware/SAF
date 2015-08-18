package co.com.codesoftware.mb;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class ConsultaFacturacionBean {

	private Date	fechaInicio;
	private Date	fechaFinal;

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
		System.out.println("Paso por aqui");
		System.out.println("Fecha inicial" + fechaInicio.toString());
		System.out.println("Fecha final" + fechaFinal.toString());
	}

}
