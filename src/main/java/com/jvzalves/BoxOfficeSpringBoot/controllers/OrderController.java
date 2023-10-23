package com.jvzalves.BoxOfficeSpringBoot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jvzalves.BoxOfficeSpringBoot.DTO.OrderDTO;
import com.jvzalves.BoxOfficeSpringBoot.exceptions.OrderIdNotFoundException;
import com.jvzalves.BoxOfficeSpringBoot.services.OrderService;
	
@RestController
@RequestMapping(value = "/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public OrderDTO findById(@PathVariable Long id) throws Exception {
	    OrderDTO result = orderService.findById(id);

	    if (result == null) {
	        throw new OrderIdNotFoundException("Enter a correct id");
	    }
	    return result;
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<OrderDTO> findAll() {
		List<OrderDTO> result = orderService.findAll();
		return result;
	}
}
