package com._igmar.workshopmongo.services.exception;

public class ObjecNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;	

	public ObjecNotFoundException(String msg) {
		
		super(msg);
	}
}
