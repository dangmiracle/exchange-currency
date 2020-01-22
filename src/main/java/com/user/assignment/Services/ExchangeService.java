package com.user.assignment.Services;

import com.user.assignment.Model.ExchangeCurrency;
import com.user.assignment.Model.TradingCurrencyExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ExchangeService {

    @Autowired
    TradingCurrencyExecutor tradingCurrencyExecutor;

    public BigDecimal getExchangeRate(String fromCurrency, String toCurrency) throws Exception {
        ExchangeCurrency from = new ExchangeCurrency(fromCurrency);
        ExchangeCurrency to = new ExchangeCurrency(toCurrency);
        from.setTradingBehavior(tradingCurrencyExecutor);
        BigDecimal rateResult = from.getExchangeRate(to);

        if (rateResult == null) {
            throw new Exception();
        }
        return rateResult;
    }

    public BigDecimal getExchangeAmount(String fromCurrency, String toCurrency, BigDecimal amount) throws Exception {
        ExchangeCurrency from = new ExchangeCurrency(fromCurrency);
        ExchangeCurrency to = new ExchangeCurrency(toCurrency);
        from.setTradingBehavior(tradingCurrencyExecutor);
        BigDecimal amountResult = from.getExchangeAmount(to,amount);

        if (amountResult == null) {
            throw new Exception();
        }
        return amountResult;
    }
}
