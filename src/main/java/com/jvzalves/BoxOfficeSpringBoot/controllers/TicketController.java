package com.jvzalves.BoxOfficeSpringBoot.controllers;

import java.util.ArrayList;
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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/api/tickets/v1")
@Tag(name = "Ticket", description = "Endpoint for Managing Tickets")
public class TicketController {

	@Autowired
	private TicketService ticketService;
	
	   @Operation(
	        summary = "Finds a Tickets", 
	        description = "Finds a Tickets", 
	        tags = {"Ticket"},
	        responses = {
	            @ApiResponse(
	                description = "Success", 
	                responseCode = "200", 
	                content = @Content(schema = @Schema(implementation = TicketDTO.class))),
	           
   @ApiResponse(description="No Content",responseCode="204",content=@Content),
   @ApiResponse(description="Bad Request",responseCode="400",content=@Content),
   @ApiResponse(description="Anauthorized",responseCode="401",content=@Content),
   @ApiResponse(description="Not Found",responseCode="404",content=@Content),
   @ApiResponse(description="Internal Server Error",responseCode="500",content=@Content)

					})
	@GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
	public TicketDTO findById(@PathVariable Long id) {
		TicketDTO result = ticketService.findById(id);
		return result;
	}

	@GetMapping(produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
	   @Operation(
		        summary = "Finds all Tickets", 
		        description = "Finds all Tickets", 
		        tags = {"Ticket"},
		        responses = {
		            @ApiResponse(
		                description = "Success", 
		                responseCode = "200", 
		                content = @Content(
		                    mediaType = "application/json", 
		                    array = @ArraySchema(schema = @Schema(implementation = TicketDTO.class))
		                )
		            ),
	@ApiResponse(description="Bad Request",responseCode="400",content=@Content),
    @ApiResponse(description="Anauthorized",responseCode="401",content=@Content),
    @ApiResponse(description="Not Found",responseCode="404",content=@Content),
    @ApiResponse(description="Internal Server Error",responseCode="500",content=@Content)
					})
	public List<TicketDTO> findAll() {
		List<TicketDTO> result = ticketService.findAll();
		return result;
	}
	
	@PostMapping(consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML},
                 produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
	   @Operation(
		        summary = "Adds a new Ticket", 
		        description = "Adds a new Ticket", 
		        tags = {"Ticket"},
		        responses = {
		            @ApiResponse(
		                description = "Created", 
		                responseCode = "201", 
		                content = @Content(schema = @Schema(implementation = TicketDTO.class))),
		           
	   @ApiResponse(description="Bad Request",responseCode="400",content=@Content),
	   @ApiResponse(description="Anauthorized",responseCode="401",content=@Content),
	   @ApiResponse(description="Internal Server Error",responseCode="500",content=@Content)

						})
    public ResponseEntity<TicketDTO> createTicket(@RequestBody Ticket ticket) {
           TicketDTO dto = ticketService.createTicket(ticket);
           return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }  

	@PutMapping (produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML}, 
                 consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML}) 
	   @Operation(
		        summary = "Updates a Ticket", 
		        description = "Updates a Ticket", 
		        tags = {"Ticket"},
		        responses = {
		            @ApiResponse(
		                description = "Updated", 
		                responseCode = "200", 
		                content = @Content(schema = @Schema(implementation = TicketDTO.class))),
		           
	   @ApiResponse(description="Bad Request",responseCode="400",content=@Content),
	   @ApiResponse(description="Anauthorized",responseCode="401",content=@Content),
	   @ApiResponse(description="Not Found",responseCode="404",content=@Content),
	   @ApiResponse(description="Internal Server Error",responseCode="500",content=@Content)

						})
    public ResponseEntity<TicketDTO>updateTicket(@RequestBody Ticket ticket) {
           TicketDTO updateTicket = ticketService.updateTicket(ticket);
           return new ResponseEntity<>(updateTicket, HttpStatus.OK);
    }
	
	@DeleteMapping("/{id}")
	   @Operation(
		        summary = "Delete a Ticket", 
		        description = "Delete a Ticket", 
		        tags = {"Ticket"},
		        responses = {
	   @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
	   @ApiResponse(description="Bad Request",responseCode="400",content=@Content),
	   @ApiResponse(description="Anauthorized",responseCode="401",content=@Content),
	   @ApiResponse(description="Not Found",responseCode="404",content=@Content),
	   @ApiResponse(description="Internal Server Error",responseCode="500",content=@Content)

						})
	public ResponseEntity<?> deleteById(@PathVariable Long id) {
		ticketService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}