package org.ddd.domain.service;

import java.util.Currency;

import org.ddd.domain.value.object.ExchangeRate;

/**
 * 汇率转换领域服务
 *
 * @author guang.yi
 * @since 2023/12/27
 */
public interface ExchangeRateService {

    ExchangeRate getExchangeRate(Currency source, Currency target);

}
