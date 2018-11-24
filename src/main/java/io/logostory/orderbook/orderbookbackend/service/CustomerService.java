package io.logostory.orderbook.orderbookbackend.service;

import com.querydsl.core.BooleanBuilder;
import io.logostory.orderbook.orderbookbackend.domain.Customer;
import io.logostory.orderbook.orderbookbackend.domain.QCustomer;
import io.logostory.orderbook.orderbookbackend.domain.dto.CustomerDTO;
import io.logostory.orderbook.orderbookbackend.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public CustomerDTO find(Long id) {
        Optional<Customer> dto = customerRepository.findOne(builder(id));
        return CustomerDTO.of(dto.orElseGet(Customer::new));
    }



    private BooleanBuilder builder(@NotNull Long customerId) {
        BooleanBuilder builder = new BooleanBuilder();
        QCustomer qCustomer = QCustomer.customer;
        builder.and(qCustomer.customerId.eq(customerId));

        return builder;
    }
}
