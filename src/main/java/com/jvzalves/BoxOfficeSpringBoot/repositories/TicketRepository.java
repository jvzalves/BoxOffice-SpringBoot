package com.jvzalves.BoxOfficeSpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jvzalves.BoxOfficeSpringBoot.entities.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {}
	


