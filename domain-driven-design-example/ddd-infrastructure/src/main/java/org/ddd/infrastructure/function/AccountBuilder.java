package org.ddd.infrastructure.function;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import org.ddd.domain.entity.Account;
import org.ddd.infrastructure.dao.data.AccountDo;

/**
 * 账户构建者
 *
 * @author guang.yi
 * @since 2023/12/27
 */
@Component("accountBuilder")
public class AccountBuilder {

    public Account toAccount(AccountDo accountDo) {
        // ToDo
        return null;
    }

    public AccountDo fromAccount(Account account) {
        // ToDo
        AccountDo accountDo = new AccountDo();
        // 创建时间
        LocalDateTime now = LocalDateTime.now();
        if (accountDo.getId() == null && accountDo.getCreateTime() == null) {
            accountDo.setCreateTime(now);
        }
        // 更新时间
        if (accountDo.getUpdateTime() == null) {
            accountDo.setUpdateTime(now);
        }
        return null;
    }

}
