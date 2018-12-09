package io.logostory.orderbook.backend.repository;

import io.logostory.orderbook.backend.domain.entity.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
