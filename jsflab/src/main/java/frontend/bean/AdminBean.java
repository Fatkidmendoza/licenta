package frontend.bean;

import java.util.List;

import backend.DAOFactory;
import backend.UserDAO;
import backend.model.User;

public class AdminBean {
	
	private List<User> userList;
	
	public AdminBean(){
		this.userList = getAllUsers();
	}
	
	public List<User> getAllUsers(){
		DAOFactory df = DAOFactory.getInstance();
		UserDAO bd = df.getUserDAO();
		List<User> a = bd.getAllUsers();
		return a;
	}
}
