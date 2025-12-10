package com._igmar.workshopmongo.domain;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Comment {

	
	private String text;
	private Date date;
	private User author;
	
	public Comment() {
		
	}


	public Comment(String text, Date date,User author) {
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


	public User getAuthor() {
		return author;
	}


	public void setAuthor(User author) {
		this.author = author;
	}
	
	
}
