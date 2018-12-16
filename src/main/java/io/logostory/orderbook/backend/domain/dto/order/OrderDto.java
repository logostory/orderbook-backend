package io.logostory.orderbook.backend.domain.dto.order;

import io.logostory.orderbook.backend.domain.entity.order.Item;
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

    private Long shopId;
    private Long seatNumber;
    List<ItemDto> items;



}
