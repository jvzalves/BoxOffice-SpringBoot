package com.jvzalves.filmlist.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TicketIdNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
    public TicketIdNotFoundException(String msg) {
    	super(msg);
    }
}
