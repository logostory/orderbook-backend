package io.logostory.orderbook.backend.repository;

import io.logostory.orderbook.backend.domain.entity.menu.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Long> {

    @Query("select m from Menu m where m.shop.shopId = ?1 and m.menuId = ?2")
    public Menu findMenuByShopAndMenu(Long shopId, Long menuId);

    @Query("select m from Menu m where m.shop.shopId = ?1")
    public List<Menu> findMenuListByShopId(Long shopId);



}
