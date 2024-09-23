package com.jvzalves.filmlist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jvzalves.filmlist.entities.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {}
	


