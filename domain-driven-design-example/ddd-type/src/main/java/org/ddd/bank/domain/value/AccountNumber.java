package org.ddd.bank.domain.value;

import lombok.Getter;
import org.ddd.bank.exception.ValidationException;

/**
 * 账号【值对象】
 *
 * @author guang.yi
 * @since 2023/12/23
 */
@Getter
public class AccountNumber {

    private final String number;

    public AccountNumber(String number) {
        if (number == null) {
            throw new ValidationException("number不能为空");
        } else if (isValid(number)) {
            throw new ValidationException("number格式错误");
        }
        this.number = number;
    }

    public static boolean isValid(String number) {
        String pattern = "^0?[1-9]{2,3}-?\\d{8}$";
        return number.matches(pattern);
    }

}
