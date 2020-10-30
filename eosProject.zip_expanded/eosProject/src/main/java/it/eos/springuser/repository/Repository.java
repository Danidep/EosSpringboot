package it.eos.springuser.repository;

import java.util.List;
import it.eos.springuser.model.User;

public interface Repository {
	User save(User user);
	List<User> getuser();
	User putuser(User user);
	String deleteuser(String mail);
	
	
}
