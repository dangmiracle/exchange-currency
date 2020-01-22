package com.user.assignment.Model;

import com.user.assignment.Configuration.ExchangeConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
public class TradingCurrencyExecutor implements TradingCurrencyBehavior {

    @Autowired
    ExchangeConfiguration config;

    @Override
    public BigDecimal getExchangeRate(Currency fromCurrency, Currency toCurrency) {
        BigDecimal rate = config.getExchangeRate(fromCurrency.getName(), toCurrency.getName());
        return rate;

    }

    @Override
    public BigDecimal getExchangeAmount(Currency fromCurrency, Currency toCurrency, BigDecimal amount) {
        fromCurrency.setTradingBehavior(new TradingCurrencyExecutor());
        BigDecimal rateResult = getExchangeRate(fromCurrency, toCurrency);
        BigDecimal result = amount.multiply(rateResult).setScale(0, RoundingMode.DOWN);
        return result;
    }
}
