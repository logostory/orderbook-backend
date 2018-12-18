package io.logostory.orderbook.backend.repository;

import io.logostory.orderbook.backend.domain.entity.order.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
