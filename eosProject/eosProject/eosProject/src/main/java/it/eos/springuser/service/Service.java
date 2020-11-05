package it.eos.springuser.service;

import java.util.List;

import it.eos.springuser.model.UserEntity;
import it.eos.springuser.model.UserModel;

public interface Service {
	
	UserModel save(UserModel user);
	
	List<UserEntity> getUser();
	
	UserModel putUser(UserModel user);
	
	String deleteUser(String Mail);
}
