package co.com.codesoftware.mb;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import co.com.codesoftware.entities.DatosSessionEntity;
import co.com.codesoftware.logic.DataSessionLogic;
import co.com.codesoftware.logic.LoginLogic;
import co.com.codesoftware.server.UsuarioTable;

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String user;
	private String password;
	private DatosSessionEntity dataSession;

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
			String rtaLogin = logic.login(this.user, this.password);
			if ("OK".equalsIgnoreCase(rtaLogin)) {
				//Obtengo los datos del usuario que se logeo
				DataSessionLogic log = new DataSessionLogic();
				UsuarioTable usuario = log.getDataUser(this.user);
				if(logic.permisoFacturador(usuario.getId())){
					// Obtengo los datos que iran en la session
					DatosSessionEntity entity = new DatosSessionEntity();				
					entity.setDataCompany(log.getDataCompany());
					entity.setDataUser(usuario);
					// Obtengo la session de jsf y le añado los datos de usuario
					FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("dataSession", entity);
					message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", this.user);
					// No se para que sirve
					this.dataSession = entity;
					// Le doy la redireccion que quiero Inicio
					redirection = "/ACTIONS/inicio?faces-redirect=false";
				}else{
					message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "El usuario con el que intenta facturar no tiene autorizacion del administrador, para realizar esta accion");
					redirection = "/index";					
				}
			} else if ("UPD".equalsIgnoreCase(rtaLogin)) {
				message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Debe actualizar la contraseña ya que tiene cambio obligatorio de contraseña", this.user);
				redirection = "/ACTIONS/USUARIO/cambioContOb";
			} else {
				message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Datos invalidos");
				redirection = "/index";
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
