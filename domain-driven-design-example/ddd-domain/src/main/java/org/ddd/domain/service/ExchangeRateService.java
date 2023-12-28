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

    /**
     * 获取汇率
     *
     * @param source 来源货币
     * @param target 目标货币
     * @return 汇率
     */
    ExchangeRate getExchangeRate(Currency source, Currency target);

}
