package io.logostory.orderbook.backend.controller;

import io.logostory.orderbook.backend.domain.entity.Menu;
import io.logostory.orderbook.backend.repository.MenuRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@AllArgsConstructor
@RequestMapping(value = "api")
public class MenuController {

    private final MenuRepository menuRepository;
    private final ModelMapper modelmapper;


    @PostMapping(path = "/menus")
    @ResponseStatus(HttpStatus.CREATED)
    public Menu saveProduct(@RequestBody Menu product) {

        return this.menuRepository.save(product);
    }

    @GetMapping(path = "/menus/{menuId}")
    public Optional<Menu> findById(@PathVariable Long menuId) {
        return this.menuRepository.findById(menuId);
    }
}
