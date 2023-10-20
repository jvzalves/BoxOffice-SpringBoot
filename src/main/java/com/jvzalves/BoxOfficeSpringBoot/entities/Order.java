package com.jvzalves.BoxOfficeSpringBoot.entities;

import com.jvzalves.BoxOfficeSpringBoot.entities.Payment.PaymentType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order")
public class Order {
	  
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;
	  
	  @Enumerated(EnumType.STRING) 
	  private PaymentType type;
	
	  private String nameClient;
	  private String ticketName;
	  private Double totalPurchasePrice;
	 
	   
    public Order() {}

	public Order(Long id, PaymentType type, String nameClient, String ticketName, Double totalPurchasePrice) {
		this.id = id;
		this.type = type;
		this.nameClient = nameClient;
		this.ticketName = ticketName;
		this.totalPurchasePrice = totalPurchasePrice;
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
