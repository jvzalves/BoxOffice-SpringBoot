package com.jvzalves.BoxOfficeSpringBoot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jvzalves.BoxOfficeSpringBoot.DTO.PaymentDTO;
import com.jvzalves.BoxOfficeSpringBoot.entities.Payment;
import com.jvzalves.BoxOfficeSpringBoot.services.PaymentService;

@RestController
@RequestMapping(value = "/api/payments/v1")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	@GetMapping(value = "/{id}", produces =  {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public PaymentDTO findById(@PathVariable Long id)  {
		PaymentDTO result = paymentService.findById(id);
		return result;
	}

	@GetMapping(produces =  {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public List<PaymentDTO> findAll() {
		List<PaymentDTO> result = paymentService.findAll();
		return result;
	}
	
	@PostMapping(consumes =  {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
	             produces =  {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<PaymentDTO> createPayment(@RequestBody Payment payment) {
		   paymentService.createPayment(payment);
		   return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping (produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, 
	             consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}) 
    public ResponseEntity<PaymentDTO>updatePayment(@RequestBody Payment payment) {
	       PaymentDTO updatePayment = paymentService.updatePayment(payment);
	       return new ResponseEntity<>(updatePayment, HttpStatus.OK);       
	       
  }
}
