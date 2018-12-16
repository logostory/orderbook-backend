package io.logostory.orderbook.backend.domain.dto.order;

import io.logostory.orderbook.backend.domain.entity.order.Order;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    private Long storeId;
    @NotEmpty
    private Long seatId;
    private Long userId;
    private Long totalPrice;




    @Data
    public static  class AddOrderDto extends OrderDto{

        private List<ItemDto.AddItemDto> items;

        public Order toOrder() {

            Order order = new Order();
            order.setUserId(getUserId());
            order.setSeatId(getSeatId());
            order.setStoreId(getStoreId());
            order.setTotalPrice(getTotalPrice());
            order.setItems(items);
            return order;
        }

    }

   /* @Data
    public static class MenuSearchResultDto extends MenuDto {

        Long menuId;

        public MenuSearchResultDto(Menu m) {

            menuId = m.getMenuId();
            categoryId = m.getCategory().getCategoryId();
            name = m.getMenuName();
            price = m.getPrice();
            comment = m.getComment();
            imagePath = m.getImagePath();

        }*/
}
