package frontend.bean;

import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;

import org.primefaces.context.RequestContext;

import backend.DAOFactory;
import backend.UserDAO;
import backend.model.User;
import frontend.util.SessionUtils;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

	private String username;
    
    private String password;
 
    private String msg;
    
  
    
    public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
   
    public String login() {
    	User found = null;
    	DAOFactory df = DAOFactory.getInstance();
		UserDAO bd = df.getUserDAO();
		List<User> a = bd.getAllUsers();
		
		for(User e : a){
			if(e.getName().equals(username) && e.getPassword().equals(password)){
			 found = e;
			}
			System.out.println(found);
		}

		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);

        if(username != null && username.equals("admin") && password != null && password.equals("admin")) {
        	if (session.getAttribute("username") == null) {

    			session.setAttribute("username", "admin");
        	}
            return "adminUser";
        }
        else if(username != null && username.equals(found.getUserName()) && password.equals(found.getPassword())){
//        	HttpSession session = SessionUtils.getSession();
//			session.setAttribute("username", found.getUserName());
        	return "regularUser";
        }
        else {
           
            System.out.println("pula");
            FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Incorrect Username and Passowrd",
							"Please enter correct username and Password"));
            return "loginPage";
        }
    }   
}
