package io.logostory.orderbook.backend.domain.entity.order;

import io.logostory.orderbook.backend.domain.entity.AuditEntity;
import io.logostory.orderbook.backend.domain.entity.menu.Menu;
import io.logostory.orderbook.backend.domain.entity.shop.Shop;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
@EqualsAndHashCode(of = "itemId")
@AllArgsConstructor
@NoArgsConstructor
public class Item  extends AuditEntity {

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


    public Item setMenu(Menu menu) {
        this.menu = menu;
        return this;
    }

    public Item setOrder(Order Order) {
        this.order = order;
        return this;
    }

}
