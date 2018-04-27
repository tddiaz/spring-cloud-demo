package com.github.tddiaz.currencycalculatorservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(value = "com.github.tddiaz.currencycalculatorservice")
public class CurrencyCalculatorServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyCalculatorServiceApplication.class, args);
	}
}
