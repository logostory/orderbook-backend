package io.logostory.orderbook.backend.domain.dto.order;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {

    Long menuId;
    List<ItemOptionDto> itemoptions;

}
