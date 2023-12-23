package org.ddd.domain.value.object;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.ddd.domain.exception.ValidationException;

/**
 * 地址【值对象】
 *
 * @author guang.yi
 * @since 2023/12/23
 */
@Getter
public class Address {

    private final String address;

    public Address(String address) {
        if (StringUtils.isBlank(address)) {
            throw new ValidationException("address不能为空");
        }
        this.address = address;
    }

}
