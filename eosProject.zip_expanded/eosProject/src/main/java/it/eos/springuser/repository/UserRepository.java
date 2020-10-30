package it.eos.springuser.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.eos.springuser.model.User;
import it.eos.springuser.service.UserService;

@Service
@Transactional
public class UserRepository implements Repository{
	
	@Autowired
	private UserService userService;
	

	@Override
	public User save(User user) {
		return userService.save(user);
	}

	@Override
	public List<User> getuser() {
		return this.userService.findAll();
	}

	@Override
	public User putuser(User user) {
		Optional<User> userDB= this.userService.findById(user.getMail());
		
		if (userDB.isPresent()) {
			User putuser=userDB.get();
			putuser.setMail(user.getMail());
			putuser.setPsw(user.getPsw());
			putuser.setNome(user.getNome());
			userService.save(putuser);
			return putuser;
		}else {
			return null;
		}
	}

	@Override
	public String deleteuser(String mail) {
		Optional<User> userDB = this.userService.findById(mail);
		
		if(userDB.isPresent()) {
			this.userService.delete(userDB.get());
			return "Cancellato";
		}else {
			return "Error";
		}
		
	}


}
