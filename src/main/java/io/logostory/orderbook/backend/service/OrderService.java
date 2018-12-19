package io.logostory.orderbook.backend.service;

import io.logostory.orderbook.backend.domain.dto.order.ItemDto.*;
import io.logostory.orderbook.backend.domain.dto.order.OrderDto;
import io.logostory.orderbook.backend.domain.entity.menu.Menu;
import io.logostory.orderbook.backend.domain.entity.menu.Option;
import io.logostory.orderbook.backend.domain.entity.order.Item;
import io.logostory.orderbook.backend.domain.entity.order.ItemOption;
import io.logostory.orderbook.backend.domain.entity.order.Order;
import io.logostory.orderbook.backend.repository.ItemRepository;
import io.logostory.orderbook.backend.repository.MenuRepository;
import io.logostory.orderbook.backend.repository.OptionRepository;
import io.logostory.orderbook.backend.repository.OrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired OrderRepository  orderRepository;
    @Autowired MenuRepository   menuRepository;
    @Autowired OptionRepository optionRepository;
    @Autowired ItemRepository itemRepository;
    @Autowired ModelMapper modelMapper;

    @Transactional
    public Order addOrder(OrderDto.OrderAddDto dto) {

        Order order = new Order();
        order.setSeatNumber(dto.getSeatNumber());

        List<Item> items = new ArrayList<>();

        for(int menuNum = 0; menuNum < dto.getMenus().size(); menuNum++) {
            ItemAddDto iadto = dto.getMenus().get(menuNum);

            Long menuId = iadto.getMenuId();
            Menu menu = menuRepository.findById(menuId).get();

            Item item = new Item();

            modelMapper.map(menu, item);
            item.setMenu(menu);
            item.setOrder(order);

            List<ItemOption> itemOptions = new ArrayList<>();
            for(int optionNum = 0; optionNum < iadto.getOptions().size(); optionNum++) {

                Long optionId = iadto.getOptions().get(optionNum).getOptionId();
                Option option = optionRepository.findById(optionId).get();

                ItemOption itemOption = new ItemOption();
                modelMapper.map(option, itemOption);
                itemOption.setItem(item);
                itemOption.setOption(option);
                itemOptions.add(itemOption);
            }
            item.setItemOptions(itemOptions);
            items.add(item);
        }

        items = itemRepository.saveAll(items);

        order.setItems(items);

        order = orderRepository.save(order);

        return order;
    }
}
