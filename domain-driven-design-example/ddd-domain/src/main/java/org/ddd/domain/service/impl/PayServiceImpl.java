package org.ddd.domain.service.impl;

import java.util.Currency;

import org.springframework.stereotype.Service;

import org.ddd.domain.service.BankService;
import org.ddd.domain.service.ExchangeService;
import org.ddd.domain.service.PayService;
import org.ddd.domain.value.object.ExchangeRate;
import org.ddd.domain.value.object.Money;

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
