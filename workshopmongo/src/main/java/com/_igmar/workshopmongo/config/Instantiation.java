package com._igmar.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com._igmar.workshopmongo.domain.Comment;
import com._igmar.workshopmongo.domain.Post;
import com._igmar.workshopmongo.domain.User;
import com._igmar.workshopmongo.dto.AuthorDTO;
import com._igmar.workshopmongo.repository.CommentRepository;
import com._igmar.workshopmongo.repository.PostRepository;
import com._igmar.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private CommentRepository commentRepository;
	
	@Override
	public void run(String... arg0) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		commentRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll( Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null,sdf.parse("21/03/2018"),"Partiu viagem","Vou viajar para São Paulo. Abraços!",new AuthorDTO(maria));
		Post post2 = new Post(null,sdf.parse("23/03/2018"),"Bom dia", "Acordei feliz hoje!",new AuthorDTO(maria));
		 
		
		
		Comment com1 = new Comment(" Boa viagem mano!",sdf.parse("21/03/2018"),new AuthorDTO(alex));
		Comment com2 = new Comment( "Tenha um ótimo dia!",sdf.parse("23/03/2018"),new AuthorDTO(alex));
		
				
		postRepository.saveAll(Arrays.asList(post1 , post2));
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);
	    commentRepository.saveAll(Arrays.asList(com1,com2));
		
	}

}
