package org.ddd.domain.repository;

import org.ddd.domain.entity.Account;
import org.ddd.domain.value.object.AccountId;
import org.ddd.domain.value.object.AccountNumber;
import org.ddd.domain.value.object.UserId;

/**
 * 账户储存接口
 * <p>
 * Repository只负责Entity对象的存储和读取
 *
 * @author guang.yi
 * @since 2023/12/27
 */
public interface AccountRepository {

    /**
     * 通过账户身份查找账户信息
     *
     * @param id 身份
     * @return 账户信息
     */
    Account find(AccountId id);

    /**
     * 通过账号查找账户信息
     *
     * @param accountNumber 账号
     * @return 账户信息
     */
    Account find(AccountNumber accountNumber);

    /**
     * 通过用户身份查找账户信息
     *
     * @param userId 用户身份
     * @return 账户信息
     */
    Account find(UserId userId);

    /**
     * 保存账户信息
     *
     * @param account 账户信息
     * @return 账户信息
     */
    Account save(Account account);

}
