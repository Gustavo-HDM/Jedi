package com.jedi.jedi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(HttpStatus.CONFLICT)
public class DuplicatedLightSaber extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public DuplicatedLightSaber(String message) {
		super(message);
	}
}
