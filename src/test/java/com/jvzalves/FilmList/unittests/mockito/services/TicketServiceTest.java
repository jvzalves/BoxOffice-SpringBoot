package com.jvzalves.FilmList.unittests.mockito.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.jvzalves.FilmList.DTO.TicketDTO;
import com.jvzalves.FilmList.entities.Ticket;
import com.jvzalves.FilmList.exceptions.RequiredObjectIsNullNotFoundException;
import com.jvzalves.FilmList.repositories.TicketRepository;
import com.jvzalves.FilmList.services.TicketService;

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
	    Ticket entity = new Ticket();
	    
	    entity.setId(1L);
	    entity.setName("Name Ticket");
	    entity.setTicketDescription("Description Ticket");
	    entity.setYear("Ticket Year");
	    
	    when(ticketRepository.findById(1L)).thenReturn(Optional.of(entity));
	    
	    var result = ticketService.findById(1L);
	    assertNotNull(result);
	    assertNotNull(result.getId());
	    assertNotNull(result.getLinks());
	    
	    assertTrue(result.toString().contains("links: [</api/tickets/v1/1>;rel=\"self\"]"));
	    assertEquals("Name Ticket", result.getName());
	    assertEquals("Description Ticket", result.getTicketDescription());
	    assertEquals("Ticket Year", result.getYear());;	
	}

	@Test
	void testCreateTicket() {
	    Ticket entity = new Ticket();
	    entity.setName("Name Ticket");
	    entity.setTicketDescription("Description Ticket");
	    entity.setYear("Ticket Year");
	    
	   
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
	    assertEquals("Name Ticket", result.getName());
	    assertEquals("Description Ticket", result.getTicketDescription());
	    assertEquals("Ticket Year", result.getYear());
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
	    entity.setName("Name Ticket");
	    entity.setTicketDescription("Description Ticket");
	    entity.setYear("Ticket Year");
	    
	   
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
	    assertEquals("Name Ticket", result.getName());
	    assertEquals("Description Ticket", result.getTicketDescription());
	    assertEquals("Ticket Year", result.getYear());
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
	  
	    List<Ticket> list = new ArrayList<>();
	    
	    Ticket ticketOne = new Ticket();
	    ticketOne.setId(1L);
	    ticketOne.setName("Name Ticket Test1");
	    ticketOne.setTicketDescription("Description Ticket Test1");
	    ticketOne.setYear("2021");  
	    list.add(ticketOne);
	    
	    Ticket ticketTwo = new Ticket();
	    ticketTwo.setId(2L);
	    ticketTwo.setName("Name Ticket Test2");
	    ticketTwo.setTicketDescription("Description Ticket Test2");
	    ticketTwo.setYear("2022");
	    list.add(ticketTwo);
	    
	    Ticket ticketThree = new Ticket();
	    ticketThree.setId(3L);
	    ticketThree.setName("Name Ticket Test3");
	    ticketThree.setTicketDescription("Description Ticket Test3");
	    ticketThree.setYear("2023");  
	    list.add(ticketThree);
	    
	    when(ticketRepository.findAll()).thenReturn(list);
	    
	    var ticket = ticketService.findAll();
	    
	    assertNotNull(ticket);
	    assertEquals(3, ticket.size());
	    
	    var ticketOneResult = ticket.get(0);  
	    assertNotNull(ticketOneResult);
	    assertNotNull(ticketOneResult.getId());
	    assertEquals("Name Ticket Test1", ticketOneResult.getName());
	    assertEquals("Description Ticket Test1", ticketOneResult.getTicketDescription());
	    assertEquals("2021", ticketOneResult.getYear());  
	    
	    var ticketTwoResult = ticket.get(1);  
	    assertNotNull(ticketTwoResult);
	    assertNotNull(ticketTwoResult.getId());
	    assertEquals("Name Ticket Test2", ticketTwoResult.getName());
	    assertEquals("Description Ticket Test2", ticketTwoResult.getTicketDescription());
	    assertEquals("2022", ticketTwoResult.getYear()); 
	    
	    var ticketThreeResult = ticket.get(2);  
	    assertNotNull(ticketThreeResult);
	    assertNotNull(ticketThreeResult.getId());
	    assertEquals("Name Ticket Test3", ticketThreeResult.getName());
	    assertEquals("Description Ticket Test3", ticketThreeResult.getTicketDescription());
	    assertEquals("2023", ticketThreeResult.getYear());  
	}
}
