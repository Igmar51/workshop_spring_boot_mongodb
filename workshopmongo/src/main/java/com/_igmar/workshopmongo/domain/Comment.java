package com._igmar.workshopmongo.domain;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Comment {

	
	private String text;
	private Date date;
	
	
	public Comment() {
		
	}


	public Comment(String text, Date date) {
		super();
		this.text = text;
		this.date = date;
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
	
	
}
