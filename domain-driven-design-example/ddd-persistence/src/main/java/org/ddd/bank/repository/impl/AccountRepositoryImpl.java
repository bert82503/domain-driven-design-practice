package org.ddd.bank.repository.impl;

import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.ddd.bank.domain.entity.Account;
import org.ddd.bank.domain.value.AccountId;
import org.ddd.bank.domain.value.AccountNumber;
import org.ddd.bank.domain.value.UserId;
import org.ddd.bank.repository.AccountRepository;
import org.ddd.bank.persistence.dao.data.AccountDO;
import org.ddd.bank.persistence.dao.mapper.AccountMapper;
import org.ddd.bank.persistence.function.AccountBuilder;

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
        AccountDO accountDo = accountDao.selectById(id.getId());
        return accountBuilder.toAccount(accountDo);
    }

    @Override
    public Account find(AccountNumber accountNumber) {
        Wrapper<AccountDO> queryWrapper = Wrappers.lambdaQuery(AccountDO.class)
                .select(AccountDO::getId, AccountDO::getAccountNumber, AccountDO::getUserId)
                .eq(AccountDO::getAccountNumber, accountNumber.getNumber())
//                .last("limit 1")
                ;
        AccountDO accountDo = accountDao.selectOne(queryWrapper);
        return accountBuilder.toAccount(accountDo);
    }

    @Override
    public Account find(UserId userId) {
        Wrapper<AccountDO> queryWrapper = Wrappers.lambdaQuery(AccountDO.class)
                .select(AccountDO::getId, AccountDO::getAccountNumber, AccountDO::getUserId)
                .eq(AccountDO::getUserId, userId.getUserId())
//                .last("limit 1")
                ;
        AccountDO accountDo = accountDao.selectOne(queryWrapper);
        return accountBuilder.toAccount(accountDo);
    }

    @Override
    public Account save(Account account) {
        AccountDO accountDo = accountBuilder.fromAccount(account);
        if (accountDo.getId() == null) {
            accountDao.insert(accountDo);
        } else {
            accountDao.updateById(accountDo);
        }
        return accountBuilder.toAccount(accountDo);
    }

}
