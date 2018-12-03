package io.logostory.orderbook.backend.security;

import io.logostory.orderbook.backend.common.ControllerTests;
import io.logostory.orderbook.backend.common.properties.OrderbookAppProperties;
import io.logostory.orderbook.backend.domain.entity.account.Account;
import io.logostory.orderbook.backend.domain.entity.account.AccountRoles;
import io.logostory.orderbook.backend.service.AccountService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import java.util.Set;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class OAuthTokenTest extends ControllerTests {

    @Autowired
    AccountService accountService;

    @Autowired
    OrderbookAppProperties orderbookAppProperties;

    @Test
    public void getAccessToken() throws Exception {
        String username = "test@email.com";
        String password = "password";

        /*Account account = Account.builder()
                .username(username)
                .password(password)
                .roles(Set.of(AccountRoles.ADMIN))
                .build();

        this.accountService.createAccount(account);*/

        this.mockMvc.perform(post("/oauth/token")
                .with(httpBasic(orderbookAppProperties.getClientId(), orderbookAppProperties.getClientSecret()))
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .param("grant_type", "password")
                .param("username", username)
                .param("password", password))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("access_token").hasJsonPath())
        ;


    }
}
