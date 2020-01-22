package com.user.assignment.Model;

import java.math.BigDecimal;

public class ExchangeCurrency extends Currency {

    public ExchangeCurrency(String name) {
        this.setName(name);
    }

    public BigDecimal getExchangeRate(Currency toCurrency) {
        return getTradingBehavior().getExchangeRate(this, toCurrency);
    }

    public BigDecimal getExchangeAmount(Currency toCurrency, BigDecimal amount) {

        return getTradingBehavior().getExchangeAmount(this, toCurrency, amount);
    }

}
