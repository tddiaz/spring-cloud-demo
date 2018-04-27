package com.github.tddiaz.currencycalculatorservice.service;

import com.github.tddiaz.currencycalculatorservice.dto.ConversionResponseDto;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CurrencyCalculatorService {

    public ConversionResponseDto calculate(String from, String to, BigDecimal quantity) {
        return new ConversionResponseDto();
    }
}
