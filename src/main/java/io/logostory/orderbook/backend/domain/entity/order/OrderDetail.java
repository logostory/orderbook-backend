package io.logostory.orderbook.backend.domain.entity.order;

import io.logostory.orderbook.backend.domain.entity.menu.Menu;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderDetailId;

    @ManyToOne
    @JoinColumn(name = "order_orderId")
    private Order orderId;

    private Long menuId;

    private Long count;
    private Long menuPrice;
}
