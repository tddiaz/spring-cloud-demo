package com.github.tddiaz.currencyexchangeservice;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
public class CurrencyExchange {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "currency_from")
    private String from;

    @Column(name = "currency_to")
    private String to;

    private BigDecimal value;

    public CurrencyExchange() {

    }

    public CurrencyExchange(String from, String to, BigDecimal value) {
        this.from = from;
        this.to = to;
        this.value = value;
    }
}
