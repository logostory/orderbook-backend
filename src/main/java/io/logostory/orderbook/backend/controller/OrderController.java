package io.logostory.orderbook.backend.controller;

import io.logostory.orderbook.backend.domain.dto.order.OrderDetailDto;
import io.logostory.orderbook.backend.domain.dto.order.OrderDto;
import io.logostory.orderbook.backend.repository.OrderDetailRepositoy;
import io.logostory.orderbook.backend.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
@RequestMapping(value = "api")
public class OrderController {

 private OrderRepository orderRepository;
 private OrderDetailRepositoy orderDetailRepositoy;
 private ModelMapper modelMapper;

 @PostMapping(value = "/orders")
 private  ResponseEntity saveOrder(@RequestBody OrderDetailDto orderDetailDto) {

     return ResponseEntity.ok(HttpStatus.CREATED);

 }
}
