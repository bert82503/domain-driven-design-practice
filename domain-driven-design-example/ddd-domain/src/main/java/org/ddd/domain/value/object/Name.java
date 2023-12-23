package org.ddd.domain.value.object;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.ddd.domain.exception.ValidationException;

/**
 * 名称【值对象】
 *
 * @author guang.yi
 * @since 2023/12/23
 */
@Getter
public class Name {

    private final String name;

    public Name(String name) {
        if (StringUtils.isBlank(name)) {
            throw new ValidationException("name不能为空");
        }
        this.name = name;
    }

}
