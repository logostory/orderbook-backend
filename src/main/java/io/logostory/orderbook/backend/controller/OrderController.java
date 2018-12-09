package io.logostory.orderbook.backend.controller;

import io.logostory.orderbook.backend.domain.dto.order.OrderDetailDto;
import io.logostory.orderbook.backend.domain.entity.order.Order;
import io.logostory.orderbook.backend.repository.OrderDetailRepositoy;
import io.logostory.orderbook.backend.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
@RequestMapping(value = "api")
public class OrderController {

 private OrderRepository orderRepository;
 private OrderDetailRepositoy orderDetailRepositoy;
 private ModelMapper modelMapper;

 @PostMapping(value = "/orders")
 private Order saveOrder (@RequestBody Order order) {

     order.setOrderDetails(this.orderDetailRepositoy.saveAll(order.getOrderDetails()));
     return orderRepository.save(order);

 }

}
