package com.jvzalves.BoxOfficeSpringBoot.DTO;

import org.springframework.beans.BeanUtils;

import com.jvzalves.BoxOfficeSpringBoot.entities.Payment;

public class PaymentDTO {
	
    private Long id;
	private String nameClient;
	private Double totalValue;

	public PaymentDTO() {}
	
	public PaymentDTO(Payment entity) {
		BeanUtils.copyProperties(entity, this);
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

	public Double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}
}
