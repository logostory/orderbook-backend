package io.logostory.orderbook.backend.domain.entity.order;

import io.logostory.orderbook.backend.domain.entity.AuditEntity;
import io.logostory.orderbook.backend.domain.entity.account.Account;
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
public class Item  extends AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long itemId;

    private String itemName;
    private Long price;
    private String comment;

    @ManyToOne
    @JoinColumn(name = "orderId")
    Order order;

    @ManyToOne
    @JoinColumn(name = "menuId")
    Menu menu;

    @OneToMany(mappedBy = "item")
    List<ItemOption> itemOptions;

    @ManyToOne
    @JoinColumn(name = "accountId")
    Account account;
}
