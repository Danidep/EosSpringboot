package it.eos.springuser.repository;

import java.util.List;
import it.eos.springuser.model.UserEntity;
import it.eos.springuser.model.UserModel;

public interface Repository {
	
	UserModel save(UserModel user);
	
	List<UserEntity> getUser();
	
	UserModel putUser(UserModel user);
	
	String deleteUser(String Mail);
	
	
}
