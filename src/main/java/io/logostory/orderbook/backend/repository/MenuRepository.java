package io.logostory.orderbook.backend.repository;

import io.logostory.orderbook.backend.domain.entity.menu.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Long> {

}
