package io.logostory.orderbook.backend.api;

import io.logostory.orderbook.backend.domain.dto.order.OrderDto.OrderAddDto;
import io.logostory.orderbook.backend.domain.dto.order.OrderDto.OrderSearchResultDto;
import io.logostory.orderbook.backend.domain.entity.order.Order;
import io.logostory.orderbook.backend.repository.OrderRepository;
import io.logostory.orderbook.backend.service.OrderService;
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

    @Autowired
    OrderService orderService;

    @PostMapping(path = "/shops/{shopId}/orders")
    public ResponseEntity<OrderSearchResultDto> addOrder(@PathVariable Long shopId, @RequestBody OrderAddDto dto) {

        Order order = orderService.create(shopId, dto);
        return ResponseEntity.ok(new OrderSearchResultDto(order));
    }

    @GetMapping(path = "/shops/{shopId}/orders/{orderId}")
    public ResponseEntity<OrderSearchResultDto> findOrder(@PathVariable Long shopId, @PathVariable Long orderId) {

        Order order = orderRepository.findById(orderId).get();

        return ResponseEntity.ok(new OrderSearchResultDto(order));
    }

    @PutMapping(path = "/shops/{shopId}/orders/{orderId}")
    public ResponseEntity<OrderSearchResultDto> updateOrder(@PathVariable Long shopId, @PathVariable Long orderId, @RequestBody OrderAddDto dto) {

        Order order = orderRepository.findById(orderId).get();

        return ResponseEntity.ok(new OrderSearchResultDto(order));
    }

    @DeleteMapping(path = "/shops/{shopId}/orders/{orderId}")
    public ResponseEntity<?> deleteOrder(@PathVariable Long shopId, @PathVariable Long orderId) {

        return ResponseEntity.ok().build();
    }

    @DeleteMapping(path = "/shops/{shopId}/orders/{orderId}/items/{itemId}")
    public ResponseEntity<?> deleteItemInOrder(@PathVariable Long shopId, @PathVariable Long orderId, @PathVariable Long itemId ) {

        return ResponseEntity.ok().build();
    }


}
