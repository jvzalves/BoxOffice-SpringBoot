package com.jvzalves.BoxOfficeSpringBoot.DTO;

import java.util.Objects;

import org.springframework.beans.BeanUtils;

import com.jvzalves.BoxOfficeSpringBoot.entities.Ticket;

public class TicketDTO {
   
	private Long id;
	private String name;
	private String ticketDescription;
	private Integer year;
	
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

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
