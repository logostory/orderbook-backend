package io.logostory.orderbook.backend.domain.dto.menu;

import lombok.Builder;
import lombok.Data;

@Builder
public class OptionDto {
    private Long id;
    private String name;
    private Long price;
}
