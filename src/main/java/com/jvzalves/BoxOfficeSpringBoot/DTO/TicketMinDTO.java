package com.jvzalves.BoxOfficeSpringBoot.DTO;

import com.jvzalves.BoxOfficeSpringBoot.entities.Ticket;
import com.jvzalves.BoxOfficeSpringBoot.projections.TicketProjection;

public class TicketMinDTO {
	private Long id;
	private String name;
	
	public TicketMinDTO() {}
	
	public TicketMinDTO(Ticket entity) {
		id = entity.getId();
		name = entity.getName();

	}
	
	public TicketMinDTO(TicketProjection projection) {
		id = projection.getId();
		name = projection.getticketName();
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
	
}
