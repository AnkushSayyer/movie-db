package com.example.demo.exception.handler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.exception.UnauthorizedException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({AccessDeniedException.class})
	public ResponseEntity<Object> handleAccessDeniedException(Exception ex, WebRequest request){
		return new ResponseEntity<Object>(
				"You do not have permission to do this", new HttpHeaders(), HttpStatus.FORBIDDEN);
	}

	@ExceptionHandler({UnauthorizedException.class})
	public ResponseEntity<Object> handleUnauthorizedException(Exception ex, WebRequest request){
		return new ResponseEntity<Object>(
				"Please login", new HttpHeaders(), HttpStatus.UNAUTHORIZED);
	}

}
