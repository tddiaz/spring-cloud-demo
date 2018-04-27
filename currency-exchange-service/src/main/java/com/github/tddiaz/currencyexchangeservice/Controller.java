package com.github.tddiaz.currencyexchangeservice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private CurrencyExchangeRepository currencyExchangeRepository;

    @GetMapping("/currency-exchange")
    public ExchangeResposne getExchange(@RequestParam("from") String from, @RequestParam("to") String to) {
        CurrencyExchange currencyExchange = currencyExchangeRepository.findByFromAndTo(from, to);
        return new ExchangeResposne(currencyExchange.getFrom(), currencyExchange.getTo(), currencyExchange.getValue().toString());
    }
}


@Getter
@Setter
@AllArgsConstructor
class ExchangeResposne {

    private String from;
    private String to;
    private String value;

}
