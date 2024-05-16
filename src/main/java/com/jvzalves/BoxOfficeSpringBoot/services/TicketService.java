package com.jvzalves.BoxOfficeSpringBoot.services;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.jvzalves.BoxOfficeSpringBoot.DTO.TicketDTO;
import com.jvzalves.BoxOfficeSpringBoot.controllers.TicketController;
import com.jvzalves.BoxOfficeSpringBoot.entities.Ticket;
import com.jvzalves.BoxOfficeSpringBoot.exceptions.TicketIdNotFoundException;
import com.jvzalves.BoxOfficeSpringBoot.repositories.TicketRepository;

@Service
public class TicketService {

	@Autowired
	private TicketRepository ticketRepository;

	@Transactional(readOnly = true)
	public TicketDTO findById(Long id) {
		try {
			 Ticket result = ticketRepository.findById(id).get();
			 TicketDTO dto = new TicketDTO(result);
			 dto.add(linkTo(methodOn(TicketController.class).findById(id)).withSelfRel());
             return dto;  
		} catch (Exception e) {
			throw new TicketIdNotFoundException("Enter a correct id");
	  }
	}

	@Transactional(readOnly = true)
	public List<TicketDTO> findAll() {
	    List<Ticket> result = ticketRepository.findAll();
		List<TicketDTO> dto = result.stream().map(x -> new TicketDTO(x)).toList();
	    Link selfLink = linkTo(methodOn(TicketController.class).findAll()).withSelfRel();
	    dto.forEach(ticketDTO -> ticketDTO.add(selfLink));
	    return dto;
	}

	@Transactional
	public TicketDTO createTicket(@RequestBody Ticket ticket) {
		try {
			Ticket result = ticketRepository.save(ticket);
			TicketDTO dto = new TicketDTO(result);
			dto.add(linkTo(methodOn(TicketController.class).findById(result.getId())).withSelfRel());
            return dto;  
            
		} catch (Exception e) {
			throw new TicketIdNotFoundException("Error creating ticket");
		}
	}
	
	@Transactional
	public TicketDTO updateTicket(@RequestBody Ticket ticket) {
		try {
			Ticket existingTicket = ticketRepository.findById(ticket.getId())
					.orElseThrow(() -> new TicketIdNotFoundException("Ticket not found for id: " + ticket.getId()));
			
			existingTicket.setName(ticket.getName());
			existingTicket.setTicketDescription(ticket.getTicketDescription());
			existingTicket.setYear(ticket.getYear());
			
			Ticket upadateTicket = ticketRepository.save(existingTicket);
			TicketDTO dto = new TicketDTO(upadateTicket);
			dto.add(linkTo(methodOn(TicketController.class).findById(upadateTicket.getId())).withSelfRel());
            return dto;  
			
		} catch (Exception e) {
			throw new TicketIdNotFoundException("Error updating ticket");
		}
	}
	
	@Transactional
	public void deleteById(Long id) {
		ticketRepository.deleteById(id);
	}
}