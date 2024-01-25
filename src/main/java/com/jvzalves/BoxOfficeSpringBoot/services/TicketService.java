package com.jvzalves.BoxOfficeSpringBoot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.jvzalves.BoxOfficeSpringBoot.DTO.TicketDTO;
import com.jvzalves.BoxOfficeSpringBoot.entities.Ticket;
import com.jvzalves.BoxOfficeSpringBoot.exceptions.OrderIdNotFoundException;
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
			 return dto;

		} catch (Exception e) {
			throw new TicketIdNotFoundException("Enter a correct id");
	  }
	}

	@Transactional(readOnly = true)
	public List<TicketDTO> findAll() {
		List<Ticket> result = ticketRepository.findAll();
		List<TicketDTO> dto = result.stream().map(x -> new TicketDTO(x)).toList();
		return dto;
	}
	
	@Transactional
	public TicketDTO createTicket(@RequestBody Ticket ticket) {
		try {
			Ticket result = ticketRepository.save(ticket);
			TicketDTO dto = new TicketDTO(result);
			return dto;
		} catch (Exception e) {
			throw new OrderIdNotFoundException("Error creating payment");
		}
	}
	
}