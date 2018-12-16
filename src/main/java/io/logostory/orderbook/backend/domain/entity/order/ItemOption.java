package io.logostory.orderbook.backend.domain.entity.order;

import io.logostory.orderbook.backend.domain.entity.AuditEntity;
import io.logostory.orderbook.backend.domain.entity.menu.Option;
import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@Entity
@EqualsAndHashCode(of = "itemOptionId")
@AllArgsConstructor
@NoArgsConstructor
public class ItemOption  extends AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long itemOptionId;

    @ManyToOne
    @JoinColumn(name = "itemId")
    Item item;

    @ManyToOne
    @JoinColumn(name = "optionId")
    Option option;
}
