package org.ddd.bank.domain.entity;

import java.util.Currency;

import lombok.Data;
import org.ddd.bank.domain.value.AccountId;
import org.ddd.bank.domain.value.AccountNumber;
import org.ddd.bank.domain.value.Money;
import org.ddd.bank.domain.value.UserId;
import org.ddd.bank.exception.DailyLimitExceededException;
import org.ddd.bank.exception.InsufficientFundsException;

/**
 * 账户实体对象
 *
 * @author guang.yi
 * @since 2023/12/27
 */
@Data
public class Account {

    /**
     * 账户身份
     */
    private AccountId id;
    /**
     * 账号
     */
    private AccountNumber accountNumber;
    /**
     * 用户身份
     */
    private UserId userId;
    private Money available;
    /**
     * 每日限额
     */
    private Money dailyLimit;

    public Currency getCurrency() {
        return this.available.getCurrency();
    }

    public void withdraw(Money money) {
        // 转出
        if (this.available.compareTo(money) < 0) {
            throw new InsufficientFundsException();
        }
        if (this.dailyLimit.compareTo(money) < 0) {
            throw new DailyLimitExceededException();
        }
        this.available = this.available.subtract(money);
    }

    public void deposit(Money money) {
        // 转入
//        if (!this.getCurrency().equals(money.getCurrency())) {
//            throw new InvalidCurrencyException("");
//        }
        this.available = this.available.add(money);
    }

}
