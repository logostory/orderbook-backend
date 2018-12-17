package io.logostory.orderbook.backend.domain.dto.order;

import io.logostory.orderbook.backend.domain.entity.order.Item;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class ItemDto {




    @Data
    public static class ItemAddDto extends ItemDto {

        Long menuId;
        List<ItemOptionDto.ItemOptionAddDto> options = new ArrayList<>();
    }

    @Data
    public static class ItemSearchResultDto extends  ItemDto {

        Long itemId;
        String itemName;
        String imagePath;
        Long price;
        String comment;

        public ItemSearchResultDto(Item i) {


        }
    }
}
