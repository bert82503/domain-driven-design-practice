package org.ddd.bank.domain.service.impl;

import java.util.Currency;

import org.springframework.stereotype.Service;

import org.ddd.bank.domain.service.BankService;
import org.ddd.bank.domain.service.ExchangeService;
import org.ddd.bank.domain.service.PayService;
import org.ddd.bank.domain.value.ExchangeRate;
import org.ddd.bank.domain.value.Money;

/**
 * 支付领域服务实现
 *
 * @author guang.yi
 * @since 2023/12/24
 */
@Service("payService")
public class PayServiceImpl implements PayService {

    private final BankService bankService;
    private final ExchangeService exchangeService;

    public PayServiceImpl(
            BankService bankService,
            ExchangeService exchangeService
    ) {
        this.bankService = bankService;
        this.exchangeService = exchangeService;
    }

    @Override
    public void pay(Money money, Long recipientId) {
        bankService.transfer(money, recipientId);
    }

    @Override
    public void pay(Money money, Currency targetCurrency, Long recipientId) {
        ExchangeRate rate = exchangeService.getRate(money.getCurrency(), targetCurrency);
        Money targetMoney = rate.exchange(money);
        bankService.transfer(targetMoney, recipientId);
    }

}
