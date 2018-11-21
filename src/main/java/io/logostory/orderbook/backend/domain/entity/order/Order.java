package io.logostory.orderbook.backend.domain.entity.order;


import lombok.Data;
import org.mapstruct.Mapping;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;

    private Long seatId;

    private Long usrId;

    private Long totalPrice;

    @OneToMany
    private List<OrderDetail> orderDetails;
}
