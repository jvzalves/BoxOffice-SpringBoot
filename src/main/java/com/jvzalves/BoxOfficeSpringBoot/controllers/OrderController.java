package com.jvzalves.BoxOfficeSpringBoot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jvzalves.BoxOfficeSpringBoot.DTO.OrderDTO;
import com.jvzalves.BoxOfficeSpringBoot.entities.Order;
import com.jvzalves.BoxOfficeSpringBoot.services.OrderService;
import com.jvzalves.BoxOfficeSpringBoot.util.MediaType;

@RestController
@RequestMapping(value = "/api/orders/v1")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})	
	public OrderDTO findById(@PathVariable Long id) {
		OrderDTO result = orderService.findById(id);
		return result;
	}

	@GetMapping(produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})	
	public List<OrderDTO> findAll() {
		List<OrderDTO> result = orderService.findAll();
		return result;
	}
	
	@PostMapping(produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML}, 
			     consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML}) 
	public ResponseEntity<OrderDTO> createOrder(@RequestBody Order order) {
		   orderService.createOrder(order);
		   return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping (produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML}, 
		         consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML}) 
	public ResponseEntity<OrderDTO>updateOrder(@RequestBody Order order) {
		  OrderDTO updatedOrder = orderService.updateOrder(order);
		  return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id) {
		orderService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
