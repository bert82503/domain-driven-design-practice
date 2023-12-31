package org.ddd.bank.persistence.function;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import org.ddd.bank.domain.entity.Account;
import org.ddd.bank.persistence.dao.data.AccountDO;

/**
 * 账户构建者
 *
 * @author guang.yi
 * @since 2023/12/27
 */
@Component("accountBuilder")
public class AccountBuilder {

    public Account toAccount(AccountDO accountDo) {
        // ToDo
        return null;
    }

    public AccountDO fromAccount(Account account) {
        // ToDo
        AccountDO accountDO = new AccountDO();
        // 创建时间
        LocalDateTime now = LocalDateTime.now();
        if (accountDO.getId() == null && accountDO.getCreateTime() == null) {
            accountDO.setCreateTime(now);
        }
        // 更新时间
        if (accountDO.getUpdateTime() == null) {
            accountDO.setUpdateTime(now);
        }
        return null;
    }

}
