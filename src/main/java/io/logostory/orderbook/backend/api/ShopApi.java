package io.logostory.orderbook.backend.api;

import io.logostory.orderbook.backend.domain.dto.ShopDto.ShopAddDto;
import io.logostory.orderbook.backend.domain.dto.ShopDto.ShopSearchResultDto;
import io.logostory.orderbook.backend.domain.entity.shop.Shop;
import io.logostory.orderbook.backend.repository.ShopRepository;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api")
public class ShopApi {

    private final ShopRepository shopRepository;

    @PostMapping(path = "/shops")
    public ResponseEntity<ShopSearchResultDto> addShop(@RequestBody ShopAddDto dto) {

        Shop shop = shopRepository.save(dto.toShop());
        shop = shopRepository.save(shop);
        return ResponseEntity.ok(new ShopSearchResultDto(shop));
    }
}
