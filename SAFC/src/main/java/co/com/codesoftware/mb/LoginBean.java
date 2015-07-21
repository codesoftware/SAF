package co.com.codesoftware.mb;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;

import co.com.codesoftware.logic.LoginLogic;

@ManagedBean
public class LoginBean {

private String user;
private String password;


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


	public String getMessageLogin(){
		String redirection="";
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;
		LoginLogic logic = new LoginLogic();
		if("OK".equalsIgnoreCase(logic.login(this.user, this.password))){
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", this.user);
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", this.user);
			redirection = "/ACTIONS/home";
		}else{
			message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Datos invalidos");
			redirection = "index";
		}
		FacesContext.getCurrentInstance().addMessage(null, message);
		return redirection;
	}

}
