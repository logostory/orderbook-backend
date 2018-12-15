package io.logostory.orderbook.backend.domain.dto.order;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    private Long storeId;
    @NotEmpty
    private Long seatId;
    private Long userId;
}
