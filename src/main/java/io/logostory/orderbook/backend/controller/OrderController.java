package io.logostory.orderbook.backend.controller;

import io.logostory.orderbook.backend.domain.dto.order.OrderDto;
import io.logostory.orderbook.backend.domain.entity.order.Order;
import io.logostory.orderbook.backend.repository.OrderDetailRepositoy;
import io.logostory.orderbook.backend.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
@RequestMapping(value = "api")
public class OrderController {

 private OrderRepository orderRepository;
 private OrderDetailRepositoy orderDetailRepositoy;
 private ModelMapper modelMapper;



    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity saveOrder(@RequestBody OrderDto orderDto) {


        return ResponseEntity.ok(HttpStatus.CREATED);
    }
}
