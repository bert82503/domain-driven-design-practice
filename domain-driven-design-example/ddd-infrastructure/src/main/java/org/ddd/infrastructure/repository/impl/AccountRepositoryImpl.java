package org.ddd.infrastructure.repository.impl;

import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.ddd.domain.entity.Account;
import org.ddd.domain.repository.AccountRepository;
import org.ddd.domain.value.object.AccountId;
import org.ddd.domain.value.object.AccountNumber;
import org.ddd.domain.value.object.UserId;
import org.ddd.infrastructure.dao.data.AccountDo;
import org.ddd.infrastructure.dao.mapper.AccountMapper;
import org.ddd.infrastructure.function.AccountBuilder;

/**
 * 账户储存接口实现
 * <p>
 * Repository的实现类完成数据库存储的细节
 *
 * @author guang.yi
 * @since 2023/12/27
 */
@Repository("accountRepository")
public class AccountRepositoryImpl implements AccountRepository {

    private final AccountMapper accountDao;
    private final AccountBuilder accountBuilder;

    public AccountRepositoryImpl(
            AccountMapper accountDao,
            AccountBuilder accountBuilder
    ) {
        this.accountDao = accountDao;
        this.accountBuilder = accountBuilder;
    }

    @Override
    public Account find(AccountId id) {
        AccountDo accountDo = accountDao.selectById(id.getId());
        return accountBuilder.toAccount(accountDo);
    }

    @Override
    public Account find(AccountNumber accountNumber) {
        Wrapper<AccountDo> queryWrapper = Wrappers.lambdaQuery(AccountDo.class)
                .select(AccountDo::getId, AccountDo::getAccountNumber, AccountDo::getUserId)
                .eq(AccountDo::getAccountNumber, accountNumber.getNumber())
//                .last("limit 1")
                ;
        AccountDo accountDo = accountDao.selectOne(queryWrapper);
        return accountBuilder.toAccount(accountDo);
    }

    @Override
    public Account find(UserId userId) {
        Wrapper<AccountDo> queryWrapper = Wrappers.lambdaQuery(AccountDo.class)
                .select(AccountDo::getId, AccountDo::getAccountNumber, AccountDo::getUserId)
                .eq(AccountDo::getUserId, userId.getUserId())
//                .last("limit 1")
                ;
        AccountDo accountDo = accountDao.selectOne(queryWrapper);
        return accountBuilder.toAccount(accountDo);
    }

    @Override
    public Account save(Account account) {
        AccountDo accountDo = accountBuilder.fromAccount(account);
        if (accountDo.getId() == null) {
            accountDao.insert(accountDo);
        } else {
            accountDao.updateById(accountDo);
        }
        return accountBuilder.toAccount(accountDo);
    }

}
