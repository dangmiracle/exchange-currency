package com.user.assignment.Model;

import java.math.BigDecimal;

public interface TradingCurrencyBehavior {
    public BigDecimal getExchangeRate(Currency fromCurrency,Currency toCurrency );
    public BigDecimal getExchangeAmount(Currency fromCurrency,Currency toCurrency,BigDecimal amount);
}
