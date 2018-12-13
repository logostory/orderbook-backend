package io.logostory.orderbook.backend.domain.dto.account;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {

    @ApiModelProperty(required = true)
    @NotEmpty
    private String username;
    @ApiModelProperty(required = true)
    @NotEmpty
    private String password;
}
