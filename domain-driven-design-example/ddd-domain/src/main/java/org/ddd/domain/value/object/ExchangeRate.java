package org.ddd.domain.value.object;

import java.math.BigDecimal;
import java.util.Currency;

import lombok.Value;
import org.apache.commons.lang3.Validate;

/**
 * 汇率对象，转换汇率的功能
 * <pre>
 * DP 的第三个原则：
 * Encapsulate Multi-Object Behavior
 * 封装 多对象 行为
 * </pre>
 *
 * @author guang.yi
 * @since 2023/12/24
 */
@Value
public class ExchangeRate {

    /**
     * 汇率
     */
    BigDecimal rate;
    Currency from;
    Currency to;

    public Money exchange(Money fromMoney) {
        Validate.notNull(fromMoney);
        Validate.isTrue(from.equals(fromMoney.getCurrency()));
        BigDecimal targetAmount = fromMoney.getAmount().multiply(rate);
        return new Money(targetAmount, to);
    }

}
