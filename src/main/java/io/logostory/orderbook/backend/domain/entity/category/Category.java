package io.logostory.orderbook.backend.domain.entity.category;

import io.logostory.orderbook.backend.domain.entity.AuditEntity;
import io.logostory.orderbook.backend.domain.entity.menu.Menu;
import io.logostory.orderbook.backend.domain.entity.shop.Shop;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@EqualsAndHashCode(of = "categoryId")
@AllArgsConstructor
@NoArgsConstructor
public class Category extends AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private Long categoryId;

    private String categoryName;

    @ManyToOne
    @JoinColumn(name = "shopId")
    @Setter(AccessLevel.NONE)
    Shop shop;

    @OneToMany(mappedBy = "category")
    private List<Menu> menus;

    public Category setShop(Shop shop) {
        this.shop = shop;
        return this;
    }
}
