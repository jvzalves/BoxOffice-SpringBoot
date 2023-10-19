package com.jvzalves.BoxOfficeSpringBoot.DTO;

public class OrderItemDTO {
	
	private Long id;
	private String ticketName;
   
	public OrderItemDTO() {}

	public OrderItemDTO(Long id, String ticketName) {
		this.id = id;
		this.ticketName = ticketName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTicketName() {
		return ticketName;
	}

	public void setTicketName(String ticketName) {
		this.ticketName = ticketName;
	}
	
}
