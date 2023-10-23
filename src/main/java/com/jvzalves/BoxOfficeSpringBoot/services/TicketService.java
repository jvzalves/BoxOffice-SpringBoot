package com.jvzalves.BoxOfficeSpringBoot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jvzalves.BoxOfficeSpringBoot.DTO.TicketDTO;
import com.jvzalves.BoxOfficeSpringBoot.DTO.TicketMinDTO;
import com.jvzalves.BoxOfficeSpringBoot.entities.Ticket;
import com.jvzalves.BoxOfficeSpringBoot.exceptions.TicketIdNotFoundException;
import com.jvzalves.BoxOfficeSpringBoot.repositories.TicketRepository;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;
    
	@Transactional(readOnly = true)
	public TicketDTO findById(Long id) {
		Optional<Ticket> optionalTicket = ticketRepository.findById(id);

		if (optionalTicket.isEmpty()) {
			throw new TicketIdNotFoundException("Enter a correct id");
		}

		Ticket result = optionalTicket.get();
		TicketDTO dto = new TicketDTO(result);
		return dto;
	}
	
	@Transactional(readOnly = true)
	public List<TicketMinDTO> findAll() {
		List<Ticket> result = ticketRepository.findAll();
		List<TicketMinDTO> dto = result.stream().map(x -> new TicketMinDTO(x)).toList();
		return dto;
	}

}