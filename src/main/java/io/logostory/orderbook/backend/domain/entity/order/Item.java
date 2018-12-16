package io.logostory.orderbook.backend.domain.entity.order;

import io.logostory.orderbook.backend.domain.entity.menu.Menu;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
@EqualsAndHashCode(of = "itemId")
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long itemId;

    @ManyToOne
    @JoinColumn(name = "orderId")
    Order order;

    @ManyToOne
    @JoinColumn(name = "menuId")
    Menu menu;

    @OneToMany(mappedBy = "item")
    List<ItemOption> itemOptions;

    public void setItemOptions(List<ItemOption> itemOptions) {
        this.itemOptions = itemOptions;
    }

    public void addToItemOptions(ItemOption itemOPtions) {
        itemOPtions.setItem(this);
        this.itemOptions.add(itemOPtions);
    }
}
