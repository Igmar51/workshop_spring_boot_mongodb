package com._igmar.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._igmar.workshopmongo.domain.User;
import com._igmar.workshopmongo.repository.UserRepository;
import com._igmar.workshopmongo.services.exception.ObjecNotFoundException;

@Service 
public class UserService {

	@Autowired
	private UserRepository repo;
	
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
	
	if(id == null) {
	 throw new IllegalArgumentException("ID não pode ser nulo");
	}
	
	return repo .findById(id).orElseThrow(() -> new ObjecNotFoundException("Objeto não encotrado"));
	}
}
