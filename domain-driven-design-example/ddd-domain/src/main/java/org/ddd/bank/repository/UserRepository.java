package org.ddd.bank.repository;

import org.ddd.bank.domain.entity.User;

/**
 * 用户仓储
 *
 * @author guang.yi
 * @since 2023/12/23
 */
public interface UserRepository {

    /**
     * 保存用户
     *
     * @param user 用户信息
     * @return 用户
     */
    User saveUser(User user);

}
