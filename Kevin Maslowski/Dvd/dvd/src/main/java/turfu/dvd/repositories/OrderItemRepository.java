package turfu.dvd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import turfu.dvd.domains.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {}
