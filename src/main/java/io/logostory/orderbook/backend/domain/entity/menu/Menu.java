package io.logostory.orderbook.backend.domain.entity.menu;

import io.logostory.orderbook.backend.domain.entity.AuditEntity;
import io.logostory.orderbook.backend.domain.entity.category.Category;
import io.logostory.orderbook.backend.domain.entity.order.OrderDetail;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Menu extends AuditEntity {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Category categoryId;
    private String name;
    private Long price;
    private String imagePath;
    private String comment;

    @OneToMany
    private List<Option> options;
    @OneToMany
    private List<OrderDetail> orderDetails;

}
