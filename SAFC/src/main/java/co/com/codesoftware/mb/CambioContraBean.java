package co.com.codesoftware.mb;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import co.com.codesoftware.logic.UsuarioLogic;
import co.com.codesoftware.server.UsuarioTable;

@ManagedBean
@ViewScoped
public class CambioContraBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String contraPrinci;
	private String contraSecund;
	private String usuario;

	public String getContraPrinci() {
		return contraPrinci;
	}

	public void setContraPrinci(String contraPrinci) {
		this.contraPrinci = contraPrinci;
	}

	public String getContraSecund() {
		return contraSecund;
	}

	public void setContraSecund(String contraSecund) {
		this.contraSecund = contraSecund;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * Funcion con la cual se genera la accion de cambiar la clave
	 * obligatoriamente
	 * 
	 * @return
	 */
	public String cambiaContrasenaObliga() {
		String redireccion = "";
		try {
			if (contraPrinci.equals(contraSecund)) {
				if (contraPrinci.length() > 7) {
					UsuarioTable usuario = new UsuarioTable();
					usuario.setUsuario(this.usuario);
					usuario.setPassword(contraPrinci);
					UsuarioLogic usuarioLogic = new UsuarioLogic();
					boolean rta = usuarioLogic.cambiaContrausuario(usuario);
					if(rta){
						FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Contraseña actualiza correctamente, ingrese al sistema con su nueva contraseña", "Exitoso");
						FacesContext.getCurrentInstance().addMessage(null, message);
						redireccion = "index";
					}else{
						FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al actualzar la contraseña", "Error");
						FacesContext.getCurrentInstance().addMessage(null, message);						
					}

				} else {
					FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "La contraseña puede tener minimo siete caracteres", "Error");
					FacesContext.getCurrentInstance().addMessage(null, message);
				}
			} else {
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Las contraseñas no coinciden", "Error");
				FacesContext.getCurrentInstance().addMessage(null, message);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return redireccion;
	}

}
