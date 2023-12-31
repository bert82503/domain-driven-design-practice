package org.ddd.bank.external.impl;

import java.math.BigDecimal;
import java.util.Currency;

import org.springframework.stereotype.Service;

import org.ddd.bank.external.YahooForexService;
import org.ddd.bank.domain.value.ExchangeRate;
import org.ddd.bank.external.ExchangeRateService;

/**
 * 汇率转换领域服务实现
 *
 * @author guang.yi
 * @since 2023/12/27
 */
@Service("exchangeRateService")
public class ExchangeRateServiceImpl implements ExchangeRateService {

    private final YahooForexService yahooForexService;

    public ExchangeRateServiceImpl(YahooForexService yahooForexService) {
        this.yahooForexService = yahooForexService;
    }

    @Override
    public ExchangeRate getExchangeRate(Currency source, Currency target) {
        if (source.equals(target)) {
            return new ExchangeRate(BigDecimal.ONE, source, target);
        }
        BigDecimal forex = yahooForexService.getExchangeRate(source.getCurrencyCode(), target.getCurrencyCode());
        return new ExchangeRate(forex, source, target);
    }

}
