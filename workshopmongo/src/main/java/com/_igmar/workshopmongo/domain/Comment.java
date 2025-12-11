package com._igmar.workshopmongo.domain;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import com._igmar.workshopmongo.dto.AuthorDTO;


@Document
public class Comment {

	
	private String text;
	private Date date;
	private AuthorDTO author;
	
	public Comment() {
		
	}


	public Comment(String text, Date date,AuthorDTO author) {
		super();
		this.text = text;
		this.date = date;
		this.author= author;
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public AuthorDTO getAuthor() {
		return author;
	}


	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}
	
	
}
