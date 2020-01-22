package com.user.assignment.Api;

import com.user.assignment.Exception.RateNotFoundException;
import com.user.assignment.Services.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class ExchangeAPIController {
    @Autowired
    ExchangeService exchangeService;


    @RequestMapping(value = "/exchange/rate", method = RequestMethod.GET)
    public ResponseEntity<BigDecimal> getExchange(@RequestParam(required = true) String from, @RequestParam(required = true) String to){
        try {
            BigDecimal result = exchangeService.getExchangeRate(from, to);
            return ResponseEntity.ok(result);
        } catch (Exception ex) {
            throw new RateNotFoundException();
        }
    }

    @RequestMapping(value = "/exchange/amount", method = RequestMethod.GET)
    public ResponseEntity<BigDecimal> getExchangeAmount(@RequestParam(required = true) String from, @RequestParam(required = true) String to, @RequestParam(required = true) BigDecimal amount) {
        try {
            BigDecimal result = exchangeService.getExchangeAmount(from, to, amount);
            return ResponseEntity.ok(result);
        } catch (Exception ex) {
            throw new RateNotFoundException();
        }
    }
}