package com.github.tddiaz.currencycalculatorservice.dto;

import lombok.Data;

@Data
public class ConversionResponseDto {

        private String from;
        private String to;
        private String exchangeRate;
        private String quantity;
        private String result;

}
