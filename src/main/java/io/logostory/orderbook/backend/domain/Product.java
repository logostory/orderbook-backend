package io.logostory.orderbook.backend.domain;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long productId;

    int categoryId;
    int productPrice;
    int productStock;
    String productName;
}
