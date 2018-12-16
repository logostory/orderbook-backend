package io.logostory.orderbook.backend.repository;

import io.logostory.orderbook.backend.domain.entity.order.ItemOption;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemOptionRepository extends JpaRepository<ItemOption,Long> {
}
