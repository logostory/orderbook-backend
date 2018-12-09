package io.logostory.orderbook.backend.domain.dto.order;

import io.logostory.orderbook.backend.domain.dto.menu.MenuDto;
import io.logostory.orderbook.backend.domain.entity.order.OrderDetail;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class OrderDto {

    private Long storeId;
    @NotEmpty
    private Long seatId;
    private Long userId;

    private List<OrderDetail> orderDetails;
}
