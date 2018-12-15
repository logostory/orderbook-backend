package io.logostory.orderbook.backend.domain.dto.order;

import lombok.Data;

import java.util.List;

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
