package com.jvzalves.BoxOfficeSpringBoot.projections;

import com.jvzalves.BoxOfficeSpringBoot.entities.Payment.PaymentType;

public interface OrderProjection {
	
	   Long GetId();
	   PaymentType getType();
	   String getnameClient();
	   String getticketName();
	   Double gettotalPurchasePrice();
	   
}
