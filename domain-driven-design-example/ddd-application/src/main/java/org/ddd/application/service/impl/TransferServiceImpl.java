package org.ddd.application.service.impl;

import java.math.BigDecimal;
import java.util.Currency;

import org.springframework.stereotype.Service;

import org.ddd.application.service.TransferService;
import org.ddd.domain.entity.Account;
import org.ddd.domain.message.AuditMessageProducer;
import org.ddd.domain.model.Result;
import org.ddd.domain.repository.AccountRepository;
import org.ddd.domain.service.AccountTransferService;
import org.ddd.domain.service.ExchangeRateService;
import org.ddd.domain.value.object.AccountNumber;
import org.ddd.domain.value.object.AuditMessage;
import org.ddd.domain.value.object.ExchangeRate;
import org.ddd.domain.value.object.Money;
import org.ddd.domain.value.object.UserId;

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
