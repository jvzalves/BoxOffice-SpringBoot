package com.jvzalves.BoxOfficeSpringBoot.unittests.mockito.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.jvzalves.BoxOfficeSpringBoot.entities.Ticket;
import com.jvzalves.BoxOfficeSpringBoot.repositories.TicketRepository;
import com.jvzalves.BoxOfficeSpringBoot.services.TicketService;

@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class TicketServiceTest {
    
	@Mock
	private TicketRepository ticketRepository;
	
	@InjectMocks
	private TicketService ticketService;
	
	@BeforeEach
	void setUpMocks() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testFindById() {
	    Ticket ticket = new Ticket();
	    
	    ticket.setId(1L);
	    ticket.setName("BATMAN The Dark Knight");
	    ticket.setTicketDescription("When the menace known as The Joker emerges from his mysterious past, he wreaks havoc and chaos on the people of Gotham.");
	    ticket.setYear(Integer.valueOf("2008"));
	    
	    when(ticketRepository.findById(1L))
	    .thenReturn(Optional.of(ticket));
		
	    var result = ticketService.findById(1L);
	    assertNotNull(result);
	    assertNotNull(result.getId());
	    assertNotNull(result.getLinks());
	    
	    System.out.println(result.toString());
	    assertTrue(result.toString().contains("links: [</api/tickets/v1/1>;rel=\"self\"]"));
	    
	    assertEquals("BATMAN The Dark Knight", result.getName());
	    assertEquals("When the menace known as The Joker emerges from his mysterious past, he wreaks havoc and chaos on the people of Gotham.", result.getTicketDescription());
	    assertEquals(2008, result.getYear());;	
	}

	@Test
	void testFindAll() {
		fail("Not yet implemented");
	}

	@Test
	void testCreateTicket() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateTicket() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteById() {
		fail("Not yet implemented");
	}

}
