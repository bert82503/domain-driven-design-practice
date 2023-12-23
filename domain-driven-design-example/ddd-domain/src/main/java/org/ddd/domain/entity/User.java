package org.ddd.domain.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.ddd.domain.value.object.Address;
import org.ddd.domain.value.object.Name;
import org.ddd.domain.value.object.PhoneNumber;
import org.ddd.domain.value.object.RepId;
import org.ddd.domain.value.object.UserId;

/**
 * 用户【领域实体】
 *
 * @author guang.yi
 * @since 2023/12/22
 */
@Data
@Accessors(chain = true)
public class User {

    /**
     * 用户身份
     */
    private UserId userId;

    /**
     * 用户名称
     */
    private Name name;

    /**
     * 电话号
     */
    private PhoneNumber phone;

    /**
     * 地址
     */
    private Address address;

    /**
     * 业务员身份
     */
    private RepId repId;

}
