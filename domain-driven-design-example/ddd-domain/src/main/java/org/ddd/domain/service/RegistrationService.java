package org.ddd.domain.service;

import javax.validation.constraints.NotNull;

import org.ddd.domain.entity.User;
import org.ddd.domain.value.object.Address;
import org.ddd.domain.value.object.Name;
import org.ddd.domain.value.object.PhoneNumber;

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
