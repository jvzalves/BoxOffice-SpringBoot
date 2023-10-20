package com.jvzalves.BoxOfficeSpringBoot.DTO;

import org.springframework.beans.BeanUtils;

import com.jvzalves.BoxOfficeSpringBoot.entities.Order;
import com.jvzalves.BoxOfficeSpringBoot.entities.Payment.PaymentType;

public class OrderDTO {
	 
	  private Long id;
	  private PaymentType type;
	  private String nameClient;
	  private String ticketName;
	  private Double totalPurchasePrice;
	 
	   
   public OrderDTO() {}

	public OrderDTO(Order entity) {
		BeanUtils.copyProperties(entity, this);
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


