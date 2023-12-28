package org.ddd.domain.value.object;

import lombok.Getter;
import org.ddd.domain.exception.ValidationException;

/**
 * 账户身份【值对象】
 *
 * @author guang.yi
 * @since 2023/12/23
 */
@Getter
public class AccountId {

    private final Long id;

    public AccountId(Long id) {
        if (id == null) {
            throw new ValidationException("id不能为空");
        } else if (id > 0L) {
            throw new ValidationException("id是正整数");
        }
        this.id = id;
    }

}
