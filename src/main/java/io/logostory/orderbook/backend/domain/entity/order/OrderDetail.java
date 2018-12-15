package io.logostory.orderbook.backend.domain.entity.order;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long menuId;
    private Long price;

    @ManyToOne(optional=false)
    @JoinColumn(name="order")
    private Order order;
}
