package io.logostory.orderbook.backend.domain.dto.order;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailDto {

    Long storeId;
    Long seatId;

    List<Menus> menus;

    @Data
    public static class Menus {
        Long menuId;
        List<Options> options;
    }

    @Data
    public static class Options {
        Long optionId;
    }

}
