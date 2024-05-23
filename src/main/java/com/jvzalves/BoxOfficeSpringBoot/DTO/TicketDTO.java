package com.jvzalves.BoxOfficeSpringBoot.DTO;

import org.springframework.beans.BeanUtils;
import org.springframework.hateoas.RepresentationModel;

import com.jvzalves.BoxOfficeSpringBoot.entities.Ticket;

public class TicketDTO extends RepresentationModel<TicketDTO> {
    
	private Long id;
	private String name;
	private String ticketDescription;
	private String year;
	
	public TicketDTO() {}

	public TicketDTO(Ticket entity) {
		BeanUtils.copyProperties(entity, this);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTicketDescription() {
		return ticketDescription;
	}

	public void setTicketDescription(String ticketDescription) {
		this.ticketDescription = ticketDescription;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

}
