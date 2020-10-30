package it.eos.springuser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.eos.springuser.repository.UserRepository;
import it.eos.springuser.model.User;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	UserRepository repository;
	
	@PostMapping 
	public ResponseEntity<Object> createUser(@RequestBody User user){
			try {
				return ResponseEntity.ok(repository.save(user));
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
	}
	
	@GetMapping 
	public ResponseEntity<Object> getUser(){
		try {
			return ResponseEntity.ok(repository.getuser());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	@DeleteMapping("/{mail}")
	public HttpStatus deleteUser(@PathVariable("mail") String mail){
		try {
			if(repository.deleteuser(mail).equals("Cancellato")) {
				return HttpStatus.OK;
			}else {
				return HttpStatus.NOT_FOUND;
			}	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	@PutMapping
	public ResponseEntity<Object> putuser(@RequestBody User user){
		try {
			return ResponseEntity.ok(repository.putuser(user));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	
}
	


