package org.ddd.bank.domain.service.impl;

import org.springframework.stereotype.Service;

import org.ddd.bank.domain.entity.Account;
import org.ddd.bank.domain.service.AccountTransferService;
import org.ddd.bank.external.ExchangeRateService;
import org.ddd.bank.domain.value.ExchangeRate;
import org.ddd.bank.domain.value.Money;

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
