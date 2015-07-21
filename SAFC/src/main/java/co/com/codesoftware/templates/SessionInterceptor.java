package co.com.codesoftware.templates;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import co.com.codesoftware.entities.UserEntity;
@Named
@ViewScoped
public class SessionInterceptor implements Serializable{
	
	public void viewSession() {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = null;
		try {
			UserEntity us = (UserEntity) context.getExternalContext().getSessionMap().get("user");
			if (us == null) {
				message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Sesión expirada");
				context.addMessage(null, message);
				context.getExternalContext().redirect("index.xhtml");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
