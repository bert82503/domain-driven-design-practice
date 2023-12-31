package org.ddd.bank.gateway.impl;

import org.springframework.stereotype.Component;

import org.ddd.bank.domain.entity.Customer;
import org.ddd.bank.gateway.CustomerGateway;

/**
 * 客户服务网关实现
 *
 * @author guang.yi
 * @since 2023/12/22
 */
@Component("customerGateway")
public class CustomerGatewayImpl implements CustomerGateway {

    @Override
    public boolean save(Customer customer) {
        // 使用
        if (customer.isBigClient()) {
            // do something
        }
        return true;
    }

}
