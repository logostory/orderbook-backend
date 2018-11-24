package io.logostory.orderbook.orderbookbackend.domain;

import io.logostory.orderbook.orderbookbackend.domain.dto.CustomerDTO;
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
    private long customerId;

    private String customerName;


    public static Customer of(CustomerDTO customerDTO){
        Customer customer = new Customer();
        customer.customerId = customerDTO.getCustomerId();
        customer.customerName = customerDTO.getName();
        return customer;
    }
}
