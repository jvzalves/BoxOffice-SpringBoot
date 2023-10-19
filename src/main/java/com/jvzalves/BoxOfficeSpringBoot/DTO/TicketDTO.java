package com.jvzalves.BoxOfficeSpringBoot.DTO;

import org.springframework.beans.BeanUtils;

import com.jvzalves.BoxOfficeSpringBoot.entities.Ticket;

public class TicketDTO {

	private Long id;
	private String name;
	private String ticketDescription;
	private Double price;
	private Double quantity;

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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}
}
	
