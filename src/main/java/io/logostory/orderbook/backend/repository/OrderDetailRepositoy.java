package io.logostory.orderbook.backend.repository;

import io.logostory.orderbook.backend.domain.entity.order.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepositoy extends JpaRepository<OrderDetail, Long> {

}
