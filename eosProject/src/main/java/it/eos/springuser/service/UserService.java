package it.eos.springuser.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.eos.springuser.business.UserConverter;
import it.eos.springuser.exeption.ResourceNotFoundException;
import it.eos.springuser.model.UserEntity;
import it.eos.springuser.model.UserModel;
import it.eos.springuser.repository.UserRepository;
import net.bytebuddy.implementation.bytecode.Throw;


@Service
public class UserService implements it.eos.springuser.service.Service {
	
	@Autowired
	private UserRepository userService;

	@Override
	public UserModel save(UserModel user) {
		userService.save(UserConverter.toEntity(user));
		return user;
	}

	@Override
	public List<UserEntity> getAllUser() {
		return this.userService.findAll();
	}

	@Override
	public UserModel putUser(UserModel user) {
		Optional<UserEntity> userDB= this.userService.findById(user.getId());
		
		if (userDB.isPresent()) {
			UserEntity putUser=userDB.get();
			putUser.setMail(user.getMail());
			putUser.setPassword(user.getPassword());
			putUser.setName(user.getName());
			userService.save(putUser);
			return user;
		}else {
			throw new ResourceNotFoundException("User not found");
		}
	}

	@Override
	public String deleteUser(Long id) {
		Optional<UserEntity> userDB = this.userService.findById(id);
		
		if(userDB.isPresent()) {
			this.userService.delete(userDB.get());
			return "Deleted";
		}else {
			return "Error";
		}	
	}

	@Override
	public UserModel getUserById(Long id) {
	Optional<UserEntity> userDB = this.userService.findById(id);
		
		if(userDB.isPresent()) {
			return UserConverter.toModel(userDB.get());
		}else {
			throw new ResourceNotFoundException("User not found");
		}
	}
}
