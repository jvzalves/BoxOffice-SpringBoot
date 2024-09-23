package com.jvzalvesfilmlist.exceptions.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.jvzalves.filmlist.exceptions.ExceptionResponse;
import com.jvzalves.filmlist.exceptions.RequiredObjectIsNullNotFoundException;
import com.jvzalves.filmlist.exceptions.TicketIdNotFoundException;

@ControllerAdvice
@RestController
public class CustomezedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    
   @ExceptionHandler(TicketIdNotFoundException.class)
   public ResponseEntity<ExceptionResponse> handleIdTicketNotFoundException(Exception ex, WebRequest request) {
	   ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
	   return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
   }
   
   @ExceptionHandler(RequiredObjectIsNullNotFoundException.class)
   public ResponseEntity<ExceptionResponse> handleBadRequestException(Exception ex, WebRequest request) {
	   ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
	   return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
   }

@ExceptionHandler(RequiredObjectIsNullNotFoundException.class)
public ResponseEntity<ExceptionResponse> handleInvalidJwtAuthenticationException(Exception ex, WebRequest request) {
	ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
	return new ResponseEntity<>(exceptionResponse, HttpStatus.FORBIDDEN);
  }
}
