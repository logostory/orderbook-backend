package io.logostory.orderbook.backend.domain.entity.order;

import io.logostory.orderbook.backend.domain.entity.AuditEntity;
import io.logostory.orderbook.backend.domain.entity.menu.Option;
import lombok.*;
import org.codehaus.jackson.annotate.JsonIgnore;

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
    @JsonIgnore
    Item item;

    @ManyToOne
    @JoinColumn(name = "optionId")
    Option option;


    public ItemOption setItem(Item item) {
        this.item = item;
        return this;
    }

    public ItemOption setOption(Option option) {
        this.option = option;
        return this;
    }
}

