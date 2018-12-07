package io.logostory.orderbook.backend.controller;

import io.logostory.orderbook.backend.domain.dto.account.AccountDto;
import io.logostory.orderbook.backend.domain.dto.menu.MenuDto;
import io.logostory.orderbook.backend.domain.entity.menu.Menu;
import io.logostory.orderbook.backend.service.MenuService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "api/menu")
public class MenuController {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    MenuService menuService;

    @PostMapping("/register")
    public ResponseEntity create(@RequestBody @Valid MenuDto menuDto, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(errors);
        }

        Menu menu = modelMapper.map(menuDto, Menu.class);
        menuService.create(menu);

        return ResponseEntity.ok(HttpStatus.CREATED);
    }
}
