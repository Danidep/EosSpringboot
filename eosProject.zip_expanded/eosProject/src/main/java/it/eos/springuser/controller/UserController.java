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
import it.eos.springuser.service.UserService;
import it.eos.springuser.model.UserModel;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	UserService repository;
	
	@PostMapping 
	public ResponseEntity<Object> createUser(@RequestBody UserModel user){
			try {
				return ResponseEntity.ok(repository.save(user));
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(new Error("Server unable to handle request"));
			}
	}
	
	@GetMapping 
	public ResponseEntity<Object> getUser(){
		try {
			return ResponseEntity.ok(repository.getUser());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(new Error("Server unable to handle request"));
		}
		
	}
	
	@DeleteMapping("/{mail}")
	public HttpStatus deleteUser(@PathVariable("mail") String mail){
		try {
			if(repository.deleteUser(mail).equals("Cancellato")) {
				return HttpStatus.OK;
			}else {
				return HttpStatus.NOT_FOUND;
			}	
		} catch (Exception e) {
			return HttpStatus.BAD_GATEWAY;
		}
		
	}
	
	@PutMapping
	public ResponseEntity<Object> putuser(@RequestBody UserModel user){
		try {
			return ResponseEntity.ok(repository.putUser(user));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(new Error("Server unable to handle request"));
		}
		
	}
	
	
}
	


