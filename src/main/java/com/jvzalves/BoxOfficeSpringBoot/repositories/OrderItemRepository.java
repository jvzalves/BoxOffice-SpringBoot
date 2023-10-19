package com.jvzalves.BoxOfficeSpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jvzalves.BoxOfficeSpringBoot.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{
}
/*@Query(nativeQuery = true, value = """
			
			
			
			
				""")
	List<OrderItemProjection> findByOrderItem(Long paymentId, Long ticketId);




SELECT tb_game.id, tb_game.title, tb_game.game_year AS gameYear, tb_game.img_url AS imgUrl,
tb_game.short_description AS shortDescription, tb_belonging.position
FROM tb_game
INNER JOIN tb_belonging ON tb_game.id = tb_belonging.game_id
WHERE tb_belonging.list_id = :listId
ORDER BY tb_belonging.position*/