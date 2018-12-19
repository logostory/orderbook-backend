package io.logostory.orderbook.backend.domain.dto.order;

import lombok.Data;

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