package it.eos.springuser.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.eos.springuser.model.UserEntity;
import it.eos.springuser.model.UserModel;
import it.eos.springuser.repository.UserRepository;


@Service
public class UserService implements it.eos.springuser.service.Service {
	
	@Autowired
	private UserRepository userService;

	@Override
	public UserModel save(UserModel user) {
		UserEntity saveUser= new UserEntity();
		saveUser.setMail(user.getMail());
		saveUser.setPassword(user.getPassword());
		saveUser.setName(user.getName());
		userService.save(saveUser);
		return user;
	}

	@Override
	public List<UserEntity> getUser() {
		return this.userService.findAll();
	}

	@Override
	public UserModel putUser(UserModel user) {
		Optional<UserEntity> userDB= this.userService.findById(user.getMail());
		
		if (userDB.isPresent()) {
			UserEntity putUser=userDB.get();
			putUser.setMail(user.getMail());
			putUser.setPassword(user.getPassword());
			putUser.setName(user.getName());
			userService.save(putUser);
			return user;
		}else {
			return null;
		}
	}

	@Override
	public String deleteUser(String Mail) {
		Optional<UserEntity> userDB = this.userService.findById(Mail);
		
		if(userDB.isPresent()) {
			this.userService.delete(userDB.get());
			return "Cancellato";
		}else {
			return "Error";
		}	
	}
}
