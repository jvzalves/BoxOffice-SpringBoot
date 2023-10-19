	package com.jvzalves.BoxOfficeSpringBoot.entities;

import java.util.Objects;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order_item")
public class OrderItem {

	@EmbeddedId
	private OrderPK id = new OrderPK();
	
	private String ticketName;

	public OrderItem() {}
	
	public OrderItem(Payment payment, Ticket ticket, String ticketName) {
		id.setPayment(payment);
		id.setTicket(ticket);
		this.ticketName = ticketName;

	}
	
	public OrderPK getId() {
		return id;
	}

	public void setId(OrderPK id) {
		this.id = id;
	}

	public String getTicketName() {
		return ticketName;
	}

	public void setTicketName(String ticketName) {
		this.ticketName = ticketName;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		return Objects.equals(id, other.id);
	}

}
