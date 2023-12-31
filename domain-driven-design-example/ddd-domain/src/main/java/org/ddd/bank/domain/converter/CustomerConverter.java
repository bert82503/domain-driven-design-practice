package org.ddd.bank.domain.converter;

import org.ddd.bank.domain.model.CustomerDto;
import org.ddd.bank.domain.entity.Customer;

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
