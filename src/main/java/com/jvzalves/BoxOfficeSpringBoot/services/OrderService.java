package com.jvzalves.BoxOfficeSpringBoot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jvzalves.BoxOfficeSpringBoot.DTO.OrderDTO;
import com.jvzalves.BoxOfficeSpringBoot.entities.Order;
import com.jvzalves.BoxOfficeSpringBoot.exceptions.OrderIdNotFoundException;
import com.jvzalves.BoxOfficeSpringBoot.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Transactional(readOnly = true)
	public OrderDTO findById(Long id) {
		Optional<Order> optionalOrder = orderRepository.findById(id);

		if (optionalOrder.isEmpty()) {
			throw new OrderIdNotFoundException("Enter a correct id");
		}

		Order result = optionalOrder.get();
		OrderDTO dto = new OrderDTO(result);
		return dto;
	}

	@Transactional(readOnly = true)
	public List<OrderDTO> findAll() {
		List<Order> result = orderRepository.findAll();
		List<OrderDTO> dto = result.stream().map(x -> new OrderDTO(x)).toList();
		return dto;
	}

}
