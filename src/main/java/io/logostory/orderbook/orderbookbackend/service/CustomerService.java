package io.logostory.orderbook.orderbookbackend.service;

import io.logostory.orderbook.orderbookbackend.domain.Customer;
import io.logostory.orderbook.orderbookbackend.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepositor;

    public Customer addCustomer(Customer customer) {

    }

    public Customer updateCustomer(Customer customer) {

    }

    public boolean deleteCustomer(Long id) {

    }
}
