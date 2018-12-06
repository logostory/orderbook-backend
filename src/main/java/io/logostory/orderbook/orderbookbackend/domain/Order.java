package io.logostory.orderbook.orderbookbackend.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "ob_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long orderId;

    String name;

    @ManyToOne
    @JoinColumn(name = "seatId")
    Seat seat;

    @ManyToOne
    @JoinColumn(name = "customerId")
    Customer customer;

    @OneToMany(mappedBy = "orderProductId")
    List<OrderProduct> products;

    int totalPrice;
}
