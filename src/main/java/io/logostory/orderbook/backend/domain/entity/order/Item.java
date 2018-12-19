package io.logostory.orderbook.backend.domain.entity.order;

import io.logostory.orderbook.backend.domain.entity.AuditEntity;
import io.logostory.orderbook.backend.domain.entity.account.Account;
import io.logostory.orderbook.backend.domain.entity.menu.Menu;
import lombok.*;
import org.codehaus.jackson.annotate.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
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

    String itemName;
    String imagePath;
    Long price;
    String comment;

    @ManyToOne
    @JoinColumn(name = "orderId")
    Order order;

    @ManyToOne
    @JoinColumn(name = "menuId")
    Menu menu;

    @OneToMany(cascade=CascadeType.ALL, mappedBy = "item")
    @JsonManagedReference
    List<ItemOption> itemOptions = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "accountId")
    Account account;

    public Item setOrder(Order order) {
        this.order = order;
        return this;
    }

    public void addItemOption(ItemOption io) {
        io.setItem(this);
        itemOptions.add(io);
    }

    public void setItem(Menu menu){
        this.menu = menu;
        this.itemName = menu.getMenuName();
        this.imagePath = menu.getImagePath();
        this.comment = menu.getComment();
        this.price = menu.getPrice();
    }
}
