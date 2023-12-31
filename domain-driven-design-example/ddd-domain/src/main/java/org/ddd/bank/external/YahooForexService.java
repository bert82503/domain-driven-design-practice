package org.ddd.bank.external;

import java.math.BigDecimal;

/**
 * TODO
 *
 * @author guang.yi
 * @since 2023/12/27
 */
public interface YahooForexService {

    BigDecimal getExchangeRate(String sourceCurrencyCode, String targetCurrencyCode);

}
