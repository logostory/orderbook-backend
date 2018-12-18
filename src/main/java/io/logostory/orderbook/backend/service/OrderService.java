package io.logostory.orderbook.backend.service;

import io.logostory.orderbook.backend.domain.dto.order.ItemDto;
import io.logostory.orderbook.backend.domain.dto.order.ItemOptionDto;
import io.logostory.orderbook.backend.domain.dto.order.OrderDto;
import io.logostory.orderbook.backend.domain.entity.menu.Option;
import io.logostory.orderbook.backend.domain.entity.order.Item;
import io.logostory.orderbook.backend.domain.entity.order.ItemOption;
import io.logostory.orderbook.backend.domain.entity.order.Order;
import io.logostory.orderbook.backend.repository.MenuRepository;
import io.logostory.orderbook.backend.repository.OptionRepository;
import io.logostory.orderbook.backend.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final MenuRepository menuRepository;
    private final OptionRepository optionRepository;

    public Order create(OrderDto.OrderAddDto orderAddDto) {
        Order order = new Order();
        Long totalPrice = 0L;

        List<ItemDto.ItemAddDto> itemAddList = orderAddDto.getMenus();
        for (ItemDto.ItemAddDto itemAdd : itemAddList) {
            Item item = new Item();
            item.setItem(menuRepository.findById(itemAdd.getMenuId()).get());
            totalPrice += item.getPrice();

            for (ItemOptionDto.ItemOptionAddDto itemOptionAdd :  itemAdd.getOptions()) {
                ItemOption itemOption = new ItemOption();
                itemOption.setItemOption(optionRepository.findById(itemOptionAdd.getOptionId()).get());
                itemOption.setItem(item);
                item.addItemOption(itemOption);

                totalPrice += itemOption.getItemOptionPrice();
            }
            item.setOrder(order);
            order.addItem(item);

        }
        order.setSeatNumber(orderAddDto.getSeatNumber());
        order.setTotalPrice((int) (long) totalPrice);

        orderRepository.save(order);

        return order;
    }

}
