package io.logostory.orderbook.backend.domain.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long menuId;

    @ManyToMany
    int categoryId;
    int menuPrice;
    int menuStock;
    String menuName;
}
