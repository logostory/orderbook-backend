package io.logostory.orderbook.backend.domain.entity.order;

import io.logostory.orderbook.backend.domain.entity.AuditEntity;
import io.logostory.orderbook.backend.domain.entity.menu.Option;
import lombok.*;
import org.codehaus.jackson.annotate.JsonBackReference;

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
    Long itemOptionPrice;

    @ManyToOne
    @JoinColumn(name = "itemId")
    @JsonBackReference
    Item item;

    @ManyToOne
    @JoinColumn(name = "optionId")
    Option option;


    public ItemOption setItemOption(Option option) {
        this.itemOptionPrice = option.getPrice();
        return this;
    }
}

