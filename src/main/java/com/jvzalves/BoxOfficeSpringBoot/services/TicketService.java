package com.jvzalves.BoxOfficeSpringBoot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jvzalves.BoxOfficeSpringBoot.entities.Ticket;
import com.jvzalves.BoxOfficeSpringBoot.repositories.TicketRepository;

@Service
public class TicketService {

	@Autowired
	private TicketRepository ticketRepository;

	@Transactional(readOnly = true)
	public List<Ticket> findAll() {
		List<Ticket> result = ticketRepository.findAll();
		return result.stream().map(x -> new Ticket()).toList();
	}

	@Transactional(readOnly = true)
	public Ticket findById(Long id) {
		Ticket result = ticketRepository.findById(id).get();
		return result;

	}

}
