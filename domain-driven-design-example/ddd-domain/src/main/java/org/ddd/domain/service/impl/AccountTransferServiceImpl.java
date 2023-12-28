package org.ddd.domain.service.impl;

import org.springframework.stereotype.Service;

import org.ddd.domain.entity.Account;
import org.ddd.domain.service.AccountTransferService;
import org.ddd.domain.service.ExchangeRateService;
import org.ddd.domain.value.object.ExchangeRate;
import org.ddd.domain.value.object.Money;

/**
 * 账户转账领域服务实现
 *
 * @author guang.yi
 * @since 2023/12/28
 */
@Service("accountTransferService")
public class AccountTransferServiceImpl implements AccountTransferService {

    private final ExchangeRateService exchangeRateService;

    public AccountTransferServiceImpl(ExchangeRateService exchangeRateService) {
        this.exchangeRateService = exchangeRateService;
    }

    @Override
    public void transfer(
            Account sourceAccount, Account targetAccount,
            Money targetMoney, ExchangeRate exchangeRate) {
        Money sourceMoney = exchangeRate.exchangeTo(targetMoney);
        sourceAccount.deposit(sourceMoney);
        targetAccount.withdraw(targetMoney);
    }

}
