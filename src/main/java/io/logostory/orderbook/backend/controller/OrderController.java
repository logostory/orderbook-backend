package io.logostory.orderbook.backend.controller;

import io.logostory.orderbook.backend.domain.dto.order.OrderDetailDto;
import io.logostory.orderbook.backend.domain.entity.order.OrderDetail;
import io.logostory.orderbook.backend.repository.OrderDetailRepositoy;
import io.logostory.orderbook.backend.repository.OrderRepository;
import lombok.*;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

@RestController
@AllArgsConstructor
@RequestMapping(value = "api")
public class OrderController {

 private final OrderRepository orderRepository;
 private final OrderDetailRepositoy orderDetailRepositoy;
 private final ModelMapper modelMapper;

 @PostMapping(value = "/orders")
 private  ResponseEntity saveOrder(@RequestBody OrderDetailDto orderDetailDto) {

     return ResponseEntity.ok(HttpStatus.CREATED);

 }

 @ExceptionHandler
 @GetMapping(path = "/orders/{orderId}")
 public OrderDetailDto findById(@PathVariable Long orderId) {
     OrderDetail orderDetail = orderDetailRepositoy.findById(orderId)
             .orElseThrow(() -> new EntityNotFoundException(String.format("Order[%s] is not found", orderId)));

     return modelMapper.map(orderDetail, OrderDetailDto.class);
 }
}
