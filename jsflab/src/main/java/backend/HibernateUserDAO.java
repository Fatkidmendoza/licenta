package backend;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.mysql.jdbc.Connection;

import backend.model.User;

public class HibernateUserDAO implements UserDAO {
	private final SessionFactory sessionF;
	private final DAOFactory df;
	
	public  HibernateUserDAO() {
		sessionF = HibernateUtil.getSessionFactory();
		df = DAOFactory.getInstance();
	}
	
	
	@Override
	public List<User> getAllUsers() throws RepositoryException {
		Session session = sessionF.openSession();
		@SuppressWarnings("unchecked")						
		List<User> users = session.createQuery("FROM User").list();
		session.close();
		System.out.println("Found " + users.size() + " Accounts");
		return users;
	}

	@Override
	public User getUserById(Long id) throws RepositoryException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUserByFilter() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User insert(User user) throws RepositoryException {
	
		Session session = sessionF.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		System.out.println("Successfully created" + user.toString());
		return user;

	}
	
	public  User findByIDAccount(Long id) {
		User tmp= null;
		Session session = sessionF.openSession();
		List<User> users = session.createQuery("FROM User").list();
		for(User userWithId: users){
			if(userWithId.getId() == id){
				tmp = userWithId;
			}
		}
		session.close();
		return tmp;
	}

	@Override
	public void update(User user) throws RepositoryException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(User user) throws RepositoryException {
		// TODO Auto-generated method stub

	}
/*
 * 
 * public static Integer create(Account e) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		session.save(e);
		session.getTransaction().commit();
		session.close();
		System.out.println("Successfully created" + e.toString());
		return e.getId();

	}
	

	public static List<Account> read() {
		Session session = getSessionFactory().openSession();
		@SuppressWarnings("unchecked")						
		List<Account> accunts = session.createQuery("FROM Account").list();
		session.close();
		System.out.println("Found " + accunts.size() + " Accounts");
		return accunts;

	}

	public static void updateAccount(Account e) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		Account em = (Account) session.load(Account.class, e.getId());
 		em.setDateOfCreation(e.getDateOfCreation());
		em.setId(e.getId());
		em.setType(e.getType());
		
		session.getTransaction().commit();
		session.close();
		System.out.println("Successfully updated " + e.toString());
	}

	public static void deleteAccount(Integer id) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		Account e = findByIDAccount(id);
		session.delete(e);
		session.getTransaction().commit();
		session.close();
		System.out.println("Successfully deleted " + e.toString());

	}

	public static Account findByIDAccount(Integer id) {
		Account tmp= null;
		Session session = getSessionFactory().openSession();
		List<Account> accounts = session.createQuery("FROM Account").list();
		for(Account accountWithId: accounts){
			if(accountWithId.getId() == id){
				tmp = accountWithId;
			}
		}
		//Flight e = (Flight) session.load(Flight.class, id);
		session.close();
		return tmp;
	}
	
	public static void deleteAll() {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("DELETE FROM Account ");
		query.executeUpdate();
		session.getTransaction().commit();
		session.close();
		System.out.println("Successfully deleted all users.");
	}
 * 
 */
}
