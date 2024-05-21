package com.jvzalves.BoxOfficeSpringBoot.unittests.mockito.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.jvzalves.BoxOfficeSpringBoot.DTO.TicketDTO;
import com.jvzalves.BoxOfficeSpringBoot.entities.Ticket;
import com.jvzalves.BoxOfficeSpringBoot.exceptions.RequiredObjectIsNullNotFoundException;
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
	void setUpMocks() throws Exception{}
		
	@Test
	void testFindById() {
	    Ticket enitity = new Ticket();
	    
	    enitity.setId(1L);
	    enitity.setName("BATMAN The Dark Knight");
	    enitity.setTicketDescription("When the menace known as The Joker emerges from his mysterious past, he wreaks havoc and chaos on the people of Gotham.");
	    enitity.setYear(Integer.valueOf("2008"));
	    
	    when(ticketRepository.findById(1L)).thenReturn(Optional.of(enitity));
	    
	    var result = ticketService.findById(1L);
	    assertNotNull(result);
	    assertNotNull(result.getId());
	    assertNotNull(result.getLinks());
	    
	    assertTrue(result.toString().contains("links: [</api/tickets/v1/1>;rel=\"self\"]"));
	    assertEquals("BATMAN The Dark Knight", result.getName());
	    assertEquals("When the menace known as The Joker emerges from his mysterious past, he wreaks havoc and chaos on the people of Gotham.", result.getTicketDescription());
	    assertEquals(2008, result.getYear());;	
	}

	@Test
	void testCreateTicket() {
	    Ticket entity = new Ticket();
	    entity.setName("BATMAN The Dark Knight");
	    entity.setTicketDescription("When the menace known as The Joker emerges from his mysterious past, he wreaks havoc and chaos on the people of Gotham.");
	    entity.setYear(2008);
	    
	   
	    Ticket persisted = new Ticket();
	    persisted.setId(1L);
	    persisted.setName(entity.getName());
	    persisted.setTicketDescription(entity.getTicketDescription());
	    persisted.setYear(entity.getYear());
	    
	    when(ticketRepository.save(entity)).thenReturn(persisted);
	    
	    TicketDTO result = ticketService.createTicket(entity);
	    assertNotNull(result);
	    assertNotNull(result.getId());
	    assertNotNull(result.getLinks());
	    assertTrue(result.toString().contains("links: [</api/tickets/v1/1>;rel=\"self\"]"));
	    assertEquals("BATMAN The Dark Knight", result.getName());
	    assertEquals("When the menace known as The Joker emerges from his mysterious past, he wreaks havoc and chaos on the people of Gotham.", result.getTicketDescription());
	    assertEquals(2008, result.getYear());
	}
	
	@Test
	void testCreateWithNullTicket() {
		Exception exception = assertThrows(RequiredObjectIsNullNotFoundException.class, ()-> {
			ticketService.createTicket(null);
		});
		
		String expectedMsg = "It is not allowed to persist a null object";
		String actualMsg = exception.getMessage();
		
		assertTrue(actualMsg.contains(expectedMsg));
	
	}
	
	@Test
	void testUpdateTicket() {
	    Ticket entity = new Ticket();
	    entity.setName("BATMAN The Dark Knight");
	    entity.setTicketDescription("When the menace known as The Joker emerges from his mysterious past, he wreaks havoc and chaos on the people of Gotham.");
	    entity.setYear(2008);
	    
	   
	    Ticket persisted = new Ticket();
	    persisted.setId(1L);
	    persisted.setName(entity.getName());
	    persisted.setTicketDescription(entity.getTicketDescription());
	    persisted.setYear(entity.getYear());
	    
		when(ticketRepository.findById(1L)).thenReturn(Optional.of(entity));
	    when(ticketRepository.save(entity)).thenReturn(persisted);
	    
	    TicketDTO result = ticketService.updateTicket(persisted);

	    assertNotNull(result);
	    assertNotNull(result.getId());
	    assertNotNull(result.getLinks());
	    assertTrue(result.toString().contains("links: [</api/tickets/v1/1>;rel=\"self\"]"));
	    assertEquals("BATMAN The Dark Knight", result.getName());
	    assertEquals("When the menace known as The Joker emerges from his mysterious past, he wreaks havoc and chaos on the people of Gotham.", result.getTicketDescription());
	    assertEquals(2008, result.getYear());
	}
	
	@Test
	void testUpdateWithNullTicket() {
		Exception exception = assertThrows(RequiredObjectIsNullNotFoundException.class, ()-> {
			ticketService.updateTicket(null);
		});
		
		String expectedMsg = "It is not allowed to persist a null object";
		String actualMsg = exception.getMessage();
		
		assertTrue(actualMsg.contains(expectedMsg));
	
	}
	
	@Test
	void testDeleteById() {
		 Ticket enitity = new Ticket();
	
	     when(ticketRepository.findById(1L)).thenReturn(Optional.of(enitity));
	    
	     ticketService.deleteById(1L);
	}
	
	@Test
	void testFindAll() {

	}

}
