package com.sfg.recipe.app.exceptions;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(NOT_FOUND)
public class NotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 5901774083459774471L;

	public NotFoundException() {
		super();
	}
	
	public NotFoundException(String message) {
		super(message);
	}
	
	public NotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}
