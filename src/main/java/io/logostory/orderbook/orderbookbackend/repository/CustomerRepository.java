package io.logostory.orderbook.orderbookbackend.repository;

import io.logostory.orderbook.orderbookbackend.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface CustomerRepository extends JpaRepository<Customer, Long>, QuerydslPredicateExecutor<Customer>  {
}
