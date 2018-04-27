package com.github.tddiaz.currencycalculatorservice.controller;

import com.github.tddiaz.currencycalculatorservice.dto.ConversionResponseDto;
import com.github.tddiaz.currencycalculatorservice.service.CurrencyCalculatorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@Slf4j
public class Controller {

    @Autowired
    private CurrencyCalculatorService currencyCalculatorService;

    @GetMapping("/calculate")
    public ConversionResponseDto calculate(@RequestParam String from, @RequestParam String to, @RequestParam BigDecimal quantity) {
        log.info("Currency Calculator Request. From {}, To {}, Quantity {}", from, to, quantity);
        return currencyCalculatorService.calculate(from, to, quantity);
    }

}

