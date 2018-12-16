package io.logostory.orderbook.backend.domain.dto.order;

import io.logostory.orderbook.backend.domain.entity.menu.Option;
import io.logostory.orderbook.backend.domain.entity.order.Item;
import io.logostory.orderbook.backend.domain.entity.order.ItemOption;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemOptionDto {

    Long itemOptionId;

    @Data
    public static  class AddItmeOption extends  ItemOptionDto{

        public ItemOption toItemOption(Option option) {
            ItemOption itemOption = new ItemOption();
            itemOption.setOption(option);
            return itemOption;
        }

    }
