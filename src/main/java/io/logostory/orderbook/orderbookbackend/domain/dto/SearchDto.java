package io.logostory.orderbook.orderbookbackend.domain.dto;

import lombok.Data;

@Data
public class SearchDto {

    String keyword = "";
    int page;
    int size;
}
