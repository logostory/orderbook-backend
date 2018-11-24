package io.logostory.orderbook.orderbookbackend.domain.dto;

import io.logostory.orderbook.orderbookbackend.domain.Customer;
import lombok.Data;

@Data
public class CustomerDTO {

    private Long customerId;
    private String name;


    public static CustomerDTO of(Customer customer){
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.customerId = customer.getCustomerId();
        customerDTO.name = customer.getCustomerName();
        return customerDTO;
    }


}
