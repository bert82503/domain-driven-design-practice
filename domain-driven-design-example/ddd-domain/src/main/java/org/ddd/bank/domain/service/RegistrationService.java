package org.ddd.bank.domain.service;

import javax.validation.constraints.NotNull;

import org.ddd.bank.domain.entity.User;
import org.ddd.bank.domain.value.Address;
import org.ddd.bank.domain.value.Name;
import org.ddd.bank.domain.value.PhoneNumber;

/**
 * 用户注册领域服务
 *
 * @author guang.yi
 * @since 2023/12/23
 */
public interface RegistrationService {

    /**
     * 注册用户
     *
     * @param name    用户姓名
     * @param phone   电话号
     * @param address 地址
     * @return 用户信息
     */
    User register(@NotNull Name name, @NotNull PhoneNumber phone, @NotNull Address address);

}
