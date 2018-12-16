package io.logostory.orderbook.backend.service;

import io.logostory.orderbook.backend.domain.dto.menu.MenuDto;
import io.logostory.orderbook.backend.domain.dto.order.ItemDto;
import io.logostory.orderbook.backend.domain.dto.order.ItemOptionDto;
import io.logostory.orderbook.backend.domain.dto.order.OrderDto;
import io.logostory.orderbook.backend.domain.entity.menu.Menu;
import io.logostory.orderbook.backend.domain.entity.order.Item;
import io.logostory.orderbook.backend.domain.entity.order.ItemOption;
import io.logostory.orderbook.backend.domain.entity.order.Order;
import io.logostory.orderbook.backend.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final MenuRepository menuRepository;
    private final OptionRepository optionRepository;
    private final ItemRepository itemRepository;
    private final ItemOptionRepository itemOptionRepository;


    public void saveOrder(OrderDto orderDto) {

        Order order = new Order();
        List<Item> itemList = new ArrayList<Item>();
        List<ItemOption> itemOPtionList = new ArrayList<ItemOption>();

        for(ItemDto items : orderDto.getItems()) {
            Item item = new Item();
            item.setMenu(menuRepository.findById(items.getMenuId()).get());

            for(ItemOptionDto itemOptions : items.getItemoptions()) {
                ItemOption itemOption = new ItemOption();
                itemOption.setOption(optionRepository.findById(itemOptions.getOptionId()).get());
                itemOption.setItem(item);
                itemOPtionList.add(itemOption);

            }
            item.setItemOptions(itemOPtionList);
            item.setOrder(order);
            itemList.add(item);

        }
        order.setItems(itemList);
        orderRepository.save(order);
    }

}