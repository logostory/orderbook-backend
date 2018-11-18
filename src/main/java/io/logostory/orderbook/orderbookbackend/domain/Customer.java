package io.logostory.orderbook.orderbookbackend.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ob_user")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long customerId;

    String customerName;
}
