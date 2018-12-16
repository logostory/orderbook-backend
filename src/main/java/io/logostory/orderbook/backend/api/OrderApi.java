package io.logostory.orderbook.backend.api;

import io.logostory.orderbook.backend.domain.dto.ShopDto;
import io.logostory.orderbook.backend.domain.dto.order.OrderDto.*;
import io.logostory.orderbook.backend.domain.entity.order.Order;
import io.logostory.orderbook.backend.domain.entity.shop.Shop;
import io.logostory.orderbook.backend.repository.OrderRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api
@RestController
@RequestMapping("/v1/api")
public class OrderApi {

    @Autowired
    OrderRepository orderRepository;

    @PostMapping(path = "/shops/{shopId}/orders")
    public ResponseEntity<OrderSearchResultDto> addOrder(@RequestBody OrderAddDto dto) {

        Order order = dto.toOrder();


        return ResponseEntity.ok(new OrderSearchResultDto(order));
    }

    @GetMapping(path = "/shops/{shopId}/orders/{orderId}")
    public ResponseEntity<OrderSearchResultDto> findOrder(@PathVariable Long orderId) {

        Order order = orderRepository.findById(orderId).get();

        return ResponseEntity.ok(new OrderSearchResultDto(order));
    }
}
