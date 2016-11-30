package backend;

import java.util.List;

import backend.model.User;

public interface UserDAO {
	
	List<User> getAllUsers() throws RepositoryException;
	
	User getUserById(Long id) throws RepositoryException;
	
	List<User> getUserByFilter();
	
	User insert(User user) throws RepositoryException;
	void update(User user) throws RepositoryException;
	void delete(User user) throws RepositoryException;
}
