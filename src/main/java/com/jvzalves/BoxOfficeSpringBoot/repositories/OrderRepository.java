package com.jvzalves.BoxOfficeSpringBoot.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jvzalves.BoxOfficeSpringBoot.entities.Order;
import com.jvzalves.BoxOfficeSpringBoot.projections.OrderProjection;

public interface OrderRepository extends JpaRepository<Order, Long>{
	@Query(nativeQuery = true, value = """
			SELECT orderItem.payment_id AS paymentId, orderItem.ticket_id AS ticketId, orderItem.ticket_name AS ticketName
		    FROM tb_order_item AS orderItem
		    WHERE orderItem.payment_id = :paymentId AND orderItem.ticket_id = :ticketId
				          """)
	List<OrderProjection> findByOrderItem(@Param("paymentId") Long paymentId, @Param("ticketId") Long ticketId);
			    
}
