package io.logostory.orderbook.backend.service;

import io.logostory.orderbook.backend.domain.dto.order.OrderDetailDto;
import io.logostory.orderbook.backend.domain.dto.order.OrderDto;
import io.logostory.orderbook.backend.domain.entity.menu.Menu;
import io.logostory.orderbook.backend.domain.entity.menu.Option;
import io.logostory.orderbook.backend.domain.entity.order.Item;
import io.logostory.orderbook.backend.domain.entity.order.ItemOption;
import io.logostory.orderbook.backend.repository.*;
import lombok.AllArgsConstructor;
import org.aspectj.lang.reflect.InterTypeMethodDeclaration;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {

    OrderRepository orderRepository;
    MenuRepository menuRepository;
    OptionRepository optionRepository;
    ItemRepository itemRepository;
    ItemOptionRepository itemOptionRepository;


    public void saveOrder(OrderDetailDto orderDetailDto) {
        List<OrderDetailDto.Menus> menus = orderDetailDto.getMenus();
        OrderDto  orderDto = new OrderDto();

        for (OrderDetailDto.Menus menu : menus) {
            Menu meneInfo =  menuRepository.findById(menu.getMenuId()).get();
            for (OrderDetailDto.Options option : menu.getOptions()) {
                Option optionInfo =  optionRepository.findById(option.getOptionId()).get();
                //ItemOption itemOption = new ItemOption().setOption(optionInfo);
            }
        }
    }
}
