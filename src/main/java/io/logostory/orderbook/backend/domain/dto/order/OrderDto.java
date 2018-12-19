package io.logostory.orderbook.backend.domain.dto.order;

import io.logostory.orderbook.backend.domain.entity.account.Account;
import io.logostory.orderbook.backend.domain.entity.order.Order;
import io.logostory.orderbook.backend.domain.entity.shop.Shop;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    String seatNumber;

    @Data
    public static class OrderAddDto extends  OrderDto {

        List<ItemDto.ItemAddDto> menus = new ArrayList();
    }

    @Data
    public static class OrderSearchResultDto extends OrderDto {

        Long orderId;
        int totalPrice;

        List<ItemDto.ItemSearchResultDto> items = new ArrayList<>();

        public OrderSearchResultDto(Order order) {

            orderId = order.getOrderId();
            seatNumber = order.getSeatNumber();
            items = order.getItems().stream().map(i -> new ItemDto.ItemSearchResultDto(i)).collect(Collectors.toList());
            totalPrice = order.getTotalPrice();
        }
    }
}
