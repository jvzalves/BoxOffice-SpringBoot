package com.jvzalves.BoxOfficeSpringBoot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jvzalves.BoxOfficeSpringBoot.DTO.PaymentDTO;
import com.jvzalves.BoxOfficeSpringBoot.entities.Payment;
import com.jvzalves.BoxOfficeSpringBoot.exceptions.PaymentIdNotFoundException;
import com.jvzalves.BoxOfficeSpringBoot.repositories.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;

	@Transactional(readOnly = true)
	public PaymentDTO findById(Long id) {
	    Optional<Payment> optionalPayment = paymentRepository.findById(id);

	    if (optionalPayment.isEmpty()) {
	        throw new PaymentIdNotFoundException("Enter a correct id");
	    }

	    Payment result = optionalPayment.get();
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
