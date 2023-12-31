package org.ddd.bank.domain.value;

import java.time.LocalDateTime;

import lombok.Value;
import org.ddd.bank.domain.entity.Account;

/**
 * 审计消息【值对象】
 *
 * @author guang.yi
 * @since 2023/12/28
 */
@Value
public class AuditMessage {

    UserId userId;

    AccountNumber source;
    AccountNumber target;

    Money money;

    LocalDateTime dateTime;

    public AuditMessage(Account sourceAccount, Account targetAccount, Money money) {
        this.userId = sourceAccount.getUserId();
        this.source = sourceAccount.getAccountNumber();
        this.target = targetAccount.getAccountNumber();
        this.money = money;
        this.dateTime = LocalDateTime.now();
    }

    public String serialize() {
        return userId + "," + source + "," + target + "," + money + "," + dateTime;
    }

    public static AuditMessage deserialize(String value) {
        // ToDo
        return null;
    }

}
