package io.logostory.orderbook.orderbookbackend.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ob_product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long productId;

    String photoUrl;
    String name;
    int price;
    String detail;
}
