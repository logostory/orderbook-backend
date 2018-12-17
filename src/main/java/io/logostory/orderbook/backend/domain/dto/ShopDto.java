package io.logostory.orderbook.backend.domain.dto;

import io.logostory.orderbook.backend.domain.entity.shop.Shop;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShopDto {

    String shopName;
    String shopImagePath;

    @Setter
    @Getter
    public static class ShopAddDto extends  ShopDto{

        public Shop toShop() {
            return Shop.builder().shopName(shopName).build();
        }
    }

    @Setter
    @Getter
    public static class ShopSearchResultDto extends  ShopDto {

        Long shopId;

        public ShopSearchResultDto(Shop shop) {
            shopId = shop.getShopId();
            shopName = shop.getShopName();
            shopImagePath = shop.getShopImagePath();
        }
    }
}
