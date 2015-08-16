package co.com.codesoftware.mb;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import co.com.codesoftware.entities.DatosSessionEntity;
import co.com.codesoftware.logic.DataSessionLogic;
import co.com.codesoftware.logic.LoginLogic;

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private String user;
	private String password;	
	private DatosSessionEntity dataSession ;
	

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

	public String getMessageLogin() {
		String redirection = "";
		try {

			RequestContext context = RequestContext.getCurrentInstance();
			FacesMessage message = null;
			LoginLogic logic = new LoginLogic();
			if ("OK".equalsIgnoreCase(logic.login(this.user, this.password))) {
				FacesContext.getCurrentInstance().getExternalContext()
						.getSessionMap().put("user", this.user);
				message = new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Bienvenido", this.user);
				redirection = "/ACTIONS/inicio";
				//Llena los datos de la session 
				DatosSessionEntity entity = new DatosSessionEntity();
				DataSessionLogic log = new DataSessionLogic();
				entity.setDataCompany(log.getDataCompany());
				entity.setDataUser(log.getDataUser(this.user));
				this.dataSession = entity;
			} else {
				message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error",
						"Datos invalidos");
				redirection = "index";
			}
			FacesContext.getCurrentInstance().addMessage(null, message);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return redirection;
	}

}
