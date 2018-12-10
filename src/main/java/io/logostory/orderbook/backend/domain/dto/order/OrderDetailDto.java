package io.logostory.orderbook.backend.domain.dto.order;

import io.logostory.orderbook.backend.domain.entity.order.OrderDetail;
import lombok.Data;

import java.util.List;

@Data
public class OrderDetailDto {

    private Long menuId;
    private List<Long> options;
}
