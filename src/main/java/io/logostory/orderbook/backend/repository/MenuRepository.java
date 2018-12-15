package io.logostory.orderbook.backend.repository;

import io.logostory.orderbook.backend.domain.entity.menu.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MenuRepository extends JpaRepository<Menu, Long> {

    Optional<Menu> findByShopAndAndMenuId(Long stroeId, Long MenuId);
}
