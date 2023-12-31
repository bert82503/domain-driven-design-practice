package org.ddd.bank.domain.value;

import java.util.Arrays;

import lombok.Getter;
import org.ddd.bank.exception.ValidationException;

/**
 * 电话号【值对象】
 *
 * @author guang.yi
 * @since 2023/12/23
 */
@Getter
public class PhoneNumber {

    private final String number;

    public PhoneNumber(String number) {
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

    /**
     * <pre>
     * DP 的第一个原则：
     * Make Implicit Concepts Explicit
     * 将隐性的概念显性化
     * </pre>
     */
    public String getAreaCode() {
        for (int i = 0; i < number.length(); i++) {
            String prefix = number.substring(0, i);
            if (isAreaCode(prefix)) {
                return prefix;
            }
        }
        return null;
    }

    private static boolean isAreaCode(String prefix) {
        String[] areas = new String[]{"0571", "021", "010"};
        return Arrays.asList(areas).contains(prefix);
    }

}
