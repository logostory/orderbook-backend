package io.logostory.orderbook.backend.domain.dto.menu;

import io.logostory.orderbook.backend.domain.entity.menu.Option;
import lombok.*;

@Data
public class OptionDto {

    String name;
    Long price;

    @Data
    public static class OptionAddDto extends OptionDto{

        public Option toOption() {
            Option option = new Option();
            option.setOptionName(name);
            option.setPrice(price);
            return option;
        }
    }
}
