package co.com.codesoftware.interceptor;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import co.com.codesoftware.entities.DatosSessionEntity;

@ManagedBean
@ViewScoped
public class InterceptorSession implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Funcion con la cual verifico si la session existe
	 */
	public void verificarSesion() {
		try {
			FacesMessage message = null;
			FacesContext context = FacesContext.getCurrentInstance();
			DatosSessionEntity entity = (DatosSessionEntity) context.getExternalContext().getSessionMap().get("dataSession");

			if (entity == null) {
				message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Esta intentando a un sitio no permitido porfavor realice el login primero");
				context.getExternalContext().redirect("../index.jsf");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
