package com.github.tddiaz.currencycalculatorservice.dto;

import lombok.Data;

@Data
public class CurrencyExchangeDto {
    private String from;
    private String to;
    private String value;
}
