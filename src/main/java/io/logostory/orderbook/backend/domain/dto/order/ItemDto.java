package io.logostory.orderbook.backend.domain.dto.order;

import io.logostory.orderbook.backend.domain.entity.order.Item;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {


    @Data
    public static class ItemAddDto extends  ItemDto {

        List<ItemOptionDto.ItemOptionAddDto> itemOptions = new ArrayList<>();

        public Item toItem() {

            Item item = new Item();
            item.setItemOptions(itemOptions.stream().map(io -> io.toItemOption()).collect(Collectors.toList()));

            return item;
        }
    }

    @Data
    public static class ItemSearchResultDto extends  ItemDto {

        public ItemSearchResultDto(Item i) {


        }
    }
}
