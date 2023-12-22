package org.ddd.domain.converter;

import org.ddd.domain.entity.Customer;
import org.ddd.domain.model.CustomerDto;

/**
 * 客户类型转换
 *
 * @author guang.yi
 * @since 2023/12/22
 */
public class CustomerConverter {

    public static Customer fromDto(CustomerDto customerDto) {
        return new Customer();
    }

}
