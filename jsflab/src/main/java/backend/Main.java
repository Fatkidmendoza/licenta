package backend;

import java.util.List;

import com.mchange.v2.c3p0.C3P0Registry;
import com.mchange.v2.c3p0.PooledDataSource;

import backend.model.User;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User user= new User("andu","11","B");
		User test = new User();
		test.setAge("11");
		test.setBloodType("A");
		test.setEmail("email");
		test.setLastName("andu");
		test.setFirstName("bandu");
		test.setPhone("8574838");
		test.setUserName("Fat");
		test.setAddress("fasdf");
		test.setCnp("fasdf");

		test.setCity("fasdf");
		
		test.setPassword("12345");
		DAOFactory df = DAOFactory.getInstance();
		UserDAO bd = df.getUserDAO();
		//User a = bd.insert(user);
		User a = bd.insert(test);
		User found =null;
//		while(found==null){
//			found =  bd.getUserById(a.getId());
//		}
//		List<User> usersList =bd.getAllUsers();
//		int i=0;
//		for(User e : usersList){
//			
//			System.out.println(e);
//			i++;
//		}
		// = bd.getUserById(a.getId());
	//	System.out.println("pula" + found.getId());
		for (Object o : C3P0Registry.getPooledDataSources()) {
			  try {
			    ((PooledDataSource) o).close();
			  } catch (Exception e) {
			    // oh well, let tomcat do the complaing for us.
			  }
			}
	}

}
