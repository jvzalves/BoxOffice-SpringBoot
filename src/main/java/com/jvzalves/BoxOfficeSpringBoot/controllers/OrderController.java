package com.jvzalves.BoxOfficeSpringBoot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jvzalves.BoxOfficeSpringBoot.DTO.OrderDTO;
import com.jvzalves.BoxOfficeSpringBoot.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
   
	@GetMapping(value = "/{id}")
	public OrderDTO findById(@PathVariable Long id) {
		OrderDTO result = orderService.findById(id);
		return result;
	}
	
	@GetMapping
	public List<OrderDTO> findAll() {
		List<OrderDTO> result = orderService.findAll();
		return result;
	}
}
