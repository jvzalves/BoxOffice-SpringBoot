package com.jvzalves.BoxOfficeSpringBoot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jvzalves.BoxOfficeSpringBoot.DTO.PaymentDTO;
import com.jvzalves.BoxOfficeSpringBoot.entities.Payment;
import com.jvzalves.BoxOfficeSpringBoot.repositories.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;

	@Transactional(readOnly = true)
	public PaymentDTO findById(Long id) {
		Payment result = paymentRepository.findById(id).get();
		PaymentDTO dto = new PaymentDTO(result);
		return dto;
	}

	@Transactional(readOnly = true)
	public List<PaymentDTO> findAll() {
		List<Payment> result = paymentRepository.findAll();
		List<PaymentDTO> dto = result.stream().map(x -> new PaymentDTO(x)).toList();
		return dto;
	}

	
}
