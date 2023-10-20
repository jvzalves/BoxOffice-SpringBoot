package com.jvzalves.BoxOfficeSpringBoot.DTO;

import com.jvzalves.BoxOfficeSpringBoot.entities.Order;
import com.jvzalves.BoxOfficeSpringBoot.entities.Payment.PaymentType;
import com.jvzalves.BoxOfficeSpringBoot.projections.OrderProjection;

public class OrderMinDTO {
	 
	  private Long id;
	  private PaymentType type;
	  private String nameClient;
	  private String ticketName;
	  private Double totalPurchasePrice;
	 
	   
    public OrderMinDTO() {}

	public OrderMinDTO(Order entity) {
		id = entity.getId();
		type = entity.getType();
		nameClient = entity.getNameClient();
		ticketName = entity.getTicketName();
		totalPurchasePrice = entity.getTotalPurchasePrice();
	}
	
	public OrderMinDTO(OrderProjection projection) {
		id = projection.GetId();
		type = projection.getType();
		nameClient = projection.getnameClient();
		ticketName = projection.getticketName();
		totalPurchasePrice = projection.gettotalPurchasePrice();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PaymentType getType() {
		return type;
	}

	public void setType(PaymentType type) {
		this.type = type;
	}

	public String getNameClient() {
		return nameClient;
	}

	public void setNameClient(String nameClient) {
		this.nameClient = nameClient;
	}

	public String getTicketName() {
		return ticketName;
	}

	public void setTicketName(String ticketName) {
		this.ticketName = ticketName;
	}

	public Double getTotalPurchasePrice() {
		return totalPurchasePrice;
	}

	public void setTotalPurchasePrice(Double totalPurchasePrice) {
		this.totalPurchasePrice = totalPurchasePrice;
	}
	   
}


