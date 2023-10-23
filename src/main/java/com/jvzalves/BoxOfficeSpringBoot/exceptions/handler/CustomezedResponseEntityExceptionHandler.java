package com.jvzalves.BoxOfficeSpringBoot.exceptions.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.jvzalves.BoxOfficeSpringBoot.exceptions.ExceptionResponse;
import com.jvzalves.BoxOfficeSpringBoot.exceptions.OrderIdNotFoundException;
import com.jvzalves.BoxOfficeSpringBoot.exceptions.PaymentIdNotFoundException;
import com.jvzalves.BoxOfficeSpringBoot.exceptions.TicketIdNotFoundException;

@ControllerAdvice
@RestController
public class CustomezedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    
   @ExceptionHandler(OrderIdNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleIdOrderNotFoundException(Exception ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }
   
   @ExceptionHandler(PaymentIdNotFoundException.class)
   public ResponseEntity<ExceptionResponse> handleIdPaymentNotFoundException(Exception ex, WebRequest request) {
	   ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
	   return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
   }
   
   @ExceptionHandler(TicketIdNotFoundException.class)
   public ResponseEntity<ExceptionResponse> handleIdTicketNotFoundException(Exception ex, WebRequest request) {
	   ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
	   return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
   }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handleAlException(Exception ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}