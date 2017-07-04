package br.com.bandas.business.user;

import org.hibernate.HibernateException;

import br.com.bandas.jpa.dao.UserDAO;
import br.com.bandas.jpa.dao.UserDAOImpl;
import br.com.bandas.jpa.entities.User;

public class UserServiceImpl implements UserService {

	private UserDAO userDAO = new UserDAOImpl();

	@Override
	public User getById(Integer id) {
		return userDAO.get(id);
	}

	@Override
	public User save(User user) {
		return userDAO.save(user);
	}
	
	@Override
	public void update(User user) {
			userDAO.update(user);
	}

	@Override
	public void delete(User id) {
		try{
			userDAO.delete(id);
		} catch (HibernateException e){
			e.printStackTrace();
		}
	}
}
