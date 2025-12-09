package com._igmar.workshopmongo.domain.resources.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com._igmar.workshopmongo.services.exception.ObjecNotFoundException;

import jakarta.servlet.http.HttpServletRequest;
import jdk.jshell.Snippet.Status;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjecNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjecNotFoundException e , HttpServletRequest request) {
		
		HttpStatus status = HttpStatus.NOT_FOUND;

		StandardError err = new StandardError(System.currentTimeMillis(),status.value(),"Não encontrado", e.getMessage(), request.getRequestURI());
	    return ResponseEntity.status(status).body(err);
	}
}
