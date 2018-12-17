package io.logostory.orderbook.backend.domain.entity.shop;

import io.logostory.orderbook.backend.domain.entity.AuditEntity;
import io.logostory.orderbook.backend.domain.entity.category.Category;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@EqualsAndHashCode(of = "shopId")
@AllArgsConstructor
@NoArgsConstructor
public class Shop extends AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long shopId;
    String shopName;
    String shopImagePath;

    @OneToMany(mappedBy = "shop")
    List<Category> categories;
}
