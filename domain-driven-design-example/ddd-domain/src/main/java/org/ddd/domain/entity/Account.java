package org.ddd.domain.entity;

import lombok.Data;
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

    public void withdraw(Money money) {
        // 转出
    }

    public void deposit(Money money) {
        // 转入
    }

}
