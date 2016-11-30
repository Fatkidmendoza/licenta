package backend;

public class HibernateDAOFactory extends DAOFactory {

	@Override
	public UserDAO getUserDAO() {
		return new HibernateUserDAO();
	}

	
}
