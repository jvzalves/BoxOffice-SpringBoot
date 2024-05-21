package com.jvzalves.BoxOfficeSpringBoot.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RequiredObjectIsNullNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public RequiredObjectIsNullNotFoundException() {
		super("It is not allowed to persist a null object");
	}
	
    public RequiredObjectIsNullNotFoundException(String msg) {
    	super(msg);
    }
    
}
