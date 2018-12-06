package io.logostory.orderbook.backend.common.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
@ConfigurationProperties("orderbook-app")
@Getter
@Setter
public class OrderbookAppProperties {

    private String clientId;

    private String clientSecret;

    private String resourceId;
}
