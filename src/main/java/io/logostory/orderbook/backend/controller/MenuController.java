package io.logostory.orderbook.backend.controller;

import io.logostory.orderbook.backend.domain.dto.menu.MenuDto;
import io.logostory.orderbook.backend.domain.dto.menu.OptionDto;
import io.logostory.orderbook.backend.domain.entity.menu.Menu;
import io.logostory.orderbook.backend.repository.CategoryRepository;
import io.logostory.orderbook.backend.repository.MenuRepository;
import io.logostory.orderbook.backend.service.MenuService;
import lombok.AllArgsConstructor;
import org.h2.util.New;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "api")
public class MenuController {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    MenuService menuService;

    MenuRepository menuRepository;

    CategoryRepository categoryRepository;

    @PostMapping("/menus/register")
    public ResponseEntity create(@RequestBody @Valid MenuDto menuDto, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(errors);
        }

        Menu menu = modelMapper.map(menuDto, Menu.class);
        menuService.create(menu);

        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @GetMapping("/{storeId}/menus/{id}")
    public MenuDto findById(@PathVariable Long storeId, @PathVariable Long id) {

         Menu menu =  this.menuRepository.findByShopAndAndMenuId(storeId, id).orElseThrow(()-> new EntityNotFoundException());
        return modelMapper.map(menu, MenuDto.class);
    }
}
