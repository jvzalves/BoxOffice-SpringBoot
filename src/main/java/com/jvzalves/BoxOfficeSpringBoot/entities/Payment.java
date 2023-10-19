package com.jvzalves.BoxOfficeSpringBoot.entities;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_payment")
public class Payment {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING) 
    private PaymentType type;
    
    private String nameClient;
    private Double totalValue;
    
	public Payment() {}

	public enum PaymentType{
			
		CREDIT_CARD,
		DEBIT_CARD,
		PIX,
	}

	public Payment(Long id, PaymentType type, String nameClient, Double totalValue) {
		this.id = id;
		this.type = type;
		this.nameClient = nameClient;
		this.totalValue = totalValue;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameClient() {
		return nameClient;
	}

	public void setNameClient(String nameClient) {
		this.nameClient = nameClient;
	}

	public Double getPrice() {
		return totalValue;
	}

	public void setPrice(Double totalValue) {
		this.totalValue = totalValue;
	}

	public PaymentType getType() {
		return type;
	}

	public void setType(PaymentType type) {
		this.type = type;
	}

	public Double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payment other = (Payment) obj;
		return Objects.equals(id, other.id);
	}
	
}
