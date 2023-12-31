package org.ddd.bank.domain.service;

import org.ddd.bank.domain.entity.Account;
import org.ddd.bank.domain.value.ExchangeRate;
import org.ddd.bank.domain.value.Money;

/**
 * 账户转账领域服务
 * <p>
 * 在任何一个Entity或者Domain Primitive里也不合适，需要有一个新的类去包含跨域对象的行为。
 * 这种对象叫做Domain Service。
 *
 * @author guang.yi
 * @since 2023/12/28
 */
public interface AccountTransferService {

    /**
     * 两个账号的转出和转入
     *
     * @param sourceAccount 来源账户
     * @param targetAccount 目标账户
     * @param targetMoney   目标的钱
     * @param exchangeRate  汇率
     */
    void transfer(
            Account sourceAccount, Account targetAccount,
            Money targetMoney, ExchangeRate exchangeRate);

}
