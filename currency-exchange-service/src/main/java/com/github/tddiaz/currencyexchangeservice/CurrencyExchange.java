package com.github.tddiaz.currencyexchangeservice;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
public class CurrencyExchange {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "currency_from")
    @NonNull
    private String from;

    @Column(name = "currency_to")
    @NonNull
    private String to;

    @NonNull
    private BigDecimal value;

}
