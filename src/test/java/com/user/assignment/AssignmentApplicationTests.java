package com.user.assignment;

import com.user.assignment.Configuration.ExchangeConfiguration;
import com.user.assignment.Model.ExchangeCurrency;
import com.user.assignment.Model.TradingCurrencyExecutor;
import com.user.assignment.Services.ExchangeService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class AssignmentApplicationTests {

	@Autowired
	ExchangeService exchangeService;
	@Test
	void contextLoads() {
	}

	@Test
	void rateTest1() throws Exception {

		BigDecimal rateExpected = BigDecimal.valueOf(0.742164);
		BigDecimal rateResult = exchangeService.getExchangeRate("SGN", "USD");
		Assert.assertEquals(rateExpected, rateResult);
	}
	@Test
	void rateTest2() throws Exception {
		BigDecimal rateExpected = BigDecimal.valueOf(1.34782);
		BigDecimal rateResult = exchangeService.getExchangeRate("USD", "SGN");
		Assert.assertEquals(rateExpected, rateResult);
	}

	@Test
	void amountTest1() throws Exception {
		BigDecimal amoutExpected = BigDecimal.valueOf(7421);
		BigDecimal amountResult = exchangeService.getExchangeAmount("SGN", "USD",BigDecimal.valueOf(10000));
		Assert.assertEquals(amoutExpected, amountResult);
	}
	@Test
	void amountTest2() throws Exception {
		BigDecimal amoutExpected = BigDecimal.valueOf(13478);
		BigDecimal amountResult = exchangeService.getExchangeAmount("USD", "SGN",BigDecimal.valueOf(10000));
		Assert.assertEquals(amoutExpected, amountResult);
	}
}
