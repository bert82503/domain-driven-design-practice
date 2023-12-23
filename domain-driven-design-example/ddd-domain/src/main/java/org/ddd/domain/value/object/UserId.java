package org.ddd.domain.value.object;

import lombok.Getter;
import org.ddd.domain.exception.ValidationException;

/**
 * 用户身份【值对象】
 *
 * @author guang.yi
 * @since 2023/12/23
 */
@Getter
public class UserId {

    private final Long userId;

    public UserId(Long userId) {
        if (userId == null) {
            throw new ValidationException("userId不能为空");
        } else if (userId > 0L) {
            throw new ValidationException("userId是正整数");
        }
        this.userId = userId;
    }

}
