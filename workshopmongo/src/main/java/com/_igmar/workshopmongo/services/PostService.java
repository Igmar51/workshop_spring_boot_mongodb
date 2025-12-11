package com._igmar.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._igmar.workshopmongo.domain.Post;
import com._igmar.workshopmongo.repository.PostRepository;
import com._igmar.workshopmongo.services.exception.ObjecNotFoundException;

@Service 
public class PostService {

	@Autowired
	private PostRepository repo;
	
	
	
	public Post findById(String id) {
	
	if(id == null) {
	 throw new IllegalArgumentException("ID não pode ser nulo");
	}
	return repo .findById(id).orElseThrow(() -> new ObjecNotFoundException("Objeto não encotrado"));
	}
	
	public List<Post> findByTitle(String text){
		return repo.findByTitleContainingIgnoreCase(text);
	}
}

