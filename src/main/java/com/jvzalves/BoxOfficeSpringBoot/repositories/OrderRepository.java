package com.jvzalves.BoxOfficeSpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jvzalves.BoxOfficeSpringBoot.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

			    
}
