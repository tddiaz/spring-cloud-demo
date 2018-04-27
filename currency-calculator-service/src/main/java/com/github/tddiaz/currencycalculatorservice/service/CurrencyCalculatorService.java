package com.github.tddiaz.currencycalculatorservice.service;

import com.github.tddiaz.currencycalculatorservice.dto.ConversionResponseDto;
import com.github.tddiaz.currencycalculatorservice.dto.CurrencyExchangeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CurrencyCalculatorService {

    @Autowired
    private CurrencyExchangeIntegrationService currencyExchangeIntegrationService;

    public ConversionResponseDto calculate(String from, String to, BigDecimal quantity) {

        CurrencyExchangeDto currencyExchangeDto = currencyExchangeIntegrationService.getExchangeRate(from, to);

        ConversionResponseDto conversionResponseDto = new ConversionResponseDto();
        conversionResponseDto.setFrom(currencyExchangeDto.getFrom());
        conversionResponseDto.setTo(currencyExchangeDto.getTo());
        conversionResponseDto.setExchangeRate(currencyExchangeDto.getValue());
        conversionResponseDto.setQuantity(quantity.toString());
        conversionResponseDto.setResult(quantity.multiply(new BigDecimal(currencyExchangeDto.getValue())).toString());

        return conversionResponseDto;
    }
}
