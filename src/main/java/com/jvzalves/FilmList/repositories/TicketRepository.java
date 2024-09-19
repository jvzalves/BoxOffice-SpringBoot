package com.jvzalves.FilmList.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jvzalves.FilmList.entities.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {}
	


