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

    Long shopId;
    String seatNumber;
    Integer userId;
    int totalPrice;

    @Data
    public static class OrderAddDto extends  OrderDto {

        List<ItemDto.ItemAddDto> items = new ArrayList();

        public Order toOrder() {

            Order order = new Order();
            order.setSeatNumber(seatNumber);
            order.setShop(Shop.builder().shopId(shopId).build());
            order.setAccount(Account.builder().accountId(userId).build());
            order.setItems(items.stream().map(i -> i.toItem()).collect(Collectors.toList()));
            order.setTotalPrice(totalPrice);
            return order;
        }
    }

    @Data
    public static class OrderSearchResultDto extends OrderDto {

        List<ItemDto.ItemSearchResultDto> items = new ArrayList<>();

        public OrderSearchResultDto(Order order) {

            shopId = order.getShop().getShopId();
            seatNumber = order.getSeatNumber();
            userId = order.getAccount().getAccountId();
            items = order.getItems().stream().map(i -> new ItemDto.ItemSearchResultDto(i)).collect(Collectors.toList());
            totalPrice = order.getTotalPrice();
        }
    }
}
