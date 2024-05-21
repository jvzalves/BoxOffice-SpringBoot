package com.jvzalves.BoxOfficeSpringBoot.services;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.jvzalves.BoxOfficeSpringBoot.DTO.TicketDTO;
import com.jvzalves.BoxOfficeSpringBoot.controllers.TicketController;
import com.jvzalves.BoxOfficeSpringBoot.entities.Ticket;
import com.jvzalves.BoxOfficeSpringBoot.exceptions.RequiredObjectIsNullNotFoundException;
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
        if (ticket == null) {
            throw new RequiredObjectIsNullNotFoundException("It is not allowed to persist a null object");
        }
        try {
            Ticket result = ticketRepository.save(ticket);
            TicketDTO dto = new TicketDTO(result);
            dto.add(linkTo(methodOn(TicketController.class).findById(result.getId())).withSelfRel());
            return dto;  
        } catch (Exception e) {
            throw new RequiredObjectIsNullNotFoundException("Error creating ticket");
        }
    }

    @Transactional
    public TicketDTO updateTicket(@RequestBody Ticket ticket) {
        if (ticket == null) {
            throw new RequiredObjectIsNullNotFoundException("It is not allowed to persist a null object");
        }
        try {
            Ticket existingTicket = ticketRepository.findById(ticket.getId())
                .orElseThrow(() -> new RequiredObjectIsNullNotFoundException("Ticket not found for id: " + ticket.getId()));
            
            existingTicket.setName(ticket.getName());
            existingTicket.setTicketDescription(ticket.getTicketDescription());
            existingTicket.setYear(ticket.getYear());
            
            Ticket updatedTicket = ticketRepository.save(existingTicket);
            TicketDTO dto = new TicketDTO(updatedTicket);
            dto.add(linkTo(methodOn(TicketController.class).findById(updatedTicket.getId())).withSelfRel());
            return dto;  
        } catch (Exception e) {
            throw new RequiredObjectIsNullNotFoundException("Error updating ticket");
        }
    }

	
	@Transactional
	public void deleteById(Long id) {
		Optional<Ticket> ticket = ticketRepository.findById(id);
		if (ticket.isPresent()) {
			ticketRepository.deleteById(id);
		} else {
			throw new TicketIdNotFoundException("Ticket not found for this id :: " + id);
		}
	}
}