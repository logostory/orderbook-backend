package io.logostory.orderbook.backend.domain.dto.category;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {
    @NotEmpty
    private Long shopId;

    @NotEmpty
    private String name;
}
