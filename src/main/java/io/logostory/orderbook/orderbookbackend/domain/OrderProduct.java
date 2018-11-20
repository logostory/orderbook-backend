package io.logostory.orderbook.orderbookbackend.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ob_order_product")
public class OrderProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long orderProductId;

    @ManyToOne
    @JoinColumn(name = "orderId")
    Order order;

    @ManyToOne
    @JoinColumn(name = "productId")
    Product product;

    int count;
    int amount;
}
