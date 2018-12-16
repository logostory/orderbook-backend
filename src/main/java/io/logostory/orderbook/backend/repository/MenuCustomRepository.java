package io.logostory.orderbook.backend.repository;

import io.logostory.orderbook.backend.domain.entity.menu.Menu;
import io.logostory.orderbook.backend.repository.criteria.MenuCriteria;

import java.util.List;

public interface MenuCustomRepository {
    List<Menu> findByMenu(MenuCriteria criteria);
}
