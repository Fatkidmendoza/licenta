package backend;

public abstract class DAOFactory {
	public static DAOFactory getInstance(){
		return new HibernateDAOFactory();
	}
	
	
	public abstract UserDAO getUserDAO();
	//public abstract MedicalAssistantDAO getMedicalAssistantDAO(); 
	
}
