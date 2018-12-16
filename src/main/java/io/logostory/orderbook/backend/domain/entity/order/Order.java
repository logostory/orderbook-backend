package io.logostory.orderbook.backend.domain.entity.order;


import io.logostory.orderbook.backend.domain.entity.AuditEntity;
import io.logostory.orderbook.backend.domain.entity.account.Account;
import lombok.*;
import org.mapstruct.Mapping;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
@EqualsAndHashCode(of = "orderId")
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "`order`")
public class Order extends AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long orderId;

    String seatNumber;

    int totalPrice;

    @OneToMany(cascade=CascadeType.ALL, mappedBy="order")
    List<Item> items;

    @ManyToOne
    @JoinColumn(name = "accountId")
    Account account;
}
