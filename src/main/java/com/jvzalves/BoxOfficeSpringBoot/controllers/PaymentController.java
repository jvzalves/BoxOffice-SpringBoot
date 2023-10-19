package com.jvzalves.BoxOfficeSpringBoot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jvzalves.BoxOfficeSpringBoot.DTO.PaymentDTO;
import com.jvzalves.BoxOfficeSpringBoot.services.PaymentService;

@RestController
@RequestMapping(value = "/payments")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	@GetMapping(value = "/{id}")
	public PaymentDTO findById(@PathVariable Long id) {
		PaymentDTO result = paymentService.findById(id);
		return result;
	}

	@GetMapping
	public List<PaymentDTO> findAll() {
		List<PaymentDTO> result = paymentService.findAll();
		return result;
	}
}
