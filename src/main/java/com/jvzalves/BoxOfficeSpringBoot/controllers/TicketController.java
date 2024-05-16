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

import com.jvzalves.BoxOfficeSpringBoot.DTO.TicketDTO;
import com.jvzalves.BoxOfficeSpringBoot.entities.Ticket;
import com.jvzalves.BoxOfficeSpringBoot.services.TicketService;
import com.jvzalves.BoxOfficeSpringBoot.util.MediaType;

@RestController
@RequestMapping(value = "/api/tickets/v1")
public class TicketController {

	@Autowired
	private TicketService ticketService;

	@GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
	public TicketDTO findById(@PathVariable Long id) {
		TicketDTO result = ticketService.findById(id);
		return result;
	}

	@GetMapping(produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
	public List<TicketDTO> findAll() {
		List<TicketDTO> result = ticketService.findAll();
		return result;
	}
	
	@PostMapping(consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML},
                 produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
    public ResponseEntity<TicketDTO> createTicket(@RequestBody Ticket ticket) {
           TicketDTO dto = ticketService.createTicket(ticket);
           return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }  

	@PutMapping (produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML}, 
                 consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML}) 
    public ResponseEntity<TicketDTO>updateTicket(@RequestBody Ticket ticket) {
           TicketDTO updateTicket = ticketService.updateTicket(ticket);
           return new ResponseEntity<>(updateTicket, HttpStatus.OK);
    }
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id) {
		ticketService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}