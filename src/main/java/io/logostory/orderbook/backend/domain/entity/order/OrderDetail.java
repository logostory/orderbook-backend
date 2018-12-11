package io.logostory.orderbook.backend.domain.entity.order;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "order_orderId")
    private Order cartId;

    private Long menuId;

    @ManyToOne(optional=false)
    @JoinColumn(name="order")
    private Order order;
}
