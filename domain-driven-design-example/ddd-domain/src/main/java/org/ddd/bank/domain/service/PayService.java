package org.ddd.bank.domain.service;

import java.util.Currency;

import org.ddd.bank.domain.value.Money;

/**
 * 支付领域服务
 *
 * @author guang.yi
 * @since 2023/12/24
 */
public interface PayService {

    /**
     * 境内转账
     * <p>
     * A用户支付 x 元给用户 B
     *
     * @param money       钱
     * @param recipientId 接受者身份
     */
    void pay(Money money, Long recipientId);

    /**
     * 跨境转账
     * <p>
     * A用户支付 x 元给用户 B
     *
     * @param money          钱
     * @param targetCurrency 目标货币
     * @param recipientId    接受者身份
     */
    void pay(Money money, Currency targetCurrency, Long recipientId);

}
