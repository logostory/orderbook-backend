package io.logostory.orderbook.backend.domain.dto.order;

import io.logostory.orderbook.backend.domain.entity.order.ItemOption;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemOptionDto {

    @Data
    public static class ItemOptionAddDto extends  ItemOptionDto {


        public ItemOption toItemOption() {

            ItemOption itemOption = new ItemOption();

            return itemOption;
        }
    }

    @Data
    public static class ItemOptionSearchResultDto extends  ItemOptionDto {

    }
}
