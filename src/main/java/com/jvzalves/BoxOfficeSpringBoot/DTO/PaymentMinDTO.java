package com.jvzalves.BoxOfficeSpringBoot.DTO;

import com.jvzalves.BoxOfficeSpringBoot.entities.Payment;
import com.jvzalves.BoxOfficeSpringBoot.projections.PaymentProjection;

public class PaymentMinDTO {
	
    private Long id;
	private String nameClient;
	private Double totalValue;

	public PaymentMinDTO() {}
	
	public PaymentMinDTO(Payment entity) {
		 id = entity.getId();
		 nameClient = entity.getNameClient();
		 totalValue = entity.getTotalValue();
	}
	
	public PaymentMinDTO(PaymentProjection projection) {
		id = projection.getId();
		nameClient = projection.getnameClient();
		totalValue = projection.gettotalValue();
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
