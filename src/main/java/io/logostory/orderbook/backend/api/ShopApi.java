package io.logostory.orderbook.backend.api;

import io.logostory.orderbook.backend.domain.dto.ShopDto;
import io.logostory.orderbook.backend.domain.dto.ShopDto.*;
import io.logostory.orderbook.backend.domain.entity.shop.Shop;
import io.logostory.orderbook.backend.repository.ShopRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api
@RestController
@RequestMapping("/v1/api")
public class ShopApi {

    @Autowired
    ShopRepository shopRepository;


    @PostMapping(path = "/shops")
    public ResponseEntity<ShopSearchResultDto> addShop(@RequestBody ShopAddDto dto) {

        Shop shop = shopRepository.save(dto.toShop());
        shop = shopRepository.save(shop);
        return ResponseEntity.ok(new ShopSearchResultDto(shop));
    }


    @GetMapping(path = "/shops/{shopId}")
    public ResponseEntity<ShopSearchResultDto> findShop(@PathVariable Long shopId) {
        Shop shop = shopRepository.findById(shopId).get();
        return ResponseEntity.ok(new ShopSearchResultDto(shop));
    }
}
