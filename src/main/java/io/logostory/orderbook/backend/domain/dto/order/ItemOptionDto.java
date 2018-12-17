package io.logostory.orderbook.backend.domain.dto.order;

import io.logostory.orderbook.backend.domain.entity.order.ItemOption;
import lombok.*;

@Data
public class ItemOptionDto {

    @Data
    public static class ItemOptionAddDto extends  ItemOptionDto {

        Long optionId;
    }

    @Data
    public static class ItemOptionSearchResultDto extends  ItemOptionDto {

        Long itemOptionId;
        String itemOptionName;

    }
}
