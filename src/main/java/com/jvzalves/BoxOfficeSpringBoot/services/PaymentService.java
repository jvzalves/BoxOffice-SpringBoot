package com.jvzalves.BoxOfficeSpringBoot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jvzalves.BoxOfficeSpringBoot.entities.Payment;
import com.jvzalves.BoxOfficeSpringBoot.repositories.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;

	@Transactional(readOnly = true)
	public List<Payment> findAll() {
		List<Payment> result = paymentRepository.findAll();
		return result.stream().map(x -> new Payment()).toList();
	}

	@Transactional(readOnly = true)
	public Payment findById(Long id) {
		Payment result = paymentRepository.findById(id).get();
		return result;

	}
}
