package io.logostory.orderbook.backend.service;

import io.logostory.orderbook.backend.domain.entity.menu.Menu;
import io.logostory.orderbook.backend.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    public void create(Menu menu) {
        this.menuRepository.save(menu);
    }
}
