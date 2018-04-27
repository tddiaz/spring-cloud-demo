package com.github.tddiaz.currencycalculatorservice.dto;

import lombok.Data;

@Data
public class ConversionResponseDto {

        private String from;
        private String to;
        private String exchangeRate;
        private int quantity;
        private String result;

}
