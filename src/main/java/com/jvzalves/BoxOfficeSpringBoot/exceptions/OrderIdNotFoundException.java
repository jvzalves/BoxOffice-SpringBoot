package com.jvzalves.BoxOfficeSpringBoot.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class OrderIdNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public OrderIdNotFoundException(String msg) {
		super(msg);
	}
}
