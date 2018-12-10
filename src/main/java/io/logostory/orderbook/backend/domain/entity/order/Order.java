package io.logostory.orderbook.backend.domain.entity.order;


import lombok.Data;
import org.mapstruct.Mapping;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long seatId;
    private Long usrId;
    private Long totalPrice;

    @OneToMany(cascade=CascadeType.ALL, mappedBy="order")
    private List<OrderDetail> orderDetails;
}
