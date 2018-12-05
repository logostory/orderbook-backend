package io.logostory.orderbook.backend.repository;

import io.logostory.orderbook.backend.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
