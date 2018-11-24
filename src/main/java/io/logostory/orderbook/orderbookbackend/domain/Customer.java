package io.logostory.orderbook.orderbookbackend.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ob_user")
public class Customer {

    // wrapper 를 쓴 이유
    // https://stackoverflow.com/questions/7506802/using-wrapper-integer-class-or-int-primitive-in-hibernate-mapping

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long customerId;

    private String customerName;

}
