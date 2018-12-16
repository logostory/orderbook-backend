package io.logostory.orderbook.backend.api;

import io.logostory.orderbook.backend.domain.dto.menu.MenuDto.MenuAddDto;
import io.logostory.orderbook.backend.domain.dto.menu.MenuDto.MenuSearchResultDto;
import io.logostory.orderbook.backend.domain.dto.menu.MenuResponseDto;
import io.logostory.orderbook.backend.domain.entity.menu.Menu;
import io.logostory.orderbook.backend.repository.MenuRepository;
import io.logostory.orderbook.backend.repository.criteria.MenuCriteria;
import io.logostory.orderbook.backend.service.MenuService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Api
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api")
public class MenuApi {

    private final ModelMapper modelMapper;
    private final MenuService menuService;
    private final MenuRepository menuRepository;

    @PostMapping(path = "/shops/{shopId}/menus")
    public ResponseEntity<List<MenuSearchResultDto>> addMenuList(
            @PathVariable Long shopId, @RequestBody List<MenuAddDto> dtos) {

        List<Menu> menus = menuService.addMenuList(shopId, dtos);
        return ResponseEntity.ok(menus.stream().map(m -> new MenuSearchResultDto(m)).collect(Collectors.toList()));
    }

    @GetMapping({"/shops/{shopId}/menus", "/shops/{shopId}/menus/{menuId}"})
    public ResponseEntity<List<MenuResponseDto>> findMenuList(@PathVariable Long shopId, @PathVariable Optional<Long> menuId) {
        List<Menu> menus;
        if (menuId.isPresent()) {
            menus = menuRepository.findByMenu(MenuCriteria.builder().menuId(menuId.get()).shopId(shopId).build());
        } else {
            menus = menuRepository.findByMenu(MenuCriteria.builder().shopId(shopId).build());
        }
        Type listType = new TypeToken<List<MenuResponseDto>>() {}.getType();
        return ResponseEntity.ok(modelMapper.map(menus, listType));
    }
}
