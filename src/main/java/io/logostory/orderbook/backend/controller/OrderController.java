package io.logostory.orderbook.backend.controller;

import io.logostory.orderbook.backend.domain.dto.order.OrderDto;
import io.logostory.orderbook.backend.repository.OrderRepository;
import io.logostory.orderbook.backend.service.OrderService;
import lombok.*;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(value = "api")
public class OrderController {

 OrderService orderService;
 private final OrderRepository orderRepository;
 private final ModelMapper modelMapper;

 @PostMapping(value = "/orders")
 private  ResponseEntity saveOrder(@RequestBody OrderDto orderDto) {

  orderService.saveOrder(orderDto);
  return ResponseEntity.ok(HttpStatus.CREATED);
 }

}
