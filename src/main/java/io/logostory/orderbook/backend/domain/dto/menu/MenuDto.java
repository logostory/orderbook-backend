package io.logostory.orderbook.backend.domain.dto.menu;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MenuDto {
    @NotEmpty
    private Long categoryId;
    @NotEmpty
    private String name;
    @NotEmpty
    private Long price;
    private String comment;
    private String imagePath;
    private List<OptionDto> options;
}
