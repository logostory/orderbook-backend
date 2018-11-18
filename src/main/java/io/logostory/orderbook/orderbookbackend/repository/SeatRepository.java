package io.logostory.orderbook.orderbookbackend.repository;

import io.logostory.orderbook.orderbookbackend.domain.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long>, QuerydslPredicateExecutor<Seat> {

}
