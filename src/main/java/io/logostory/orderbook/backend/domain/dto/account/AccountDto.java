package io.logostory.orderbook.backend.domain.dto.account;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {

    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
}
