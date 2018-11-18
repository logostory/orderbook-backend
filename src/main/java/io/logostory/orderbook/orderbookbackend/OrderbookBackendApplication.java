package io.logostory.orderbook.orderbookbackend;

import lombok.extern.java.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Log
public class OrderbookBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderbookBackendApplication.class, args);
	}
}
