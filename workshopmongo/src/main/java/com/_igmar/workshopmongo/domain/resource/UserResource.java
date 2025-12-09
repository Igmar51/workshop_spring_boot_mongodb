package com._igmar.workshopmongo.domain.resource;


import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com._igmar.workshopmongo.domain.User;
import com._igmar.workshopmongo.dto.UserDTO;
import com._igmar.workshopmongo.services.UserService;

@RestController
@RequestMapping("/users")
public class UserResource {

     
	@Autowired
	private UserService service;
	
 
    
	//@RequestMapping(method = RequestMethod.GET)
    @GetMapping
	public ResponseEntity< List<UserDTO>> findAll(){
		List<User> list = service.findAll();
		List<UserDTO> listDto= list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
		
	}
	
}
