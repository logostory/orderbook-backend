package io.logostory.orderbook.backend.service;

import io.logostory.orderbook.backend.domain.dto.menu.MenuDto.*;
import io.logostory.orderbook.backend.domain.entity.menu.Menu;
import io.logostory.orderbook.backend.domain.entity.shop.Shop;
import io.logostory.orderbook.backend.repository.MenuRepository;
import io.logostory.orderbook.backend.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    ShopRepository shopRepository;

    public void create(Menu menu) {
        this.menuRepository.save(menu);
    }

    public List<Menu> addMenuList(Long shopId, List<MenuAddDto> dtos) {

        Shop shop = shopRepository.findById(shopId).get();
        List<Menu> menus = dtos.stream().map(mdto -> mdto.toMenu().setShop(shop)).collect(Collectors.toList());
        menus = menuRepository.saveAll(menus);

        return menus;
    }
}
