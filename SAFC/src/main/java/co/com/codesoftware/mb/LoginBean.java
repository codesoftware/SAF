package co.com.codesoftware.mb;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import co.com.codesoftware.entities.DatosSessionEntity;
import co.com.codesoftware.logic.DataSessionLogic;
import co.com.codesoftware.logic.LoginLogic;

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

	private static final long	serialVersionUID	= 1L;
	private String				user;
	private String				password;
	private DatosSessionEntity	dataSession;

	public DatosSessionEntity getDataSession() {
		return dataSession;
	}

	public void setDataSession(DatosSessionEntity dataSession) {
		this.dataSession = dataSession;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Funcion encargada de realizar el login de usuario
	 * 
	 * @return
	 */
	public String getMessageLogin() {
		String redirection = "";
		try {
			// RequestContext context = RequestContext.getCurrentInstance();
			FacesMessage message = null;
			LoginLogic logic = new LoginLogic();
			if ("OK".equalsIgnoreCase(logic.login(this.user, this.password))) {
				// Obtengo los datos que iran en la session
				DatosSessionEntity entity = new DatosSessionEntity();
				DataSessionLogic log = new DataSessionLogic();
				entity.setDataCompany(log.getDataCompany());
				entity.setDataUser(log.getDataUser(this.user));
				// Obtengo la session de jsf y le añado los datos de usuario
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("dataSession", entity);
				message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", this.user);
				// No se para que sirve
				this.dataSession = entity;
				// Le doy la redireccion que quiero Inicio
				redirection = "/ACTIONS/inicio?faces-redirect=false";
				// redirection = "/ACTIONS/inicio";
			} else {
				message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Datos invalidos");
				redirection = "index";
			}
			FacesContext.getCurrentInstance().addMessage(null, message);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return redirection;
	}

	/**
	 * Funcion encargada de cerrar la session del usuario y redirigirlo a la
	 * pagina de inicio
	 */
	public void cerrarSesion() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

	}

}
