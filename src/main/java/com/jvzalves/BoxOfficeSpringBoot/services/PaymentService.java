package com.jvzalves.BoxOfficeSpringBoot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.jvzalves.BoxOfficeSpringBoot.DTO.PaymentDTO;
import com.jvzalves.BoxOfficeSpringBoot.entities.Payment;
import com.jvzalves.BoxOfficeSpringBoot.exceptions.OrderIdNotFoundException;
import com.jvzalves.BoxOfficeSpringBoot.exceptions.PaymentIdNotFoundException;
import com.jvzalves.BoxOfficeSpringBoot.repositories.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;

	@Transactional(readOnly = true)
	public PaymentDTO findById(Long id) {
		try {
			 Payment result = paymentRepository.findById(id).get();
			 PaymentDTO dto = new PaymentDTO(result);
			 return dto;
		} catch (Exception e) {
			throw new PaymentIdNotFoundException("Enter a correct id");
		}

	}

	@Transactional(readOnly = true)
	public List<PaymentDTO> findAll() {
		List<Payment> result = paymentRepository.findAll();
		List<PaymentDTO> dto = result.stream().map(x -> new PaymentDTO(x)).toList();
		return dto;
	}
	
	@Transactional
	public PaymentDTO createPayment(@RequestBody Payment payment) {
		try {
			Payment result = paymentRepository.save(payment);
			PaymentDTO dto = new PaymentDTO(result);
			return dto;
		} catch (Exception e) {
			throw new OrderIdNotFoundException("Error creating payment");
		}
	}
	
	@Transactional
	public PaymentDTO updatePayment(@RequestBody Payment payment) {
		try {
			Payment existingPayment = paymentRepository.findById(payment.getId())
					.orElseThrow(() -> new PaymentIdNotFoundException("Payment not found for id: " + payment.getId()));
			
			existingPayment.setType(payment.getType());
			existingPayment.setNameClient(payment.getNameClient());
			existingPayment.setTotalValue(payment.getTotalValue());
			
			Payment upadatePayment = paymentRepository.save(existingPayment);
			PaymentDTO dto = new PaymentDTO(upadatePayment);
			return dto;
			
		} catch (Exception e) {
			throw new PaymentIdNotFoundException("Error updating payment");
		}
	}
}
