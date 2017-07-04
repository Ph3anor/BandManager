package br.com.bandas.business.user;

import br.com.bandas.jpa.entities.User;


public interface UserService {

	
	public User save(User user);
	public User getById(Integer id);

	
	public void update(User user);
	
	public void delete(User id);



}
