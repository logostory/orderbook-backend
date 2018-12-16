package io.logostory.orderbook.backend.repository;

import io.logostory.orderbook.backend.domain.entity.shop.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<Shop, Long> {

}
