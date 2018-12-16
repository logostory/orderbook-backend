package io.logostory.orderbook.backend.domain.dto.menu;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuResponseDto {
    Long menuId;
    Long categoryId;
    String menuName;
    Long price;
    String comment;
    String imagePath;
}
