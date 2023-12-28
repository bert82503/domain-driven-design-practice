package org.ddd.domain.entity;

import java.util.Currency;

import lombok.Data;
import org.ddd.domain.exception.DailyLimitExceededException;
import org.ddd.domain.exception.InsufficientFundsException;
import org.ddd.domain.value.object.AccountId;
import org.ddd.domain.value.object.AccountNumber;
import org.ddd.domain.value.object.Money;
import org.ddd.domain.value.object.UserId;

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
