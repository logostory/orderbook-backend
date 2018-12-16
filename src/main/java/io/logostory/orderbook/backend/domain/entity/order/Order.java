package io.logostory.orderbook.backend.domain.entity.order;


import lombok.*;
import org.mapstruct.Mapping;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
@EqualsAndHashCode(of = "orderId")
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "`order`")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;

    private Long storeId;
    private Long seatId;
    private Long userId;
    private Long totalPrice;

    @OneToMany(cascade=CascadeType.ALL, mappedBy="order")
    List<Item> items;

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void addToItems(Item item) {
        item.setOrder(this);
        this.items.add(item);
    }
}
