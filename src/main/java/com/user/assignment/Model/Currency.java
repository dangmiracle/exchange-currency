package com.user.assignment.Model;

public abstract class Currency {
    private long id;
    private String name;
    private TradingCurrencyBehavior tradingBehavior;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TradingCurrencyBehavior getTradingBehavior() {
        return tradingBehavior;
    }

    public void setTradingBehavior(TradingCurrencyBehavior tradingBehavior) {
        this.tradingBehavior = tradingBehavior;
    }

}
