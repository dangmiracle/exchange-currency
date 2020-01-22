package com.user.assignment.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.math.BigDecimal;

@Configuration
@ComponentScan(basePackages = { "resources*" })
@PropertySource("classpath:exchange.properties")
public class ExchangeConfiguration {

    @Autowired
    private Environment env;

    public BigDecimal getExchangeRate(String from, String to) {
        String rateStr = env.getProperty("rate." + from.toLowerCase() + "." + to.toLowerCase());
        BigDecimal rate = BigDecimal.valueOf(Double.valueOf(rateStr));
        return rate;
    }

}