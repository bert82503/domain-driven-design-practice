package org.ddd.bank.application.service.impl;

import java.math.BigDecimal;
import java.util.Currency;

import org.springframework.stereotype.Service;

import org.ddd.bank.application.service.TransferService;
import org.ddd.bank.domain.value.AccountNumber;
import org.ddd.bank.domain.value.ExchangeRate;
import org.ddd.bank.domain.value.Money;
import org.ddd.bank.domain.value.UserId;
import org.ddd.bank.domain.entity.Account;
import org.ddd.bank.message.AuditMessageProducer;
import org.ddd.bank.domain.model.Result;
import org.ddd.bank.repository.AccountRepository;
import org.ddd.bank.domain.service.AccountTransferService;
import org.ddd.bank.external.ExchangeRateService;
import org.ddd.bank.domain.value.AuditMessage;

/**
 * 转账应用服务实现
 *
 * @author guang.yi
 * @since 2023/12/26
 */
@Service("transferService")
public class TransferServiceImpl implements TransferService {

    private final AccountRepository accountRepository;
    private final ExchangeRateService exchangeRateService;
    private final AccountTransferService accountTransferService;
    private final AuditMessageProducer auditMessageProducer;

    public TransferServiceImpl(
            AccountRepository accountRepository,
            ExchangeRateService exchangeRateService,
            AccountTransferService accountTransferService,
            AuditMessageProducer auditMessageProducer
    ) {
        this.accountRepository = accountRepository;
        this.exchangeRateService = exchangeRateService;
        this.accountTransferService = accountTransferService;
        this.auditMessageProducer = auditMessageProducer;
    }

    @Override
    public Result<Boolean> transfer(
            Long sourceUserId, String targetAccountNumber,
            BigDecimal targetAmount, String targetCurrency) {
        // 参数校验
        Money targetMoney = new Money(targetAmount, Currency.getInstance(targetCurrency));

        // 读数据
        Account sourceAccount = accountRepository.find(new UserId(sourceUserId));
        Account targetAccount = accountRepository.find(new AccountNumber(targetAccountNumber));
        ExchangeRate exchangeRate = exchangeRateService.getExchangeRate(sourceAccount.getCurrency(), targetMoney.getCurrency());

        // 业务逻辑
        accountTransferService.transfer(sourceAccount, targetAccount, targetMoney, exchangeRate);

        // 保存数据
        accountRepository.save(sourceAccount);
        accountRepository.save(targetAccount);

        // 发送审计消息
        AuditMessage message = new AuditMessage(sourceAccount, targetAccount, targetMoney);
        auditMessageProducer.send(message);

        return Result.success(true);
    }

}
