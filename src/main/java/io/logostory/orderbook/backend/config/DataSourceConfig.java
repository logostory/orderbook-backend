package io.logostory.orderbook.backend.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaAuditing
@EnableJpaRepositories(
        basePackages = {"io.logostory.orderbook.backend.repository"}
)
@EntityScan("io.logostory.orderbook.backend.domain.entity")
public class DataSourceConfig {}
