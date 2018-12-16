package io.logostory.orderbook.backend.api;

import io.logostory.orderbook.backend.domain.dto.order.OrderDto;
import io.logostory.orderbook.backend.domain.entity.order.Order;
import io.logostory.orderbook.backend.repository.OrderRepository;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

@Api
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api")
public class OrderApi {

    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;

    @ExceptionHandler
    @GetMapping(path = "/orders/{orderId}")
    public OrderDto findById(@PathVariable Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Order[%s] is not found", orderId)));

        return modelMapper.map(order, OrderDto.class);
    }
}
