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
    class Menus {
        Long id;
        List<Options> options;
    }

    @Data
    class Options {
        Long id;
    }

}
