package com.github.tddiaz.currencycalculatorservice.service;


import com.github.tddiaz.currencycalculatorservice.dto.CurrencyExchangeDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "${currency-exchange-service.name}", url = "${currency-exchange-service.endpoint}")
public interface CurrencyExchangeIntegrationService {

    @GetMapping
    CurrencyExchangeDto getExchangeRate(@RequestParam("from") String from, @RequestParam("to") String to);
}
