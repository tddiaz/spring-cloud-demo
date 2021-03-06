package com.github.tddiaz.currencyexchangeservice;

import brave.sampler.Sampler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;


@SpringBootApplication
@RefreshScope
@EnableDiscoveryClient
public class CurrencyExchangeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyExchangeServiceApplication.class, args);
	}

	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
}


@Slf4j
@Component
class DataBootstrap implements ApplicationContextAware {

	@Autowired
	private CurrencyExchangeRepository currencyExchangeRepository;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		log.info("bootstraping database..");
		currencyExchangeRepository.save(new CurrencyExchange("USD", "PHP", new BigDecimal(50)));
		currencyExchangeRepository.save(new CurrencyExchange("PHP", "USD", new BigDecimal(0.02)));


	}
}
