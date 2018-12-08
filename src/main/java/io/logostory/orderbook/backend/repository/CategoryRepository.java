package io.logostory.orderbook.backend.repository;

import io.logostory.orderbook.backend.domain.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
