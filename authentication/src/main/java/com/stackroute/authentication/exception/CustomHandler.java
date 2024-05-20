package com.stackroute.authentication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import jakarta.servlet.http.HttpServletResponse;

@RestControllerAdvice
public class CustomHandler {
	
	@ExceptionHandler(CredentialsNotMatchingException.class)
	
	public ResponseEntity<String> handleNotmatching(HttpServletResponse res)
	{
		return new ResponseEntity<String>("Credentials are not matching ", HttpStatus.CONFLICT);
	}

	@ExceptionHandler(UserIdNotFoundException.class)
	public ResponseEntity<String> handleNotfound(HttpServletResponse res)
	{
		return new ResponseEntity<String>("UserId not found", HttpStatus.BAD_REQUEST);
	}


	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> handleArgumentNotValid(HttpServletResponse res)
	{
		return new ResponseEntity<String>("Arguments are not Valid ", HttpStatus.BAD_REQUEST);
	}



}
