package com.jvzalves.BoxOfficeSpringBoot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jvzalves.BoxOfficeSpringBoot.DTO.TicketDTO;
import com.jvzalves.BoxOfficeSpringBoot.entities.Ticket;
import com.jvzalves.BoxOfficeSpringBoot.services.TicketService;

@RestController
@RequestMapping(value = "/api/tickets/v1")
public class TicketController {

	@Autowired
	private TicketService ticketService;

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public TicketDTO findById(@PathVariable Long id) {
		TicketDTO result = ticketService.findById(id);
		return result;
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<TicketDTO> findAll() {
		List<TicketDTO> result = ticketService.findAll();
		return result;
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TicketDTO> createTicket(@RequestBody Ticket ticket) {
		   ticketService.createTicket(ticket);
		   return new ResponseEntity<>(HttpStatus.CREATED);
	}
}