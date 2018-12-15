package io.logostory.orderbook.backend.api;

import io.logostory.orderbook.backend.domain.dto.category.CategoryDto;
import io.logostory.orderbook.backend.domain.dto.menu.MenuDto.*;
import io.logostory.orderbook.backend.domain.entity.category.Category;
import io.logostory.orderbook.backend.domain.entity.menu.Menu;
import io.logostory.orderbook.backend.service.MenuService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Api
@RestController
@RequestMapping("/v1/api")
public class MenuApi {


    @Autowired  MenuService menuService;

    @PostMapping(path = "/shops/{shopId}/menus")
    public ResponseEntity<List<MenuSearchResultDto>> addMenuList(
            @PathVariable Long shopId, @RequestBody List<MenuAddDto> dtos) {

        List<Menu> menus = menuService.addMenuList(shopId, dtos);
        return ResponseEntity.ok( menus.stream().map(m -> new MenuSearchResultDto(m)).collect(Collectors.toList()) );
    }
}
