package io.logostory.orderbook.backend.repository;

import io.logostory.orderbook.backend.domain.entity.menu.Option;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OptionRepository extends JpaRepository<Option, Long> {
}
