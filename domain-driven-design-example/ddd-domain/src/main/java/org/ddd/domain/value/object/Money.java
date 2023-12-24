package org.ddd.domain.value.object;

import java.math.BigDecimal;
import java.util.Currency;

import lombok.Value;

/**
 * 钱
 * <p>
 * 支付金额 + 支付货币，可以把这两个概念组合成为一个独立的完整概念。
 * <pre>
 * DP 的第二个原则
 * Make Implicit Context Explicit
 * 将 隐性的 上下文 显性化
 * </pre>
 *
 * @author guang.yi
 * @since 2023/12/23
 */
@Value
public class Money {

    /**
     * 支付金额
     */
    BigDecimal amount;
    /**
     * 支付货币
     */
    Currency currency;

}
