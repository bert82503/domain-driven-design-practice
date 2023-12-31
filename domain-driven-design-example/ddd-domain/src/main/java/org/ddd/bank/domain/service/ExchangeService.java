package org.ddd.bank.domain.service;

import java.util.Currency;

import org.ddd.bank.domain.value.ExchangeRate;

/**
 * 外币兑换领域服务
 *
 * @author guang.yi
 * @since 2023/12/24
 */
public interface ExchangeService {

    /**
     * 获取货币汇率
     *
     * @param sourceCurrency 来源货币
     * @param targetCurrency 目标货币
     * @return 汇率
     */
    ExchangeRate getRate(Currency sourceCurrency, Currency targetCurrency);

}
