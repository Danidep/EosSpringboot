package it.eos.springuser.service;

import org.springframework.data.jpa.repository.JpaRepository;

import it.eos.springuser.model.User;

public interface UserService extends JpaRepository<User, String>{

}
