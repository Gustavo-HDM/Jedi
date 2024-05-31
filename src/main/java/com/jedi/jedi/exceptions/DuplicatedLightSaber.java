package com.jedi.jedi.exceptions;

public class DuplicatedLightSaber extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public DuplicatedLightSaber(String message) {
		super(message);
	}

}
